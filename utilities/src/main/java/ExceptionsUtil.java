import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by liju on 9/29/16.
 */
public class ExceptionsUtil {
    /**
     * Return error stack trace as string
     * @param e
     * @return
     */
    public static String messageAndStackTraceAsString(Throwable e){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.print(e.getMessage());
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static void main(String[] args) {
        try {
            String str= null;
            str.charAt(0);
        } catch (Exception e) {
            System.out.println(messageAndStackTraceAsString(e));
        }
    }
}
