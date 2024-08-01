package Lab_8;

public class PrintNum extends  Thread {
    public void run(){
        for (int i= 1;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        PrintNum num = new PrintNum();
        num.start();
    }
}
