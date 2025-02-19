package org.example.dsa;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ArrayQuestions {


    public static void main(String[] args) {
        //group anagrams (medium)
        /*String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));*/

        //Top K frequent elements in array;
        /*int[] nums1 = new int[]{1,2,2,3,3,3};
        int[] nums2 = new int[]{7,7};
        System.out.println(Arrays.toString(topKFrequentOptimal(nums2, 1)));*/

        //Product of elements in array without self
        /*int[] nums1 = new int[]{2, 4, 3};
        int[] nums2 = new int[]{1, 2, 4, 6};
        int[] nums3 = new int[]{-1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums3)));*/

        //Find longest sequence
        /*int[] nums1 = new int[]{2, 20, 4, 0, 3, 4, 5};
        int[] nums2 = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -2, -1, 6};
        System.out.println(longestConsecutive(nums2));*/

        //Two Sum constant space ascending array - Medium level
        /*int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{2, 6, 8, 19, 21, 22, 26, 29, 30, 145, 257, 800, 1000};
        int[] nums3 = new int[]{-8, -6, -5,-3,-2,-1,0,2,4,6,8};
        int[] nums4 = new int[]{-1,0};
        System.out.println(Arrays.toString(twoSumConstantSpace(nums3, -1)));*/

        //Bubble sort
        /*int[] nums1 = new int[]{4, 1, 3, 9, 7};
        bubbleSort(nums1, 5);
        System.out.println(Arrays.toString(nums1));*/

        //Second largest and second smallest
        /*int[] nums2 = new int[]{2, 6, 8, 19, 21, 22, 26, 29, 30, 145, 257, 800, 1000};
        int[] nums3 = new int[]{-8, -6, -5,-3,-2,-1,0,2,4,6,8};
        sndLargeSmall(nums2);*/

        //Rotate array by k places
        /*int[] nums1 = new int[]{-1};
        int k = 2;
        rotate(nums1, k);
        System.out.println(Arrays.toString(nums1));*/

        //Find union for sorted arrays
        /*int[] a = new int[]{2, 2, 3, 4, 5};
        int[] b = new int[]{1, 1, 2, 3, 4};*/

        /*int[] a1 = new int[]{-6, -6, -5, -4, -3, 0};
        int[] b1 = new int[]{-5, 2, 2};

        System.out.println(findUnion(a1, b1));*/

        //int[] a = {2, 3, 5, 1, 9};
        //int[] a = {0, 10, 5, 5, 11, 2, 12, 5, 10, 6, 4, 3, 2, 0, 20, 5, 1};
        /*int[] a = {-1, 1, 1};
        long k = 1;
        int len = getLongestSubarrayOptimal(a, k);
        System.out.println("The length of the longest subarray is: " + len);*/

        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = new int[]{1};
        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = new int[]{2, 30, 44, -20, -7, 2, 0};
        //System.out.println(myKadaneAlgo(nums));

        /*int[] nums = new int[]{2, 3, 1, 0, 6, 5, 3};    // Common ex
        //int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};  // Voting ex
        System.out.println(majorityElement(nums));*/

        //Next permutation (lexicographical order of array)
        /*int[] nums = new int[]{4, 3, 1, 2, 5};
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{4, 3, 2, 1};
        int[] nums4 = new int[]{2, 3, 1, 3, 3};
        lexiCo(nums4);
        System.out.println(Arrays.toString(nums4));*/

        /*int[] num = new int[] {1, 1, 1};
        int[] num1 = new int[] {1, 2, 3};
        int k = 3;
        System.out.println(countSubArraySumEqualsK(num1, k));*/

        /*int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setMatrixZeros(matrix);
        printMatrix(matrix);*/

        /*int[] nums = new int[]{2, 3, 2, 2, 4, 5, 6, 7};
        System.out.println(majorityElementNThird(nums));*/

        int[] nums = new int[]{1, 2, 8, 10, 11, 12, 19};
        //System.out.println(findFloor(nums, 0));
        //System.out.println(Arrays.toString(getFloorAndCiel(nums, 7)));

        int[] nums2 = new int[]{1, 1, 1, 2, 5, 5, 7, 7, 8, 9, 9, 9};
        //System.out.println(Arrays.toString(removeDuplicates(nums2)));

        int[] nums3 = new int[]{1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        System.out.println(Arrays.toString(moveZerosToLast(nums3)));

    }

    public static int[] moveZerosToLast(int[] nums) {
        int x = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[x] = nums[i];
                x++;
            }
        }

        while(x < nums.length) {
            nums[x++] = 0;
        }

        return nums;
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();

        Map<String , List<String>> anagrams = new HashMap<>();

        for(String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if(anagrams.containsKey(key)) {
                anagrams.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                anagrams.put(key, list);
            }


            //java 8 map function
            //anagrams.computeIfAbsent(key, k ->  new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for(Integer num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> kElements = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequency.entrySet());

        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        int[] result = new int[k];
        for(Map.Entry<Integer, Integer> entry : list) {
            if (k == 0) {
                break;
            }
            result[--k] = entry.getKey();
        }

        return result;
    }

    public static int[] topKFrequentOptimal(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int[] result = new int[k];

        for(Integer num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> Integer.compare(b.getValue(), a.getValue());
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparator);

        for (Map.Entry<Integer, Integer> entrySet : frequency.entrySet()) {
            queue.offer(entrySet);
        }

        for(int i = 0; i < k; i++) {
            if(!queue.isEmpty()) {
                result[i] = queue.poll().getKey();
            }
        }

        return result;
    }

    public static int[] productOfArrayExceptSelf(int[] nums) {
        int[] result =  new int[nums.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        int suffix = 1;
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length) {
            result[left] *= prefix;
            prefix *= nums[left];
            left++;

            result[right] *= suffix;
            suffix *= nums[right];
            right--;
        }

        return result;
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int counter = 1;
        int longestSeq = 1;
        for(int i = 1; i < nums.length; i++) {
            int val = nums[i] - nums[i-1];

            if(val == 1) {
                counter++;
            } else if(val != 0) {
                longestSeq = Math.max(longestSeq, counter);
                counter = 1;
            }
        }

        return Math.max(longestSeq, counter);
    }

    public static int[] twoSumConstantSpace(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l < r) {
            int val =  target - nums[l];

            for(; nums[r] >= val; r--) {
                if(nums[r] == val) {
                    return new int[]{l+1, r+1};
                }
            }

            l++;
        }

        return new int[]{l+1, r+1};
    }

    public static void bubbleSort(int[] arr, int n)
    {
        boolean swapped = false;
        int j = 0;
        do {
            swapped = false;

            for(int i = 0; i < n-1-j; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }

            if(swapped) j++;
        } while (swapped);

    }

    public static void sndLargeSmall(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int element : arr) {
            if(element > largest) {
                secondLargest = largest;
                largest = element;
            } else if(element < largest && element > secondLargest) {
                secondLargest = element;

            }

            if(element < smallest) {
                secondSmallest = smallest;
                smallest = element;
            } else if(element > smallest && element < secondSmallest) {
                secondSmallest = element;
            }
        }

        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Second smallest: " + secondSmallest);

    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        reverse(nums, 0, n - 1 - k);

        reverse(nums, n - k, n - 1);

        reverse(nums, 0, n - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static List<Integer> findUnion(int[] a, int[] b) {
        List<Integer> union = new ArrayList<>();

        int m = a.length;
        int n = b.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            while (i < m-1 && a[i] == a[i+1]) i++;

            while (j < n-1 && b[j] == b[j+1]) j++;
            
            if(a[i] == b[j]) {
                union.add(a[i]);
                i++;
                j++;
            } else if(a[i] < b[j]) {
                union.add(a[i++]);
            } else {
                union.add(b[j++]);
            }
        }

        while (i < m) {
            if(a[i] != union.getLast()) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < n) {
            if(b[j] != union.getLast()) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }

    //# GFG Longest sub array with sum k
    public static int getLongestSubarray(int[] a, long k) {
        int n = a.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static int getLongestSubarrayOptimal(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }


    // TODO check all below algos
    public static int maxSubArrayKadaneAlgo(int[] nums) {
        // Initialize the current sum and max sum to the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If currentSum is negative, it's better to start a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum if currentSum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private static int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return nums[left];
        }

        // Find the middle point
        int mid = left + (right - left) / 2;

        // Find the maximum subarray sum in the left and right halves
        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);

        // Find the maximum subarray sum that crosses the middle
        int crossMax = maxCrossingSubArray(nums, left, mid, right);

        // Return the maximum of the three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int maxCrossingSubArray(int[] nums, int left, int mid, int right) {
        // Find the maximum sum starting from mid and going left
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Find the maximum sum starting from mid + 1 and going right
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return the sum of the maximum left and right subarrays that cross the middle
        return leftSum + rightSum;
    }

    public static int myKadaneAlgo(int[] nums) {
        // Initialize the current sum and max sum to the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            //Add current element to summation
            currentSum += nums[i];
            //if current element found greater tha previous elements summation, then start over from current element
            currentSum = Math.max(currentSum, nums[i]);
            //Compare with maxSum and update
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }


    public static void sortColors(int[] nums) {
        int l = 0, r = nums.length -1, c = 0;

        while (c < r) {
            if(nums[c] == 2) {
                int temp = nums[r];
                nums[r--] = 2;
                nums[c] = temp;
            }
        }
    }

    //Using Voting algorithm (Only works if majority element frequency is half of array (n/2))
    public static int majorityElementVotingAlgo(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int i : nums) {
            if(count == 0) candidate = i;

            if(candidate == i) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        AtomicInteger maxCount = new AtomicInteger(0);
        AtomicInteger variable = new AtomicInteger(0);
        map.forEach((k, v) -> {
            if(v > maxCount.get()) {
                maxCount.set(v);
                variable.set(k);
            }
        });

        return variable.get();
    }

    public static void lexiCo(int[] nums) {
        int n = nums.length;
        int pivotIndex = Integer.MIN_VALUE;
        boolean pivotFound = false;
        if (n > 1) {
            for(int i = n - 1; i > 0; i--) {
                if (nums[i] > nums[i-1]) {
                    pivotFound = true;
                    pivotIndex = i-1;
                    break;
                }
            }

            if(pivotFound) {
                int successor = Integer.MAX_VALUE;
                int successorIndex = -1;
                for(int i = n - 1; i > pivotIndex; i--) {
                    if(nums[i] > nums[pivotIndex] && nums[i] < successor) {
                        successor = nums[i];
                        successorIndex = i;
                    }
                }

                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[successorIndex];
                nums[successorIndex] = temp;

                int l = pivotIndex + 1, r = n - 1;
                while (l < r) {
                    int swap = nums[l];
                    nums[l] = nums[r];
                    nums[r] = swap;
                    l++;
                    r--;
                }
            } else {
                int l = 0, r = n - 1;
                while (l < r) {
                    int temp =  nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r--;
                }
            }
        }

    }


    //Similar to max length of subarray, modification for useCases where k = zero and multiple zeros in array
    public static int countSubArraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
        int index = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;
        while (index < n) {
            sum += nums[index++];
            if(sum == k) count++;

            int rem = sum - k;

            if(store.containsKey(rem)) count = store.get(rem);

            store.put(sum, store.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void setMatrixZeros(int[][] matrix ) {
        Set<Short> set = new HashSet<>();
        for(short i = 0; i < matrix.length; i++) {
            boolean foundZeroInRow = false;
            for(short j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    foundZeroInRow = true;
                    set.add(j);
                }
            }

            if(foundZeroInRow) {
                for(short j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(short i = 0; i < matrix.length; i++) {
            for(short j = 0; j < matrix[i].length; j++) {
                if(set.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static List<Integer> majorityElementNThird(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 == 0 && ele1 != nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) {
                cnt1++;
            }
            else if(nums[i] == ele2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == ele1){
                count1++;
            }
            if (nums[i] == ele2){
                count2++;
            }
        }
        if (count1 > nums.length/3){
            list.add(ele1);
        }
        if (count2> nums.length/3){
            list.add(ele2);
        }
        return list;
    }

    static int findFloor(int[] arr, int k) {
        int ans = -1;
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int[] getFloorAndCiel(int[] nums, int k) {
        int floor = -1;
        int ciel = -1;
        int low = 0;
        int high =  nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == k) {
                return new int[]{mid, mid};
            } else if(nums[mid] > k) {
                ciel = mid;
                high = mid - 1;
            } else {
                floor = mid;
                low = mid + 1;
            }
        }

        return new int[]{floor, ciel};
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }

    //Array is sorted
    public static int[] removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1) return nums;

        int add = 0;
        int trav = 0;

        while (trav < nums.length) {

            while(trav < nums.length - 1 && nums[trav] == nums[trav + 1]) {
                trav++;
            }

            nums[add] = nums[trav];
            add++;
            trav++;
        }

        while(add < nums.length) {
            nums[add++] = 0;
        }

        return nums;
    }



}
