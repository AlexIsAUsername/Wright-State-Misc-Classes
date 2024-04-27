public class LinkedList {
    
    private Node head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int element) {
        Node newNode = new Node(element);
        
        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            size++;
        }
    }
    
    public int getSize() {
        return size;
    }

    public boolean removeN(int thingRemoved, int numRemoved) {
        int numThing = 0;
        Node current = head;
        while (current != null && numThing != numRemoved){
            if (current.getElement() == thingRemoved){
                numThing++;
            }
            current = current.getNext();
        }

        if (numThing == numRemoved && numRemoved != 0){
            current = head;
            Node next = current.getNext();
            while (current != null && numRemoved != 0){
                if (current == head && current.getElement() == thingRemoved){
                    current = current.getNext();
                    head = current;
                    if (head != null){
                        next = current.getNext();
                    }
                    size--;
                    numRemoved--;
                }
                else if (next.getElement() == thingRemoved){
                    current.setNext(next.getNext());
                    if (current != null){
                        next = current.getNext();
                    }
                    size--;
                    numRemoved--;
                }
                else{
                    current = current.getNext();
                    next = current.getNext();
                }
            }
        }

        if (numRemoved == 0){
            return true;
        }
        else{
            return false;
        }
    }
   
    @Override
    public String toString() {
        String s = "";
        if (head == null) {
            return s;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                s += current.toString() + ", ";
                current = current.getNext();
            }
            s += current.toString(); // last item has no trailing comma
            return s;
        }
    }
    
}
