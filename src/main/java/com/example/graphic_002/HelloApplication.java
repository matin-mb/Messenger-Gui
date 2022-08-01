package com.example.graphic_002;

import Sample.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class HelloApplication extends Application {
    public static Connection connection ;
    public static Stage mainStage ;
    public static User myUser;

    public static Scene scene0011saved;

    @Override
    public void start(Stage stage) throws IOException {

//        PersonalUser tempUser = new PersonalUser();
//        tempUser.username = "parsann";
//        tempUser.password = "1234567l";
//        tempUser.bio = "I'm 19 from Sabzevar!";
//        PersonalUser.allPersonalUsers.add(tempUser);
//
//        PersonalUser tempUser2 = new PersonalUser();
//        tempUser2.username = "matin";
//        tempUser2.password = "12345678";
//        tempUser2.bio = "I'm 19";
//        PersonalUser.allPersonalUsers.add(tempUser2);
//
//        CommercialUser tempUser3 = new CommercialUser();
//        tempUser3.username="jemco";
//        tempUser3.password="1234567j";
//        CommercialUser.allCommercialUsers.add(tempUser3);



        mainStage = stage;
        Label label01 =new Label("Welcome!");

        Button button01 = new Button();
        button01.setText("enter");
        BorderPane borderPane01 =new BorderPane(label01);
        borderPane01.setAlignment(label01, Pos.CENTER);
        borderPane01.setBottom(button01);
        Scene scene = new Scene(borderPane01,700,700);
        button01.setOnAction(e->{
            VBox vBox01= new VBox(50);
            Button button001 = new Button("Sign up");
            Button button002 = new Button("Login");
            Button button003 = new Button("Forget my password");
            vBox01.getChildren().addAll(button001,button002,button003);
            BorderPane borderPane02= new BorderPane(vBox01);
            borderPane02.setCenter(vBox01);
            Scene scene001 =new Scene(borderPane02,700,700);
            mainStage.setScene(scene001);
            button001.setOnAction(b->{
                ListView listView001= new ListView();
                listView001.getItems().addAll("Username: ");
                TextField textField001 = new TextField();
                listView001.getItems().addAll(textField001);
                listView001.getItems().addAll("Password: ");
                TextField textField002 = new TextField();
                listView001.getItems().addAll(textField002);
                Text text001 = new Text("your password must contains  8 characters (both words and numbers)");
                listView001.getItems().addAll(text001);
                Button button011 = new Button("Submit");
                listView001.getItems().addAll(button011);

                Button button012=new Button("Back");
                listView001.getItems().addAll(button012);
                button012.setOnAction(n->{
                    mainStage.setScene(scene001);
                });
                HBox hBox_help01 = new HBox();
                HBox hBox_help02 = new HBox();


                Scene scene011 = new Scene(listView001,700,700);
                button011.setOnAction(m->{

                    String id = textField001.getText();
                    String password = textField002.getText();
                    Boolean letLoop = false;
                    hBox_help01.getChildren().removeAll(hBox_help01.getChildren());
                    hBox_help02.getChildren().removeAll(hBox_help02.getChildren());

                    for (int i = 0; i < PersonalUser.allPersonalUsers.size() && !letLoop; i++) {
                        if (PersonalUser.allPersonalUsers.get(i).username.equals(id)) {
                            Text text011 =new Text("existed username!");
                            hBox_help01.getChildren().addAll(text011);
                            letLoop = true;

                        }
                    }
                    for (int i = 0; i < CommercialUser.allCommercialUsers.size() && !letLoop; i++) {
                        if (CommercialUser.allCommercialUsers.get(i).username.equals(id)) {
                            Text text011 =new Text("existed username!");
                            hBox_help01.getChildren().addAll(text011);
                            letLoop = true;

                        }
                    }
                    if(!letLoop)
                    {

                    if (password.length() != 8) {
                            Text text012 = new Text("invalid password!");
                            hBox_help01.getChildren().addAll(text012);
//                            listView001.getItems().addAll(hBox_help02);
                        }

                    else if ( ( !password.matches("[a-zA-Z0-9]+") ) || (password.matches("[1-9]+")) ) {
                         Text text012 = new Text("invalid password!");
                         hBox_help01.getChildren().addAll(text012);
                     }
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                        .
//                    vorood be hesab
                        else {

                        Button button0111 = new Button("Personal_User");
                        Button button0112 = new Button("Commercial_User");
                        Button button0113 = new Button("Back");
                        ListView listView021 = new ListView();
                        listView021.getItems().addAll(button0111, button0112, button0113);
                        BorderPane borderPane021 = new BorderPane(listView021);
                        borderPane021.setCenter(listView021);
                        Scene scene0211 = new Scene(borderPane021, 700, 700);
                        mainStage.setScene(scene0211);
                        button0111.setOnAction(v->{
                            PersonalUser personalUser = new PersonalUser();
                            personalUser.username=id;
                            personalUser.password=password;
                            PersonalUser.allPersonalUsers.add(personalUser);
                            BorderPane borderPane_Per_firstPage = new BorderPane();
                            Label label011 = new Label("Welcome " + personalUser.username);
                            borderPane_Per_firstPage.setCenter(label011);
                            HBox hBox_Per_opt = new HBox(50);
                            Button button0011 = new Button("Post");
                            Button button0012 = new Button("Chats");
                            Button button0013 = new Button("Follow");
                            Button button0014 = new Button("Profile");
                            hBox_Per_opt.getChildren().addAll(button0011, button0012, button0013, button0014);
                            borderPane_Per_firstPage.setBottom(hBox_Per_opt);

                            Button button0015 = new Button("Back");
                            borderPane_Per_firstPage.setRight(button0015);
                            Scene scene0011 = new Scene(borderPane_Per_firstPage, 700, 700);
                            mainStage.setScene(scene0011);


                            button0015.setOnAction(g -> {
                                mainStage.setScene(scene011);
                            });
//                            .
//                            .
//                            .
//                            .
//                            .
//                            vorood be post
                            button0011.setOnAction(u-> {
                                PersonalUser finalPersonalUser = personalUser;
                                Button button0000 = new Button("ADD_POST");
                                ScrollPane scrollPane001 = new ScrollPane();


                                VBox vBox001 = new VBox(10);
                                int t=0;
                                vBox001.getChildren().removeAll(vBox001.getChildren());
                                scrollPane001.setContent(vBox001);

                                Scene scene0112 = new Scene(scrollPane001,700,700);

                                mainStage.setScene(scene0112);
                                for (int i = Post.allPosts.size()-1; i >=0 ; i--) {
                                    if (Post.allPosts.get(i).user.equals(finalPersonalUser.username) || finalPersonalUser.followings.contains(Post.allPosts.get(i).user)) {
                                        final String[] l1 = {new String()};
                                        final String[] l2 = {new String()};
                                        final String[] l3 = {new String()};
                                        final int[] likes = {0};
                                        final int[] dislikes = {0};
                                        final int[] comments = {0};
                                        if (comments[0] != 0)
                                            l1[0] = String.valueOf(comments[0]) + " comments";
                                        else
                                            l1[0] = "No comment";

                                        if (likes[0] != 0)
                                            l2[0] = String.valueOf(likes[0]) + " likes";
                                        else
                                            l2[0] = "No like";

                                        if (dislikes[0] != 0)
                                            l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                        else
                                            l3[0] = "No dislike";

                                        HBox hBox001 = new HBox(20);
                                        HBox hBox002 = new HBox(20);
                                        hBox001.getChildren().removeAll(hBox001.getChildren());
                                        hBox002.getChildren().removeAll(hBox002.getChildren());

                                        Label label001 = new Label(String.valueOf(++t)+". "+Post.allPosts.get(i).user + " : " + Post.allPosts.get(i).text);

                                        Button button00111 = new Button("Like");
                                        Button button00222 = new Button("Dislike");
                                        Button button00333 = new Button("Add_Comment");
                                        Button button00444 = new Button();
                                        Button button00555 = new Button();
                                        Button button00666 = new Button();

                                        label001.setFont(new Font("Arial",button00111.getFont().getSize()*2));
                                        hBox001.getChildren().addAll(label001, button00111, button00222, button00333);
                                        int finalI = i;

                                        button00111.setOnAction(y->{
                                            boolean be=true;
                                            for(int g=0;g<Post.allPosts.get(finalI).reactions.size() && be;g++)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username))
                                                {
                                                    Post.allPosts.get(finalI).reactions.get(g).like=1;
                                                    Post.allPosts.get(finalI).reactions.get(g).dislike=0;
                                                    be=false;
                                                    hBox002.getChildren().removeAll(hBox002.getChildren());
                                                    likes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                            likes[0]++;
                                                        }
                                                    }
                                                    dislikes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                            dislikes[0]++;
                                                        }
                                                    }
                                                    comments[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                            comments[0]++;
                                                        }
                                                    }

                                                    if (comments[0] != 0)
                                                        l1[0] = String.valueOf(comments[0]) + " comments";
                                                    else
                                                        l1[0] = "No comment";

                                                    if (likes[0] != 0)
                                                        l2[0] = String.valueOf(likes[0]) + " likes";
                                                    else
                                                        l2[0] = "No like";

                                                    if (dislikes[0] != 0)
                                                        l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                    else
                                                        l3[0] = "No dislike";
                                                    button00444 .setText(l1[0]);
                                                    button00555 .setText(l2[0]);
                                                    button00666 .setText(l3[0]);
                                                    hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                }
                                            }
                                            if(be)
                                            {
                                                Reaction reaction = new Reaction();
                                                reaction.user=finalPersonalUser.username;
                                                reaction.like=1;
                                                reaction.dislike=0;
                                                Post.allPosts.get(finalI).reactions.add(reaction);
                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                likes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                        likes[0]++;
                                                    }
                                                }
                                                dislikes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                        dislikes[0]++;
                                                    }
                                                }
                                                comments[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                        comments[0]++;
                                                    }
                                                }

                                                if (comments[0] != 0)
                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                else
                                                    l1[0] = "No comment";

                                                if (likes[0] != 0)
                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                else
                                                    l2[0] = "No like";

                                                if (dislikes[0] != 0)
                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                else
                                                    l3[0] = "No dislike";
                                                button00444 .setText(l1[0]);
                                                button00555 .setText(l2[0]);
                                                button00666 .setText(l3[0]);
                                                hBox002.getChildren().addAll(button00444, button00555, button00666);


                                            }
                                            mainStage.setScene(scene0112);
                                        });

                                        button00222.setOnAction(y->{
                                            boolean be=true;
                                            for(int g=0;g<Post.allPosts.get(finalI).reactions.size() && be;g++)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username))
                                                {
                                                    Post.allPosts.get(finalI).reactions.get(g).like=0;
                                                    Post.allPosts.get(finalI).reactions.get(g).dislike=1;
                                                    hBox002.getChildren().removeAll(hBox002.getChildren());
                                                    likes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                            likes[0]++;
                                                        }
                                                    }
                                                    dislikes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                            dislikes[0]++;
                                                        }
                                                    }
                                                    comments[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                            comments[0]++;
                                                        }
                                                    }

                                                    if (comments[0] != 0)
                                                        l1[0] = String.valueOf(comments[0]) + " comments";
                                                    else
                                                        l1[0] = "No comment";

                                                    if (likes[0] != 0)
                                                        l2[0] = String.valueOf(likes[0]) + " likes";
                                                    else
                                                        l2[0] = "No like";

                                                    if (dislikes[0] != 0)
                                                        l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                    else
                                                        l3[0] = "No dislike";
                                                    button00444 .setText(l1[0]);
                                                    button00555 .setText(l2[0]);
                                                    button00666 .setText(l3[0]);
                                                    hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                    be=false;
                                                }
                                            }
                                            if(be)
                                            {
                                                Reaction reaction = new Reaction();
                                                reaction.user=finalPersonalUser.username;
                                                reaction.like=0;
                                                reaction.dislike=1;
                                                Post.allPosts.get(finalI).reactions.add(reaction);
                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                likes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                        likes[0]++;
                                                    }
                                                }
                                                dislikes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                        dislikes[0]++;
                                                    }
                                                }
                                                comments[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                        comments[0]++;
                                                    }
                                                }

                                                if (comments[0] != 0)
                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                else
                                                    l1[0] = "No comment";

                                                if (likes[0] != 0)
                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                else
                                                    l2[0] = "No like";

                                                if (dislikes[0] != 0)
                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                else
                                                    l3[0] = "No dislike";
                                                button00444 .setText(l1[0]);
                                                button00555 .setText(l2[0]);
                                                button00666 .setText(l3[0]);
                                                hBox002.getChildren().addAll(button00444, button00555, button00666);



                                            }
                                        });
                                        int finalI1 = i;
                                        button00333.setOnAction(y->{
                                            BorderPane borderPane0001 = new BorderPane();
                                            Label label0001 = new Label("ADD_Comment");
                                            borderPane0001.setCenter(label0001);
                                            TextField textField0001 = new TextField();
                                            borderPane0001.setBottom(textField0001);
                                            Button button0001 =new Button("Back");
                                            Button button0002 = new Button("Submit");
                                            borderPane0001.setRight(button0002);
                                            borderPane0001.setLeft(button0001);
                                            Scene scene00123 = new Scene(borderPane0001,700,700);
                                            mainStage.setScene(scene00123);

                                            button0002.setOnAction(o-> {
                                                boolean be = true;
                                                for (int g = 0; g < Post.allPosts.get(finalI).reactions.size() && be; g++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username)) {
                                                        {
                                                            if (Post.allPosts.get(finalI).reactions.get(g).comment == null) {
                                                                Post.allPosts.get(finalI).reactions.get(g).comment = textField0001.getText();
                                                                mainStage.setScene(scene0112);
                                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                                likes[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                                        likes[0]++;
                                                                    }
                                                                }
                                                                dislikes[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                                        dislikes[0]++;
                                                                    }
                                                                }
                                                                comments[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                                        comments[0]++;
                                                                    }
                                                                }

                                                                if (comments[0] != 0)
                                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                                else
                                                                    l1[0] = "No comment";

                                                                if (likes[0] != 0)
                                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                                else
                                                                    l2[0] = "No like";

                                                                if (dislikes[0] != 0)
                                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                                else
                                                                    l3[0] = "No dislike";
                                                                button00444 .setText(l1[0]);
                                                                button00555 .setText(l2[0]);
                                                                button00666 .setText(l3[0]);
                                                                hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                            }
                                                            else {
                                                                Text text = new Text("You have made comment to this post!");
                                                                borderPane0001.setTop(text);
                                                                System.out.println(3);
                                                            }
                                                            be = false;
                                                        }
                                                    }
                                                }
                                                if (be) {
                                                    Reaction reaction = new Reaction();
                                                    reaction.user = finalPersonalUser.username;
                                                    reaction.comment = textField0001.getText();
                                                    Post.allPosts.get(finalI).reactions.add(reaction);
                                                    hBox002.getChildren().removeAll(hBox002.getChildren());
                                                    likes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                            likes[0]++;
                                                        }
                                                    }
                                                    dislikes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                            dislikes[0]++;
                                                        }
                                                    }
                                                    comments[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                            comments[0]++;
                                                        }
                                                    }

                                                    if (comments[0] != 0)
                                                        l1[0] = String.valueOf(comments[0]) + " comments";
                                                    else
                                                        l1[0] = "No comment";

                                                    if (likes[0] != 0)
                                                        l2[0] = String.valueOf(likes[0]) + " likes";
                                                    else
                                                        l2[0] = "No like";

                                                    if (dislikes[0] != 0)
                                                        l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                    else
                                                        l3[0] = "No dislike";
                                                    button00444 .setText(l1[0]);
                                                    button00555 .setText(l2[0]);
                                                    button00666 .setText(l3[0]);
                                                    hBox002.getChildren().addAll(button00444, button00555, button00666);





                                                    mainStage.setScene(scene0112);
                                                }

                                            });
                                            button0001.setOnAction(s->{
                                                mainStage.setScene(scene0112);
                                            });



                                        });
                                        likes[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (Post.allPosts.get(i).reactions.get(j).like == 1) {
                                                likes[0]++;
                                            }
                                        }
                                        dislikes[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (Post.allPosts.get(i).reactions.get(j).dislike == 1) {
                                                dislikes[0]++;
                                            }
                                        }
                                        comments[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (Post.allPosts.get(i).reactions.get(j).comment!=null) {
                                                comments[0]++;
                                            }
                                        }

                                        if (comments[0] != 0)
                                            l1[0] = String.valueOf(comments[0]) + " comments";
                                        else
                                            l1[0] = "No comment";

                                        if (likes[0] != 0)
                                            l2[0] = String.valueOf(likes[0]) + " likes";
                                        else
                                            l2[0] = "No like";

                                        if (dislikes[0] != 0)
                                            l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                        else
                                            l3[0] = "No dislike";
                                        button00444 .setText(l1[0]);
                                        button00555 .setText(l2[0]);
                                        button00666 .setText(l3[0]);
                                        hBox002.getChildren().addAll(button00444, button00555, button00666);
                                        vBox001.getChildren().addAll(hBox001, hBox002);

                                        button00444.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                            ListView listView00001 = new ListView();
                                            ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                            Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                            int count=0;
                                            for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(j).comment!=null)
                                                {
                                                    Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user+" :    "+ Post.allPosts.get(finalI).reactions.get(j).comment);
                                                    listView00001.getItems().addAll(label0);
                                                }
                                            }
                                            Button button000011= new Button("Back");
                                            button000011.setOnAction(g->{
                                                mainStage.setScene(scene0112);

                                            });
                                            mainStage.setScene(scene00001111);
                                            listView00001.getItems().addAll(button000011);
                                            anchorPane00001.getChildren().addAll(listView00001);



                                        });
                                    }
                                }
                                vBox001.getChildren().addAll(button0000);

                                Button button00777 = new Button("Back");
                                button00777.setOnAction(y -> {
                                    mainStage.setScene(scene0011);
                                });
                                vBox001.getChildren().addAll(button00777);

                                button0000.setOnAction(k->{
                                    BorderPane borderPane0000 = new BorderPane();
                                    Label label00001 = new Label("Please text your post");
                                    borderPane0000.setCenter(label00001);
                                    TextField textField0000 = new TextField();
                                    borderPane0000.setBottom(textField0000);
                                    Button button00001 = new Button("Submit");
                                    borderPane0000.setRight(button00001);
                                    Button button00002 = new Button("Back");
                                    borderPane0000.setLeft(button00002);
                                    Scene scene0000 = new Scene(borderPane0000,700,700);
                                    button00001.setOnAction(s->{
                                        Post post = new Post();
                                        post.user= finalPersonalUser.username;
                                        post.text=textField0000.getText();
                                        mainStage.setScene(scene0011);
                                        Post.allPosts.add(post);
                                    });
                                    button00002.setOnAction(d->{
                                        mainStage.setScene(scene0112);
                                    });
                                    mainStage.setScene(scene0000);
                                });
                            });

                        });
                        button0112.setOnAction(u->{
                            CommercialUser commercialUser = new CommercialUser();
                            commercialUser.username=id;
                            commercialUser.password=password;
                            CommercialUser.allCommercialUsers.add(commercialUser);

                            BorderPane borderPane_Com_firstPage = new BorderPane();
                            Label label011 = new Label("Welcome " + commercialUser.username);
                            borderPane_Com_firstPage.setCenter(label011);
                            HBox hBox_Com_opt = new HBox(50);
                            Button button0011 = new Button("Post");
                            Button button0012 = new Button("Stats");
                            Button button0013 = new Button("Follow");
                            Button button0014 = new Button("Profile");
                            hBox_Com_opt.getChildren().addAll(button0011, button0012, button0013, button0014);
                            borderPane_Com_firstPage.setBottom(hBox_Com_opt);
                            Button button0015 = new Button("Back");
                            borderPane_Com_firstPage.setRight(button0015);

                            Scene scene0011 = new Scene(borderPane_Com_firstPage, 700, 700);
                            mainStage.setScene(scene0011);
                            button0015.setOnAction(g -> {
                                mainStage.setScene(scene011);
                            });



                        });
                        button0113.setOnAction(r->{
                            mainStage.setScene(scene011);
                        });




















                    }




                    }
