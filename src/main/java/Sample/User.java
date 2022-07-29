package Sample;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public String username;
    public String password;
    public ArrayList<String> followers = new ArrayList<>();
    public ArrayList<String> followings = new ArrayList<>();
    public String bio;
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, String bio) {
        this.username = username;
        this.password = password;
        this.bio = bio;
    }

    public User() {
    }

//    public void follow(){
//
//        System.out.println("Here you can follow new people! (0: Back to HomePage)");
//        boolean repeatFollow = true;
//
//        while (repeatFollow) {
//
//            Firstpage.printNewPeople(followings , username);
//
//            System.out.println("Enter username to follow (0: Back to HomePage )\n(e.g. 'Follow mahdi23') ");
//            String command = scanner.nextLine();
//            String[] splitted = command.split(" ");
//
//            if(splitted[0].equals("Follow")) {
//                String username = splitted[1];
////                for (PersonalUser allPersonalUser : PersonalUser.allPersonalUsers) {
////                    if(username.equals(allPersonalUser.username)) {
////                        followings.add(allPersonalUser);
////                        System.out.println("Followed successfully!");
////                    }
////                }
//                for (User allUser : User.allUsers) {
//                    if(username.equals(allUser.username)){
//                        followings.add(allUser.username);
//                        allUser.followers.add(username);
//                        System.out.println("Followed successfully!");
//                    }
//                }
//
//            }
//            else {
//                repeatFollow = false;
//            }
//
//        }
//
//
//    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", followers=" + followers +
                ", followings=" + followings +
                ", bio='" + bio + '\'' +
                '}';
    }
}
