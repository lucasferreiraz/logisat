package semantic;

import java.util.List;

import abstractions.formulas.Formula;
import abstractions.operators.And;

public class Semantics {
    
    public static And bigAnd(List<Formula> formulasList){
        Formula conjunction = formulasList.get(0);

        formulasList.remove(0);
        for(Formula formula : formulasList){
            conjunction = new And(conjunction, formula);
        }

        return (And) conjunction;
    }

}
