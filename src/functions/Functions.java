package functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import abstractions.formulas.Atomic;
import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import abstractions.operators.Or;

public class Functions {

    private static Set<String> setAtoms = new HashSet<String>();

    //returns a list of atoms from a formula
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

    private static Stack<String> stackAtoms(List<String> listAtoms){
        Stack<String> stack = new Stack<String>();

        for(String atomic : listAtoms){
            stack.push(atomic);
        }

        return stack;
    }

    public static Boolean truthValue(Formula formula, HashMap<String, Boolean> interpretation){

        if (formula instanceof Atomic){
            return interpretation.get(formula.toString());
        }
        if (formula instanceof Not){
            Not not = (Not) formula;
            Boolean result = truthValue(not.getInner(), interpretation);
            return !result;
        }
        if (formula instanceof Implies){
            Implies implies = (Implies) formula;
            Boolean left = truthValue(implies.getLeft(), interpretation);
            Boolean right = truthValue(implies.getRight(), interpretation);

            return ((left && !right) ? false : true);
        }
        if (formula instanceof Or){
            Or or = (Or) formula;
            Boolean left = truthValue(or.getLeft(), interpretation);
            Boolean right = truthValue(or.getRight(), interpretation);

            return ((left || right) ? true : false);
        }
        if (formula instanceof And){
            And and = (And) formula;
            Boolean left = truthValue(and.getLeft(), interpretation);
            Boolean right = truthValue(and.getRight(), interpretation);

            return ((left && right) ? true : false);
        }

        return null;
    }

}