package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class AppendK {

	private static Node head=null;
	
	private int length(Node node) {
		int length=0;
		while(node!=null) {
			length++;
			node=node.next;
		}
		return length;
	}
	
	private void append(int k) {
		int length=length(head);
		if(k>=length||k<=0)
			return;
		Node temp=head;
		int pos=length-k-1;
		while(pos--!=0) {
			temp=temp.next;
		}
		Node newHead=temp.next;
		temp.next=null; 
	    temp=newHead;  
	    while(temp.next!=null) {
	    	temp=temp.next;
	    }
	    temp.next=head;
	    head=newHead;
	}
	
	private void insert_begin(int data) {
		//1->2->3->4->5->6
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
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
		AppendK obj=new AppendK();
		obj.insert_begin(6);
		obj.insert_begin(5);
		obj.insert_begin(4);
		obj.insert_begin(3);
		obj.insert_begin(2);
		obj.insert_begin(1);
		obj.display();
		obj.append(3);
		obj.display();
	}

}
