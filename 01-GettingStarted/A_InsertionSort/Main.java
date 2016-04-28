import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] = new int[100];

        for(int i=0;i<n;i++){
            A[i] = scan.nextInt();
        }

        for(int i=1;i<n;i++){
            printArray(A,  n);
            int v = A[i];
            int j = i - 1;
            // 挿入先が見つかるまでループ
            // 挿入するため、見ていった要素を一個ずつ後方へズラす。
            while(j >=0 && A[j] > v){
                A[j+1] = A[j];
                j--;
                // 見つけた挿入場所へ挿入。
                A[j+1] = v;
            }
            printArray(A,  n);
        }
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
