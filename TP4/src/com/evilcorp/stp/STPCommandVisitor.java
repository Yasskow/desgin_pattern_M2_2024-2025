package com.evilcorp.stp;

import com.evilcorp.stphipster.*;

public interface STPCommandVisitor {
    void visit(HelloCmd helloCmd);
    void visit(StartTimerCmd startTimerCmd);
    void visit(StopTimerCmd stopTimerCmd);
    void visit(ElapsedTimeCmd elapsedTimeCmd);
}
