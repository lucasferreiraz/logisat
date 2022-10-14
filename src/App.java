import abstractions.formulas.Atomic;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import abstractions.operators.Or;
import functions.Functions;

public class App {
    public static void main(String[] args) throws Exception {
        Atomic p = new Atomic("p");
        Atomic q = new Atomic("q");
        Atomic r = new Atomic("r");
        
        Or o = new Or(p, q);
        And a = new And(p, r);
        Implies i = new Implies(o, a);
        Not n = new Not(i);
        System.out.println(n);
        System.out.println(Functions.atoms(n));

    }
}
