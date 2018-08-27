

class SetOfStacks{
    SetOfStacks next;
    Stack data;
    int StackLimit = 2; //The maximum number of elements a given stack can have
    int numStacks = 0; //Counter for number of stacks used
    void pushStack(Stack s){ //Create and add new stack to set
        SetOfStacks newTop = new SetOfStacks();
        newTop.data = s;
        newTop.next = next; //Pointing new stack to previous one
        next = newTop; //Moving new stack on top
    }
    void push(int d){
        if(data == null) { //If no stacks yet, create one and start stack set
            data = new Stack(d);
            next = new SetOfStacks();
            next.data = data; //Put Stack onto set of stacks
            numStacks++; //Increment the number of stacks used
        }
        else{ //If have stacks, check if reached a stack's size limit & add accordingly
            if(next.data.stackSize == StackLimit){
                pushStack(new Stack(d)); //Create new stack with elem and add to set
                numStacks++;
            } else next.data.push(d); //Just add to the topmost stack
        }
    }
    int pop(){ //Pop data off a stack and/or pop off stacks as they empty
        //Need to find a better way to write this function
        if(next==null) return -1; //Stack set is empty
        if(next.data.stackSize == 0){ //popping stack of stack set
            next = next.next;
            numStacks--;
            if(next==null) return -1; //Stack set is now empty
        }
        int res = next.data.pop(); //Normal stack pop
        if(next.data.stackSize == 0){//if just popped off last of a stack, pop stack off
            next = next.next;
            numStacks--;
        }
        return res;
    }
}