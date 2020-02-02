
class Checking extends Account{
    private long debitCardNumber;
    private int debitCardPIN;

    public Checking(String name, String sSN, double balance){
        super(2, name, sSN, balance);
        genDebitCard();
    }
    
    private void genDebitCard(){
        this.debitCardNumber = (long) (Math.random() * (Math.pow(10, 12) - Math.pow(10, 11))  + Math.pow(10, 11));
        this.debitCardPIN = (int) (Math.random() * (10000 - 1000)) + 1000;
    }
    
    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;
    }
    
    public void showInfo(){
        setRate();
        super.showInfo();
        System.out.println("DebitCardNumber: " + debitCardNumber + " | DebitCardPIN: " + debitCardPIN);
        System.out.println();
    }
}
