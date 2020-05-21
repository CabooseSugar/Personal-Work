/*********************************************************
*  file name: Objective.cpp
*  programmer name: Xutao Liu
*  date created: 2/18/2018
*  date of last revision: 2/18/2018
*  details of the revision: none
*  short description: objective class implementation file
**********************************************************/

#include "Objective.h"
#include <iostream>

using namespace std;

namespace myObj
{
	// Default Constructor
	Objective :: Objective() {
		objName = "Paint";
		objDescription = "Paint a Painting" ;

		objCategory = 2;
		objPriority = 3;
		objTimeToFinish = 5;

		objStatus = 'F';

		objStartDate.month = 1;
		objStartDate.day = 13;
		objStartDate.year = 2018;

		objDueDate.month = 1;
		objDueDate.day = 15;
		objDueDate.year = 2018;
		
		objResources[0] = "Paints";
		objResources[1] = "Brushes";
		objResources[2] = "Glue";
	}

	// Overloaded Constructor
	Objective:: Objective(std::string name, std::string descr, int cate, int prior, Date startD, Date dueD,
		int tTF, std::string resour[], bool compl)
	{
		objName = name;
		objDescription = descr;

		objCategory = cate;
		objPriority = prior;
		objTimeToFinish = tTF;

		objStartDate = startD;

		objDueDate = dueD;

		objResources[3] = resour[3]; 
	}

	// Function to set objective Name(
	void Objective:: setObjName(const std::string newName) {
		objName = newName;
	}

	// Function to set objective Description
	void Objective:: setObjDescription(const std::string newDescription) {
		objDescription = newDescription;
	}

	// Function to set objective Category
	void Objective:: setObjCategory(const int newCategory) {
		objCategory = newCategory;
	}

	// Function to set objective Priority
	void Objective:: setObjPriority(const int newPriority) {
		objPriority = newPriority;
	}

	// Function to set objective StartDate
	void Objective:: setObjStartDate(const int month, const int day, const int year) {
		objStartDate.month = month;
		objStartDate.day = day;
		objStartDate.year = year;
	}

	// Function to set objective DueDate
	void Objective:: setObjDueDate(const int month, const int day, const int year)
	{
		objDueDate.month = month;
		objDueDate.day = day;
		objDueDate.year = year;
	}

	// Function to set objective TimeToFinish
	void Objective:: setObjTimeToFinish(const double newTimeToFinish) {
		objTimeToFinish = newTimeToFinish;
	}

	// Function to set objective Resources
	void Objective::setObjResources(const std::string newResources[]) { // THIS IS A PROBLEM - BAD DYNAMIC ARRAY CAUSING RUNTIME
		for (int i = 0; i < 3; i++)
		objResources[i] = newResources[i];
	}

	// Function to set objective Status
	void Objective:: setObjStatus(const char newStatus) {
		objStatus = newStatus;
	}

	// Function to write to a file
	void Objective:: objWriteFile(ofstream& outFile) {
		outFile << " Objective Name: " << endl << objName << endl;
		outFile << " The Description of the Objective is: " << endl << objDescription << endl;
		outFile << " The Category of the Objective is: " << endl <<  objCategory << endl;
		outFile << " The Priority of the Objective is: " << endl << objPriority << endl;
		outFile << " The Time To Finish is: " << endl << objTimeToFinish << endl;
		outFile << " The Status of the Objective is (F for Finished, P for In Progress): " << endl << objStatus << endl;
		outFile << " The Resources of the Objective are... " << endl;
		for (int i = 0; i < 3; i++)
			outFile << " Resource " << i + 1 << ": " << endl << objResources[i] << endl;

		outFile << " The StartDate of the Objective is: " << endl << objStartDate.month << " "
			<< objStartDate.day << " " << objStartDate.year << endl;
		outFile << " The DueDate of the Objective is: " << endl << objDueDate.month << " "
			<< objDueDate.day << " " << objDueDate.year << endl;
	}

	// Function to read from a file
	void Objective::objReadFile(ifstream& inFile) {
		string buffer;
		
		getline(inFile, buffer);
		getline(inFile, buffer);
		getline(inFile, objName);
		getline(inFile, buffer);
		getline(inFile, objDescription);
		getline(inFile, buffer);
		inFile >> objCategory;
		getline(inFile, buffer);
		getline(inFile, buffer);
		inFile >> objPriority;
		getline(inFile, buffer);
		getline(inFile, buffer);
		inFile >> objTimeToFinish;
		getline(inFile, buffer);
		getline(inFile, buffer);
		inFile >> objStatus;
		getline(inFile, buffer);
		getline(inFile, buffer);
		getline(inFile, buffer);
		getline(inFile, objResources[0]);
		getline(inFile, buffer);
		getline(inFile, objResources[1]);
		getline(inFile, buffer);
		getline(inFile, objResources[2]);
		getline(inFile, buffer);
		inFile >> objStartDate.month;
		inFile >> objStartDate.day;
		inFile >> objStartDate.year;
		getline(inFile, buffer);
		getline(inFile, buffer);
		inFile >> objDueDate.month;
		inFile >> objDueDate.day;
		inFile >> objDueDate.year;
		getline(inFile, buffer);
		getline(inFile, buffer);
	}

	// Function to display all elements
	void Objective:: objDisplayInfo() {
		cout << "\nObjective Name: " << objName << endl;
		cout << "The Description of the Objective is: " << objDescription << endl;
		cout << "The Category of the Objective is: " << objCategory << endl;
		cout << "The Priority of the Objective is: " << objPriority << endl;
		cout << "The Time To Finish is: " << objTimeToFinish << endl;
		cout << "The Status of the Objective is (F for Finished, P for In Progress): " << objStatus << endl;
		cout << "The Resources of the Objective are..." << endl;
		for (int i = 0; i < 3; i++)
			cout << " Resource " << i + 1 << ": " << objResources[i] << endl;
		
		cout << "The StartDate of the Objective is: " << objStartDate.month << " " 
			<< objStartDate.day << " " << objStartDate.year << endl;
		cout << "The DueDate of the Objective is: " << objDueDate.month << " "
			<< objDueDate.day << " " << objDueDate.year << endl;
	}

	void Objective::objDisplayPartialInfo() {
		cout << "\nObjective Name: " << objName << endl;
		cout << "The Description of the Objective is: " << objDescription << endl;
		cout << "The Priority of the Objective is: " << objPriority << endl;
		cout << "The Time To Finish is: " << objTimeToFinish << endl;
	}
}