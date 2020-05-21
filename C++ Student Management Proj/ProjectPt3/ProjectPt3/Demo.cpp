// TESTS THE VARIOUS CLASSES 
#include "Obj.h"
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
#include <cctype> // for toupper

using namespace std;

// Functions to change individual elements of objective
void enterName(Obj&, int);
void enterDesc(Obj&, int);
void enterCategory(Obj&, int);
void enterPriority(Obj&, int);
void enterStartDate(Obj&, int);
void enterDueDate(Obj&, int);
void enterTime(Obj&, int);
void enterResources(Obj&, int);
void enterStatus(Obj&, int);
void enterTasks(Obj&, int);

// Functions to change individual elements of tasks functions
void enterTaskName(Obj&, int, int);
void enterTaskDesc(Obj&, int, int);
void enterTaskStartDate(Obj&, int, int);
void enterTaskDueDate(Obj&, int, int);
void enterTaskTime(Obj&, int, int);
void enterTaskResources(Obj&, int, int);
void enterTaskStatus(Obj&, int, int);

// Menu functions
void addObj(Obj&, int&);
void editObj(Obj&, int);
void deleteObj(Obj&, int&);
void displayObj(Obj, int);
void displayAllPriority(Obj, int);
void displayAllFull(Obj, int);
void writeObj(Obj, int);
void readObj(Obj&, int&);
void sortObj(Obj&, int);
void prioritySearch(Obj, int);
void dueDateSearch(Obj, int);
void statusSearch(Obj, int);


int main()
{
	// Program description
	cout << "This program will allow the user to enter" << endl
		<< "and manipulate a list of objectives." << endl;

	// Declaring the variables / objects
	int selection, numberOfObjectives = 0;
	Obj objective;
	
	while (1)
	{
		cout << "\n---------------------------------------------" << endl
			<< setw(23) << ' ' << "MAIN MENU" << endl
			<< " 1.  Add objective to array" << endl
			<< " 2.  Edit an objective" << endl
			<< " 3.  Delete an objective" << endl
			<< " 4.  Display an objective" << endl
			<< " 5.  Display all objectives (Priority View)" << endl
			<< " 6.  Display all objectives (Full View)" << endl
			<< " 7.  Write objectives to file" << endl
			<< " 8.  Read objectives from file" << endl
			<< " 9.  Sort objectives" << endl
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
			addObj(objective, numberOfObjectives);
			break;
		case 2:
			editObj(objective, numberOfObjectives);
			break;
		case 3:
			deleteObj(objective, numberOfObjectives);
			break;
		case 4:
			displayObj(objective, numberOfObjectives);
			break;
		case 5:
			displayAllPriority(objective, numberOfObjectives);
			break;
		case 6:
			displayAllFull(objective, numberOfObjectives);
			break;
		case 7:
			writeObj(objective, numberOfObjectives);
			break;
		case 8:
			readObj(objective, numberOfObjectives);
			break;
		case 9:
			sortObj(objective, numberOfObjectives);
			break;
		case 10:
			prioritySearch(objective, numberOfObjectives);
			break;
		case 11:
			dueDateSearch(objective, numberOfObjectives);
			break;
		case 12:
			statusSearch(objective, numberOfObjectives);
			break;
		case 13:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

//------------------------------------------------------------------------------------------------------
// INDIVIDUAL ELEMENT FUNCTIONS
void enterName(Obj& obj, int objNum)
{
	string objName;

	cout << "\nEnter a name for the new objective: ";
	cin.ignore();
	getline(cin, objName);
	obj.changeName(objName, objNum);
}

void enterDesc(Obj& obj, int objNum)
{
	string objDesc;

	cout << "Enter a description: ";
	getline(cin, objDesc);
	obj.changeDesc(objDesc, objNum);
}

void enterCategory(Obj& obj, int objNum)
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

	obj.changeCategory(objCategory, objNum);
}

void enterPriority(Obj& obj, int objNum)
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

	obj.changePriority(objPriority, objNum);
}

