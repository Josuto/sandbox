package org.sandbox.collection.stack;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the logic of {@link ListStack}.
 * <p>
 * Since {@link ListStack} is less restrictive than {@link ArrayStack} from a
 * semantic perspective (the main difference between the two is that the latter
 * includes the notion of 'full stack'), the methods of this test class could be
 * reused in {@link ArrayStackTest}. Thus, we could promote this class to become
 * a {@link Stack} testing superclass that specifies parameterized test methods.
 * We could then use JUnit 5 data provider methods to feed the parameterized
 * tests with initialized concrete types of {@link Stack} and run them. However,
 * this solution (1) may obscure the executable documentation of the
 * {@link Stack} infrastructure for its reader and (2) may not be coherent for
 * the validation of future {@link Stack} implementations. Therefore, we keep it
 * as it currently is.
 * 
 * @author josumartinez
 *
 */
public class ListStackTest {

	@Test
	public void pushToEmptyStackTest() {
		Stack<String> stack = new ListStack<>();
		
		assertTrue(stack.size() == 0);
		
		stack.push("element");
		
		assertTrue(stack.size() == 1);
		assertTrue("element".equals(stack.pop().orElseThrow()));
	}
	
	@Test
	public void pushToNotEmptyStackTest() {
	    Stack<String> stack = new ListStack<>();
		
		stack.push("element1");
		
		assertTrue(stack.size() == 1);
		
		stack.push("element2");
		
		assertTrue(stack.size() == 2);
		assertTrue("element2".equals(stack.pop().orElseThrow()));
	}
	
	@Test
	public void popFromEmptyStackTest() {
	    Stack<String> stack = new ListStack<>();
		
	    assertTrue(stack.size() == 0);
	    
		Optional<String> element = stack.pop();
		
		assertTrue(stack.size() == 0);
		assertTrue(element.isEmpty());
	}
	
	@Test
	public void popFromNotEmptyStackTest() {
		Stack<String> stack = new ListStack<>();
		
		stack.push("element1");
		
		assertTrue(stack.size() == 1);
		
		Optional<String> poppedElement = stack.pop();
		
		assertTrue(stack.size() == 0);
		assertTrue("element1".equals(poppedElement.orElseThrow()));
	}
	
	@Test
    public void popAndPushSeveralTimesTest() {
	    Stack<String> stack = new ListStack<>();
        
        assertTrue(stack.size() == 0);
        stack.push("element1");
        assertTrue(stack.size() == 1);
        stack.push("element2");
        assertTrue(stack.size() == 2);
        Optional<String> poppedElement = stack.pop();
        assertTrue(stack.size() == 1);
        assertTrue("element2".equals(poppedElement.orElseThrow()));
        stack.push("element3");
        assertTrue(stack.size() == 2);
        poppedElement = stack.pop();
        assertTrue(stack.size() == 1);
        assertTrue("element3".equals(poppedElement.orElseThrow()));
        poppedElement = stack.pop();
        assertTrue(stack.size() == 0);
        assertTrue("element1".equals(poppedElement.orElseThrow()));
    }
	
}
