import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int quantum;
    public static int currentTime = 0;
    public Main() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int quantum = scan.nextInt();

        Queue queue = new Queue(100000 + n);
        this.quantum = quantum;

        while(scan.hasNext()){
            String pName = scan.next();
            int time = scan.nextInt();
            queue.enqueue(new Data(pName,  time));
        }
        while(!queue.isEmpty()){
            Data data = queue.dequeue();
            if(data.time == 0){
                System.out.println(data.pName + " " + currentTime);
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private class Queue{
        private int head = 0;
        private int tail = 0;
        private Data queue[];

        public Queue(int size){
            queue = new Data[size*2];
        }

        public void enqueue(Data data){
            queue[tail++] = data;
        }

        public Data dequeue(){
            Data data = queue[head++];
            int time = expendedTime(data);
            if(data.time != 0){
                enqueue(data);
            }
            currentTime += time;
            return data;
        }

        public int expendedTime(Data data){
            int time;
            if(data.time > quantum){
                time = quantum;
                data.time -= quantum;
            }else{
                time = data.time;
                data.time = 0;
            }
            return time;
        }

        public boolean isEmpty(){
            return head == tail;
        }

    }

    private class Data{
        public String pName;
        public int time;

        public Data(String pName,  int time){
            this.pName = pName;
            this.time = time;
        }
    }
}
