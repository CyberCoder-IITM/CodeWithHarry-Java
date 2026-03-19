# Java Learning Repository

A comprehensive collection of Java programs demonstrating fundamental to advanced programming concepts, algorithms, cryptography, and real-world applications.

## Repository Structure

This repository contains **150+ Java programs** organized by topic, ranging from basic syntax to advanced algorithms and security implementations.

---

## Main Categories

### 1. **Algorithms & Data Structures** (15+ Programs)

#### Sorting & Searching Algorithms

- **AK_BasicSorting.java** - Bubble Sort and Selection Sort implementations
- **AK_Binary_Search.java** - Binary search on sorted arrays
- **KMPStringMatcher.java** - Knuth-Morris-Pratt string pattern matching algorithm

#### Advanced Path-Finding & Graph Algorithms

- **AStarPathfinder.java** - A\* pathfinding algorithm on 2D grids with heuristic optimization
- **FloydWarshallAlgorithm.java** - All-pairs shortest path algorithm

#### Array & Optimization Algorithms

- **AK_Kadande_Algorithm.java** - Kadane's algorithm for finding maximum subarray sum (O(n))
- **AK_prefix_sum.java** - Prefix sum array technique for range sum queries
- **AK_max_subarray_sum_brute.java** - Brute force approach to maximum subarray problem
- **AK_Trapping_Rainwater.java** - Optimal solution for trapping rainwater problem
- **AK_buyAndSellStocks.java** - Best time to buy and sell stocks algorithm
- **AK_print_subarrays.java** - Generate all subarrays of an array
- **AK_arrays_pairs_in_array.java** - Find all pairs in an array
- **AK_reverse_an_array.java** - Reverse an array in-place

---

### 2. **Data Structures & Collections** (12+ Programs)

#### Linear Data Structures

- **CWH_91_arraylist.java** - ArrayList creation, manipulation, and merging
- **CWH_92_linkedlist.java** - LinkedList operations (add, remove, search)
- **CWH_93_ArrayDeque.java** - Double-ended queue implementation
- **StackExample.java** - Stack operations (push, pop, peek)
- **QueueEx.java** - Queue implementation using LinkedList (FIFO)

#### Set & Map Data Structures

- **CWH_95_set.java** - HashSet for unique elements
- **MapEx.java** - HashMap with lambda expressions for iteration
- **CWH_89_collections.java** - Collections framework overview

#### Tree & Graph Data Structures

- **LevelOrderTraversal.java** - Binary tree level-order (BFS) traversal
- **DynamicExpressionEngine.java** - Shunting Yard algorithm with custom operators

---

### 3. **Cryptography & Security** (18+ Programs)

#### Encryption & Decryption

- **AESCryptoDemo.java** - AES encryption/decryption with 128/192/256-bit keys
- **CaesarCipher.java** - Caesar cipher with shift-based encryption/decryption
- **XORCipher.java** - XOR-based encryption technique
- **Base64Tool.java** - Base64 encoding and decoding utility

#### Hashing & Integrity

- **FileHasher.java** - SHA-256 file hashing for integrity verification
- **IntegritySentinel.java** - File Integrity Monitoring (FIM) tool with baseline creation
- **DictionaryAttacker.java** - Dictionary attack simulator with SHA-256 hashing
- **SimpleBlockchain.java** - Blockchain implementation with Proof-of-Work mining

#### Password Security

- **PasswordStrengthChecker.java** - Password strength analysis using character sets
- **EntropyMeter.java** - Password entropy calculation based on information theory

#### Network Security

- **BrowserSecurityDemo.java** - Bloom Filter for malicious URL detection
- **PortScanner.java** - Network port scanner with timeout handling
- **NetworkFlowAnalysis.java** - Packet flow analysis with anomaly detection
- **FlowLens** - Network traffic analysis tool with heuristic-based anomaly detection

#### Web & API Security

- **WeatherClient.java** - HTTP client for secure API communication

---

### 4. **Object-Oriented Programming** (20+ Programs)

#### Classes & Objects

