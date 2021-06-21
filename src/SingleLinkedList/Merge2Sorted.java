package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class Merge2Sorted {

	static Node head1;
	static Node head2;
	static Node head3;
	
	private Node merge(Node head1,Node head2) {
		Node p1=head1;
		Node p2=head2;
		Node dummy=new Node(-1);
		Node p3=dummy;
		while(p1!=null&&p2!=null) {
			if(p1.data<p2.data) {
				p3.next=p1;
				p1=p1.next;
			}
			else {
				p3.next=p2;
				p2=p2.next;
			}
			p3=p3.next;
		}
		while(p1!=null) {
			p3.next=p1;
			p1=p1.next;
			p3=p3.next;
		}
		while(p2!=null) {
			p3.next=p2;
			p2=p2.next;
			p3=p3.next;
		}
		return dummy.next;
	}
	
	private void display(Node head) {
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
	
	private Node insert_begin(Node head,int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
		return head;
	}
	
	public static void main(String[] args) {
		Merge2Sorted obj=new Merge2Sorted();
		head1=obj.insert_begin(head1, 7);
		head1=obj.insert_begin(head1, 5); 
		head1=obj.insert_begin(head1, 4);
		head1=obj.insert_begin(head1, 1); 
		head2=obj.insert_begin(head2, 6);
		head2=obj.insert_begin(head2, 3);
		head2=obj.insert_begin(head2, 2);
		head3=obj.merge(head1,head2);
		obj.display(head3);
	}

}
