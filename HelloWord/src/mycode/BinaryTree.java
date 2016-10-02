// BinaryTree.java，这个是二叉树建树过程
package mycode;
  
public class BinaryTree {
	class Node {//内部类，只有定义它的类可以访问
	    Node left ;
	    Node right ;
	    int data ;
	    Node( int newData) {
	      left = null ;
	      right = null ;
	      data = newData;
	    }
	  }
  // Root node pointer. Will be null for an empty tree.
  private Node root ;//实例变量和类变量都是全局变量，在类中定义,私有变量，不能随意改动
  
  public Node getRoot(){//获取私有变量
	  return root;
  }
  /**
   Creates an empty binary tree -- a null root pointer.
  */
  public BinaryTree() {
    root = null ;//全局变量，给root赋初值，建立空树
  }
  /**
   Inserts the given data into the binary tree.
   Uses a recursive helper.
  */
  public void insert(int data){
	  root = insert(root,data);//给root赋值，否则root一直为null，每次调用的时候，都是从root开始，所以返回值为root不是new node
  }
  /**
   Recursive insert -- given a node pointer, recur down and
   insert the given data into the tree. Returns the new
   node pointer (the standard way to communicate
   a changed pointer back to the caller).
    该方法使用递归算法，简单易懂，但比循环的性能差，注意有返回值，利用方法的返回值，赋值节点引用。当弄不懂算法的时候，一步一步debug
  */
  private Node insert(Node node, int data) {//建树规则，将数值小的放到左子树，大的放到右子树
    if (node== null ) {
      node = new Node(data);//建立新的节点，但是是给形参建立对象引用，函数的调用不会影响实参，new node使得node的引用不断改变，但调用insert时传入的实参引用并无改变，而我们建树用的是实参，遍历
      //时，使用的对象是实参引用的对象，所以必须赋值，将形参的引用传递给实参，实参引用的对象才有改变。不过有一点，如果方法内形参引用的对象值有改变，实参的对象也会改变，因为他们是指向一个对象的
    }
    else {
      if (data <= node. data ) {
       node.left = insert(node. left , data);//给左子节点赋值，对这个insert函数有问题，为什么引用已经作为实参传进去了，却还需要返回值重新赋值呢，因为方法内部形参引用的改变不会影响实参的引用
       //意思是，我建树是从root这个全局变量开始的，随后的遍历也是从他开始，所以root必须不断变化，加节点，但是insert函数new node的时候，改变的是形参node引用（每new一个对象，形参node的地址值改变，就是引用改变
      //注意！这里把insert返回值赋值给node.left，仍然是将形参引用传出来给实参，因为递归算法中，调用第二次函数实参，就是第一个函数额形参，所以node.left没错
      }
      else {
       node.right = insert(node. right , data);//给右子节点赋值
      }
    }
    return node; // in any case, return the new pointer to the caller,每次执行insert，返回的node都是从root开始的所有节点，而不是每一个new的新节点
  }
  public void buildTree( int [] data){
    for ( int i=0;i<data. length ;i++){

         insert(data[i]);
      } 

  }
  /*
  public void printTree() {//给遍历方法，传入根节点root

      printTree( root );

      System. out .println();

     }
     */
  private void inOrderPrint(Node node) {//中序遍历

      if (node == null ) return ;
      // left, node itself, right
      inOrderPrint(node. left );
      System. out .print(node. data + " " );
      inOrderPrint(node. right );
     }
  private void preOrderPrint(Node node){
	  if(node == null) return;
	  System.out.print(node.data + " ");
	  preOrderPrint(node.left);
	  preOrderPrint(node.right);
  }
  private void postOrderPrint(Node node){
	  if(node == null) return;
	  postOrderPrint(node.left);
	  postOrderPrint(node.right);
	  System.out.print(node.data + " ");
  }
  public static void main(String[] args){
	  BinaryTree tree = new BinaryTree();
	  int[] data = {5,3,7,8,1,2,0};
	  tree.buildTree(data);
	  
	  tree.inOrderPrint(tree.getRoot());//root是实例变量，也就是
  }
}