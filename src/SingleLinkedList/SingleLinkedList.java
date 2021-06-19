package SingleLinkedList;

public class SingleLinkedList {
	
	private static Node head;
	private static int count;
	
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			next=null;
		}
	}
	
	private SingleLinkedList() {
		head=null;
		count=0;
	}
	
	//Insert at beginning
	private void insert_begin(int data) {
		Node toAdd=new Node(data);
		toAdd.next=head;
		head=toAdd;
		count++;
	}
	
	//Insertion at middle
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
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else if(pos==0) {
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
	
	//Deletion at ending
	private void delete_end() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else if(head.next==null){
			delete_begin();
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
	
	//Searching an element 
	private boolean search(int val) {
		if(head==null) {
			return false;
		}
		Node temp=head;
		while(temp!=null) {
			if(temp.data==val) {
				return true;
			}
			temp=temp.next;
		}
		return false;
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
		obj.insert_begin(23);
		obj.insert_begin(24);
		obj.insert_begin(25);
		obj.insert_end(26);
		obj.display();
		obj.insert_middle(45, 0);
		obj.display();
		obj.delete_begin();
		obj.display();
		obj.delete_middle(1);
		obj.delete_end();
		obj.display();
		System.out.println(obj.search(23));
		System.out.println(obj.search(26));
	}
}
