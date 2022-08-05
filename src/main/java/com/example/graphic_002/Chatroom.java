package com.example.graphic_002;

import Sample.*;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import static com.example.graphic_002.HelloApplication.*;

public class Chatroom implements Initializable {

    public ComboBox chatsAvailable;
    public Button chatSelected;
    public Button backButton;
    public ComboBox groupChatsAvailabe;
    public CheckBox groupOnly;
    public Button createPvChat;
    public TextField searchBar;
    public Label createPvStats;
    public Label chatDetails;
    public Button createGroup;
    public Button addNewMember;
    public ImageView profile;

    public AnchorPane theme;
    @FXML private ListView lvChatWindow;
    @FXML private TextField tfUser1, tfUser2;

    public static Secret_Chat mySecretChat;
    public static Group myGroup;
    public static ComboBox chatsAvail;
    public final static int width = 90;

    ObservableList<String> chatMessages = FXCollections.observableArrayList();//create observablelist for listview


    @FXML
    private void handleUser1SubmitMessage(ActionEvent event) {
        //chatMessages.add("User 1: " + tfUser1.getText());//get 1st user's text from his/her textfield and add message to observablelist


        if(myGroup ==null) {
            //chatMessages.add(myUser.username + " : " + tfUser1.getText());
//            String s = myUser.username + " : " + tfUser1.getText();
            String s = tfUser1.getText() + " : " + myUser.username;
            StringBuilder text = new StringBuilder("");
            for (int i = 0; i < width - s.length(); i++) {
                text.append(" ");
            }
            text.append(s);
//            chatMessages.add("                      " + myUser.username + " : " + tfUser1.getText());
            chatMessages.add(text.toString());
            Chats chats = new Chats();
            chats.sender = myUser.username;
            if(mySecretChat.user2 != null) chats.receiver = mySecretChat.user2;
            if (mySecretChat.user2.equals(myUser.username)) chats.receiver = mySecretChat.user1;
            chats.text = new StringBuilder(tfUser1.getText().toString());
            mySecretChat.thisPVChats.add(chats);

        }
        else {
            //chatMessages.add(myUser.username + " : " + tfUser1.getText());
            //String s = myUser.username + " : " + tfUser1.getText();
            String s = tfUser1.getText() + " : " + myUser.username;
            StringBuilder text = new StringBuilder("");
            for (int i = 0; i < width - s.length(); i++) {
                text.append(" ");
            }
            text.append(s);
//            chatMessages.add("                      " + myUser.username + " : " + tfUser1.getText());
            chatMessages.add(text.toString());
            Chats chats = new Chats();
            chats.sender = myUser.username;
            chats.text = new StringBuilder(tfUser1.getText().toString());
            myGroup.groupChats.add(chats);

        }

        tfUser1.setText("");//clear 1st user's textfield
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleSwitch themeButton = new ToggleSwitch();
        SimpleBooleanProperty isOn = themeButton.switchOnProperty();
        isOn.addListener( (observable,oldValue,newValue)->{
            if(newValue){
                themeButton.getScene().getRoot().getStylesheets().add(getClass().getResource("styles.css").toString());
            }
            else {
                themeButton.getScene().getRoot().getStylesheets().remove(getClass().getResource("styles.css").toString());
            }
        });
        theme.getChildren().add(themeButton);



        // TODO
        lvChatWindow.setItems(chatMessages);//attach the observablelist to the listview
        chatsAvail = chatsAvailable;

        User myuser = myUser;

//        InputStream stream = null;
//        try {
//            String s = "C:\\Users\\MATIN\\Desktop\\Graphic_002\\src\\main\\resources\\com\\example\\graphic_002\\1.jpg";
//            stream = new FileInputStream(s);
//        } catch (FileNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//        Image image = new Image(stream);
//        profile.setImage(image);

        ArrayList<String> pvUsernames = new ArrayList<>();

        for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if (all_secret_chat.user1.equals(myuser.username) || all_secret_chat.user2.equals(myuser.username)) {
                    if (!all_secret_chat.user1.equals(myuser.username))
                        pvUsernames.add(all_secret_chat.user1);
                    else
                        pvUsernames.add(all_secret_chat.user2);
                }
            }

        for (Group group : Group.groups) {
                if (group.users.contains(myuser.username)) {
                    pvUsernames.add(group.name);
                }
            }

        chatsAvailable.getItems().addAll(pvUsernames);

