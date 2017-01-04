CS542 Design Patterns
Fall 2016
PROJECT 4 README FILE

Due Date: <Wednesday, November 23, 2016>
Submission Date: <Wednesday, November 23, 2016>
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Sunil Kumar Sahu 
e-mail(s): ssahu1@binghamton.edu


PURPOSE:

This java program introduces design patterns to implement a backup system.
  
 
JUSTIFICATION TO DATA STRUCTURE:

The data structure used in this project is a Binary Search Tree(BST) to store the words
present in the input text file. The node of this BST also has variable to store the
word count (frequncy of occurance) of a particular word in the input text file. This will
be used to check and clone the node.

Benefits of a Binary Tree is that the access of the data (insertion) is
computed with a time complexity of O(log n). This is much faster than other data strutures
such as Hash map when dealing with duplicate values.

PERCENT COMPLETE:

To the best of my knowledge my current implementation handles all cases. So I
can say its 100% complete.

PARTS THAT ARE NOT COMPLETE:
None

BUGS:

No known bugs exists.

FILES:
The following files listed below are :

/src/wordCount/driver/Driver.java       : Staring point of execution
/src/wordCount/dsForStrings/BST.java    : Binary Tree Class to create the data structure. Its the element for visitor pattern.
/src/wordCount/dsForStrings/Node.java   : class that implements node details and ObserverI and SubjectI interface methods to setup Observers and Subject. 
/src/wordCount/observer/ObserverI.java  : Interface to setup Observer
/src/wordCount/observer/SubjectI.java   : Interface to setup Subject
/src/wordCount/visitors/CloneObserverVisitor.java   : Visitor implementation of method visitDataStructure to clone and setup Observer and subject
/src/wordCount/visitors/PopulateVisitor.java        : Visitor implementation of method visitDataStructure to read file and generate the binary tree
/src/wordCount/visitors/TetstVisitor.java           : Visitor implementation of method visitDataStructure to Test the backup/cloning
/src/wordCount/visitors/Visitor.java                : Visitor interface with method visitDataStructure()
/src/wordCount/visitors/WordCountVisitor.java       : Visitor implementation of method visitDataStructure to count words
/src/wordCount/util/FileProcessor.java  : perform file specific read & write operations.
/src/wordCount/util/Logger.java         : for logging output.
/src/build.xml                          : compiles and runs the project.

And Input.txt will be required as an input at the run time. 
File not present in the attached tar file.

SAMPLE OUTPUT:

Avg execution time : 37 ms


TO COMPILE:
Go to project folder:
cd sunil_sahu_assign4/sunil_sahu/wordCount

ant compile_all

TO RUN:

ant run


Note : Input file and output files not provided in tar.gz

EXTRA CREDIT:

N/A


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

ACKNOWLEDGEMENT:

None


