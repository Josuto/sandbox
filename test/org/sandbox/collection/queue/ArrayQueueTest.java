package org.sandbox.collection.queue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

	@Test
	public void createANegativeLengthQueueTest() {
		assertThrows(IllegalArgumentException.class, () -> new ArrayQueue<String>(-1));
	}
	
	@Test
    public void enqueueIntoZeroLengthQueueTest() {
        Queue<String> queue = new ArrayQueue<String>(0);
        
        assertThrows(IllegalStateException.class, () -> queue.enqueue("element"), 
                "Adding an element to a zero length queue is illegal");
    }
	
	@Test
	public void enqueueIntoEmptyQueueTest() {
		Queue<String> queue = new ArrayQueue<String>(1);
		String element = "element";
		
		assertTrue(queue.size() == 0, "The queue must be empty");
		
		queue.enqueue(element);
		
		assertTrue(queue.size() == 1, "The queue must include one element");
		Optional<String> enqueuedElement = queue.dequeue();
		assertTrue(element.equals(enqueuedElement.orElseThrow()), 
		        "The queue must include one element");
	}
	
	@Test
	public void enqueueIntoFullQueueTest() {
	    Queue<String> queue = new ArrayQueue<String>(1);
	    
	    queue.enqueue("element1");
        
        assertThrows(IllegalStateException.class, () -> queue.enqueue("element2"), 
                "Adding an element to a full queue is illegal");
	}
	
	@Test
    public void dequeueFromZeroLengthQueueTest() {
        Queue<String> queue = new ArrayQueue<String>(0);
        
        Optional<String> element = queue.dequeue();
        
        assertTrue(element.isEmpty(), "There must be no element to dequeue");
    }
	
	@Test
	public void dequeueFromEmptyQueueTest() {
	    Queue<String> queue = new ArrayQueue<String>(1);
	    
	    Optional<String> element = queue.dequeue();
	    
	    assertTrue(element.isEmpty(), "The queue must be empty");
	}
	
	@Test
	public void dequeueFromFullQueueTest() {
	    Queue<String> queue = new ArrayQueue<String>(1);
        String element = "element";
	    
	    queue.enqueue(element);
        Optional<String> dequeuedElement = queue.dequeue();
        
        assertTrue(dequeuedElement.orElseThrow().equals(element), 
                "The dequeued element must be that that was enqueued");
	}
	
	@Test
	public void enqueueAndDequeueSeveralTimesTest() {
	    Queue<String> queue = new ArrayQueue<String>(2);
	    
	    assertTrue(queue.size() == 0, "The queue must be empty");
	    queue.enqueue("element1");
	    assertTrue(queue.size() == 1, "The queue must include one element");
	    queue.enqueue("element2");
	    assertTrue(queue.size() == 2, "The queue must include two elements");
	    Optional<String> dequeuedElement = queue.dequeue();
	    assertTrue(queue.size() == 1, "The queue must include one element");
	    assertEquals("element1", dequeuedElement.orElseThrow());
	    queue.enqueue("element3");
	    assertTrue(queue.size() == 2, "The queue must include two elements");
	    dequeuedElement = queue.dequeue();
	    assertTrue(queue.size() == 1, "The queue must include one element");
	    assertEquals("element2", dequeuedElement.orElseThrow());
	    queue.enqueue("element4");
	    assertTrue(queue.size() == 2, "The queue must include two elements");
	}

}
