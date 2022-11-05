import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> attributes = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();
        readData(attributes, values);

        Integer patients = values.size();

        System.out.println(attributes);
        for(int i = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }

    }

    public static void readData(List<String> attributes, List<List<String>> values){

        String absolutePath = new File("").getAbsolutePath();
        String relativePath = "/src/data/column_bin_5a_3p.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath + relativePath))) {
            
            //points to the first line of the file
            String line = br.readLine();
            for(String s : line.split(",")){
                attributes.add(s);
            }

            //points to the second line of the file
            line = br.readLine();

            while(line != null){
                List<String> tmp = Arrays.asList(line.split(","));
                values.add(tmp);
                
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}   
