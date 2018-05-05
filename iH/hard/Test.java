package GI.hard;

import java.util.*;
import java.util.PriorityQueue;

public class Test {
	public List<Integer> closestKValues(TreeNode root, final double t, int k) {
	    List<Integer>ret = new ArrayList<Integer>();
	    PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>(new Comparator<TreeNode>(){
	       public int compare(TreeNode n1, TreeNode n2) {
	           return 1;
	       }
	    });
	    //findClosest(root, queue);
	   /* while(k-- > 0) ret.add(queue.poll().val);*/
	    return ret;
	}

/*	public void findClosest(TreeNode root, PriorityQueue<TreeNode> queue) {
	    if(root == null) return;
	    findClosest(root.left, queue);
	    queue.add(root);
	    findClosest(root.right, queue);
	}*/
}

class TreeNode {
	int data;
	Node left, right;

	public TreeNode(int d) {
		data = d;
		left = right = null;
	}
}