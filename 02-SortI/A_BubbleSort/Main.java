mport java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] = new int[100];

        for(int i=0;i<n;i++){
            A[i] = scan.nextInt();
        }
        int count = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=n-1;i>=1;i--){
                if(A[i] < A[i-1]){
                    count++;
                    // 要素の交換
                    int tmp = A[i];
                    A[i] = A[i-1];
                    A[i-1] = tmp;
                    flag = true;
                }
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
