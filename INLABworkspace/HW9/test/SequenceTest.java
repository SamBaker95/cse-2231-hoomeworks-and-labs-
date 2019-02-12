import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /*
     * Test StackKernel constructor(s) and methods. Note: these are just some
     * sample test cases, not complete nor systematic.
     */

    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testLengthNonEmpty() {
        /*
         * Set up variables
         */
        Sequence<String> s = this.createFromArgsTest("red", "blue");
        Sequence<String> sExpected = this.createFromArgsRef("red", "blue");
        /*
         * Call method under test
         */
        int i = s.length();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(2, i);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddNonEmpty() {
        /*
         * Set up variables
         */
        Sequence<String> s = this.createFromArgsTest("red", "blue");
        Sequence<String> sExpected = this.createFromArgsRef("green", "red",
                "blue");
        /*
         * Call method under test
         */
        s.add(0, "green");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testPopLeavingEmpty() {
        /*
         * Set up variables
         */
        Sequence<String> s = this.createFromArgsTest("red");
        Sequence<String> sExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        String x = s.remove(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("red", x);
    }

}