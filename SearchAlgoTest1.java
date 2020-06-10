Median of two sorted arrays of same size:-

int getMedian(int[] a, int[] b, int startA, int endA, int startB, int endB)
{
   // if arrays are having only 2 elements
   if(endA-startA == 1){
     return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB]))/2;
   }

   int m1 = findMedian(a, n);
   int m2 = findMedian(b, n);

   if(m1 == m2)
      return m1;
   else if (m1 < m2)
      return getMedian(a, b, midA, endA, startB, midB);
  else
      return getMedian(a, b, startA, midA, startB, midB);
}

-------------------------------------------------------------------------------------------------------------------
Binary Search is preferred over Ternary Search :-

Binary Search :- T(n) = T(n/2) + 2, T(1) = 1
Ternary Search:- T(n) = T(n/4) + 4, T(1) = 1

Time Complexity for Binary search = 2clog2n + O(1)
Time Complexity for Ternary search = 4clog3n + O(1)
Since the value of (2 / Log2(3)) is more than one, Ternary Search does more comparisons than Binary Search in worst case.
-------------------------------------------------------------------------------------------------------------------
Count the number of occurences of a key in a sorted array:-
1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
3) Return (j – i + 1);

int getCount(int []a, int n , int x)
{
  int i = getFirstIndex(a, 0, n-1 ,x);
  if(i == -1)
    return -1;

  int j = getLastIndex(a, 0, n-1, x);

  return j-i+1;
}

int getFirstIndex(int []a, int low , int high, int x)
{
  if(low <= high){
    int mid = (low+high)/2;
    if(a[mid] == x && (mid == 0 || x > a[mid-1]))
        return mid;
    else if (a[mid] < x)
        return getFirstIndex(a, mid+1, high, x);
    else
        return getFirstIndex(a, low, mid-1, x);
  }
  return -1;
}

int getLastIndex(int[]a, int low, int high, int x)
{
  if(low <= high) {
    int mid = (low+ high)/2;
    if(a[mid] == x && (mid == n-1 || a[mid+1] > x))
        return mid;
    else if (a[mid] < x)
        return getLastIndex(a, mid+1, high, x);
    else
        return getlastIndex(a, low, mid-1, x);
  }
  return -1;
}
-------------------------------------------------------------------------------------------------------------------
Find the maximum element in an array which is first increasing and then decreasing:-

Approach:-
1. if mid is greater from its left and right element , then mid is maximum.
2. if mid is greater from its right but smaller from its left then max will be on left sub-array.
3. if mid is smaller than from its right but greater then its left then max will be on right sub-array.

int getMaxElement(int[]a, int low, int high) {
  // Base cases
  if(low == high)
      return a[low];
  if(low+1 == high)
    return Math.max(a[low], a[high]);

  int mid = (low+ high)/2;
  if(a[mid] > a[mid+1] && a[mid] > a[mid-1])
      return a[mid];
  else if (a[mid] > a[mid+1] && a[mid] < a[mid-1])
      return getMaxElement(a, 0, mid-1);
  else
      return getMaxElement(a, mid+1 , high);
}

-------------------------------------------------------------------------------------------------------------------
Median of two sorted arrays of different size:-
Array A is smaller than Array B.

Suppose there are two arrays and size of both the arrays is greater than 2.
Find the middle element of the first array and middle element of the second array and if the middle element of the first array
is less than the second array then it can be said that all elements of the first half of first array will be in the first half
of the output (merged array). So, reduce the search space by ignoring the first half of the first array and the second half of
the larger array. else ignore the second half of the first array and first half of second array.

Some base cases needs to be handled when arrays are either size of 0 or 1 or 2.

-------------------------------------------------------------------------------------------------------------------
Find position of an element in a sorted array of infinite numbers:-

int getPosition(int []a, int key) {
  int low = 0, high = 1;
  int val = a[0];
  while(val < key) {
    low = high;
    if(2*high < a.length-1)
      high = 2* high;
    else
        high = a.length -1;

    val = a[high];
  }
  return Arrays.binarySearch(a, low, high, key);
}

-------------------------------------------------------------------------------------------------------------------
Minimum time required to produce m items:-

Input : arr[] = {1, 2, 3}, m = 11
Output : 6
In 6 sec, machine 1 produces 6 items, machine 2 produces 3 items,and machine 3 produces 2 items. So to produce 11 items minimum
6 sec are required.

The idea is to use Binary Search. Maximum possible time required to produce m items will be maximum time in the array, amax,
multiplied by m i.e amax * m. So, use binary search between 1 to amax * m and find the minimum time which produce m items.


// return the no. of items can be produced in x secs.

int getItems(int []a, int n, int x) {
  int ans =0;
  for(int i=0; i<n; i++) {
    ans += x/a[i];
  }
  return ans;
}

int getTotalTime(int[]a, int n , int m, int high) {  // high = max element in array * m .
  int low = 1;
  while(low < high) {
    int mid = (low + high)/2;
    int itemCount = getItems(a, n, mid);
    if(itemCount < m)
      low = mid;
    else
      high = mid;
  }

  return high;
}

-------------------------------------------------------------------------------------------------------------------
Kth smallest element in a row-wise and column-wise sorted matrix:-

Approach :-

1. Create a min heap from the elements of 1st row of matrix.
2. Heap entry will contain an object comprising (element, rowNo, colNo).
3. Run a loop for k times to get the kth smallest element:-
  3.1 Extract the min element (i.e. root of min heap) and find the rowNo and colNo of extracted elemented.
  3.2 Replace root with the next element from the same column and min-heapify the root.
4. Return the root as answer.
