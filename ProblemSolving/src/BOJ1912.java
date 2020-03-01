import java.util.Scanner;

public class BOJ1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long [] arr = new long[T];
        for(int i=0; i<T; i++){
            arr[i]= sc.nextInt();
        }
        long [] D = new long[T];
        long imax = arr[0];
        D[0] = arr[0];
        for(int i=1; i<T; i++){
            if((D[i-1]+arr[i]) > arr[i]){
                D[i] = D[i-1]+arr[i];
            }else{
                D[i] = arr[i];
            }
            if(D[i]>imax){
                imax = D[i];
            }
        }
        System.out.println(imax);
    }
}