        chatSelected.setOnAction(e->{
            chatMessages.clear();
            boolean isPv = false;
            for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if( ( all_secret_chat.user2.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user1.equals(myuser.username) )
                        || (all_secret_chat.user1.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user2.equals(myuser.username) ) ) {

                    isPv = true;

                }
            }

            if(isPv) {
                Secret_Chat secret_chat = null;
                for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                    if ((all_secret_chat.user2.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user1.equals(myuser.username))
                            || (all_secret_chat.user1.equals(chatsAvailable.getValue().toString()) && all_secret_chat.user2.equals(myuser.username))) {
                        for (Chats pvChat : all_secret_chat.thisPVChats) {
                            //chatMessages.add(pvChat.sender + " : " + pvChat.text.toString());
                            if(pvChat.sender.equals(myuser.username)){
                                //String s = pvChat.sender + " : " + pvChat.text.toString();
                                String s = pvChat.text.toString() + " : " + pvChat.sender;
                                StringBuilder txt = new StringBuilder("");
                                //int width = (int) lvChatWindow.getWidth();
                                for (int i = 0; i < width - s.length(); i++) {
                                    txt.append(" ");

                                }
                                txt.append(s);
                                chatMessages.add(txt.toString());



                            }
                            else {
                                chatMessages.add(pvChat.sender + " : " + pvChat.text.toString());
                            }


                        }
                        secret_chat = all_secret_chat;

                    }
                }
                String contantUsername;
                if(secret_chat.user1.equals(myUser.username)){
                    chatDetails.setText(secret_chat.user2);
                    contantUsername = secret_chat.user2;
                }
                else {
                    chatDetails.setText(secret_chat.user1);
                    contantUsername = secret_chat.user1;
                }


                User contact = null;
                for (User allUser : User.allUsers) {
                    if(allUser.username.equals(contantUsername)){
                        contact = allUser;
                    }
                }


                if(contact.profile_address != null) {
                    //System.out.println("yes");
                    InputStream stream = null;
                    try {
                        stream = new FileInputStream(contact.profile_address.toString());
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    Image image = new Image(stream);
                    profile.setImage(image);
                }
                else {
                    profile.setImage(null);
                }


                mySecretChat = secret_chat;
                myGroup = null;
            }
            else {
                Group group = null;
                for (Group group1 : Group.groups) {
                    if(group1.name.equals(chatsAvailable.getValue().toString())){
                        for (Chats groupChat : group1.groupChats) {
                            //chatMessages.add(groupChat.sender + " : " + groupChat.text.toString());
                            if(groupChat.sender.equals(myuser.username)){
                                //String s = pvChat.sender + " : " + pvChat.text.toString();
                                String s = groupChat.text.toString() + " : " + groupChat.sender;
                                StringBuilder txt = new StringBuilder("");
                                //int width = (int) lvChatWindow.getWidth();
                                for (int i = 0; i < width - s.length(); i++) {
                                    txt.append(" ");

                                }
                                txt.append(s);
                                chatMessages.add(txt.toString());

                            }
                            else {
                                chatMessages.add(groupChat.sender + " : " + groupChat.text.toString());
                            }

                        }
                        group = group1;
                    }
                }

                myGroup = group;
                mySecretChat = null;
                StringBuilder s = new StringBuilder("");
                s.append("groupName : " + myGroup.name + " some members: ");
                for (int i = 0; i < group.users.size(); i++) {
                    s.append(group.users.get(i) + " , ");
                    if(i > 2) break;
                }
                s.deleteCharAt(s.length() - 2);
                chatDetails.setText(s.toString());

                if(group.profile_address != null) {
                    //System.out.println("yes");
                    InputStream stream = null;
                    try {
                        stream = new FileInputStream(group.profile_address);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    Image image = new Image(stream);
                    profile.setImage(image);
                }
                else {
                    profile.setImage(null);
                }

            }


        });

        backButton.setOnAction(e ->{

            mainStage.setScene(scene0011saved);

        });

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (groupOnly.isSelected()) {
                    chatsAvailable.getItems().clear();
                    ArrayList<String> items = new ArrayList<>();
                    for (Group group : Group.groups) {
                        if (group.users.contains(myuser.username)) {
                            items.add(group.name);
                        }
                    }
                    chatsAvailable.getItems().addAll(items);

                }
                else{
                    chatsAvailable.getItems().clear();
                    ArrayList<String> items = new ArrayList<>();

                    for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                        if (all_secret_chat.user1.equals(myuser.username) || all_secret_chat.user2.equals(myuser.username)) {
                            if (!all_secret_chat.user1.equals(myuser.username))
                                items.add(all_secret_chat.user1);
                            else
                                items.add(all_secret_chat.user2);
                        }
                    }

                    for (Group group : Group.groups) {
                        if (group.users.contains(myuser.username)) {
                            items.add(group.name);
                        }
                    }

                    chatsAvailable.getItems().addAll(items);


                }


            }

        };

        groupOnly.setOnAction(event);

        createPvChat.setOnAction(e->{
            chatDetails.setText("");
            String userName = searchBar.getText().toString();
            User contact = null;
            for (User allUser : User.allUsers) {
                if(allUser.username.equals(userName)){
                    contact = allUser;
                }
            }
            boolean okToCreate = true;
            if(contact == null) {
                okToCreate = false;
                createPvStats.setText("Username Not Found!");
            }
            else if(myuser.username.equals(userName)){
                okToCreate = false;
                createPvStats.setText("Can't chat with yourself!");

            }

            for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if( ( all_secret_chat.user2.equals(userName) && all_secret_chat.user1.equals(myuser.username) )
                        || (all_secret_chat.user1.equals(userName) && all_secret_chat.user2.equals(myuser.username) ) ) {
                    okToCreate = false;
                    //System.out.println("tekrari");
                    createPvStats.setText("Chat has already been created!");
                    break;
                }
            }

            if(okToCreate){

                createPvStats.setText("");
                Secret_Chat secret_chat = new Secret_Chat();
                secret_chat.user1 = myuser.username;
                secret_chat.user2 = userName;
                Secret_Chat.all_Secret_Chats.add(secret_chat);
                chatsAvailable.getItems().add(secret_chat.user2);
                chatMessages.clear();

                mySecretChat = secret_chat;
                myGroup = null;

            }

        });

        createGroup.setOnAction(u->{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createGroup.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage newStage = new Stage();
            CreateGroup.thisStage = newStage;
            Scene newScene = new Scene(root,400,300);
            newStage.setScene(newScene);
            newStage.show();

            //System.out.println(Group.groups);

        });


        addNewMember.setOnAction(v->{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addMember.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage newStage = new Stage();
            AddMember.thisStage = newStage;
            Scene newScene = new Scene(root,500,300);
            newStage.setScene(newScene);
            newStage.show();


        });



    }




}