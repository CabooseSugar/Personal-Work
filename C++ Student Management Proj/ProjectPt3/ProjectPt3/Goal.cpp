//// DEFINES THE FUNCTIONS OF OBJ.H
#include "Goal.h"
#include <iostream>
#include <fstream>
using namespace std;

// SIZE CHECK FUNCTION
void Goal::sizeCheck(const int goalMax)
{
	if (goalMax > listLength(goalPtr))
		addEmptyNode(goalPtr);
}

// FUNCTIONS TO CHANGE ELEMENTS
void Goal::changeName(const string entry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->name = entry;
}

void Goal::changeDesc(const string entry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->description = entry;
}

void Goal::changePriority(const int entry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->priority = entry;
}

void Goal::changeStartDate(const date dateEntry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->startDate.setdate(dateEntry.getMonth(), dateEntry.getDay(), dateEntry.getYear()); // this could be simplified if setdate function in Date.h accepted and deconstructed a date variable on its own
}

void Goal::changeDueDate(const date dateEntry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->dueDate.setdate(dateEntry.getMonth(), dateEntry.getDay(), dateEntry.getYear());
}

void Goal::changeStatus(const char entry, const int goalNum)
{
	GoalList* targetNodePtr;

	sizeCheck(goalNum);
	targetNodePtr = goToNode(goalPtr, goalNum);
	targetNodePtr->status = entry;
}

// GET FUNCTIONS
string Goal::getName(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->name;
}

string Goal::getDesc(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->description;
}

int Goal::getPriority(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->priority;
}

date Goal::getStartDate(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->startDate;
}

date Goal::getDueDate(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->dueDate;
}

char Goal::getStatus(const int goalNum) const
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->status;
}

Obj& Goal::getObj(const int goalNum)
{
	GoalList* targetNodePtr;

	targetNodePtr = goToNode(goalPtr, goalNum);
	return targetNodePtr->objective;
}

// OBJECT MODIFICATION FUNCTIONS
void Goal::deleteSelected(const int goalNum)
{
	GoalList* target;
	int objMax;

	target = goToNode(goalPtr, goalNum);

	objMax = target->objective.getObjMax();
	for (int i = 1; i <= objMax; i++)
		target->objective.deleteSelected(i);

	if (goalNum == 1)
	{
		deleteHeadNode(target);
		return;
	}

	deleteNode(goalPtr, target);
}  

// DISPLAY FUNCTIONS
void Goal::displayFull(const int goalNum) const
{
	GoalList* targetNodePtr;

	cout << "\nName: " << getName(goalNum) << endl
		<< "Description: " << getDesc(goalNum) << endl
		<< "Priority (1-5, 5 being the highest priority): " << getPriority(goalNum) << endl
		<< "Start Date: " << getStartDate(goalNum).getMonth() << "/" << getStartDate(goalNum).getDay() << "/" << getStartDate(goalNum).getYear() << endl
		<< "Due Date: " << getDueDate(goalNum).getMonth() << "/" << getDueDate(goalNum).getDay() << "/" << getDueDate(goalNum).getYear() << endl
		<< "Status ('C' for Complete, 'I' for In Progress): " << getStatus(goalNum) << endl;

	targetNodePtr = goToNode(goalPtr, goalNum);
	for (int i = 1; i <= targetNodePtr->objective.getObjMax(); i++)
	{
		cout << "\nOBJECTIVE " << i << ":" << endl;
		targetNodePtr->objective.displayFull(i);
	}
}

void Goal::displayPriority(const int goalNum) const
{
	GoalList* targetNodePtr;

	cout << "\nName: " << getName(goalNum) << endl
		<< "Priority (1-5, 5 being the highest priority): " << getPriority(goalNum) << endl
		<< "Due Date: " << getDueDate(goalNum).getMonth() << "/" << getDueDate(goalNum).getDay() << "/" << getDueDate(goalNum).getYear() << endl
		<< "Status ('C' for Complete, 'I' for In Progress): " << getStatus(goalNum) << endl;

	targetNodePtr = goToNode(goalPtr, goalNum);
	for (int i = 1; i <= targetNodePtr->objective.getObjMax(); i++)
	{
		cout << "\nOBJECTIVE " << i << ":" << endl;
		targetNodePtr->objective.displayPriority(i);
	}
}

