//// DEFINES THE FUNCTIONS OF OBJ.H
#include "Obj.h"
#include <iostream>
#include <fstream>
using namespace std;

// SIZE CHECK FUNCTION
void Obj::sizeCheck(const int objMax)
{
	if (objMax > listLength(objPtr))
		addEmptyNode(objPtr);
}

// FUNCTIONS TO CHANGE ELEMENTS
void Obj::changeName(const string entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->name = entry;
}

void Obj::changeDesc(const string entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->description = entry;
}

void Obj::changeCategory(const int entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->category = entry;
}

void Obj::changePriority(const int entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->priority = entry;
}

void Obj::changeStartDate(const date dateEntry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->startDate.setdate(dateEntry.getMonth(), dateEntry.getDay(), dateEntry.getYear()); // this could be simplified if setdate function in Date.h accepted and deconstructed a date variable on its own
}

void Obj::changeDueDate(const date dateEntry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->dueDate.setdate(dateEntry.getMonth(), dateEntry.getDay(), dateEntry.getYear());
}

void Obj::changeTime(const double entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->time = entry;
}

void Obj::changeResources(const vector<string> entryVector, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->resources = entryVector;
}

void Obj::changeStatus(const char entry, const int objNum)
{
	ObjList* targetNodePtr;

	sizeCheck(objNum);
	targetNodePtr = goToNode(objPtr, objNum);
	targetNodePtr->status = entry;
}

// GET FUNCTIONS
string Obj::getName(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->name;
}

string Obj::getDesc(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->description;
}

int Obj::getCategory(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->category;
}

int Obj::getPriority(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->priority;
}

date Obj::getStartDate(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->startDate;
}

date Obj::getDueDate(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->dueDate;
}

double Obj::getTime(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->time;
}

vector<string> Obj::getResources(const int objNum) const 
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->resources;
}

char Obj::getStatus(const int objNum) const
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->status;
}

Task& Obj::getTask(const int objNum)
{
	ObjList* targetNodePtr;

	targetNodePtr = goToNode(objPtr, objNum);
	return targetNodePtr->task;
}

// OBJECT MODIFICATION FUNCTIONS
void Obj::deleteSelected(const int objNum)
{
	ObjList* target;
	int taskMax;

	target = goToNode(objPtr, objNum);

	taskMax = target->task.getTasksMax();
	for (int i = 1; i < taskMax; i++)
		target->task.deleteSelected(i);

	if (objNum == 1)
	{
		deleteHeadNode(target);
		return;
	}

	deleteNode(objPtr, target);
}

// DISPLAY FUNCTIONS
void Obj::displayFull(const int objNum) const
{
	ObjList* targetNodePtr;
	vector<string> resourceVector = getResources(objNum);
	vector<string>::iterator p = resourceVector.begin();
	int resourceCount = 1;

	cout << "\nName: " << getName(objNum) << endl
		<< "Description: " << getDesc(objNum) << endl
		<< "Category: " << getCategory(objNum) << endl
		<< "Priority (1-5, 5 being the highest priority): " << getPriority(objNum) << endl
		<< "Start Date: " << getStartDate(objNum).getMonth() << "/" << getStartDate(objNum).getDay() << "/" << getStartDate(objNum).getYear() << endl
		<< "Due Date: " << getDueDate(objNum).getMonth() << "/" << getDueDate(objNum).getDay() << "/" << getDueDate(objNum).getYear() << endl
		<< "Time to complete: " << getTime(objNum) << " hours" << endl;
	for (p; p != resourceVector.end(); p++)
	{
		cout << "Resource " << resourceCount << ": " << resourceVector[resourceCount - 1] << endl;
		resourceCount++;
	}
	
	cout << "Status ('C' for Complete, 'I' for In Progress): " << getStatus(objNum) << endl;

	targetNodePtr = goToNode(objPtr, objNum);
	for (int i = 1; i <= targetNodePtr->task.getTasksMax(); i++)
	{
		cout << "\n\tTASK " << i << ":" << endl;
		targetNodePtr->task.displayFull(i);
	}
}

void Obj::displayPriority(const int objNum) const
{
	ObjList* targetNodePtr;

	cout << "\nName: " << getName(objNum) << endl
		<< "Priority (1-5, 5 being the highest priority): " << getPriority(objNum) << endl
		<< "Due Date: " << getDueDate(objNum).getMonth() << "/" << getDueDate(objNum).getDay() << "/" << getDueDate(objNum).getYear() << endl
		<< "Time to complete: " << getTime(objNum) << " hours" << endl
		<< "Status ('C' for Complete, 'I' for In Progress): " << getStatus(objNum) << endl;

	targetNodePtr = goToNode(objPtr, objNum);
	for (int i = 1; i <= targetNodePtr->task.getTasksMax(); i++)
	{
		cout << "\n\tTASK " << i << ":" << endl;
		targetNodePtr->task.displayPriority(i);
	}
}

