package DesignPattern.Behavior.TemplateMethod;

public class DualTronThunder extends Charger {

    @Override
    protected void findCorrectCharger() {
        System.out.println("듀얼트론 전용 충전기를 찾아서 연결");
    }
}
