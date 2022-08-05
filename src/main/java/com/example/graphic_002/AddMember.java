package com.example.graphic_002;

import Sample.Group;
import Sample.User;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.graphic_002.Chatroom.myGroup;
import static com.example.graphic_002.HelloApplication.myUser;

public class AddMember {

    public ComboBox followerBox;
    public Button submit;
    public Button addMember;
    public ComboBox currentMembers;

    public static Stage thisStage;
    public static ArrayList<String> members = new ArrayList<>();
    public TextField groupProfileAdd;
    public Button groupProfileAddConfirm;


    public void initialize(){
        User user = myUser;
        Group group = myGroup;

        ArrayList<String> currents = new ArrayList<>();
        currents.addAll(group.users);
        currentMembers.getItems().addAll(currents);
        members.addAll(group.users);

        ArrayList<String> canBeAdded = new ArrayList<>();

        for (User allUser : User.allUsers) {
            if(!currents.contains(allUser.username)){
                canBeAdded.add(allUser.username);
                followerBox.getItems().add(allUser.username);
            }
        }


        addMember.setOnAction(e->{
            members.add(followerBox.getValue().toString());
            currentMembers.getItems().clear();
            currentMembers.getItems().addAll(members);


            canBeAdded.remove(followerBox.getValue().toString());
            followerBox.getItems().clear();
            followerBox.getItems().addAll(canBeAdded);


        });

        submit.setOnAction(h->{
            group.users.clear();
            group.users.addAll(members);

            members.clear();

            thisStage.close();


        });

        groupProfileAddConfirm.setOnAction(g->{

            String address = groupProfileAdd.getText().toString();
            group.profile_address = address;


        });





    }
}
