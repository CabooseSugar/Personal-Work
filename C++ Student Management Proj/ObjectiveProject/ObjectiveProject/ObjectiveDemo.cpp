/*********************************************************
*  file name: ObjectiveDemo.cpp
*  programmer name: Kyle Wolf
*  date created: 2/20/2018
*  date of last revision: 
*  details of the revision: 
*  short description: allows user to enter and manipulate a list of objectives
**********************************************************/

#include <iostream>    
#include <cstdlib>   
#include <iomanip>
#include <string>
#include <fstream>
#include "Objective.h"     
using namespace std;
using namespace myObj;

// FUNCTIONS TO CHANGE INDIVIDUAL ELEMENTS OF OBJECTIVE
void changeObjName(Objective[], int);
void changeObjDescrip(Objective[], int);
void changeObjCat(Objective[], int);
void changeObjPrio(Objective[], int);
void changeObjStartDate(Objective[], int);
void changeObjDueDate(Objective[], int);
void changeObjTimeToFin(Objective[], int);
void changeObjRes(Objective[], int);
void changeObjStat(Objective[], int);

// MAIN MENU FUNCTIONS 
void addObj(Objective[], int);
void editObj(Objective[]);
void deleteObj(Objective[], int&); //dodgy method
void displayObj(Objective[]);
void displayAllPartial(Objective[], int);
void displayAllFull(Objective[], int);
void writeToFile(Objective[], int);
void readFromFile(Objective[], int&);

const int maxObj = 3;

int main()
{
	// Program description
	cout << "This program will allow the user to enter" << endl
		<< "and manipulate a list of objectives." << endl;

	// Declaring the variables / objects
	int selection, place = 0;
	Objective objList[maxObj];

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
			<< " 9. Quit" << endl
			<< "---------------------------------------------" << endl;

		// Variable initialization
		cout << "Enter selection: ";
		cin >> selection;

		switch (selection) {
		case 1:
			addObj(objList, place);
			place++;
			break;
		case 2:
			editObj(objList);
			break;
		case 3:
			deleteObj(objList, place);
			break;
		case 4:
			displayObj(objList);
			break;
		case 5:
			displayAllPartial(objList, place);
			break;
		case 6:
			displayAllFull(objList, place);
			break;
		case 7:
			writeToFile(objList, place);
			break;
		case 8:
			readFromFile(objList, place);
			break;
		case 9:
			cout << "\nGoodbye!" << endl;
			return 0;
		default:
			cout << "\nInvalid entry." << endl;
		}
	}
}

// FUNCTIONS TO CHANGE INDIVIDUAL ELEMENTS OF OBJECTIVE
void changeObjName(Objective objList[], int i)
{
	string name;

	cout << "\nEnter a name for the objective: ";
	cin.ignore();
	getline(cin, name);
	objList[i].setObjName(name);
}

void changeObjDescrip(Objective objList[], int i)
{
	string descrip;

	cout << "\nEnter a description for the objective: ";
	getline(cin, descrip);
	objList[i].setObjDescription(descrip);
}

void changeObjCat(Objective objList[], int i)
{
	int quad;

	while (1) {
		cout << "\nEnter the number of the quadrant the objective falls into." << endl;
		cout << "--------------------------------------------------------------" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "|" << setw(5) << " 1 - Urgent, Important" << setw(5) << " " << "|" << setw(2) << " " << "2 - Not Urgent, Important" << setw(5) << " " << "|" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "--------------------------------------------------------------" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "|" << setw(5) << " 3 - Urgent, Not Important" << " |" << setw(2) << " " << "4 - Not Urgent, Not Important" << " |" << endl;
		cout << "|" << setw(27) << " " << "|" << setw(32) << " " << "|" << endl;
		cout << "--------------------------------------------------------------";
		cout << "\nEntry: ";
		cin >> quad;

		if (quad < 1 || quad > 4) 
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}

		objList[i].setObjCategory(quad);
		break;
	}
}

void changeObjPrio(Objective objList[], int i)
{
	int priority;

	while (1)
	{
		cout << "\nEnter the priority level of the objective (1-5; 5 being the highest): ";
		cin >> priority;

		if (priority < 1 || priority > 5)
		{
			cout << "\nInvalid entry." << endl;
			continue;
		}
		
		objList[i].setObjPriority(priority);
		break;
	}
}

