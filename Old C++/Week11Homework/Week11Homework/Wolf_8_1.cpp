/**************************************************************************************
* file name: Wolf_8_1
* programmer name: Kyle Wolf
* date created: 4/13/18
* date of last revision: 4/17/18
* details of the revision: Changed method to split sentences into individual words to involve istringstream
* short description: Detect if a sentence is a word-by-word palindrome
***************************************************************************************/
#include <cassert> // Provides assert 
#include <cctype> // Provides isalpha, toupper
#include <string>
#include <cstdlib> // Provides EXIT_SUCCESS 
#include <iostream> // Provides cout, cin, peek 
#include <queue> // Provides the queue template class 
#include <stack> // Provides the stack template class 
#include <sstream> // Provides istringstream
using namespace std;

string splitSentence(string&);

int main()
{
	queue<string> q;
	stack<string> s;
	string sentence, token, word, selection;
	queue<string>::size_type mismatches; // Mismatches between queue and stack 
											//done like this because it is possible for a vector to contain more than, say, an int can hold

	// Program description
	cout << "This program will detect if an entered sentence" << endl
		<< "is a word-by-word palindrome." << endl;

	while (1)
	{
		// reset mismatches for each new line the user wants to enter
		mismatches = 0;

		// Getting input from user
		cout << "\nEnter a line:" << endl;
		getline(cin, sentence);

		istringstream editSen(sentence);

		while (getline(editSen, token, ' ')) {
			// converts all non-alphabetical characters into the character '!'
			for (int i = 0; i < token.length(); i++)
				if (!isalpha(token[i]))
					token[i] = '!';
			// constructs a new string from token without any of the '!' characters
			for (int i = 0; i < token.length(); i++)
				if (token[i] == '!')
					continue;
				else
					word += toupper(token[i]); // makes all letters uppercase for easy comparisons

			q.push(word);
			s.push(word);

			// empty the contents of word since contents already put on stack and queue 
			word = "";
		}

		while ((!q.empty()) && (!s.empty()))
		{
			// compare word from front of queue (starts at first word of sentence) to word at top of the stack (starts at last word of the sentence)
			if (q.front() != s.top())
				++mismatches;
			q.pop();
			s.pop();
		}

		if (mismatches == 0)
			cout << "That is a palindrome." << endl;
		else
			cout << "That is not a palindrome." << endl;

		// check to see if user wants to enter another line
		while (1)
		{
			cout << "\nTry a different line? (Enter Y/y for Yes, N/n for No): ";
			getline(cin, selection);

			if (selection == "Y" || selection == "y")
				break;
			else if (selection == "N" || selection == "n")
				return EXIT_SUCCESS;
			else
			{
				cout << "Invalid entry.";
				continue;
			}
		}
	}
}

/*
This program will detect if an entered sentence
is a word-by-word palindrome.

Enter a line:
The dog ran
That is not a palindrome.

Try a different line? (Enter Y/y for Yes, N/n for No): g
Invalid entry.
Try a different line? (Enter Y/y for Yes, N/n for No): Y

Enter a line:
The dog RAN dog tHe?
That is a palindrome.

Try a different line? (Enter Y/y for Yes, N/n for No): y

Enter a line:
You can cage a swallow, can't you, but you can't swallow a cage, can you?
That is a palindrome.

Try a different line? (Enter Y/y for Yes, N/n for No): n
Press any key to continue . . .
*/