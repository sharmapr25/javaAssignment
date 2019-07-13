package probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    public void equals_shouldReturnTrue_whenGivenTwoProbabilitiesAreEqual(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.5);

        assertEquals(probability1, probability2);
    }

    @Test
    public void equals_shouldReturnFalse_whenGivenTwoProbabilitiesAreNotEqual(){
        Probability probability1 = new Probability(0.5);
        Probability probability2 = new Probability(0.6);

        assertNotEquals(probability1,probability2);
    }

    @Test
    public void compareWith_shouldReturnOne_whenGivenProbabilityIsGreaterThanAnotherProbability(){
        Probability probability1 = new Probability(0.6);
        Probability probability2 = new Probability(0.4);
        assertEquals(1, probability1.compareWith(probability2));
    }

    @Test
    public void compareWith_shouldReturnMinusOne_whenGivenProbabilityIsLessThanAnotherProbability(){
        Probability probability1 = new Probability(0.4);
        Probability probability2 = new Probability(0.6);
        assertEquals(-1, probability1.compareWith(probability2));
    }

    @Test
    public void compareWith_shouldReturnZero_whenGivenProbabilityIsSameAsAnotherProbability(){
        Probability probability1 = new Probability(0.6);
        Probability probability2 = new Probability(0.6);
        assertEquals(0, probability1.compareWith(probability2));
    }
}