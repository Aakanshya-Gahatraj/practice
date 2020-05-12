/******Corrsponding file- student_record.txt *******/

import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

public class Student {
    public static void main(String[] args) {
        DecimalFormat dec= new DecimalFormat(".##");
        try{
            File a= new File("/home/rjan/IdeaProjects/Aka/src/student_record.txt");
            Scanner sc= new Scanner(a);
            Scanner in= new Scanner(a);
            String line1,line2;
            int count=0;
            double avg;

            while(sc.hasNext()){
                line1= sc.nextLine();
                count++; }

            String[] Separr=null;
            int[] Stid= new int[count];
            int[] Math= new int[count];
            int[] Sci= new int[count];
            int[] Eng= new int[count];
            double sum=0;
            double[] Avg= new double[count];

            for(int i=0;i<count;i++) {
                line2 = in.nextLine();
                Separr = line2.split(" ");
                Stid[i] = Integer.parseInt(Separr[0]);
                Math[i] = Integer.parseInt(Separr[1]);
                Sci[i] = Integer.parseInt(Separr[2]);
                Eng[i] = Integer.parseInt(Separr[3]);
                sum += (double) Math[i]+Sci[i]+Eng[i];
                Avg[i] = (sum/(Separr.length-1));
                sum=0;
                }


            //Display
            System.out.println("StudentId  Math  Science  English  AverageMarks");
            for(int j=0;j<count;j++){
                System.out.println(Stid[j]+"\t\t"+Math[j]+"\t\t"+Sci[j]+"\t\t"+Eng[j]+"\t\t"+dec.format(Avg[j])); }
            sc.close();
            in.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
