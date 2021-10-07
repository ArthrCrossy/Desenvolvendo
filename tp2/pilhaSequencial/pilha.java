class pilha {
    static final int MAX = 1000;
    int top;
    int array[] = new int[MAX]; // Maximum size of Stack
 
    boolean isEmpty(){
        return (top < 0);
    }
    pilha(){
        top = -1;
    }
 
    boolean push(int x){
        if (top >= (MAX - 1)) {
            MyIO.println("Stack Overflow");
            return false;
        }else {
            array[top = 1 + top] = x;
            MyIO.println(x + " pushed into stack");
            return true;
        }
    }
 
    int pop(){
        if (top < 0) {
            MyIO.println("Stack Underflow");
            return 0;
        }else {
            int x = array[top--];
            return x;
        }
    }
 
    int peek(){
        if (top < 0) {
            MyIO.println("Stack Underflow");
            return 0;
        }else {
            int x = array[top];
            return x;
        }
    }
    
    void print(){
    for(int i = top;i>-1;i--){
    MyIO.print(" "+ array[i]);
    }
  }


  public static void main(String args[]){
    pilha s = new pilha();
    s.push(10);
    s.push(20);
    s.push(30);
    MyIO.println(s.pop() + " Popped from stack");
    MyIO.println("Top element is :" + s.peek());
    MyIO.print("Elements present in stack :");
    s.print();
}
}
 

