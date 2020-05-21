/*********************************************************
*  file name: objective.h
*  programmer name: Kevin Tran
*  date created: 2/12/2018
*  date of last revision: 2/12/2018
*  details of the revision: none
*  short description: objective class header file
**********************************************************/

#ifndef OBJECTIVE_H
#define OBJECTIVE_H

// Including strings becuase we need to use them to store certain elements
#include <string>
// Including fstream because we need to read from a file and write to a file
#include <fstream>
using namespace std;

// Creating a static const int so string array of resources can be created
// You can determine the limit on how many resources can be used for all objectives

namespace myObj
{
	class Objective
	{
		
		// Creating all elements that will store needed information for the class
	private:
		struct Date {
			int day;
			int month;
			int year;
		};
		
		std::string objName, objDescription;   
		// I do not know which Date class the instructions are referring to with certain elements so I just made them ints for now
		int objCategory, objPriority;
		double objTimeToFinish;
		char objStatus;
		struct Date objStartDate, objDueDate;
		std::string objResources[3]; // normal array for now
	public:
		// Default and overloaded constructors
		Objective();
		Objective(std::string name, std::string descr, int cate, int prior, Date startD, Date dueD, 
			int tTF, std::string resour[], bool compl);

		// Functions that return each element
		const std::string getObjName() { return objName; };
		const std::string getObjDescription() { return objDescription; };
		const int getObjCategory() { return objCategory; };
		const int getObjPriority() { return objPriority; };
		const Date getObjStartDate() { return objStartDate; };
		const Date getObjDueDate() { return objDueDate; };
		const double getObjTimeToFinish() { return objTimeToFinish; };
		const std::string getObjResources() { return objResources[3]; }; // won't work

		// Functions that may change each element -- set 
				// DO WE need to set the input const?
		void setObjName(const std::string newName);
		void setObjDescription(const std::string newDescription);
		void setObjCategory(const int newCategory);
		void setObjPriority(const int newPriority);
		void setObjStartDate(const int month, const int day, const int year);
		void setObjDueDate(const int month, const int day, const int year);
		void setObjTimeToFinish(const double newTimeToFinish);
		void setObjResources(const std::string newResources[]);
		void setObjStatus(const char newStatus);

		// Function to read from a file
		void objReadFile(ifstream& inFile);
		// Function to write to a file
		void objWriteFile(ofstream& outFile);

		// Functions to display elements
		void objDisplayInfo();
		void objDisplayPartialInfo();
	};

}


#endif OBJECTIVE_H