// READ AND WRITE FUNCTIONS
void Obj::write(const int objMax, ofstream& file)
{
	vector<string> resourceVector;
	vector<string>::iterator p;
	int resourceCount, taskMax;
	ObjList* targetNodePtr;

	for (int count = 1; count <= objMax; count++)
	{
		file << getName(count) << endl
			<< getDesc(count) << endl
			<< getCategory(count) << endl
			<< getPriority(count) << endl
			<< getStartDate(count).getDay() << endl
			<< getStartDate(count).getMonth() << endl
			<< getStartDate(count).getYear() << endl
			<< getDueDate(count).getDay() << endl
			<< getDueDate(count).getMonth() << endl
			<< getDueDate(count).getYear() << endl
			<< getTime(count) << endl
			<< getStatus(count) << endl;

		resourceCount = 1;
		resourceVector = getResources(count);
		for (p = resourceVector.begin(); p != resourceVector.end(); p++)
		{
			file << resourceVector[resourceCount - 1] << endl;
			resourceCount++;
		}
		file << "{" << endl; // marks end of resources, start of tasks

		targetNodePtr = goToNode(objPtr, count);
		taskMax = targetNodePtr->task.getTasksMax();
		targetNodePtr->task.write(taskMax, file);
		file << "}" << endl; // marks end of all tasks, thus end of objective
	}
	file << "!" << endl;
}

void Obj::read(int& objMax, ifstream& file)
{
	date fileStartDate, fileDueDate;
	int fileCategory, filePriority,
		fileStartMonth, fileStartDay, fileStartYear,
		fileDueMonth, fileDueDay, fileDueYear;

	double fileTime;
	char fileStatus;
	string fileName, fileDesc, fileResource, buffer;
	vector<string> fileResourceVector;

	objMax = 0;

	while (1)
	{
		getline(file, fileName);
		if (fileName == "!")
			return;
		objMax++;
		changeName(fileName, objMax);
		getline(file, fileDesc);
		changeDesc(fileDesc, objMax);
		file >> fileCategory;
		changeCategory(fileCategory, objMax);
		file >> filePriority;
		changePriority(filePriority, objMax);
		file >> fileStartMonth;
		file >> fileStartDay;
		file >> fileStartYear;
		fileStartDate.setdate(fileStartMonth, fileStartDay, fileStartYear); // fill date to pass it to changeStartDate
		changeStartDate(fileStartDate, objMax);
		file >> fileDueDay;
		file >> fileDueMonth;
		file >> fileDueYear;
		fileDueDate.setdate(fileDueMonth, fileDueDay, fileDueYear); 
		changeDueDate(fileDueDate, objMax);
		file >> fileTime;
		changeTime(fileTime, objMax);
		file >> fileStatus;
		changeStatus(fileStatus, objMax);
		getline(file, buffer);

		fileResourceVector.clear();
		while (1)
		{
			getline(file, fileResource);
			if (fileResource == "{")
				break;
			
			fileResourceVector.push_back(fileResource);
		}
		changeResources(fileResourceVector, objMax);

		this->getTask(objMax).read(file);
	}	
}

// SORT FUNCTIONS
void Obj::sortByCategory(const int objMax)
{
	ObjList *target1, *target2;
	if (objMax == 1)
		return;

	for (int i = 1; i < objMax; i++)
		for (int j = 2; j <= objMax; j++)
			if (getCategory(j) < getCategory(i))
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);

				swapNodes(target1, target2);
			}
}

void Obj::sortByPriority(const int objMax)
{
	ObjList *target1, *target2;
	if (objMax == 1)
		return;

	for (int i = 1; i < objMax; i++)
		for (int j = 2; j <= objMax; j++)
			if (getPriority(j) > getPriority(i))
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);

				swapNodes(target1, target2);
			}
}

void Obj::sortByDueDate(const int objMax)
{
	ObjList *target1, *target2;
	if (objMax == 1)
		return;

	for (int i = 1; i < objMax; i++)
		for (int j = 2; j <= objMax; j++)
			if (getDueDate(j).getYear() > getDueDate(i).getYear())
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);

				swapNodes(target1, target2);
			}
			else if (getDueDate(j).getYear() == getDueDate(i).getYear() && getDueDate(j).getMonth() > getDueDate(i).getMonth())
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);
				
				swapNodes(target1, target2);
			}
			else if (getDueDate(j).getYear() == getDueDate(i).getYear() && getDueDate(j).getMonth() == getDueDate(i).getMonth() && getDueDate(j).getDay() > getDueDate(i).getDay())
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);

				swapNodes(target1, target2);
			}
}

void Obj::sortByStatus(const int objMax)
{
	ObjList *target1, *target2;
	if (objMax == 1)
		return;

	for (int i = 1; i < objMax; i++)
		for (int j = 2; j <= objMax; j++)
			if (getPriority(j) == 'I' || getPriority(j) == 'i') 
			{
				target1 = goToNode(objPtr, j);
				target2 = goToNode(objPtr, i);

				swapNodes(target1, target2);
			}
}
