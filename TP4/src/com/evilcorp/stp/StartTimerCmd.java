package com.evilcorp.stp;

public final class StartTimerCmd implements STPCommand {

    private int  timerId;

    public StartTimerCmd(int timerId){
        this.timerId=timerId;
    }

    public int getTimerId() {
        return timerId;
    }

    @Override
    public void accept(STPCommandVisitor commandVisitor) {
        commandVisitor.visit(this);
    }
}
