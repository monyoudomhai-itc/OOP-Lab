# 📁 Java File Processing Guide
> Based on OOP Lecture 05 — Constructor & File Processing

---

## 📦 Imports You Need

```java
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
```

---

## 🧠 Core Classes Overview

| Class | Purpose |
|---|---|
| `PrintWriter` | Writes text to a file |
| `File` | Represents a file path on disk |
| `Scanner` | Reads line by line from a file |

---

## ✍️ Writing to a File — `PrintWriter`

```java
public class FileTest {
    public static void main(String[] args) throws Exception {

        PrintWriter writer = new PrintWriter("file.txt");

        writer.println("Hello file!");       // writes text + line break
        writer.println("More text");         // writes text + line break
        writer.print("And a little extra");  // writes text WITHOUT line break

        writer.close(); // closes the file and saves everything
    }
}
```

### 💡 Key Points
- `throws Exception` on the method means you don't need a try-catch block.
- `writer.println()` works just like `System.out.println()` — but writes to the file.
- `writer.print()` writes text **without** a line break at the end.
- Always call `writer.close()` — this saves and closes the file!

---

## 📖 Reading from a File — `Scanner`

```java
import java.io.File;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("fileName.txt"));

        while (scanner.hasNextLine()) {        // check if there is a next line
            String line = scanner.nextLine();  // read the line
            System.out.println(line);
        }
    }
}
```

### 💡 Key Points
- `new File("fileName.txt")` — pass a `File` object to `Scanner`, not just a String.
- `scanner.hasNextLine()` returns `true` if there is still a line to read.
- `scanner.nextLine()` reads and returns the next line as a `String`.
- It's the same `Scanner` class you use for keyboard input — just with a `File` instead of `System.in`!

---

## 🔍 Skipping Blank Lines

```java
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();

    // if the line is blank, skip it
    if (line.isEmpty()) {
        continue;
    }

    // do something with the data
    System.out.println(line);
}
```

### 💡 Key Points
- `line.isEmpty()` returns `true` if the line has no characters.
- `continue` skips the rest of the loop body and moves to the next line.

---

## 🔄 Full Example — Write Then Read

```java
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) throws Exception {

        // Step 1: Write data to file
        writeToFile("students.txt");

        // Step 2: Read it back
        readFromFile("students.txt");
    }

    // --- WRITE ---
    static void writeToFile(String filename) throws Exception {
        PrintWriter writer = new PrintWriter(filename);

        writer.println("Alice, 25");
        writer.println("Bob, 30");
        writer.println("Charlie, 22");

        writer.close();
        System.out.println("Written to " + filename);
    }

    // --- READ ---
    static void readFromFile(String filename) throws Exception {
        Scanner scanner = new Scanner(new File(filename));

        System.out.println("Reading from " + filename + ":");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            System.out.println("  -> " + line);
        }
    }
}
```

### Expected Output
```
Written to students.txt
Reading from students.txt:
  -> Alice, 25
  -> Bob, 30
  -> Charlie, 22
```

---

## ⚠️ Common Mistakes to Avoid

| ❌ Mistake | ✅ Fix |
|---|---|
| Forgetting `writer.close()` | Always close — otherwise the file may not save |
| Passing a `String` to `Scanner` directly | Wrap it: `new Scanner(new File("name.txt"))` |
| Not adding `throws Exception` | Add it to the method signature |
| Reading a file that doesn't exist | Write to the file first |

---

---

# 🏋️ Exercises — Practice File Processing

> Try to solve each exercise yourself before checking the hints!

---

## Exercise 1 — Write a Shopping List

**Task:**
Create a program that writes a shopping list to a file called `shopping.txt`.
The list should have at least 5 items, each on its own line.

**Expected `shopping.txt`:**
```
Apples
Bread
Milk
Eggs
Butter
```

<details>
<summary>💡 Hint 1</summary>

Use `PrintWriter` to write. Call `writer.println("item")` for each item.

</details>

<details>
<summary>💡 Hint 2</summary>

