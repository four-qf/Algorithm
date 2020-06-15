package com.qiux.algorithm;


import java.util.*;

/**
 * 求2个正整数的最小公倍数
 * @author qiuxian
 * @date 2020/6/15
 */
public class LowestCommonMultiple {

    static List<Integer> qualityList = new ArrayList<>(); //Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
    static int sum = 1 ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        primitiveNum(1000);
        if (qualityList != null && qualityList.size() >0) {
            minNum(a,b);
        }
        System.out.println(sum);


    }

    //求小于n的质素
    public static void primitiveNum (int n) {
        for (int i = 2; i < n; i ++) {
            if (isPrimitive(i)) {
                qualityList.add(i);
            }
        }
    }

    //判断是否是质素
    public static boolean isPrimitive(int num) {
        for (int j =2; j < Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }


    //算最小公倍数
    public static void minNum (int a , int b) {
        if (qualityList.contains(a) && qualityList.contains(b)) {
            sum = sum * a * b;
            return;
        }

        for (Integer quality : qualityList) {
            if (0 == a % quality && b % quality == 0) {
                sum = sum * quality;
                a = a/quality;
                b = b/quality;
                if (a == 1 || b == 1 || qualityList.contains(a) || qualityList.contains(b)) {
                    sum = a * b * sum;
                } else {
                    minNum(a, b);
                }
                break;
            }
        }

        if (sum == 1) {
            sum = a * b;
        }
    }

}
