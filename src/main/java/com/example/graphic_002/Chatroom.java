package com.example.graphic_002;

import Sample.Chats;
import Sample.Secret_Chat;
import Sample.User;
import javafx.event.ActionEvent;

//public class Chatroom {
//
//
//    public void handleUser1SubmitMessage(ActionEvent actionEvent) {
//    }
//
//    public void handleUser2SubmitMessage(ActionEvent actionEvent) {
//    }
//}

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
        import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.graphic_002.HelloApplication.*;

public class Chatroom implements Initializable {

    public ComboBox chatsAvailable;
    public Button chatSelected;
    public Button backButton;
    @FXML private ListView lvChatWindow;
    @FXML private TextField tfUser1, tfUser2;

    public static Secret_Chat mySecretChat;

    ObservableList<String> chatMessages = FXCollections.observableArrayList();//create observablelist for listview


    @FXML
    private void handleUser1SubmitMessage(ActionEvent event) {
        //chatMessages.add("User 1: " + tfUser1.getText());//get 1st user's text from his/her textfield and add message to observablelist
        chatMessages.add(myUser.username + " : " + tfUser1.getText());
        Chats chats = new Chats();
        chats.sender = myUser.username;
        chats.receiver =  mySecretChat.user2;
        if(mySecretChat.user2.equals(myUser.username)) chats.receiver = mySecretChat.user1;
        chats.text = new StringBuilder(tfUser1.getText().toString());
        mySecretChat.thisPVChats.add(chats);
        tfUser1.setText("");//clear 1st user's textfield
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lvChatWindow.setItems(chatMessages);//attach the observablelist to the listview

        User myuser = myUser;
        ArrayList<String> pvUsernames = new ArrayList<>();
        for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
            //System.out.println(all_secret_chat.user2);
            if(all_secret_chat.user1.equals(myuser.username) || all_secret_chat.user2.equals(myuser.username)) {
                if (!all_secret_chat.user1.equals(myuser.username))
                    pvUsernames.add(all_secret_chat.user1);
                else
                    pvUsernames.add(all_secret_chat.user2);
            }
        }
//        for (String pvUsername : pvUsernames) {
//            chatsAvailable.getItems().add(pvUsername);
//        }
        chatsAvailable.getItems().addAll(pvUsernames);
        chatSelected.setOnAction(e->{
            chatMessages.clear();
            Secret_Chat secret_chat = null;
            for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if( ( all_secret_chat.user2.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user1.equals(myuser.username) )
                        || (all_secret_chat.user1.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user2.equals(myuser.username) ) ){
                    for (Chats pvChat : all_secret_chat.thisPVChats) {
                        chatMessages.add(pvChat.sender + " : " + pvChat.text.toString() );
                    }
                    secret_chat = all_secret_chat;
                }
            }
            mySecretChat = secret_chat;


        });

        backButton.setOnAction(e ->{

            mainStage.setScene(scene0011saved);

        });



    }
}