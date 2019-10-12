import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;

import java.util.Random;
import rbt.RedBlackTree;
import rbt.RedBlackTreeNode;
import org.junit.*;

public class RedBlackTreeSearchBenchmarks extends TestJPF {
    long before;
    long after;
    String testName;

    @Before
    public void beforeEachTestMethod() {
        before = Verify.currentTimeMillis();
    }

    @After
    public void afterEachTestMethod() {
        float elasped = Verify.currentTimeMillis() - before;
        Verify.println("Time elapsed for " + testName + ": " + elasped / 1000 + "s\n\n");
    }

    @Test
    public void insertSearch100() {
        testName = "vertices100";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 100;
            RedBlackTree tree = new RedBlackTree();

            for (int i = 0; i < N; i++) {
                tree.treeInsert(new RedBlackTreeNode(i));
            }

            for (int i = 0; i < N; i++) {
                tree.treeSearch(tree.root(), i);
            }
        }
    }

    @Test
    public void vertices1000() {
        testName = "vertices1000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 1000;
            RedBlackTree tree = new RedBlackTree();

            for (int i = 0; i < N; i++) {
                tree.treeInsert(new RedBlackTreeNode(i));
            }

            for (int i = 0; i < N; i++) {
                tree.treeSearch(tree.root(), i);
            }
        }
    }

    @Test
    public void vertices10000() {
        testName = "vertices10000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 10000;
            RedBlackTree tree = new RedBlackTree();

            for (int i = 0; i < N; i++) {
                tree.treeInsert(new RedBlackTreeNode(i));
            }

            for (int i = 0; i < N; i++) {
                tree.treeSearch(tree.root(), i);
            }
        }
    }
}
