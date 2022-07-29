package Sample;

import java.util.ArrayList;

public class CommercialUser extends User {
    public static ArrayList<CommercialUser> allCommercialUsers = new ArrayList<CommercialUser>();


    public CommercialUser(String username, String password, String bio) {
        super(username, password, bio);
    }

    public CommercialUser() {
    }
    public static int findPU(String uname)
    {
        for (int i=0;i<allCommercialUsers.size();i++)
        {
            if(allCommercialUsers.get(i).username.equals(uname))
            {
                return i;
            }
        }
        return -1;
    }
//    @Override
//    public String toString() {
//        return "CommercialUser{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", followers=" + followers +
//                ", followings=" + followings +
//                ", bio='" + bio + '\'' +
//                '}';
//    }
}