// READ AND WRITE FUNCTIONS
void Goal::write(const int goalMax, ofstream& file)
{
	int objMax;
	GoalList* targetNodePtr;

	for (int count = 1; count <= goalMax; count++)
	{
		file << getName(count) << endl
			<< getDesc(count) << endl
			<< getPriority(count) << endl
			<< getStartDate(count).getDay() << endl
			<< getStartDate(count).getMonth() << endl
			<< getStartDate(count).getYear() << endl
			<< getDueDate(count).getDay() << endl
			<< getDueDate(count).getMonth() << endl
			<< getDueDate(count).getYear() << endl
			<< getStatus(count) << endl;

			file << "[" << endl; // marks end of goal, start of objectives

		targetNodePtr = goToNode(goalPtr, count);
		objMax = targetNodePtr->objective.getObjMax();
		targetNodePtr->objective.write(objMax, file);
		file << "]" << endl; // marks end of all objectives, thus end of goal
	}
	file << "?" << endl; // end of file
}

void Goal::read(int& goalMax, ifstream& file)
{
	date fileStartDate, fileDueDate;
	int filePriority, objMax = 0,
		fileStartMonth, fileStartDay, fileStartYear,
		fileDueMonth, fileDueDay, fileDueYear;

	char fileStatus;
	string fileName, fileDesc, buffer;
	

	goalMax = 0;

	while (1)
	{
		getline(file, fileName);
		if (fileName == "?")
			return;
		goalMax++;
		changeName(fileName, goalMax);
		getline(file, fileDesc);
		changeDesc(fileDesc, goalMax);
		file >> filePriority;
		changePriority(filePriority, goalMax);
		file >> fileStartMonth;
		file >> fileStartDay;
		file >> fileStartYear;
		fileStartDate.setdate(fileStartMonth, fileStartDay, fileStartYear); // fill date to pass it to changeStartDate
		changeStartDate(fileStartDate, goalMax);
		file >> fileDueDay;
		file >> fileDueMonth;
		file >> fileDueYear;
		fileDueDate.setdate(fileDueMonth, fileDueDay, fileDueYear);
		changeDueDate(fileDueDate, goalMax);
		file >> fileStatus;
		changeStatus(fileStatus, goalMax);
		getline(file, buffer);

		// if goal was implemented in Demo, this would have to be retooled so the read function in Obj.cpp worked the same as Task.cpp,
		// and this works as Obj.cpp's read function works now
		this->getObj(goalMax).read(objMax, file);
	}
}

// SORT FUNCTIONS
void Goal::sortByPriority(const int goalMax)
{
	GoalList *target1, *target2;
	if (goalMax == 1)
		return;

	for (int i = 1; i < goalMax; i++)
		for (int j = 2; j <= goalMax; j++)
			if (getPriority(j) > getPriority(i))
			{
				target1 = goToNode(goalPtr, j);
				target2 = goToNode(goalPtr, i);

				swapNodes(target1, target2);
			}
}

void Goal::sortByDueDate(const int goalMax)
{
	GoalList *target1, *target2;
	if (goalMax == 1)
		return;

	for (int i = 1; i < goalMax; i++)
		for (int j = 2; j <= goalMax; j++)
			if (getDueDate(j).getYear() > getDueDate(i).getYear())
			{
				target1 = goToNode(goalPtr, j);
				target2 = goToNode(goalPtr, i);

				swapNodes(target1, target2);
			}
			else if (getDueDate(j).getYear() == getDueDate(i).getYear() && getDueDate(j).getMonth() > getDueDate(i).getMonth())
			{
				target1 = goToNode(goalPtr, j);
				target2 = goToNode(goalPtr, i);

				swapNodes(target1, target2);
			}
			else if (getDueDate(j).getYear() == getDueDate(i).getYear() && getDueDate(j).getMonth() == getDueDate(i).getMonth() && getDueDate(j).getDay() > getDueDate(i).getDay())
			{
				target1 = goToNode(goalPtr, j);
				target2 = goToNode(goalPtr, i);

				swapNodes(target1, target2);
			}
}

void Goal::sortByStatus(const int goalMax)
{
	GoalList *target1, *target2;
	if (goalMax == 1)
		return;

	for (int i = 1; i < goalMax; i++)
		for (int j = 2; j <= goalMax; j++)
			if (getPriority(j) == 'I' || getPriority(j) == 'i')
			{
				target1 = goToNode(goalPtr, j);
				target2 = goToNode(goalPtr, i);

				swapNodes(target1, target2);
			}
}
