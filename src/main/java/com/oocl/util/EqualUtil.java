package com.oocl.util;

import java.util.List;

public class EqualUtil {



    public static boolean listisEqual(List<Object> list1,List<Object> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        else{
            for(int i=0;i<list1.size();i++){
                if(!list1.get(i).equals(list2.get(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
