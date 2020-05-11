package com.company;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class May4_cw {
    static int cnt = 0;
    public static void compute(File a){
        cnt++;
        DecimalFormat dec= new DecimalFormat(".##");
        try{

            Scanner sc= new Scanner(a);
            Scanner input= new Scanner(a);
            String line1, line2;
            int line_num=0;
            int count=0,above= 0, below= 0;
            int sum=0;
            double avg=0, meansum=0, stdeviation=0;

            //File A
            while(sc.hasNext()){
                line1= sc.nextLine();
                sum += Integer.parseInt(line1); //for avg
                count++; //for num
            }

            avg= (double)sum/count;


            int [] arr= new int[count];
            for(int i=0; i<count; i++){
                line2= input.nextLine();
                arr[i]=Integer.parseInt(line2);
                meansum += Math.pow((arr[i] -avg),2);
                if (arr[i]>avg){ above++;}
                else {below++;}
            }


            //final values:
            //Standard deviation -mean, (x-mean)^2, tesko sum, 1/no
            stdeviation= Math.sqrt(meansum/count);
            Arrays.sort(arr);


            //Display
            String fname;
            if(cnt==1) fname="a";
            else if(cnt==2) fname="b";
            else fname="c";
            System.out.println("**************************************************"+
                    "\nLab 13 Fall 2015 <Aaka> using file Lab11"+fname+".txt\n" +
                    "**************************************************"+
                    "\n---------------Summary Statistics-----------------"      );
            System.out.println("Number of elements:\t"+count+"\nAverage data value is:\t"+dec.format(avg));
            System.out.println("The standard deviation is:\t"+ dec.format(stdeviation));
            System.out.println("Min data value is:\t"+arr[0]+"\nMax data value is:\t"+arr[count-1]);
            System.out.println("Count above avg is:\t"+above+"\nCount below avg is:\t"+below);
            int maxel=70;
            if (cnt==2) maxel=280;
            System.out.println("Maximum elements:\t"+maxel+"\n");


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main (String[] args){
        File a= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11a.txt");
        File b= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11b.txt");
        File c= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11c.txt");


        compute(a);
        compute(b);
        compute(c);

    }
}
