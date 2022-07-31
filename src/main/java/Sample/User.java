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
