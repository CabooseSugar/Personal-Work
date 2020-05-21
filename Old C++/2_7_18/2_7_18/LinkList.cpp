#include <cstdlib>
#include "LinkList.h"

size_t list_length(Node* head_ptr) {
	size_t answer = 0;

	Node* cursor = head_ptr;

	for (cursor = head_ptr; cursor != NULL; cursor = cursor->link)
		answer++;

	return answer;
}