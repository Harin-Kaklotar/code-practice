package completableFuture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by liju on 9/6/16.
 */
public class Shop {
    private String shopName;
    Random random = new Random();

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice(String product) {
            return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay(1000);
        return random.nextDouble() * product.charAt(0);

    }

    public static void delay (long timeInMs){
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Double> getPriceAsyncV1(String product){
        CompletableFuture<Double> futurePrice  = new CompletableFuture<>();
        new Thread(() -> {

            try {
                double price = calculatePrice(product);
                //once price is calculated , complete the future with the price
                futurePrice.complete(price);
            } catch (Exception e) {
                //if error occurs complete the future with the exception
                futurePrice.completeExceptionally(e);
            }
        }
        ).start();
        return  futurePrice;
    }

    // rewritten the same getPriceAsyncV1 function with async supplier
    public CompletableFuture<Double> getPriceAsyncV2(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    public String getPriceWithDiscountCoupon(String product){
        final double price = calculatePrice(product);
        final Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s",shopName,price,code);

    }

}

class Discount{

    public enum Code{
        NONE(0),SILVER(5),GOLD(10);
        private int discountPercent;
        Code(int i){
            this.discountPercent = i;
        }
    }

    public static String applyDiscount(Quote quote){
        return quote.getShopName()+ "price is "+Discount.apply(quote.getPrice(),quote.getDiscountCode());
    }
    private static double apply(double price , Discount.Code code){
        delay(1000);
        return (price * (100 - code.discountPercent)/100);
    }

    public static void delay (long timeInMs){
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
// Quote
class Quote{
    private String shopName;
    private double price;
    private Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    //Gets Quote object parsing string in format (shopName:price:discountCode)
    public static Quote parse(String str){
        String[] split = str.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }
    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}

class Client1{
    public static void main(String[] args) {
        Shop shop = new Shop("myShop");
        long startTime  = System.currentTimeMillis();
        final CompletableFuture<Double> futurePrice = shop.getPriceAsyncV1("MyFav Product");

        //do something else , do more tasks etc  while the price of product is been calculated
        Double price = null;
        try {
             price = futurePrice.get();
            System.out.printf("Price is %.2f%n \n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long timeTaken  = System.currentTimeMillis() - startTime;
        System.out.printf("Time taken %s ms",timeTaken);

    }
}

class Client2 {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("iShop"),new Shop("jShop"),new Shop("kShop"),new Shop("lShop"),new Shop("mShop"));
        //find price sequentially
        long startTime1  = System.currentTimeMillis();
        System.out.println(findPriceSequentially(shops));
        long timeTaken1  = System.currentTimeMillis() - startTime1;
        System.out.println("Total time taken sequentially is "+timeTaken1);

        //find price using parallel streams but not async call
        long startTime2  = System.currentTimeMillis();
        System.out.println(findPriceParallelStream(shops));
        long timeTaken2  = System.currentTimeMillis() - startTime2;
        System.out.println("Total time taken using parallel stream is "+timeTaken2);

        //find price in Async using completableFuture
        long startTime3  = System.currentTimeMillis();
        System.out.println(findPricesAsync(shops));
        long timeTaken3  = System.currentTimeMillis() - startTime3;
        System.out.println("Total time taken in async using completableFuture "+timeTaken3);

        //find price in Async using completableFuture and custom executor
        long startTime4  = System.currentTimeMillis();
        System.out.println(findPricesAsyncUsingCustomExecutor(shops));
        long timeTaken4  = System.currentTimeMillis() - startTime4;
        System.out.println("Total time taken in async using completableFuture and custom executor "+timeTaken4);

         /* Calling additional service to get discounted price */

        //find discounted price sequentially
        long startTime5  = System.currentTimeMillis();
        System.out.println(findPricesWithDiscountSequentially(shops));
        long timeTaken5  = System.currentTimeMillis() - startTime5;
        System.out.println("Total time taken in ms :: sequentially :: discounted price :: "+timeTaken5);

        //find discounted price asynchronously
        long startTime6  = System.currentTimeMillis();
        System.out.println(findPricesWithDiscountAsync(shops));
        long timeTaken6  = System.currentTimeMillis() - startTime6;
        System.out.println("Total time taken in ms :: async :: discounted price :: "+timeTaken6);

    }

    //finding price sequentially
    public static List<String> findPriceSequentially(List<Shop> shops){
        // note  - the shop.getPrice() is not async one
        return shops.stream()
            .map(shop -> String.format("%s price is %.2f",shop.getShopName(),shop.getPrice("product A")))
            .collect(Collectors.toList());
    }

    //finding price using parallel stream
    public static List<String> findPriceParallelStream(List<Shop> shops){
        // note  - the shop.getPrice() is not async one
        return shops.parallelStream()
            .map(shop -> String.format("%s price is %.2f",shop.getShopName(),shop.getPrice("product A")))
            .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync(List<Shop> shops){
        final List<CompletableFuture<String>> completableFutures = shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getShopName(),shop.getPrice("product A"))))
            .collect(Collectors.toList());

        //waits for completion of all async operations
        return completableFutures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

    }

    public static List<String> findPricesAsyncUsingCustomExecutor(List<Shop> shops) {

        final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        });
        final List<CompletableFuture<String>> completableFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f",shop.getShopName(), shop.getPrice("product A")), executor)).collect(
            Collectors.toList());

        // waits for completion of all async operations
        return completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    // simple way for getting the discounted price
    public static  List<String> findPricesWithDiscountSequentially(List<Shop> shops){

        return shops.stream()
            .map(shop -> shop.getPriceWithDiscountCoupon("Product A"))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(Collectors.toList());
    }

    //combining synchronous and asynchronous to get discounted price
    public static List<String> findPricesWithDiscountAsync(List<Shop> shops){

        final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        });

        final List<CompletableFuture<String>> futurePrices = shops.stream()
            // asynchronously get the price with discount coupon
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscountCoupon("Product A")))
            // synchronously get the quote
            .map(future -> future.thenApply(Quote::parse))
            // asynchronously apply the discount
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
            .collect(Collectors.toList());

        //wait for all the futures in the stream to be completed and then extract there results
        return futurePrices.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());

    }

}
