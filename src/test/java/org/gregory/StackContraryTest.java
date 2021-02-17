package org.gregory;

import org.gregory.contrary.StackContrary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackContraryTest {

    StackContrary stackString;
    StackContrary stackDouble;
    StackContrary stackStringEmpty;
    StackContrary stackDoubleEmpty;


    @BeforeEach
    void setUp() {
        stackDouble = new StackContrary<Double>(Double.class);
        stackDouble.push(1.1);
        stackDouble.push(2.2);
        stackDouble.push(3.3);
        stackDouble.push(4.4);
        stackDouble.push(5.5);

        stackString = new StackContrary<String>(String.class);

        stackString.push("1");
        stackString.push("2");
        stackString.push("3");
        stackString.push("4");
        stackString.push("5");

        stackDoubleEmpty = new StackContrary<Double>(Double.class);
        stackStringEmpty = new StackContrary<String>(String.class);
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
        assertThat(stackDouble.pop(), is(1.1));
        assertThat(stackDouble.pop(), is(2.2));
        assertThat(stackDouble.pop(), is(3.3));
        assertThat(stackDouble.size(), is(2));
        assertThat(stackDouble.pop(), is(4.4));
        assertThat(stackDouble.pop(), is(5.5));
        assertThat(stackDouble.pop(), nullValue());
        assertThat(stackDouble.size(), is(0));
        assertThat(stackDouble, is(stackDoubleEmpty));

        assertThat(stackString.pop(), is("1"));
        assertThat(stackString.pop(), is("2"));
        assertThat(stackString.pop(), is("3"));
        assertThat(stackString.size(), is(2));
        assertThat(stackString.pop(), is("4"));
        assertThat(stackString.pop(), is("5"));
        assertThat(stackString.size(), is(0));
        assertThat(stackString.pop(), nullValue());

        assertThat(stackString, is(stackStringEmpty));
    }

    @Test
    void peek() {
        assertThat(stackDouble.peek(), is(1.1));
        assertThat(stackDouble.size(), is(5));
        assertThat(stackString.peek(), is("1"));
        assertThat(stackString.size(), is(5));
    }

    @Test
    void classDoNotMatch() {
        assertThrows(
                ClassCastException.class,
                () -> stackDoubleEmpty.push("123")
        );
    }
}