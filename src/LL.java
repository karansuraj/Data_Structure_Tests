class LL{
    LL next = null;
    int data;
    LL(int d){data = d;}
    void appendToTail(int d){
        LL newLL = new LL(d);
        LL currLL = this;
        while(currLL.next != null){currLL = currLL.next;}
        currLL.next = newLL;
    }
    void appendNode(LL node){
        LL currLL = this;
        while(currLL.next != null) currLL = currLL.next;
        currLL.next = node;
    }
    void print(){
        LL currLL = this;
        while(currLL != null) {
            System.out.println(currLL.data);
            currLL = currLL.next;
        }
    }
    boolean contains(LL node){
        LL thisLL = this;
        while(thisLL!=null){
            if(thisLL==node) return true;
            thisLL = thisLL.next;
        }
        return false;
    }
    void makeCircular3rd(){
        LL currLL = this;
        LL thirdElem = null;
        int count = 1;
        //if(currLL!= null){
        if(currLL.next != null){
            if(currLL.next.next != null){
                while(currLL.next != null){
                    if(count==3) thirdElem = currLL;
                    currLL = currLL.next;
                    count++;
                }
                currLL.next = thirdElem; //Connecting null end to 3rd element of LL
            }
        }
        //}
    }
}