package org.gregory;

import org.gregory.standart.Stack;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class StackTest {
    Stack stackString;
    Stack stackDouble;
    Stack stackStringEmpty;
    Stack stackDoubleEmpty;


    @BeforeEach
    void setUp() {
        stackDouble = new Stack<Double>();
        stackDouble.push(1.1);
        stackDouble.push(2.2);
        stackDouble.push(3.3);
        stackDouble.push(4.4);
        stackDouble.push(5.5);

        stackString = new Stack<String>();

        stackString.push("1");
        stackString.push("2");
        stackString.push("3");
        stackString.push("4");
        stackString.push("5");

        stackDoubleEmpty = new Stack<Double>();
        stackStringEmpty = new Stack<String>();
    }

    @AfterEach
    void tearDown() {
        stackString = null;
        stackDouble = null;
        stackStringEmpty = null;
        stackDoubleEmpty = null;
    }

    @Test
    void size() {
        assertThat(stackDouble.size(), is(5));
        assertThat(stackString.size(), is(5));
    }

    @Test
    void pop() {
        assertThat(stackDouble.pop(), is(5.5));
        assertThat(stackDouble.pop(), is(4.4));
        assertThat(stackDouble.pop(), is(3.3));
        assertThat(stackDouble.size(), is(2));
        assertThat(stackDouble.pop(), is(2.2));
        assertThat(stackDouble.pop(), is(1.1));
        assertThat(stackDouble.pop(), nullValue());
        assertThat(stackDouble.size(), is(0));
        assertThat(stackDouble, is(stackDoubleEmpty));

        assertThat(stackString.pop(), is("5"));
        assertThat(stackString.pop(), is("4"));
        assertThat(stackString.pop(), is("3"));
        assertThat(stackString.size(), is(2));
        assertThat(stackString.pop(), is("2"));
        assertThat(stackString.pop(), is("1"));
        assertThat(stackString.size(), is(0));
        assertThat(stackString.pop(), nullValue());

        assertThat(stackString, is(stackStringEmpty));
    }

    @Test
    void peek() {
        assertThat(stackDouble.peek(), is(5.5));
        assertThat(stackDouble.size(), is(5));
        assertThat(stackString.peek(), is("5"));
        assertThat(stackString.size(), is(5));
    }

    @Test
    void getTop() {
        assertThat(stackDouble.getTop().getValue(), is(5.5));
        assertThat(stackString.getTop().getValue(), is("5"));
    }

}