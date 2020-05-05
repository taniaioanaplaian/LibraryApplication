package utils;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String[]> convertData(List<? extends Object> data){
        List<String[]> list = new ArrayList<>();
        for(Object o : data){
            String[] toAdd = o.toString().split(",");
            list.add(toAdd);
        }
        return list;
    }

    public static String getEncryptedPassword(String password){
        return  DigestUtils.sha256Hex(password);
    }

    public static void displayMessage(Label messageLabel, String messageText, String color) {

        messageLabel.setText(messageText);
        messageLabel.setVisible(true);
        messageLabel.setOpacity(1);
        messageLabel.setWrapText(true);
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(color.equals("RED"))
                    messageLabel.setTextFill(Color.web("#FF0000"));
                else if(color.equals("GREEN")){
                    messageLabel.setTextFill(Color.web("#009933"));
                }
                messageLabel.setText(messageText);
                messageLabel.setVisible(true);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    messageLabel.setVisible(false);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