void enterStartDate(Obj& obj, int objNum)
{
	int objStartMonth, objStartDay, objStartYear;
	date objDate;

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

	objDate.setdate(objStartMonth, objStartDay, objStartYear); // fill Date class variable to pass it to changeStartDate
	obj.changeStartDate(objDate, objNum);
}

void enterDueDate(Obj& obj, int objNum)
{
	int objDueMonth, objDueDay, objDueYear;
	date objDate;

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

		if (objDueYear < obj.getStartDate(objNum).getYear())
			cout << "\nDue date must be on or after the start date." << endl;
		else if (objDueYear == obj.getStartDate(objNum).getYear() && objDueMonth <  obj.getStartDate(objNum).getMonth())
			cout << "\nDue date must be on or after the start date." << endl;
		else if (objDueYear == obj.getStartDate(objNum).getYear() && objDueMonth == obj.getStartDate(objNum).getMonth() && objDueDay <   obj.getStartDate(objNum).getDay())
			cout << "\nDue date must be on or after the start date." << endl;
		else
			break;
	}

	objDate.setdate(objDueMonth, objDueDay, objDueYear); 
	obj.changeDueDate(objDate, objNum);
}

void enterTime(Obj& obj, int objNum)
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

	obj.changeTime(objTime, objNum);
}

void enterResources(Obj& obj, int objNum)
{
	vector<string> resourceVector;
	string objResource;
	char moreResources;
	bool stopEntering = false;

	cout << "\nEnter a resource needed for the objective: ";
	cin.ignore();
	getline(cin, objResource);
	
	resourceVector.push_back(objResource);

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
				resourceVector.push_back(objResource);
				continue;
			}
			else
			{
				cout << "Invalid entry." << endl;
				continue;
			}
		}
	}

	obj.changeResources(resourceVector, objNum);
}

void enterStatus(Obj& obj, int objNum)
{
	char objStatus;
	
	while (1)
	{
		cout << "\nEnter the status of the objective. C/c for Complete, I/i for In Progress: ";
		cin >> objStatus;
		objStatus = toupper(objStatus);

		if (objStatus != 'C' && objStatus != 'I')
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		break;
	}

	cout << endl;
	obj.changeStatus(objStatus, objNum);
}

void enterTasks(Obj& obj, int objNum)
{
	int taskNum = 1;
	char moreEntries;
	
	cout << "\tTASK " << taskNum << ":" << endl;

	while (1)
	{
		enterTaskName(obj, objNum, taskNum);
		enterTaskDesc(obj, objNum, taskNum);
		enterTaskStartDate(obj, objNum, taskNum);
		enterTaskDueDate(obj, objNum, taskNum);
		enterTaskTime(obj, objNum, taskNum);
		enterTaskResources(obj, objNum, taskNum);
		enterTaskStatus(obj, objNum, taskNum);

		while (1)
		{
			cout << "\tEnter another task? (Y/y for Yes, N/n for No): ";
			cin >> moreEntries;
			cout << endl;
			moreEntries = toupper(moreEntries);

			if (moreEntries == 'Y')
			{
				taskNum++;
				cout << "\tTASK " << taskNum << ":" << endl;
				break;
			}
			else if (moreEntries == 'N')
				return;
			else
				cout << "\n\tInvalid entry." << endl;
		}
	}
}


//------------------------------------------------------------------------------------------------------
// FUNCTIONS FOR ENTERING TASK ELEMENTS
void enterTaskName(Obj& obj, int objNum, int taskNum)
{
	string taskName;

	cout << "\tEnter a name for the new task: ";
	cin.ignore( );
	getline(cin, taskName);
	obj.getTask(objNum).changeName(taskName, taskNum);
}

void enterTaskDesc(Obj& obj, int objNum, int taskNum)
{
	string taskDesc;

	cout << "\tEnter a description: ";
	getline(cin, taskDesc);
	obj.getTask(objNum).changeDesc(taskDesc, taskNum);
}

