package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFixedThread {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 9; i ++) {
            Future<Object> submit = executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return "aaaaaaaa";
                }
            });

            Thread.sleep(1000);
        }




//        Future<Object> submit1 = executorService.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                return "aaaaaaaa";
//            }
//        });
//
//        Thread.sleep(10000);
//
//        Future<Object> submit2 = executorService.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                return "aaaaaaaa";
//            }
//        });


        while (true) {

        }
    }
}
