package wordCount.visitors;

import wordCount.dsForStrings.BST;

public class TetstVisitor implements Visitor{

	/* (non-Javadoc)
	 * @see wordCount.visitors.Visitor#visitDataStructure(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visitDataStructure(BST bst) {

		bst.updateTree(bst.getRoot(),  100);
		bst.inOrderWriteToFileClone(bst.getcRoot());
		
	}

}
