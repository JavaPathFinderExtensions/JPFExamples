import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;

import java.util.Random;

import org.junit.*;

public class BellmanFordBenchmarks extends TestJPF {
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
    public void vertices100() {
        testName = "vertices100";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        final int V = 100;
        Random random = new Random();
        final int D[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    continue;
                D[i][j] = random.nextInt(i + j + 1);
            }
        }
        if (verifyNoPropertyViolation(propertyPath)) {
            new BellmanFord().runBellmanFord(V, D, 0);

        }
    }

    @Test
    public void vertices1000() {
        testName = "vertices1000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        final int V = 1000;
        Random random = new Random();
        final int D[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    continue;
                D[i][j] = random.nextInt(i + j + 1);
            }
        }
        if (verifyNoPropertyViolation(propertyPath)) {
            new BellmanFord().runBellmanFord(V, D, 0);

        }
    }

}