void enterTaskStartDate(Obj& obj, int objNum, int taskNum)
{
	int taskStartMonth, taskStartDay, taskStartYear;
	date taskDate;
	date objStartCompare, objDueCompare;

	objStartCompare = obj.getStartDate(objNum);
	objDueCompare = obj.getDueDate(objNum);

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

		if (taskStartYear < objStartCompare.getYear() || taskStartYear > objDueCompare.getYear())
		{
			cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
			continue;
		}
		if (taskStartYear == objStartCompare.getYear())
		{
			if (taskStartMonth < objStartCompare.getMonth())
			{
				cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
				continue;
			}
			else if (taskStartMonth == objStartCompare.getMonth())
				if (taskStartDay < objStartCompare.getDay())
				{
					cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
					continue;
				}
		}
		
		if (taskStartYear == objDueCompare.getYear())
		{
			if (taskStartMonth > objDueCompare.getMonth())
			{
				cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
				continue;
			}
			else if (taskStartMonth == objDueCompare.getMonth())
				if (taskStartDay > objDueCompare.getDay())
				{
					cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
					continue;
				}
		}
		break;
	}

	taskDate.setdate(taskStartMonth, taskStartDay, taskStartYear); 
	obj.getTask(objNum).changeStartDate(taskDate, taskNum);
}

void enterTaskDueDate(Obj& obj, int objNum, int taskNum)
{
	int taskDueMonth, taskDueDay, taskDueYear;
	date taskDate;
	date objStartCompare, objDueCompare;

	objStartCompare = obj.getStartDate(objNum);
	objDueCompare = obj.getDueDate(objNum);

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

		if (taskDueYear < objStartCompare.getYear() || taskDueYear > objDueCompare.getYear())
		{
			cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
			continue;
		}
		if (taskDueYear == objStartCompare.getYear())
		{
			if (taskDueMonth < objStartCompare.getMonth())
			{
				cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
				continue;
			}
			else if (taskDueMonth == objStartCompare.getMonth())
				if (taskDueDay < objStartCompare.getDay())
				{
					cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
					continue;
				}
		}

		if (taskDueYear == objDueCompare.getYear())
		{
			if (taskDueMonth > objDueCompare.getMonth())
			{
				cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
				continue;
			}
			else if (taskDueMonth == objDueCompare.getMonth())
				if (taskDueDay > objDueCompare.getDay())
				{
					cout << "\tInvalid entry. Make sure entered date is in range of the objective Start-Due dates." << endl;
					continue;
				}
		}

		if (taskDueYear < obj.getTask(objNum).getStartDate(taskNum).getYear())
		{
			cout << "\tInvalid entry. Due date of task must be on or after the start date." << endl;
			continue;
		}
		if (taskDueYear == obj.getTask(objNum).getStartDate(taskNum).getYear())
			if (taskDueMonth < obj.getTask(objNum).getStartDate(taskNum).getMonth())
			{
				cout << "\tInvalid entry. Due date of task must be on or after the start date." << endl;
				continue;
			}
			else if (taskDueMonth == obj.getTask(objNum).getStartDate(taskNum).getMonth())
				if (taskDueDay < obj.getTask(objNum).getStartDate(taskNum).getDay())
				{
					cout << "\tInvalid entry. Due date of task must be on or after the start date." << endl;
					continue;
				}

		break;
	}

		

	taskDate.setdate(taskDueMonth, taskDueDay, taskDueYear); 
	obj.getTask(objNum).changeDueDate(taskDate, taskNum);
}

void enterTaskTime(Obj& obj, int objNum, int taskNum)
{
	double taskTime;

	while (1)
	{
		cout << "\n\tEnter the time (in hours) it will take to finish this objective: ";
		cin >> taskTime;

		if (taskTime < 0)
		{
			cout << "\n\tInvalid entry." << endl;
			continue;
		}
		if (taskTime > obj.getTime(objNum))
		{
			cout << "\n\tInvalid entry, must be less than total time needed for the objective." << endl;
			continue;
		}
		break;
	}

	obj.getTask(objNum).changeTime(taskTime, taskNum);
}

