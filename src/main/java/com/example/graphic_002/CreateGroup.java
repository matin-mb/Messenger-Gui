package com.example.graphic_002;

import Sample.Group;
import Sample.User;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.graphic_002.HelloApplication.myUser;

public class CreateGroup {


    public TextField groupName;
    public Button submit;
    public Button addMember;
    public ComboBox followerBox;
    public static ArrayList<String> members = new ArrayList<>();
    public static Stage thisStage;


    public void initialize(){
        User user = myUser;
        ArrayList<String> followers = new ArrayList<>();

        followers.addAll(user.followers);
        //followerBox.getItems().addAll(user.followers);
        followerBox.getItems().addAll(followers);

        addMember.setOnAction(e->{
            members.add(followerBox.getValue().toString());
            followers.remove(followerBox.getValue().toString());
            followerBox.getItems().clear();
            followerBox.getItems().addAll(followers);

        });

        submit.setOnAction(t->{
            Group newGroup = new Group();
            newGroup.name = groupName.getText();
            newGroup.admin = myUser.username;
            newGroup.users.addAll(members);
            newGroup.users.add(myUser.username);
            Group.groups.add(newGroup);

            //thisStage.close();

            members.clear();

        });



    }


}
