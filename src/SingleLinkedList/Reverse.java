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
	
	private Node reverse_recur(Node head) {
		if(head==null||head.next==null) {
			return head;
		}
		Node newhead=reverse_recur(head.next);
		head.next.next=head;
		head.next=null;
		return newhead;
	}
	
	private Node reverse_iter(Node head) {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to reverse.");
			return null;
		}
		//1->2->3->4
		Node prev=null;    
        Node current=head; 
        Node next;    
        while (current != null) {
            next = current.next;  
            current.next = prev;
            prev = current;
            current = next;
        }
        head=prev;
        return head;
	} 
	
	private void display() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to print.");
		}
		else {
			Node temp=head;
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
		obj.display();
		head=obj.reverse_recur(head);
		System.out.println("Reversed List");
		obj.display();
		/*head=obj.reverse_iter(head);
		System.out.println("Reversed List");
		obj.display();*/
	}

}
