import exception.ElementNotFoundException;
import exception.IllegalIndexException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringListImplTest {
    public final StringList stringList = new StringListImpl();


    @AfterEach
    public void afterEach () {
        stringList.clear();
    }

    @Test
    void testAdd() {
        String string0 = "string 0";
        stringList.add(string0);
        Assertions.assertEquals(stringList.size(), 1);
        Assertions.assertEquals(stringList.get(0), ("string 0"));


    }

    @Test
    void testAddByIndex() {
        stringList.add(0, "string 0");
        stringList.add(1, "string 1");
        Assertions.assertEquals(stringList.size(), 2);
        Assertions.assertEquals(stringList.get(0), ("string 0"));
        stringList.add(1, "string new1");
        Assertions.assertEquals(stringList.size(), 3);
        Assertions.assertEquals(stringList.get(1), ("string new1"));
        Assertions.assertEquals(stringList.get(2), ("string 1"));
    }

    @Test
    void testSet() {
        stringList.add(0, "string 0");
        stringList.set(0,"string new1" );
        Assertions.assertEquals(stringList.get(0), ("string new1"));


    }

    @Test
    void testRemove() {
        stringList.add ("string 0");
        stringList.add ("string 1");
        stringList.remove("string 1");
        Assertions.assertEquals(stringList.size(), 1);
        Assertions.assertEquals(stringList.get(1), null);
        Assertions.assertThrows(ElementNotFoundException.class, () -> {
            stringList.remove("string 1");});

    }

    @Test
    void testRemoveByIndex() {
        stringList.add(0, "string 0");
        stringList.add(1, "string 1");
        stringList.remove(0);
        Assertions.assertEquals(stringList.size(), 1);
        Assertions.assertEquals(stringList.get(0), "string 1");
        Assertions.assertEquals(stringList.get(1), null);

    }

    @Test
    void testContains() {
        stringList.add("s");
        Assertions.assertEquals(stringList.size(), 1);
       Assertions.assertEquals(stringList.contains("s"), true);
       Assertions.assertEquals(stringList.contains("string 10"), false);
    }

    @Test
    void testIndexOf() {
        stringList.add(0, "string 0");
        Assertions.assertEquals(stringList.indexOf("string 0"), 0);
        Assertions.assertEquals(stringList.indexOf("s"), -1);
    }

    @Test
    void testLastIndexOf() {
        stringList.add(0, "string 20");
        stringList.add(1, "string 21");
        Assertions.assertEquals(stringList.lastIndexOf("string 20"), 0);
        Assertions.assertEquals(stringList.lastIndexOf("string 21"), 1);
        Assertions.assertEquals(stringList.lastIndexOf("s"), -1);
    }

    @Test
    void testGet() {
        stringList.add(0, "string 0");
        stringList.add(1, "string 1");
        Assertions.assertEquals(stringList.get(0), "string 0");
        Assertions.assertEquals(stringList.get(1), "string 1");
        Assertions.assertEquals(stringList.get(2), null);

       Assertions.assertThrows(IllegalIndexException.class, () -> {
           stringList.get(-1);});
        Assertions.assertThrows(IllegalIndexException.class, () -> {
            stringList.get(3);});

    }



    @Test
    void testSize() {
        stringList.add(0, "string 0");
        stringList.add(1, "string 1");
        Assertions.assertEquals(stringList.size(), 2);
    }

    @Test
    void testIsEmpty() {
        Assertions.assertEquals(stringList.isEmpty(), true);
        stringList.add(0, "string 1");
        Assertions.assertEquals(stringList.isEmpty(), false);
    }

    @Test
    void testClear() {
        stringList.add(0, "string 1");
        Assertions.assertEquals(stringList.size(), 1);
        stringList.clear();
        Assertions.assertEquals(stringList.size(), 0);
    }

}