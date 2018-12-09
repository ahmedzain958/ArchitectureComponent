package com.zain.alarmmanagerstandup.BlaBlas;

// What if the types of vehicles increased ?
//strategy pattern applied due to different vehicle types owed amount calculations ;
public interface OwedAmount {
    double getOwedAmount(double owedAmount, int daysRented, int kilometersRented);
}

class OwedAmountContext {
    private OwedAmount owedAmount;

    public OwedAmountContext(OwedAmount owedAmount) {
        this.owedAmount = owedAmount;
    }

    public double getOwedAmount(double owedAmount, int daysRented, int kilometersRented) {
        return this.owedAmount.getOwedAmount(owedAmount, daysRented, kilometersRented);
    }
}

class SedanOwedAmount implements OwedAmount {
    @Override
    public double getOwedAmount(double owedAmount, int daysRented, int kilometersRented) {
        owedAmount += 100 * daysRented;
        if (kilometersRented > daysRented * 50) {
            owedAmount += (kilometersRented - daysRented * 50) * 2;
        }
        return owedAmount;
    }
}

class FourXFourROwedAmount implements OwedAmount {
    @Override
    public double getOwedAmount(double owedAmount, int daysRented, int kilometersRented) {
        owedAmount += 200 * daysRented;
        return owedAmount;
    }
}

class SuvOwedAmount implements OwedAmount {
    @Override
    public double getOwedAmount(double owedAmount, int daysRented, int kilometersRented) {
        owedAmount += 150 * daysRented;
        if (kilometersRented > daysRented * 70)
            owedAmount += (kilometersRented - daysRented * 70) * 2;
        return owedAmount;
    }
}