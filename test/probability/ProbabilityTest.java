package probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    public void isEqual_shouldReturnTrue_whenGivenTwoProbabilitiesAreEqual(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.5);

        assertTrue(probability1.equals(probability2));
    }

    @Test
    public void isEqual_shouldReturnFalse_whenGivenTwoProbabilitiesAreNotEqual(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.6);

        assertFalse(probability1.equals(probability2));
    }
}