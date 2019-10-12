import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;

import java.util.Random;

import org.junit.*;

public class TspBenchmarks extends TestJPF {
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
    public void vertices10() {
        testName = "vertices10";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        Random random = new Random();
        final int N = 10;
        int D[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                D[i][j] = random.nextInt(i + j + 1);
            }
        }
        if (verifyNoPropertyViolation(propertyPath)) {
            Tsp.TspSolver tspSolver = new Tsp.TspSolver(N, D);
            tspSolver.solve();
        }
    }

    // @Test
    // public void vertices100() {
    // testName = "vertices10";
    // String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
    // Random random = new Random();
    // final int N = 100;
    // int D[][] = new int[N][N];

    // for (int i = 0; i < N; i++) {
    // for (int j = 0; j < N; j++) {
    // D[i][j] = random.nextInt(i + j + 1);
    // }
    // }
    // if (verifyNoPropertyViolation(propertyPath)) {
    // Tsp.TspSolver tspSolver = new Tsp.TspSolver(N, D);
    // tspSolver.solve();
    // }
    // }

}
