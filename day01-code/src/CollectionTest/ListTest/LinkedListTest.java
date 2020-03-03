package CollectionTest.ListTest;

/*
* LinkedList是list接口的实现类，包含大量操作首尾元素的方法，经常用作栈、队列
* 特点：增删快，查找慢
*/
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {

        //LinkedList可以用作堆栈：先进后出(这里假设链表的首部是栈顶)
        LinkedList<String> stack = new LinkedList<String>();
        stack.addFirst("a");
        stack.addFirst("b");
        stack.addFirst("c");
        System.out.println("------将LinkedList用作堆栈------");
        System.out.println("当前堆栈元素"+stack);

        //堆栈中的压栈与出栈
        System.out.println("出栈元素："+stack.pop());//API中说明pop方法和removeFirst方法等效
        System.out.println("当前堆栈元素"+stack);

        stack.push("d");//API中说明push()方法和addFirst()方法等效
        System.out.println("当前堆栈元素"+stack);

        //LinkedList可以用作队列：先进先出
        LinkedList<String> queue = new LinkedList<String>();
        queue.addLast("a");
        queue.addLast("b");
        queue.add("c"); //方法是等效的
        System.out.println("-----将LinkedList用作队列------");
        System.out.println("输出当前队列"+queue);

        //队列中的出队
        System.out.println("出队元素："+queue.removeFirst());
        System.out.println("当前队列"+queue);




    }
}
