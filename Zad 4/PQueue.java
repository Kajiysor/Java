public class PQueue<E> {
    private ArrayQueue<E> [] queues;
    private int totalSize;
    private int highestNonEmptyQueue;

    /*
    * highestNonEmptyQueue is -1 when there are no element in every queue
    * items of X priority is stored in queues[X]
    * */

    public PQueue(int highest) {
        queues = new ArrayQueue[highest + 1];
        totalSize = 0;
        highestNonEmptyQueue = -1;

        // init each queue in the queues
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new ArrayQueue<E>();
        }

    }

    public void add(E element, int priority) {
        queues[priority].add(element);

        if (highestNonEmptyQueue == -1) {
            highestNonEmptyQueue = 0;
        } else if (priority > highestNonEmptyQueue) {
            highestNonEmptyQueue = priority;
        }

//        System.out.println(queues[priority].remove());
    }


    public E remove() {
        if (highestNonEmptyQueue == -1) return null;

        // remove the element from the queues[highestNOnEmptyQueue]
        // if the the highestNOnemptyQueue is 0 and it is empty, set highestNonEmptyQueue to -1

        // if the queue becomes empty after removal
        // find the next highest queue that have element

        E element = queues[highestNonEmptyQueue].remove();
        if (highestNonEmptyQueue == 0 && queues[highestNonEmptyQueue].isEmpty()) {
            highestNonEmptyQueue = -1;
        } else if (queues[highestNonEmptyQueue].isEmpty()) {

            int i = highestNonEmptyQueue - 1;
            for (i = highestNonEmptyQueue - 1; i >= 0; i--) {
                if (queues[i].isEmpty() == false) {
                    highestNonEmptyQueue = i;
                    break;
                }
            }
            // if reached the end and the end is empty
            if (i == 0 && queues[0].isEmpty()) {
                highestNonEmptyQueue = -1;
            }

        }

        return element;
    }


    public int size() {
        return totalSize;
    }


}