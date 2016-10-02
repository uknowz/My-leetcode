// BinaryTree.java������Ƕ�������������
package mycode;
  
public class BinaryTree {
	class Node {//�ڲ��ֻ࣬�ж�����������Է���
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
  private Node root ;//ʵ�����������������ȫ�ֱ����������ж���,˽�б�������������Ķ�
  
  public Node getRoot(){//��ȡ˽�б���
	  return root;
  }
  /**
   Creates an empty binary tree -- a null root pointer.
  */
  public BinaryTree() {
    root = null ;//ȫ�ֱ�������root����ֵ����������
  }
  /**
   Inserts the given data into the binary tree.
   Uses a recursive helper.
  */
  public void insert(int data){
	  root = insert(root,data);//��root��ֵ������rootһֱΪnull��ÿ�ε��õ�ʱ�򣬶��Ǵ�root��ʼ�����Է���ֵΪroot����new node
  }
  /**
   Recursive insert -- given a node pointer, recur down and
   insert the given data into the tree. Returns the new
   node pointer (the standard way to communicate
   a changed pointer back to the caller).
    �÷���ʹ�õݹ��㷨�����׶�������ѭ�������ܲע���з���ֵ�����÷����ķ���ֵ����ֵ�ڵ����á���Ū�����㷨��ʱ��һ��һ��debug
  */
  private Node insert(Node node, int data) {//�������򣬽���ֵС�ķŵ�����������ķŵ�������
    if (node== null ) {
      node = new Node(data);//�����µĽڵ㣬�����Ǹ��βν����������ã������ĵ��ò���Ӱ��ʵ�Σ�new nodeʹ��node�����ò��ϸı䣬������insertʱ�����ʵ�����ò��޸ı䣬�����ǽ����õ���ʵ�Σ�����
      //ʱ��ʹ�õĶ�����ʵ�����õĶ������Ա��븳ֵ�����βε����ô��ݸ�ʵ�Σ�ʵ�����õĶ�����иı䡣������һ�㣬����������β����õĶ���ֵ�иı䣬ʵ�εĶ���Ҳ��ı䣬��Ϊ������ָ��һ�������
    }
    else {
      if (data <= node. data ) {
       node.left = insert(node. left , data);//�����ӽڵ㸳ֵ�������insert���������⣬Ϊʲô�����Ѿ���Ϊʵ�δ���ȥ�ˣ�ȴ����Ҫ����ֵ���¸�ֵ�أ���Ϊ�����ڲ��β����õĸı䲻��Ӱ��ʵ�ε�����
       //��˼�ǣ��ҽ����Ǵ�root���ȫ�ֱ�����ʼ�ģ����ı���Ҳ�Ǵ�����ʼ������root���벻�ϱ仯���ӽڵ㣬����insert����new node��ʱ�򣬸ı�����β�node���ã�ÿnewһ�������β�node�ĵ�ֵַ�ı䣬�������øı�
      //ע�⣡�����insert����ֵ��ֵ��node.left����Ȼ�ǽ��β����ô�������ʵ�Σ���Ϊ�ݹ��㷨�У����õڶ��κ���ʵ�Σ����ǵ�һ���������βΣ�����node.leftû��
      }
      else {
       node.right = insert(node. right , data);//�����ӽڵ㸳ֵ
      }
    }
    return node; // in any case, return the new pointer to the caller,ÿ��ִ��insert�����ص�node���Ǵ�root��ʼ�����нڵ㣬������ÿһ��new���½ڵ�
  }
  public void buildTree( int [] data){
    for ( int i=0;i<data. length ;i++){

         insert(data[i]);
      } 

  }
  /*
  public void printTree() {//������������������ڵ�root

      printTree( root );

      System. out .println();

     }
     */
  private void inOrderPrint(Node node) {//�������

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
	  
	  tree.inOrderPrint(tree.getRoot());//root��ʵ��������Ҳ����
  }
}