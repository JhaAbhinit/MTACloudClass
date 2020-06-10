This File is having the Sorting Problem Questions.

Ceiling Index Search of a number x in sorted array :-
int ceilIndexSearch(int[]a, int low, int up, int x)
{
  if(x<=a[low])
    return low

  if(x>a[up])
      return -1;

  int mid=(low+up)/2;
  if(a[mid]==x)
        return mid;
  /* If x is greater than arr[mid], then  either arr[mid + 1] is ceiling of x or  ceiling lies in arr[mid+1...high] */
  else if(x>arr[mid])
  {
      if(mid + 1 <= high && x <= arr[mid+1])
        return mid + 1;
      else
        return ceilSearch(arr, mid+1, high, x);
  }
  /* If x is smaller than arr[mid],  then either arr[mid] is ceiling of x  or ceiling lies in arr[mid-1...high] */
  else
  {
      if(mid - 1 >= low && x > arr[mid-1])
          return mid;
      else
          return ceilSearch(arr, low, mid - 1, x);
  }
}

---------------------------------------------------------------------------------------------------------------
int mid = low + ((high - low) / 2);
Probably faster, and arguably as clear is (works only in Java):
int mid = (low + high) >>> 1;

In C and C++ (where you don’t have the >>> operator), you can do this:

   mid = ((unsigned int)low + (unsigned int)high)) >> 1

---------------------------------------------------------------------------------------------------------------
Find Triplets whose sum is equal to zero :-

Method 1:-
1. Sort the array
2. Run loop from i=0 to n-2.
     Initialize two index variables l=i+1 and r=n-1
4. while (l < r)
     Check sum of arr[i], arr[l], arr[r] is
     zero or not if sum is zero then print the
     triplet and do l++ and r--.
5. If sum is less than zero then l++
6. If sum is greater than zero then r--
7. If not exist in array then print not found.

Method 2:- Using HashSet
void findTriplets(int arr[], int n)
{
    boolean found = false;
    for (int i = 0; i < n - 1; i++)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int j = i + 1; j < n; j++)
        {
           int x = -(arr[i] + arr[j]);
           if (s.contains(x))
           {
              System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
              found = true;
          }
          else
          {
              s.add(arr[j]);
          }
       }
    }
   if (found == false)
   {
        System.out.printf(" No Triplet Found\n");
   }
}

---------------------------------------------------------------------------------------------------------------
Binary Search for Rational Numbers without using floating point arithmetic:-
class Rational{
  int p,q;
  Rational(int p, int q)
  {
    this.p=p;
    this.q=q;
  }
}

int compareRational(Rational a, Rational b)
{
  if(a.p*b.q==a.q*b.p)
    return 0;
  else if(a.p*b.q>a.q*b.p)
    return 1;
  return -1;

}

int binarySearchForRational(Rational [] a, int low, int up, Rational key)
{
  if(low<=up)
  {
    int mid=low+up/2;
    if(compareRational(a[mid],key)==0)
      return mid;

    if(compareRational(a[mid],key)>0)
      return binarySearchForRational(a, low, mid-1,key);

    return binarySearchForRational(a, mid+1,up,key);
  }
  return -1;
}

---------------------------------------------------------------------------------------------------------------
Given a team of N players. How many minimum games are required to find second best player?
Using tournament Tree :- Tournament tree is a form of min (max) heap which is a complete binary tree. Every external node represents
a player and internal node represents winner.
It is obvious that to select the best player among N players, (N – 1) players to be eliminated, i.e. we need minimum of (N – 1) games.
The information explored during best player selection can be used to minimize the number of comparisons in tracing the next best player.
For example, we can pick second best player in (N + log2N – 2) comparisons.For second best player we need to trace the candidates
participated with final winner.

---------------------------------------------------------------------------------------------------------------
Check if reversing a sub array make the array sorted:-

Method 1:- The idea is to compare the given array with the sorted array. Make a copy of the given array and sort it. Now, find the first index
and last index which do not match with sorted array. If no such indices are found, print “Yes”. Else check if the elements between the
indices are in decreasing order.
O(nlogn)

Method 2:-
Observe, answer will be “Yes” when the array is sorted or when the array consist of three parts. First part is increasing subarray,
then decreasing subarray and then again increasing subarray. So, we need to check that array contain increasing elements then some
decreasing elements and then increasing elements. In all other case, answer will be “No”.

---------------------------------------------------------------------------------------------------------------

https://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
https://prismoskills.appspot.com/lessons/System_Design_and_Big_Data/Chapter_05_-_K_most_frequent_words_in_a_huge_file.jsp
