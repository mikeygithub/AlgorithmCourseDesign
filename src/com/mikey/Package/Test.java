package com.mikey.Package;

import java.util.Arrays;

/**动态规划资源分配
 * @author Mikey
 * @date 2018/12/16 15:37
 */
public class Test{
    public static String maxProfit(int[][] c){
        int m = c.length+1, n = c[0].length+1;
        int[][] p = new int[m][n];
        int[][] l = new int[m][n];
        for(int i = 0; i < m; i ++)
            p[i][0] = 0;
        for(int j = 0; j < n; j ++)
            p[0][j] = 0;
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                int max = p[i-1][j];
                l[i][j] = 0;
                for(int k = 1; k <= j; k ++){
                    if(max < c[i-1][k-1] + p[i-1][j-k]){
                        max = c[i-1][k-1] + p[i-1][j-k];
                        l[i][j] = k;
                    }
                }
                p[i][j] = max;
            }
        }
        String result = "";
        for(int i = m-1, j = n-1; i > 0 && j > 0;){
            if(l[i][j] == 0)
                i --;
            else{
                result = "\n" + "工程" + i + " 分配: " + l[i][j] + result;
                j -= l[i][j];
                i --;
            }
        }
        result = "最大利润: " + p[m-1][n-1] + result;
        return result;
    }
    public static void main(String[] args) {
        int[][] c = new int[3][10];
        for(int i = 0; i < 3; i ++){
            c[i][0] = (int)(Math.random()*10);
            for(int j = 1; j < 10; j ++){
                c[i][j] = c[i][j-1] + (int)(Math.random()*5);
            }
        }
        for(int i = 0; i < 3; i ++)
            System.out.println(Arrays.toString(c[i]));
        System.out.println(maxProfit(c));
    }
}
