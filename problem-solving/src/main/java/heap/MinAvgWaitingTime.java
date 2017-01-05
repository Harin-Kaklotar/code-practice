package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by liju on 1/2/17.
 *

 */
public class MinAvgWaitingTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCustomers = sc.nextInt();

        PriorityQueue<Customer> customers = new PriorityQueue<>(nCustomers,Comparator.comparing(Customer::getArrivalTime));
        PriorityQueue<Customer> waitingList = new PriorityQueue<>(Comparator.comparing(Customer::getCookingTime));

        for (int i = 0; i < nCustomers; i++) {
            customers.offer(new Customer(sc.nextInt(), sc.nextInt()));
        }
        long totalTime =0 ,waitingTime =0;
        while (!customers.isEmpty() || !waitingList.isEmpty()){
            //waiting list is empty but customers not empty
            if (waitingList.isEmpty()){
                Customer customer = customers.poll();
                waitingList.offer(customer);
                totalTime = customer.arrivalTime;
                continue;
            }
            Customer customer = waitingList.poll();
            totalTime+= customer.cookingTime;
            waitingTime += totalTime - customer.arrivalTime;
            while (!customers.isEmpty()&& customers.peek().arrivalTime<=totalTime){
                waitingList.offer(customers.poll());
            }
        }
        System.out.println(waitingTime/nCustomers);
    }


    private static class Customer{
        private final int arrivalTime;
        private final int cookingTime;

        public Customer(int arrivalTime, int cookingTime) {
            this.arrivalTime = arrivalTime;
            this.cookingTime = cookingTime;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public int getCookingTime() {
            return cookingTime;
        }
    }
}
