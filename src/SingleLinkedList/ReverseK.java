package SingleLinkedList;
import SingleLinkedList.SingleLinkedList.Node;
public class ReverseK {
	
	public static Node head;
	
	private ReverseK(){
		head=null;
	}
	
	private void insert_begin(int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
	}
	
	private Node reverse(Node head,int k) {
		
		Node prev =null;      
        Node current=head;   
        Node next=null;           
        int count=0;
        while (current != null && count<k) {
            next=current.next;  
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        if(next!=null) {
        	head.next=reverse(next,k);
        }
        return prev;
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
		ReverseK obj=new ReverseK();
		obj.insert_begin(45);
		obj.insert_begin(12);
		obj.insert_begin(34);
		obj.insert_begin(47);
		obj.insert_begin(89);
		obj.insert_begin(90);
		obj.display();
		head=obj.reverse(head,3);
		obj.display();
	}

}
