import java.util.*;

public class PQueue<E> {
    class Node{
        E data;
        int priority;
    }

    public PQueue(){
        queue = new LinkedList<>();
    }

    List<Node> queue;

    public void enqueue(E element, int priority){
        if (queue.isEmpty()){
            Node temp = new Node();
            temp.data = element;
            temp.priority = priority;
            queue.add(temp);
        }
        else{
            if (queue.get(0).priority > priority){
                Node newNode = new Node();
                newNode.data = element;
                newNode.priority = priority;
                queue.add(0, newNode);
            }
            else{
                int i = 0;
                for(; i<queue.size()-1; i++){
                    if (priority <= queue.get(i).priority){
                        break;
                    }
                }
                Node newNode = new Node();
                newNode.data = element;
                newNode.priority = priority;
                queue.add(i+1, newNode);
            }
        }
        return;
        
    }

    public E dequeue(){
        E temp = queue.get(0).data;
        queue.remove(0);
        return temp;
    }

    public E peek(){
        return queue.get(0).data;
    }

    public void traverse(){
        for (Node current_node: queue){
            System.out.println(current_node.data);
        }
        return;
    }

    public static void main(String[] args) {
        PQueue<String> pq = new PQueue<>();
        pq.enqueue("Not", 2);
        pq.enqueue("Page", 1);
        pq.enqueue("Error", 0);
        pq.enqueue(":(", 3);
        pq.enqueue("404", 0);
        pq.enqueue("Found", 2);
        pq.traverse();
        System.out.println("Usunieto element: " + pq.dequeue());
        pq.traverse();
        System.out.println("Podgladany element: " + pq.peek());
    }
}

