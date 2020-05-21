// HEADER FILE FOR THE OBJ CLASS - FUNCTIONS TO POPULATE/EDIT/DISPLAY/DELETE/READ/WRITE LINKED LIST OF OBJECTIVES
#ifndef GOAL_H
#define GOAL_H

#include "GoalList.h"
#include "Obj.h"

class Goal
{
private:
	GoalList* goalPtr;

public:
	// CONSTRUCTOR/DESTRUCTOR
	Goal() { goalPtr = NULL; };

	void sizeCheck(const int goalMax);

	// FUNCTIONS TO CHANGE EACH OF THE ELEMENTS
	void changeName(const string entry, const int goalNum);
	void changeDesc(const string entry, const int goalNum);
	void changePriority(const int entry, const int goalNum);
	void changeStartDate(const date dateEntry, const int goalNum);
	void changeDueDate(const date dateEntry, const int goalNum);
	void changeStatus(const char entry, const int goalNum);

	// GET FUNCTIONS
	string getName(const int goalNum) const;
	string getDesc(const int goalNum) const;
	int getPriority(const int goalNum) const;
	date getStartDate(const int goalNum) const;
	date getDueDate(const int goalNum) const;
	char getStatus(const int goalNum) const;
	Obj& getObj(const int goalNum);

	// OBJECT MODIFICATION FUNCTIONS
	void deleteSelected(const int goalNum);

	// DISPLAY FUNCTIONS
	void displayFull(const int goalNum) const;
	void displayPriority(const int goalNum) const;

	// READ AND WRITE FUNCTIONS
	void write(const int goalMax, ofstream& file);
	void read(int& goalMax, ifstream& file);

	// SORT FUNCTIONS
	void sortByPriority(const int goalMax);
	void sortByDueDate(const int goalMax);
	void sortByStatus(const int goalMax);
};

#endif