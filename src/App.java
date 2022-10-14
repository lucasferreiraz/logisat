import abstractions.formulas.Atomic;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import abstractions.operators.Or;

public class App {
    public static void main(String[] args) throws Exception {
        Atomic p = new Atomic("p");
        Atomic q = new Atomic("q");
        
        Or o = new Or(p, q);
        And a = new And(p, q);
        Implies i = new Implies(o, a);
        Not n = new Not(i);
        System.out.println(n);
    }
}
