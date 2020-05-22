package com.sid.leetcode;

public class HappyNumbers {


    /**
     * Write an algorithm to determine if a number n is "happy".
     *
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     *
     * Return True if n is a happy number, and False if not.
     *
     * Example:
     *
     * Input: 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     *
     * **/


    private boolean checkHappy(int n){

        int slow=n,fast=n;

        do{
            slow=getSumOfDigits(slow);
            fast=getSumOfDigits(getSumOfDigits(fast));

        }while(slow !=fast);

        return slow==1;

    }

    private int getSumOfDigits(int n) {
        int sum=0;
        while(n>0){
            int temp=n%10;
            sum += (temp*temp);
            n=n/10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int n=29;
        System.out.println(new HappyNumbers().checkHappy(n));
    }
}
