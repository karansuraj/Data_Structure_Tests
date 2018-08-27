class Stack{
    Stack next;
    int data;
    int stackSize = 0;
    Stack(int d){
        data = d;
        stackSize++;
    }
    void push(int d){
        Stack newTop = new Stack(d);
        newTop.next = next;
        next = newTop;
        stackSize++;
    }
    int pop(){
        if(next!=null){
            int d = next.data;
            next = next.next;
            stackSize--;
            return d;
        } else{
            int d = data;
            data = -1;
            stackSize--;
            return d;
        }
    }
}