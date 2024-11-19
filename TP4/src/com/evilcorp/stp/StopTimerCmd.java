package com.evilcorp.stp;

public final class StopTimerCmd implements STPCommand {

    private int  timerId;

    public StopTimerCmd(int timerId){
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
