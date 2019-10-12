import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;
import org.junit.*;
import java.util.Random;

public class BinaryTreeSearchBenchmarks extends TestJPF {
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
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        testName = "insertSearch100";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 100;
            BinarySearchTree b = new BinarySearchTree();
            for (int i = 0; i < N; i++) {
                b.insert(i);
            }
            for (int i = 0; i < N; i++) {
                b.search(i);
            }
            long after = Verify.currentTimeMillis();

        }
    }

    @Test
    public void insertSearch1000() {
        testName = "insertSearch1000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 1000;
            BinarySearchTree b = new BinarySearchTree();
            for (int i = 0; i < N; i++) {
                b.insert(i);
            }
            for (int i = 0; i < N; i++) {
                b.search(i);
            }
        }
    }

    @Test
    public void insertSearch10000() {
        testName = "insertSearch10000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        if (verifyNoPropertyViolation(propertyPath)) {
            final int N = 10000;
            BinarySearchTree b = new BinarySearchTree();
            for (int i = 0; i < N; i++) {
                b.insert(i);
            }
            for (int i = 0; i < N; i++) {
                b.search(i);
            }
        }
    }
}
