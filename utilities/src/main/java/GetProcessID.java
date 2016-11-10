import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Getting process id from Linux/Unix
 */
public class GetProcessID {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", "echo $PPID" });
        StringBuilder sb = null;
        if (process.isAlive()) {
            InputStream is = null;
            BufferedReader br = null;
            try {
                is = process.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } finally {
                br.close();
                is.close();
            }
        }
        System.out.println("Process id  = " + sb);
    }
}
