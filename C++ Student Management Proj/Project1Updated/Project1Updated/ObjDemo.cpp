#include "Objective.h"
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <vector>
using namespace std;

// functions to change individual elements of objective
void enterName(Objective&);
void enterDesc(Objective&);
void enterCategory(Objective&);
void enterPriority(Objective&);
void enterStartDate(Objective&);
void enterDueDate(Objective&);
void enterTime(Objective&);
void enterResources(Objective&);
void enterStatus(Objective&);
void enterTasks(Objective&);

// individual sort functions
void sortByCategory(vector <Objective>&);
void sortByPriority(vector <Objective>&);
void sortByDueDate(vector <Objective>&);
void sortByStatus(vector <Objective>&);

// main menu functions
void addObj(vector<Objective>&);
void editObj(vector<Objective>&);
void deleteObj(vector<Objective>&);
void displayObj(vector<Objective>);
void displayAllCritical(vector<Objective>);
void displayAllFull(vector<Objective>);
void writeToFile(vector<Objective>);
void readFromFile(vector<Objective>&);
void sortObj(vector<Objective>&);

int main()
{
	// Program description
	cout << "This program will allow the user to enter" << endl
		<< "and manipulate a list of objectives." << endl;

	// Declaring the variables / objects
	int selection, listEndPosition = 0;
	vector<Objective> objList;	// vector declaration

	// Selection menu
	while (1)
	{
		cout << "\n---------------------------------------------" << endl
			<< setw(23) << ' ' << "MAIN MENU" << endl
			<< " 1. Add objective to array" << endl
			<< " 2. Edit an objective" << endl
			<< " 3. Delete an objective" << endl
			<< " 4. Display an objective" << endl
			<< " 5. Display all objectives (Priority View)" << endl
			<< " 6. Display all objectives (Full View)" << endl
			<< " 7. Write objectives to file" << endl
			<< " 8. Read objectives from file" << endl
			<< " 9. Sort an objective's tasks" << endl
			<< " 10. Search objectives by priority" << endl
			<< " 11. Search objectives by due dates" << endl
			<< " 12. Search objectives by status" << endl
			<< " 13. Quit" << endl
			<< "---------------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			addObj(objList);
			break;
		case 2:
			editObj(objList);
			break;
		case 3:
			deleteObj(objList);
			break;
		case 4:
			displayObj(objList);
			break;
		case 5:
			displayAllCritical(objList);
			break;
		case 6:
			displayAllFull(objList);
			break;
		case 7:
			writeToFile(objList);
			break;
		case 8:
			readFromFile(objList);
			break;
		case 9:
			sortObj(objList);
		case 13:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

// START OF INDIVIDUAL ELEMENT FUNCTIONS
void enterName(Objective& obj)
{
	string objName;

	cout << "\nEnter a name for the new objective: ";
	cin.ignore();
	getline(cin, objName);
	obj.changeName(objName);
}

void enterDesc(Objective& obj)
{
	string objDesc;
	
	cout << "Enter a description: ";
	getline(cin, objDesc);
	obj.changeDesc(objDesc);
}

void enterCategory(Objective& obj)
{
	int objCategory;

	while (1) {
		cout << "\nEnter the number of the quadrant the objective falls into." << endl;
		cout << "--------------------------------------------------------------" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "|" << setw(5) << " 1 - Urgent, Important" << setw(5) << " " << "|"
			<< setw(2) << " " << "2 - Not Urgent, Important" << setw(5) << " " << "|" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "--------------------------------------------------------------" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "|" << setw(5) << " 3 - Urgent, Not Important" << " |"
			<< setw(2) << " " << "4 - Not Urgent, Not Important" << " |" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "--------------------------------------------------------------";

		cout << "\nEntry: ";
		cin >> objCategory;

		if (objCategory < 1 || objCategory > 4)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	obj.changeCategory(objCategory);
}

void enterPriority(Objective& obj)
{
	int objPriority;
	
	while (1)
	{
		cout << "\nEnter the priority of the objective (1-5, 5 being the highest priority): ";
		cin >> objPriority;

		if (objPriority < 1 || objPriority > 5)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	obj.changePrior(objPriority);
}

void enterStartDate(Objective& obj)
{
	int objStartMonth, objStartDay, objStartYear;
	
	cout << "\nEnter the start date of the objective." << endl;
	while (1)
	{
		cout << "Month: ";
		cin >> objStartMonth;
		if (objStartMonth < 1 || objStartMonth > 12)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1)
	{
		cout << "Day: ";
		cin >> objStartDay;
		if (objStartDay < 1 || objStartDay > 31)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1)
	{
		cout << "Year: ";
		cin >> objStartYear;
		if (objStartYear < 2000 || objStartYear >= 2100)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	obj.changeStartDate(objStartDay, objStartMonth, objStartYear);
}

void enterDueDate(Objective& obj)
{
	int objDueMonth, objDueDay, objDueYear;
	
	while (1)
	{
		cout << "\nEnter the due date of the objective." << endl;
		while (1)
		{
			cout << "Month: ";
			cin >> objDueMonth;
			if (objDueMonth < 1 || objDueMonth > 12)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		while (1)
		{
			cout << "Day: ";
			cin >> objDueDay;
			if (objDueDay < 1 || objDueDay > 31)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		while (1)
		{
			cout << "Year: ";
			cin >> objDueYear;
			if (objDueYear < 2000 || objDueYear > 2100)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		if (objDueYear < obj.getStartDateYear())
			cout << "\nDue date must be on or after the start date." << endl;
		else if (objDueYear == obj.getStartDateYear() && objDueMonth <  obj.getStartDateMonth())
			cout << "\nDue date must be on or after the start date." << endl;
		else if (objDueYear ==  obj.getStartDateYear() && objDueMonth == obj.getStartDateMonth() && objDueDay <  obj.getStartDateDay())
			cout << "\nDue date must be on or after the start date." << endl;
		else
			break;
	}

	obj.changeDueDate(objDueDay, objDueMonth, objDueYear);
}

void enterTime(Objective& obj)
{
	double objTime;
	
	while (1)
	{
		cout << "\nEnter the time (in hours) it will take to finish this objective: ";
		cin >> objTime;

		if (objTime < 0)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	obj.changeTime(objTime);
}

void enterResources(Objective& obj)
{
	string objResource;
	char moreResources;
	bool stopEntering = false;

	obj.resourcesClear(); // empty array just in case using this function to edit, where you want to start the array from scratch

	cout << "\nEnter a resource needed for the objective: ";
	cin.ignore();
	getline(cin, objResource);
	obj.changeResources(objResource);

	while (stopEntering == false)
	{
		while (1)
		{
			cout << "Enter another resource? Enter Y/y for Yes, N/n for No: ";
			cin >> moreResources;

			if (moreResources == 'N' || moreResources == 'n')
			{
				stopEntering = true;
				break;
			}
			else if (moreResources == 'Y' || moreResources == 'y')
			{
				cout << "Enter resource: ";
				cin.ignore();
				getline(cin, objResource);
				obj.changeResources(objResource);
				continue;
			}
			else
			{
				cout << "Invalid entry." << endl;
				continue;
			}
		}
	}
}

void enterStatus(Objective& obj)
{
	char objStatus;
	
	while (1)
	{
		cout << "\nEnter the status of the objective. C/c for Complete, I/i for In Progress: ";
		cin >> objStatus;

		if (objStatus != 'C' && objStatus != 'c' && objStatus != 'I' && objStatus != 'i')
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	obj.changeStatus(objStatus);
}

void enterTasks(Objective& obj)
{
	int taskStartMonth, taskStartDay, taskStartYear, taskDueMonth, taskDueDay, taskDueYear, resCount;
	string taskName, taskDescription, taskResource;
	double taskTime;
	char moreResources, taskStatus, moreTasks;
	bool stopEntering;

	for (int count = 1; count < 11; count++) // limits number of tasks to 10
	{
		stopEntering = false;	// resets stopEntering to false after user chooses to stop entering resources on first task
		resCount = 1; // resets resources count to 1 between each new task

		cout << "\n\tTASK " << count << ":" << endl;
		// Entering task name
		cout << "\tEnter task name: ";
		cin.ignore();
		getline(cin, taskName);
		obj.changeTaskName(taskName, count);

		// Entering task description
		cout << "\tEnter task description: ";
		getline(cin, taskDescription);
		obj.changeTaskDesc(taskDescription, count);

		// Entering task start date
		while (1)
		{
			cout << "\n\tEnter the start date of the task." << endl;
			while (1)
			{
				cout << "\tMonth: ";
				cin >> taskStartMonth;
				if (taskStartMonth < 1 || taskStartMonth > 12)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			while (1)
			{
				cout << "\tDay: ";
				cin >> taskStartDay;
				if (taskStartDay < 1 || taskStartDay > 31)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			while (1)
			{
				cout << "\tYear: ";
				cin >> taskStartYear;
				if (taskStartYear < 2000 || taskStartYear >= 2100)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			if (taskStartYear < obj.getStartDateYear())
				cout << "\n\tTask start date cannot precede objective start date." << endl;
			else if (taskStartYear == obj.getStartDateYear() && taskStartMonth < obj.getStartDateMonth())
				cout << "\n\tTask start date cannot precede objective start date." << endl;
			else if (taskStartYear == obj.getStartDateYear() && taskStartMonth == obj.getStartDateMonth() && taskStartDay < obj.getStartDateDay())
				cout << "\n\tTask start date cannot precede objective start date." << endl;
			else if (taskStartYear > obj.getDueDateYear())
				cout << "\n\tTask start date cannot be after the objective due date." << endl;
			else if (taskStartYear == obj.getDueDateYear() && taskStartMonth > obj.getDueDateMonth())
				cout << "\n\tTask start date cannot be after the objective due date." << endl;
			else if (taskStartYear == obj.getDueDateYear() && taskStartMonth == obj.getDueDateMonth() && taskStartDay > obj.getDueDateDay())
				cout << "\n\tTask start date cannot be after the objective due date." << endl;
			
			else
				break;
		}

		obj.changeTaskStartDate(taskStartMonth, taskStartDay, taskStartYear, count);

		// Entering task due date
		while (1)
		{
			cout << "\n\tEnter the due date of the task." << endl;
			while (1)
			{
				cout << "\tMonth: ";
				cin >> taskDueMonth;
				if (taskDueMonth < 1 || taskDueMonth > 12)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			while (1)
			{
				cout << "\tDay: ";
				cin >> taskDueDay;
				if (taskDueDay < 1 || taskDueDay > 31)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			while (1)
			{
				cout << "\tYear: ";
				cin >> taskDueYear;
				if (taskDueYear < 2000 || taskDueYear >= 2100)
				{
					cout << "\n\tInvalid entry." << endl << endl;
					continue;
				}
				break;
			}

			if (taskDueYear > obj.getDueDateYear())
				cout << "\n\tTask due date cannot extend past the objective due date." << endl;
			else if (taskDueYear == obj.getDueDateYear() && taskDueMonth > obj.getDueDateMonth())
				cout << "\n\tTask due date cannot extend past the objective due date." << endl;
			else if (taskDueYear == obj.getDueDateYear() && taskDueMonth == obj.getDueDateMonth() && taskDueDay > obj.getDueDateDay())
				cout << "\n\tTask due date cannot extend past the objective due date." << endl;
			else if (taskDueYear < obj.getStartDateYear())
				cout << "\n\tTask due date must be after task start date." << endl;
			else if (taskDueYear == obj.getStartDateYear() && taskDueMonth < obj.getStartDateMonth())
				cout << "\n\tTask due date must be after task start date." << endl;
			else if (taskDueYear == obj.getStartDateYear() && taskDueMonth == obj.getStartDateMonth() && taskDueDay < obj.getStartDateDay())
				cout << "\n\tTask due date must be after task start date." << endl;
			else
				break;
		}

		obj.changeTaskDueDate(taskDueMonth, taskDueDay, taskDueYear, count);

		// Enterint task time to complete
		cout << "\n\tEnter task time to complete (in hours): ";
		cin >> taskTime;

		obj.changeTaskTime(taskTime, count);

		// Entering task resources
		cout << "\n\tEnter task resource: ";
		cin.ignore();
		getline(cin, taskResource);

		obj.changeTaskResources(taskResource, count, resCount);
	
		while (stopEntering == false)
		{
			while (1)
			{
				cout << "\tEnter another resource? Enter Y/y for Yes, N/n for No: ";
				cin >> moreResources;

				if (moreResources == 'N' || moreResources == 'n')
				{
					stopEntering = true;
					break;
				}
				else if (moreResources == 'Y' || moreResources == 'y')
				{
					resCount++;
					cout << "\tEnter resource: ";
					cin.ignore();
					getline(cin, taskResource);
					obj.changeTaskResources(taskResource, count, resCount);
					continue;
				}
				else
				{
					cout << "\tInvalid entry." << endl;
					continue;
				}
			}
		}

		// Entering task status
		while (1)
		{
			cout << "\n\tEnter task status (C/c for Complete, I/i for In Progress): ";
			cin >> taskStatus;

			if (taskStatus != 'C' && taskStatus != 'c' && taskStatus != 'I' && taskStatus != 'i')
			{
				cout << "\n\tInvalid entry." << endl;
				continue;
			}

			if ((taskStatus == 'I' || taskStatus == 'i') && (obj.getStatus() == 'C' || obj.getStatus() == 'c'))
			{
				cout << "\nTasks cannot be incomplete if objective is complete." << endl;
				continue;
			}
			break;
		}

		obj.changeTaskStatus(taskStatus, count);

		cout << "\n\tEnter another task? (Y/y for Yes, N/n for No): ";
		cin >> moreTasks;

		if (moreTasks == 'Y' || moreTasks == 'y')
		{
			obj.increaseTaskListSize(count);
			continue;
		}
		else if (moreTasks == 'N' || moreTasks == 'n')
			break;
		else
			cout << "\tInvalid entry." << endl;
	}
}


//--------------------------------------------------------------------------------------------------------------------------
// START OF MAIN MENU FUNCTIONS
void addObj(vector<Objective>& objList)
{
	Objective newObj;

	// calling individual enter functions for each element
	enterName(newObj);
	enterDesc(newObj);
	enterCategory(newObj);
	enterPriority(newObj);
	enterStartDate(newObj);
	enterDueDate(newObj);
	enterTime(newObj);
	enterResources(newObj);
	enterStatus(newObj);
	newObj.initializeTaskList();
	enterTasks(newObj);

	// Putting this new object with all info into the vector
	objList.push_back(newObj);
}

void editObj(vector<Objective>& objList)
{
	int objSelection, elemSelection, sizeOfList = 0, i = 1;
	vector<Objective>::iterator p = objList.begin(); // set iterator to point to first object (resource) in vector
	bool validEntry = false;
	
	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	// Selecting an objective to edit
	cout << "\nEnter the number of the objective you want to edit." << endl;
	for (p; p != objList.end(); p++)
	{
		cout << i << ". " << objList[sizeOfList].getName() << endl;
		sizeOfList++;
		i++;
	}
	
	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if ( objSelection > i - 1 || objSelection < 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}

	// Selecting an element of the objective to edit
	cout << "\nEnter the number of the element in the objective you want to edit." << endl
		<< "1. Name" << endl
		<< "2. Description" << endl
		<< "3. Category" << endl
		<< "4. Priority" << endl
		<< "5. Start Date" << endl
		<< "6. Due Date" << endl
		<< "7. Time to complete" << endl
		<< "8. Resources" << endl
		<< "9. Status" << endl
		<< "10. Tasks" << endl;

	while (validEntry == false)
	{
		validEntry = true;

		cout << "\nEntry: ";
		cin >> elemSelection;

		switch (elemSelection)
		{
		case 1:
			enterName(objList[objSelection - 1]);
			break;
		case 2:
			cin.ignore(); // put this in here instead of in enterDesc(), otherwise when adding an entire new objective, the cin.ignore would take off the first letter
			enterDesc(objList[objSelection - 1]);
			break;
		case 3:
			enterCategory(objList[objSelection - 1]);
			break;
		case 4:
			enterPriority(objList[objSelection - 1]);
			break;
		case 5:
			enterStartDate(objList[objSelection - 1]);
			break;
		case 6:
			enterDueDate(objList[objSelection - 1]);
			break;
		case 7:
			enterTime(objList[objSelection - 1]);
			break;
		case 8:
			enterResources(objList[objSelection - 1]);
			break;
		case 9:
			enterStatus(objList[objSelection - 1]);
			break;
		case 10:
			objList[objSelection - 1].clearTaskList(); // deletes tasks so user edits task list from scratch
			objList[objSelection - 1].increaseTaskListSize(0); // uses special condition in increaseTaskListSize function so pointer to list is created after being deleted by clearTaskList
			enterTasks(objList[objSelection - 1]);
			break;
		default:
			cout << "\nInvalid entry." << endl;
			validEntry = false;
		}
	}
}

void deleteObj(vector<Objective>& objList)
{
	int objSelection, sizeOfList = 0, i = 1;
	vector<Objective>::iterator p = objList.begin();

	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	cout << "\nEnter number of objective to delete." << endl;
	for (p; p != objList.end(); p++)
	{
		cout << i << ". " << objList[sizeOfList].getName() << endl;
		sizeOfList++;
		i++;
	}

	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if (objSelection > i - 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}
	
	p = objList.begin(); // reset iterator to start of vector
	objList.erase(p + (objSelection - 1)); // erase object (objective) by moving iterator to spot in vector defined by objSelection (-1 since user picks from a list that starts at 1, not 0)
}

void displayObj(vector<Objective> objList)
{
	int objSelection, sizeOfList = 0, i = 1;
	vector<Objective>::iterator p = objList.begin();

	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	cout << "\nEnter number of objective to view." << endl;
	for (p; p != objList.end(); p++)
	{
		cout << i << ". " << objList[sizeOfList].getName() << endl;
		sizeOfList++;
		i++;
	}

	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if (objSelection > i - 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}

	objList[objSelection - 1].displayFull(); // again -1 since user sees options starting at 1, not 0
}

void displayAllCritical(vector<Objective> objList)
{
	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	for (int i = 0; i < objList.size(); i++)
	{
		cout << "\nOBJECTIVE " << i + 1;
		objList[i].displayCritical();
	}
}

void displayAllFull(vector<Objective> objList)
{
	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	for (int i = 0; i < objList.size(); i++)
	{
		cout << "\nOBJECTIVE " << i + 1;
		objList[i].displayFull();
	}
}

void writeToFile(vector<Objective> objList)
{
	int index = 0;
	ofstream outFile;
	vector<Objective>::iterator p = objList.begin();

	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}
	
	outFile.open("objectiveInfo.txt");
	if (outFile.fail())
	{
		cout << "\nFailed to open file." << endl;
		exit(1);
	}

	for (p; p != objList.end(); p++)
	{
		objList[index].writeTo(outFile);
		index++;
	}

	cout << "\nObjectives succesfully written to file objectiveInfo.txt" << endl;
	outFile.close();
}

void readFromFile(vector<Objective>& objList)
{
	Objective newObj;
	ifstream inFile;

	objList.clear();

	inFile.open("objectiveInfo.txt");
	if (inFile.fail())
	{
		cout << "\nFailed to open file." << endl;
		exit(1);
	}

	for (int index = 0; index < 2; index++)
	{
		newObj.readFrom(inFile);
		objList.push_back(newObj);
	}
}

void sortObj(vector<Objective>& objList)
{
	int sortSelection;

	if (objList.size() == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	while (1)
	{
		cout << "\nEnter number of what you want to sort based off:" << endl
			<< "1. Category" << endl
			<< "2. Priority" << endl
			<< "3. Due date" << endl
			<< "4. Status" << endl
			<< "\nEntry: ";
		cin >> sortSelection;

		if (sortSelection < 1 || sortSelection > 4)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	switch (sortSelection)
	{
	case 1:
		sortByCategory(objList);
		break;
	case 2:
		sortByPriority(objList);
		break;
	case 3: 
		sortByDueDate(objList);
		break;
	case 4:
		sortByStatus(objList);
		break;
	}
}

// Individual Sort functions
void sortByCategory(vector <Objective>& objList)
{
	Objective temp;

	for (int i = 0; i < objList.size() - 1; i++)
		for (int j = 1; j < objList.size(); j++)
		{
			if (objList[j].getCategory() > objList[i].getCategory())
			{
				temp = objList[i];
				objList[i] = objList[j];
				objList[j] = temp;
			}
		}
}

void sortByPriority(vector <Objective>& objList)
{
	Objective temp;

	for (int i = 0; i < objList.size() - 1; i++)
		for (int j = 1; j < objList.size(); j++)
		{
			if (objList[j].getPriority() > objList[i].getPriority())
			{
				temp = objList[i];
				objList[i] = objList[j];
				objList[j] = temp;
			}
		}
}

void sortByDueDate(vector <Objective>& objList)
{
	Objective temp;

	for (int i = 0; i < objList.size() - 1; i++)
		for (int j = 1; j < objList.size(); j++)
		{
			if (objList[j].getDueDateYear() < objList[i].getDueDateYear())
			{
				temp = objList[i];
				objList[i] = objList[j];
				objList[j] = temp;
			}
			else if (objList[j].getDueDateYear() == objList[i].getDueDateYear())
				if (objList[j].getDueDateMonth() < objList[i].getDueDateMonth())
				{
					temp = objList[i];
					objList[i] = objList[j];
					objList[j] = temp;
				}
				else if (objList[j].getDueDateMonth() == objList[i].getDueDateMonth())
					if (objList[j].getDueDateDay() < objList[i].getDueDateDay())
					{
						temp = objList[i];
						objList[i] = objList[j];
						objList[j] = temp;
					}
		}
}

void sortByStatus(vector <Objective>& objList)
{
	Objective temp;

	for (int i = 0; i < objList.size() - 1; i++)
		for (int j = 1; j < objList.size(); j++)
		{
			if ((objList[j].getStatus() == 'I' || objList[j].getStatus() == 'i') && (objList[i].getStatus() == 'C' || objList[i].getStatus() == 'c'))
			{
				temp = objList[i];
				objList[i] = objList[j];
				objList[j] = temp;
			}
		}
}
