package wordCount.dsForStrings;

import java.io.IOException;

import wordCount.util.FileProcessor;
import wordCount.visitors.Visitor;

/**
 * @author Sunil
 *
 */
public class BST {
		
	    private Node root, cRoot;
	    private FileProcessor fileObj, fileObjClone, fileObjActual;
	    private String line;
	    private int totalWordCount;
	    private int treeSize;
	    private int totalChars;
	    
		
	    /**
	     * @param fileObjIn 		: File pointer of input file
	     * @param fileObjCloneIn	: File pointer to store the clone/backup structure
	     * @param fileObjActualIn	: file pointer to store the Actual structure
	     */
	    public BST(FileProcessor fileObjIn, FileProcessor fileObjCloneIn,FileProcessor fileObjActualIn){
	    	fileObj = fileObjIn;
	    	fileObjClone = fileObjCloneIn;
	    	fileObjActual = fileObjActualIn;
	    	root = null;
	    	cRoot = null;
	    	totalWordCount = 0;
	    	treeSize = 0;
	    	totalChars = 0;
	    	

	    }

	    
	    /**
	     * Read input file	
	     */
	    public void readFileBuildTree(){
	    try {
			while( (line = fileObj.hasLine()) != null){
				String[] words = line.split(" ");
				//System.out.println("word read from file: " + words.toString());
				 for(String word: words ){
					 if (!word.equals(""))
						 buildTree(root, word);
			}
		}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} finally{
			
		 }
	    }
	    



	    /**
	     * @param node : Actual bst node type. Needed to start traversing the actual tree
	     * @param word : String type word to store during node creation
	     * 
	     * String check logic to decide whether to go right or left of node
		 * Recursive function to construct binary tree (unbalanced) for a line of words.
	     * Then balance the BST and then loop over to add the next line of words
	     */
	     
	    public void buildTree(Node node, String word) 
	    {
	    	
	    	//Note: duplicate values not stored in BST
	        // base case if node is Null then its root and this is the first word to enter the BST
	    	if (node == null){
	    		root = new Node(word); 
	    		//return root;
	    	}
	    	
	    	// Else check if left node is the correct place to insert this new word
	    	else if (node.getData().compareTo(word) > 0){
	    		if (node.getLeft() == null ){
	    			node.setLeft(new Node(word)) ;
	    			}
	    		else
	    			buildTree(node.getLeft(), word);
	    		}
	    	
	    	// Else check if right node is the correct place to insert this new word
	    	else if (node.getData().compareTo(word) < 0){

	    		if (node.getRight() == null ){
	    			node.setRight(new Node(word)) ;
	    			//return node;
	    			}
	    		else
	    			buildTree(node.getRight(), word);
	    		}
	    	else if (node.getData().compareTo(word) == 0){
	    		node.setCount(node.getCount()+1);
	    		
	    	}
	    	
	    }
	 
	     
	    /**
	     * Function to calculate the words in the BST
	     */
	    public void printWordCountDetailsToFile(){
	    	fileObj.writeToFile("Total number of distinct words	: " + treeSize + "\n");
	    	fileObj.writeToFile("Total number of words			: " + totalWordCount + "\n");
	    	fileObj.writeToFile("Total number of characters		: " + totalChars + "\n");
	    	//System.out.("Total number of distinct words	: " + treeSize);
	    	//System.out.println("Total number of words			: " + totalWordCount);
	    	//System.out.println("Total number of characters		: " + totalChars);
	    }

	    /**
	     * @param node : Actual bst node type. Needed to start traversing the actual tree
	     */
	    public void countWords(Node node) 
	    {
	    	if (node != null){
	    		countWords(node.getLeft());
	    		int cnt = node.getCount();
	    		treeSize+=1;
    			totalChars += (cnt * node.getWord().length());
    			totalWordCount += cnt;
	    		countWords(node.getRight());
           }
	    }
	    
	    /* Function to do preorder traversal of tree */
	    /**
	     * @param node Actual bst node type. Needed to start traversing the actual tree
	     */
	    public void inOrder(Node node) 
	    {
	    	if (node != null){
	    		
	    		inOrder(node.getLeft());
	    		System.out.println(node.getData() + " " + node.getCount());
	    		inOrder(node.getRight());
           }
	    }
	    
	    
	    /**
	     * @param node Actual bst node type. Needed to start traversing the actual tree
	     * @param fptr File pointer to write to file
	     */
	    public void inOrderWriteToFile(Node node, FileProcessor fptr)
	    {
	    	if (node != null){
	    		
	    		inOrderWriteToFile(node.getLeft(), fptr);
	    		fptr.writeToFile(node.getWord() + "  " + node.getCount() + "\n");
	    		inOrderWriteToFile(node.getRight(), fptr);
           }
	    }
	    
	    
	    /* Function to do preorder traversal write to file of tree */
	    /**
	     * @param node Actual bst node type. Needed to start traversing the actual tree
	     */
	    public void inOrderWriteToFileActual(Node node)
	    {
	    	inOrderWriteToFile(node, fileObjActual);
	    }

	    
	    /* Function to do preorder traversal write to file of tree */
	    /**
	     * @param node Actual bst node type. Needed to start traversing the actual tree
	     */
	    public void inOrderWriteToFileClone(Node node)
	    {
	    	inOrderWriteToFile(node, fileObjClone);
	    }
	    
	    /* Function to do in Order traversal and of tree */

	    
	    /**
	     * @param node		: Actual bst node type. Needed to start traversing the actual tree
	     * @return returns	: clone type node. Needed for cloning
	     */
	    public Node inOrderClone(Node node)  {

		    Node cNode = null;
		    if(node == null){
		    	return cNode;
		    }
		    else{
		    	cNode = (Node)node.clone();
		    	cNode.setLeft(null);
		    	cNode.setRight(null);
		    	if (node.getData().equals(getRoot().getData())){
		    		setcRoot(cNode);
		    	}
		    	
		    	node.registerObserver(cNode);
		    	cNode.setLeft(inOrderClone(node.getLeft()));
		    	cNode.setRight(inOrderClone(node.getRight()));
		    }

		    	return cNode;
		    	
		}
	    
		/**
		 * @param node 	: Node type reference to start with tree update. Used by fourth visitor
		 * @param i	 	: Interger type value to update the count of the node	
		 */
		public void updateTree(Node node,int i) {
			if (node != null){
	    		node.notifyObservers(i);	    			    		
	    		updateTree(node.getLeft(), i);
	    		updateTree(node.getRight(), i);
           }	
			
		}



		/**
		 * @param visitor to visit a Visitor type class 
		 */
		public void accept(Visitor visitor) {
			visitor.visitDataStructure(this);
			
		}
		
		// getters and setters
	    public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		public int getTotalWordCount() {
			return totalWordCount;
		}

		public void setTotalWordCount(int totalWordCount) {
			this.totalWordCount = totalWordCount;
		}

		public int getTreeSize() {
			return treeSize;
		}

		public void setTreeSize(int treeSize) {
			this.treeSize = treeSize;
		}

		public int getTotalChars() {
			return totalChars;
		}

		public void setTotalChars(int totalchars) {
			this.totalChars = totalchars;
		}

		public Node getcRoot() {
			return cRoot;
		}

		public void setcRoot(Node cRoot) {
			this.cRoot = cRoot;
		}

	
	
	
	
}
