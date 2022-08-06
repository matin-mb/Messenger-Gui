package Sample;

import java.util.ArrayList;

public class Group {
    public String name;
    public String admin;
    public String id;
    public String profile_address;
    public ArrayList<String> closed_users = new ArrayList<String>();
    public ArrayList<String > users = new ArrayList<String>();
    public static ArrayList<Group> groups = new ArrayList<Group>();
    public ArrayList<Chats> groupChats = new ArrayList<Chats>();


}
