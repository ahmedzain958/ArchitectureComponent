package com.zain.alarmmanagerstandup.architecturecomponent;

public class test {
    public static void main(String[] str) {

    }

    public int provideSoda(SodaMachine sodaMachine) {
        return sodaMachine.provideSoda(20);
    }
}


interface SodaMachine {
    int provideSoda(int money);
}

class sodaMachine1 implements SodaMachine {

    @Override
    public int provideSoda(int money) {
        return 0;
    }
}

class sodaMachine2 implements SodaMachine {

    @Override
    public int provideSoda(int money) {
        return 0;
    }
}

