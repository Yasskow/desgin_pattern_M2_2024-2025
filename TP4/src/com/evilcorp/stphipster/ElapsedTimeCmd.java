package com.evilcorp.stphipster;

import java.util.List;
import java.util.Objects;

public record ElapsedTimeCmd(List<Integer> timers) implements STPCommand{
    public ElapsedTimeCmd {
        Objects.requireNonNull(timers);
    }

    public List<Integer> getTimers() {
        return List.copyOf(timers);
    }
}