void enterTaskResources(Obj& obj, int objNum, int taskNum)
{
	vector<string> resourceVector;
	string taskResource;
	char moreResources;
	bool stopEntering = false;

	cout << "\n\tEnter a resource needed for the task: ";
	cin.ignore();
	getline(cin, taskResource);

	resourceVector.push_back(taskResource);

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
				cout << "\tEnter resource: ";
				cin.ignore();
				getline(cin, taskResource);
				resourceVector.push_back(taskResource);
				continue;
			}
			else
			{
				cout << "\tInvalid entry." << endl;
				continue;
			}
		}
	}

	obj.getTask(objNum).changeResources(resourceVector, taskNum);
}

void enterTaskStatus(Obj& obj, int objNum, int taskNum)
{
	char taskStatus;

	while (1)
	{
		cout << "\n\tEnter the status of the objective. C/c for Complete, I/i for In Progress: ";
		cin >> taskStatus;
		taskStatus = toupper(taskStatus);

		if (taskStatus != 'C' && taskStatus != 'I')
		{
			cout << "\n\tInvalid entry." << endl;
			continue;
		}
		else if (obj.getStatus(objNum) == 'C' && taskStatus == 'I')
		{
			cout << "\n\tCannot have in progress tasks in a completed objective." << endl;
			continue;
		}
		break;
	}

	cout << endl;
	
	obj.getTask(objNum).changeStatus(taskStatus, taskNum);
}

//------------------------------------------------------------------------------------------------------
// MAIN MENU FUNCTIONS
void addObj(Obj& obj, int& objMax) 
{
	objMax++;

	// calling individual enter functions for each element
	enterName(obj, objMax);
	enterDesc(obj, objMax);
	enterCategory(obj, objMax);
	enterPriority(obj, objMax);
	enterStartDate(obj, objMax);
	enterDueDate(obj, objMax);
	enterTime(obj, objMax);
	enterResources(obj, objMax);
	enterStatus(obj, objMax);
	enterTasks(obj, objMax);
}

