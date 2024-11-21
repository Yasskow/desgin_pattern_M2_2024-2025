package com.evilcorp.stphipster;

import com.evilcorp.stphipster.STPCommandVisitor;

public record HelloCmd() implements STPCommand {
    @Override
    public void accept(STPCommandVisitor commandVisitor) {
        System.out.println("Au revoir");
    }
}