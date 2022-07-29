package Sample;//import java.util.ArrayList;
//
//public class PersonalUser extends User {
//    static ArrayList<PersonalUser> allPersonalUsers = new ArrayList<PersonalUser>();
//
//    public String emailAddress;
//
//
//
//
//}
import java.util.ArrayList;

public class PersonalUser extends User {
    public static ArrayList<PersonalUser> allPersonalUsers = new ArrayList<PersonalUser>();
    public String emailAddress;

    public PersonalUser(String username, String password, String bio) {
        super(username, password, bio);
    }

    public PersonalUser() {
    }
    public static int findPU(String uname)
    {
        for (int i=0;i<allPersonalUsers.size();i++)
        {
            if(allPersonalUsers.get(i).username.equals(uname))
            {
                return i;
            }
        }
        return -1;
    }

}
