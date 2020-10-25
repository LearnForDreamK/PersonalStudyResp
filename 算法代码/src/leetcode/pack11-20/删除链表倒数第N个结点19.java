import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 删除链表倒数第N个结点19 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 把链表放入栈 顺序取出第N个结点即是要删除的结点 这里有点问题
     * @param head
     * @param n
     * @return
     */
    public  ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next==null){
            return head.next;
        }

        Stack<ListNode> result=new Stack<>();
        //存放所有值
        while(head.next!=null){
            result.add(head);
            head=head.next;
        }

        if(n==1){
            ListNode res,tmp,last1;
            res=null;
            last1=result.pop();
            for(int i=1;!result.isEmpty();i++){
               //取出最顶上一个
               res=result.pop();

               res.next=last1;

               last1=res;

            }
            return res;
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

    /**
     *
     * 先计算链表的长度 然后遍历到第L-N+1个位置删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     *
     * 标准栈解法
     * @param args
     */

    public ListNode removeNthFromEndStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        //5 4 3 2 1   2
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     *0 1 2 3 5 （5-2）+1
     * 双指针法
     *要删除的结点在L-n+1的位置
     * 一个指针先跑n步
     * 然后另一个指针在第一个指针跑n步的时候开始跑，两指针同时跑，等第一个指针跑到最后跑了总长度L步，这时第二个指针跑了l-n步
     * 即在要删除的结点的上一个节点停下来了
     * @param args
     */

    public ListNode removeNthFromEndE(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //fast移n步，
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null){
            return head.next;
        }


        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;
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
