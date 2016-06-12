package callback;

/**
 * Created by liju on 5/20/16.
 */
public abstract class Task {

    public abstract void execute();

    public void execute(Callback callback){
        execute();
        if (callback!=null){
            callback.call();
        }
    }
}
