//height of a tree
//Count Node
//Sum of all Node
//Diameter
//Subtree of another tree
//Top view of a tree
package BinaryTree;

import java.util.*;

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
  public static int diameter(Node root){ //O(N^2)
    if(root==null){
      return 0;
    }
    int leftdiam = diameter(root.left);
    int rightdiam = diameter(root.right);
    int leftHeight =height(root.right);
    int rightHeight = height(root.right);
     int selfDiam =leftHeight +rightHeight +1;
    return Math.max(Math.max(leftdiam,rightdiam), selfDiam);
  }
  static class Info{
    int d ;
    int h;
     Info(int d,int h){
      this.d=d;
      this.h=h;
     }
  }
  public static Info diameter2(Node root){ //O(N)
    if(root==null){
      return new Info(0,0);
    }
    Info leftInfo = diameter2(root.left);
    Info rightInfo = diameter2(root.right);
     int selfHeight =Math.max(leftInfo.h ,rightInfo.h)  +1;
     int selfDiameter =Math.max(Math.max(leftInfo.d, rightInfo.d),leftInfo.h+ rightInfo.h +1 );
     Info newInfo = new Info(selfDiameter, selfHeight) ;

    return newInfo;
  }
  //---------------------Subtree of another tree------------------
  public static boolean isIdentical(Node node, Node subRoot){
    if(node == null && subRoot==null) {
      return true;
      //chech Condn for non identical
    }else if(node == null || subRoot==null ||node.data != subRoot.data ){
      return false;
    }
    if(!isIdentical(node.left,subRoot.left)){
      return false;
    }
    if(!isIdentical(node.right,subRoot.right)){
      return false;
    }
  return true;
  }
  public static boolean isSubtree(Node root, Node subRoot){
    //base case
    if(root==null){
      return false;
    }
    if(root.data==subRoot.data){
      
      if(isIdentical(root,subRoot)){
        return true;
      }
    }
    return isSubtree(root.left,subRoot) || isSubtree(root.left,subRoot);
  }
   //---------------------Subtree of another tree------------------
   //---------------------Top view of a tree-----------------------
   public static class Info2{
    Node node;
    int hd;
    Info2(Node node,int hd){
      this.node=node;
      this.hd=hd;
    }
   }
   public static void topView(Node root){
    int min=0,max=0;
    Queue<Info2> q = new LinkedList<>();
    HashMap<Integer,Node> map = new HashMap<>();
    q.add(new Info2(root, 0));
    q.add(null);// for next line
    while(!q.isEmpty()){
      Info2 curr = q.remove();
      if(curr == null){
        if(q.isEmpty()){
          break;

        }else{
          q.add(null);
        }
      }else{
        if(!map.containsKey(curr.hd)){ // hd occuring first time
          map.put(curr.hd,curr.node);
      }
      if(curr.node.left!=null){
        q.add(new Info2(curr.node.left, curr.hd-1));
        min= Math.min(min, curr.hd-1);
      }
      if(curr.node.right!=null){
        q.add(new Info2(curr.node.right, curr.hd+1));
        max= Math.max(max, curr.hd+1);
      }
 

      }
      
    }
    for(int i=min;i<=max;i++){
      System.out.print(map.get(i).data+" ");
    }

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
     System.out.println(diameter( root));
     System.out.println(diameter2(root).d);
     Node subRoot = new Node(2);
     subRoot.left = new Node(4);
     subRoot.right = new Node(5);
     System.out.println(isSubtree(root,subRoot));
     topView(root);
     
    
  }
  
}
