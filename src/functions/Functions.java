package functions;

import java.util.HashSet;
import java.util.Set;

import abstractions.formulas.*;
import abstractions.operators.*;

public class Functions {

    private static Set<String> listAtoms = new HashSet<String>();
    
    //returns a set of atoms from a formula
    public static Set<String> atoms(Formula formula) {
        if (formula instanceof Atomic) {
            listAtoms.add(formula.toString());
        }
        if (formula instanceof Not) {
            Not negation = (Not) formula;
            atoms(negation.getInner());
        }
        if (formula instanceof Or){
            Or or = (Or) formula;
            atoms(or.getLeft());
            atoms(or.getRight());
        }
        if (formula instanceof And){
            And and = (And) formula;
            atoms(and.getLeft());
            atoms(and.getRight());
        }
        if (formula instanceof Implies){
            Implies implies = (Implies) formula;
            atoms(implies.getLeft());
            atoms(implies.getRight());
        }
        return listAtoms;
    }

}
