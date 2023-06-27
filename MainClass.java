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
                homePage();
            }else{
                System.out.println("user name is invalid. please try again!"); 
            }
        }
    }

    public static void homePage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|       WELCOME TO IJSE STOCK MANAGMENT SYSTEM  |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Change the credintials\t\t\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t\t\t[4] Log out\n[5] Exit the system");
    }
}