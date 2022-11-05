package restrictions;

import java.util.ArrayList;
import java.util.List;

import abstractions.formulas.Atomic;
import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import semantic.Semantics;

public class Restrictions {

    public static And restrictionOne(Integer m, List<String> attributes){
        List<Formula> listOne = new ArrayList<>();
        List<Formula> listTwo = new ArrayList<>();
        List<Formula> listThree = new ArrayList<>();

        for (int rule = 1; rule <= m ; rule++) {
            for (String attribute : attributes) {
                if(!attribute.equals("P")){
                    listOne.add(new Atomic(attribute + "_" + rule + "_" + "gt"));
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "le")));
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "s")));
                    listTwo.add(Semantics.bigAnd(listOne));
                    listOne.clear();

                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "gt")));
                    listOne.add(new Atomic(attribute + "_" + rule + "_" + "le"));
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "s")));
                    listTwo.add(Semantics.bigAnd(listOne));
                    listOne.clear();

                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "gt")));
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "le")));
                    listOne.add(new Atomic(attribute + "_" + rule + "_" + "s"));
                    listTwo.add(Semantics.bigAnd(listOne));
                    listOne.clear();

                    listThree.add(Semantics.bigOr(listTwo));
                    listTwo.clear();
                }
            }
        }

        return Semantics.bigAnd(listThree);

    }

    public static And restrictionTwo(Integer m, List<String> attributes){
        List<Formula> listOne = new ArrayList<>();
        List<Formula> listTwo = new ArrayList<>();

        for (int rule = 1; rule <= m ; rule++){
            for (String attribute : attributes){
                if(!attribute.equals("P")){
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "s")));
                }
            }
            listTwo.add(Semantics.bigOr(listOne));
            listOne.clear();
        }

        return Semantics.bigAnd(listTwo);
    }

    public static And restrictionFour(Integer m, List<String> attributes, List<List<String>> values){
        List<Formula> listOne = new ArrayList<>();

        int pacientes = 3;

        for (int rule = 1; rule <= m ; rule++){
            for (String attribute : attributes){
                if(!attribute.equals("P")){
                   if(values.get(rule).indexOf(attribute).equals("P")){
                    listOne.add(new Implies(new Atomic(attribute + rule + "gt"), new Not(null)));
                   }
                }
            }
        }
    }

}
