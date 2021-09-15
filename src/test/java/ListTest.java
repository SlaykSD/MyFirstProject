import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void add() {
        List list = new List();
        list.add(1);
        list.add(10);
        Object expected1 = list.get(0);
        Object expected2 = list.get(1);
        Object actual1  = 1;
        Object actual2  = 10;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        list.add(132,3);
        list.add(213,1231);
        list.add(null, -1);
        list.add(null, 1);
        Object actual3  = 10;
        Object expected3 = list.get(2);
        assertEquals(expected3, actual3);
    }

    @Test
    void remove() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        list.add(null);
        list.add(2.123);
        list.remove(0);
        Object actual  = 123;
        Object expected = list.get(0);
        assertEquals(expected, actual);
        list.remove(1);
        actual = null;
        expected = list.get(2);
        assertEquals(expected, actual);
        list.remove(list.size()-1);
        list.remove(0);
        assertEquals(list.size(), 0);
    }


    @Test
    void set() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        list.add(null);
        list.add(2.123);
        list.set(0, "nya hello");
        assertEquals( list.get(0),"nya hello");
        list.set(124,"not exist");
        assertEquals(list.get(124), null);
    }

    @Test
    void get() {
        List list = new List();
        list.add(1);
        list.add(10);
        Object expected1 = list.get(0);
        Object expected2 = list.get(1);
        Object actual1  = 1;
        Object actual2  = 10;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void indexOf() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        list.add(2.123);
        assertEquals(2,list.indexOf(2.123));
        assertEquals(0,list.indexOf("hello world"));
        assertEquals(-1,list.indexOf("Blackjack") );
    }

    @Test
    void contains() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        list.add(2.123);
        assertEquals(true,list.contains(123));
        assertEquals(true, list.contains(2.123));
        assertEquals(false, list.contains("Baka"));
    }

    @Test
    void size() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        assertEquals(2, list.size());
        list.remove(1);
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        List list = new List();
        list.add("hello world");
        list.add(123);
        assertEquals(false, list.isEmpty());
        list.remove(0);
        list.remove(0);
        assertEquals(true ,list.isEmpty());
    }
}