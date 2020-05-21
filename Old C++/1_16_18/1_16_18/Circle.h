class Circle
{
private:
	int xCent, yCent;
	float radius;
	static float scaleFactor;
public:
	Circle(int = 5, int = 10, float = 5);
	void setRadius(float);
	void setXYCent(int, int);
	void setXCent(int);
	void setYCent(int);
	int getXCent();
	int getYCent();
	float getRadius();
	static void setScaleFactor(float factor);
	static float getScaleFactor();
	void scaleRadius();
};