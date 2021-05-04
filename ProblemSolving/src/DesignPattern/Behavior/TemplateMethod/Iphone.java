package DesignPattern.Behavior.TemplateMethod;

public class Iphone extends Charger {

    @Override
    protected void findCorrectCharger() {
        System.out.println("아이폰 충전기를 찾아서 연결");
    }
}
