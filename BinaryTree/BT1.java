//Build Tree
//TC:-O(n)
package BinaryTree;

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
    public Node buildTree(int[] nodes){
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
    

  }
  public static void main(String[] args) {
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    Tree t = new Tree();
    Node root = t.buildTree(nodes);
    System.out.println(root.data);
    
  }
  
}
