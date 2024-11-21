package com.evilcorp.stphipster;

import com.evilcorp.stp.ElapsedTimeCmd;
import com.evilcorp.stp.HelloCmd;
import com.evilcorp.stp.StartTimerCmd;
import com.evilcorp.stp.StopTimerCmd;

public interface STPCommandVisitor {
    void visit(HelloCmd helloCmd);
    void visit(StartTimerCmd startTimerCmd);
    void visit(StopTimerCmd stopTimerCmd);
    void visit(ElapsedTimeCmd elapsedTimeCmd);

    void visit(com.evilcorp.stphipster.HelloCmd helloCmd);

    void visit(com.evilcorp.stphipster.StartTimerCmd startTimerCmd);

    void visit(StopTimerCmd stopTimerCmd);

    void visit(com.evilcorp.stphipster.ElapsedTimeCmd elapsedTimeCmd);
}
