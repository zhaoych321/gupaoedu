package org.example.finaltest;

public class Test {
    public static void main(String[] args) {
        System.out.println("和是：" + new Test().add(3, 4));
    }

   public int add(int a, int b) {
        try {
            System.out.println("进入try块中！");
            return a + b;
        } catch (Exception e) {
            System.out.println("进入catch块中！");
        } finally {
            System.out.println("进入finally块中！");
        }
        return 0;
   }
}
