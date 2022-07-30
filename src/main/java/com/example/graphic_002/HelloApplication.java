package com.example.graphic_002;

import Sample.CommercialUser;
import Sample.PersonalUser;
import Sample.Post;
import Sample.Reaction;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage mainStage ;

    @Override
    public void start(Stage stage) throws IOException {
        PersonalUser tempUser = new PersonalUser();
        tempUser.username = "parsann";
        tempUser.password = "1234567l";
        tempUser.bio = "I'm 19 from Sabzevar!";
        PersonalUser.allPersonalUsers.add(tempUser);

        PersonalUser tempUser2 = new PersonalUser();
        tempUser2.username = "matin";
        tempUser2.password = "12345678";
        tempUser2.bio = "I'm 19";
        PersonalUser.allPersonalUsers.add(tempUser2);

        CommercialUser tempUser3 = new CommercialUser();
        tempUser3.username="jemco";
        tempUser3.password="1234567j";
        CommercialUser.allCommercialUsers.add(tempUser3);



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
                                        button00555.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                            ListView listView00001 = new ListView();
                                            ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                            Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                            int count=0;
                                            for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(j).like==1)
                                                {
                                                    Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user);
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
                                        button00666.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                            ListView listView00001 = new ListView();
                                            ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                            Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                            int count=0;
                                            for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(j).dislike==1)
                                                {
                                                    Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user);
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
                                        button00555.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                            ListView listView00001 = new ListView();
                                            ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                            Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                            int count=0;
                                            for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(j).like==1)
                                                {
                                                    Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user);
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
                                        button00666.setOnAction(w->{
                                            AnchorPane anchorPane00001 = new AnchorPane();
                                            ListView listView00001 = new ListView();
                                            ScrollPane scrollPane00001 = new ScrollPane(anchorPane00001);
//                                                listView00001.setLayoutX(100);
//                                                listView00001.setLayoutY(50);

                                            Scene scene00001111 = new Scene(scrollPane00001,700,700);
                                            int count=0;
                                            for (int j=-1+Post.allPosts.get(finalI).reactions.size();j>=0;j--)
                                            {
                                                if(Post.allPosts.get(finalI).reactions.get(j).dislike==1)
                                                {
                                                    Label label0 = new Label(String.valueOf(++count)+". "+Post.allPosts.get(finalI).reactions.get(j).user);
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

    public static void main(String[] args) {
        launch();
    }
}