- **CWH_38_ObjectAndClasses.java** - Class definition and object instantiation
- **CWH_42_Constructors.java** - Multiple constructor overloading
- **CWH_31_Methods_In_Java.java** - Static methods and method invocation
- **CWH_32_MethodOverloading.java** - Method overloading with different parameter types
- **CWH_33_VarArgs.java** - Variable-length arguments (varargs) in methods

#### Inheritance & Polymorphism

- **CWH_45_inheritance.java** - Single inheritance with base and derived classes
- **CWH_46_Constructors_in_inheritance.java** - Constructor chaining across hierarchy
- **CWH_47_this_super.java** - Usage of `this` and `super` keywords
- **CWH_48_method_overriding.java** - Method overriding in subclasses
- **CWH_49_dynamic_method_dispatch.java** - Runtime polymorphism

#### Abstraction & Interfaces

- **CWH_53_abstract.java** - Abstract classes and abstract methods
- **CWH_54_Interfaces.java** - Multiple interface implementation
- **CWH_57_default_methods.java** - Default methods in interfaces (Java 8+)
- **CWH_58_inheritance_in_interfaces.java** - Interface inheritance
- **CWH_59_polymorphism_in_interfaces.java** - Polymorphic behavior with interfaces

#### Access Control

- **CWH_40_AccessModifiers.java** - Public, private, protected, default modifiers
- **CWH_66_access_modifiers.java** - Practical examples of access modifiers

---

### 5. **Exception Handling** (12+ Programs)

#### Basic Exception Handling

- **CWH_80_try.java** - Try-catch blocks
- **CWH_81_specific_exceptions.java** - Multiple catch blocks for specific exceptions
- **CWH_82_nested_try_catch.java** - Nested try-catch blocks
- **CWH_85_finally.java** - Finally block for cleanup operations

#### Custom Exceptions

- **CWH_83_exception_class.java** - Creating custom exception classes
- **CWH_84_throw_throws.java** - Throwing and declaring exceptions
- **CWH_103_custom_calculator.java** - Custom exceptions in arithmetic operations
- **Exceptional_Handling.java** - Exception handling best practices

---

### 6. **Threading & Concurrency** (7+ Programs)

- **CWH_70.java** - Basic thread creation by extending Thread class
- **CWH_71_runnable.java** - Thread creation using Runnable interface
- **CWH_73_thread_constructor.java** - Thread naming and identification
- **CWH_74_thread_priorities.java** - Thread priority and scheduling
- **CWH_75_thread_methods.java** - Thread methods (sleep, join)
- **CWH_70.java** - Multi-threaded execution patterns

---

### 7. **Generics & Lambda Expressions** (5+ Programs)

- **CWH_110_generics.java** - Generic classes with type parameters
- **CWH_109_lambda.java** - Lambda expressions and functional interfaces
- **LambdaEx.java** - Lambda with return values
- **LambdaForEachEx.java** - ForEach with lambda expressions
- **Generics.java** - Generics with wildcards (`<? super T>`)

---

### 8. **Date & Time** (6+ Programs)

- **CWH_96_date.java** - System.currentTimeMillis() for timestamp calculations
- **CWH_97_date_class.java** - Deprecated Date class methods
- **CWH_98_calendar_class.java** - Calendar class with TimeZones
- **CWH_99_gregorian.java** - GregorianCalendar and leap year checking
- **CWH_100_java_time.java** - Modern Java Time API (LocalDate, LocalTime)
- **CWH_101_datetimeformatter.java** - Custom date formatting
- **DateEx.java** - Date arithmetic (adding/subtracting days)

---

### 9. **Arrays & Strings** (12+ Programs)

#### String Manipulation

- **CWH_13_Strings.java** - String declaration and formatting
- **CWH_14_String_Methods.java** - String methods (toUpperCase, toLowerCase, substring, etc.)
- **SmallToCapitalLetters.java** - Case conversion and character manipulation

#### Array Operations

- **CWH_26_Arrays.java** - Array declaration and initialization
- **CWH_27_ForEachLoop.java** - For-each loop for array iteration
- **CWH_28_Multidimensional_Arrays.java** - 2D array operations
- **Practice_Array.java** - Array manipulation examples
- **Practice_Array3x3.java** - 3x3 matrix operations

