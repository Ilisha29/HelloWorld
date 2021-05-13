package DesignPattern.Structural.Adaptor;

public class HairDryer implements E110V {
    @Override
    public void powerOn() {
        System.out.println("헤어드라이기 110v on");
    }
}
