# 📋 Java ArrayList — Complete Method Reference

> `ArrayList` is a resizable array implementation in Java (`java.util.ArrayList`). Unlike a fixed-size array, it grows and shrinks dynamically. It is part of the **Java Collections Framework**.

```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
```

---

## 📑 Table of Contents

- [add()](#add)
- [addAll()](#addAll)
- [get()](#get)
- [set()](#set)
- [remove()](#remove)
- [removeAll()](#removeAll)
- [removeIf()](#removeIf)
- [size()](#size)
- [isEmpty()](#isEmpty)
- [contains()](#contains)
- [indexOf()](#indexOf)
- [lastIndexOf()](#lastIndexOf)
- [clear()](#clear)
- [toArray()](#toArray)
- [subList()](#subList)
- [sort()](#sort)
- [iterator()](#iterator)
- [forEach()](#forEach)
- [clone()](#clone)
- [trimToSize()](#trimToSize)
- [ensureCapacity()](#ensureCapacity)

---

## <a id="add"></a> `add()`

### What it does
Adds an element to the ArrayList. You can either append it to the **end of the list**, or insert it at a **specific index** — pushing existing elements to the right.

### Syntax
```java
list.add(element);
list.add(index, element);
```

### Parameters

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `element` | `E` (the generic type) | ✅ Yes | The element to add |
| `index`   | `int` | ❌ Optional | Position to insert at (0-based) |

### Accepted Data Types
Since `ArrayList` uses generics, the element type depends on how you declared it:

| Declaration | What you can add |
|-------------|-----------------|
| `ArrayList<String>` | `String` only |
| `ArrayList<Integer>` | `Integer` (auto-boxed from `int`) |
| `ArrayList<Double>` | `Double` (auto-boxed from `double`) |
| `ArrayList<Boolean>` | `Boolean` (auto-boxed from `boolean`) |
| `ArrayList<Object>` | Any object |
| `ArrayList` (raw) | Any object (not recommended) |

> ⚠️ **Primitives** like `int`, `double`, `char` are **auto-boxed** — Java automatically wraps them into `Integer`, `Double`, `Character`.

### How to Use
```java
ArrayList<String> fruits = new ArrayList<>();

// Append to the end
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
// Result: ["Apple", "Banana", "Cherry"]

// Insert at a specific index
fruits.add(1, "Mango");
// Result: ["Apple", "Mango", "Banana", "Cherry"]
```

### How it Works
- When you call `add(element)`, it places the element at position `size` and increments the size counter.
- When you call `add(index, element)`, it **shifts all elements** from that index onward one position to the right, then inserts.
- If the internal array is full, ArrayList **doubles its capacity** automatically (this is called *resizing/growing*).

### Returns
- `add(element)` → `boolean` (always `true`)
- `add(index, element)` → `void`

### Throws
- `IndexOutOfBoundsException` if `index < 0` or `index > size()`

---

## <a id="addAll"></a> `addAll()`

### What it does
Adds **all elements** from another collection into this ArrayList at once — either at the end or at a specific index.

### Syntax
```java
list.addAll(collection);
list.addAll(index, collection);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `collection` | `Collection<? extends E>` | Any Collection (List, Set, etc.) |
| `index` | `int` | Optional. Where to insert the collection |

### How to Use
```java
ArrayList<String> list1 = new ArrayList<>();
list1.add("A");
list1.add("B");

ArrayList<String> list2 = new ArrayList<>();
list2.add("C");
list2.add("D");

list1.addAll(list2);
// Result: ["A", "B", "C", "D"]

list1.addAll(1, list2);
// Result: ["A", "C", "D", "B", "C", "D"]
```

### Returns
`boolean` — `true` if the list changed as a result of the call.

---

## <a id="get"></a> `get()`

### What it does
Retrieves the element at a specified index without removing it.

### Syntax
```java
E element = list.get(index);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `index` | `int` | The position of the element (0-based) |

### How to Use
```java
ArrayList<String> colors = new ArrayList<>();
colors.add("Red");
colors.add("Green");
colors.add("Blue");

String first = colors.get(0);   // "Red"
String second = colors.get(1);  // "Green"
String last = colors.get(colors.size() - 1); // "Blue"
```

### How it Works
ArrayList is backed by an array, so `get()` is an **O(1)** constant-time operation — it directly accesses the internal array by index.

### Returns
`E` — the element at the given position.

### Throws
- `IndexOutOfBoundsException` if `index < 0` or `index >= size()`

---

## <a id="set"></a> `set()`

### What it does
**Replaces** the element at a specified index with a new value.

### Syntax
```java
E oldElement = list.set(index, newElement);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `index` | `int` | Position of the element to replace |
| `newElement` | `E` | The new value to store at that position |

### How to Use
```java
ArrayList<String> animals = new ArrayList<>();
animals.add("Cat");
animals.add("Dog");
animals.add("Fish");

animals.set(1, "Bird"); 
// Result: ["Cat", "Bird", "Fish"]

String replaced = animals.set(0, "Lion"); 
// replaced = "Cat"
// Result: ["Lion", "Bird", "Fish"]
```

### Returns
`E` — the element that was previously at that index.

### Throws
- `IndexOutOfBoundsException` if `index < 0` or `index >= size()`

---

## <a id="remove"></a> `remove()`

### What it does
Removes an element from the ArrayList, either by **index** or by **value**.

### Syntax
```java
list.remove(index);      // remove by index
list.remove(object);     // remove by value
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `index` | `int` | The position to remove |
| `object` | `Object` | The first matching element to remove |

> ⚠️ **Ambiguity with integers:** If your list is `ArrayList<Integer>`, calling `remove(2)` removes by **index**, not by value `2`. To remove by value, cast: `list.remove(Integer.valueOf(2))`.

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("X");
list.add("Y");
list.add("Z");

list.remove(0);       // Removes "X" by index → ["Y", "Z"]
list.remove("Z");     // Removes "Z" by value → ["Y"]

// Integer example
ArrayList<Integer> nums = new ArrayList<>();
nums.add(10);
nums.add(20);
nums.add(30);

nums.remove(1);                   // Removes index 1 → [10, 30]
nums.remove(Integer.valueOf(10)); // Removes value 10 → [30]
```

### How it Works
When an element is removed, all subsequent elements **shift left** by one position, and the size decreases by 1.

### Returns
- `remove(index)` → `E` the removed element
- `remove(object)` → `boolean` (`true` if element was found and removed)

---

## <a id="removeAll"></a> `removeAll()`

### What it does
Removes **all elements** from this list that are also contained in a specified collection.

### Syntax
```java
list.removeAll(collection);
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("A"); list.add("B"); list.add("C"); list.add("D");

ArrayList<String> toRemove = new ArrayList<>();
toRemove.add("B"); toRemove.add("D");

list.removeAll(toRemove);
// Result: ["A", "C"]
```

### Returns
`boolean` — `true` if the list changed.

---

## <a id="removeIf"></a> `removeIf()`

### What it does
Removes **all elements** that satisfy a given condition (a `Predicate`). Instead of specifying which elements to remove by value or collection, you write a **rule** — and every element that matches that rule gets removed.

### Syntax
```java
list.removeIf(predicate);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `predicate` | `Predicate<? super E>` | A lambda or method reference that returns `true` for elements to be removed |

### Accepted Data Types for the Predicate
The predicate receives each element of the list one at a time and must return a `boolean`. You write it as a lambda:

| List Type | Lambda Example | What it removes |
|-----------|---------------|-----------------|
| `ArrayList<Integer>` | `n -> n < 0` | All negative numbers |
| `ArrayList<String>` | `s -> s.isEmpty()` | All empty strings |
| `ArrayList<String>` | `s -> s.startsWith("A")` | All strings starting with "A" |
| `ArrayList<Double>` | `d -> d > 100.0` | All doubles above 100 |
| `ArrayList<MyObject>` | `o -> o.isExpired()` | All objects where `isExpired()` is true |

### How to Use
```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(1); nums.add(-2); nums.add(3); nums.add(-4); nums.add(5);

// Remove all negative numbers
nums.removeIf(n -> n < 0);
// Result: [1, 3, 5]

// Remove all strings longer than 3 characters
ArrayList<String> words = new ArrayList<>();
words.add("Hi"); words.add("Hello"); words.add("Hey"); words.add("Howdy");

words.removeIf(s -> s.length() > 3);
// Result: ["Hi", "Hey"]

// Remove all even numbers
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10); numbers.add(11); numbers.add(12); numbers.add(13);

numbers.removeIf(n -> n % 2 == 0);
// Result: [11, 13]
```

### How it Works
`removeIf()` iterates through the list internally and tests each element against the predicate. Elements returning `true` are removed. It is **safe to use** — unlike manually removing inside a for-each loop, it won't throw `ConcurrentModificationException`.

Internally it uses a bitmask approach to mark elements for removal, then compacts the array in one pass — making it more efficient than calling `remove()` one at a time in a loop.

### Returns
`boolean` — `true` if any elements were removed, `false` if nothing changed.

### Throws
- `NullPointerException` if the predicate is `null`

---

## <a id="size"></a> `size()`

### What it does
Returns the **number of elements** currently in the ArrayList.

### Syntax
```java
int count = list.size();
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("One");
list.add("Two");
list.add("Three");

System.out.println(list.size()); // 3

list.remove(0);
System.out.println(list.size()); // 2
```

### How it Works
`size()` returns an internal counter that is updated on every `add()` and `remove()`. It is **O(1)** — instant.

### Returns
`int` — the number of elements.

---

## <a id="isEmpty"></a> `isEmpty()`

### What it does
Returns `true` if the ArrayList has **no elements**.

### Syntax
```java
boolean result = list.isEmpty();
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();

System.out.println(list.isEmpty()); // true

list.add("Hello");
System.out.println(list.isEmpty()); // false

list.clear();
System.out.println(list.isEmpty()); // true
```

### Returns
`boolean` — `true` if size is 0, otherwise `false`.

---

## <a id="contains"></a> `contains()`

### What it does
Checks whether the ArrayList **contains a specific element**. Uses `.equals()` for comparison.

### Syntax
```java
boolean found = list.contains(object);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `object` | `Object` | The element to search for |

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.add("C++");

System.out.println(list.contains("Python")); // true
System.out.println(list.contains("Rust"));   // false
```

### How it Works
Iterates through the list and calls `.equals()` on each element. This is **O(n)** linear time.

### Returns
`boolean` — `true` if found.

---

## <a id="indexOf"></a> `indexOf()`

### What it does
Returns the **index of the first occurrence** of a specified element, or `-1` if not found.

### Syntax
```java
int index = list.indexOf(object);
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("Cat");
list.add("Dog");
list.add("Cat");

System.out.println(list.indexOf("Cat")); // 0 (first occurrence)
System.out.println(list.indexOf("Dog")); // 1
System.out.println(list.indexOf("Fox")); // -1 (not found)
```

### Returns
`int` — index of first match, or `-1`.

---

## <a id="lastIndexOf"></a> `lastIndexOf()`

### What it does
Returns the **index of the last occurrence** of a specified element, or `-1` if not found.

### Syntax
```java
int index = list.lastIndexOf(object);
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("Cat");
list.add("Dog");
list.add("Cat");

System.out.println(list.lastIndexOf("Cat")); // 2 (last occurrence)
System.out.println(list.lastIndexOf("Dog")); // 1
```

### Returns
`int` — index of last match, or `-1`.

---

## <a id="clear"></a> `clear()`

### What it does
**Removes all elements** from the ArrayList, leaving it empty.

### Syntax
```java
list.clear();
```

### How to Use
```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(1); nums.add(2); nums.add(3);

System.out.println(nums.size()); // 3

nums.clear();

System.out.println(nums.size());    // 0
System.out.println(nums.isEmpty()); // true
```

### Returns
`void`

---

## <a id="toArray"></a> `toArray()`

### What it does
Converts the ArrayList into a **regular Java array**.

### Syntax
```java
Object[] arr = list.toArray();
String[] arr = list.toArray(new String[0]); // typed version
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");

// Untyped array
Object[] arr1 = list.toArray();

// Typed array (preferred)
String[] arr2 = list.toArray(new String[0]);
System.out.println(arr2[0]); // "A"
```

### Returns
`Object[]` or typed array `T[]`.

---

## <a id="subList"></a> `subList()`

### What it does
Returns a **view** of a portion of the list between `fromIndex` (inclusive) and `toIndex` (exclusive).

### Syntax
```java
List<E> sub = list.subList(fromIndex, toIndex);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `fromIndex` | `int` | Start index (inclusive) |
| `toIndex` | `int` | End index (exclusive) |

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("A"); list.add("B"); list.add("C"); list.add("D"); list.add("E");

List<String> sub = list.subList(1, 4);
// sub = ["B", "C", "D"]
```

> ⚠️ The returned list is a **view** — changes to it affect the original list.

### Returns
`List<E>` — the sublist view.

### Throws
- `IndexOutOfBoundsException` for invalid range
- `IllegalArgumentException` if `fromIndex > toIndex`

---

## <a id="sort"></a> `sort()`

### What it does
Sorts the ArrayList **in-place** using a given `Comparator`. If `null` is passed, natural ordering is used (requires elements to implement `Comparable`).

### Syntax
```java
list.sort(comparator);
list.sort(null); // natural order
```

### How to Use
```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(5); nums.add(1); nums.add(3); nums.add(2);

// Natural (ascending) order
nums.sort(null);
// Result: [1, 2, 3, 5]

// Descending order
nums.sort((a, b) -> b - a);
// Result: [5, 3, 2, 1]

// Sorting strings alphabetically
ArrayList<String> words = new ArrayList<>();
words.add("Banana"); words.add("Apple"); words.add("Cherry");

words.sort(Comparator.naturalOrder());
// Result: ["Apple", "Banana", "Cherry"]
```

### Returns
`void`

---

## <a id="iterator"></a> `iterator()`

### What it does
Returns an **Iterator** object to traverse the list element by element. Useful when you need to safely remove elements while iterating.

### Syntax
```java
Iterator<E> it = list.iterator();
```

### How to Use
```java
import java.util.Iterator;

ArrayList<String> list = new ArrayList<>();
list.add("Alpha"); list.add("Beta"); list.add("Gamma");

Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    System.out.println(item);

    if (item.equals("Beta")) {
        it.remove(); // safe removal during iteration
    }
}
// Result list: ["Alpha", "Gamma"]
```

> ⚠️ Never use `list.remove()` directly inside a regular `for-each` loop — it causes `ConcurrentModificationException`. Use `iterator.remove()` instead.

### Returns
`Iterator<E>`

---

## <a id="forEach"></a> `forEach()`

### What it does
Performs an action on **each element** in the list using a lambda expression or method reference.

### Syntax
```java
list.forEach(action);
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>();
list.add("Hello"); list.add("World"); list.add("Java");

// Using lambda
list.forEach(item -> System.out.println(item));

// Using method reference
list.forEach(System.out::println);

// Modify elements (use external structure)
ArrayList<String> upper = new ArrayList<>();
list.forEach(item -> upper.add(item.toUpperCase()));
```

### Returns
`void`

---

## <a id="clone"></a> `clone()`

### What it does
Creates a **shallow copy** of the ArrayList — the list structure is copied, but the objects inside are not duplicated (they share references).

### Syntax
```java
ArrayList<E> copy = (ArrayList<E>) list.clone();
```

### How to Use
```java
ArrayList<String> original = new ArrayList<>();
original.add("X"); original.add("Y");

ArrayList<String> copy = (ArrayList<String>) original.clone();

copy.add("Z");
System.out.println(original); // [X, Y]     — unaffected
System.out.println(copy);     // [X, Y, Z]
```

> ⚠️ **Shallow copy** means: if elements are mutable objects (like custom classes), changing the object inside `copy` also affects `original`.

### Returns
`Object` (cast to `ArrayList<E>`)

---

## <a id="trimToSize"></a> `trimToSize()`

### What it does
Trims the **internal capacity** of the ArrayList to its current size. Useful for memory optimization when you're done adding elements.

### Syntax
```java
list.trimToSize();
```

### How to Use
```java
ArrayList<String> list = new ArrayList<>(100); // reserve capacity for 100
list.add("A");
list.add("B");
// Internal array has space for 100, but only 2 used

list.trimToSize();
// Internal array is now trimmed to exactly 2
```

### Returns
`void`

---

## <a id="ensureCapacity"></a> `ensureCapacity()`

### What it does
**Pre-allocates** internal capacity so that ArrayList doesn't need to resize repeatedly when adding many elements. A performance optimization.

### Syntax
```java
list.ensureCapacity(minCapacity);
```

### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| `minCapacity` | `int` | The desired minimum capacity |

### How to Use
```java
ArrayList<Integer> list = new ArrayList<>();
list.ensureCapacity(10_000); // pre-allocate for 10,000 elements

for (int i = 0; i < 10_000; i++) {
    list.add(i); // no internal resizing happens
}
```

### Returns
`void`

---

## 🗂️ Quick Reference Summary

| Method | Description | Returns |
|--------|-------------|---------|
| `add(e)` | Append element to end | `boolean` |
| `add(i, e)` | Insert element at index | `void` |
| `addAll(c)` | Append all from collection | `boolean` |
| `get(i)` | Get element at index | `E` |
| `set(i, e)` | Replace element at index | `E` (old value) |
| `remove(i)` | Remove by index | `E` (removed) |
| `remove(o)` | Remove by value | `boolean` |
| `removeAll(c)` | Remove all in collection | `boolean` |
| `removeIf(p)` | Remove all matching a condition | `boolean` |
| `size()` | Number of elements | `int` |
| `isEmpty()` | Check if empty | `boolean` |
| `contains(o)` | Check if element exists | `boolean` |
| `indexOf(o)` | First index of element | `int` |
| `lastIndexOf(o)` | Last index of element | `int` |
| `clear()` | Remove all elements | `void` |
| `toArray()` | Convert to array | `Object[]` |
| `subList(f, t)` | Get a portion of the list | `List<E>` |
| `sort(c)` | Sort in-place | `void` |
| `iterator()` | Get iterator | `Iterator<E>` |
| `forEach(a)` | Run action on each element | `void` |
| `clone()` | Shallow copy | `Object` |
| `trimToSize()` | Trim capacity to size | `void` |
| `ensureCapacity(n)` | Pre-allocate capacity | `void` |