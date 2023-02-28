package LinkList;

public class LinklistRotation {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Function to rotate a linked list.
    void rotate(int k)
    {
        // let us consider the example
        // 10->20->30->40->50->60 - k=4
        // initialising 2 nodes temp and last
        Node last = head;
        Node temp = head;

        // if head is null or k==0 no rotation is required
        if (head == null || k == 0) {
            return;
        }

        // Making last point to the last-node of the given
        // linked list in this case 60
        while (last.next != null) {
            last = last.next;
        }

        // Rotating the linked list k times, one rotation at a
        // time.
        while (k != 0) {

            // Make head point to next of head
            // so in the example given above head becomes 20
            head = head.next;

            // Making next of temp as null
            // In the above example :10->null
            temp.next = null;

            // Making temp as last node
            // (head)20->30->40->50->60->10(last)
            last.next = temp;
            last = temp;

            // Point temp to head again for next rotation
            temp = head;
            k--;
        }
    }

    void push(int new_data)
    {
        // 1 & 2: Allocate the Node & Put in the data
        Node new_node = new Node(new_data);

        // 3. Make next of new Node as head
        new_node.next = head;

        // 4. Move the head to point to new Node
        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        LinklistRotation llist = new LinklistRotation();

        // create a list 10->20->30->40->50->60
        for (int i = 60; i >= 10; i -= 10)
            llist.push(i);

        System.out.println("Given list");
        llist.printList();

        llist.rotate(4);

        System.out.println("\nRotated Linked List");
        llist.printList();
    }
}