package factory;

import java.io.IOException;
import java.util.List;

public interface Report {

     String generateReport(String filePath, List<String[]> data) throws IOException;


}
