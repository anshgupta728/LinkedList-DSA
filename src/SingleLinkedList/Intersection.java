package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class Intersection {
	static Node head1;
	static Node head2;
		
	private Node insert_begin(Node head,int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
		return head;
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
	
	private int length(Node node) {
		int length=0;
		while(node!=null) {
			length++;
			node=node.next;
		}
		return length;
	}
	
	private int findIntersection(Node head1,Node head2) {
		int l1=length(head1);
		int l2=length(head2);
		Node ptr1,ptr2;
		int d=0;
		if(l1>l2) {
			d=l1-l2;
			ptr1=head1;
			ptr2=head2;
		}
		else {
			d=l2-l1;
			ptr2=head1;
			ptr1=head2;
		}
		while(d--!=0) {
			ptr1=ptr1.next;
			if(ptr1==null) {
				return -1;
			}
		}
		
		while(ptr1!=null && ptr2!=null) {
			if(ptr1==ptr2)
				return ptr1.data;
			ptr1=ptr1.next;
			ptr2=ptr2.next;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Intersection obj=new Intersection();
		
		/* List 1:     1->2->3->4
        						 \
         						  5->6->null 
        						 /      
	       List 2:         	9->10              */
		
		head1=obj.insert_begin(head1, 6);
		head1=obj.insert_begin(head1, 5); 
		head1=obj.insert_begin(head1, 4);
		head1=obj.insert_begin(head1, 3); 
		head1=obj.insert_begin(head1, 2);
		head1=obj.insert_begin(head1, 1);
		obj.display(head1);
		head2=obj.insert_begin(head2, 10);
		head2=obj.insert_begin(head2, 9);
		head2.next.next=head1.next.next.next.next;
		obj.display(head2); 
		System.out.println(obj.findIntersection(head1,head2));
	}

}
