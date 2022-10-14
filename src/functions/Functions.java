package functions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import abstractions.formulas.Atomic;
import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import abstractions.operators.Or;

public class Functions {

    private static Set<String> setAtoms = new HashSet<String>();
    
    //returns a set of atoms from a formula
    public static List<String> atoms(Formula formula) {
        if (formula instanceof Atomic) {
            setAtoms.add(formula.toString());
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

        List<String> listAtoms = setAtoms.stream()
                                         .collect(Collectors.toList());

        return listAtoms;
    }

}
