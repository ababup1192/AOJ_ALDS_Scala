import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // 初期値を仮で最小値に
        int minv = scan.nextInt();
        // 更新できるように最大値に十分小さい値を
        int maxv = Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            int in = scan.nextInt();
            // 最大値の更新
            maxv = Math.max(maxv,  in-minv);
            // 最小値の更新
            minv = Math.min(minv,  in);
        }
        System.out.println(maxv);
    }
}
