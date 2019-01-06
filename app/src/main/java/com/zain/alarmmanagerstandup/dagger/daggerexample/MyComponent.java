package com.zain.alarmmanagerstandup.dagger.daggerexample;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = MyModule.class)
interface MyComponent {

    void inject(DaggerExampleActivity mainActivity);

}
