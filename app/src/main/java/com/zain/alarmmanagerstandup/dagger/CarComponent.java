package com.zain.alarmmanagerstandup.dagger;

import dagger.Component;

@Component
public interface CarComponent {
    void inject(DaggerActivity daggerActivity);

    //to be used in another activity
    //void injectInActivity2(DaggerActivity2 daggerActivity2);
}
