package Sample;

public class Reaction {
    public String comment;
    public int like;
    public int dislike;
    public String user;

    public Reaction() {
    }

    public Reaction(String comment, int like, int dislike, String user) {
        this.comment = comment;
        this.like = like;
        this.dislike = dislike;
        this.user = user;
    }

}
