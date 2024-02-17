package assign03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimplePriorityQueueTest {

    private SimplePriorityQueue<Integer> integerQueue;
    private SimplePriorityQueue<String> stringQueue;
    private SimplePriorityQueue<String> length;
    
    protected class OrderByLength implements Comparator<String> {

		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
    	
    }
    
    @BeforeEach
    void setUp() {
    	this.integerQueue = new SimplePriorityQueue<Integer>();
    	this.stringQueue = new SimplePriorityQueue<String>();
    	this.length = new SimplePriorityQueue<String>(new OrderByLength());
    }
   
    @Test
    void testInsertAndFindMaxByLength() {
    	length.insert("Bob");
    	length.insert("Billy");
    	length.insert("Ty");
    	length.insert("A");
    	length.insert("Anthony");
    	
    	assertEquals("Anthony", length.findMax());
    }
    
    @Test
    void testInsertAndDeleteByLength2() {
    	length.insert("");
    	length.insert("Billy");
    	length.insert("Ty");
    	length.insert("A");
    	length.insert("Anthony");
    	
    	assertEquals("Anthony", length.deleteMax());
    	assertEquals("Billy",length.findMax());
    }
    

    @Test
    void testInsertAndFindMax() {
        integerQueue.insert(10);
        integerQueue.insert(5);
        integerQueue.insert(20);

        assertEquals(20, integerQueue.findMax());
    }
    @Test
    void testInsertAndFindMax2() {
        stringQueue.insert("bob");
        stringQueue.insert("Nathan");
        stringQueue.insert("alex");
        stringQueue.insert("Nathan B");
        
        assertEquals("bob", stringQueue.findMax());
    }

    @Test
    void testInsertAndDeleteMax() {
        stringQueue.insert("Apple");
        stringQueue.insert("Banana");
        stringQueue.insert("Orange");

        assertEquals("Orange", stringQueue.deleteMax());
        assertEquals("Banana", stringQueue.findMax());
    }

    @Test
    void testInsertAll() {
        Collection<Integer> integers = Arrays.asList(30, 15, 40);
        integerQueue.insertAll(integers);

        assertEquals(40, integerQueue.findMax());
    }

    @Test
    void testContains() {
        assertFalse(stringQueue.contains("Grapes"));

        stringQueue.insert("Grapes");
        assertTrue(stringQueue.contains("Grapes"));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(integerQueue.isEmpty());

        integerQueue.insert(25);
        integerQueue.insert(35);

        assertEquals(2, integerQueue.size());
        assertFalse(integerQueue.isEmpty());
    }

    @Test
    void testClear() {
        integerQueue.insert(5);
        integerQueue.insert(10);

        assertFalse(integerQueue.isEmpty());

        integerQueue.clear();

        assertTrue(integerQueue.isEmpty());
    }

    @Test
    void testEmptyQueueFindMaxException() {
        assertThrows(NoSuchElementException.class, () -> integerQueue.findMax());
    }

    @Test
    void testEmptyQueueDeleteMaxException() {
        assertThrows(NoSuchElementException.class, () -> integerQueue.deleteMax());
    }
}
