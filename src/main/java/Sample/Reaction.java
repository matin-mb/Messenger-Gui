package Sample;

import java.util.ArrayList;

public class Reaction {
    public String comment;
    public int like;
    public int dislike;
    public String user;
    //public User user;
    public int post_id;
    public static ArrayList<Reaction> reactions = new ArrayList<>();

    public Reaction() {
    }

    public Reaction(String comment, int like, int dislike, String user) {
        this.comment = comment;
        this.like = like;
        this.dislike = dislike;
        this.user = user;
    }
//public Reaction(String comment, int like, int dislike, User user) {
//    this.comment = comment;
//    this.like = like;
//    this.dislike = dislike;
//    this.user = user;
//}

}
