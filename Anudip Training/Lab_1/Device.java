public class Device {
    private String brand;
    private String model;
    private boolean powerStatus;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.powerStatus = false;
    }

    public void displayInfo() {
        System.out.println("Brand Of The Device: " + brand);
        System.out.println("Model Of The Device: " + model);
    }

    public void powerOn() {
        if (!powerStatus) {
            powerStatus = true;
            System.out.println(brand + " " + model + " is switched on");
        } else {
            System.out.println(brand + " " + model + " is already in working.");
        }
    }

    public void powerOff() {
        if (powerStatus) {
            powerStatus = false;
            System.out.println(brand + " " + model + " is switched off");
        } else {
            System.out.println(brand + " " + model + " is off");
        }
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isPowerStatus() {
        return powerStatus;
    }
}