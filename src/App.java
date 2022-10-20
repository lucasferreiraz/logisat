import java.util.HashMap;

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
        Atomic s = new Atomic("s");
        
        Not n = new Not(p);
        Implies i = new Implies(p, q);
        Or o = new Or(p, q);
        And a = new And(o, i);
        And b = new And(a, n);

        System.out.println(b.toString());
        //System.out.println(Functions.atoms(n));

        
        HashMap<String, Boolean> interpretation = new HashMap<>();
        interpretation.put("p", false);
        interpretation.put("q", false);
        interpretation.put("r", true);
        interpretation.put("s", true);

        //System.out.println(interpretation);

        //System.out.println(Functions.truthValue(n, interpretation));
        
        System.out.println(Functions.satisfabilityBruteForce(b));
    }
}
