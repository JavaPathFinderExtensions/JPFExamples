import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;

import java.util.Random;

import org.junit.*;

public class InsertionSortBenchmarks extends TestJPF {
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
    public void Array1000() {
        testName = "Array1000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        final int N = 1000;
        Random random = new Random();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(N + 1);
        }
        if (verifyNoPropertyViolation(propertyPath)) {
            new InsertionSort().sort(a);
        }
    }

    @Test
    public void Array10000() {
        testName = "Array10000";
        String propertyPath = "src/test/junit/benchmarks/benchmarks.jpf";
        final int N = 10000;
        Random random = new Random();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(N + 1);
        }
        if (verifyNoPropertyViolation(propertyPath)) {
            new InsertionSort().sort(a);
        }
    }

}
