package DoublyLinkedList;
public class DoublyLinkedList {
	
	private static DLLNode head;
	private static int count;
	
	private DoublyLinkedList() {
		head=null;
		count=0;
	}
	
	public static class DLLNode {
		int data;
		DLLNode prev,next;
		public DLLNode(int data) {
			this.data=data;
			prev=null;
			next=null;
		}
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
	
	//Deletion in beginning
	private void delete_begin() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else {
			if(head.next==null) {
				head=null;
				count--;
			}
			else {
				head.next.prev=null;
				head=head.next;
				count--;
			}
		}
	}
	
	//Delete at middle
	private void delete_middle(int pos) {
		if(pos==0) {
			delete_begin();
		}
		else if(pos>0&&pos<count) {
			DLLNode temp=head;
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
	
	//Deletion in ending
	private void delete_end() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to delete.");
		}
		else {
			DLLNode temp=head;
			if(temp.next==null) {
				head=null;
				count--;
			}
			else {
				while(temp.next.next!=null) {
					temp=temp.next;
				}
				temp.next=null;
				count--;
			}
		}
	}	
	
	//Print the Linked List
	private void display() {
		if(head==null) {
			System.out.println("Linked List is Empty! Nothing to print.");
		}
		else {
			DLLNode temp=head;
			System.out.println("Nodes in Linked List:");
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
		DoublyLinkedList obj=new DoublyLinkedList();
		obj.insert_begin(23);
		obj.insert_begin(45);
		obj.insert_end(42);
		obj.insert_middle(41,2);
		obj.display();
		obj.delete_begin();
		obj.delete_end();
		obj.display();
		obj.insert_begin(45);
		obj.display();
		obj.delete_middle(2);
		obj.display();
	}

}
