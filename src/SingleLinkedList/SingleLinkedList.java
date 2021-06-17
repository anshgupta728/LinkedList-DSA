package SingleLinkedList;
public class SingleLinkedList {
	
	private static Node head;
	private static int count;
	
	private SingleLinkedList() {
		head=null;
		count=0;
	}
	
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			next=null;
		}
	}
	
	//Insert at beginning
	private void insert_begin(int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
		count++;
	}
	
	//Insert at middle
	private void insert_middle(int data,int pos) {
		if(pos==0) {
			insert_begin(data);
		}
		else if(pos>0&&pos<=count) {
			Node temp=head;
			int i=0;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			Node toAdd=new Node(data);
			toAdd.next=temp.next;
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
			Node toAdd=new Node(data);
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=toAdd;
			count++;
		}
	}
	
	//Deletion at beginning
	private void delete_begin() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else {
			head=head.next;
			count--;
		}
	}
	
	//Deletion at middle
	private void delete_middle(int pos) {
		if(pos==0) {
			delete_begin();
		}
		else if(pos>0&&pos<count) {
			Node temp=head;
			int i=0;
			while(i<pos-1) {
				temp=temp.next;
				i++;
			}
			temp.next=temp.next.next;
			count--;
		}
		else {
			System.out.println("Position entered is not valid!");
		}
	}
	
	//Deletion at beginning
	private void delete_end() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else if(head.next==null){
			head=null;
			count--;
		}
		else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next=null;
			count--;
		}
	}
	
	//Print the Linked List
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
			System.out.println("Number of nodes: "+count);
			System.out.println("******************************************");
		}
	}
	
	public static void main(String[] args) {
		SingleLinkedList obj=new SingleLinkedList();
		obj.insert_end(23);
		obj.insert_end(24);
		obj.insert_begin(33);
		obj.insert_begin(32);
		obj.insert_begin(31);
		obj.insert_begin(42);
		obj.display();
		obj.insert_middle(44,3);
		obj.display();
		obj.delete_begin();
		obj.display();
		obj.delete_end();
		obj.display();
		obj.delete_middle(3);
		obj.display();
	}
}
