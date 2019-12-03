import java.util.*; 
class tree{ 
  
static class Node {  
    Node left, right, parent;  
    int value;  
} 
static Node newNode(int value)  
{  
    Node temp = new Node();  
    temp.left = null; 
    temp.right = null; 
    temp.parent = null;  
    temp.value = value;  
    return temp;  
}  
  
static Node postorderPredecessor(Node root, Node n)  
{  
	if(n==null || root==null)
		return null;
	
    if (n.right!=null) 
          return n.right;
    if(n.left!=null)
    	return n.left;
    Node curre=n;
    Node parent = curre.parent;  
     while (parent != null && parent.left == curre) { 
        curre = curre.parent; 
        parent = parent.parent; 
    } 
   if (parent == null) 
        return null; 
    return parent.left; 
}  
public static void main(String[] args)  
{  
    Node root = newNode(20);  
    root.parent = null;  
    root.left = newNode(10);  
    root.left.parent = root;  
    root.left.left = newNode(4);  
    root.left.left.parent = root.left;  
    root.left.right = newNode(18);  
    root.left.right.parent = root.left;  
    root.right = newNode(26);  
    root.right.parent = root;  
    root.right.left = newNode(24);  
    root.right.left.parent = root.right;  
    root.right.right = newNode(27);  
    root.right.right.parent = root.right;  
    root.left.right.left = newNode(14);  
    root.left.right.left.parent = root.left.right;  
    root.left.right.left.left = newNode(13);  
    root.left.right.left.left.parent = root.left.right.left;  
    root.left.right.left.right = newNode(15);  
    root.left.right.left.right.parent = root.left.right.left;  
    root.left.right.right = newNode(19);  
    root.left.right.right.parent = root.left.right;  
    
    Node test= root.left.right.right;
    Node res = postorderPredecessor(root,test);  
    if (res!=null) { 
        System.out.println("Postorder predecessor of "+test.value+"is"+ res.value); 
    } 
    else { 
       System.out.println("Postorder predecessor of "+test.value+"is"+ "NULL\n");
    } 
}  
} 