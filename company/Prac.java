package com.company;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {
        DecimalFormat dec= new DecimalFormat(".##");
        for(int j=0;j<3;j++) {
            try {
                File a=null;
                String fname;
                int maxel= 70;
                if(j==0) {
                    fname="a";
                    a= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11a.txt");
                }
                else if(j==1){
                    fname= "b";
                    maxel= 280;
                    a= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11b.txt");
                }
                else{
                    fname="c";
                    a= new File("/home/kaneki/IdeaProjects/aakanshya/src/com/company/Lab11c.txt");
                }
                Scanner sc = new Scanner(a);
                Scanner input = new Scanner(a);
                String line1, line2;
                int line_num = 0;
                int count = 0, above = 0, below = 0;
                int sum = 0;
                double avg = 0, meansum = 0, stdeviation = 0;

                //File A
                while (sc.hasNext()) {
                    line1 = sc.nextLine();
                    sum += Integer.parseInt(line1); //for avg
                    count++; //for num
                }

                avg = (double) sum / count;


                int[] arr = new int[count];
                for (int i = 0; i < count; i++) {
                    line2 = input.nextLine();
                    arr[i] = Integer.parseInt(line2);
                    meansum += Math.pow((arr[i] - avg), 2);
                    if (arr[i] > avg) {
                        above++;
                    } else {
                        below++;
                    }
                }


                //final values:
                //Standard deviation -mean, (x-mean)^2, tesko sum, 1/no
                stdeviation = Math.sqrt(meansum / count);
                Arrays.sort(arr);


                //Display
                System.out.println("**************************************************" +
                        "\nLab 13 Fall 2015 <Aaka> using file Lab11"+fname+".txt\n" +
                        "**************************************************" +
                        "\n---------------Summary Statistics-----------------");
                System.out.println("Number of elements:\t" + count + "\nAverage data value is:\t" + dec.format(avg));
                System.out.println("The standard deviation is:\t" + dec.format(stdeviation));
                System.out.println("Min data value is:\t" + arr[0] + "\nMax data value is:\t" + arr[count - 1]);
                System.out.println("Count above avg is:\t" + above + "\nCount below avg is:\t" + below);
                System.out.println("Maximum elements:\t" + maxel);

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
