package DesignPattern.Structural.Decorator;

public class AfterDecorator {
    public static void main(String[] args) {
        Soju2 goJinGamRae = new SoMaek2(new SoCol2(new Soju2Impl()));
        goJinGamRae.drink();
        System.out.println("를 마신다.");
    }
}

interface Soju2 {
    void drink();
}

class Soju2Impl implements Soju2 {

    @Override
    public void drink() {
        System.out.print("소주");
    }
}

abstract class AlcoholDecorator implements Soju2 {
    private Soju2 delegate;

    public AlcoholDecorator(Soju2 delegate) {
        this.delegate = delegate;
    }

    protected void doDelegate() {
        delegate.drink();
    }
}

class SoMaek2 extends AlcoholDecorator{

    public SoMaek2(Soju2 delegate) {
        super(delegate);
    }

    @Override
    public void drink() {
        System.out.print("맥주가 섞인 ");
        super.doDelegate();
    }
}

class SoCol2 extends AlcoholDecorator{

    public SoCol2(Soju2 delegate) {
        super(delegate);
    }

    @Override
    public void drink() {
        System.out.print("콜라가 섞인 ");
        super.doDelegate();
    }
}