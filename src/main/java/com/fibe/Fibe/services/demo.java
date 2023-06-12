package com.fibe.Fibe.services;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class demo {
    public static void main(String[] args){
        System.out.println( sum(30,6));

    }
    public static int sum(int a,int b){
    int notD=0;
    int d=0;
    for (int i=0;i<=a;i++){
        if(i%b==0){
            d=d+i;

        }
        else{

            notD=notD+i;
        }

    }
    return notD-d;

    }
}
