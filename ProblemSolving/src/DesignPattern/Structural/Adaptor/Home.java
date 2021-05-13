package DesignPattern.Structural.Adaptor;

public class Home {
    public static void main(String[] args) {
        Mac mac = new Mac();
        consent(mac);

        //HairDryer hairDryer = new HairDryer();
        E220V adaptor = new PigNoseAdapter();
        consent(adaptor);
    }

    public static void consent(E220V e220V) {
        e220V.connect();
    }
}
