# Java DSA Learning Repository

A comprehensive Java repository containing Data Structures & Algorithms implementations, LeetCode solutions, and Core Java concepts for learning and interview preparation.

## 📁 Project Structure

```
src/com/deeparishi/javaapp/
├── dsaconcepts/          # Core DSA implementations
├── leetcode/             # LeetCode problem solutions
├── corejavaconcepts/     # Java fundamentals and advanced concepts
├── hackerrank/           # HackerRank solutions
├── practice/             # General practice problems
├── systemdesign/         # System design concepts
├── ZohoExam/            # Zoho interview preparation
├── udemychallenge/      # Udemy course challenges
├── miscellaneous/       # Miscellaneous coding problems
├── cheatsheet/          # Quick reference guides
└── notes/               # Learning notes
```

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- IntelliJ IDEA (recommended) or any Java IDE
- Basic understanding of Java programming

### Running the Code
1. Clone the repository
2. Open in your preferred Java IDE
3. Navigate to any class with a `main` method
4. Run the specific class to see the implementation in action

## 📚 Core Topics Covered

### Data Structures & Algorithms (`dsaconcepts/`)

#### **Data Structures**
- **Arrays & ArrayLists** - Dynamic arrays and operations
- **Linked Lists** - Singly and doubly linked lists
- **Stacks & Queues** - LIFO and FIFO implementations
- **Trees** - Binary trees, BST, AVL trees
- **Heaps** - Min/Max heap implementations
- **Graphs** - Graph representations and traversals
- **Tries** - Prefix trees for string operations
- **Hashing** - Hash tables with collision handling

#### **Algorithms**
- **Sorting** - Bubble, Selection, Insertion, Merge, Quick, Radix, Bucket, Count Sort
- **Dynamic Programming** - Fibonacci, Frog Jump, Memoization
- **Graph Algorithms** - BFS, DFS, Dijkstra, Bellman-Ford, Floyd-Warshall
- **Greedy Algorithms** - Various optimization problems
- **Tree Algorithms** - Traversals, searching, balancing

### LeetCode Solutions (`leetcode/`)

Organized by problem categories:
- **Arrays** - Array manipulation and algorithms
- **Strings** - String processing and pattern matching
- **Trees** - Binary tree problems and solutions
- **Graphs** - Graph traversal and shortest path problems
- **Dynamic Programming** - Optimization problems
- **Stacks & Queues** - LIFO/FIFO based problems
- **Linked Lists** - List manipulation problems
- **Sorting & Searching** - Sorting algorithms and binary search
- **Sliding Window** - Window-based optimization problems
- **Greedy Algorithms** - Greedy approach problems
- **Bit Manipulation** - Bitwise operations
- **Math** - Mathematical problem solving
- **Hashing** - Hash-based solutions
- **Recursion** - Recursive problem solving
- **Design** - System design problems

### Core Java Concepts (`corejavaconcepts/`)

#### **Object-Oriented Programming**
- **SOLID Principles** - SRP, OCP, LSP, ISP, DIP
- **Design Patterns** - Creational and Structural patterns

#### **Modern Java Features**
- **Streams API** - Functional programming with streams
- **Lambda Expressions** - Functional interfaces and expressions
- **Records** - Modern data classes
- **Collections Framework** - Advanced collection operations

#### **Concurrency & Multithreading**
- **Basic Threading** - Thread creation and management
- **Executors** - Thread pools and task execution
- **Synchronization** - Locks, semaphores, barriers
- **CompletableFuture** - Asynchronous programming
- **Virtual Threads** - Project Loom features

#### **Advanced Topics**
- **Reflection** - Runtime class inspection
- **Serialization** - Object serialization/deserialization
- **Memory Management** - JVM memory concepts
- **Comparable/Comparator** - Object comparison

## 🎯 Key Features

- **Comprehensive Coverage** - From basic to advanced topics
- **Well-Commented Code** - Clear explanations and documentation
- **Multiple Approaches** - Different solutions for the same problem
- **Interview Ready** - Problems commonly asked in technical interviews
- **Practical Examples** - Real-world applicable implementations

## 📖 How to Use This Repository

### For Learning DSA
1. Start with `dsaconcepts/` for fundamental understanding
2. Practice with `leetcode/` problems by category
3. Review `corejavaconcepts/` for Java-specific knowledge

### For Interview Preparation
1. Focus on `leetcode/` solutions for coding interviews
2. Study `systemdesign/` for system design rounds
3. Review `ZohoExam/` for company-specific preparation

### For Quick Reference
1. Check `cheatsheet/` for quick algorithm references
2. Browse `notes/` for conceptual understanding

## 🔧 Code Examples

### Running a Sorting Algorithm
```java
// Navigate to: dsaconcepts/sorting/MergeSort.java
public static void main(String[] args) {
    int[] arr = new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1};
    int[] sortedArr = mergeSort(arr);
    display(sortedArr);
}
```

### Using Streams API
```java
// Navigate to: corejavaconcepts/streams/functions/FunctionExamples.java
BiFunction<Integer, Integer, String> output = biFunction
    .andThen(sum)
    .andThen(display);
```

## 🤝 Contributing

This is a personal learning repository. Feel free to:
- Fork the repository for your own learning
- Suggest improvements via issues
- Share alternative solutions

## 📝 Notes

- Each major topic has its own package structure
- Most classes contain `main` methods for direct execution
- Code includes both iterative and recursive approaches where applicable
- Solutions prioritize clarity and learning over optimization

## 🎓 Learning Path Recommendation

1. **Beginner**: Start with basic data structures (arrays, linked lists)
2. **Intermediate**: Move to trees, graphs, and sorting algorithms
3. **Advanced**: Tackle dynamic programming and complex graph algorithms
4. **Expert**: Focus on system design and optimization problems

## 📞 Contact

This repository is maintained as part of personal learning journey in Data Structures, Algorithms, and Java programming.

---

**Happy Coding! 🚀**
