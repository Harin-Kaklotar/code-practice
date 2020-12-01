package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class RegexTest {

    public static void main(String[] args) {
        test1();
        test2();

        System.out.println(Pattern.COMMENTS );
    }

    /**
     * Capturing groups are numbered by counting their opening parentheses from the left to the right. In the expression ((A)(B(C))), for example, there are four such groups −
     *
     * ((A)(B(C)))
     * (A)
     * (B(C))
     * (C)
     */
    public static void test1(){
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

        System.out.println(m.groupCount());

        if (m.find( )) {
            System.out.println(m.group());
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    public static void test2(){
        Pattern pattern = Pattern.compile("M+", 5);
        Matcher matcher = pattern.matcher("M Merit Match MM m mM");
        while (matcher.find())
            System.out.print(matcher.group() + " ");
    }
}
