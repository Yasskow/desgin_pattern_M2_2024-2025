package com.evilcorp.stp;

import java.util.Objects;

public class CommandTreatmentVisitor implements STPCommandVisitor{

    @Override
    public void visit(HelloCmd helloCmd) {
        Objects.requireNonNull(helloCmd);
        System.out.println("Au Revoir");
    }

    @Override
    public void visit(StartTimerCmd startTimerCmd) {
        System.out.println("Pas implementé");
    }

    @Override
    public void visit(StopTimerCmd stopTimerCmd) {
        System.out.println("Pas implementé");
    }

    @Override
    public void visit(ElapsedTimeCmd elapsedTimeCmd) {
        System.out.println("Pas implementé");
    }
}
