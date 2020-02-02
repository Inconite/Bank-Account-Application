
abstract class Account implements IBaseRate{
    private String name;
    private String sSN;
    private int accTypeID; //1 for Savings; 2 for Checking
    private String accTypeName;
    private String accNumber;
    private double balance;
    private static int uniqueID = 10000;
    double rate;
    
    public abstract void setRate();
    
    //creates Savings/Checking account for the customer
    Account(int accTypeID, String name, String sSN, double balance){
        this.accTypeID = accTypeID;
        this.name = name;
        this.sSN = sSN;
        this.balance = balance;
        
        if(accTypeID == 1)  this.accTypeName = "Savings";
        else this.accTypeName = "Checking";
        //System.out.print("NAME: " + name + " | SSN ID: " + sSN + " | BALANCE: " + balance + " Zeni | ");
        genAccountNumber(accTypeID);
        //System.out.println("ACCOUNT NUMBER: " + accNumber);
        setRate();
    }
    
    //generates Account number
    private void genAccountNumber(int accTypeID){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int rand = (int) (Math.random() * 1000);
        this.accNumber = accTypeID + lastTwoOfSSN + ++uniqueID + rand;
    }
    
    //handles deposit transaction
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit Successful");
            showBalance();
        }
        else{
            System.out.println("Deposit FAILED: amount cannot be negative or zero.");
        }
    }
    
    //handles withdraw transaction
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Withdrawal FAILED: Insufficient Balance: " + balance);
        }
        else{
            balance -= amount;
            System.out.println("Withdrawal Successful");
            showBalance();
        }
    }
    
    //handles balance transfer from one customer to another
    public void transfer(double amount, Account a){
        if(amount > balance){
            System.out.println("Transfer FAILED: Insufficient Balance: " + balance);
        }
        else{
            balance -= amount;
            a.balance += amount;
            System.out.println("Transfer Successful");
            showBalance();
        }
    }
    
    //displays balance
    public void showBalance(){
        System.out.println("Your Balance: " + balance + "\n");
    }
    
    //generates compount interest
    public void setCompoundInterest(){
        double compoundInterest = balance * rate/100.0;
        balance += compoundInterest;
    }
    
    //displays the customer account info
    public void showInfo(){
        System.out.println("NAME: " + name + " | ACCOUNT TYPE: " + accTypeName + " | ACCOUNT NUMBER: " + accNumber +
        " | BALANCE: " + balance + " Zeni | RATE: " + rate + "%");
    }
    
}
