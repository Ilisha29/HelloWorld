package DesignPattern.Structural.Adaptor;

public class Mac implements E220V{

    @Override
    public void connect() {
        System.out.println("맥 220v on");
    }
}
