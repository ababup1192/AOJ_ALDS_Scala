import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] = new int[100];

        for(int i=0;i<n;i++){
            A[i] = scan.nextInt();
        }
        int count=0;
        int minj;
        int i,  j;
        for(i=0;i<n-1;i++){
            minj = i;
            for(j=i;j<n;j++){
                if(A[minj] > A[j]){
                    minj = j;
                }
            }
            if(i != minj){
                int tmp;
                tmp = A[i];
                A[i] = A[minj];
                A[minj] = tmp;
                count++;
            }
        }
        printArray(A,  n);
        System.out.println(count);
    }

    // スペース区切りで表示
    public static void printArray(int A[],  int n){
        int i;
        for(i=0;i<n-1;i++){
            System.out.print(A[i] + " ");
        }
        System.out.println(A[i]);
    }
}
