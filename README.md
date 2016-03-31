# Zillow Coding challenge 
Coding Questions

**String-to-Int Conversion**

Given a String of digits (and possibly signs) such as "123", write a routine int stringToInteger( String s ) that converts the string to an integer, without using the built in Java functions that would do this. The code should handle reasonable edge and error conditions gracefully. (You can rely on the input being in base-10 representation - no need to worry about hex, octal, or binary input.)

**Ternary Tree**

Implement the class (or classes) required for a ternary tree. Then implement a function that would add an element to this tree, keeping all invariants intact.

The ternary tree is much like a binary tree but with 3 child nodes for each parent instead of two - with the left node being values < parent, the right node values > parent, and the middle node values == parent.  For example, if I added the following nodes to the tree in this order:  5, 4, 9, 5, 7, 2, 2 --  the tree would look like this:

                5
               /|\
              4 5 9
             /   /
             2  7
             |
             2

The trinary tree is really just a binary tree that does not merge equality with the less than or greater than side of tree.

StringToLong with no internal libraries is really just about managing errors that can result with fixed length data types (under/over flow) and
any weirdness in the input

[![Book session on Codementor](https://cdn.codementor.io/badges/book_session_github.svg)](https://www.codementor.io/chb0codementor?utm_source=github&utm_medium=button&utm_term=chb0codementor&utm_campaign=github)

[![My Stack Overflow Profile][2]][1] 
  [1]: http://stackexchange.com/users/673865
  [2]: http://stackoverflow.com/users/flair/889053.png
