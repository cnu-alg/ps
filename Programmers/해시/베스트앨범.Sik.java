import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < plays.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> genres_list = new ArrayList<>();
        for (int i = 0; i < entryList.size(); i++){
            genres_list.add(entryList.get(i).getKey());
        }

        List<Integer> music_list = new ArrayList<>();
        for(String genre : genres_list){
            Map<Integer,Integer> music_map = new HashMap<>();
            for (int i =0; i < genres.length; i++){
                if(genres[i].equals(genre)){
                    music_map.put(i,plays[i]);
                }
            }
            List<Map.Entry<Integer, Integer>> tempList = new LinkedList<>(music_map.entrySet());
            tempList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            music_list.add(tempList.get(0).getKey());
            if (tempList.size() > 1){
                music_list.add(tempList.get(1).getKey());
            }
        }
        int[] answer = new int[music_list.size()];
        for (int i = 0; i < music_list.size(); i++){
            answer[i] = music_list.get(i);
        }
        return answer;
    }
}