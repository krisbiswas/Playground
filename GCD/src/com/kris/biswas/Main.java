package com.kris.biswas;
/*
* Compute GCD or HCF of two Numbers or array of numbers.
*/
public class Main {

    static int gcd(int a,int b){
        int result = 1;
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        if(a == b){
            return b;
        }
        
//        while(a%2 == 0 || b%2 == 0){
//            if(a%2==0 && b%2 == 0) {
//                result *= 2;
//                a /= 2;
//                b /= 2;
//            }else if(a%2 == 0){
//                a/=2;
//            }else{
//                b/=2;
//            }
//        }
        
        for (int i = 2; i <= a && i <= b; i = i + 2) {
            while (a%i == 0 || b%i == 0) {
                if(a%i==0 && b%i == 0) {
                    result *= i;
                    a /= i;
                    b /= i;
                }else if(a%i == 0){
                    a/=i;
                }else{
                    b/=i;
                }
            }
        }
        return result;
    }

    static int gcdOfArray(int[] a){
        int result = a[0];
        for(int i = 1;i<a.length;i++){
            result = gcd(result,a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfArray(new int[]{80,88,16,280}));
    }
}