#### Advanced Array Problems

- **Amazon_Array.java** - Finding duplicate elements
- **PalindromeChecker.java** - Palindrome detection with two-pointer technique
- **ReverseNumber.java** - Reverse a number
- **ArmstrongNumber.java** - Armstrong number validation

---

### 10. **Mathematical Algorithms** (8+ Programs)

- **CWH_34_Recursion.java** - Factorial using recursion vs iteration
- **Fibonacci_recursion.java** - Fibonacci series using recursion
- **Fibonacci_nth_term.java** - Nth Fibonacci term calculation
- **Fibonacci.java** - Fibonacci series generation
- **Fatorial_Reverse.java** - Factorial computation with reverse loop
- **PrimeNumberAnalyzer.java** - Prime number detection and counting
- **Pattern_using_recursion.java** - Star patterns using recursion
- **LinearRegression.java** - Simple linear regression using OLS method

---

### 11. **File I/O & Serialization** (5+ Programs)

- **CWH_111_file_handling.java** - File creation, writing, reading, and deletion
- **SeriEX.java** - Object serialization to file
- **SERiEx2.java** - Object deserialization from file
- **IntegritySentinel.java** - File integrity monitoring system

---

### 12. **Control Flow & Fundamentals** (25+ Programs)

#### Data Types & Operators

- **CWH_04_literals.java** - Primitive data types (byte, int, float, double, char, boolean)
- **CWH_08_Operators.java** - Arithmetic, assignment, logical, bitwise operators
- **CWH_09_Operator_Precedence.java** - Operator precedence and associativity
- **CWH_10_DataTypesOfExpressions.java** - Type conversion and increment/decrement operators

#### Conditional Statements

- **CWH_16_Conditional.java** - If-else statements
- **CWH_17_Operators.java** - Logical AND, OR, NOT operators
- **CWH_18_Switch_Statements.java** - Switch statements (enhanced syntax)

#### Loops

- **CWH_21_While_Loop.java** - While loop syntax and usage
- **CWH_22_Do_While_Loop.java** - Do-while loop
- **CWH_23_For_Loop.java** - For loop with various patterns
- **CWH_24_BreakAndContinueStatements.java** - Break and continue statements

#### Input & Output

- **CWH_05_TakingInput.java** - Scanner class for user input
- **CWH_06_MarksToPercentageCalculator.java** - Input validation and calculation

---

### 13. **Practice Problem Sets** (10+ Complete Sets)

Each set contains 5-15 problems with solutions:

- **CWH_CH1_PS.java** - Basic operations and input/output
- **CWH_CH2_PS.java** - Operators and type conversion
- **CWH_CH3_PS.java** - String manipulation challenges
- **CWH_CH4_PS.java** - Conditional logic problems
- **CWH_CH5_PS.java** - Loop and pattern problems
- **CWH_CH6_PS.java** - Array manipulation problems
- **CWH_CH7_PS.java** - Methods and recursion problems
- **CWH_CH8_PS.java** - Class design challenges
- **CWH_CH9_PS.java** - Constructor and property problems
- **CWH_CH10_PS.java** - Inheritance problems
- **CWH_CH11_PS.java** - Abstract classes and interfaces
- **CWH_CH13_PS.java** - Threading problems
- **CWH_CH14_PS.java** - Exception handling challenges
- **CWH_CH15_PS.java** - Collections and date/time problems

---

### 14. **Specialized Applications** (6+ Programs)

#### Games & Entertainment

- **CWH_41_RPS_GAME.java** - Rock-Paper-Scissors game
- **CWH_43_Guess_The_Number.java** - Number guessing game
- **ConsoleMazeGen.java** - Console-based maze generation

#### Utility Tools

- **Temperature_conversion.java** - Celsius to Fahrenheit conversion
- **Area_Rectangle.java** - Rectangle area calculation
- **AnomalyFlow.java** - Real-time anomaly detection with standard deviation
- **CWH_61_Online_Library.java** - Library management system

---

## Code Statistics

