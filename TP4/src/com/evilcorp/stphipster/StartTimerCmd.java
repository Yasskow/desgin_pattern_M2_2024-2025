package com.evilcorp.stphipster;

import com.evilcorp.stphipster.STPCommand;
import com.evilcorp.stphipster.STPCommandVisitor;

public record StartTimerCmd(int timerId) implements STPCommand {
    public int getTimerId(){
        return timerId;
    }

    @Override
    public void accept(STPCommandVisitor commandVisitor) {
        commandVisitor.visit(this);
    }
}
