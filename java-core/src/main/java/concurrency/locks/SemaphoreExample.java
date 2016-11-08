package concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Created by liju on 11/7/16.
 *
 * Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource. For
 * example, here is a class that uses a semaphore to control access to a pool of items:
 */
public class SemaphoreExample {
    private final int MAX_AVAILABLE = 3;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);
    private final Map<Object, Boolean> itemAvailable = new HashMap<>(MAX_AVAILABLE); // map of item key and is used flag
    private final Map<Object, Object> items = new HashMap<>(); // map of item key and item

    public SemaphoreExample() {
        items.put("key1", "val1");
        items.put("key2", "val2");
        items.put("key3", "val3");

        itemAvailable.put("key1", true);
        itemAvailable.put("key2", true);
        itemAvailable.put("key3", true);

    }

    public Object getItem() throws InterruptedException {
        semaphore.acquire();
        return nextAvailableItem();
    }

    public void putItem(Object key, Object item) {
        if (markItemAsUnused(key, item)) {
            semaphore.release();
        }
    }

    private synchronized Object nextAvailableItem() {
        for (Map.Entry entry : itemAvailable.entrySet()) {
            if ((Boolean) entry.getValue()) {
                itemAvailable.put(entry.getKey(), false);
                System.out.println("next item" + items.get(entry.getKey()));
                return items.get(entry.getKey());
            }
        }
        throw new RuntimeException("All items are in use");
    }

    private synchronized boolean markItemAsUnused(Object key, Object item) {
        if (itemAvailable.get(key) != null) {
            if (!itemAvailable.get(key)) {
                itemAvailable.put(key, true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
