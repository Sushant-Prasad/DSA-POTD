//height of a tree
package BinaryTree;

public class BT2 {
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
  public static int height(Node root){
    if(root==null){
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    int height = Math.max(leftHeight, rightHeight)+1;
    return height;
  }
  public static int countNode(Node root){
    if(root==null){
      return 0;
    }
    int leftCount = countNode(root.left);
    int rightCount = countNode(root.right);
    int totalCountNode =leftCount + rightCount +1;
    return totalCountNode;
  }
  public static int sum(Node root){
    if(root==null){
      return 0;
    }
    int leftsum = sum(root.left);
    int rightsum = sum(root.right);
     int sum = (leftsum + rightsum +root.data);
    return sum;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left  = new Node(6);
     root.right.right  = new Node(7);
     System.out.println(height(root));
     System.out.println(countNode(root));
     System.out.println(sum(root));
    
  }
  
}
