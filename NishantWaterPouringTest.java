import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NishantWaterPouringTest {

    NishantWaterPouring wp = new NishantWaterPouring();

    @Test
    public void test1() {
        int[] capacities = {2, 5, 6, 72};
        int target = 143;
        assertEquals(15, wp.nishantSolve(capacities, target));
    }

    @Test
    public void test2() {
        int[] capacities = {2, 3, 5, 19, 121, 852};
        int target = 11443;
        assertEquals(2711, wp.nishantSolve(capacities, target));
    }

    @Test
    public void test3() {
        int[] capacities = {3, 5, 8};
        int target = 2; // Impossible target
        assertEquals(1, wp.nishantSolve(capacities, target));
    }

    @Test
    public void test4() {
        int[] capacities = {10, 15};
        int target = 10; // Easy target
        assertEquals(1, wp.nishantSolve(capacities, target));
    }
}
