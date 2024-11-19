package com.evilcorp.stp;

public sealed interface STPCommand permits ElapsedTimeCmd, HelloCmd, StartTimerCmd, StopTimerCmd {
    void accept(STPCommandVisitor commandVisitor);
}
