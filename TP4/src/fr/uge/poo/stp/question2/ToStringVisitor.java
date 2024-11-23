package fr.uge.poo.stp.question2;

public class ToStringVisitor implements ExprVisitor<String> {

    @Override
    public String visitValue(Value value) {
        return String.valueOf(value.value());
    }

    @Override
    public String visitBinOp(BinOp binOp) {
        return "(" + binOp.expr1().accept(this) + " " + binOp.op() + " " + binOp.expr2().accept(this) + ")";
    }
}
