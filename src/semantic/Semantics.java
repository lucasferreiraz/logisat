package semantic;

import java.util.List;

import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Or;

public class Semantics {
    
    public static And bigAnd(List<Formula> formulasList){
        Formula conjunction = formulasList.get(0);

        formulasList.remove(0);
        for(Formula formula : formulasList){
            conjunction = new And(conjunction, formula);
        }

        return (And) conjunction;
    }

    public static Or bigOr(List<Formula> formulasList){
        Formula disjunction = formulasList.get(0);

        formulasList.remove(0);
        for(Formula formula : formulasList){
            disjunction = new Or(disjunction, formula);
        }

        return (Or) disjunction;
    }

}
