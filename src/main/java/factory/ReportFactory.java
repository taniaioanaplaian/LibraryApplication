package factory;

public class ReportFactory {

    public static Report generateReport(String reportType){
        if(reportType == null){
            return null;
        }
        if(reportType.equalsIgnoreCase("csv")){
            return new CsvGenerator();

        } else if(reportType.equalsIgnoreCase("txt")){
            return new TxtGenerator();

        }
        return null;

    }
}
