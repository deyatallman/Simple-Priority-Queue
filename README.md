# CS 2420 Assignment 03: Generic Priority Queue

## Description
The purpose of this assignment is to implement a generic priority queue that supports access to the maximum element. The priority queue is backed by a sorted array, and its operations, such as finding the maximum element and deleting the maximum element, must run efficiently. The priority queue can accommodate any type of item, and it maintains items in sorted order to ensure fast access to the maximum element.

## Implementation Details
- Implemented a generic class `SimplePriorityQueue<E>` that implements the `PriorityQueue<E>` interface.
- The priority queue is backed by a sorted array, with elements ordered either by their natural ordering or by a provided comparator.
- Utilized binary search for efficient insertion and element search, avoiding the use of Java's `Arrays.binarySearch` method.
- Implemented methods for inserting elements, finding the maximum element, deleting the maximum element, checking containment, getting the size, checking if the priority queue is empty, and clearing the priority queue.
- Implemented JUnit5 tests (`SimplePriorityQueueTest`) to verify the correctness of the priority queue implementation.

## Classes
- `PriorityQueue<E>`: Interface defining the methods required for the priority queue.
- `SimplePriorityQueue<E>`: Generic class implementing the priority queue using a sorted array.
- `SimplePriorityQueueTest`: JUnit5 test class for testing the `SimplePriorityQueue` class.

## Usage
1. Instantiate a `SimplePriorityQueue` object, optionally specifying a comparator for custom ordering.
2. Use methods like `insert`, `findMax`, `deleteMax`, etc., to manipulate the priority queue.
3. Run JUnit tests in `SimplePriorityQueueTest` to validate the implementation.

## Testing
- Implemented comprehensive JUnit5 tests to verify the functionality and correctness of the priority queue implementation.
- Tested various scenarios including inserting elements, finding the maximum element, deleting the maximum element, checking containment, getting the size, and clearing the priority queue.
- Special attention was given to edge cases such as an empty priority queue and handling exceptions.

## Author
- Deya Tallman and Erin Parker
- Date: 1/31/2024
