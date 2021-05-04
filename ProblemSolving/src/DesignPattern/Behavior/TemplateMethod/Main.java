package DesignPattern.Behavior.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("사용중인 아이폰이 충전이 필요하다.");
        Iphone iphone = new Iphone();
        iphone.charging();

        System.out.println();
        System.out.println("=============================");
        System.out.println();

        System.out.println("사용중인 킥보드의 충전이 필요하다.");
        DualTronThunder dualTronThunder = new DualTronThunder();
        dualTronThunder.charging();
    }
}
