package p01;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreCollectionTest {
    @Test
    public void arithmeticMeanOfFiveAndSevenResultsInSix() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);
        int actualResult = collection.arithmeticMean();
        assertEquals(6, actualResult);
    }

    @Test
    public void arithmeticMeanOfTenAndTwentyResultsInFifteen() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 10);
        collection.add(() -> 20);
        int actualResult = collection.arithmeticMean();
        assertEquals(15, actualResult);
    }

}