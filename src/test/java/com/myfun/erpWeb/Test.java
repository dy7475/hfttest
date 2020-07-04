package com.myfun.erpWeb;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println(test());
    }

    public static Integer test() {
        for (Integer i=0;i<100;i++) {
            if(i==20) {
                return 20;
            }
        }
        return 0;
    }

}

