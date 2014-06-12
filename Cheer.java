/*
Cheer program uses threads to print out cheers for a country
Creator:Edson Siera
Date:2/25/14
*
*/
import java.util.Scanner;
import java.util.*;
class Cheer {
 	public static void main (String args[]) {

Scanner scan=new Scanner(System.in);
ArrayList<String> arr=new ArrayList<String>();
ArrayList<Integer> countryTimes=new ArrayList<Integer>();

 System.out.println("How many countries are supported at the bar?");
 int countries=scan.nextInt(); 

//adds the country and the cheers for each country to List
for(int k=0;k<countries;k++)
{
System.out.println("Enter country: ");
  arr.add(scan.next());
  System.out.println("Enter how many cheers: ");
  countryTimes.add(scan.nextInt());
}

List<Integer> list=new ArrayList<Integer>();
for(int i=0;i<countries;i++) list.add(i);{
	Collections.shuffle(list);} //this will pick a unique random number

//pick a random unique number and pass it to the thread
for(int j=0;j<list.size();j++)
{
 new CheerThread(arr.get(list.get(j)),countryTimes.get(list.get(j))).start();
}
    }
}

class CheerThread extends Thread {
	private int time;
    public CheerThread(String str,int times) {
	 super(str);
	 time=times;
    }
    //threading process
    public void run() {
	     for(int j=0;j<time;j++){
	       System.out.println("Go"+ " " +getName()+"!");
              try {
		            sleep((int)(Math.random() * 3000));
	                } catch (InterruptedException e) {}
	         }
      }
}

