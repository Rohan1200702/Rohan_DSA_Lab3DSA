package com.gl.bst.findpairforsum.main;

import java.util.*;

public class FindPairForTargetSum {
	static class Node {
		int data;
		Node leftNode, rightNode;

		public Node(int data) {
			this.data = data;
			leftNode = rightNode = null;
		}
	}

	static Node createNode(int nodeData) {
		Node newNode = new Node(nodeData);
		return newNode;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return createNode(key);
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public static void main(String[] args) {
		Node root = null;
		Scanner sc = new Scanner(System.in);
		FindPairForTargetSum findPS = new FindPairForTargetSum();
		int count = 7;
		while (count-- > 0) {
			System.out.println("Enter the BST node data");
			root = findPS.insert(root, sc.nextInt());
		}
		System.out.println("Enter the target Sum");
		int targetSum = sc.nextInt();
		findPS.findPairWithGivenSum(root, targetSum);
	}

	private void findPairWithGivenSum(Node root, int targetSum) {
		Set<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, targetSum, set))
			System.out.println("Pairs do not exist in the BST tree");

	}

	private boolean findPairUtil(Node root, int targetSum, Set<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.leftNode, targetSum, set))
			return true;
		if (set.contains(targetSum - root.data)) {
			System.out.println("Pair is found (" + (targetSum - root.data) + "," + root.data + ")");
			return true;
		} else
			set.add(root.data);
		return findPairUtil(root.rightNode, targetSum, set);
	}

}
