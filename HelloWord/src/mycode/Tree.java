package mycode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 这个代码实现了二叉树的多种算法遍历，蛮经典的，但是泛型还是不会用
 */

//这个node类主要用来实现节点信息的，包括节点的值，左右子树
class Node<E extends Comparable<E>>{//extends接口，表示必须实现这个接口中的方法compareTo(T O)
	Node<E> left;
	Node<E> right;
	E value;
	
	Node(E value){
		this.value = value;
		left = null;
		right = null;
	}
	
	void preOrderPrint(){//这个函数内部只有一个功能，就是输出value的值，只不过不断递归达到遍历整个子树的目的
		System.out.print(value.toString() + " ");
		if(left != null)
			left.preOrderPrint();
		if(right != null)
			right.preOrderPrint();
	}
	
	
	
	void postOrderPrint(){
		if(left != null)
			left.postOrderPrint();
		if(right != null)
			right.postOrderPrint();
		System.out.print(value.toString() + " ");
	}
	
	//Print By Level
	void LevelOrderPrint(){
		if(this == null)
			throw new IllegalArgumentException("null node !");
		Queue<Node<E>> queue1 = new LinkedList<Node<E>>();
		Queue<Node<E>> queue2 = new LinkedList<Node<E>>();
		queue1.add(this);
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(queue2.isEmpty()){
				while(!queue1.isEmpty()){
					Node<E> currentNode = queue1.poll();
					System.out.print(currentNode.value.toString() + " ");
					if(currentNode.left != null){
						queue2.add(currentNode.left);
					}
					if(currentNode.right != null){
						queue2.add(currentNode.right);
					}
				}
			}
			else{
				while(!queue2.isEmpty()){
					Node<E> currentNode = queue2.poll();
					System.out.print(currentNode.value.toString() + " ");
					if(currentNode.left != null){
						queue1.add(currentNode.left);
					}
					if(currentNode.right != null){
						queue1.add(currentNode.right);
					}
				}
			}
			System.out.println();
		}
	}
	
	//Print By Level S-style
	public void S_LevelOrderPrint(){
		Stack<Node<E>> stack1 = new Stack<Node<E>>();
		Stack<Node<E>> stack2 = new Stack<Node<E>>();
		stack1.add(this);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(stack1.isEmpty()){
				while(!stack2.isEmpty()){
					Node<E> currentNode = stack2.pop();
					System.out.print(currentNode.value + " ");
					if(currentNode.left != null)
						stack1.push(currentNode.left);
					if(currentNode.right != null)
						stack1.push(currentNode.right);
				}
			}else{
				while(!stack1.isEmpty()){
					Node<E> currentNode = stack1.pop();
					System.out.print(currentNode.value + " ");
					if(currentNode.right != null)
						stack2.add(currentNode.right);
					if(currentNode.left != null)
						stack2.add(currentNode.left);
				}
			}
			System.out.println();
		}
	}
}

//用来建立二叉树，给节点赋值
class BinarySearchTree<E extends Comparable<E>>{
	public int maxDepth(Node root) {
        if(root == null) return 0;
        else{
            int leftlength = maxDepth(root.left);
            int rightlength = maxDepth(root.right);
            return leftlength > rightlength? leftlength+1 : rightlength+1;
        }
    }
	void inOrderPrint(Node<E> node){
		if(node == null) return;
		inOrderPrint(node.left);
		System.out.print(node.value + " ");
		inOrderPrint(node.right);
	}
	public BinarySearchTree(){
		 root = null;
	}
	private Node<E> root ;
	
	public Node<E> getRoot(){
		return root;
	}
	//循环建树
	public void insertNode(E value){//这个函数的本身只有new node这一个功能，只不过通过不断地递归调用，丰富了node结构
		if( root == null){//给根节点赋值，调用第一次，每次调用都是从根节点开始的
			root = new Node<E>(value);
			return;//程序返回，不再执行下面的代码，如果放在方法的最后面，后接某值，则是返回此值
		}
		Node<E> currentNode = root;//所以这点好理解了，与递归算法相比，没用函数调用，就不会扯到实参形参引用传递的问题，但是还是要用一个局部变量来代替root操作，因为currentnode是个可变指针，但是
		//root不变，赋值，只是表示每次建树，从root这个不变指针开始，后面会对currentnode修改的
		//这个循环表示了建立二叉树的规则，把比父节点大的放在右子树，把比他小的放在左子树
		while(true){
			if(value.compareTo(currentNode.value) > 0){
				if(currentNode.right == null){
 					currentNode.right = new Node<E>(value);
					break;
				}
				currentNode = currentNode.right;//这句代码是用来将建立好的新节点转移到当前节点上,可变指针，递归变量，这里修改了currentnode，其实这句话，就相当于递归中的赋值node.left
			}else{
				if(currentNode.left == null){
					currentNode.left = new Node<E>(value);
					break;
				}
				currentNode = currentNode.left;//同理，没有这句话，currentNode永远是root，不会向下移动，陷入死循环，递归式指针通信移动
			}
		}
	}
	
}

public class Tree<E extends Comparable<E>> {
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		{
			tree.insertNode(5);
			tree.insertNode(3);
			tree.insertNode(7);
			tree.insertNode(8);
			tree.insertNode(1);
			tree.insertNode(2);
			tree.insertNode(0);
			
		}
		System.out.print(tree.maxDepth(tree.getRoot()) );
		
		//tree.inOrderPrint(tree.getRoot());
		//System.out.print("\nInOrderPrint: ");
		//tree.inOrderPrint(tree.getRoot());
		/*
		System.out.print("\nPostOrderPrint: ");
		tree.getRoot().postOrderPrint();
		System.out.println("\nLevelOrderPrint: ");
		tree.getRoot().LevelOrderPrint();
		System.out.println("\nS_LevelOrderPrint: ");
		tree.getRoot().S_LevelOrderPrint();
		*/
	}
}

