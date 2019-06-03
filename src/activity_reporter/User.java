package activity_reporter;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<User> followers;

    public User(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public boolean hasFollower(User followerToCheck) {
        return followers.contains(followerToCheck);
    }

}
