// HEADER FILE FOR THE OBJ CLASS - FUNCTIONS TO POPULATE/EDIT/DISPLAY/DELETE/READ/WRITE LINKED LIST OF OBJECTIVES
#ifndef OBJ_H
#define OBJ_H

#include "ObjList.h"
#include "Task.h"

class Obj
{
private: 
	ObjList* objPtr;

public:
	// CONSTRUCTOR/DESTRUCTOR
	Obj() { objPtr = NULL; };
	
	// Check that an empty node in ObjList exists if using change functions for a new task in main, makes one if needed. 
	// Really putting this in every change function instead of just changeName is redundant, but probably a good practice
	void sizeCheck(const int objMax);

	// FUNCTIONS TO CHANGE EACH OF THE ELEMENTS
	void changeName(const string entry, const int objNum);
	void changeDesc(const string entry, const int objNum);
	void changeCategory(const int entry, const int objNum);
	void changePriority(const int entry, const int objNum);
	void changeStartDate(const date dateEntry, const int objNum); 
	void changeDueDate(const date dateEntry, const int objNum);
	void changeTime(const double entry, const int objNum);
	void changeResources(const vector<string> entryVector, const int objNum); 
	void changeStatus(const char entry, const int objNum);	

	// GET FUNCTIONS
	string getName(const int objNum) const;
	string getDesc(const int objNum) const;
	int getCategory(const int objNum) const;
	int getPriority(const int objNum) const;
	date getStartDate(const int objNum) const;
	date getDueDate(const int objNum) const;
	double getTime(const int objNum) const;
	vector<string> getResources(const int objNum) const; 
	char getStatus(const int objNum) const;
	Task& getTask(const int objNum); 
	int getObjMax() const { return listLength(objPtr); };

	// OBJECT MODIFICATION FUNCTIONS
	void deleteSelected(const int objNum);

	// DISPLAY FUNCTIONS
	void displayFull(const int objNum) const; 
	void displayPriority(const int objNum) const;

	// READ AND WRITE FUNCTIONS
	void write(const int objMax, ofstream& file);
	void read(int& objMax, ifstream& file);

	// SORT FUNCTIONS
	void sortByCategory(const int objMax);
	void sortByPriority(const int objMax);
	void sortByDueDate(const int objMax);
	void sortByStatus(const int objMax);
};

#endif