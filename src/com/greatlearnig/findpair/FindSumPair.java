package com.greatlearnig.findpair;

import java.util.HashSet;

public class FindSumPair {

	public Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return newNode(key);

		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;

	}

	public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {

		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("pair is found(" + (sum - root.data) + "," + root.data + ")");
			return true;
		} else
			set.add(root.data);
		return findpairUtil(root.right, sum, set);

	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		if (!findpairUtil(root, sum, set))
			System.out.println("Pair do not exist" + "\n");
	}

}
