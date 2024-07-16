public class Finall {
    public static void main(String[] args) {
        Smartphone myPhone = new Smartphone("Motorola", "G61 5G", "Android 12", "60MP");
        myPhone.displaySmartphoneInfo();
        myPhone.powerOn();
        myPhone.takePhoto();
        myPhone.powerOff();
        myPhone.takePhoto();
    }
}