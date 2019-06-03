package activity_reporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void addFollower_shouldAddFollowerToAlice_whenBobFollowsAlice(){
        User bob = new User("Bob");
        User alice = new User("Alice");

        alice.addFollower(bob);

        assertTrue(alice.hasFollower(bob));

    }
}