package wordCount.visitors;

import wordCount.dsForStrings.BST;

public class WordCountVisitor implements Visitor{

	/* (non-Javadoc)
	 * @see wordCount.visitors.Visitor#visitDataStructure(wordCount.dsForStrings.BST)
	 */
	@Override
	public void visitDataStructure(BST bst) {
	bst.countWords(bst.getRoot());
	bst.printWordCountDetailsToFile();
		
	}

}
