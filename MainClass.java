import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        loginPage();
    }
    public static void loginPage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                  LOGIN PAGE                   |");
        System.out.println("+-----------------------------------------------+");

        String validUsername="Udith Dev";
        String validPassword="1234";
        
        
        Scanner scanner=new Scanner(System.in);

        boolean isLogged=true;

        while(isLogged){
            System.out.print("User Name : ");
            String userName=scanner.nextLine();

            if(userName.equals(validUsername)){
                while (true){
                    System.out.print("Password : ");
                    String password=scanner.nextLine();
                    if(password.equals(validPassword)) {
                        homePage();
                        isLogged = false;
                        
                        break;
                    }else{
                        System.out.println("password  is incorrect. please try again!");
                    }
                }
            }else{
                System.out.println("user name is invalid. please try again!");
            }
        }
        scanner.close();
    
    }

    public static void homePage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|       WELCOME TO IJSE STOCK MANAGMENT SYSTEM  |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Change the credintials\t\t\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t\t\t[4] Log out\n[5] Exit the system");

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter an option to continue > ");
        int option=scanner.nextInt();
        scanner.close();

        switch(option){
            case 1: chnageTheCredintials();
            break;

            case 2: supplierMnage();
            break;

            case 3:
            break;

            case 4:
            break;

            case 5:
            break;
        }
        
    }

    public static void chnageTheCredintials(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                CREDENTIAL MANAGE              |");
        System.out.println("+-----------------------------------------------+");

        Scanner scanner=new Scanner(System.in);
        try {
            System.out.print(" please enter the user name  to verify it's you :  ");
        String userName_2 =scanner.nextLine();

        if(userName_2.equals("Udith Dev")){
            System.out.println("Hey Udith Dev");
        }else{
            System.out.println("invalid user name.try again!");
        }
            
        } catch (Exception e) {
            
        }
        scanner.close();
        
    }

   
    public static void supplierMnage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                SUPPLIAR MANAGE                |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Add Supplier\t\t\t\t[2] Update Supplier\n[3] Delete Supplier\t\t\t\t[4] View Supplier\n[5] Search Supplier\t\t\t\t[6] Home Page");

    }
}