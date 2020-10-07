package SeobNote;

public class CalculateMemory {
    public static void main(String[] args) {
        long preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        /*
        ...
        Code
        ...
         */
        long aftUserMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(aftUserMemory - preUseMemory); //단위 : Byte
    }
}
