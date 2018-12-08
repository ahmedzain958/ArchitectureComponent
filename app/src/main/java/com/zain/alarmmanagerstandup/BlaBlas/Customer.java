package com.zain.alarmmanagerstandup.BlaBlas;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
    private String mCustomerName;
    private ArrayList<Rental> mRentals = new ArrayList<>();

    public Customer(String customerName) {
        this.mCustomerName = customerName;
    }

    public void addRental(Rental rental) {
        mRentals.add(rental);
    }

    public String getCustomerName() {
        return mCustomerName;
    }

    public String generateRentalFeesStatement() {
        double totalOwedAmount = 0;
        int rewardPoints = 0;
        Iterator iterator = mRentals.iterator();
        StringBuilder resultStringBuilder = new StringBuilder("Rental Record for:").append(getCustomerName()).append("\n");
        while (iterator.hasNext()) {
            Rental rental = (Rental) iterator.next();
            // Setup fee, as decided by management in Dec 2016
            double owedAmount = 50.0;
            int vehicleCategoryCode = rental.getVehicle().getVehicleCategoryCode();
            int daysRented = rental.getDaysRented();
            int kilometersRented = rental.getKilometersRented();
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

    private double discountOwedAmount(double owedAmount, int vehicleCategoryCode, int kilometersRented, int daysRented) {
        if (kilometersRented >= 200) {
            if ((daysRented > 10 && vehicleCategoryCode == Vehicle.FOURxFOUR) || vehicleCategoryCode == Vehicle.SUV) {
                owedAmount -= owedAmount * 0.05;
            }
        }
        return owedAmount;
    }

    private int calculateRewardPoints(int rewardPoints, int daysRented, int vehicleCategoryCode) {
        rewardPoints++;
        // add bonus for FOURxFOUR rental
        if ((vehicleCategoryCode == Vehicle.FOURxFOUR)) rewardPoints *= 2;
        // add bonus for SUV rental and daysRented > 5 (incremental points for every extra day)
        if ((vehicleCategoryCode == Vehicle.SUV) && daysRented > 5)
            rewardPoints += (daysRented - 5);
        return rewardPoints;
    }

    private double getOwedAmountByCategoryCode(double owedAmount, int vehicleCategoryCode, int daysRented, int kilometersRented) {
        switch (vehicleCategoryCode) {
            case Vehicle.SEDAN:
                owedAmount += 100 * daysRented;
                if (kilometersRented > daysRented * 50) {
                    owedAmount += (kilometersRented - daysRented * 50) * 2;
                }
                break;
            case Vehicle.FOURxFOUR:
                owedAmount += 200 * daysRented;
                break;

            case Vehicle.SUV:
                owedAmount += 150 * daysRented;
                if (kilometersRented > daysRented * 70)
                    owedAmount += (kilometersRented - daysRented * 70) * 2;
                break;
            default:
                owedAmount += 0;
        }
        return owedAmount;
    }
}