//                    .
//                    .
//                    .
//                    .
//                    .
//                    .
//                    .
//                    .

















                });
                listView001.getItems().addAll(hBox_help01);
                listView001.getItems().addAll(hBox_help02);

                mainStage.setScene(scene011);
            });
            button002.setOnAction(v-> {

                Button button0111 = new Button("Personal_User");
                Button button0112 = new Button("Commercial_User");
                Button button0113 = new Button("Back");
                ListView listView011 = new ListView();
                listView011.getItems().addAll(button0111, button0112, button0113);
                BorderPane borderPane011 = new BorderPane(listView011);
                borderPane011.setCenter(listView011);
                Scene scene0111 = new Scene(borderPane011, 700, 700);
                mainStage.setScene(scene0111);
                button0111.setOnAction(r -> {

                    ListView listView001 = new ListView();
                    listView001.getItems().addAll("Username: ");
                    TextField textField001 = new TextField();
                    listView001.getItems().addAll(textField001);
                    listView001.getItems().addAll("Password: ");
                    TextField textField002 = new TextField();
                    listView001.getItems().addAll(textField002);
                    Text text001 = new Text("your password must contains  8 characters (both words and numbers)");
                    listView001.getItems().addAll(text001);
                    Button button011 = new Button("Submit");
                    HBox hBox_help01 = new HBox();
                    HBox hBox_help02 = new HBox();
                    Scene scene013 = new Scene(listView001, 700, 700);

                    listView001.getItems().addAll(button011);
                    button011.setOnAction(m -> {
                        String id = textField001.getText();
                        String password = textField002.getText();
                        Boolean letLoop = false;
                        hBox_help01.getChildren().removeAll(hBox_help01.getChildren());
                        hBox_help02.getChildren().removeAll(hBox_help02.getChildren());

                        if(PersonalUser.findPU(id)!=-1) {
                            letLoop = true;
                        }
//                        for (int i = 0; i < CommercialUser.allCommercialUsers.size() && !letLoop; i++) {
//                            if (CommercialUser.allCommercialUsers.get(i).username.equals(id)) {
//                                letLoop = true;
//
//                            }
//                        }
                        if (!letLoop) {
                            Text text011 = new Text("username not found!");
                            hBox_help01.getChildren().addAll(text011);
                        }
                        else {

                        if (password.length() != 8) {
                                Text text012 = new Text("invalid password!");
                                hBox_help01.getChildren().addAll(text012);
//                            listView001.getItems().addAll(hBox_help02);

                        } else if ((!password.matches("[a-zA-Z0-9]+")) || (password.matches("[1-9]+"))) {
                                Text text012 = new Text("invalid password!");
                                hBox_help01.getChildren().addAll(text012);
                        }
                        else if (!PersonalUser.allPersonalUsers.get(PersonalUser.findPU(id)).password.equals(password)) {
                            Text text012 = new Text("incorrect password!");
                            hBox_help01.getChildren().addAll(text012);
                        }
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
                        //                    vorood be hesab
                        else {
                            PersonalUser personalUser = new PersonalUser();
                            personalUser = PersonalUser.allPersonalUsers.get(PersonalUser.findPU(id));
                            BorderPane borderPane_Per_firstPage = new BorderPane();
                            Label label011 = new Label("Welcome " + personalUser.username);
                            borderPane_Per_firstPage.setCenter(label011);
                            HBox hBox_Per_opt = new HBox(50);
                            Button button0011 = new Button("Post");
                            Button button0012 = new Button("Chats");
                            Button button0013 = new Button("Follow");
                            Button button0014 = new Button("Profile");
                            hBox_Per_opt.getChildren().addAll(button0011, button0012, button0013, button0014);
                            borderPane_Per_firstPage.setBottom(hBox_Per_opt);
                            Button button0015 = new Button("Back");
                            borderPane_Per_firstPage.setRight(button0015);
                            Scene scene0011 = new Scene(borderPane_Per_firstPage, 700, 700);
                            mainStage.setScene(scene0011);
                            scene0011saved = scene0011;

                            button0015.setOnAction(g -> {
                                mainStage.setScene(scene013);
                            });
                            PersonalUser finalPersonalUser = personalUser;

                            button0011.setOnAction(u-> {
                                Button button0000 = new Button("ADD_POST");
                                ScrollPane scrollPane001 = new ScrollPane();


                                VBox vBox001 = new VBox(10);
                                int t=0;
                                vBox001.getChildren().removeAll(vBox001.getChildren());
                                scrollPane001.setContent(vBox001);

                                Scene scene0112 = new Scene(scrollPane001,700,700);

                                mainStage.setScene(scene0112);
                                for (int i = Post.allPosts.size()-1; i >=0 ; i--) {
                                    if (Post.allPosts.get(i).user.equals(finalPersonalUser.username) || finalPersonalUser.followings.contains(Post.allPosts.get(i).user)) {
                                        final String[] l1 = {new String()};
                                        final String[] l2 = {new String()};
                                        final String[] l3 = {new String()};
                                        final int[] likes = {0};
                                        final int[] dislikes = {0};
                                        final int[] comments = {0};
                                        if (comments[0] != 0)
                                            l1[0] = String.valueOf(comments[0]) + " comments";
                                        else
                                            l1[0] = "No comment";

                                        if (likes[0] != 0)
                                            l2[0] = String.valueOf(likes[0]) + " likes";
                                        else
                                            l2[0] = "No like";

                                        if (dislikes[0] != 0)
                                            l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                        else
                                            l3[0] = "No dislike";

                                        HBox hBox001 = new HBox(20);
                                        HBox hBox002 = new HBox(20);
                                        hBox001.getChildren().removeAll(hBox001.getChildren());
                                        hBox002.getChildren().removeAll(hBox002.getChildren());

                                        Label label001 = new Label(String.valueOf(++t)+". "+Post.allPosts.get(i).user + " : " + Post.allPosts.get(i).text);

                                        Button button00111 = new Button("Like");
                                        Button button00222 = new Button("Dislike");
                                        Button button00333 = new Button("Add_Comment");
                                        Button button00444 = new Button();
                                        Button button00555 = new Button();
                                        Button button00666 = new Button();
                                        label001.setFont(new Font("Arial",button00111.getFont().getSize()*2));
                                        hBox001.getChildren().addAll(label001, button00111, button00222, button00333);
                                        int finalI = i;

                                        button00111.setOnAction(y->{
                                            boolean b=true;
                                            for(int g=0;g<Post.allPosts.get(finalI).reactions.size() && b;g++)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username))
                                                {
                                                    Post.allPosts.get(finalI).reactions.get(g).like=1;
                                                    Post.allPosts.get(finalI).reactions.get(g).dislike=0;
                                                    b=false;
                                                    hBox002.getChildren().removeAll(hBox002.getChildren());
                                                    likes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                            likes[0]++;
                                                        }
                                                    }
                                                    dislikes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                            dislikes[0]++;
                                                        }
                                                    }
                                                    comments[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                            comments[0]++;
                                                        }
                                                    }

                                                    if (comments[0] != 0)
                                                        l1[0] = String.valueOf(comments[0]) + " comments";
                                                    else
                                                        l1[0] = "No comment";

                                                    if (likes[0] != 0)
                                                        l2[0] = String.valueOf(likes[0]) + " likes";
                                                    else
                                                        l2[0] = "No like";

                                                    if (dislikes[0] != 0)
                                                        l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                    else
                                                        l3[0] = "No dislike";
                                                    button00444 .setText(l1[0]);
                                                    button00555 .setText(l2[0]);
                                                    button00666 .setText(l3[0]);
                                                    hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                }
                                            }
                                            if(b)
                                            {
                                               Reaction reaction = new Reaction();
                                               reaction.user=finalPersonalUser.username;
                                               reaction.like=1;
                                               reaction.dislike=0;
                                               Post.allPosts.get(finalI).reactions.add(reaction);
                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                likes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                        likes[0]++;
                                                    }
                                                }
                                                dislikes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                        dislikes[0]++;
                                                    }
                                                }
                                                comments[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                        comments[0]++;
                                                    }
                                                }

                                                if (comments[0] != 0)
                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                else
                                                    l1[0] = "No comment";

                                                if (likes[0] != 0)
                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                else
                                                    l2[0] = "No like";

                                                if (dislikes[0] != 0)
                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                else
                                                    l3[0] = "No dislike";
                                                button00444 .setText(l1[0]);
                                                button00555 .setText(l2[0]);
                                                button00666 .setText(l3[0]);
                                                hBox002.getChildren().addAll(button00444, button00555, button00666);


                                            }
                                            mainStage.setScene(scene0112);
                                        });
                                        button00222.setOnAction(y->{
                                            boolean b=true;
                                            for(int g=0;g<Post.allPosts.get(finalI).reactions.size() && b;g++)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username))
                                                {
                                                    Post.allPosts.get(finalI).reactions.get(g).like=0;
                                                    Post.allPosts.get(finalI).reactions.get(g).dislike=1;
                                                    hBox002.getChildren().removeAll(hBox002.getChildren());
                                                    likes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                            likes[0]++;
                                                        }
                                                    }
                                                    dislikes[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                            dislikes[0]++;
                                                        }
                                                    }
                                                    comments[0] =0;
                                                    for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                        if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                            comments[0]++;
                                                        }
                                                    }

                                                    if (comments[0] != 0)
                                                        l1[0] = String.valueOf(comments[0]) + " comments";
                                                    else
                                                        l1[0] = "No comment";

                                                    if (likes[0] != 0)
                                                        l2[0] = String.valueOf(likes[0]) + " likes";
                                                    else
                                                        l2[0] = "No like";

                                                    if (dislikes[0] != 0)
                                                        l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                    else
                                                        l3[0] = "No dislike";
                                                    button00444 .setText(l1[0]);
                                                    button00555 .setText(l2[0]);
                                                    button00666 .setText(l3[0]);
                                                    hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                    b=false;
                                                }
                                            }
                                            if(b)
                                            {
                                                Reaction reaction = new Reaction();
                                                reaction.user=finalPersonalUser.username;
                                                reaction.like=0;
                                                reaction.dislike=1;
                                                Post.allPosts.get(finalI).reactions.add(reaction);
                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                likes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                        likes[0]++;
                                                    }
                                                }
                                                dislikes[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                        dislikes[0]++;
                                                    }
                                                }
                                                comments[0] =0;
                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                        comments[0]++;
                                                    }
                                                }

                                                if (comments[0] != 0)
                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                else
                                                    l1[0] = "No comment";

                                                if (likes[0] != 0)
                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                else
                                                    l2[0] = "No like";

                                                if (dislikes[0] != 0)
                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                else
                                                    l3[0] = "No dislike";
                                                button00444 .setText(l1[0]);
                                                button00555 .setText(l2[0]);
                                                button00666 .setText(l3[0]);
                                                hBox002.getChildren().addAll(button00444, button00555, button00666);



                                            }
                                        });
                                        int finalI1 = i;
                                        button00333.setOnAction(y->{
                                            BorderPane borderPane0001 = new BorderPane();
                                            Label label0001 = new Label("ADD_Comment");
                                            borderPane0001.setCenter(label0001);
                                            TextField textField0001 = new TextField();
                                            borderPane0001.setBottom(textField0001);
                                            Button button0001 =new Button("Back");
                                            Button button0002 = new Button("Submit");
                                            borderPane0001.setRight(button0002);
                                            borderPane0001.setLeft(button0001);
                                            Scene scene00123 = new Scene(borderPane0001,700,700);
                                            mainStage.setScene(scene00123);

                                            button0002.setOnAction(o-> {
                                                boolean b = true;
                                                for (int g = 0; g < Post.allPosts.get(finalI).reactions.size() && b; g++) {
                                                    if (Post.allPosts.get(finalI).reactions.get(g).user.equals(finalPersonalUser.username)) {
                                                        {
                                                            if (Post.allPosts.get(finalI).reactions.get(g).comment == null) {
                                                                Post.allPosts.get(finalI).reactions.get(g).comment = textField0001.getText();
                                                                mainStage.setScene(scene0112);
                                                                hBox002.getChildren().removeAll(hBox002.getChildren());
                                                                likes[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                                        likes[0]++;
                                                                    }
                                                                }
                                                                dislikes[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                                        dislikes[0]++;
                                                                    }
                                                                }
                                                                comments[0] =0;
                                                                for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                                    if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                                        comments[0]++;
                                                                    }
                                                                }

                                                                if (comments[0] != 0)
                                                                    l1[0] = String.valueOf(comments[0]) + " comments";
                                                                else
                                                                    l1[0] = "No comment";

                                                                if (likes[0] != 0)
                                                                    l2[0] = String.valueOf(likes[0]) + " likes";
                                                                else
                                                                    l2[0] = "No like";

                                                                if (dislikes[0] != 0)
                                                                    l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                                else
                                                                    l3[0] = "No dislike";
                                                                button00444 .setText(l1[0]);
                                                                button00555 .setText(l2[0]);
                                                                button00666 .setText(l3[0]);
                                                                hBox002.getChildren().addAll(button00444, button00555, button00666);



                                                            }
                                                            else {
                                                                Text text = new Text("You have made comment to this post!");
                                                                borderPane0001.setTop(text);
                                                                System.out.println(3);
                                                            }
                                                            b = false;
                                                        }
                                                    }
                                                }
                                                    if (b) {
                                                        Reaction reaction = new Reaction();
                                                        reaction.user = finalPersonalUser.username;
                                                        reaction.comment = textField0001.getText();
                                                        Post.allPosts.get(finalI).reactions.add(reaction);
                                                        hBox002.getChildren().removeAll(hBox002.getChildren());
                                                        likes[0] =0;
                                                        for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                            if (Post.allPosts.get(finalI).reactions.get(j).like == 1) {
                                                                likes[0]++;
                                                            }
                                                        }
                                                        dislikes[0] =0;
                                                        for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                            if (Post.allPosts.get(finalI).reactions.get(j).dislike == 1) {
                                                                dislikes[0]++;
                                                            }
                                                        }
                                                        comments[0] =0;
                                                        for (int j = 0; j < Post.allPosts.get(finalI).reactions.size(); j++) {
                                                            if (Post.allPosts.get(finalI).reactions.get(j).comment!=null) {
                                                                comments[0]++;
                                                            }
                                                        }

                                                        if (comments[0] != 0)
                                                            l1[0] = String.valueOf(comments[0]) + " comments";
                                                        else
                                                            l1[0] = "No comment";

                                                        if (likes[0] != 0)
                                                            l2[0] = String.valueOf(likes[0]) + " likes";
                                                        else
                                                            l2[0] = "No like";

                                                        if (dislikes[0] != 0)
                                                            l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                                        else
                                                            l3[0] = "No dislike";
                                                        button00444 .setText(l1[0]);
                                                        button00555 .setText(l2[0]);
                                                        button00666 .setText(l3[0]);
                                                        hBox002.getChildren().addAll(button00444, button00555, button00666);





                                                        mainStage.setScene(scene0112);
                                                    }

                                            });
                                            button0001.setOnAction(s->{
                                                mainStage.setScene(scene0112);
                                            });



                                        });
                                         likes[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (Post.allPosts.get(i).reactions.get(j).like == 1) {
                                                likes[0]++;
                                            }
                                        }
                                        dislikes[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (Post.allPosts.get(i).reactions.get(j).dislike == 1) {
                                                dislikes[0]++;
                                            }
                                        }
                                        comments[0] =0;
                                        for (int j = 0; j < Post.allPosts.get(i).reactions.size(); j++) {
                                            if (!Post.allPosts.get(i).reactions.get(j).comment.isEmpty()) {
                                                comments[0]++;
                                            }
                                        }

                                        if (comments[0] != 0)
                                            l1[0] = String.valueOf(comments[0]) + " comments";
                                        else
                                            l1[0] = "No comment";

                                        if (likes[0] != 0)
                                            l2[0] = String.valueOf(likes[0]) + " likes";
                                        else
                                            l2[0] = "No like";

                                        if (dislikes[0] != 0)
                                            l3[0] = String.valueOf(dislikes[0]) + " dislikes";
                                        else
                                            l3[0] = "No dislike";
                                        button00444 .setText(l1[0]);
                                        button00555 .setText(l2[0]);
                                        button00666 .setText(l3[0]);
                                        hBox002.getChildren().addAll(button00444, button00555, button00666);
                                        vBox001.getChildren().addAll(hBox001, hBox002);

                                        //int a;
                                        button00444.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                                ListView listView00001 = new ListView();
                                                ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                                Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                                int count=0;
                                                for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                                {
                                                    if(Post.allPosts.get(finalI).reactions.get(j).comment!=null)
                                                    {
                                                        Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user+" :    "+ Post.allPosts.get(finalI).reactions.get(j).comment);
                                                        listView00001.getItems().addAll(label0);
                                                    }
                                                }
                                                Button button000011= new Button("Back");
                                                button000011.setOnAction(g->{
                                                    mainStage.setScene(scene0112);

                                                });
                                                mainStage.setScene(scene00001111);
                                                listView00001.getItems().addAll(button000011);
                                            anchorPane00001.getChildren().addAll(listView00001);



                                        });


                                    }



                                }
                                vBox001.getChildren().addAll(button0000);

                                Button button00777 = new Button("Back");
                                button00777.setOnAction(y -> {
                                    mainStage.setScene(scene0011);
                                });
                                vBox001.getChildren().addAll(button00777);

                                button0000.setOnAction(k->{
                                    BorderPane borderPane0000 = new BorderPane();
                                    Label label00001 = new Label("Please text your post");
                                    borderPane0000.setCenter(label00001);
                                    TextField textField0000 = new TextField();
                                    borderPane0000.setBottom(textField0000);
                                    Button button00001 = new Button("Submit");
                                    borderPane0000.setRight(button00001);
                                    Button button00002 = new Button("Back");
                                    borderPane0000.setLeft(button00002);
                                    Scene scene0000 = new Scene(borderPane0000,700,700);
                                    button00001.setOnAction(s->{
                                        Post post = new Post();
                                        post.user= finalPersonalUser.username;
                                        post.text=textField0000.getText();
                                        mainStage.setScene(scene0011);
                                        Post.allPosts.add(post);
                                    });
                                    button00002.setOnAction(d->{
                                        mainStage.setScene(scene0112);
                                    });

                                    mainStage.setScene(scene0000);
                                });



                            });

                            PersonalUser finalPersonalUser1 = personalUser;
                            myUser = finalPersonalUser1;
                            button0012.setOnAction(u ->{

                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chatroom.fxml"));
                                Parent root = null;

                                try {
                                    root = fxmlLoader.load();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                Chatroom chatroom = fxmlLoader.getController();

                                Scene scenenew = new Scene(root);
                                mainStage.setScene(scenenew);
                                mainStage.show();

                            });



                        }









                        }








                    });
                    listView001.getItems().addAll(hBox_help01);
                    listView001.getItems().addAll(hBox_help02);


                    Button button012 = new Button("Back");
                    listView001.getItems().addAll(button012);
                    button012.setOnAction(n -> {
                        mainStage.setScene(scene0111);
                    });

                    mainStage.setScene(scene013);
                });

                button0112.setOnAction(p -> {

                    ListView listView001 = new ListView();
                    listView001.getItems().addAll("Username: ");
                    TextField textField001 = new TextField();
                    listView001.getItems().addAll(textField001);
                    listView001.getItems().addAll("Password: ");
                    TextField textField002 = new TextField();
                    listView001.getItems().addAll(textField002);
                    Text text001 = new Text("your password must contains  8 characters (both words and numbers)");
                    listView001.getItems().addAll(text001);
                    Button button011 = new Button("Submit");
                    HBox hBox_help01 = new HBox();
                    HBox hBox_help02 = new HBox();

                    listView001.getItems().addAll(button011);
                    Scene scene013 = new Scene(listView001, 700, 700);

                    button011.setOnAction(m -> {
                        String id = textField001.getText();
                        String password = textField002.getText();
                        Boolean letLoop = false;
                        hBox_help01.getChildren().removeAll(hBox_help01.getChildren());
                        hBox_help02.getChildren().removeAll(hBox_help02.getChildren());
//
//                        if(PersonalUser.findPU(id)!=-1) {
//                            letLoop = true;
//                        }
                        for (int i = 0; i < CommercialUser.allCommercialUsers.size() && !letLoop; i++) {
                            if (CommercialUser.allCommercialUsers.get(i).username.equals(id)) {
                                letLoop = true;

                            }
                        }
                        if (!letLoop) {
                            Text text011 = new Text("username not found!");
                            hBox_help01.getChildren().addAll(text011);
                        }
                        else {

                            if (password.length() != 8) {
                                Text text012 = new Text("invalid password!");
                                hBox_help01.getChildren().addAll(text012);
//                            listView001.getItems().addAll(hBox_help02);

                            } else if ((!password.matches("[a-zA-Z0-9]+")) || (password.matches("[1-9]+"))) {
                                Text text012 = new Text("invalid password!");
                                hBox_help01.getChildren().addAll(text012);
                            }
                            else if (!CommercialUser.allCommercialUsers.get(CommercialUser.findPU(id)).password.equals(password)) {
                                Text text012 = new Text("incorrect password!");
                                hBox_help01.getChildren().addAll(text012);
                            }
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
//                            .
//                    vorood be hesab
                            else {
                                CommercialUser commercialUser = new CommercialUser();
                                commercialUser = CommercialUser.allCommercialUsers.get(CommercialUser.findPU(id));
                                BorderPane borderPane_Com_firstPage = new BorderPane();
                                Label label011 = new Label("Welcome " + commercialUser.username);
                                borderPane_Com_firstPage.setCenter(label011);
                                HBox hBox_Com_opt = new HBox(50);
                                Button button0011 = new Button("Post");
                                Button button0012 = new Button("Stats");
                                Button button0013 = new Button("Follow");
                                Button button0014 = new Button("Profile");
                                hBox_Com_opt.getChildren().addAll(button0011, button0012, button0013, button0014);
                                borderPane_Com_firstPage.setBottom(hBox_Com_opt);
                                Button button0015 = new Button("Back");
                                borderPane_Com_firstPage.setRight(button0015);
                                Scene scene0011 = new Scene(borderPane_Com_firstPage, 700, 700);
                                mainStage.setScene(scene0011);
                                button0015.setOnAction(g -> {
                                    mainStage.setScene(scene013);
                                });



                            }


                        }


                    });
                    listView001.getItems().addAll(hBox_help01);
                    listView001.getItems().addAll(hBox_help02);


                    Button button012 = new Button("Back");
                    listView001.getItems().addAll(button012);
                    button012.setOnAction(n -> {
                        mainStage.setScene(scene0111);
                    });
                    mainStage.setScene(scene013);





                });

                button0113.setOnAction(k -> {
                    mainStage.setScene(scene001);
                });

