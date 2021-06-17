package DoublyLinkedList;
import DoublyLinkedList.DoublyLinkedList.DLLNode;
public class Reverse {
	
	private static DLLNode head;
	private static int count;
	
	private Reverse() {
		head=null;
		count=0;
	}
	
	//Insertion at beginning 
	private void insert_begin(int data) {
		DLLNode toadd=new DLLNode(data);
		toadd.next=head;
		if(head!=null) {
			head.prev=toadd;
		}
		head=toadd;
		count++;
	}
	
	//Insertion at middle
	private void insert_middle(int data,int pos) {
		if(pos==0) {
			insert_begin(data);
		}
		else if(pos==count) {
			insert_end(data);
		}
		else if(pos>0&&pos<count) {
			DLLNode temp=head;
			int i=0;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			DLLNode toAdd=new DLLNode(data);
			temp.next.prev=toAdd;
			toAdd.next=temp.next;
			toAdd.prev=temp;
			temp.next=toAdd;
			count++;
		}
		else {
			System.out.println("Position entered is not valid!");
		}
	}
		
	//Insertion at ending 
	private void insert_end(int data) {
		if(head==null) {
			insert_begin(data);
		}
		else {
			DLLNode toadd=new DLLNode(data);
			DLLNode temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			toadd.prev=temp;
			temp.next=toadd;
			count++;
		}
	}	
	
	//Reversing the linked list
	private DLLNode do_reverse(DLLNode node) {
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
	
	//Printing the linked list
	private void display() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to print.");
		}
		else {
			DLLNode temp=head;
			System.out.print("null <-> ");
			while(temp!=null) {
				System.out.print(temp.data+" <-> ");
				temp=temp.next;
			}
			System.out.print("null");
			System.out.println();
			System.out.println("Number of nodes: "+count);
			System.out.println("******************************************");
		}
	}
	
	public static void main(String[] args) {
		Reverse obj=new Reverse();
		obj.insert_begin(23);
		obj.insert_begin(24);
		obj.insert_end(22);
		obj.insert_end(21);
		obj.insert_middle(25,2);
		obj.insert_middle(26,3);
		obj.insert_begin(99);
		System.out.println("Original Linked List");
		obj.display();
		System.out.println("Linked List after reversing");
		head=obj.do_reverse(head);
		obj.display();
	}

}
