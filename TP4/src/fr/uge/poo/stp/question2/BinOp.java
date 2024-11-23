package fr.uge.poo.stp.question2;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

public record BinOp(Expr expr1, Expr expr2, String op, IntBinaryOperator biFunction) implements Expr{
    public BinOp{
        Objects.requireNonNull(expr1);
        Objects.requireNonNull(expr2);
        Objects.requireNonNull(op);
        Objects.requireNonNull(biFunction);
    }
//    @Override
//    public int eval() {
//        return biFunction.applyAsInt(expr1.eval(), expr2.eval());
//    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visitBinOp(this);
    }

//    @Override
//    public String toString() {
//        return "(" + expr1.toString() + " " + op + " " + expr2.toString() + ")";
//    }
}
