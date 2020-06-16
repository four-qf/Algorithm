package com.qiux.algorithm;
import java.text.DecimalFormat;

/**
 * @author qiuxian
 * @date 2020/6/16
 */
public class CubeRoot {

    public static void main(String[] args) {
        System.out.println(getCubeRoot(18));
    }

    public static double getCubeRoot(double input) {
        double num = Math.cbrt(input);
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String result = decimalFormat.format(num);
        return Double.parseDouble(result);
    }
}
