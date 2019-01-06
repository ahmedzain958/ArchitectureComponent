package com.zain.alarmmanagerstandup.dagger.daggerexample;

import java.util.Date;

class MyExampleImpl implements MyExample {

    private long mDate;

    MyExampleImpl() {
        mDate = new Date().getTime();
    }

    public long getDate() {
        return mDate;
    }

}
