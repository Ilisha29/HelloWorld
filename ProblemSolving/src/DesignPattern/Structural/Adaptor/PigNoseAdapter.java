package DesignPattern.Structural.Adaptor;

/*public class PigNoseAdapter implements E220V {

    private E110V e110V;

    public PigNoseAdapter(E110V e110V) {
        this.e110V = e110V;
    }

    @Override
    public void connect() {
        e110V.powerOn();
    }
}*/

public class PigNoseAdapter extends HairDryer implements E220V {
    @Override
    public void connect() {
        super.powerOn();
    }
}