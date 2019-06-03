package activity_reporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void hasFollower_shouldReturnTrue_whenBobFollowsAlice() {
        User alice = new User("Alice");
        User bob = new User("Bob");

        alice.addFollower(bob);

        assertTrue(alice.hasFollower(bob));

    }

    @Test
    public void hasFollower_shouldReturnFalse_whenBobDoesNotFollowsAlice() {
        User alice = new User("Alice");
        User bob = new User("Bob");

        assertFalse(alice.hasFollower(bob));

    }

    @Test
    public void addFollower_shouldAddJohnAndBobAsFollower_whenBothFollowsAlice() {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User john = new User("John");


        alice.addFollower(bob);
        alice.addFollower(john);

        assertTrue(alice.hasFollower(bob));
        assertTrue(alice.hasFollower(john));
    }

    @Test
    public void addFollower_shouldThrowUserIsAlreadyFollowing_whenBobTryToFollowAliceTwice() {
        User alice = new User("Alice");
        User bob = new User("Bob");

        alice.addFollower(bob);

        assertThrows(UserIsAlreadyFollowing.class, () -> {
            alice.addFollower(bob);
        });
    }

    @Test
    public void addFollower_shouldThrowSelfFollowingNotAllowed_whenAliceTryToFollowHimself() {
        User alice = new User("Alice");

        assertThrows(SelfFollowingNotAllowed.class, () -> {
            alice.addFollower(alice);
        });
    }

}