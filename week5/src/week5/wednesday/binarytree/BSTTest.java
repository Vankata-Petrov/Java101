package week5.wednesday.binarytree;

public class BSTTest {
	public static void main(String[] args) throws Exception {
		BinaryTree b = new BinaryTree();
		b.add(5);
		b.add(3);
		b.add(7);
		b.add(1);
		b.add(4);
		b.add(0);
		b.add(6);
		b.add(8);
		b.add(10);
		b.add(9);
		// b.add(2);
		// b.add(1);
		b.add(50);
		b.add(100);
		b.add(200);
		// b.delete(50);
		// b.deleteElement(3);
		// b.delete(7);
		// b.deleteElement(5);
		// b.deleteElement(-1);
		// b.deleteElement(4);
		// b.deleteElement(5);
		b.delete(5);
		// b.deleteElement(6);
		// b.deleteElement(8);
		// b.delete(3);
		// b.deleteElement(10);
		// System.out.println(b.getRoot().rightChild.leftChild.data);
		// System.out.printf("Root height is: %d%nRoot depth is: %d%n",
		// b.getRoot().data, b.getRoot().depth);
		// System.out.println(b.contains(50));
	//	System.out.println(b.getElementHeight(5));
		// System.out.println(b.contains(10));
		// System.out.println(b.getElementHeight(10));
		// System.out.println(b.getParentData(100));
		System.out
				.printf("Searched element height is: %d%nSearched element depth is: %d%n",
						b.getElementHeight(8), b.getElementDepth(8));
		System.out.println(b);
		System.out.println(b.recursivePrintNodeData());
		// System.out.println(b.printNodeData());
		// System.out.println(b.getNodeByData(6).leftChild.data);
	}
}