| Category              | Count    |
| --------------------- | -------- |
| Algorithms            | 15+      |
| Data Structures       | 12+      |
| Cryptography/Security | 18+      |
| OOP Concepts          | 20+      |
| Exception Handling    | 12+      |
| Threading             | 7+       |
| Generics & Lambda     | 5+       |
| Date & Time           | 6+       |
| Arrays & Strings      | 12+      |
| Mathematics           | 8+       |
| I/O & Serialization   | 5+       |
| Control Flow          | 25+      |
| Practice Problems     | 10+ Sets |
| Specialized Apps      | 6+       |
| **TOTAL**             | **150+** |

---

## 🎓 Learning Outcomes

After studying this repository, you will understand:

### **Fundamentals**

- Data types, variables, and operators
- Control flow (if-else, switch, loops)
- Methods and function overloading
- Arrays and multidimensional arrays

### **Object-Oriented Programming**

- Classes, objects, and encapsulation
- Inheritance and polymorphism
- Abstraction and interfaces
- Access modifiers and visibility

### **Advanced Concepts**

- Exception handling and custom exceptions
- Generics and type safety
- Lambda expressions and functional programming
- Threading and concurrent programming
- Collections Framework (ArrayList, LinkedList, HashMap, etc.)

### **Algorithms & Data Structures**

