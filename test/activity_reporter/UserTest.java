package activity_reporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void hasFollower_shouldReturnTrue_whenBobFollowsAlice(){
        User bob = new User("Bob");
        User alice = new User("Alice");

        alice.addFollower(bob);

        assertTrue(alice.hasFollower(bob));

    }

    @Test
    public void hasFollower_shouldReturnFalse_whenBobDoesNotFollowsAlice(){
        User bob = new User("Bob");
        User alice = new User("Alice");

        assertFalse(alice.hasFollower(bob));

    }
}