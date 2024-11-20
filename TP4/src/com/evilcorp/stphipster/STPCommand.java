package com.evilcorp.stphipster;

import com.evilcorp.stphipster.*;

public sealed interface STPCommand permits HelloCmd{
    void accept(STPCommandVisitor commandVisitor);
}