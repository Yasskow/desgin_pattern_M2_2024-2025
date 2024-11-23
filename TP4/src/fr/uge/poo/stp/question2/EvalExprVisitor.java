package fr.uge.poo.stp.question2;

import java.util.Objects;

public class EvalExprVisitor implements ExprVisitor<Integer>{

    @Override
    public Integer visitValue(Value value) {
        Objects.requireNonNull(value);
        return value.value();
    }

    @Override
    public Integer visitBinOp(BinOp binOp) {
        Objects.requireNonNull(binOp);
        return binOp.biFunction().applyAsInt(binOp.expr1().accept(this), binOp.expr2().accept(this));
    }

}
