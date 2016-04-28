import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public Main() {
    Scanner scan = new Scanner(System.in);

    Stack stack = new Stack(200);

    while(scan.hasNext()){
      String str = scan.next();
      stack.push(str);
    }
    System.out.println(stack.pop());
  }

  public static void main(String[] args) {
    new Main();
  }

  private class Stack{
    private int top = 0;
    private int stack[];

    public Stack(int size){
      stack = new int[size];
    }

    public void push(int n){
      stack[top++] = n;
    }

    public void push(String str){
      if(isInteger(str)){
        int n = Integer.parseInt(str);
        push(n);
      }else{
        int o1 = pop();
        int o2 = pop();

        if(str.equals("+")){
          push(o2+o1);
        }
        else if(str.equals("-")){
          push(o2-o1);
        }else{
          push(o2*o1);
        }
      }
    }

    public int pop(){
      return stack[--top];
    }

    public boolean isInteger(String str) {
      try {
        Integer.parseInt(str);
      } catch(NumberFormatException e) {
        return false;
      }
      return true;
    }
  }
}
