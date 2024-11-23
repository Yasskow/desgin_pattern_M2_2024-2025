package com.evilcorp.stphipster;

public interface STPCommandVisitor {
    void visit(HelloCmd helloCmd);
    void visit(StartTimerCmd startTimerCmd);
    void visit(StopTimerCmd stopTimerCmd);
    void visit(ElapsedTimeCmd elapsedTimeCmd);
    default void visit(STPCommand stpCommand){
        switch (stpCommand){
            case HelloCmd helloCmd -> visit(helloCmd);
            case StartTimerCmd startTimerCmd -> visit(startTimerCmd);
            case StopTimerCmd stopTimerCmd -> visit(stopTimerCmd);
            case ElapsedTimeCmd elapsedTimeCmd -> visit(elapsedTimeCmd);
        }
    }
}
