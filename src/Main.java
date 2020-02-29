import java.util.Scanner;
public class Main {
    public static class MyThread extends Thread {
        public boolean work;
        int number;
        String name;
        public MyThread(int num, String name) {
            this.number = num;
            this.name = name;
        }
        @Override
        public void run() {
            while(work){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Object monitor = new Object();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество потоков:");
        int num = sc.nextInt();
        System.out.println("Введите, кто будет работать:");
        String na = sc.next();
        MyThread[] ar = new MyThread[num];
        for (int i = 0; i < num; i++) {
            ar[i] = new MyThread(num, na);
            try {
                ar[i].start();
                Thread.sleep(1000);
                ar[i].work = false;
                ar[i].join();
                synchronized (monitor) {
                    System.out.print("/");
                    Thread.sleep(1000);
                    System.out.print(na + " номер " + i + " поработал");
                    Thread.sleep(1000);
                    System.out.print("/ ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
