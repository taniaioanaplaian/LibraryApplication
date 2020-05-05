package factory;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvGenerator implements Report {


    @Override
    public String generateReport(String filePath, List<String[]> data) {
        File file = new File(filePath);

        try {
            FileWriter outfile = new FileWriter(file, false);
            CSVWriter writer = new CSVWriter(outfile);
            writer.writeAll(data);
            writer.close();
            return "success";
        }
        catch (IOException e) {
              return "fail";
        }

    }
}
