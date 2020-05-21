#ifndef P1_H
#define P1_H

	class Circle
	{
	private:
		int xCent;
		int yCent;
		float radius;
		static float scaleFactor;
	public:
		Circle(int = 0, int = 0); // constructor
		void setCenter();						
		void scale();						
	};

#endif
