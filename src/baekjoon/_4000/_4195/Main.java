package baekjoon._4000._4195;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int numOfCase = Integer.parseInt(br.readLine());

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < numOfCase; i++) {

            int networkCreatedSequences = Integer.parseInt(br.readLine());
            HashSet<String> membersInTheNetwork = new HashSet<>();
            HashSet<String> membersGroupInNetwork = new HashSet<>();
            Integer count = 0;


            /**
             * 두 사람을 가져와서 HashSet에 Add를 할 것이다.
             * Set은 중복을 허용하지 않기 때문에 자동으로 중복이 되면
             * 저장이 안 될 것이다.
             */
            for (int j = 0; j < networkCreatedSequences; j++) {
                String networkCase = br.readLine();
                String[] twoPeopleInTheNetwork = networkCase.split(" ");

                /**
                 * 만약 세트에 하나도 없는 경우는 받은 사람 집어넣고 수 2 올리기
                 * 세트에 누군가가 있는데 겹치는게 없으면 카운트 안올리기
                 * 세트에 있는거랑 하나만 겹치면 카운트 하나 올리기
                 * 두개다 겹치면 두개 분리된거 연결시키는거면 +2
                 * 아니면 0
                 */
                if(!membersInTheNetwork.contains(twoPeopleInTheNetwork[0])&&!membersInTheNetwork.contains(twoPeopleInTheNetwork[1])){
                    if (membersInTheNetwork.size() == 0) {
                        membersInTheNetwork.add(twoPeopleInTheNetwork[0]);
                        membersInTheNetwork.add(twoPeopleInTheNetwork[1]);
                        count = count+ 2;
                        intList.add(count);
                        membersGroupInNetwork.add(networkCase);
                    }else {
                        membersInTheNetwork.add(twoPeopleInTheNetwork[0]);
                        membersInTheNetwork.add(twoPeopleInTheNetwork[1]);
                        intList.add(count);
                        membersGroupInNetwork.add(networkCase);
                    }
                }else if (membersInTheNetwork.contains(twoPeopleInTheNetwork[0])&&!membersInTheNetwork.contains(twoPeopleInTheNetwork[1])||
                    !membersInTheNetwork.contains(twoPeopleInTheNetwork[0])&&membersInTheNetwork.contains(twoPeopleInTheNetwork[1])){
                    membersInTheNetwork.add(twoPeopleInTheNetwork[0]);
                    membersInTheNetwork.add(twoPeopleInTheNetwork[1]);
                    count = count + 1;
                    intList.add(count);
                    membersGroupInNetwork.add(networkCase);
                }else {
                    if(membersGroupInNetwork.contains(networkCase)){
                        intList.add(count);
                    }else {
                        count = count + 2;
                        intList.add(count);
                        membersGroupInNetwork.add(networkCase);
                    }
                }
            }

        }
        for (Integer integer : intList) {
            bw.write(integer.toString() + "\n");
        }
        bw.flush();

        br.close();
        bw.close();


    }

}