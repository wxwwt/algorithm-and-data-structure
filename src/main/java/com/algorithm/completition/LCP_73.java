package com.algorithm.completition;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author scott
 * @date 2023/4/22 16:37
 */
public class LCP_73 {

    public int adventureCamp(String[] expeditions) {
        if (expeditions.length == 1) {
            return -1;
        }

        String start = expeditions[0];
        Set<String> set = new HashSet<>();
        if (start.length() > 0) {
            String[] temp = start.split("->");
            for (String s : temp) {
                set.add(s);
            }
        }

        int max = 0, maxIndex = -1;
        for (int i = 1; i < expeditions.length; i++) {
            String s = expeditions[i];
            if (s.length() <= 0) {
                continue;
            }

            String[] temp = s.split("->");
            Set<String> tempSet = new HashSet<>();
            for (String s1 : temp) {
                tempSet.add(s1);
            }
            // 没有新营地发现
            if (set.containsAll(tempSet)) {
                continue;
            } else {

                tempSet.removeAll(set);
                int gtSize = tempSet.size();
                set.addAll(tempSet);
                if (gtSize > max) {
                    max = tempSet.size();
                    maxIndex = i;
                }
            }

        }
        return maxIndex;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(1, adventureCamp(new String[]{"leet->code","leet->code->Campsite->Leet","leet->code->leet->courier"}));
        Assertions.assertEquals(-1, adventureCamp(new String[]{"Alice->Dex","","Dex"}));
        Assertions.assertEquals(2, adventureCamp(new String[]{"","Gryffindor->Slytherin->Gryffindor","Hogwarts->Hufflepuff->Ravenclaw"}));
        Assertions.assertEquals(1, adventureCamp(new String[]{"xO->xO->xO","xO->BKbWDH","xO->BKbWDH","BKbWDH->mWXW","LSAYWW->LSAYWW","oAibBvPdJ","LSAYWW->u","LSAYWW->LSAYWW"}));

    }
}