import java.util.*;

public class PQueue<T> {
    class Node{
        T data;
        int priority;
    }

    public PQueue(){
        queue = new LinkedList<>();
    }

    List<Node> queue;

    public void add(T element, int priority){ // Suma zlozonosci, a zatem zlozonosc operacji najbardziej zlozonej - O(n)
        if (queue.isEmpty()){ // Zlozonosc O(1)
            Node temp = new Node();
            temp.data = element;
            temp.priority = priority;
            queue.add(temp);
        }
        else{
            if (queue.get(0).priority > priority){ // Zlozonosc O(1)
                Node newNode = new Node();
                newNode.data = element;
                newNode.priority = priority;
                queue.add(0, newNode);
            }
            else{ // Zlozonosc O(n)
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

    public T get(){ // Zlozonosc O(1)
        T temp = queue.get(0).data;
        queue.remove(0);
        return temp;
    }

    public T peek(){ // Zlozonosc O(1)
        return queue.get(0).data;
    }

    public void traverse(){ // Zlozonosc O(n)
        for (Node current_node: queue){
            System.out.println(current_node.data);
        }
        return;
    }

    public static void main(String[] args) {
        PQueue<String> pq = new PQueue<>();
        pq.add("Not", 2);
        pq.add("Page", 1);
        pq.add("Error", 0);
        pq.add(":(", 3);
        pq.add("404", 0);
        pq.add("Found", 2);
        pq.traverse();
        System.out.println("Usunieto element: " + pq.get());
        pq.traverse();
        System.out.println("Podgladany element: " + pq.peek());
    }
}

