import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map.Pair;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> m = this.constructorTest();
        Map<String, String> mExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mExpected, m);
    }

    @Test
    public final void testNewInstanceNonEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m1 = this.createFromArgsTest("red", "blue");
        Map<String, String> m1Expected = this.createFromArgsRef("red", "blue");
        Map<String, String> m2Expected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        Map<String, String> m2 = m1.newInstance();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(m2Expected, m2);
        assertEquals(m1.getClass(), m2.getClass());
        assertEquals(m1Expected, m1);
    }

    @Test
    public final void testAddNonEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("Pair number", "1",
                "Pair number", "2");
        Map<String, String> mExpected = this.createFromArgsRef("Pair number",
                "1", "Pair number", "2", "Addition", "3");
        /*
         * Call method under test
         */
        m.add("Addition", "3");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mExpected, m);
    }

    @Test
    public final void testRemoveAny() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("get me out of here",
                "please");
        Map<String, String> mExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        Pair<String, String> x = m.removeAny();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mExpected, m);
        assertEquals("get me out of here", "please", x);
    }

    @Test
    public final void testRemove() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("get me out of here",
                "please");
        Map<String, String> mExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        Pair<String, String> x = m.remove("get me out of here");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(mExpected, m);
        assertEquals("get me out of here", "please", x);
    }

    @Test
    public final void testLengthNonEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("element", "1",
                "element", "2");
        Map<String, String> mExpected = this.createFromArgsRef("element", "1",
                "element", "2");
        /*
         * Call method under test
         */
        int i = m.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(2, i);
        assertEquals(mExpected, m);
    }

    @Test
    public final void testLengthEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest();
        Map<String, String> mExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        int i = m.size();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(0, i);
        assertEquals(mExpected, m);
    }

    @Test
    public final void testHasKey() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("check", "if I'm here");
        Map<String, String> mExpected = this.createFromArgsRef("check",
                "if I'm here");
        /*
         * Call method under test
         */
        boolean test = m.hasKey("check");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, test);
        assertEquals(mExpected, m);
    }

    @Test
    public final void testHasKeyEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest();
        Map<String, String> mExpected = this.createFromArgsRef();
        /*
         * Call method under test
         */
        boolean test = m.hasKey("check");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(false, test);
        assertEquals(mExpected, m);
    }

    @Test
    public final void testValueEmpty() {
        /*
         * Set up variables
         */
        Map<String, String> m = this.createFromArgsTest("the value is", "42");
        Map<String, String> mExpected = this.createFromArgsRef("the value is",
                "42");
        /*
         * Call method under test
         */
        String val = m.value("the value is");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals("42", val);
        assertEquals(mExpected, m);
    }

}