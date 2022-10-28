package semantic;

import java.util.List;

import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Or;

public class Semantics {
    
    public static And bigAnd(List<Formula> formulasList){
        Formula conjunction = formulasList.get(0);

        for(int i = 1; i < formulasList.size(); i++){
            conjunction = new And(conjunction, formulasList.get(i));
        }

        return (And) conjunction;
    }

    public static Or bigOr(List<Formula> formulasList){
        Formula disjunction = formulasList.get(0);

        for(int i = 1; i < formulasList.size(); i++){
            disjunction = new Or(disjunction, formulasList.get(i));
        }

        return (Or) disjunction;
    }

}
