Implement Stack and Queue using Deque:

Deque also known as double ended queue, as name suggests is a special kind of queue in which insertions and deletions can be done at the last as well as at the beginning.
A link-list representation of deque is such that each node points to the next node as well as the previous node. So that insertion and deletions take constant time at both the beginning and the last.

Examples: Stack 

Input : Stack : 1 2 3
        Push(4)
Output : Stack : 1 2 3 4

Input : Stack : 1 2 3
        Pop()
Output : Stack : 1 2

Examples: Queue 

Input: Queue : 1 2 3
       Enqueue(4)
Output: Queue : 1 2 3 4

Input: Queue : 1 2 3
       Dequeue()
Output: Queue : 2 3

Output :

Stack: 7 8 
Stack: 7 

Queue: 12 13 
Queue: 13 

Size of Stack is 1
Size of Queue is 1

Time Complexity: O(n)
Auxiliary Space: O(n)
