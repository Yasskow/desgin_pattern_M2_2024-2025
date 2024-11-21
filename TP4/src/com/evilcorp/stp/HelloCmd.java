package com.evilcorp.stp;

public final class HelloCmd implements STPCommand {
    @Override
    public void accept(STPCommandVisitor commandVisitor) {
        commandVisitor.visit(this);
    }
}