public class Main{
  public static void main(String[] args){
	int[] testCase1 = new int[]{3,1,2};
	int[] testCase2 = new int[]{4, 5, 1, 2, 3};
	int[] testCase3 = new int[]{1, 1, 1, 1, 1};
	int[] testCase4 = new int[]{0,0,0};
	test(testCase1, 5, 1);
	test(testCase2, 12, 1);
	test(testCase3, 6, -1);
	test(testCase4, 1, -1);
  }
  static void test(int[] testCase, int k, int correct){
	int result = (new Solution()).solution(testCase,k);
	if (correct == result) System.out.println("Pass");
	else System.out.println("Fail" + "\nNeq <result, correct> <" + result + ", "+correct+">");
  }
}
class Solution {
    static int[] global_foods;
    static int size;
    static int answer = 0;
    static int idx = 0;
	static boolean eatable = true;
    public int solution(int[] food_times, long k) {
        global_foods = food_times;
        size = food_times.length;
		// make variable global
        recursive_Sub(k);
		// eatable is false when there is no more food.
		if (!eatable) return -1;
		// Find eatable food's index
		findNext();
		return idx+1;
    }
	/*
	@void
	@Summary. If idx'value is not 0 return, else iterate.
	 */
    void findNext(){
        while(true){
            if ( global_foods[idx%size] > 0) {return;}
            idx = (idx+1) % size;
        }
    }
	/*
	@void
	@Input time : Remaining value that need to be traversed
	@Summary. Recursive ...
	 */
    void recursive_Sub(long k){
        // exit point
        if (k == 0) return ;
        // able to divide
        if ( k >= size ) {
            subtract(k/size);
            k = k % size;
        }
        else {
            subtractPart(Long.valueOf(k).intValue()); // Downcasting for saving memory
            k = 0;
        }
        // find negative -> if return -1 : no else possitive foods
        long negative = findNegative();
		if (negative == -1 ) {
		  eatable = false;
		  return;
		}
        k += negative;
        recursive_Sub(k);
    }
	/*
	@void
	@Input. sub : K / food_times.size
	@Summary. Iterates through the entire array and subtracts the given variable
	 */
    void subtract(long sub){
        for ( int i = 0 ; i < size ; i ++ ) global_foods[i] -= sub;
    }
	/*
	@void
	@Input. sub : K % food_times.size
	@Summary. Iterates through the entire array by the given variable and subtracts one by one
	 */
    void subtractPart(int sub){
        for ( int i = 0 ; i < sub ; i ++ ) {
            global_foods[idx] --;
			idx = (idx+1)%size;
        }
        return;
    }
	/*
	@void
	@Summary. find negative value foreach food_times, if there's no negatvie : return -1
	 */
    long findNegative(){
        boolean positive = false; // flag for 'no negative value'
        long sum = 0;
        for (int i = 0 ; i < size ; i ++ ){
            if (!positive && global_foods[i] > 0) positive = true;
            if ( global_foods[i] < 0 ) {
                sum -= global_foods[i];
                global_foods[i] = 0;
            }
        }
		if ( !positive ) return -1;
        return sum;
    }
}
