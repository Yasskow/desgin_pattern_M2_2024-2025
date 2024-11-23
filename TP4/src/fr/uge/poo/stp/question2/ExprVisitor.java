package fr.uge.poo.stp.question2;

public interface ExprVisitor<T> {
    T visitValue(Value value);
    T visitBinOp(BinOp binOp);
}
