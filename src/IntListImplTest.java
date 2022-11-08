import exception.ElementNotFoundException;
import exception.IllegalIndexException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class IntListImplTest {
    public final IntList intList = new IntListImpl();

    @AfterEach
    public void afterEach () {
        intList.clear();
    }

    @Test
    void testAdd() {
        Integer num0 = 0;
        intList.add(num0);
        Assertions.assertEquals(intList.size(), 1);
        Assertions.assertEquals(intList.get(0), 0);


    }

    @Test
    void testAddByIndex() {
        intList.add(0, 0);
        intList.add(1, 1);
        Assertions.assertEquals(intList.size(), 2);
        Assertions.assertEquals(intList.get(0), 0);
        intList.add(1, 10);
        Assertions.assertEquals(intList.size(), 3);
        Assertions.assertEquals(intList.get(1), 10);
        Assertions.assertEquals(intList.get(2), 1);
    }


    @Test
    void testSet() {
        intList.add(0, 0);
        intList.set(0,10);
        Assertions.assertEquals(intList.get(0), 10);
    }

    @Test
    void testRemove() {
        Integer num0 = 0;
        Integer num10 = 10;
        intList.add (num0);
        intList.add (num10);
        intList.remove(num10);
        Assertions.assertEquals(intList.size(), 1);
        Assertions.assertEquals(intList.get(1), null);
        Assertions.assertThrows(ElementNotFoundException.class, () -> {
            intList.remove(num10);});
    }

    @Test
    void testRemoveByIndex() {
        intList.add(0, 0);
        intList.add(1, 1);
        intList.remove(0);
        Assertions.assertEquals(intList.size(), 1);
        Assertions.assertEquals(intList.get(0), 1);
        Assertions.assertEquals(intList.get(1), null);
    }

    @Test
    void testContains() {
        intList.add(20);
        Assertions.assertEquals(intList.size(), 1);
        Assertions.assertEquals(intList.contains(20), true);
        Assertions.assertEquals(intList.contains(30), false);
    }

    @Test
    void testIndexOf() {
        intList.add(0, 12);
        Assertions.assertEquals(intList.indexOf(12), 0);
        Assertions.assertEquals(intList.indexOf(2), -1);
    }

    @Test
    void testLastIndexOf() {
        intList.add(0, 20);
        intList.add(1, 21);
        Assertions.assertEquals(intList.lastIndexOf(20), 0);
        Assertions.assertEquals(intList.lastIndexOf(21), 1);
        Assertions.assertEquals(intList.lastIndexOf(22), -1);
    }

    @Test
    void testGet() {
        intList.add(0, 20);
        intList.add(1, 21);
        Assertions.assertEquals(intList.get(0), 20);
        Assertions.assertEquals(intList.get(1), 21);
        Assertions.assertEquals(intList.get(2), null);

        Assertions.assertThrows(IllegalIndexException.class, () -> {
            intList.get(-1);});
        Assertions.assertThrows(IllegalIndexException.class, () -> {
            intList.get(3);});
    }


    @Test
    void testSize() {
        intList.add(0, 0);
        intList.add(1, 1);
        Assertions.assertEquals(intList.size(), 2);
    }

    @Test
    void TestIsEmpty() {
        Assertions.assertEquals(intList.isEmpty(), true);
        intList.add(0, 1);
        Assertions.assertEquals(intList.isEmpty(), false);
    }

    @Test
    void testClear() {
        intList.add(0, 1);
        Assertions.assertEquals(intList.size(), 1);
        intList.clear();
        Assertions.assertEquals(intList.size(), 0);
    }


    @Test
    void sort() {
        intList.add(0, 0);
        intList.add(1, 480);
        intList.add(2, 348);
        intList.add(3, 2);
        intList.sort();
        Assertions.assertEquals(Arrays.toString(intList.toArray()), "[0, 2, 348, 480]");

    }

    @Test
    void binarySearch() {
        intList.add(0, 0);
        intList.add(1, 480);
        intList.add(2, 348);
        intList.add(3, 2);
        Assertions.assertEquals(intList.binarySearch((intList.toArray()),480), true);
        Assertions.assertEquals(intList.binarySearch((intList.toArray()),481), false);

    }


}