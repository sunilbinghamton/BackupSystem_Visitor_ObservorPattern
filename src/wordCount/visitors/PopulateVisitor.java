package wordCount.visitors;

import wordCount.dsForStrings.BST;

public class PopulateVisitor implements Visitor{
	
	/* (non-Javadoc)
	 * @see wordCount.visitors.Visitor#visitDataStructure(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visitDataStructure(BST bst) {
		bst.readFileBuildTree();
		bst.inOrderWriteToFileActual(bst.getRoot());
	}

}
