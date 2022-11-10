package restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import functions.Functions;

public class AuxiliarBuilders {
    
    public List<String> rulesSet(Integer m, List<String> attributes, HashMap<String, Boolean> interpretation){
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        HashMap<String, Boolean> interpretationCopy = Functions.copy(interpretation);

        for(int rule = 1; rule <= m; rule++){
            for(String attribute : attributes){
                if(!attribute.equals("P")){
                    if(!interpretationCopy.get(attribute + "_" + rule + "_" + "s")){
                        if(interpretationCopy.get(attribute + "_" + rule + "_" + "gt")){
                            String attributeModified = attribute.replaceFirst("<=", ">");
                            listOne.add(attributeModified);
                        } else {
                            listOne.add(attribute);
                        }
                    }
                }
            }
            listTwo.add(listOne + " \u21D2 P");
            listOne.clear();
        }

        return listTwo;
    }

    public List<String> checkPatology(Integer m, Integer p, List<String> attributes, List<List<String>> values, HashMap<String, Boolean> interpretation){
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        HashMap<String, Boolean> interpretationCopy = Functions.copy(interpretation);

        return sickList(m, p, attributes, values, interpretationCopy, listOne, listTwo);

    }

}
