# CrackingInterview

Solutions of tasks from "Cracking the coding interview" book and some basic algorithms

# Build and run:

All examples(except CountItems,Pipeline) are ran in unit tests.
```yaml
 mvn clean test
```

For non-unit test example set main class in pom.xml before build

# Problems

## Strings

- isUnique - Determine if all the characters in string are unique
- checkPermutation - Check if str2 is permutation of str1
- urlify - Replace spaces with %20 except spaces at the end replace within char array
- palindromePermutation - Check if any of words permutations can be a palindrome
- oneAway - Check of oneString can be got from another by just one edit
- stringCompressor - Compress repeated chars in string(e.g: aabcccccaaa -> a2b1c5a3)
- reverseString - In place string reverse
- isStringPalindrome - Is string a palindrome
- longestCommonPrefix - Find the longest common prefix string amongst an array of strings.
All given inputs are in lowercase letters a-z.
- validParentheses - Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
- strStr - Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
- string len - find length of string in format a5[ab] where 5 is number of repeats of ab
- filter strings - filter collection of strings (remove blank,trim leading/trailing white spaces,
convert to upperCase,sort by len(ASC) and return distinct)
- card war - check /screens/cardwar.png for description 
- string chain - check /screens/string.chains for description
- length of last word - Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
- validPassword - given a string verify if it is a valid password. Valid password must have length between 7 and 30,
 should have 1 capital letter, one punctuation character and should not contain word 'password'
