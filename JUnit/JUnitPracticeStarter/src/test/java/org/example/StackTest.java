package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StackTest {
	public Stack<String> stack;

	@Nested
	public class whenNew {

		@BeforeEach
		public void createNewStack() {
			stack = new Stack<>();
		}

		@Test
		public void isEmpty() {
			assertTrue(stack.isEmpty());
		}

		@Test
		public void throwsExceptionWhenPopped() {
			assertThrows(EmptyStackException.class, () -> stack.pop());
		}

		@Nested
		public class afterPushing {
			private final String anElement = "要素1";

			@BeforeEach
			public void pushAnElement() {
				stack.push(anElement);
			}

			@Test
			public void isNotEmpty() {
				assertFalse(stack.isEmpty());
			}

			@Test
			public void returnElementWhenPopped() {
				assertEquals(anElement, stack.pop());
			}
		}
	}
}
