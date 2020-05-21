public class PriorityQueue<T> {
    Node head;

    class Node {
        private int priority;
        private T data;
        private Node next;

        public Node(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        public Node(int priority, T data, Node next) {
            this.priority = priority;
            this.data = data;
            this.next = next;
        }
    }

    public void push(int priority, T data){
        Thread pushThread = new Thread() {
            public void run() {
                if (head == null ){
                    head = new Node(priority, data);
                    return;
                }

                if (priority > head.priority){
                    head = new Node(priority, data, head);
                    return;
                }

                Node p = head;
                while(p.next != null && priority <= p.next.priority ){
                    p = p.next;
                }
                p.next = new Node(priority, data, p.next);
            }
        };
    }

    public void pop(){
        Thread popThread = new Thread() {
            public void run() {
                if (head == null){
                    return;
                }
                T ret = head.data;
                head = head.next;
                return;
            }
        };
    }
}
