package org.sandbox.collection.stack;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

	@Test
	public void createANegativeLengthStackTest() {
		assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(-1), 
		        "Should break as negative stack sizes are illegal");
	}
	
	@Test
	public void pushToZeroLengthStackTest() {
		Stack<String> stack = new ArrayStack<>(0);

		assertThrows(IllegalStateException.class, () -> stack.push("element"), 
		        "Pushing an element to a zero stack is illegal");
	}
	
	@Test
	public void pushToEmptyStackTest() {
		String element = "element";
		Stack<String> stack = new ArrayStack<>(1);
		
		assertTrue(stack.size() == 0);
		
		stack.push(element);
		
		assertTrue(stack.size() == 1);
		assertTrue(element.equals(stack.pop().orElseThrow()));
	}
	
	@Test
	public void pushToFullStackTest() {
		Stack<String> stack = new ArrayStack<>(1);
		String element = "element";
		
		stack.push(element);
		
		assertTrue(stack.size() == 1);
		assertThrows(IllegalStateException.class, () -> stack.push(element));
	}
	
	@Test
	public void popFromZeroLengthStackTest() {
		Stack<String> stack = new ArrayStack<>(0);
		
		Optional<String> element = stack.pop();
		
		assertTrue(stack.size() == 0);
		assertTrue(element.isEmpty());
	}
	
	@Test
	public void popFromEmptyStackTest() {
		Stack<String> stack = new ArrayStack<>(1);
		
		Optional<String> element = stack.pop();
		
		assertTrue(stack.size() == 0);
		assertTrue(element.isEmpty());
	}
	
	@Test
	public void popFromFullStackTest() {
		String element = "element";
		Stack<String> stack = new ArrayStack<>(1);
		
		stack.push(element);
		
		assertTrue(stack.size() == 1);
		
		Optional<String> poppedElement = stack.pop();
		
		assertTrue(stack.size() == 0);
		assertTrue(poppedElement.isPresent());
		assertTrue(poppedElement.get().equals(element));
	}
	
	@Test
	public void popAndPushSeveralTimesTest() {
		Stack<String> stack = new ArrayStack<>(2);
		
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
