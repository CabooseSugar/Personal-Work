class Node  
{
	public:
	     typedef double Item;
	     //Constructor
	     Node(const Item& init_data=Item(), Node* init_link=NULL)
		      {  data = init_data; link = init_link; }
	     //Member functions
	     void set_data(const Item& new_data) { data = new_data; }
	     void set_link(Node *new_link) { link = new_link; }
	     //Member function to retrieve data
	     Item data_in () const { return data; }
	     //Two other functions to retrieve the current link
	     const Node *link_to () const { return link; }
	     Node *link_to () { return link; }
	private:
	     Item data;
	     Node *link;	
};
