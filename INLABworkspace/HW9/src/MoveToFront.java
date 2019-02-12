import components.map.Map.Pair;
import components.queue.Queue;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class MoveToFront {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MoveToFront() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
    }

    /**
     * Finds pair with first component {@code key} and, if such exists, moves it
     * to the front of {@code q}.
     *
     * @param <K>
     *            type of {@code Pair} key
     * @param <V>
     *            type of {@code Pair} value
     * @param q
     *            the {@code Queue} to be searched
     * @param key
     *            the key to be searched for
     * @updates q
     * @ensures <pre>
     * perms(q, #q)  and
     * if there exists value: V (<(key, value)> is substring of q)
     *  then there exists value: V (<(key, value)> is prefix of q)
     * </pre>
     */
    private static <K, V> void moveToFront(Queue<Pair<K, V>> q, K key) {
        int finished = q.length();
        int rotations = 0;
        while (rotations <= q.length() && q.front().key() != key) {
            q.rotate(1);
            rotations++;

        }
    }
}
