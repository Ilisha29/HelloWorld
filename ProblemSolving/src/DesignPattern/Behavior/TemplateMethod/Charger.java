package DesignPattern.Behavior.TemplateMethod;

public abstract class Charger {

    public void charging() {
        System.out.println("step 1 : 배터리 잔량 확인");
        findCorrectCharger();
        System.out.println("step 2 : 충전후 충전기 제거");
    }

    protected abstract void findCorrectCharger();
}
