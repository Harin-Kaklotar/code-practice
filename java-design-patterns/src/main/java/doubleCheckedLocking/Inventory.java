package doubleCheckedLocking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liju on 6/11/16.
 */
public class Inventory {
    private List<Item> itemList;
    private Lock lock;
    private int inventorySize;

    public Inventory(int inventorySize) {
        this.itemList = new ArrayList<>(inventorySize);
        this.lock = new ReentrantLock();
        this.inventorySize = inventorySize;
    }

    public boolean addItem(Item item) {

        if (itemList.size() < inventorySize) {
            lock.lock();
            try {
                if (itemList.size() < inventorySize) {
                    itemList.add(item);
                    System.out.println("item added ,by thread " + Thread.currentThread().getName());
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

}
