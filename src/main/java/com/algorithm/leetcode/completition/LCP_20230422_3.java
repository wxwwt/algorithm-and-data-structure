package com.algorithm.leetcode.completition;

/**
 * @author scott
 * @date 2023/4/22 17:10
 */
public class LCP_20230422_3 {

    public int fieldOfGreatestBlessing(int[][] forceField) {

        int max = 0;
            for (int i = 0; i < forceField.length; i++) {
                int strong = 0;
                double  banjing = getBanJing(forceField[i][2]);
                for (int j = i + 1; j < forceField.length; j++) {
                    double banjing1 = getBanJing(forceField[j][2]);
                    double dis = banjing + banjing1;
                    // 说明相交
                    if (getDistance(forceField[i][0], forceField[i][1], forceField[j][0], forceField[j][1]) < dis) {
                        strong++;

                    }
                }
            }
            return 0;
    }

    /**
     * 计算两点之间的距离
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public double getDistance(int x1, int y1, int x2, int y2) {
     return    Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2),2 ));
    }

    public double getBanJing(double l) {
        return  Math.sqrt(Math.pow((l / 2.0),2) + Math.pow((l / 2.0), 2));
    }
}