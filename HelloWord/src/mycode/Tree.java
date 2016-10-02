package mycode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * �������ʵ���˶������Ķ����㷨������������ģ����Ƿ��ͻ��ǲ�����
 */

//���node����Ҫ����ʵ�ֽڵ���Ϣ�ģ������ڵ��ֵ����������
class Node<E extends Comparable<E>>{//extends�ӿڣ���ʾ����ʵ������ӿ��еķ���compareTo(T O)
	Node<E> left;
	Node<E> right;
	E value;
	
	Node(E value){
		this.value = value;
		left = null;
		right = null;
	}
	
	void preOrderPrint(){//��������ڲ�ֻ��һ�����ܣ��������value��ֵ��ֻ�������ϵݹ�ﵽ��������������Ŀ��
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

//�������������������ڵ㸳ֵ
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
	//ѭ������
	public void insertNode(E value){//��������ı���ֻ��new node��һ�����ܣ�ֻ����ͨ�����ϵصݹ���ã��ḻ��node�ṹ
		if( root == null){//�����ڵ㸳ֵ�����õ�һ�Σ�ÿ�ε��ö��ǴӸ��ڵ㿪ʼ��
			root = new Node<E>(value);
			return;//���򷵻أ�����ִ������Ĵ��룬������ڷ���������棬���ĳֵ�����Ƿ��ش�ֵ
		}
		Node<E> currentNode = root;//������������ˣ���ݹ��㷨��ȣ�û�ú������ã��Ͳ��ᳶ��ʵ���β����ô��ݵ����⣬���ǻ���Ҫ��һ���ֲ�����������root��������Ϊcurrentnode�Ǹ��ɱ�ָ�룬����
		//root���䣬��ֵ��ֻ�Ǳ�ʾÿ�ν�������root�������ָ�뿪ʼ��������currentnode�޸ĵ�
		//���ѭ����ʾ�˽����������Ĺ��򣬰ѱȸ��ڵ��ķ������������ѱ���С�ķ���������
		while(true){
			if(value.compareTo(currentNode.value) > 0){
				if(currentNode.right == null){
 					currentNode.right = new Node<E>(value);
					break;
				}
				currentNode = currentNode.right;//�������������������õ��½ڵ�ת�Ƶ���ǰ�ڵ���,�ɱ�ָ�룬�ݹ�����������޸���currentnode����ʵ��仰�����൱�ڵݹ��еĸ�ֵnode.left
			}else{
				if(currentNode.left == null){
					currentNode.left = new Node<E>(value);
					break;
				}
				currentNode = currentNode.left;//ͬ��û����仰��currentNode��Զ��root�����������ƶ���������ѭ�����ݹ�ʽָ��ͨ���ƶ�
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

