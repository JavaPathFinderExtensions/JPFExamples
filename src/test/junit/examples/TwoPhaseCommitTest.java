
/*
* @author Yifan Ning
*/

import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TwoPhaseCommitTest extends TestJPF {

    @Test
    public void testThreeParticipants() {
        if (verifyNoPropertyViolation("src/test/junit/examples/examplesTest.jpf")) {
            List<TwoPhaseCommit.Participant> parts = new ArrayList<>();
            parts.add(new TwoPhaseCommit.Participant());
            parts.add(new TwoPhaseCommit.Participant());
            // parts.add(new TwoPhaseCommit.Participant());
            new TwoPhaseCommit.Coordinator(parts).start();
            for (int i = 0; i < parts.size(); i++) {
                parts.get(i).start();
            }
        }
    }

}
