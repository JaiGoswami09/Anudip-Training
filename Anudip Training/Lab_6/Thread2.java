package Lab_6;

public class Thread2 extends Thread{
    public void run(){
        for (int i = 21; i <= 60; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}