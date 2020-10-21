package CS.OOP.상속;

public class Plane {
    public void fly() {
        System.out.println("Plane fly");
    }
}

class AirPlane extends Plane {
    public void boost() {
        System.out.println("airplae boost");
    }

    @Override
    public void fly() {
        System.out.println("airPlane fly");
    }
}