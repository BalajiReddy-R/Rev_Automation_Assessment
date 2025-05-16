package Question1_BasicJavaConcepts;

public class Question1_BasicJavaConcepts {
    public static void main(String[] args) {
        int sum= addNumber(19,21);
        System.out.println("The Sum of two numbers are..."+sum);
        int diff= subNumber(20,100);
        System.out.println("The Diff of two numbers are..."+diff);
        int prod= mulNumber(20,10);
        System.out.println("The Product of two numbers are..."+prod);
        int div= divNumber(10,100);
        System.out.println("The Div of two numbers are..."+div);
        int errorHandlingDiv= errHandlingDivNumber(0,100);
        System.out.println("The Div of two numbers in errorHandling are..."+errorHandlingDiv);
    }
    public static int addNumber(int a,int b)
    {
        return a+b;
    }
    public static int subNumber(int a,int b)
    {
        return b-a;
    }
    public static int mulNumber(int a,int b)
    {
        return a*b;
    }
    public static int divNumber(int a,int b)
    {
        return b/a;
    }
    public static int errHandlingDivNumber(int a,int b)
    {
        if (a==0){
            System.out.println("A Number Divided by 0 is not possible...");
            return 0;
        }
        return b/a;
    }
}