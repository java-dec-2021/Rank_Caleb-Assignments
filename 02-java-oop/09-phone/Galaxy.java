public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getRingTone();
    }
    @Override
    public String unlock() {
        return "Unlocking via fingerprint.";
    }
    @Override
    public void displayInfo() {
        System.out.println("------");
        System.out.println( "Galaxy Version: " + this.getVersionNumber() );
        System.out.println( "Galaxy Battery: " + Integer.toString(this.getBatteryPercentage()) );
        System.out.println( "Galaxy Carrier: " + this.getCarrier() );
        System.out.println( "Galaxy Ring Tone: " + this.getRingTone() );
        System.out.println("------");
    }
}