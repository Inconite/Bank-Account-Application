
class Savings extends Account{
    private int SafetyDepositBoxID;
    private int SafetyDepositBoxPIN; 
    
    public Savings(String name, String sSN, double balance){
        super(1, name, sSN, balance);
        genSafetyDepositBox();
    }    
    private void genSafetyDepositBox(){
        this.SafetyDepositBoxID = (int) (Math.random() * (1000 - 100))  + 100;
        this.SafetyDepositBoxPIN = (int) (Math.random() * (10000 - 1000)) + 1000;
    }
    
    @Override
    public void setRate(){
        rate = getBaseRate() * 0.15;
    }
    
    public void showInfo(){
        super.showInfo();
        System.out.println("SafetyDepositBoxID: " + SafetyDepositBoxID + " | SafetyDepositBoxPIN: " + SafetyDepositBoxPIN);
        System.out.println();
    }
    
    
}
