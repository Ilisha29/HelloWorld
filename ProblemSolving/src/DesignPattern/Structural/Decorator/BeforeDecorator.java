package DesignPattern.Structural.Decorator;

public class BeforeDecorator {
    public static void main(String[] args) {
        Soju soMaek = new SoMaek();
        soMaek.drink();
        Soju soCol = new SoCol();
        soCol.drink();
    }
}

class Soju {
    public void drink() {
        System.out.println("소주를 마신다");
    }
}

class SoMaek extends Soju {
    @Override
    public void drink() {
        System.out.print("맥주가 섞인 ");
        super.drink();
    }
}

class SoCol extends Soju {
    @Override
    public void drink(){
        System.out.print("콜라가 섞인 ");
        super.drink();
    }
}
