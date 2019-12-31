import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {
    @org.junit.jupiter.api.Test
    public void sum() throws Exception {
        Numbers numbers = new Numbers();
        int actual = numbers.sum(5);
        int expected = 15;
        assertEquals(expected, actual);
    }
}