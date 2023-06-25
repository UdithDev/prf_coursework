import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        loginPage();
    }
    public static void loginPage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                  LOGIN PAGE                   |");
        System.out.println("+-----------------------------------------------+");

        String validusername="Udith Dev";
        String validpassword="1234";


        Scanner scanner=new Scanner(System.in);
       
        
        boolean isLogged=false;

        while(!isLogged){
            System.out.print("User Name : ");
            String userName=scanner.nextLine();
            if(userName.equals(validusername)){
                System.out.print("Password : ");
                int password=scanner.nextInt();
                isLogged=true;
            }else{
                System.out.println("user name is invalid. please try again!"); 
            }
        }
    }
}