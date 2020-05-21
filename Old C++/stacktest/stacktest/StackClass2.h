// stackClass2.h - In Class Exercise

class Stack
{
public:
	static const int MAXCHARS = 30;
	Stack(void);                // constructor
	void push(char *);
	char *pop(void);
	int isEmpty(void);
	void printStack(void);
private:
	struct NameRec
	{
		char name[MAXCHARS];
		NameRec *priorAddr;
	};
	NameRec *top;         // top-of-stack pointer 
};