void editObj(Obj& obj, int objMax)
{
	int objSelection, elemSelection, taskSelection, taskElemSelection, taskOperation, taskNum;
	bool validEntry = false;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	// Selecting an objective to edit
	cout << "\nEnter the number of the objective you want to edit." << endl;
	for (int i = 1; i <= objMax; i++)
		cout << i << ". " << obj.getName(i) << endl;
	
	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if (objSelection > objMax || objSelection < 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}

	// Selecting an element of the objective to edit
	cout << "\nEnter the number of the element in the objective you want to edit." << endl
		<< "1.  Name" << endl
		<< "2.  Description" << endl
		<< "3.  Category" << endl
		<< "4.  Priority" << endl
		<< "5.  Start Date" << endl
		<< "6.  Due Date" << endl
		<< "7.  Time to complete" << endl
		<< "8.  Resources" << endl
		<< "9.  Status" << endl
		<< "10. Tasks" << endl;

	while (validEntry == false)
	{
		validEntry = true;

		cout << "\nEntry: ";
		cin >> elemSelection;

		switch (elemSelection)
		{
		case 1:
			enterName(obj, objSelection);
			break;
		case 2:
			cin.ignore(); // put this in here instead of in enterDesc(), otherwise when adding an entire new objective, the cin.ignore would take off the first letter
			enterDesc(obj, objSelection);
			break;
		case 3:
			enterCategory(obj, objSelection);
			break;
		case 4:
			enterPriority(obj, objSelection);
			break;
		case 5:
			enterStartDate(obj, objSelection);
			break;
		case 6:
			enterDueDate(obj, objSelection);
			break;
		case 7:
			enterTime(obj, objSelection);
			break;
		case 8:
			enterResources(obj, objSelection);
			break;
		case 9:
			enterStatus(obj, objSelection);
			break;
		case 10:
		{
			while (1)
			{
				cout << "\n\tWhat do you wish to do with the objective's tasks?" << endl
					<< "\t1. Add a task" << endl
					<< "\t2. Edit a task" << endl
					<< "\t3. Delete a task" << endl
					<< "\tEntry: ";
				cin >> taskOperation;

				if (obj.getTask(objSelection).getTasksMax() == 1 && taskOperation == 3)
					cout << "\t\nCan't delete last remaining task from an objective." << endl;
				else if (taskOperation < 1 || taskOperation > 3)
					cout << "\t\nInvalid entry." << endl;
				else
					break;
			}
			
			if (taskOperation == 1)
			{
				taskNum = obj.getTask(objSelection).getTasksMax() + 1;

				cout << "\t\nTASK " << taskNum << ":" << endl;

				enterTaskName(obj, objSelection, taskNum);
				enterTaskDesc(obj, objSelection, taskNum);
				enterTaskStartDate(obj, objSelection, taskNum);
				enterTaskDueDate(obj, objSelection, taskNum);
				enterTaskTime(obj, objSelection, taskNum);
				enterTaskResources(obj, objSelection, taskNum);
				enterTaskStatus(obj, objSelection, taskNum);	
			}
			
			if (taskOperation == 2)
			{
				cout << "\n\tWhich task do you wish to edit for Objective " << objSelection << "? Enter its number." << endl;

				for (int i = 1; i <= obj.getTask(objSelection).getTasksMax(); i++)
					cout << "\t" << i << ". " << obj.getTask(objSelection).getName(i) << endl;

				while (1)
				{
					cout << "\n\tEntry: ";
					cin >> taskSelection;

					if (taskSelection < 1 || taskSelection > obj.getTask(objSelection).getTasksMax())
						cout << "Invalid entry." << endl;
					else
						break;
				}

				cout << "\n\tEnter the number of the element in this task you want to edit." << endl
					<< "\t1. Name" << endl
					<< "\t2. Description" << endl
					<< "\t3. Start Date" << endl
					<< "\t4. Due Date" << endl
					<< "\t5. Time to complete" << endl
					<< "\t6. Resources" << endl
					<< "\t7. Status" << endl;

				validEntry = false;
				while (validEntry == false)
				{
					validEntry = true;
					cout << "\n\tEntry: ";
					cin >> taskElemSelection;

					switch (taskElemSelection)
					{
					case 1:
						enterTaskName(obj, objSelection, taskSelection);
						break;
					case 2:
						enterTaskDesc(obj, objSelection, taskSelection);
						break;
					case 3:
						enterTaskStartDate(obj, objSelection, taskSelection);
						break;
					case 4:
						enterTaskDueDate(obj, objSelection, taskSelection);
						break;
					case 5:
						enterTaskTime(obj, objSelection, taskSelection);
						break;
					case 6:
						enterTaskResources(obj, objSelection, taskSelection);
						break;
					case 7:
						enterTaskStatus(obj, objSelection, taskSelection);
						break;
					default:
						cout << "\nInvalid entry." << endl;
						validEntry = false;
					}
				}
			}

			if (taskOperation == 3)
			{
				cout << "\n\tWhich task do you wish to delete for Objective " << objSelection << "? Enter its number." << endl;

				for (int i = 1; i <= obj.getTask(objSelection).getTasksMax(); i++)
					cout << "\t" << i << ". " << obj.getTask(objSelection).getName(i) << endl;

				while (1)
				{
					cout << "\n\tEntry: ";
					cin >> taskSelection;

					if (taskSelection < 1 || taskSelection > obj.getTask(objSelection).getTasksMax())
						cout << "Invalid entry." << endl;
					else
						break;
				}

				obj.getTask(objSelection).deleteSelected(taskSelection);

			}
				break;
		}

		default:
			cout << "\nInvalid entry." << endl;
			validEntry = false;
			
		}
	}
}

