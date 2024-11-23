package fr.uge.poo.stp.question2;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        var iterator = Pattern.compile(" ").splitAsStream("+ * 4 + 1 1 + 2 3").iterator();
        var expr = Expr.parseExpr(iterator);
//        System.out.println(expr);
//        System.out.println(expr.eval());
        var eev = new EvalExprVisitor();
        var sev = new ToStringVisitor();
        System.out.println(expr.accept(sev));
        System.out.println(expr.accept(eev));
    }
}
