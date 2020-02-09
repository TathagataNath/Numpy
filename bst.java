import java.io.*;

class node
{
	int data;
	node left,right;
}

class binary_search_tree
{
	private node root;
	
	public binary_search_tree()
	{
		root=null;
	}
	
	public binary_search_tree(node r)
	{
		root=r;
	}
	
	public void insert() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		node cur=new node();
		
		System.out.print ("\nEnter Data : ");
		cur.data=Integer.parseInt(br.readLine());
		cur.left=null;
		cur.right=null;
		
		node c=root,p=null;
		while(c!=null)
		{
			p=c;
			if(cur.data < c.data)
				c=c.left;
			else
				c=c.right;
		}
		if(cur.data < p.data)
			p.left=cur;
		else
			p.right=cur;
	}
	
	/*public void search(int dat)
	{
		node c=root;
		
		while(c!=null)
		{
			if(c.data == dat)
				break;
			else if(c.data > dat)
				c=c.left;
			else
				c=c.right;
		}
		
		if(c == null)
			System.out.println ("\nDATA NOT FOUND");
		else
			System.out.println ("\nDATA FOUND");
	}*/
	
	public void search(node root,int dat)
	{
		if(root == null)
		{
			System.out.println ("\nDATA NOT FOUND");
			return;
		}
		else if(root.data == dat)
		{
			System.out.println ("\nDATA FOUND");
			return;
		}
		else if(root.data > dat)
			search(root.left,dat);
		else
			search(root.right,dat);
	}
	
	public void inorder_display(node root)
	{
		if(root!=null)
		{
			inorder_display(root.left);
			System.out.print (root.data+" ");
			inorder_display(root.right);
		};
	}
}

public class bst
{
	public static void main(String []args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		node root=new node();
		
		System.out.print ("Enter Data : ");
		root.data=Integer.parseInt(br.readLine());
		root.left=null;
		root.right=null;
		
		binary_search_tree ob=new binary_search_tree(root);
		System.out.println ();
		ob.inorder_display(root);
		System.out.println ();
		
		int ch;
		do
		{
			System.out.print ("\n1.Insert Data\n2.Inorder Display\n3.Search Data\n4.Exit\n\nEnter Your Choice : ");
			ch=Integer.parseInt(br.readLine());
			
			switch(ch)
			{
				case 1:
					
					ob.insert();
					System.out.println ();
					ob.inorder_display(root);
					System.out.println ();
					
					break;
					
				case 2:
					
					System.out.println ();
					ob.inorder_display(root);
					System.out.println ();
					
					break;
					
				case 3:
					
					System.out.print ("\nEnter Data To Search : ");
					int search_data=Integer.parseInt(br.readLine());
					
					ob.search(root,search_data);
					
					System.out.println ();
					ob.inorder_display(root);
					System.out.println ();
					
					break;
					
				case 4:
					
					System.out.println ("\nTHANK YOU");
					
					break;
					
				default:
					
					System.out.println ("\nWRONG CHOICE");
			}
		}while(ch!=4);
	}
}