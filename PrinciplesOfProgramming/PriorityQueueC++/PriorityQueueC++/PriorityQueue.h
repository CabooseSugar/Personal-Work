template <class T>
struct Node
{
private:
	int priority;
	T data;
	Node<T>* next;

	template <class T>
	friend class PriorityQueue;

public:
	Node(int priority, T data, Node* next) { this->priority = priority; this->data = data; this->next = next; };
};

template <class T>
class PriorityQueue
{
private:
	Node<T>* head = NULL;

public:
	PriorityQueue insert(int priority, T data) {
		if (head == NULL) {
			head = new Node<T>(priority, data, NULL);
			return *this;
		}

		if (priority > head->priority) {
			head = new Node<T>(priority, data, head);
			return *this;
		}

		Node<T>* p = head;
		while (p->next != NULL && priority <= p->next->priority) {
			p = p->next;
		}
		p->next = new Node<T>(priority, data, p->next);
		return *this;
	}

	T removeHighestElem() {
		if (head == NULL) {
			return NULL;
		}

		int ret = head->data;
		head = head->next;
		return ret;
	}

	T getHighestElem() {
		if (head == NULL) {
			return NULL;
		}
		return head->data;
	}

	
	int getHighestPriority() {
		if (head == NULL) {
			return -1;
		}

		return head->priority;
	}

	int getSize() {
		if (head == NULL) {
			return 1;
		}

		Node<T>* p = head;
		int size = 1;

		while (p->next != NULL) {
			size++;
			p = p->next;
		}
		return size;
	}
};