package DesignPattern.Structural.Proxy;

public class AfterProxy {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.doAction();
    }
}


interface Subject{
    void doAction();
}

class RealSubject implements Subject{

    @Override
    public void doAction() {
        System.out.println("핵심 로직 실행");
    }
}

class Proxy implements Subject{
    private RealSubject realSubject;

    @Override
    public void doAction() {
        System.out.println("부가기능 1 ");
        realSubject = new RealSubject();
        realSubject.doAction();
        System.out.println("부가기능 2");
    }
}