//            button003.setOnAction(u->{
//
//            });


            });

        });




        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dataBaseInit();
        launch();
    }

    public static void dataBaseInit() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysocial", "root" ,
                "2231382");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()){
            if(resultSet.getInt("type") == 1){
                PersonalUser personalUser = new PersonalUser(resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("bio"));
//                personalUser.securityQ = resultSet.getString("securityQ");
//                personalUser.securityA = resultSet.getString("securityA");
                PersonalUser.allPersonalUsers.add(personalUser);
                User.allUsers.add(personalUser);

            }
            else if(resultSet.getInt("type") == 2){
                CommercialUser commercialUser = new CommercialUser(resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("bio"));
//                commercialUser.securityQ = resultSet.getString("securityQ");
//                commercialUser.securityA= resultSet.getString("securityA");
                CommercialUser.allCommercialUsers.add(commercialUser);
                User.allUsers.add(commercialUser);

            }

        }

        resultSet = statement.executeQuery("select * from followlist");
        while (resultSet.next()){

            int follower_id = resultSet.getInt("follower_id") , followee_id = resultSet.getInt("followee_id");
            User follower, followee ;
            follower = User.allUsers.get(follower_id - 1);
            followee = User.allUsers.get(followee_id - 1);

            follower.followings.add(followee.username);
            followee.followers.add(follower.username);
        }

        resultSet = statement.executeQuery("select * from posts");
        while (resultSet.next()){
            User author = User.allUsers.get(resultSet.getInt("user_id") - 1);
            //Post post = new Post(resultSet.getString("content"),author);
            Post post = new Post(resultSet.getString("content"),author.username);
            post.postTime = resultSet.getObject("postDateTime", LocalDateTime.class);
            //System.out.println(post.postTime);

            Post.allPosts.add(post);
        }

        resultSet = statement.executeQuery("select * from reactions");
        while (resultSet.next()){
            User commenter = User.allUsers.get(resultSet.getInt("user_id") - 1);
//            Reaction reaction = new Reaction(resultSet.getString("comment"),resultSet.getInt("liked"),
//                    resultSet.getInt("disliked"),commenter);
            Reaction reaction = new Reaction(resultSet.getString("comment"),resultSet.getInt("liked"),
                    resultSet.getInt("disliked"),commenter.username);
            reaction.post_id = resultSet.getInt("post_id");
            Post post = Post.allPosts.get(resultSet.getInt("post_id") - 1);
            post.reactions.add(reaction);
        }

        resultSet = statement.executeQuery("select * from privatechats");
        while (resultSet.next()){

            Secret_Chat secret_chat = null;
            for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if( (all_secret_chat.user1.equals(resultSet.getString("user1_id")) && all_secret_chat.user2.equals(resultSet.getString("user2_id") ) )
                        || (all_secret_chat.user2.equals(resultSet.getString("user1_id")) && all_secret_chat.user1.equals(resultSet.getString("user2_id") ) ) )
                {
                    secret_chat = all_secret_chat;
                }
            }
            if(secret_chat != null){
                Chats chats = new Chats();
                chats.receiver = resultSet.getString("user2_id");
                chats.sender = resultSet.getString("user1_id");
                chats.text = new StringBuilder(resultSet.getString("text"));
                chats.replied = resultSet.getInt("replied");
                chats.forwarded = resultSet.getInt("forwarded");
                secret_chat.block = resultSet.getInt("blocked");

                secret_chat.thisPVChats.add(chats);
            }
            else {
                secret_chat = new Secret_Chat();
                secret_chat.user1 = resultSet.getString("user1_id");
                secret_chat.user2 = resultSet.getString("user2_id");
                Chats chats = new Chats();
                chats.receiver = resultSet.getString("user2_id");
                chats.sender = resultSet.getString("user1_id");
                chats.text = new StringBuilder(resultSet.getString("text"));
                chats.replied = resultSet.getInt("replied");
                chats.forwarded = resultSet.getInt("forwarded");

                secret_chat.thisPVChats.add(chats);
                //secret_chat.thisPVChats.add(resultSet.)
                Secret_Chat.all_Secret_Chats.add(secret_chat);
            }

        }

        resultSet = statement.executeQuery("select * from allgroups" );
        while (resultSet.next()){
            Group group = null;
            for (Group group1 : Group.groups) {
                if(group1.admin.equals(resultSet.getString("groupAdmin"))){
                    group = group1;
                }
            }

            if(group != null){
                group.users.add(resultSet.getString("member"));
            }
            else {
                group = new Group();
                group.id = resultSet.getString("group_id");
                group.admin = resultSet.getString("groupAdmin");
                group.name = resultSet.getString("groupName");
                group.users.add(resultSet.getString("member"));

                Group.groups.add(group);
            }

        }

        resultSet = statement.executeQuery("select * from groupchats" );
        while (resultSet.next()){
            Group group;
            int groupId = resultSet.getInt("group_id");
            group = Group.groups.get(groupId - 1);

            //group.groupChats.add(resultSet.getString())
            Chats chats = new Chats();
            chats.text = new StringBuilder(resultSet.getString("text"));
            chats.sender = resultSet.getString("sender_id");
            chats.replied = resultSet.getInt("replied");
            chats.forwarded = resultSet.getInt("forwarded");

            group.groupChats.add(chats);


        }

        resultSet = statement.executeQuery("select * from groupclosed");
        while (resultSet.next()){
            String groupid = resultSet.getString("group_id");
            Group group = null;
            for (Group group1 : Group.groups) {
                if(group1.id.equals(groupid))
                    group = group1;
            }
            if(group != null)
                group.closed_users.add(resultSet.getString("banned_user"));

        }

    }

