import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by liju on 11/10/16.
 */
public class GZipCompressorExample {

    /**
     * Method to compress data in gzip format
     * @param input bytes to compress
     * @return
     * @throws IOException
     */
    public static byte[] compress(byte[] input) throws IOException {
        ByteArrayOutputStream outputStream = null;
        GZIPOutputStream gzip = null;
        try {
            System.out.println("non-compressed size = " +input.length);
            outputStream = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(outputStream);
            gzip.write(input);

            final byte[] output = outputStream.toByteArray();
            System.out.println("compressed size = " +output.length);
            return output;

        } catch (Exception e) {
            throw  e;
        }finally {
            if (outputStream!=null)
                outputStream.close();
            if (gzip!=null)
                gzip.close();
        }
    }

    /**
     * Method to decompress data in gzip format
     * @param compressed bytes in gzip format
     * @return
     * @throws IOException
     */
    public static byte[] decompress(byte[] compressed) throws IOException {
        ByteArrayOutputStream outputStream = null;
        GZIPInputStream gzipInputStream = null;
        try {
            System.out.println("compressed size = " +compressed.length);
            outputStream = new ByteArrayOutputStream();
            gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressed));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer))!=-1) {
                outputStream.write(buffer, 0, len);
            }
            buffer = outputStream.toByteArray();
            System.out.println("decompressed size = " +buffer.length);
            return buffer;
        } catch (Exception e) {
           throw e;
        }finally {
            if (gzipInputStream!=null)
                gzipInputStream.close();
            if (outputStream!=null)
                outputStream.close();

        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb  = new StringBuilder();
        sb.append("This is line 1");
        sb.append("This is line 2");
        sb.append("This is line 3");
        sb.append("This is line 4");
        sb.append("This is line 5");
        sb.append("This is line 6");
        sb.append("This is line 7");
        sb.append("This is line 8");
        sb.append("This is line 9");


        decompress(compress(sb.toString().getBytes()));

    }
}
