package com.evilcorp.stphipster;

public record StopTimerCmd(int timerId) implements STPCommand{
    public int getTimerId(){
        return timerId;
    }
}