//    public static void accountRecommender(User myUser) {
//
//        ArrayList<String> myfollowings = new ArrayList<>();
//        myfollowings.addAll(myUser.followings);
//        ArrayList<User> releative = new ArrayList<>();
//
//        for (String following : myUser.followings) {
//            User followingUser = getUser(following);
//            if(followingUser == null) continue;
//
//            for (String f : followingUser.followings) {
//
//                if(!myfollowings.contains(f) && !myUser.username.equals(f)){
//                    User userf = getUser(f);
//                    if(userf == null) continue;
//                    releative.add(userf);
//                }
//
//            }
//
//        }
//
//        HashMap<User,Integer> countMap = new HashMap<>();
//        for (User user : releative) {
//            if (countMap.containsKey(user))
//                countMap.put(user, countMap.get(user) + 1);
//            else
//                countMap.put(user, 1);
//
//        }
//
//        HashMap<User,Integer> countMap1 = sortByValue(countMap);
//        releative = (ArrayList<User>) countMap1.keySet().stream().collect(Collectors.toList());
//
//        System.out.println("Recommended Users:");
//        for (int i = releative.size() - 1;  i >= 0; i--) {
//            //System.out.println(releative.get(i));
//            System.out.println( (releative.size() - i) + " - " + releative.get(i).username);
//        }
//        if(releative.size() == 0) System.out.println("There is no recommended user!");
//        System.out.println();
//
//    }

    private static User getUser(String following) {

        for (User allUser : User.allUsers) {
            if(allUser.username.equals(following))
                return allUser;

        }

        return null;
    }

    public static HashMap<User, Integer> sortByValue(HashMap<User, Integer> hm) {
        List<Map.Entry<User, Integer> > list =
                new LinkedList<Map.Entry<User, Integer> >(hm.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<User, Integer> >() {
            public int compare(Map.Entry<User, Integer> o1,
                               Map.Entry<User, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<User, Integer> temp = new LinkedHashMap<User, Integer>();
        for (Map.Entry<User, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static HashMap<Post, Integer> sortByValue1(HashMap<Post, Integer> hm) {
        List<Map.Entry<Post, Integer> > list =
                new LinkedList<Map.Entry<Post, Integer> >(hm.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<Post, Integer> >() {
            public int compare(Map.Entry<Post, Integer> o1,
                               Map.Entry<Post, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Post, Integer> temp = new LinkedHashMap<Post, Integer>();
        for (Map.Entry<Post, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

//    public static void dataBaseFin() throws SQLException {
//
//        Statement statement = connection.createStatement();
//
//        statement.executeUpdate("truncate users");
////        PreparedStatement preparedStatement = connection.prepareStatement("insert into users" +
////                "(username,password,bio,type,securityQ,securityA) values(?,?,?,?,?,?)");
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into users" +
//                "(username,password,bio,type) values(?,?,?,?)");
//
//
//        for (User allUser : User.allUsers) {
//            preparedStatement.setString(1, allUser.username);
//            preparedStatement.setString(2, allUser.password.toString());
//            if(allUser.bio != null)
//                preparedStatement.setString(3,allUser.bio.toString());
//            else
//                preparedStatement.setString(3 , "no bio!");
//
//            if(allUser.getClass() == PersonalUser.class )
//                preparedStatement.setInt(4,1);
//            else
//                preparedStatement.setInt(4,2);
//
////            preparedStatement.setString(5, allUser.securityQ);
////            preparedStatement.setString(6 , allUser.securityA);
//
//            preparedStatement.executeUpdate();
//        }
//
//
//        statement.executeUpdate("truncate posts");
//        preparedStatement = connection.prepareStatement("insert into posts" +
//                "(user_id,content,postDateTime) values (?,?,?)");
//        for (Post allPost : Post.allPosts) {
//            preparedStatement.setInt(1,getId(allPost.user));
//            preparedStatement.setString(2,allPost.text);
//            preparedStatement.setObject(3 , allPost.postTime);
//
//            preparedStatement.executeUpdate();
//        }
//
//        statement.executeUpdate("truncate reactions");
//        preparedStatement = connection.prepareStatement("insert into reactions" +
//                "(post_id,user_id,comment,liked,disliked) values (?,?,?,?,?)");
//
//
//        for (int i = 0; i < Post.allPosts.size(); i++) {
//            for (Reaction reaction : Post.allPosts.get(i).reactions) {
//                reaction.post_id = i + 1;
//                Reaction.reactions.add(reaction);
//            }
//        }
//
//        for (Reaction reaction : Reaction.reactions) {
//            preparedStatement.setInt(1 , reaction.post_id);
//            preparedStatement.setInt(2 , getId(reaction.user));
//            preparedStatement.setString(3 , reaction.comment);
//            preparedStatement.setInt(4,reaction.like);
//            preparedStatement.setInt(5,reaction.dislike);
//
//            preparedStatement.executeUpdate();
//        }
//
//        statement.executeUpdate("truncate followlist");
//        preparedStatement = connection.prepareStatement("insert into followlist" +
//                "(follower_id,followee_id) values (?,?)");
//
//        for (User allUser : User.allUsers) {
//            for (String following : allUser.followings) {
//                User followee = getUser(following);
//                preparedStatement.setInt(1, getId(allUser));
//                preparedStatement.setInt(2, getId(followee));
//                preparedStatement.executeUpdate();
//            }
//        }
//
//        statement.executeUpdate("truncate privatechats");
//        preparedStatement = connection.prepareStatement("insert into privatechats" +
//                "(user1_id,user2_id,text,replied,forwarded,blocked) values (?,?,?,?,?,?)");
//
//        for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
//            for (Chats pvChat : all_secret_chat.thisPVChats) {
//                preparedStatement.setString(1, pvChat.sender);
//                preparedStatement.setString(2, pvChat.receiver);
//                preparedStatement.setString(3,pvChat.text.toString());
//                preparedStatement.setInt(4,pvChat.replied);
//                preparedStatement.setInt(5,pvChat.forwarded);
//                preparedStatement.setInt(6,all_secret_chat.block);
//
//                preparedStatement.executeUpdate();
//            }
//        }
//
//        statement.executeUpdate("truncate allgroups");
//        preparedStatement = connection.prepareStatement("insert into allgroups" +
//                "(groupName,groupAdmin,member,group_id) values (?,?,?,?)");
//
//        for (int i = 0; i < Group.groups.size(); i++) {
//            for (String user : Group.groups.get(i).users) {
//                preparedStatement.setString(1, Group.groups.get(i).name);
//                preparedStatement.setString(2, Group.groups.get(i).admin);
//                preparedStatement.setString(3,user);
//                preparedStatement.setInt(4, i + 1);
//
//                preparedStatement.executeUpdate();
//            }
//        }
//
//        statement.executeUpdate("truncate groupchats");
//        preparedStatement = connection.prepareStatement("insert into groupchats" +
//                "(sender_id,text,group_id,replied,forwarded) values (?,?,?,?,?)");
//
//        for (int i = 0; i < Group.groups.size(); i++) {
//            for (Chats groupChat : Group.groups.get(i).groupChats) {
//                preparedStatement.setString(1,groupChat.sender);
//                preparedStatement.setString(2,groupChat.text.toString());
//                preparedStatement.setInt(3, Integer.parseInt(Group.groups.get(i).id));
//                preparedStatement.setInt(4,groupChat.replied);
//                preparedStatement.setInt(5,groupChat.forwarded);
//                preparedStatement.executeUpdate();
//
//            }
//        }
//
//
//        statement.executeUpdate("truncate groupclosed");
//        preparedStatement = connection.prepareStatement("insert into groupclosed" +
//                "(group_id,banned_user) values (?,?)");
//
//        for (Group group : Group.groups) {
//            for (String closedUser : group.closed_users) {
//                preparedStatement.setString(1 , group.id);
//                preparedStatement.setString(2 , closedUser);
//                preparedStatement.executeUpdate();
//            }
//        }
//
//    }

    public static int getId(User user){

        int id = -1;
        for (int i = 0; i < User.allUsers.size(); i++) {
            if(User.allUsers.get(i).username.equals(user.username))
                id = i + 1;
        }

        return id;
    }

//    public static void postRecommender(PersonalUser personalUser) {
//
//        ArrayList<String> followings = personalUser.followings;
//        ArrayList<User> userFollowings = new ArrayList<>();
//        for (String following : followings) {
//            userFollowings.add(getUser(following));
//        }
//
//        ArrayList<User> sameInterest = new ArrayList<>();
//        for (Post allPost : Post.allPosts) {
//            for (Reaction reaction : allPost.reactions) {
//                if(followings.contains(reaction.user.username)){
//                    //check if personal user has liked or disliked
//                    boolean liked = checkInterest(personalUser,allPost);
//                    if( (liked && reaction.like ==1) || (!liked && reaction.dislike == 1) ){
//                        sameInterest.add(reaction.user);
//                    }
//                }
//            }
//        }
//
//        HashMap<User,Integer> countMap = new HashMap<>();
//        for (User user : sameInterest) {
//            if (countMap.containsKey(user))
//                countMap.put(user, countMap.get(user) + 1);
//            else
//                countMap.put(user, 1);
//
//        }
//
//        HashMap<User,Integer> countMap1 = sortByValue(countMap);
//        sameInterest = (ArrayList<User>) countMap1.keySet().stream().collect(Collectors.toList());
//
//        ArrayList<User> sameInterest1 = new ArrayList<>();
//        for (int i = sameInterest.size() - 1; i >= 0; i--) {
//            sameInterest1.add(sameInterest.get(i));
//        }
//
//        ArrayList<Post> recommendedPost = new ArrayList<>();
//
//
//        for (User user : sameInterest1) {
//            for (Post allPost : Post.allPosts) {
//                if( allPost.user.getClass() == CommercialUser.class ){
//
//                    boolean seenByFollowing = checkHadReaction(user , allPost);
//                    if(seenByFollowing && checkInterest((PersonalUser) user, allPost)) {
//                        boolean seen = checkHadReaction(personalUser, allPost);
//                        if (!seen) {
//                            recommendedPost.add(allPost);
//                        }
//                    }
//
//                }
//            }
//        }
//
//        HashMap<Post,Integer> countMap2 = new HashMap<>();
//        for (Post post : recommendedPost) {
//            if (countMap2.containsKey(post))
//                countMap2.put(post, countMap2.get(post) + 1);
//            else
//                countMap2.put(post, 1);
//
//        }
//
//        HashMap<Post,Integer> countMap3 = sortByValue1(countMap2);
//        recommendedPost = (ArrayList<Post>) countMap3.keySet().stream().collect(Collectors.toList());
//
//
//        ArrayList<Post> recommendedPost1 = new ArrayList<>();
//        for (int i = recommendedPost.size() - 1; i >= 0 ; i--) {
//            recommendedPost1.add(recommendedPost.get(i));
//        }
//        recommendedPost = recommendedPost1;
//
//
//        System.out.println("Recommended Commercial Posts:");
//        for (int i = 0; i < recommendedPost.size(); i++) {
//            System.out.println( (i+1) + " - " + recommendedPost.get(i).user.username + " : " +
//                    recommendedPost.get(i).text + "    " + recommendedPost.get(i).postTime.toLocalDate() + "  "
//                    + recommendedPost.get(i).postTime.toLocalTime());
//        }
//        if(recommendedPost.size() == 0 ) System.out.println("No recommended Commercial Posts!");
//        System.out.println();
//
//
//    }
//
//    private static boolean checkHadReaction(User user, Post allPost) {
//        boolean hadReacted = false;
//        for (Reaction reaction : allPost.reactions) {
//            if(reaction.user.username.equals(user.username)){
//                hadReacted = true;
//            }
//        }
//        return hadReacted;
//    }
//
//    private static boolean checkInterest(PersonalUser personalUser, Post allPost) {
//
//        boolean likes = false;
//        for (Reaction reaction : allPost.reactions) {
//            if(reaction.user.username.equals(personalUser.username)){
//                if(reaction.like == 1)
//                    likes = true;
//            }
//        }
//
//        return likes;
//    }

}