import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<String> reportList = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<Integer> answers = new ArrayList<Integer>();

        for (int i = 0; i < id_list.length; i++){
            count.add(0);
            answers.add(0);
        }

        HashSet<String> setreport = new HashSet<>();
        for(String item : report){
            setreport.add(item);
        }
        ArrayList<String> setrepo = new ArrayList<>(setreport);


        for (int i = 0; i < setrepo.size(); i++){
            reportList.add(setrepo.get(i).split(" ")[1]);
        }


        for (int i = 0; i < id_list.length; i++){
            for (int j = 0; j < setrepo.size(); j++){
                if (id_list[i].equals(reportList.get(j))){
                    count.set(i, count.get(i)+1);
                }
            }
        }


        for (int i = 0; i < count.size(); i++){
            if (count.get(i) >= k){
                for (int j = 0; j < setrepo.size(); j++){
                    if (setrepo.get(j).split(" ")[1].equals(id_list[i]) == true){
                        for(int h = 0; h < id_list.length; h++){
                            if (setrepo.get(j).split(" ")[0].equals(id_list[h])){
                                answers.set(h, answers.get(h)+1);
                            }
                        }
                    }
                }
            }
        }

        int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }



        return answer;
    }
}