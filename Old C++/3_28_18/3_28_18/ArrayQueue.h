#ifndef QUEUE_ARRAY_H     // Prevent duplicate definition
#define QUEUE_ARRAY_H

const int MAXQUEUE = 100;
const int TRUE = 1;
const int FALSE = 0;

// class declaration
// preconditions: requires that MAXQUEUE, the maximum size of the
//              : queue, be defined
//              : requires that TRUE be defined as a nonzero integer
//              : requires that FALSE be defined as 0

class ArrayQueue
{
  private:
    int queue_in;        // top-of-queue position
    int storage[MAXQUEUE];

  public:
    ArrayQueue(void);    // constructor
    void enqueue(int);
    int dequeue(void);   // serve function 
    int isEmpty(void);
    int isFull(void);
};

#endif

