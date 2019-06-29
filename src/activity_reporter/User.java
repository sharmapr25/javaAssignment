package activity_reporter;

import java.util.ArrayList;
import java.util.List;

public class User implements FollowerObserver {

    private String name;
    private List<User> followers;

    public User(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
    }

    public void addFollower(User follower) {
        if (this.equals(follower)) {
            throw new SelfFollowingNotAllowed();
        }
        if (hasFollower(follower)) {
            throw new UserIsAlreadyFollowing();
        }
        followers.add(follower);
    }

    public boolean hasFollower(User followerToCheck) {
        return followers.contains(followerToCheck);
    }

    public void uploadPhoto(Photo photo) {
        followers.forEach(User::notifyPhotoUploaded);
    }

    @Override
    public void notifyPhotoUploaded() {

    }
}
