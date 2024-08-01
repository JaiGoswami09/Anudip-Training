package Lab_7;

public class PrintNumbers extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public static void main(String[] args) {
        PrintNumbers num = new PrintNumbers();
        num.start();
    }
}




