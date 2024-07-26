package Lab_6;

public class Main {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.setName("Thread1");
        t2.setName("Thread2");

        t1.start();
        t2.start();

        Thread.currentThread().setName("mainThread");
        for(int i =61;i<=80;i++){
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The Execution Of All Threads Is Completed");
    }
}