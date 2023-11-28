/**
 * Represents a singly linked list.
 */
public class List {

    private class Node {
        int value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n   The reference to the successor node.
         */
        Node(int val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(int val) {
            this(val, null);
        }
    }

    private Node first;

    /**
     * Constructor.
     */
    public List() {
        first = null;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e The value to add to the end of the list.
     */
    public void add(int e) {
        if (isEmpty()) {
            first = new Node(e);
        } else {
            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = new Node(e);
        }
    }

    /**
     * Adds an element at a specific position.
     *
     * @param index The position at which to add the element.
     * @param val   The element to add to the list.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public void add(int index, int val) {
        if (index < 0) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        if (index == 0) {
            first = new Node(val, first);
            return;
        }

        Node cur = first;
        int count = 0;
        while (cur != null && count != index - 1) {
            cur = cur.next;
            count++;
        }
        if (cur == null)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        Node tmp = new Node(val, cur.next);
        cur.next = tmp;
    }

    /**
     * Computes the string representation of the list.
     *
     * @return The string form of the list.
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        Node p = first;
        while (p.next != null) {
            strBuilder.append(p.value).append("->");
            p = p.next;
        }
        strBuilder.append(p.value);
        return strBuilder.toString();
    }

    /**
     * Removes the element at a specific index.
     *
     * @param index The index of the element to remove.
     * @return The element removed.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public int remove(int index) {
        if (first == null)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index < 0)
            throw new IndexOutOfBoundsException(String.valueOf(index));

        int val;
        if (index == 0) {
            val = first.value;
            first = first.next;
            return val;
        }

        Node cur = first;
        int count = 0;
        while (cur != null && count != index - 1) {
            cur = cur.next;
            count++;
        }
        if (cur == null)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        if (cur.next == null)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        val = cur.next.value;
        cur.next = cur.next.next;
        return val;
    }

    /**
     * Compares two lists for equality.
     *
     * @param obj The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj.getClass() != this.getClass())
            return false;
        List a = (List) obj;
        Node curThis = this.first;
        Node curObj = a.first;
        while (curThis != null && curObj != null) {
            if (curThis.value != curObj.value)
                return false;
            curThis = curThis.next;
            curObj = curObj.next;
        }
        return curThis == null && curObj == null;
    }

    /**
     * Reverses the linked list in place.
     */
    public void reverse() {
        Node prev = null;
        Node current = first;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = prev;
    }

    /**
     * Creates a string with integers in reverse order.
     *
     * @return A string with space-separated integers in reverse order.
     */
    public String reverseToString() {
        StringBuilder result = new StringBuilder();
        Node current = first;

        while (current != null) {
            result.insert(0, current.value).insert(0, " ");
            current = current.next;
        }

        return result.toString().trim();
    }

    /**
     * Recursively creates a string with integers in reverse order.
     *
     * @return A string with space-separated integers in reverse order.
     */
    public String recReverseToString() {
        if (first != null && first.next != null) {
            return recReverseToString(first.next) + first.value;
        }
        else{
            if(first!=null){
                return Integer.toString(first.value);
            }
            else{
                return "";
            }
        }
        
    }

    private String recReverseToString(Node current) {
        if (current == null) {
            return "";
        }
        return recReverseToString(current.next) + current.value + " ";
    }

    /**
     * Creates a deep copy of the list.
     * 
     * @return A new List object with the same elements.
     * @throws CloneNotSupportedException If cloning is not supported.
     */
    public List clone() {
        List clonedList = new List();
        Node current = first;

        while (current != null) {
            clonedList.add(current.value);
            current = current.next;
        }

        return clonedList;
    }

    /**
     * Moves the node with the smallest integer to become the first node.
     */
    public void smallestFirst() {




        if (first == null || first.next == null) {
            // Empty list or only one node, no change needed
            return;
        }
        if(first.next.next==null){
            first.next.next=first;
            first = first.next;
            first.next.next=null;
            return;
            
        }


        Node prev = null;
        Node smallestPrev = null;
        Node smallest = first;
        Node current = first.next;

        // Find the smallest node and its previous node
        while (current != null) {
            if (current.value < smallest.value) {
                smallest = current;
                smallestPrev = prev;
            }
            prev = current;
            current = current.next;
        }

        if (smallestPrev != null) {
            // Move the smallest node to the front
            smallestPrev.next = smallest.next;
            smallest.next = first;
            first = smallest;
        }
        // else: the smallest node is already at the front, no change needed
    }

    /**
     * Sorts the list using selection sort.
     */
    public void selectionSort() {
        Node sorted = null;
        Node current = first;
    
        while (current != null) {
            Node maxPrev = null;
            Node max = current;
            Node prev = null;
            Node temp = current;
    
            while (temp != null) {
                if (temp.value > max.value) {
                    maxPrev = prev;
                    max = temp;
                }
                prev = temp;
                temp = temp.next;
            }
    
            if (maxPrev != null) {
                maxPrev.next = max.next;
            } else {
                current = current.next;
            }
    
            max.next = sorted;
            sorted = max;
        }
    
        first = sorted;
    }
    
}
