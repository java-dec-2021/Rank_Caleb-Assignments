public class IPhone extends Phone implements Ringable {

    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return this.getRingTone();
    }
    @Override
    public String unlock() {
        return "Unlocking via facial recognition.";
    }
    @Override
    public void displayInfo() {
        System.out.println("------");
        System.out.println( "IPhone Version: " + this.getVersionNumber() );
        System.out.println( "IPhone Battery: " + Integer.toString(this.getBatteryPercentage()) );
        System.out.println( "IPhone Carrier: " + this.getCarrier() );
        System.out.println( "IPhone Ring Tone: " + this.getRingTone() );
        System.out.println("------");
    }
}