```java
PrintWriter writer = new PrintWriter("shopping.txt");
writer.println("Apples");
writer.println("Bread");
// ... add more
writer.close();
```

</details>

---

## Exercise 2 — Read and Print the List

**Task:**
Read the `shopping.txt` file from Exercise 1 and print each item with a number in front of it.

**Expected Console Output:**
```
1. Apples
2. Bread
3. Milk
4. Eggs
5. Butter
```

<details>
<summary>💡 Hint 1</summary>

Use `Scanner` with a `File` object. Create an `int counter = 1` and increase it each loop.

</details>

<details>
<summary>💡 Hint 2</summary>

```java
Scanner scanner = new Scanner(new File("shopping.txt"));
int count = 1;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    System.out.println(count + ". " + line);
    count++;
}
```

</details>

---

## Exercise 3 — Count Lines in a File

**Task:**
Write a method `countLines(String filename)` that reads a file and returns the total number of lines as an `int`. Test it on `shopping.txt`.

**Expected Console Output:**
```
Total lines: 5
```

<details>
<summary>💡 Hint 1</summary>

Create `int count = 0` before the loop. Every time you read a line, add 1. Return count after the loop.

</details>

<details>
<summary>💡 Hint 2</summary>

```java
static int countLines(String filename) throws Exception {
    Scanner scanner = new Scanner(new File(filename));
    int count = 0;
    while (scanner.hasNextLine()) {
        scanner.nextLine();
        count++;
    }
    return count;
}
```

</details>

---

## Exercise 4 — Write and Read Student Data

**Task:**
Write 3 students (name and age) to a file called `students.txt`, then read it back and print each student's info neatly.

**Expected `students.txt`:**
```
Tola,20
Kompheak,22
Srey,21
```

**Expected Console Output:**
```
Name: Tola     | Age: 20
Name: Kompheak | Age: 22
Name: Srey     | Age: 21
```

<details>
<summary>💡 Hint 1 — Writing</summary>

Use `writer.println("Name,Age")` format — a comma separates the name and age.

</details>

<details>
<summary>💡 Hint 2 — Reading and Splitting</summary>

Use `split(",")` to separate the name and age from each line:
```java
String[] parts = line.split(",");
String name = parts[0];
String age  = parts[1];
```

</details>

---

## Exercise 5 — Student Grade Tracker ⭐ (Challenge)

**Task:**
Build a mini grade tracker that:
1. **Writes** 4 students with their scores to `grades.txt` (format: `Name,Score`)
2. **Reads** the file back
3. **Calculates** and prints the average score
4. **Prints** who has the highest score

**Expected `grades.txt`:**
```
Alice,88
Bob,95
Charlie,72
Diana,90
```

**Expected Console Output:**
```
--- Student Grades ---
Alice    : 88
Bob      : 95
Charlie  : 72
Diana    : 90

Average Score : 86.25
Top Student   : Bob (95)
```

<details>
<summary>💡 Hint 1 — Splitting a line</summary>

```java
String[] parts = line.split(",");
String name = parts[0];
int score   = Integer.parseInt(parts[1]);
```

</details>

<details>
<summary>💡 Hint 2 — Tracking the highest score</summary>

Create `String topName = ""` and `int topScore = 0`. Each loop, if the current score is greater than `topScore`, update both variables.

</details>

<details>
<summary>💡 Hint 3 — Calculating average</summary>

```java
double average = (double) total / count;
```

</details>

---

## ✅ Exercise Completion Checklist

| # | Exercise | Skill Practiced |
|---|---|---|
| 1 | Write a shopping list | `PrintWriter`, `println()`, `close()` |
| 2 | Read and number the list | `Scanner`, `hasNextLine()`, `nextLine()` |
| 3 | Count lines in a file | Loop counting, return values |
| 4 | Write and read student data | `split(",")`, combining write + read |
| 5 | Student grade tracker ⭐ | `parseInt()`, calculations, tracking max |

---

> 💬 **Remember:** Always call `writer.close()` after writing, and always pass `new File("name.txt")` to Scanner when reading!