import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Yifan Ning
 */
public class FileOperation {

    public static void getPage(String inputUrl) throws Exception {
        // Verify the methods read and write used by the FileChannel of a
        // FileInput/OutputStream
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {

            URL url = new URL(inputUrl);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        } finally {
            if (br != null) {
                br.close();
            }
        }
        sb.append("Just for testing");

        BufferedWriter bw = null;
        try {
            File testFile = new File("test_webpage.html");
            bw = new BufferedWriter(new FileWriter(testFile));

            // write contents of StringBuffer to a file
            bw.write(sb.toString());

            // flush the stream
            bw.flush();
            System.out.println("Content of webpage saved.");
        } finally {
            if (bw != null) {
                // close the stream
                bw.close();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        // Replace link with the HTTP referrer to your website address
        getPage("https://www.google.com/");
    }
}