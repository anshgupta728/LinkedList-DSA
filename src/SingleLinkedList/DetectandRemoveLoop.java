package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class DetectandRemoveLoop {
	
	static Node head=null;
	
	private boolean detectCycle() {
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	private void removeCycle() {
		Node slow=head;
		Node fast=head;
		do {
			slow=slow.next;
			fast=fast.next.next;
		}while(slow!=fast);
		
		fast=head;
		
		while(slow.next!=fast.next) {
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=null;
		//fast.next=null; to remove the whole loop
	}
	
	private void insert_begin(int data) {
		//1->2->3->4->5->6->7->8->9
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
	}
	
	private void insert_cycle() {
		//1->2->3->4->5->6->7->8->9  to   1->2->3->4->5->6->7->8->9    
		//                                         |______________|     
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head.next.next.next;    //9.next=4
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
		DetectandRemoveLoop obj=new DetectandRemoveLoop();
		obj.insert_begin(9);
		obj.insert_begin(8);
		obj.insert_begin(7);
		obj.insert_begin(6);
		obj.insert_begin(5);
		obj.insert_begin(4);
		obj.insert_begin(3);
		obj.insert_begin(2);
		obj.insert_begin(1);
		obj.insert_cycle();
		System.out.println(obj.detectCycle());
		obj.removeCycle();
		obj.display();
	}

}
