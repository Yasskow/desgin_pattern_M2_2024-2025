package fr.uge.poo.stp.question2;

public record Value(int value) implements Expr{

//    @Override
//    public int eval() {
//        return value;
//    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visitValue(this);
    }

//    @Override
//    public String toString() {
//        return String.valueOf(value);
//    }
}
