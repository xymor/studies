package challenge;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,5,999);
        //System.out.println("Input array is: " + l );
        //System.out.println("Result sum is: " + sumInteractive(l));

        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(10001));
        System.out.println(isPalindrome(10000));
    }

    private static int[] indexEqualValue(int[] array){
        int[] out = {};
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == i){
                out[index] = i;
                index++;
            }
        }
        return out;
    }

    private static boolean isPalindrome(int a){
        String text = Integer.toString(a);

        int length = text.length();
        if(length==0) return false;
        for(int i = 0; i < length; i++){
            if(text.charAt(i) != text.charAt(length-1-i)){
                return false;
            };
        }
        return true;
    }

    private static int sumInteractive(List<Integer> list){
        return list.stream().reduce(Integer::sum).orElse(0);
    }

    private static int sumBasic(List<Integer> list){
        Integer total = 0 ;
        for(Integer i : list){
            total += i;
        }
        return total;
    }

    private static int sumRecursive(Integer total, List<Integer> list){
        if(list == null || list.size() == 0){ return total; }
        if(list.size() == 1){ return sumRecursive(list.get(0), null); }

        Integer head = list.get(0);
        List<Integer> tail = list.subList(1, list.size());

        return sumRecursive(head, tail);
    }
}
