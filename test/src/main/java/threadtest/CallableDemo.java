package threadtest;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {

        int i = 1;
        int j = 2;
        return "执行结果i + j ：" + (i + j);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new CallableDemo());
        try {
            System.out.println((String)future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
