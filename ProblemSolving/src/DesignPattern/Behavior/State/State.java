package DesignPattern.Behavior.State;

public interface State {
    public abstract void study(SeobSeob seobseob);
}

class NormalState implements State {

    @Override
    public void study(SeobSeob seobseob) {
        System.out.println("천천히 공부한다.");
        //평상시로 공부하다가 바쁜시즌이 돌아옴
        seobseob.changeState(new BusyState());
    }
}

class BusyState implements State {

    @Override
    public void study(SeobSeob seobseob) {
        System.out.println("열심히 공부한다.");
        //열심히 공부했으니 상태가 여유롭게 됨
        seobseob.changeState(new FreeState());
    }
}

class FreeState implements State {

    @Override
    public void study(SeobSeob seobseob) {
        System.out.println("여유있게 공부한다.");
        //여유있게 공부하다보니 다시 조금씩 할일이 생겨 평상시로 돌아옴
        seobseob.changeState(new NormalState());
    }
}
