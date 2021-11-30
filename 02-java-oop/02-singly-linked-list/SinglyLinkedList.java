public class SinglyLinkedList {

    // Attributes
    public Node head;

    // Constructors
    public SinglyLinkedList() {
        this.head = null;
    }

    // Methods
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove() {
        Node current = this.head;
        Node next = this.head.next;
        while ( next.next != null ) {
            current = next;
            next = next.next;
        }
        next = null;
        current.next = null;
    }
    public void printValues() {
        Node current = this.head;
        while ( current != null ) {
            System.out.println( current.value );
            current = current.next;
        }
    }
    public Node find( int x ) {
        Node current = this.head;
        while ( current != null ) {
            if ( current.value == x ) {
                return current;
            }
            else {
                current = current.next;
            }
        }
        return null;
    }
}