- Sorting algorithms (Bubble Sort, Selection Sort)
- Searching algorithms (Binary Search, KMP)
- Graph algorithms (A\*, Floyd-Warshall)
- Optimization techniques (Kadane's Algorithm, Prefix Sum)
- Tree traversal (Level-order BFS)

### **Cryptography & Security**

- Encryption (AES, Caesar Cipher)
- Hashing (SHA-256, File Integrity)
- Password security and entropy analysis
- Network security (Port Scanner, Bloom Filters)
- Blockchain basics

### **Real-World Applications**

- API communication (Weather Client)
- File handling and serialization
- Network packet analysis
- Date/Time manipulation
- Pattern matching and anomaly detection

---

## Quick Start

### Compile a Program

```bash
javac FileName.java
```

### Run a Program

```bash
java FileName
```

### Example: Running a Sorting Algorithm

```bash
javac AK_BasicSorting.java
java AK_BasicSorting
```

---

## File Organization

```
Java/
├── Algorithm Files (AK_*.java)
├── CodeWithHarry (CWH_*.java) - Complete tutorial series
├── Data Structure Files (CWH_*_arraylist.java, etc.)
├── Cryptography Files (*Cipher.java, *Crypto*.java)
├── Threading Examples (*Thread*.java)
├── Practice Problems (CWH_CH*_PS.java)
└── Specialized Applications (*Checker.java, *Demo.java)
```

---

## 🔑 Key Features

### 1. **Well-Documented Code**

Every program includes:

- Class-level documentation
- Method descriptions with @param and @return tags
- Inline comments explaining complex logic
- Multiple examples in main methods

### 2. **Progressive Difficulty**

- **Beginner**: Basic syntax, control flow, simple methods
- **Intermediate**: OOP concepts, collections, exception handling
- **Advanced**: Algorithms, cryptography, threading, generics

### 3. **Hands-On Learning**

- Runnable examples with sample data
- Practice problem sets with solutions
- Real-world applications (library, maze, API client)
- Interactive programs with user input

### 4. **Comprehensive Topics**

- From "Hello World" to Blockchain
- Covers Java 8+ features (Lambda, Streams)
- Security-focused implementations
- Network and file I/O operations

---

## 💡 Notable Programs

### Must-Study Programs:

1. **AStarPathfinder.java** - Advanced algorithm implementation
2. **SimpleBlockchain.java** - Cryptographic concepts
3. **AESCryptoDemo.java** - Real encryption/decryption
4. **CWH_54_Interfaces.java** - Multiple inheritance through interfaces
5. **IntegritySentinel.java** - Practical security application

### Challenging Programs:

1. KMPStringMatcher - Pattern matching O(n + m)
2. FloydWarshallAlgorithm - Graph algorithms O(n³)
3. DynamicExpressionEngine - Custom operator parsing
4. AnomalyFlow - Statistical anomaly detection
5. NetworkFlowAnalysis - Packet parsing and analysis

---

## 🔧 Requirements

- **Java Version**: Java 8 or higher
- **IDE**: VS Code, IntelliJ IDEA, or Eclipse (optional)
- **Compiler**: `javac` (included with JDK)
- **Runtime**: `java` (included with JDK)

---

## 📚 Recommended Study Order

### Phase 1: Fundamentals (1-2 weeks)

1. CWH_04 through CWH_24 (Data types, operators, control flow)
2. CWH_26 through CWH_28 (Arrays)
3. CWH_31 through CWH_34 (Methods and recursion)

### Phase 2: OOP (2-3 weeks)

1. CWH_38 through CWH_42 (Classes, constructors)
2. CWH_45 through CWH_49 (Inheritance, polymorphism)
3. CWH_53 through CWH_59 (Abstraction, interfaces)

### Phase 3: Advanced Concepts (2-3 weeks)

1. CWH_80 through CWH_85 (Exception handling)
2. CWH_89 through CWH_95 (Collections)
3. CWH_109 through CWH_111 (Generics, lambdas, I/O)
4. CWH_70 through CWH_75 (Threading)

### Phase 4: Algorithms & Applications (2-4 weeks)

1. AK\_\* files (Sorting, searching, optimization)
2. Cryptography files (CaesarCipher, AES, etc.)
3. Specialized applications (Online Library, Games)

---

## 🎯 Use Cases

### 🎓 **Educational**

- Learn Java fundamentals
- Study algorithms and data structures
- Understand design patterns

### 💼 **Interview Preparation**

- Algorithm problems (LeetCode-style)
- OOP design questions
- Exception handling scenarios

### 🔐 **Security Learning**

- Cryptography basics
- Hashing and integrity verification
- Network security concepts

### 🚀 **Project Reference**

- Copy algorithm implementations
- Use as code templates
- Understand best practices

---

## Topics Coverage Matrix

| Topic            | Beginner | Intermediate | Advanced |
| ---------------- | -------- | ------------ | -------- |
| **Syntax**       | ✅       | -            | -        |
| **OOP**          | ✅       | ✅           | ✅       |
| **Algorithms**   | -        | ✅           | ✅       |
| **Cryptography** | -        | ✅           | ✅       |
| **Threading**    | -        | ✅           | ✅       |
| **Security**     | -        | -            | ✅       |
| **Optimization** | -        | ✅           | ✅       |

---

## 🤝 Contributing

Found a bug or want to improve code? Feel free to:

1. Add documentation
2. Optimize existing code
3. Add more test cases
4. Fix edge cases

---

## 📜 License

This is a learning repository. Use freely for educational purposes.

---

## 👨About This Repository

This comprehensive Java learning repository covers:

- **150+ Java Programs** demonstrating fundamental to advanced concepts
- **Complete conceptual coverage** from basic syntax to cryptographic algorithms
- **Real-world applications** including security tools and games
- **Best practices** and well-documented code examples

**Perfect for**: Students, developers preparing for interviews, and professionals learning advanced Java concepts.

---

## 📞 Quick Reference

### File Name Conventions

- `AK_*.java` - Algorithm files
- `CWH_*.java` - CodeWithHarry tutorial series
- `CWH_CH*_PS.java` - Practice problem sets
- `*Cipher.java` - Encryption implementations
- `*Demo.java` - Demonstrations and examples

### Running Common Programs

```bash
# Run sorting algorithms
java AK_BasicSorting

# Run pathfinding
java AStarPathfinder

# Run encryption
java AESCryptoDemo

# Run library system
java CWH_61_Online_Library

# Run games
java CWH_41_RPS_GAME
java CWH_43_Guess_The_Number
```

---

## 🎉 Happy Learning!

This repository contains everything you need to master Java from basics to advanced topics. Start with fundamentals and progressively move to more complex concepts.

**Last Updated**: March 2026  
**Total Programs**: 150+  
**Lines of Code**: 15,000+

---

_"Code is read much more often than it is written."_ - Guido van Rossum
