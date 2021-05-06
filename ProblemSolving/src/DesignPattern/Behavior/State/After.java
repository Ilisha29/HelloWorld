package DesignPattern.Behavior.State;

public class After {
    public static void main(String[] args) {
        SeobSeob seobseob = new SeobSeob(new NormalState());
        System.out.println("=====공부 시작=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
        System.out.println("=====몇 주 뒤=======");
        seobseob.study();
        seobseob.eating();
    }
}

class SeobSeob {
    State state;

    SeobSeob(State state) {
        this.state = state;
    }

    public void study() {
        this.state.study(this);
    }

    public void eating() {
        System.out.println("어떠한 상황에도 밥은 맛있게 먹는다.");
    }

    public void changeState(State newState) {
        this.state = newState;
    }
}