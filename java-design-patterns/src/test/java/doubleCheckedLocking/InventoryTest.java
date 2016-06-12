package doubleCheckedLocking;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class InventoryTest {

    @Test public void testAddItem() throws Exception {
        int inventorySize = 50;
        Inventory inventory = new Inventory(inventorySize);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        boolean[] result = new boolean[inventorySize];

        int itemsToBeAdded = 100;
        Future<Boolean>[] futures = new Future[itemsToBeAdded];
        for (int i = 0; i < itemsToBeAdded; i++) {
            futures[i] = executorService.submit(new MyRunnable(inventory));
        }
        int trueCount = 0, falseCount = 0;
        for (int i = 0; i < futures.length; i++) {
            if (futures[i].get()) {
                trueCount++;
            } else {
                falseCount++;
            }
        }

        assertEquals(50, trueCount);
        assertEquals(50, falseCount);
    }

    class MyRunnable implements Callable {
        private final Inventory inventory;

        MyRunnable(Inventory inventory) {
            this.inventory = inventory;
        }

        @Override public Object call() throws Exception {
            return inventory.addItem(new Item());
        }
    }
}