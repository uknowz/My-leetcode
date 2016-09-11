package leetcode;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode{
	int val;//作为root
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		left = null;
		right = null;
		val = x;
	}
}
//这个类用来建树
public class InvertTree226 {
	static Integer [] array = {4,2,7,1,3,6,null,9};//还不对？？
	 List<TreeNode> list = new LinkedList<>();//linkedlist没有定义初始大小的构造函数，和arraylist不一样
	
	public void creatBinaryTree(){
		for(int index=0; index<array.length; index++){
			list.add(new TreeNode(array[index].intValue()));//因为数组array是封装类型，要自动拆箱成int型
		}
		//利用子节点和父节点之间数学关系建树，但是要考虑出界问题
		for(int parentIndex=0; parentIndex<array.length/2; parentIndex++){
			if(parentIndex *2 + 1>array.length){
				break;
			}else{
				list.get(parentIndex).left = list.get(parentIndex * 2 + 1);
			}
			if(parentIndex *2 + 2>array.length){
				break;
			}else{
				list.get(parentIndex).right = list.get(parentIndex * 2 + 2);
			}			
		}
	}
	//这个方法是这道题的solution
	public TreeNode invertTree(TreeNode root){
		if(root==null){
			return null;
		}//用来做递归出口	
		
		TreeNode contain = root.left;//实例变量直接赋值来定义
		//System.out.print(root.data);//前序、中序、后序遍历的代码，熟记
		root.left = root.right;
		root.right = contain;
		invertTree(root.left);//遍历节点的左孩子
		invertTree(root.right);//遍历节点的右孩子，一个都不能少		
		return root;
		/*对比别人的
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
        */
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		InvertTree226 tree = new InvertTree226();
		tree.creatBinaryTree();
		TreeNode root = tree.list.get(0);
		TreeNode node = tree.invertTree(root);
		System.out.print(node.right.right.val);//到底怎么输出啊
	}
}
