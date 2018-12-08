package com.zain.alarmmanagerstandup.BlaBlas;

public class Getting {

    public float convertFehrnToCel(float fa) {
        float result = ((fa - 32) * 5 / 9);
        return result;
    }

    public float convertCelToFahr(float C) {
        float result = ((C * 9) / 5) + 32;
        return result+6;
    }

}
