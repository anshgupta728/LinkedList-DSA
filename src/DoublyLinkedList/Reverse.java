package DoublyLinkedList;
import DoublyLinkedList.DoublyLinkedList.DLLNode;
public class Reverse {
	
	private static DLLNode head;
	
	private Reverse() {
		head=null;
	}
	
	public void insert_begin(int data) {
		DLLNode toadd=new DLLNode(data);
		toadd.next=head;
		toadd.prev=null;
		if(head!=null) {
			head.prev=toadd;
		}
		head=toadd;
	}
	
	public DLLNode reverse_iter(DLLNode node) {
		if(node==null) {
			System.out.println("Linked List is Empty! Nothing to reverse.");
			return null;
		}
		DLLNode prev = null;
        DLLNode current = node;
        DLLNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
	}
	
	private void display() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to print.");
		}
		else {
			DLLNode temp=head;
			System.out.println("Nodes in Linked List:");
			System.out.print("null -> ");
			while(temp!=null) {
				System.out.print(temp.data+" <-> ");
				temp=temp.next;
			}
			System.out.print("null");
			System.out.println();
			System.out.println("******************************************");
		}
	}
	
	public static void main(String[] args) {
		Reverse obj=new Reverse();
		obj.insert_begin(23);
		obj.insert_begin(24);
		obj.insert_begin(33);
		obj.insert_begin(32);
		obj.insert_begin(31);
		obj.display();
		head=obj.reverse_iter(head);
		obj.display();
	}

}
