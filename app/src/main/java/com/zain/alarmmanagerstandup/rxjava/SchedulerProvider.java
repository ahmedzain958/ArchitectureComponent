package com.zain.alarmmanagerstandup.rxjava;

import rx.Scheduler;

public interface SchedulerProvider {
    Scheduler ui();
    Scheduler computation();
    Scheduler io();
    Scheduler special();
}
