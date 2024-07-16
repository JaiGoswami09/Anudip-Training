public class Smartphone extends Device {
    private String operatingSystem;
    private String cameraResolution;

    public Smartphone(String brand, String model, String operatingSystem, String cameraResolution) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        this.cameraResolution = cameraResolution;
    }

    public void displaySmartphoneInfo() {
        displayInfo();
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Camera Resolution: " + cameraResolution);
    }

    public void takePhoto() {
        if (isPowerStatus()) {
            System.out.println("Photo is captured with " + cameraResolution + " resolution.");
        } else {
            System.out.println("Photo Can't Be Clicked As Your Smartphone Is Switched Off.");
        }
    }


    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getCameraResolution() {
        return cameraResolution;
    }
}