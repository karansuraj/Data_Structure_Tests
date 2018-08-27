import java.util.*;
public class Main {
    public static void main(String[] args) {
    /*System.out.println(AA1_4("torvalds", "vladsrot")); //true
    System.out.println(AA1_4("apple", "leepap")); //false*/
        //System.out.println(repSpace1_5("HELL O B"));
        //testLL();
        //testsumLL();
        //testFindStartLoop();
        //testStackMin();
        testSOStacks();
    }

    static void testSOStacks(){
        SetOfStacks ts = new SetOfStacks();
        ts.push(4);
        ts.push(3);
        ts.push(7);
        ts.push(2);
        ts.push(6);
        ts.push(1);
        ts.push(9);
        //System.out.println(ts.pop());
        //System.out.println(ts.stackSize);
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        System.out.println(ts.pop());
        System.out.println("Number of Stacks: "+ts.numStacks);
        //System.out.println(ts.stackSize);
    }

    static void testStackMin(){
        StackMin ts = new StackMin(2);
        ts.push(4);
        ts.push(3);
        //ts.push(1);
        //System.out.println(ts.pop());
        //System.out.println(ts.pop());
        System.out.println(ts.data);
        //System.out.println(ts.pop());
        //System.out.println(ts.pop());
    }

    static void testFindStartLoop(){
        LL tll = new LL(2);
        tll.appendToTail(3);
        tll.appendToTail(8);
        tll.appendToTail(7);
        tll.appendToTail(4);
        tll.makeCircular3rd();
        //tll.print();
        System.out.println(findStartLoop2_5(tll)); //print data at start loop node
    }

    static int findStartLoop2_5(LL origLL){
        //considering that there is circular loop, assume no nulls
        LL looper1 = origLL;
        LL looper2 = origLL.next.next; //2 off from looper1, double traverse
        int count = 1;
        while(looper1 != looper2){
            looper1 = looper1.next;
            looper2 = looper2.next.next;
        }
        looper1 = looper1.next;
        while(looper1 != looper2){ //looper2 remains constant & looper 1 circles back
            count++;
            looper1 = looper1.next;
        }
        outer:
        while(origLL != looper1){
            for(int i = 0; i<count; i++){
                if(origLL==looper1) break outer;
                looper1 = looper1.next;
            }
            origLL = origLL.next;
        }
        return origLL.data;
    }

    static void testsumLL(){
        LL tll = new LL(2);
        tll.appendToTail(3);
        tll.appendToTail(8);

        LL tll2 = new LL(2);
        tll2.appendToTail(3);
        tll2.appendToTail(4);
        //tll2.appendToTail(8);

        LL tllSum = sumLLs2_4(tll, tll2);
        tllSum.print();
    }

    static LL sumLLs2_4(LL n, LL m){
        LL sumLL = null;
        boolean n_loop = true;
        boolean m_loop = true;
        int n_data;
        int m_data;
        int sum;
        int rem = 0;
        while(n_loop | m_loop){
            if(n==null){
                n_data=0;
                n_loop = false;
            } else{
                n_data = n.data;
                n = n.next;
            }
            if(m==null){
                m_data=0;
                m_loop = false;
            } else{
                m_data = m.data;
                m = m.next;
            }
            sum = n_data + m_data + rem;
            if(sum>10){
                rem = 1;
                sum = sum - 10;
            }
            else rem = 0;
            if(sumLL==null) sumLL = new LL(sum);
            else {
                if(sum!=0 || rem !=0) sumLL.appendToTail(sum);
            }
        }
        if(rem>0) sumLL.appendToTail(rem);
        return sumLL;
    }

    static void testLL(){
        LL tll = new LL(2);
        tll.appendToTail(3);
        tll.appendToTail(4);
        tll.print();
    }
    static void testStack(){
        Stack ts = new Stack(2);
        ts.push(4);
        ts.push(3);
        System.out.println(ts.pop());
        System.out.println(ts.pop());
        System.out.println(ts.pop());
        System.out.println(ts.pop());
    }
  /*public static String repSpace1_5(String str){
    return str.replace(" ", "%20");
  }
  public static boolean AA1_4(String str1, String str2){
    StringBuilder sb2 = new StringBuilder(str2);
    Character currChar;
    int sb2Ind;
    for(int i=0; i<str1.length(); i++){
      currChar = str1.charAt(i);
      sb2Ind = sb2.toString().indexOf(currChar);
      if(sb2Ind == -1) return false;
      sb2.deleteCharAt(sb2Ind);
    }
    if(sb2.length()>0) return false;
    return true;
  }*/
}