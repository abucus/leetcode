package leetcode;

import java.util.LinkedList;

import structure.TreeNode;


public class MaximumDepthOfBinaryTree {
	
	public static int solution(TreeNode root){
		if(root == null){
			return 0;
		}else{
			LinkedList<TreeNode> l = new LinkedList<TreeNode>();
			TreeNode current = null, last = null;
			l.add(root);
			root.val = 1;
			while((current = l.poll())!=null){
				last = current;
				if(last.left != null){
					last.left.val = last.val+1;
					l.add(last.left);
				}
				if(last.right!=null){
					last.right.val = last.val+1;
					l.add(last.right);
				}
			}
			
			return last.val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(solution(root));

	}

}
