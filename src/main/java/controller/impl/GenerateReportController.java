package controller.impl;

import factory.Report;
import factory.ReportFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import service.api.BookService;
import utils.Utils;
import view.ReportView;

import java.io.IOException;

public class GenerateReportController {


    private final int height;
    private final int width;
    private final BookService bookService;
    private final ReportView reportView;


    public GenerateReportController(ReportView reportView, BookService data, int width, int height){
        this.bookService = data;
        this.width = width;
        this.height = height;
        this.reportView = reportView;
    }


    public void initialize(){
        initLayout();
        initAction();
    }

    private void initAction() {
        reportView.getGenerateButton2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Report report;
                String type = reportView.getReportType2().getValue();
                report = ReportFactory.generateReport(type);

                switch (type){
                    case "CSV":
                        String result = "fail";
                        try {
                            result = report.generateReport("src/main/java/reports/csvFile.csv", Utils.convertData(bookService.searchOutOfStock()));

                            Utils.displayMessage(reportView.getMessageLabel2(), result, "GREEN");
                        } catch (IOException e) {
                            Utils.displayMessage(reportView.getMessageLabel2(), result, "RED");
                        }
                        break;
                    case "TXT":
                        String result2 = "fail";
                        try {
                            result2 = report.generateReport("src/main/java/reports/txtFile.txt", Utils.convertData(bookService.searchOutOfStock()));
                            Utils.displayMessage(reportView.getMessageLabel2(), result2, "GREEN");
                        } catch (IOException e) {
                            Utils.displayMessage(reportView.getMessageLabel2(), result2, "RED");
                        }
                        break;
                }

            }
        });
    }

    private void initLayout() {
        reportView.getAnchorPane2().setPrefWidth(width);
        reportView.getAnchorPane2().setPrefHeight(height);

        reportView.getReportType2().setItems(FXCollections.observableArrayList(
                "CSV", "TXT"));

        reportView.getReportType2().setValue("CSV");
    }


}
