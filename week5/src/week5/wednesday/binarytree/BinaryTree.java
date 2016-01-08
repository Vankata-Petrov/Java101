package week5.wednesday.binarytree;

public class BinaryTree {
	private class Node {
		private int depth;
		private int height;
		private int data;
		private Node left;
		private Node right;
		private Node parent;

		public Node(int height, int depth, int data, Node leftChild,
				Node rightChild, Node parent) {
			this.height = height;
			this.depth = depth;
			this.data = data;
			this.left = leftChild;
			this.right = rightChild;
			this.parent = parent;
		}

		public Node(int data) {
			this.data = data;
			height = 0;
			depth = 0;

		}

	}

	private Node root;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public void add(int data) throws Exception {
		if (root == null) {
			root = new Node(data);
		} else {
			recursiveAdd(data, root);
			if (root.left != null && root.right != null) {
				root.height = root.left.height >= root.right.height ? root.left.height + 1
						: root.right.height + 1;
			}
			if (root.left == null) {
				root.height = root.right.height + 1;
			} else if (root.right == null) {
				root.height = root.left.height + 1;
			}
		}
	}

	private void recursiveAdd(int data, Node parent) throws Exception {
		if (parent == null) {
			return;
		}
		if (data == parent.data) {
			throw new Exception("BST not awoled duplicates");
		}
		if (parent.data > data && parent.left == null) {
			parent.left = new Node(0, parent.depth + 1, data, null, null,
					parent);
			return;
		}
		if (parent.data < data && parent.right == null) {
			parent.right = new Node(0, parent.depth + 1, data, null, null,
					parent);
			return;
		}
		Node node = parent.data < data ? parent.right : parent.left;
		recursiveAdd(data, node);
		// set height-/*
		int leftHeight = 0;
		int rightHeight = 0;
		if (node.left != null && node.right != null) {
			leftHeight = node.left.height;
			rightHeight = node.right.height;
			node.height = leftHeight >= rightHeight ? leftHeight + 1
					: rightHeight + 1;
		}
		if (node.left == null) {
			rightHeight = node.right.height;
			node.height = rightHeight + 1;
		} else if (node.right == null) {
			leftHeight = node.left.height;
			node.height = leftHeight + 1;
		}
	}

	public int getElementHeight(int element) {
		return getNodeByData(element).height;
	}

	public int getElementDepth(int number) {
		return getNodeByData(number, root).depth;
	}

	private Node getNodeByData(int number) {
		return getNodeByData(number, root);
	}

	public boolean contains(int element) {
		return getNodeByData(element) != null;
	}

	private Node getNodeByData(int data, Node node) {
		if (node == null) {
			return null;
		}
		if (data == node.data) {
			return node;
		}
		if (data < node.data) {
			return getNodeByData(data, node.left);
		} else if (data > node.data) {
			return getNodeByData(data, node.right);
		}
		return node;
	}

	public int getParentData(int data) {
		return getNodeByData(data).parent.data;
	}

	public int getRootData() {
		return root.data;
	}

	public void delete(int data) {
		delete(root, data);
	}

	private Node delete(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data > node.data) {
			node.right = delete(node.right, data);
		} else if (data < node.data) {
			node.left = delete(node.left, data);
		} else {
			if (node.left == null) {
				recalculateDepth(node.right);
				if (node.parent.left.height < node.height) {
					node.height -= 1;
				}
				return node.right;
			} else if (node.right == null) {
				recalculateDepth(node.left);
				if (node.parent.right.height < node.height) {
					node.height -= 1;
				}
				return node.left;
			}
			node.data = getSmallestFromTheRightSubTree(node.right);
			node.right = delete(node.right, node.data);
		}
		return node;
	}

	private void recalculateDepth(Node node) {
		if (node == null) {
			return;
		}
		recalculateDepth(node.right);
		recalculateDepth(node.left);
		node.depth--;
	}

	private int getSmallestFromTheRightSubTree(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return getSmallestFromTheRightSubTree(node.left);
	}

	private String recursivePrint(Node node) {
		if (node == null) {
			return "";
		}
		return recursivePrint(node.left) + " " + node.data + ","
				+ recursivePrint(node.right);
	}

	private String recursivePrintNodeData(Node node) {
		if (node == null) {
			return "";
		}
		return recursivePrintNodeData(node.left) + " " + node.data + "( H:"
				+ node.height + " D:" + node.depth + ")" + ","
				+ recursivePrintNodeData(node.right);
	}

	public String recursivePrintNodeData() {
		if (root == null) {
			return "[]";
		}
		String bst = "[" + recursivePrintNodeData(root).trim();
		return bst.substring(0, bst.length() - 1) + "]";
	}

	@Override
	public String toString() {
		if (root == null) {
			return "[]";
		}
		String bst = "[" + recursivePrint(root).trim();
		return bst.substring(0, bst.length() - 1) + "]";
	}
}