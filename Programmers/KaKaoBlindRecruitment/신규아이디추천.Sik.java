import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String new_id) {

        // 1단계
        String id = new_id.toLowerCase();

        // 2단계
        String[] word = {"~","!","@","#","$","%","^","&","*","(",")","=","+","[","{","]","}",":","?",",","<",">","/"};

        for(int i = 0; i < word.length; i++){
            id = id.replace(word[i],"");
        }

        // 3단계
        ArrayList<String> arr_id = new ArrayList<String>();
        for(int i = 0; i < id.length(); i++){
            arr_id.add(id.split("")[i]);
        }

        while (true){
            for(int i = 0; i < arr_id.size() - 1; i++){
                if (arr_id.get(i).equals(".")){
                    if(arr_id.get(i+1).equals(".")){
                        arr_id.remove(i);
                    }
                }
            }
            if (!String.join("", arr_id).contains("..")){
                break;
            }
        }

        // 4단계
        if (arr_id.get(0).equals(".")){
            arr_id.remove(0);
        }
        if (arr_id.size() != 0){
            if (arr_id.get(arr_id.size()-1).equals(".")){
                arr_id.remove(arr_id.size()-1);
            }
        }

        // 5단계
        if (arr_id.size() == 0) arr_id.add("a");

        // 6단계
        List<String> lis_id = new ArrayList<String>();
        if (arr_id.size() > 15){
            lis_id = arr_id.subList(0, 15);
            if (lis_id.get(lis_id.size()-1).equals(".")){
                lis_id.remove(lis_id.size()-1);
            }
        }
        else {
            lis_id = arr_id;
        }

        // 7단계
        if (lis_id.size() <= 2){
            while(lis_id.size() != 3){
                lis_id.add(lis_id.get(lis_id.size()-1));
            }
        }


        String answer = String.join("", lis_id);
        return answer;
    }
}