- isAnagram - check if two given strings are anagrams of each other
- printTokens - print tokens from string (token is a sequence of chars not containing spaces and following chars: !,._'@)
- validUsername - given a string verify if it is a valid username. Valid username must have length between 7 and 30,
  should contain alpanumeric characters and underscores(_). First character must be alphabetical character
- staircase - print staircase of # symbols, if no # then print space.
- timeFormatter - convert time of format 07:05:45pm to 19:05:45
- countCamelCase - count number words in the line written in camel case
- minNumber - count number of chars to be added to make a password strong. Strong password has len of 6, one small,one capital letter and one special char.
- caesarCypher - Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
- marsExploration - Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string determine how many letters of the SOS message have been changed by radiation.
- isHackerrank - check if incoming string contains string 'hackerrank' in exactly the same char sequence
- isPangram - check if the incoming string has all letters of english alphabet
- superReducedString - remove from string all pairs of letters
- alternatingChars - given a string containing characters A and B only,change it into a string such that there are no matching adjacent characters and find the minimum number of required deletions.
- twoStrings - given two strings check if they have a common substring
- beautifulBinaryString - given a binary string make it beautiful by removing "010" and return minimum number of steps required for it.

## Ints

- reverse integer - Given a 32-bit signed integer, reverse digits of an integer.
- isIntegerPalindrome - Is integer a palindrome
- romanToInt - Transform roman number to decimal integer
- diskSegment - check /screens/disk_space_segments.png for description
- maxOrders - check /sreens/max_orders.png for description
- multPersistence - count multiplexing persistence of a number
- sumOfDivisors - sum of divisors of input num

## Arrays
- sum - sum elements of array via recursion
- sumList - sum elements iteratively
- veryBigSum - sum of list of longs,where first elem is integer to be ignored
- twoSum - Given an array of integers, return indices of the two numbers such that they add up to a specific target.
- len - count number of elements of array via recursion
- rotateMatrix - Rotate matrix by 90 degrees clockwise
- zeroMatrix - If element [i][j] of matrix is zero - entire row and column must be zero
If element [i][j] of matrix is zero - entire row and column must be zero
- calcUniqueLen - calc length of array(L) with no duplicates and return no-duplicates from 0 to L
- cleanDuplicates - return array without duplications
- removeValue - calc length of array(L) with no value(V) and return array with no value from 0 to L
- searchIndex - find elem index or position to insert
- fairIndex - check /screens/fair_index.png for description 
- duplicatesStat - check /screens/duplicates_stat.png for description
- largestSubGrid - check /screens/largerst_sub_grid1.png and largerst_sub_grid2.png for description
- plusOne - Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
- singleNumber  - find a unique number in array 
- tv time -  given a room with tv. the tv is on only when there is at least one person watching
              tv slots are presented as below.
                [(1,4),(2,6)] - > 5
                [(4,6)(1,2)(1,2)] -> 3
                [(1,4)(6,8)(2,4)(7,9)(10,15)] -> 11
- compareTriplets - given two lists of scores return a list of comparision. Scoring: if a[i]>b[i] then a get +1, if equal no point awarded
- diagonalDifference - calculate difference of sums of diagonals in matrix 
- plusMinus - print ration of positive,negative and zero integers in the list
- getFibonacci - get list of fibonacci numbers up to a limit       
- minimaxSum - find min and max sums of elements of list excluding one of the elements
- birthdayCandles - You are in charge of the cake for a child's birthday. 
You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.
- minArrayDistance - calculate minimum distance between two sorted int arrays

##  List
- addToEnd - append a new node to the end of list
- addToMiddle - append a new node to the middle of list
- findNode - find node by value
- deleteVal - delete element by value
- removeDuplicates - Remove duplicates from list without using any tmp buffer
- deleteDuplicates - remove duplicates from linked list
- kToLast   - Return  k elements from last element in list
- sumLists - Each list is a number : list 7-1-6 is number 716. If flag isReverse is true list represents 617. 
We need to return a list which represents sum of two lists (existing and the one we sum with)
- isPalindrome - Check if list is a palindrome
- hasIntersection - Check if two list have an intersection.Intersection is by ref, not by val which means one node in two lists 
- detectLoop - Check if list has loops and return it. Loop is the same node(not val) added to the list twice.
- mergeLists - merge two sorted linked lists of integers
- reverseList - reverse linked list

## Stack
- CustomStack - custom stack implementation
- MinStack - wrapper class for CustomStack<Integer> counting minVal and doingSort
- StackSet - wrapper class for a set of stacks. Each stack has a max capacity and when we run over it we add a new stack.
Methods push,pop and peek work as in simple stack
- MultiStack - Splits an int array to defined number of stacks. 

## Queue
- CustomQueue - custom queue implementation
- TwoStackQueue - queue using two stacks
- AnimalQueue - priority queue for two types of animals which can be adopted.

Check comments in classes

## Graph
- bfs - get list of nodes using Bread First Search
- dfs - get list of nodes using Depth First Search
- hasRouteBFS,hasRouteDFS - Check if a graph has route between two nodes.
- buildOrder - By given list of dependencies build a list of build order
- findCommonAncestor - Find first common ancestor of two given listNodes without storing additional listNodes in ds.
- distanceToSource - find distance to source in weighted graph
- Dijkstra algorithm for shortest path. Best,Avg,Worst: O((V+E)*log V)


## Tree
- inOrderTraversal - Visit node in order: left,current,right
- preOrderTraversal - Visit node in order: current,left,right
- postOrderTraversal - Visit node in order: left,right,current
- insert - Insert a value into the tree
- delete - Delete a node with provided value
- search - Search for a node by value starting from selected node
- getMostLeftVal - find value of the most left tree leaf.
- getMostRightVal - find value of the most right tree leaf.
- minTree - Build a tree with min height from sorted array
- listOfDepth - Get list of lists of listNodes on every depth of the tree
- isBalanced - Check if bin tree is balanced(e.g heights of subtrees of any node don't differ more than by one)
- isBST - Check if binary tree is BST
- treeHeight - find a height of a tree
- bstSequences - Find all possible arrays of listNodes in BST with distinct elems


## Bit operations

- insert - Insert 32-bit number m into number n from position j to position i. M fully fits between positions 
- bin to str - Given real number between 0 and 1 convert it to bin and save as str.Max 32 chars.
- conversion - Given two numbers determine how many bits are needed to convert one to another
- pairwise swap - Swap odd and even bits in 32-bit int
- flip bit to win - Find the longest sequence of 1 ny flipping only one 0  to 1
- next number - Find the next biggest and smallest numbers with the same number of 1 bits
- draw line - Draw a line on the screen of width divisible by 8
- power of two - Check if a given number is power of 2
- hamming weight - return the number of '1' bits in unsigned int.
- add binary - sum two binary nums
- getSum - sum two ints without using +- operators
- unique integer - get a unique integer in the given list
- max xor - get a maximum xor value in given range
- flip bits - get a number with converted bits

## Greedy Tasks

- set coverage - Given a list of states and radio stations you want to reach listeners in provided states. You have to decide what
  stations to play on to reach all those listeners. 
## Dynamic programming

- count ways - child runs staircase with n steps with hops of 1 ,2 or 3 steps. How many possible ways can he run?
- magic index - find an element in a sorted int array A where A[i] = i
- power set - return all subsets of a set
- recursive mult - write a func to mult two ints without *
- hanoi towers - popular hanoi towers task (one disk moved at a time,disk slid from top of one tower to another,disk 
can"t be on top of a smaller one,disks sorted in ascending order)
- paint fill - fill the area arount selected point on the screen with color(contains bug)
- max permutations(no dups) - find max number of char permutaions in a string of unique chars
- max permutations(dups) - find max number of unique char permutaions in a string with dup chars
- parentheses - print all valid combinations of n pairs of parentheses
- coins - given coins of 25,10,5 and 1 cents calc a number of ways to represent n cents
- stack of boxes - given stack of n boxes with dimenstions w1,h1,d1. The boxes can't be rotated. 
the largest boxes are at the bottom of the stack. find the height of max possible stack as sum of heights of all boxes in it.
- boolean equation - given bool expression with 0,1,or,xor,and + desired result , 
find number of ways to parentesizing expression that it will evaluate result 
- count and say - The count-and-say sequence is the sequence of integers with the first five terms as following:
                  
                  1.     1
                  2.     11
                  3.     21
                  4.     1211
                  5.     111221
                  1 is read off as "one 1" or 11.
                  11 is read off as "two 1s" or 21.
                  21 is read off as "one 2, then one 1" or 1211.
                  
                  Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
- rod cut - get max revenue of rod-cutting (both memorized and bottom up solution).
- matrix chain multiplication order - Given a sequence of matrices, find the most efficient way to multiply these matrices together. Sequence of matrices is represented as array p  such that the ith matrix Ai is of dimension p[i-1] x p[i].
For example  p[] = {40, 20, 30, 10, 30} represents matrices 40x20 20x30 30x10 and 10x30.
- longest common subsequence length - given two strings give a length of their longest common subsequence


## Sorting tasks

These tasks use algorithms from Sorting section below

- sortedMerge - given two sorted arrays A and B merge them in sorted order.
- groupAnagrams - sort an array of strings so that all annagrams are next to each other
- rotated search - find an element in sorted in inc order array which has been rotated
- sorted search - given a ds called listy(list without size method) with positive sorted ints 
find and index where element occurs
- sparse search - given a sorted array of strings interpressed with empty strs write a method to find a location of string
- find dups - in array with numbers from 1 to N (N <=32000) find duplicate entries having 4kb of memory
- sortedMatrixSearch - given matrix m x n with sorted in asc order rows and cols find an element
- rank from stream - reading stream of ints it's needed to check a rank of number x(the number of vals <= x)
- peaks and valleys - sort an array in alternating seq of peaks(elem>=adjacent elems) and valleys(elem<=adjacent)


# Algorithms

## Sorting
- Bubble Sort. Best,Avg: O(n^2)
- Selection Sort. Best,Avg: O(n^2)
- - Counting Sort. Best,Avg,Worst: O(n+k)
- Radix Sort. Best,Avg,Worst: O(n+k)
- Bucket Sort. Best:O(n+k),Avg:O(n),Worst:O(n^2)
- Insertion sort. Best,Avg: O(n), Worst: O(n^2) 
- Heap sort. Best,Avg,Worst: O(nlog n) 
- Quick sort. Best,Avg: O(n log n), Worst: O(n^2) 
- Merge sort. Best,Avg,Worst: O(n log n) 

## Search
- Sequential search. Best: O(1), Avg,Worst: O(n)
- Binary search. Best: O(1), Avg,Worst: O(log n)
- Hash search. Best,Avg: O(1), Worst: O(n)


## Other 
- countItems - Fetch json with data in format {"data":"key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47"}.Where item is key=IAfpK, age=58. 
Calculate number of items with age >=50
  
  
# Data Structures

- Node - linked list node
- Binary Tree Node with visiting and traversal
- Graph Node with dfs and bfs
- Queue 
- Queue with two stacks
- Custom stack
- Min Stack - stack with basic functionality
- Set of Stacks - set consisting of several stacks
