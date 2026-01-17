# DSA Learning - Java

A comprehensive Data Structures and Algorithms (DSA) learning project in Java, containing implementations of fundamental DSA concepts and LeetCode solutions.

## Prerequisites

- **Java Development Kit (JDK)**: Java 8 or higher
  - Verify installation: `java -version`
  - Download from: [oracle.com](https://www.oracle.com/java/technologies/downloads/) or use your package manager

## Project Structure

```
src/              # Source code (.java files)
bin/              # Compiled bytecode (.class files) - Auto-generated
├── com/dsaj/concepts/   # DSA concept implementations
└── com/dsaj/problems/   # LeetCode problem solutions
```

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/visheshdvn/dsa-j.git
cd dsa-j
```

### 2. Compile All Source Files

Compile the entire project into the `bin` directory:

```bash
javac -d bin src/**/*.java
```

Or compile recursively:

```bash
find src -name "*.java" | xargs javac -d bin
```

## Running a Java Class

### Option 1: Run from Command Line

After compilation, run any class with a `main` method:

```bash
java -cp bin com.dsaj.problems.leetcode.arrays.LC153FindMinInRotatedSortedArray
```

**Format:** `java -cp bin <fully.qualified.class.name>`

### Example: Run LC153 (Find Min in Rotated Sorted Array)

```bash
java -cp bin com.dsaj.problems.leetcode.arrays.LC153FindMinInRotatedSortedArray
```

Then enter input when prompted:

```
Enter array values: 3 4 5 1 2
Min element: 1
```

### Option 2: Run in VS Code (Recommended)

1. Install **Extension Pack for Java** by Microsoft
2. Open any `.java` file with a `main` method
3. Click **Run** button above the `main` method, or press `Ctrl+F5`

The extension handles compilation and execution automatically.

## Testing a Specific Class

### Step-by-Step Example: Test LC153FindMinInRotatedSortedArray

**1. Navigate to project directory:**

```bash
cd /path/to/dsa-j
```

**2. Compile the project (first time only):**

```bash
javac -d bin src/**/*.java
```

**3. Run the specific class:**

```bash
java -cp bin com.dsaj.problems.leetcode.arrays.LC153FindMinInRotatedSortedArray
```

**4. Provide test input:**

```
Enter array values: 3 4 5 1 2
Min element: 1
```

### Running All Tests

To recompile after making changes:

```bash
# Clean and recompile
rm -rf bin/*
javac -d bin src/**/*.java

# Run a specific class
java -cp bin com.dsaj.problems.leetcode.arrays.LC153FindMinInRotatedSortedArray
```

## Troubleshooting

### Error: "package does not exist"

- **Cause**: Dependencies not compiled
- **Solution**: Ensure all files are compiled with `javac -d bin src/**/*.java`

### Error: "cannot find symbol"

- **Cause**: Classpath incorrect or file not compiled
- **Solution**: Use `-cp bin` flag and verify class exists in `bin` directory

### Error: "Main method not found"

- **Cause**: Class doesn't have a `main` method
- **Solution**: Only run files with `public static void main(String[] args)`

## Quick Reference

| Task        | Command                                                                           |
| ----------- | --------------------------------------------------------------------------------- |
| Compile all | `javac -d bin src/**/*.java`                                                      |
| Run a class | `java -cp bin com.dsaj.problems.leetcode.arrays.LC153FindMinInRotatedSortedArray` |
| Clean build | `rm -rf bin/* && javac -d bin src/**/*.java`                                      |

## Notes

- The `bin/` folder contains compiled classes and should **not** be committed to version control
- It's included in `.gitignore` and is automatically regenerated during compilation
- Source files are in the `src/` directory

## Project Contents

- **Concepts**: DSA fundamentals (arrays, linked lists, trees, queues, stacks, sorting)
- **Problems**: LeetCode solutions organized by topic (arrays, linked lists, trees, etc.)

---

**Happy Learning! 🎓**