void deleteObj(Obj& obj, int& objMax)
{
	int objSelection, sizeOfList = 0, i = 1;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	cout << "\nEnter number of objective to delete." << endl;
	for (int i = 1; i <= objMax; i++)
		cout << i << ". " << obj.getName(i) << endl;

	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if (objSelection > objMax || objSelection < 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}

	obj.deleteSelected(objMax);
	objMax--;
}

void displayObj(Obj obj, int objMax)
{
	int objSelection;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	cout << "\nEnter number of objective to view." << endl;
	for (int i = 1; i <= objMax; i++)
		cout << i << ". " << obj.getName(i) << endl;
		

	while (1)
	{
		cout << "\nEntry: ";
		cin >> objSelection;

		if (objSelection > objMax || objSelection < 1)
		{
			cout << "\nInvalid entry" << endl;
			continue;
		}
		break;
	}

	obj.displayFull(objSelection);
}

void displayAllPriority(Obj obj, int objMax)
{
	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}
	for (int i = 1; i <= objMax; i++)
	{
		cout << "\nOBJECTIVE " << i;
		obj.displayPriority(i);
	}
}

void displayAllFull(Obj obj, int objMax)
{
	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}
	for (int i = 1; i <= objMax; i++)
	{
		cout << "\nOBJECTIVE " << i;
		obj.displayFull(i);
	}
}

void writeObj(Obj obj, int objMax)
{
	ofstream outFile;

	if (objMax == 0)
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

	obj.write(objMax, outFile);

	cout << "\nObjectives succesfully written to file objectiveInfo.txt" << endl;
	outFile.close();
}

void readObj(Obj& obj, int& objMax)
{
	ifstream inFile;

	inFile.open("objectiveInfo.txt");
	if (inFile.fail())
	{
		cout << "\nFailed to open file." << endl;
		exit(1);
	}
	
	obj.read(objMax, inFile);
	
	cout << "\nObjectives succesfully read from file objectiveInfo.txt" << endl;
	inFile.close();
}

void sortObj(Obj& obj, int objMax)
{
	int sortSelection;

	if (objMax == 0)
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
		obj.sortByCategory(objMax);
		break;
	case 2:
		obj.sortByPriority(objMax);
		break;
	case 3:
		obj.sortByDueDate(objMax);
		break;
	case 4:
		obj.sortByStatus(objMax);
		break;
	}

	cout << "\nSorting successful." << endl;
}

void prioritySearch(Obj obj, int objMax)
{
	int priorityEntry, matches = 0;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	while (1)
	{
		cout << "\nEnter a priority to search for objectives with that priority. (1 - 5)" << endl
			<< "Entry: ";
		cin >> priorityEntry;

		if (priorityEntry < 1 || priorityEntry > 5)
			cout << "Invalid entry." << endl;
		else
			break;
	}
	
	for (int i = 1; i <= objMax; i++)
		if (obj.getPriority(i) == priorityEntry)
			matches++;

	if (matches == 0)
	{
		cout << "\nNo matches for that priority." << endl;
		return;
	}

	cout << "\nMatching priority for objective(s):" << endl;
	for (int i = 1; i <= objMax; i++)
		if (obj.getPriority(i) == priorityEntry)
			cout << i << ". " << obj.getName(i) << endl;
}

