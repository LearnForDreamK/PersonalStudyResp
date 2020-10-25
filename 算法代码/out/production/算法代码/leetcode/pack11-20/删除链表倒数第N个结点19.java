import java.util.Stack;

public class 删除链表倒数第N个结点19 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public  ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null ){
            return head.next;
        }

        Stack<ListNode> result=new Stack<>();
        //存放所有值
        while(head.next!=null){
            result.add(head);
            head=head.next;
        }
        result.add(head);
        //5 4* 3 2 1
        //
        //1 2
        ListNode current,last,tmp;
        last=result.pop();
        current=last;
        for(int i=1;!result.isEmpty();i++){

            current=result.pop();
            //找到倒数第n个元素
            if(i+1==n){

                tmp=current;
                //取出下一个元素
                current=result.pop();
                //接上上一个元素
                current.next=tmp.next;
                //留给下一个元素接
                last=current;
            }else{
                current.next=last;
                last=current;
            }


        }

        return current;
    }

    public static void main(String[] args) {
        ListNode a,b,c,d,e;
        a=new ListNode(1);
        b=new ListNode(2,a);
        c=new ListNode(3,b);
        d=new ListNode(4,c);
        e=new ListNode(5,d);
        ListNode rs=new 删除链表倒数第N个结点19().removeNthFromEnd(e,2 );

        while(rs.next!=null){
            System.out.println(rs.val);
            rs=rs.next;
        }
        System.out.println(rs.val);

    }


}
