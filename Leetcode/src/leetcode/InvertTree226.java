package leetcode;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode{
	int val;//��Ϊroot
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		left = null;
		right = null;
		val = x;
	}
}
//�������������
public class InvertTree226 {
	static Integer [] array = {4,2,7,1,3,6,null,9};//�����ԣ���
	 List<TreeNode> list = new LinkedList<>();//linkedlistû�ж����ʼ��С�Ĺ��캯������arraylist��һ��
	
	public void creatBinaryTree(){
		for(int index=0; index<array.length; index++){
			list.add(new TreeNode(array[index].intValue()));//��Ϊ����array�Ƿ�װ���ͣ�Ҫ�Զ������int��
		}
		//�����ӽڵ�͸��ڵ�֮����ѧ��ϵ����������Ҫ���ǳ�������
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
	//���������������solution
	public TreeNode invertTree(TreeNode root){
		if(root==null){
			return null;
		}//�������ݹ����	
		
		TreeNode contain = root.left;//ʵ������ֱ�Ӹ�ֵ������
		//System.out.print(root.data);//ǰ�����򡢺�������Ĵ��룬���
		root.left = root.right;
		root.right = contain;
		invertTree(root.left);//�����ڵ������
		invertTree(root.right);//�����ڵ���Һ��ӣ�һ����������		
		return root;
		/*�Աȱ��˵�
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
        */
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		InvertTree226 tree = new InvertTree226();
		tree.creatBinaryTree();
		TreeNode root = tree.list.get(0);
		TreeNode node = tree.invertTree(root);
		System.out.print(node.right.right.val);//������ô�����
	}
}
