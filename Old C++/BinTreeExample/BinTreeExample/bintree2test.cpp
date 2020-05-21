// bintree2test.cpp
#include <iostream>
#include "bintree2.h"
using namespace std;

int main()
{
	BinaryTreeNode<int>* root_ptr;
	BinaryTreeNode<int> *node_ptr;

	// Create the root node
	root_ptr = create_node(2);

	// Create and attach the left subtree
	node_ptr = create_node(4);
	node_ptr->left = create_node(6);
	node_ptr->right = create_node(8);
	root_ptr->left = node_ptr;

	// Create and attach the right subtree
	node_ptr = create_node(10);
	node_ptr->right = create_node(12);
	root_ptr->right = node_ptr;

	// Display tree contents - depth 0 and 1
	cout << "Display the original: ";
	cout << root_ptr->data << root_ptr->left->data << root_ptr->right->data;
	// Display depth 2
	node_ptr = root_ptr->left;
	cout << node_ptr->left->data << node_ptr->right->data;
	node_ptr = root_ptr->right;
	cout << node_ptr->right->data;
	cout << endl;

	// Test tree_copy function
	BinaryTreeNode<int> *new_ptr = tree_copy(root_ptr);

	// Display tree contents - depth 0 and 1
	cout << "Display the copy: ";
	cout << new_ptr->data << new_ptr->left->data << new_ptr->right->data;
	// Display depth 2
	node_ptr = new_ptr->left;
	cout << node_ptr->left->data << node_ptr->right->data;
	node_ptr = new_ptr->right;
	cout << node_ptr->right->data;
	cout << endl;

	// Display again
	cout << "\nUsing print function: " << endl;
	print(new_ptr, 0);

	// Try sum_all function
	cout << "\nThe sum of all of the values in the tree is: "
		<< sum_all(root_ptr) << endl;
	
	// Try inorder
	cout << "\nInorder result: ";
	inorder(root_ptr);

	// Try postorder
	cout << "\nPostorder result: ";
	postorder(root_ptr);

	// Try preorder
	cout << "\nPreorder result: ";
	preorder(root_ptr);

	return 0;
}

/*
Display the original: 24106812
Display the copy: 24106812

Using print function:
12
10
2
8
4
6

The sum of all of the values in the tree is: 42
Press any key to continue . . .
*/