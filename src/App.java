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
        
        Or o = new Or(p, q);
        Implies i = new Implies(o, r);
        Not n = new Not(i);
        //System.out.println(n.toString());
        //System.out.println(Functions.atoms(n));

        HashMap<String, Boolean> interpretation = new HashMap<>();
        interpretation.put("p", false);
        interpretation.put("q", false);
        interpretation.put("r", true);
        interpretation.put("s", true);

        System.out.println(Functions.truthValue(n, interpretation));
        

    }
}
