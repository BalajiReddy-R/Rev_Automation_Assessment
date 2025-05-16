package Question3_ExceptionHandling;

public class CreateBankAccount
{
    private double balance=0;

    public static void main(String[] args) {
        CreateBankAccount account=new CreateBankAccount();
        try
        {
            account.depositAmount(5000);
//            account.availableBalance();
            account.withdrawAmount(2000);
            account.availableBalance();
            account.depositAmount(-1000);
            account.availableBalance();
        }
        catch (IllegalArgumentException e)
        {
           System.out.println("Error Message..."+e.getMessage());
        }
        try
        {
            account.withdrawAmount(7000);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error Message..."+e.getMessage());
        }
        account.availableBalance();
    }

    public void depositAmount(double amount)
    {
        System.out.println("Method to validate +ve & -ve Deposit Scenario ");
        if(amount<0)
        {
            throw new IllegalArgumentException("\u001B[31m Negative Amount Cannot be Deposited\u001B[0m");
        }
        balance +=amount;
        System.out.println("\u001B[32m Deposited Amount Is...\u001B[0m "+amount);
    }
    public void withdrawAmount(double amount)
    {
        System.out.println("Method to validate WithDraw higher amount than balance ");
        if(amount>balance)
        {
            throw new IllegalArgumentException("\u001B[31m Due to Insufficient balance withdrawal is not Possible\u001B[0m");
        }
        balance -=amount;
        System.out.println("\u001B[32m WithDrawn Amount is...\u001B[0m"+amount);

    }
    public void availableBalance()
    {
        System.out.println("\u001B[34m Your Available Balance...\u001B[0m"+balance);
    }



}
