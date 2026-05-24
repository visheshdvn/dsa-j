# Dynamic Programming

## What is Dynamic Programming?

**Dynamic Programming (DP)** is an optimization technique used to solve problems that have **overlapping subproblems** and **optimal substructure**. It works by breaking down a problem into simpler subproblems, solving each subproblem only once, and storing the results to avoid redundant calculations.

### Core Principles

1. **Overlapping Subproblems**: The problem can be broken down into subproblems which are reused several times.
2. **Optimal Substructure**: An optimal solution can be constructed from optimal solutions of its subproblems.

### When to Use DP

- Problems with recursive nature where the same subproblems are solved repeatedly
- Optimization problems (finding minimum/maximum)
- Counting problems (number of ways to do something)
- Examples: Fibonacci, Longest Common Subsequence, 0/1 Knapsack, Coin Change, etc.

---

## Memoization vs Tabulation

Dynamic Programming can be implemented using two main approaches: **Memoization (Top-Down)** and **Tabulation (Bottom-Up)**. Here's the detailed comparison:

### Memoization (Top-Down Approach)

**Definition**: Memoization is a technique where we solve the problem recursively and store the results of subproblems in a data structure (usually a HashMap or array) to avoid recalculating them.

#### Characteristics

| Aspect | Details |
|--------|---------|
| **Approach** | Recursive + Caching |
| **Direction** | Top-Down (start from the problem, break it down) |
| **Implementation** | Function calls with base cases and memoization storage |
| **Space Complexity** | May use extra space for recursion call stack |
| **When to solve subproblems** | On-demand (as needed during recursion) |

#### Pseudo Code
```
function solve(n, memo):
    if n is in memo:
        return memo[n]
    
    if base_case:
        result = base_value
    else:
        result = solve(n-1) + solve(n-2)  // or some recursive relation
    
    memo[n] = result
    return result
```

#### Example: Fibonacci with Memoization
```
memo = {}

function fib(n):
    if n in memo:
        return memo[n]
    
    if n <= 1:
        return n
    
    result = fib(n-1) + fib(n-2)
    memo[n] = result
    return result
```

#### Advantages
- ✅ Intuitive and easy to understand (natural recursive form)
- ✅ Only computes subproblems that are needed
- ✅ Easy to implement from a brute-force recursive solution
- ✅ Uses space only for necessary subproblems

#### Disadvantages
- ❌ Recursion overhead (function calls on stack)
- ❌ Risk of stack overflow for very deep recursion
- ❌ Slightly more cache-unfriendly than iterative approaches

---

### Tabulation (Bottom-Up Approach)

**Definition**: Tabulation is a technique where we build a table (usually an array) and fill it iteratively from the bottom up, starting from the base cases to reach the final answer.

#### Characteristics

| Aspect | Details |
|--------|---------|
| **Approach** | Iterative + Array Building |
| **Direction** | Bottom-Up (start from base cases, build up) |
| **Implementation** | Loop-based, filling table systematically |
| **Space Complexity** | Clear space allocation for the table |
| **When to solve subproblems** | All subproblems in order (pre-computed) |

#### Pseudo Code
```
function solve(n):
    table = array of size n+1
    
    // Initialize base cases
    table[0] = base_value_0
    table[1] = base_value_1
    
    // Fill table iteratively
    for i from 2 to n:
        table[i] = table[i-1] + table[i-2]  // or some recurrence relation
    
    return table[n]
```

#### Example: Fibonacci with Tabulation
```
function fib(n):
    if n <= 1:
        return n
    
    table = array of size n+1
    table[0] = 0
    table[1] = 1
    
    for i from 2 to n:
        table[i] = table[i-1] + table[i-2]
    
    return table[n]
```

#### Advantages
- ✅ No recursion overhead (iterative approach)
- ✅ No risk of stack overflow
- ✅ Better cache locality (sequential memory access)
- ✅ Generally faster due to less function call overhead

#### Disadvantages
- ❌ May compute unnecessary subproblems (all are computed)
- ❌ Requires more memory if not all subproblems are needed
- ❌ Harder to implement without understanding the pattern first

---

## Side-by-Side Comparison

| Feature | Memoization | Tabulation |
|---------|------------|-----------|
| **Approach** | Recursive | Iterative |
| **Execution** | Top-Down | Bottom-Up |
| **Storage** | HashMap/Dictionary | Array/Matrix |
| **Subproblem Solving** | As needed (on-demand) | All upfront |
| **Stack Space** | High (recursion stack) | Low (or can be optimized) |
| **Implementation Ease** | Easier (recursive form) | Requires understanding pattern |
| **Performance** | Good | Generally better |
| **Cache Efficiency** | Lower | Higher |
| **Stack Overflow Risk** | Yes | No |

---

## Which One to Use?

| Use Memoization When | Use Tabulation When |
|-------------------|-----------------|
| Problem has unclear or complex state transitions | Problem has clear, well-defined recurrence relation |
| Only subset of subproblems need to be solved | All subproblems need to be solved |
| Recursive approach is more natural | Iterative approach is clearer |
| Problem has deep recursion but sparse states | Problem has deep recursion and you need performance |

---

## Key Takeaways

1. **Memoization** is a top-down approach that caches results as we recursively solve subproblems
2. **Tabulation** is a bottom-up approach that iteratively builds a table from base cases
3. Both achieve **O(n) time complexity** for problems like Fibonacci (vs O(2^n) for naive recursion)
4. Choose memoization for **ease of implementation** and tabulation for **better performance**
5. The choice doesn't affect time complexity asymptotically, but affects constant factors and stack usage