void changeObjStartDate(Objective objList[], int i)
{
	int startMonth, startDay, startYear;

	cout << "\nEnter the start date of the objective." << endl;
	while (1) {
		cout << "Month: ";
		cin >> startMonth;
		if (startMonth < 1 || startMonth > 12)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1) {
		cout << "Day: ";
		cin >> startDay;
		if (startDay < 1 || startDay > 31)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	cout << "Year: ";
	cin >> startYear;
	objList[i].setObjStartDate(startMonth, startDay, startYear);
}

void changeObjDueDate(Objective objList[], int i)
{
	int dueMonth, dueDay, dueYear;

	cout << "\nEnter the due date of the objective." << endl;
	while (1) {
		cout << "Month: ";
		cin >> dueMonth;
		if (dueMonth < 1 || dueMonth > 12)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}

	while (1) {
		cout << "Day: ";
		cin >> dueDay;
		if (dueDay < 1 || dueDay > 31)
		{
			cout << "\nInvalid entry." << endl << endl;
			continue;
		}
		break;
	}
	
	cout << "Year: ";
	cin >> dueYear;
	objList[i].setObjDueDate(dueMonth, dueDay, dueYear);
}

void changeObjTimeToFin(Objective objList[], int i) 
{
	double hours;

	cout << "\nEnter the time required to finish the objective (in hours): ";
	cin >> hours;
	objList[i].setObjTimeToFinish(hours);
}

void changeObjRes(Objective objList[], int i) 
{
	string resources[3];
	cout << "\nEnter the resources needed." << endl;
	cin.ignore();
	for (int i = 0; i < 3; i++)
	{
		cout << "Resource " << i + 1 << ": ";
		getline(cin, resources[i]);
	}
	objList[i].setObjResources(resources);
}

void changeObjStat(Objective objList[], int i)
{
	char status;

	while (1) {
		cout << "\nEnter the current status of the objective" << endl
			<< "Enter F for Finished, P for In Progress." << endl
			<< "\nEntry: ";
		cin >> status;
		if (status != 'F' && status != 'P')
		{
			cout << "Invalid Entry." << endl;
			continue;
		}
		break;
	}
	
	objList[i].setObjStatus(status);
}

// MAIN MENU FUNCTIONS 
void addObj(Objective objList[], int i)
{
	if (i > 3)
	{
		cout << "Array is full, delete items to make space." << endl;
		return;
	}

	changeObjName(objList, i);
	changeObjDescrip(objList, i);
	changeObjCat(objList, i);
	changeObjPrio(objList, i);
	changeObjStartDate(objList, i);
	changeObjDueDate(objList, i);
	changeObjTimeToFin(objList, i);
	changeObjRes(objList, i);
	changeObjStat(objList, i);
}

void editObj(Objective objList[])
{
	int selection;
	string objToEdit;
	bool invalidSelection;

	while (1) {
		cout << "\nEnter name of objective you wish to edit: ";
		cin.ignore();
		getline(cin, objToEdit);

		for (int i = 0; i < maxObj; i++)
		{
			if (objList[i].getObjName() == objToEdit)
			{
				do {
					invalidSelection = false;

					cout << "Enter number of element you'd like to edit from the list." << endl
						<< " 1. Edit objective name" << endl
						<< " 2. Edit description" << endl
						<< " 3. Edit category" << endl
						<< " 4. Edit priority" << endl
						<< " 5. Edit start date" << endl
						<< " 6. Edit due date" << endl
						<< " 7. Edit time to finish" << endl
						<< " 8. Edit required resources" << endl
						<< " 9. Edit status" << endl;
					cout << "Entry: ";
					cin >> selection;

					switch (selection) {
					case 1:
						changeObjName(objList, i);
						break;
					case 2:
						changeObjDescrip(objList, i);
						break;
					case 3:
						changeObjCat(objList, i);
						break;
					case 4:
						changeObjPrio(objList, i);
						break;
					case 5:
						changeObjStartDate(objList, i);
						break;
					case 6:
						changeObjDueDate(objList, i);
						break;
					case 7:
						changeObjTimeToFin(objList, i);
						break;
					case 8:
						changeObjRes(objList, i);
						break;
					case 9:
						changeObjStat(objList, i);
						break;
					default:
						cout << "\nInvalid entry." << endl;
						invalidSelection = true;
					}
					
				} while (invalidSelection = false);
				
				return;
			}
		}

		cout << "\nObjective name not found." << endl;
	}
}

void deleteObj(Objective objList[], int& place)
{
	string objToDelete;

	while (1) {
		cout << "\nEnter name of objective you wish to delete: ";
		getline(cin, objToDelete);

		for (int i = 0; i < maxObj; i++)
		{
			if (objList[i].getObjName() == objToDelete)
			{
				if (i != maxObj - 1) {
					objList[i] = objList[maxObj - 1];
					place--;
				}
				else
					place--;
			}
		}

		cout << "\nObjective name not found." << endl;
	}
}

void displayObj(Objective objList[])
{
	string objToView;

	while (1)
	{
		cout << "\nEnter name of objective you wish to view: ";
		getline(cin, objToView);

		for (int i = 0; i < maxObj; i++)
			if (objList[i].getObjName() == objToView)
			{
				objList[i].objDisplayInfo();
				return;
			}
			
		cout << "\nObjective name not found." << endl;
	}	
}

void displayAllPartial(Objective objList[], int place)
{
	for (int i = 0; i < place + 1; i++)
	{
		cout << "\nOBJECTIVE " << i + 1;
		objList[i].objDisplayPartialInfo();
	}
}

void displayAllFull(Objective objList[], int place)
{
	for (int i = 0; i < place + 1; i++)
	{
		cout << "\nOBJECTIVE " << i + 1;
		objList[i].objDisplayInfo();
	}
}

void writeToFile(Objective objList[], int place)
{
	ofstream outFile;
	outFile.open("results.txt");

	if (outFile.fail())
	{
		cout << "\nFailed to open file." << endl;
		exit(1);
	}

	for (int i = 0; i < place + 1; i++)
	{
		outFile << "\tOBJECTIVE " << i + 1 << endl;
		objList[i].objWriteFile(outFile);
		outFile << endl;
	}

	cout << "\nSuccesfully wrote results to file results.txt." << endl;
}

void readFromFile(Objective objList[], int& place) // right now only works if reading max amount of objects
{
	ifstream inFile;
	inFile.open("testData.txt");

	if (inFile.fail())
	{
		cout << "\nFailed to open file." << endl;
		exit(1);
	}

	for (int i = 0; i < maxObj - 1; i++)
	{
		objList[i].objReadFile(inFile);
	}

	place = 2;
	cout << "\nSuccesfully read results from file testData.txt." << endl;
}
