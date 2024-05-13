package org.chatapp.client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public VBox vbox_message;
    @FXML
    public Button button_send;
    @FXML
    public TextField tf_message;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addReceivedMessage("John Doe","Hello Word");
        addReceivedMessage("John Doe","Hello Word");
        addReceivedMessage("John Doe","Hello Word");

        vbox_message.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newValue) {
                scrollPane.setVvalue((Double) newValue);
            }
        });

        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String messageToSend = tf_message.getText();

                if (!messageToSend.isEmpty()) {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);

                    hBox.setPadding(new Insets(5,5,5,10));
                    Text text = new Text(messageToSend);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(239, 242, 255);" + "-fx-background-color: rgb(15,125,242);" + "-fx-background-radius: 20px");
                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(0.934,0.945,0.996));

                    hBox.getChildren().add(textFlow);
                    vbox_message.getChildren().add(hBox);

                    tf_message.clear();
                }
            }
        });
    }

    private void addReceivedMessage(String sender, String message) {

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));

        ImageView imageView = new ImageView(new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/org/chatapp/client/images/icons8-utilisateur-50.png")
                )
        ));
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);

        Text senderText = new Text(sender + ": \n");
        senderText.setStyle("-fx-font-weight: bold;");

        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(senderText,text);
        textFlow.setStyle("-fx-background-color: rgb(233, 233, 235);-fx-background-radius: 15px");
        textFlow.setPadding(new Insets(5,10,5,10));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView, textFlow);

        hBox.getChildren().add(vBox);
        vbox_message.getChildren().add(hBox);

    }
}