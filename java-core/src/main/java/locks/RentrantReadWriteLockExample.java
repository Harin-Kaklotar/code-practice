package locks;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Liju on 11/6/2016.
 */
public class RentrantReadWriteLockExample {

    Map<String, String> dictionaryData = new TreeMap<>();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock rl = reentrantReadWriteLock.readLock();
    ReentrantReadWriteLock.WriteLock wl = reentrantReadWriteLock.writeLock();

    public String getData(String key) {
        rl.lock();
        try {
            return dictionaryData.get(key);
        } finally {
            rl.unlock();
        }
    }

    public void putData(String key, String data) {
        wl.lock();
        try {
            dictionaryData.put(key, data);
        } finally {
            wl.unlock();
        }
    }

    public void clear() {
        rl.lock();
        try {
            dictionaryData.clear();
        } finally {
            rl.unlock();
        }
    }
}
