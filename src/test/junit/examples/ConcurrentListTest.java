
/*
* @author Yifan Ning
*/
import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;
import org.junit.Test;

public class ConcurrentListTest extends TestJPF {

    @Test
    public void testAddFirst() {
        if (verifyNoPropertyViolation("src/test/junit/examples/examplesTest.jpf")) {
            ConcurrentList<Integer> myList = new ConcurrentList<>();
            myList.addFirst(6);
            myList.addFirst(5);
            myList.addFirst(4);
            myList.addFirst(3);
            myList.addLast(7);
            int prevLen = myList.size();
            // Verify.print("prev Len", prevLen);
            // Verify.println();
            int a = Verify.getInt(1, 3);
            Thread threads[] = new Thread[a];
            for (int i = 0; i < a; i++) {
                Thread thread1 = new Thread() {

                    @Override
                    public void run() {
                        myList.addFirst(10);
                    }
                };
                threads[i] = thread1;
                thread1.start();
            }
            for (int i = 0; i < a; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                }
            }
            // Verify.print("a", a);
            // Verify.println();
            // Verify.print("after len" ,myList.size());
            // Verify.println();
            Verify.assertTrue(prevLen + a == myList.size());
        }
    }

    @Test
    public void testRemoveFirst() {
        if (verifyNoPropertyViolation("src/test/junit/examples/examplesTest.jpf")) {
            ConcurrentList<Integer> myList = new ConcurrentList<>();
            myList.addFirst(6);
            myList.addFirst(5);
            myList.addFirst(4);
            myList.addFirst(3);
            myList.addLast(7);
            int prevLen = myList.size();
            // Verify.print("prev Len", prevLen);
            // Verify.println();
            int a = Verify.getInt(1, 3);
            Thread threads[] = new Thread[a];
            for (int i = 0; i < a; i++) {
                Thread thread1 = new Thread() {

                    @Override
                    public void run() {
                        myList.removeFirst();
                    }
                };
                threads[i] = thread1;
                thread1.start();
            }
            for (int i = 0; i < a; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                }
            }
            // Verify.print("a", a);
            // Verify.println();
            // Verify.print("after len" ,myList.size());
            // Verify.println();
            Verify.assertTrue(prevLen - a == myList.size());
        }
    }

    // This is the test that's supposed to fail
    // @Test
    // public void testRemoveFirstUnsafe() {
    // if (verifyNoPropertyViolation("src/test/junit/examples/examplesTest.jpf")) {
    // ConcurrentList<Integer> myList = new ConcurrentList<>();
    // myList.addFirst(6);
    // myList.addFirst(5);
    // myList.addFirst(4);
    // myList.addFirst(3);
    // myList.addLast(7);
    // int prevLen = myList.size();
    // // Verify.print("prev Len", prevLen);
    // // Verify.println();
    // int a = Verify.getInt(1, 3);
    // Thread threads[] = new Thread[a];
    // for (int i = 0; i < a; i++) {
    // Thread thread1 = new Thread() {

    // @Override
    // public void run() {
    // myList.removeFirstUnsafe();
    // }
    // };
    // threads[i] = thread1;
    // thread1.start();
    // }
    // for (int i = 0; i < a; i++) {
    // try {
    // threads[i].join();
    // } catch (InterruptedException e) {
    // }
    // }
    // // Verify.print("a", a);
    // // Verify.println();
    // // Verify.print("after len" ,myList.size());
    // // Verify.println();
    // Verify.assertTrue(prevLen - a == myList.size());
    // }
    // }
}
