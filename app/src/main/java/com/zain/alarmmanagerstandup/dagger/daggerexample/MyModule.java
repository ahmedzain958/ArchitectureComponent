package com.zain.alarmmanagerstandup.dagger.daggerexample;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class MyModule {

    @Provides
    @Singleton
    static MyExample provideMyExample() {
        return new MyExampleImpl();
    }
}
