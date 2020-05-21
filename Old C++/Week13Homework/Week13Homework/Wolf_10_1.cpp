/**************************************************************************************
* file name: Wolf_10_1.cpp
* programmer name: Kyle Wolf
* date created: 4/27/18
* date of last revision:
* details of the revision: 
* short description: Build multiple expression trees and test the various functions of the
					 BinTree class, including the newly added tree_solve function
***************************************************************************************/
#include <iostream>
#include "BinTree.h"
using namespace std;

int main()
{
	BinaryTreeNode<char>* root_ptr;
	BinaryTreeNode<char> *node_ptr;

	// Create the root node
	root_ptr = create_node('*');

	// Create and attach the left subtree
	node_ptr = create_node('+');
	node_ptr->left = create_node('6');
	node_ptr->right = create_node('8');
	root_ptr->left = node_ptr;

	// Create and attach the right subtree
	node_ptr = create_node('4');
	root_ptr->right = node_ptr;

	// Display tree contents - depth 0 and 1
	cout << "Display the original: ";
	cout << root_ptr->data << root_ptr->left->data << root_ptr->right->data;
	// Display depth 2
	node_ptr = root_ptr->left;
	cout << node_ptr->left->data << node_ptr->right->data;
	node_ptr = root_ptr->right;
	cout << node_ptr->data;
	cout << endl;

	// Test tree_copy function
	BinaryTreeNode<char> *new_ptr = tree_copy(root_ptr);

	// Display tree contents - depth 0 and 1
	cout << "Display the copy: ";
	cout << new_ptr->data << new_ptr->left->data << new_ptr->right->data;
	// Display depth 2
	node_ptr = new_ptr->left;
	cout << node_ptr->left->data << node_ptr->right->data;
	node_ptr = new_ptr->right;
	cout << node_ptr->data;
	cout << endl;

	// Display again
	cout << "\nUsing print function: " << endl;
	print(new_ptr, 0);

	// Try inorder
	cout << "\nInorder result: ";
	inorder(root_ptr);

	// Try postorder
	cout << "\nPostorder result: ";
	postorder(root_ptr);

	// Try preorder
	cout << "\nPreorder result: ";
	preorder(root_ptr);
	cout << endl;

	// Try solving the tree
	cout << "\nThe solution to the tree is: " << solve_tree(root_ptr) << endl;

	// Erase the tree
	tree_clear(root_ptr);

	// Make a new tree
	cout << "\n---------------------------------" << endl;
	// Create the root node
	root_ptr = create_node('+');

	// Create and attach the left subtree
	node_ptr = create_node('+');
	node_ptr->left = create_node('6');
	node_ptr->right = create_node('8');
	root_ptr->left = node_ptr;

	// Create and attach the right subtree
	node_ptr = create_node('*');
	node_ptr->left = create_node('3');
	node_ptr->right = create_node('+');
	root_ptr->right = node_ptr;

	// Create and attack the far right subtree (depth 3)
	node_ptr = create_node('7');
	root_ptr->right->right->right = node_ptr;
	node_ptr = create_node('4');
	root_ptr->right->right->left = node_ptr;

	// Display new tree
	cout << "\nNew tree displayed using print function: " << endl;
	print(root_ptr, 0);

	// Try solving the new tree
	cout << "\nThe solution to the new tree is: " << solve_tree(root_ptr) << endl;
	
	return 0;
}

/*
Display the original: *+4684
Display the copy: *+4684

Using print function:
    4
*
        8
    +
        6

Inorder result: 6 + 8 * 4
Postorder result: 6 8 + 4 *
Preorder result: * + 6 8 4

The solution to the tree is: 56

---------------------------------

New tree displayed using print function:
            7
        +
            4
    *
        3
+
        8
    +
        6

The solution to the new tree is: 47
Press any key to continue . . .
*/
