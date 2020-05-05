package factory;

import model.entity.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TxtGenerator implements Report {
    @Override
    public String generateReport(String filePath,List<String[]> data)  {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath, false));
            for(String[] string : data){
                String str = Arrays.toString(string);
                writer.write(str);
                writer.write("\n");
            }
            writer.close();
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
