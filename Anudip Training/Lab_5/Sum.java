package Lab_5;

public class Sum extends Thread{
    private int sum;
    public void run(){
        sum=0;

        for (int i=1;i<=100;i++){
            sum +=i;
        }
    }
    public int getSum(){
        return sum;
    }

    public static void main(String[] args) {
        Sum s=new Sum();
        s.start();
        try {

            s.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The Final Sum Of Numbers: "+s.getSum());
        System.out.println("Task Completed");
    }
}