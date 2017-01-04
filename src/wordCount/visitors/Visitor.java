package wordCount.visitors;

import wordCount.dsForStrings.BST;

public interface Visitor {
	/**
	 * @param bst Binary Tree data structure reference to visit the structure
	 */
	public void visitDataStructure(BST bst);

}
