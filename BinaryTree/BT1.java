//Build Tree
// tree traversal

package BinaryTree;
import java.util.*;

public class BT1 {
   static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
      this.data=data;
      this.left=null;
      this.right=null;
    }
  }
   static class Tree{
     static int idx=-1;// initial value will be null for every new root node
    public static Node buildTree(int[] nodes){//TC:-O(n)
      idx++;
      // for leave node
      if(nodes[idx] == -1){
        return null;
      }
      // creating node recursively
      Node newNode = new Node(nodes[idx]); // creating newNode
      newNode.left=buildTree(nodes); // left subtree
      newNode.right = buildTree(nodes);//right subtree
      return newNode;

    }
    public static void preorder(Node root){ // TC:- O(n)
      if(root == null){
        return;
      }
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
      
    }
    public static void inorder(Node root){ // TC:- O(n)
      if(root == null){
        return;
      }
      
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
      
      
      
    }
    
    public static void postorder(Node root){ // TC:- O(n)
      if(root == null){
        return;
      }
      
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
      
      
    }
    public static void levelorder(Node root){ //TC:- O(n)
      if(root==null){
        return;
      }
      Queue<Node> q = new LinkedList<>(); // Queue of nodes
      q.add(root);
      q.add(null);
      while(!q.isEmpty()){
        Node currNode = q.remove(); // current node
        if(currNode==null){
          System.out.println(); // next line for null
          if(q.isEmpty()){
            break; // When queue is empty...no need to add null again
          }else{
            q.add(null);  
          }
        }else{
          System.out.print(currNode.data+" "); 
        //check left-subtree
        if(currNode.left!=null){
        q.add(currNode.left);
        }
        // check right subtree
        if(currNode.right!=null){
          q.add(currNode.right);
        }
      }
      }
    }
  }
  public static void main(String[] args) {
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    Tree t = new Tree();
    Node root = t.buildTree(nodes);
    //System.out.println(root.data);
    t.preorder(root);
    System.out.println();
    t.inorder(root);
    System.out.println();
    t.postorder(root);
    System.out.println();
    t.levelorder(root);
  }
  
}