void dueDateSearch(Obj obj, int objMax)
{
	int startYear, startMonth, startDay, endYear, endMonth, endDay, matches = 0;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	cout << "\nEnter a range of dates to search for objectives with a due date within the range." << endl;
	cout << "Enter the start date of the search." << endl;
	while (1)
	{
		cout << "Month: ";
		cin >> startMonth;
		if (startMonth < 1 || startMonth > 12)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1)
	{
		cout << "Day: ";
		cin >> startDay;
		if (startDay < 1 || startDay > 31)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1)
	{
		cout << "Year: ";
		cin >> startYear;
		if (startYear < 0 || startYear >= 3000)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1)
	{
		cout << "\nEnter the end date of the search." << endl;
		while (1)
		{
			cout << "Month: ";
			cin >> endMonth;
			if (endMonth < 1 || endMonth > 12)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		while (1)
		{
			cout << "Day: ";
			cin >> endDay;
			if (endDay < 1 || endDay > 31)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		while (1)
		{
			cout << "Year: ";
			cin >> endYear;
			if (endYear < 2000 || endYear > 2100)
			{
				cout << "\nInvalid entry." << endl << endl;
				continue;
			}
			break;
		}

		if (endYear < startYear)
			cout << "\nEnd date must be on or after the start date." << endl;
		else if (endYear == startYear && endMonth <  startMonth)
			cout << "\nEnd date must be on or after the start date." << endl;
		else if (endYear == startYear && endMonth == startMonth && endDay < startDay)
			cout << "\nDue date must be on or after the start date." << endl;
		else
			break;
	}

	for (int i = 1; i <= objMax; i++)
	{
		// simple case
		if (obj.getDueDate(i).getYear() > startYear && obj.getDueDate(i).getYear() < endYear)
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}

		// more specific start date comparisons
		else if ((obj.getDueDate(i).getYear() == startYear && obj.getDueDate(i).getMonth() > startMonth)
			&& obj.getDueDate(i).getYear() < endYear)
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}
		else if ((obj.getDueDate(i).getYear() == startYear && obj.getDueDate(i).getMonth() == startMonth && obj.getDueDate(i).getDay() >= startDay)
			&& obj.getDueDate(i).getYear() < endYear)
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}

		// more specific end date comparisons
		else if (obj.getDueDate(i).getYear() > startYear
			&& (obj.getDueDate(i).getYear() == endYear && obj.getDueDate(i).getMonth() < endMonth))
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}
		else if (obj.getDueDate(i).getYear() > startYear
			&& (obj.getDueDate(i).getYear() == endYear && obj.getDueDate(i).getMonth() == endMonth && obj.getDueDate(i).getDay() <= endDay))
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}

		// more specific start and end date comparisons
		else if ((obj.getDueDate(i).getYear() == startYear && obj.getDueDate(i).getMonth() > startMonth)
			&& (obj.getDueDate(i).getYear() == endYear && obj.getDueDate(i).getMonth() < endMonth))
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}
		else if ((obj.getDueDate(i).getYear() == startYear && obj.getDueDate(i).getMonth() == startMonth && obj.getDueDate(i).getDay() >= startDay)
			&& (obj.getDueDate(i).getYear() == endYear && obj.getDueDate(i).getMonth() == endMonth && obj.getDueDate(i).getDay() <= endDay))
		{
			cout << "\nMatch found for objective " << i << ". " << obj.getName(i);
			matches++;
		}
	}

	if (matches == 0)
		cout << "\nNo matches found." << endl;
}

void statusSearch(Obj obj, int objMax)
{
	char statusEntry, upperCased;
	int matches = 0;

	if (objMax == 0)
	{
		cout << "\nNo objectives entered." << endl;
		return;
	}

	while (1)
	{
		cout << "\nEnter a status to search for objectives with that status (C/c for Complete or I/i for Incomplete)" << endl
			<< "Entry: ";
		cin >> statusEntry;
		statusEntry = toupper(statusEntry);

		if (statusEntry != 'I' && statusEntry != 'C')
			cout << "Invalid entry." << endl;
		else
			break;
	}

	for (int i = 1; i <= objMax; i++)
	{
		upperCased = toupper(obj.getStatus(i));
		if (upperCased == statusEntry)
			matches++;
	}

	if (matches == 0)
	{
		cout << "\nNo matches for that priority." << endl;
		return;
	}

	cout << "\nMatching status for objective(s):" << endl;
	for (int i = 1; i <= objMax; i++)
	{
		upperCased = toupper(obj.getStatus(i));
		if (upperCased == statusEntry)
			cout << i << ". " << obj.getName(i) << endl;
	}
}