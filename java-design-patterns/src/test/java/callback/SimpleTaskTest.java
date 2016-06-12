package callback;

import org.junit.Test;

public class SimpleTaskTest {

    @Test
    public void testExecute() throws Exception {
        Task task = new SimpleTask();
        task.execute();
    }

    @Test
    public void testExecute1() throws Exception {
        Task task = new SimpleTask();
        Callback callback = new SimpleCallback();
        task.execute(callback);
    }
}