import java.io.*;
import java.util.*;

class Main{

    static List<String> possibleLS = new LinkedList<>();
    static Set<String> possSetLS = new HashSet<>();
    static Queue<String> possLS = new PriorityQueue<>();
    static final int MAX = 2100000000;
    static int[] dp;
    public static void main(String[] args) {
        // possLS.add("1");
        
        int L = 5;
        int S = 4;
        dp = new int[S+1];
        for ( int i = 0 ; i < S+1 ; i ++ ) dp[i] = -1;
        dp[1] = initFirstLS(L, 1);
        // findLSWithDP(L,S,"");
        // findLS(L, S,"");

        for (String ls : possibleLS){
            System.out.println(ls);
        }
        possLS = new PriorityQueue<>(possSetLS);
        for (String ls : possLS){
            System.out.println(ls);
        }
        // @Ref. LinkedList.size() return int...
        // @Todo: is it possible LinkedList store over amount 2^32 ?
        System.out.println("SIZE : " + possibleLS.size() % MAX);
    }
    private static int initFirstLS(int l, int i) {

        return 0;
    }
    static void findLS(int l, int s, String result){
        //System.out.println("[DEBUG] l : "+l+" s : "+s+" result: "+result);
        // endpoint , 남은 자리수가 하나!
        if ( l == 1 ) {
            // if sum is in 0~9, *add to list
            if ( s < 10 ) possibleLS.add(result + s);
            return;
        }
        for ( int i = 0 ; i < 10 ; i ++ ){
            // nextRecursiveCall`s param s >= 0
            if ( s - i < 0 ) return;
            // Cannot be zero first place of num
            if ( i == 0 && result.equals("") ) continue;
            // recursive call
            findLS(l-1,s-i,result+i);
        }
    }
    static void findLSWithDP(int l, int s, String result){
        //System.out.println("[DEBUG] l : "+l+" s : "+s+" result: "+result);
        // endpoint , 남은 자리수가 하나!

        if ( s > 1 && dp[s-1] == -1 ){
            findLSWithDP(l, s-1, result);
        }
        if ( l == 1 ) {
            // if sum is in 0~9, *add to list
            if ( s < 10 ) possibleLS.add(result + s);
            return;
        }
        for ( int i = 0 ; i < 10 ; i ++ ){
            // nextRecursiveCall`s param s >= 0
            if ( s - i < 0 ) return;
            // Cannot be zero first place of num
            if ( i == 0 && result.equals("") ) continue;
            // recursive call
            findLSWithDP(l-1,s-i,result+i);
        }
    }
}