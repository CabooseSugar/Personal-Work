#include <iostream>;
#include <string>;
#include "stackClass.h"
using namespace std;

int main()
{
	Stack<double> test;
	string expression;
	int size = 0, index = 0;
	char operand1, operand2;
	double entry;

	cout << "Enter an expresson: ";
	getline(cin, expression);
	
	for (int i = 0; expression[i] != '\0'; i++)
		size++;

	do
	{
		if (expression[index] >= 48 && expression[index] <= 57) // ASCII values
		{
			entry = expression[index] - '0';
			test.push(entry);
		}
		
		else
		{
			operand1 = test.pop();
			operand2 = test.pop();
			if (expression[index] == '+')
			{
				operand2 += operand1;
				test.push(operand2);
			}
			else if (expression[index] == '-')
			{
				operand2 -= operand1;
				test.push(operand2);
			}
			else if (expression[index] == '*')
			{
				operand2 *= operand1;
				test.push(operand2);
			}
			else if (expression[index] == '/')
			{
				operand2 /= operand1;
				test.push(operand2);
			}
			else
			{
				cout << "\nInvalid operator." << endl;
				exit;
			}
		}
		index++;
	} while (index < size);

	cout << "Final result: " << test.peek() << endl;

	return 0;
}