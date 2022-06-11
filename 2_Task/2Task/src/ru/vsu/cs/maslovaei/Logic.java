package ru.vsu.cs.maslovaei;

import static java.lang.Integer.MIN_VALUE;

public class Logic {

    public LinkedList findNumber(LinkedList<Integer> list) throws Exception {
        int maxIndex=0;
        int maxNum = MIN_VALUE;

        for (int i = 0;i<list.size();i++){
            if(list.get(i)>maxNum){
                maxNum = list.get(i);
                maxIndex = i;
            }
        }
        maxNum=-maxNum;
        list.addNext(maxNum,maxIndex);

        return list;
    }
}
