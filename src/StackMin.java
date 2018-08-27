

class StackMin{
    StackMin next;
    int data;
    int minimum;
    StackMin(int d){
        data = d;
        minimum = data;
    }
    void push(int d){
        StackMin newTop = new StackMin(d);
        if(minimum > newTop.minimum) minimum = newTop.minimum;
        newTop.next = next;
        next = newTop;
    }
    int pop(){
        if(next!=null){
            int d = next.data;
            next = next.next;
            return data;
        } else{
            int d = data;
            data = -1;
            return d;
        }
    }
    int getMin() {return minimum;}
}