/**************************************************************************************
* file name: BinTree.h
* programmer name: Kyle Wolf
* date created: 4/27/18
* date of last revision:
* details of the revision: 
* short description: Declare the functions and data members of the BinTree template class
***************************************************************************************/

#ifndef BINTREE_H
#define BINTREE_H
#include <cstdlib>  // Provides NULL

template <class Item>
struct BinaryTreeNode
{
	Item data;
	BinaryTreeNode* left;
	BinaryTreeNode* right;
};

template <class Item>
BinaryTreeNode<Item>* create_node(
	const Item& entry,
	BinaryTreeNode<Item>* l_ptr = NULL,
	BinaryTreeNode<Item>* r_ptr = NULL
);

template <class Item>
BinaryTreeNode<Item>* tree_copy(const BinaryTreeNode<Item>* root_ptr);

template <class Item>
void tree_clear(BinaryTreeNode<Item>*& root_ptr);

template <class Item>
bool is_leaf(const BinaryTreeNode<Item>& ptr);

template <class Item>
void preorder(BinaryTreeNode<Item>*);

template <class Item>
void inorder(BinaryTreeNode<Item>*);

template <class Item>
void postorder(BinaryTreeNode<Item>*);

template <class Item, class SizeType>
void print(BinaryTreeNode<Item>* node_ptr, SizeType depth);

template <class Item>
size_t tree_size(const BinaryTreeNode<Item>* root_ptr);

template <class Item>
int sum_all(BinaryTreeNode<Item>* root_ptr);

// Function newly added to provided toolkit
template <class Item>
int solve_tree(BinaryTreeNode<Item>* ptr);
// Postcondition: Returns the result of the expression tree 

#include "BinTree.template"
#endif

