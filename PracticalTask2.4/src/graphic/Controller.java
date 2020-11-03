package graphic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    private TextArea historyTextArea;
    public TextField messageTextField;

    public void btnSendClickAction(ActionEvent actionEvent) {
        sendMessage();
    }

    public void msgTextFieldEnterAction(ActionEvent actionEvent) {
        sendMessage();
    }

    public void sendMessage() {

        String message = messageTextField.getText();
        if (message.length() == 0)
            return;


        historyTextArea.appendText(String.format("%s %s\n", message,
                new SimpleDateFormat("yyyy.MM.dd hh:mm").format(new Date())));
        messageTextField.clear();
    }

}
