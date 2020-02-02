import java.io.*;
import java.util.*;


public class Main{
	public static void main(String[] args) throws IOException{
	    List<String[]> customers = new ArrayList();
		File file = new File("input.txt");
		
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
		    String[] content = sc.nextLine().split(", ");
		    customers.add(content);
		}
		sc.close();
		
		List<Account> bankAccounts = new ArrayList();
		for(int i = 0; i < customers.size(); i++){
		    if(customers.get(i)[1].equals("Savings") && customers.get(i).length == 4){
		        bankAccounts.add(new Savings(customers.get(i)[0], customers.get(i)[2], Double.parseDouble(customers.get(i)[3])));
		        System.out.println("Savings Account was created for the customer: " + customers.get(i)[0]);
		    }
		    else if(customers.get(i)[1].equals("Checking") && customers.get(i).length == 4) {
		        bankAccounts.add(new Checking(customers.get(i)[0], customers.get(i)[2], Double.parseDouble(customers.get(i)[3])));
		        System.out.println("Checking Account was created for the customer: " + customers.get(i)[0]);
		    }
		    else{
		        System.out.println("Error reading the Account info.");
		    }
	    }
	    
	    
	    
	   // for(Account a: bankAccounts){
	   //     a.showBalance();
	   // }
	    
	   // bankAccounts.get(0).showBalance();
    //     bankAccounts.get(0).deposit(100);
    //     bankAccounts.get(0).withdraw(100);
        
        // bankAccounts.get(0).withdraw(1000);
        // bankAccounts.get(0).transfer(1010, bankAccounts.get(1));
        
        // System.out.println("Total Bank Accounts: " + bankAccounts.size());


// 		Savings s1 = new Savings("Goku", "125632541", 100);
// 		Checking c1 = new Checking("Gohan", "125632542", 100);
// 		Savings s2 = new Savings("Vegeta", "125632545", 1000);
		
// 		s1.showInfo();
// 		s2.showInfo();
// 		c1.showInfo();
		
// 		s1.deposit(100);
// 		s1.withdraw(50);
// 		s1.transfer(50, c1);
		
// 		c1.setCompoundInterest();
// 		c1.showInfo();
		
// 		FileWriter writer = new FileWriter("output.txt");
// 		writer.write(content);
// 		writer.close();

	}
}
