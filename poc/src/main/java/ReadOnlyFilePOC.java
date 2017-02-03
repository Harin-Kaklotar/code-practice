import org.apache.log4j.Logger;

/**
 * Created by liju on 2/3/17.
 *
 * Checking the impact on logging when process is running and in the middle you change the log file and log folder access to read only mode
 *
 * Steps
 * 1. Start the program
 * 2. Monitor the inode stats (file size) for the log file  ( cmd> stat -x test.log  OR lsof | grep inodeNum)
 * 3. Change the permision of the log file to read only after some time
 * 4. Check the inode stats (again ) for the same file
 * 5. Delete the running log file
 * 6. Check the inode stats (again ) for the same file
 *
 *
 * Observations:
 * 1. Since the file descriptor is already open , changing or deleting file doesn't gets reflected to the log4j
 * 2. Even after deleting or changing to Read only , we can see that the file size keeps increasing while monitoring the file inode
 * 3. Once the java process is killed only after that the inode and file node is removed from the system
 * 4. If multiple process refer to the same file , the filedescriptor for the file is open even if any one of them is using the fd.
 */
public class ReadOnlyFilePOC {

    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger("ReadOnlyFilePOC");
            while (true) {
                logger.info("logging some random stuff");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}