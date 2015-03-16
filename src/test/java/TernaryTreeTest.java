import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TernaryTreeTest {

    @Test
    public void testTree() throws Exception {
        // The simplest way to prove the internal structure of this tree is to do either dfs/bfs and produce the results.
        // then compare them with the expected
        List<Integer> expected = Arrays.asList(2, 2, 4, 5, 7, 9, 5);

        TernaryTree<Integer> tree = new TernaryTree<>(5, 4, 9, 5, 7, 2, 2);
        List<Integer> results = tree.dfs();
        assertEquals(expected,results);

        /*
              5

            / | \
           4  5  9
         /      /
        2      7
        |
        2
         */

    }
}