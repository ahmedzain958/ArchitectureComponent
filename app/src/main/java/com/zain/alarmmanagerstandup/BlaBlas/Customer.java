package com.zain.alarmmanagerstandup.BlaBlas;

import java.util.ArrayList;
import java.util.Iterator;

class Customer {
    private String mCustomerName;
    private ArrayList<Rental> mRentals = new ArrayList<>();

    Customer(String customerName) {
        this.mCustomerName = customerName;
    }

    void addRental(Rental rental) {
        mRentals.add(rental);
    }

    private String getCustomerName() {
        return mCustomerName;
    }

    String generateRentalFeesStatement() {
        double totalOwedAmount = 0;
        int rewardPoints = 0;
        Iterator iterator = mRentals.iterator();
        StringBuilder resultStringBuilder = new StringBuilder("Rental Record for:").append(getCustomerName()).append("\n");
        while (iterator.hasNext()) {
            Rental rental = (Rental) iterator.next();
            int vehicleCategoryCode = rental.getVehicle().getVehicleCategoryCode();
            int daysRented = rental.getDaysRented();
            int kilometersRented = rental.getKilometersRented();
            // Setup fee, as decided by management in Dec 2016
            double owedAmount = 50.0;
            owedAmount = getOwedAmountByCategoryCode(owedAmount, vehicleCategoryCode, daysRented, kilometersRented);
            //discount for renting 4x4 with days rented > 10 days and SUV with 200 or more kms rented
            owedAmount = discountOwedAmount(owedAmount, vehicleCategoryCode, kilometersRented, daysRented);
            if (!rental.isLate()) {
                rewardPoints = calculateRewardPoints(rewardPoints, daysRented, vehicleCategoryCode);
            } else {
                // deduction on late in delivery time 0.03 of the calculated owed amount
                owedAmount += owedAmount * 0.03;
            }
            // show figures for this rental
            resultStringBuilder.append("\t\"").append(rental.getVehicle().getMakeAndModel()).append("\"\tLE ")
                    .append(String.valueOf(owedAmount)).append("\n");
            totalOwedAmount += owedAmount;
        }

        // add footer lines
        resultStringBuilder.append("Amount owed is LE ").append(String.valueOf(totalOwedAmount))
                .append("\n").append("You earned: ").append(String.valueOf(rewardPoints)).append(" new Reward Points\n\n");
        return resultStringBuilder.toString();
    }

    String generateRentalFeesStatementJson() {
        //json header with array of customers and their array of rentals
        StringBuilder jsonStatement = new StringBuilder("{\n")
                .append("  \"customers\": [\n")
                .append("    {\n")
                .append("      \"customer\": ").append("\"").append(getCustomerName()).append("\",\n")
                .append("      \"rentals\": [\n");
        double totalOwedAmount = 0;
        int rewardPoints = 0;
        int i = 0;
        for (Rental rental : mRentals) {
            int vehicleCategoryCode = rental.getVehicle().getVehicleCategoryCode();
            int daysRented = rental.getDaysRented();
            int kilometersRented = rental.getKilometersRented();
            // Setup fee, as decided by management in Dec 2016
            double owedAmount = 50.0;
            owedAmount = getOwedAmountByCategoryCode(owedAmount, vehicleCategoryCode, daysRented, kilometersRented);
            //discount for renting 4x4 with days rented > 10 days and SUV with 200 or more kms rented
            owedAmount = discountOwedAmount(owedAmount, vehicleCategoryCode, kilometersRented, daysRented);
            if (!rental.isLate()) {
                rewardPoints = calculateRewardPoints(rewardPoints, daysRented, vehicleCategoryCode);
            } else {
                // deduction on late in delivery time 0.03 of the calculated owed amount
                owedAmount += owedAmount * 0.03;
            }
            totalOwedAmount += owedAmount;
            //to prevent adding ',' to the last object
            ++i;
            jsonStatement.append("        {\n").append(
                    "          \"make_and_model\": \"").append(rental.getVehicle().getMakeAndModel()).append("\",\n")
                    .append("          \"cost\": ").append(owedAmount).append("\n")
                    .append("        }").append((i == mRentals.size() ? "\n" : ",\n"));
        }
        jsonStatement.append("      ],\n").append("      \"owedAmount\": ").append(totalOwedAmount).append(",\n").append("      \"rewards\": ").append(rewardPoints + "\n").append(
                "    }\n").append("  ]\n").append(
                "}");

        return jsonStatement.toString();

    }

    private double discountOwedAmount(double owedAmount, int vehicleCategoryCode, int kilometersRented, int daysRented) {
        if (kilometersRented >= 200) {
            if ((daysRented > 10 && vehicleCategoryCode == VehicleCategoryCodeEnum.FOURxFOUR.getValue()) || vehicleCategoryCode == VehicleCategoryCodeEnum.SUV.getValue()) {
                owedAmount -= owedAmount * 0.05;
            }
        }
        return owedAmount;
    }

    private int calculateRewardPoints(int rewardPoints, int daysRented, int vehicleCategoryCode) {
        rewardPoints++;
        // add bonus for FOURxFOUR rental
        if ((vehicleCategoryCode == VehicleCategoryCodeEnum.FOURxFOUR.getValue())) rewardPoints *= 2;
        // add bonus for SUV rental and daysRented > 5 (incremental points for every extra day)
        if ((vehicleCategoryCode == VehicleCategoryCodeEnum.SUV.getValue()) && daysRented > 5)
            rewardPoints += (daysRented - 5);
        return rewardPoints;
    }

    private double getOwedAmountByCategoryCode(double owedAmount, int vehicleCategoryCode, int daysRented, int kilometersRented) {
        OwedAmountContext owedAmountContext;
        if (vehicleCategoryCode == VehicleCategoryCodeEnum.SEDAN.getValue()) {
            owedAmountContext = new OwedAmountContext(new SedanOwedAmount());
            owedAmount = owedAmountContext.getOwedAmount(owedAmount, daysRented, kilometersRented);
        } else if (vehicleCategoryCode == VehicleCategoryCodeEnum.FOURxFOUR.getValue()) {
            owedAmountContext = new OwedAmountContext(new FourXFourROwedAmount());
            owedAmount = owedAmountContext.getOwedAmount(owedAmount, daysRented, kilometersRented);
        } else if (vehicleCategoryCode == VehicleCategoryCodeEnum.SUV.getValue()) {
            owedAmountContext = new OwedAmountContext(new SuvOwedAmount());
            owedAmount = owedAmountContext.getOwedAmount(owedAmount, daysRented, kilometersRented);
        }
        return owedAmount;
    }
}
