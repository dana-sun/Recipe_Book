import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Data_Retriever{
    String user_name; 
    String password;
    String database_path;
    Hashtable<String, String[]> file_data = new Hashtable<String, String[]>();
    private int RECIPE_NAME_INDEX = 0;
    private int DESCRIPTION_INDEX = 1;
    private int INGREDIENTS_INDEX = 2;
    private int INSTRUCTIONS_INDEX = 3;


    public Data_Retriever(String user_name, String password, String database_path){
        this.user_name = user_name;
        this.password = password;
        this.database_path = database_path;
    }


    public void read_csv(){
        try{
            String line = "";
            String split_by = ",";
            BufferedReader csvReader = new BufferedReader(new FileReader(this.database_path));
            while((line = csvReader.readLine()) != null){
                String[] row = line.split(split_by);
                this.file_data.put(row[0], row);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public Object get_ingredients(String name){
        return this.file_data.get(name)[INGREDIENTS_INDEX];
    }


    public Object get_description(String name){
        return this.file_data.get(name)[DESCRIPTION_INDEX];
    }


    public Object get_instructions(String name){
        return this.file_data.get(name)[INSTRUCTIONS_INDEX];
    }


}