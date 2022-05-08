import java.util.*;
public class Atm {
	static int pin=4040, manage= 1234, genpin;
	static double balance=1000;
	static Scanner g=new Scanner(System.in);
	public static void main(String[] args) {
		int pinn;
	label:	for(int i=1 ; i<=3 ; i++){
		try{
		System.out.print("\tWELCOME TO BANGKO SENTRAL NG BSCS 2B\n\n");
				System.out.print("\nEnter your PIN code: ");
		 pinn = g.nextInt();
		 if(pinn == pin || pinn == manage){
		 	System.out.print("\nAccess Granted!, Press any key to continue...");
		 	new java.util.Scanner(System.in).nextLine();
		 	System.out.print("\033[H\033[2J");
			atm();
			break;
		 }
		else if(pinn!=pin || pinn != manage){
			System.out.print("Invalid PIN code.\n\nPress any key to continue...");
			new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
			if(i==3){
			genpin=(int)(Math.random()*1000+1111);
			System.out.print("   Your PIN code was BLOCKED!\n\nGenerated pin: "+genpin + "\n\nPress any key to continue...");
			pin = genpin;
			manage=genpin;
			i=0;
			new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
			continue label;
			}
		}
		}
		catch(Exception e){
		System.out.println("\nERROR: your input must not containing letters or special characters, Please restart the program....\n");
		break;
		}
		}
	}
	public static void atm(){
		System.out.print("\nBangko ng Sentral ng BSCS 2B\n\n[1] - Balance Inquiry\n[2] - Withdraw\n[3] - Deposit\n[4] - Change pin\n[5] - Transfer Cash\n[6] - Exit\n\nEnter transaction: ");
		int i = g.nextInt();
		switch(i){
			case 1:
			System.out.print("\033[H\033[2J");
			bal();
			break;
			case 2:
			System.out.print("\033[H\033[2J");
			with();
			break;
			case 3:
			System.out.print("\033[H\033[2J");
			dep();
			break;
			case 4:
			System.out.print("\033[H\033[2J");
			cp();
			break;
			case 5:
			System.out.print("\033[H\033[2J");
			tc();
			break;
			case 6:
			System.out.print("\nThank you, Goodbye!");
			break;
			default:
			System.out.print("Invalid input!, Please try again....");
			new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
			atm();
			}
		}
	static void bal(){
		System.out.print("\n\nYour balance is:\n\t"+ balance +" pesos.\n\nDo you want another transaction?\nY || N... ");
		String y = g.next();
		if(y.equals("Y")||y.equals("y")){
			System.out.print("Press any key to continue...");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		atm();
		}
		else if(y.equals("N")||y.equals("n")){
		System.out.print("\nThank you, Goodbye!");
		System.exit(0);
		}
		else{
		System.out.print("Invalid input! Please try again....\n");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		bal();
		}
		}
	static void with(){
		note: for(int i=1 ; i>=0 ; i++){
		System.out.print("\tWithdrawal Section\n\nEnter amount: ");
		double ma = g.nextInt();
		if(ma>10000 && balance>=10000){
			System.out.print("You can't withdraw more than 10k cash, Please try again... ");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		continue note;
			}
		if(ma >= balance){
		System.out.print("You have insuficient balance, Please try again... ");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		continue note;
		}
		else if(ma%100!=0){
		System.out.print("Invalid amount!, Please try again... ");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		continue note;
		}
		else {
			balance -= ma;
		System.out.print("\nPlease get your cash: " + ma +"\n\nCurrent balance: " + balance+"\n\t....");
		xxx();
		break;
		}
		}
		}
		static void xxx(){
			new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
			System.out.print("\n\nDo you want another transaction?\nY || N... ");
		String yn = g.next();
		if(yn.equals("Y") || yn.equals("y")){
			System.out.print("Press any key to continue...");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		atm();
			}
		else if(yn.equals("N")||yn.equals("n")){
		System.out.print("\nThank you, Goodbye!");
		System.exit(0);
		}
		else{
		System.out.print("Invalid input! Please try again....\n");
		xxx();
		}
			}
	static void dep(){
		depdep: for(int i=1 ; i>0 ; i++){
		System.out.print("\tDeposit Section\n\nCurrent Balance: "+balance+"\n\nEnter amount: ");
		double de = g.nextInt();
		if(de > 10000){
			System.out.print("You can't deposit more than 10k cash, Please try again... ");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		continue depdep;
			}
		if(de%100!=0){
		System.out.print("Bawal butal dito!, Please try again... ");
		new java.util.Scanner(System.in).nextLine();
			System.out.print("\033[H\033[2J");
		continue depdep;
		}
		else{
		balance += de;
		System.out.print("\nUpdated Balance: "+balance+"\n\t....");
		xxx();
		}
		}
		}
		static void tc(){
		System.out.print("\033[H\033[2J");
		System.out.print("\tTransferring Cash Section.\n\nEnter your PIN code: ");
		int tca = g.nextInt();
		if(tca == pin || tca == manage){
			System.out.print("\nEnter amount to be transmitted: ");
			int newtc= g.nextInt();
			if(newtc %100!=0){
			System.out.print("Bawal butal dito, ulitin mo....");
			new java.util.Scanner(System.in).nextLine();
			tc();
			}
			System.out.print("\nEnter reciever's PIN code: ");
			int tca1 = g.nextInt();
			balance-=newtc;
			System.out.print("\n\nCash Transmitted Successfully!...");
			xxx();
			}
		else{
			System.out.print("\n\nIncorrect PIN code, Please try again....");
			new java.util.Scanner(System.in).nextLine();
			tc();
			}
			}
	static void cp(){
			System.out.print("\033[H\033[2J");
		System.out.print("\tChange PIN code Section.\n\nEnter old PIN code: ");
		int cd = g.nextInt();
		if(cd == pin){
			System.out.print("\nEnter new PIN code: ");
			int newpin = g.nextInt();
			System.out.print("\nRe-enter new PIN code: ");
			int np1 = g.nextInt();
			if(newpin == np1){
			pin = newpin;
			System.out.print("\n\nPIN code changed Successfully!...");
			xxx();
			}
			else{
				System.out.print("\n\nNew PIN code not matched, Please try again....");
				new java.util.Scanner(System.in).nextLine();
				cp();
				}
			}
		else{
			System.out.print("\n\nIncorrect PIN code, Please try again....");
			new java.util.Scanner(System.in).nextLine();
			cp();
			}
		}
}