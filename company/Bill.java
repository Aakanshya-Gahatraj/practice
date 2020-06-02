//connects to Inventory.txt and Sales.txt
package com.company;

import java.util.Scanner;
import java.io.*;

public class Bill {
    static String date,name,pname;
    static int quantity,total;
    static  int count;

    public static void main(String[] args) {
        Scanner reply= new Scanner (System.in);

        try{
            //reading the file
            File a= new File ("/home/rjan/IdeaProjects/Aaka_progassignment/src/com/company/Inventory.txt");
            Scanner sc = new Scanner(a);
            Scanner in = new Scanner(a);
            Scanner ab= new Scanner(a);
            String line;

            while(sc.hasNext()){
                sc.nextLine();
                count ++;
            }

            String[][] array = new String[count][5]; //making 2-d array
            for(int i=0; i<count; i++){
                line= in.nextLine();
                array[i]= line.split(","); // splitting line
            }

            //for writing in inventory
            System.out.println("\nDo you want to add new info to inventory? (y/n)");
            String yn_forinven= reply.next();

            if(yn_forinven.toUpperCase().equals("Y")) {
                System.out.println("Add info in format- date,pid,pname,instock,price,");
                FileWriter out = new FileWriter("/home/rjan/IdeaProjects/Aaka_progassignment/src/com/company/Inventory.txt");
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < 5; j++){
                        out.write(array[i][j] +",");
                        System.out.print(array[i][j]+",");
                    }
                    out.write("\n");
                    System.out.println();
                }
                System.out.println("Insert the data");
                out.write(reply.next());
                out.close();
            }

            //search by pid
            String id_ans="";
            System.out.println("Do you want to search for a product? (y/n)");
            String yn_forpid= reply.next();
            if(yn_forpid.toUpperCase().equals("Y")){
                System.out.println("Enter the product ID");
                  id_ans= reply.next();
            }

            int soo=0;
            for(int i=1; i<count; i++){
                if (array[i][1].equals(id_ans)){
                    System.out.println("Product Name= "+array[i][2]+"\t\tInstock= "+array[i][3]+"\t\tPrice= "+array[i][4]);
                    soo= 1;}
            }
            if(soo==0) {
                System.out.println("The product doesn't exist");
            }

            // for sales
            FileWriter writing= new FileWriter("/home/rjan/IdeaProjects/Aaka_progassignment/src/com/company/Sales.txt");
            System.out.println("\n\nDo you want to buy a product? (y/n)");
            String yn_forbuy = reply.next();
            if(yn_forbuy.toUpperCase().equals("Y")) {
                System.out.println("Date?");
                date = reply.next();
                System.out.println("Your Name?");
                name = reply.next();
                System.out.println("Product Name?");
                pname = reply.next();
                System.out.println("Quantity?");
                quantity = reply.nextInt();
            }
            writing.write("Date,Name,Product,Quantity\n");
            writing.write(date+","+name+","+pname+","+quantity);
            writing.close();

            //for price
            int price=0;
            for(int i=0;i<count;i++){
                line=ab.nextLine();
                String[] arr= line.split(",");
                if(line.contains(pname)){
                    price= Integer.parseInt(arr[4]);
                }
            }
            total += quantity*price;  //total

            //bill
            System.out.println("*********************");
            System.out.println("Welcome to AKAMart\n*********************\n\nThis is the bill of "+name);
            System.out.println("\nName\t\tProduct\t\tQuantity\t\tTotal");
            System.out.println(name+"\t\t\t"+pname+"\t\t\t"+quantity+"\t\t\t"+quantity*price);
            System.out.println("\t\t\t================================");
            System.out.println("\t\t\t\t\t\t\t\t\t\t"+total);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
