import java.util.*;
class Main{
  public static void main(String[] args){
    String[] test1 = {"hot", "dot", "dog", "lot", "log", "cog"};
    Solution sol = new Solution();
    System.out.println(sol.solution("hit","cog",test1));
  }
}
class Node{
    String word;
    int convert;
    Node(String w, int c){
        word = w;
        convert = c;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        boolean[] check = new boolean[words.length];

        while(!q.isEmpty()){
            Node node = q.poll();
            if ( node.word.equals(target)) return node.convert;
            for ( int i = 0 ; i < words.length ; i ++ ){
                if (!check[i] && check(node.word, words[i])) {
                    check[i] = true;
                    q.add(new Node(words[i], ++node.convert));
                }
            }
        }
        return 0;
    }
    boolean check(String s1, String s2){
        int count = 0;
        for ( int i = 0 ; i < s1.length() ; i ++ ){
          if ( s1.charAt(i) != s2.charAt(i)) count ++;
          if ( count > 1 ) return false;
        }
        return count == 1;
    }
}
