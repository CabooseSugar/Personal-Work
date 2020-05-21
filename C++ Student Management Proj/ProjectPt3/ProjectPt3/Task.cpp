// DEFINES THE FUNCTIONS OF TASK.H
#include "Task.h"
#include <iostream>
#include <fstream>

using namespace std;

// SIZE CHECK FUNCTION
void Task::sizeCheck(const int taskMax)
{
	if (taskMax > listLength(taskPtr))
		addEmptyNode(taskPtr);
}

// FUNCTIONS TO CHANGE ELEMENTS
void Task::changeName(const string entry, const int taskNum)
{
	TaskList* targetNodePtr;
	
	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->name = entry;
}

void Task::changeDesc(const string entry, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->description = entry;
}

void Task::changeStartDate(const date dateEntry, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->startDate.setdate(dateEntry.getMonth(), dateEntry.getDay(),dateEntry.getYear());
}
void Task::changeDueDate(const date dateEntry, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->dueDate.setdate(dateEntry.getMonth(), dateEntry.getDay(), dateEntry.getYear());
}

void Task::changeTime(const double entry, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->time = entry;
}

void Task::changeResources(const vector<string> entryVector, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->resources = entryVector;
}

void Task::changeStatus(const char entry, const int taskNum)
{
	TaskList* targetNodePtr;

	sizeCheck(taskNum);
	targetNodePtr = goToNode(taskPtr, taskNum);
	targetNodePtr->status = entry;
}

// GET FUNCTIONS
string Task::getName(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->name;
}

string Task::getDesc(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->description;
}

date Task::getStartDate(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->startDate;
}

date Task::getDueDate(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->dueDate;
}

double Task::getTime(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->time;
}

vector<string> Task::getResources(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->resources;
}

char Task::getStatus(const int taskNum) const
{
	TaskList* targetNodePtr;

	targetNodePtr = goToNode(taskPtr, taskNum);
	return targetNodePtr->status;
}

// OBJECT MODIFICATION FUNCTIONS
void Task::deleteSelected(const int taskNum)
{
	TaskList* target;

	target = goToNode(taskPtr, taskNum);

	if (taskNum == 1)
	{
		deleteHeadNode(target);
		return;
	}

	deleteNode(taskPtr, target);
}

// DISPLAY FUNCTIONS
void Task::displayFull(const int taskNum) const
{
	vector<string> resourceVector = getResources(taskNum);
	vector<string>::iterator p = resourceVector.begin();
	int resourceCount = 1;

	cout << "\tName: " << getName(taskNum) << endl
		<< "\tDescription: " << getDesc(taskNum) << endl
		<< "\tStart Date: " << getStartDate(taskNum).getMonth() << "/" << getStartDate(taskNum).getDay() << "/" << getStartDate(taskNum).getYear() << endl
		<< "\tDue Date: " << getDueDate(taskNum).getMonth() << "/" << getDueDate(taskNum).getDay() << "/" << getDueDate(taskNum).getYear() << endl
		<< "\tTime to complete: " << getTime(taskNum) << " hours" << endl;
	for (p; p != resourceVector.end(); p++)
	{
		cout << "\tResource " << resourceCount << ": " << resourceVector[resourceCount - 1] << endl;
		resourceCount++;
	}
	
	cout << "\tStatus ('C' for Complete, 'I' for In Progress): " << getStatus(taskNum) << endl;
}

void Task::displayPriority(const int taskNum) const
{
	cout << "\n\tName: " << getName(taskNum) << endl
		<< "\tDue Date: " << getDueDate(taskNum).getMonth() << "/" << getDueDate(taskNum).getDay() << "/" << getDueDate(taskNum).getYear() << endl
		<< "\tTime to complete: " << getTime(taskNum) << " hours" << endl
		<< "\tStatus ('C' for Complete, 'I' for In Progress): " << getStatus(taskNum) << endl;
}

// READ AND WRITE FUNCTIONS
void Task::write(const int taskMax, ofstream& file)
{
	vector<string> resourceVector;
	vector<string>::iterator p;
	int resourceCount;

	for (int count = 1; count <= taskMax; count++)
	{
		file << getName(count) << endl
			<< getDesc(count) << endl
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

		file << "-" << endl; // marks end of task resources
	}
}

void Task::read(ifstream& file)
{
	date fileStartDate, fileDueDate;
	int taskMax,
		fileStartMonth, fileStartDay, fileStartYear,
		fileDueMonth, fileDueDay, fileDueYear;

	double fileTime;
	char fileStatus;
	string fileName, fileDesc, fileResource, buffer;
	vector<string> fileResourceVector;

	taskMax = 0;

	while (1)
	{
		getline(file, fileName);
		if (fileName == "}")
			return;
		taskMax++;
		changeName(fileName, taskMax);
		getline(file, fileDesc);
		changeDesc(fileDesc, taskMax);
		file >> fileStartMonth;
		file >> fileStartDay;
		file >> fileStartYear;
		fileStartDate.setdate(fileStartMonth, fileStartDay, fileStartYear); // fill date to pass it to changeStartDate
		changeStartDate(fileStartDate, taskMax);
		file >> fileDueDay;
		file >> fileDueMonth;
		file >> fileDueYear;
		fileDueDate.setdate(fileDueMonth, fileDueDay, fileDueYear);
		changeDueDate(fileDueDate, taskMax);
		file >> fileTime;
		changeTime(fileTime, taskMax);
		file >> fileStatus;
		changeStatus(fileStatus, taskMax);
		getline(file, buffer);

		fileResourceVector.clear();
		while (1)
		{
			getline(file, fileResource);
			if (fileResource == "-")
				break;;
			
			fileResourceVector.push_back(fileResource);
		}
		changeResources(fileResourceVector, taskMax);

	}
}