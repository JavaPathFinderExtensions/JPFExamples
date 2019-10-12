
/*
* @author Yifan Ning
*/

import gov.nasa.jpf.util.test.TestJPF;
import gov.nasa.jpf.vm.Verify;
import org.junit.Test;

public class FileOperationTest extends TestJPF {

    @Test
    public void testGetInvalidUrl() throws Exception {
        if (verifyNoPropertyViolation("src/test/junit/examples/examplesTest.jpf")) {
            new FileOperation().getPage("aafkjskjfkjsdkf");
        }
    }

}
