package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class Reverse {
	
	public static Node head;
	
	private Reverse() {
		head=null;
	}
	
	private void insert_begin(int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
	}
	
	private Node reverse_iter(Node node) {
		if(node==null) {
			System.out.println("Linked List is Empty! Nothing to reverse.");
			return null;
		}
		Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
	}
	
	private void display(Node node) {
		if(node==null) {
			System.out.println("Linked List is Empty! Nothing to print.");
		}
		else {
			Node temp=node;
			System.out.println("Nodes in Linked List:");
			while(temp!=null) {
				System.out.print(temp.data+" -> ");
				temp=temp.next;
			}
			System.out.print("null");
			System.out.println();
			System.out.println("******************************************");
		}
	}
	
	public static void main(String[] args) {
		Reverse obj=new Reverse();
		obj.insert_begin(33);
		obj.insert_begin(32);
		obj.insert_begin(31);
		obj.insert_begin(42);
		obj.insert_begin(45);
		System.out.println("Original List:");
		obj.display(head);
		head=obj.reverse_iter(head);
		System.out.println("Reversed List");
		obj.display(head);
	}

}
