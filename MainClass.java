import java.util.Scanner;

public class MainClass {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        loginPage();
    }
    public static void loginPage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                  LOGIN PAGE                   |");
        System.out.println("+-----------------------------------------------+");

        String validUsername="UdithDev";
        String validPassword="1234";
        


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
      
    
    }

    public static void homePage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|       WELCOME TO IJSE STOCK MANAGMENT SYSTEM  |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Change the credintials\t\t\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t\t\t[4] Log out\n[5] Exit the system");

        

        System.out.print("Enter an option to continue > ");
        int option=scanner.nextInt();
       // scanner.close();

        switch(option){
            case 1: chnageTheCredintials();
            break;

            case 2: supplierMnage();
            break;

            case 3: stockManage();
            break;

            case 4: logOut();
            break;

            case 5:exitTheSystem();
            break;
        }
        
    }

    
    public static void chnageTheCredintials(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                CREDENTIAL MANAGE              |");
        System.out.println("+-----------------------------------------------+");

        System.out.println();

        boolean passwordChange=true;
        while(passwordChange){
            System.out.print(" please enter the user name  to verify it's you :  ");
            String userName=scanner.next();
            if(userName.equals("UdithDev")){
                System.out.println("Hey UdithDev");

                while(true){
                    System.out.print(" Enter your current password :  ");
                    String password=scanner.next();
                    if(password.equals("1234")){
                    System.out.print("Enter Your new Password : ");
                    String validPassword=scanner.next();
                    System.out.print("Password Change successfully! Do you want to go home page (Y/N): ");
                    String answer=scanner.next();
                    if(answer.equals("y")){
                        homePage();
                    }else if(userName.equals("n")){
                        chnageTheCredintials();
                    }
                    passwordChange=false;
                    break;
                    }else{
                        System.out.println(" incorrect password. try again!");
                        
                    }
                }
            }else{
                System.out.println("invalid user name. try again");
            }
        }  
    }

   
    public static void supplierMnage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                SUPPLIAR MANAGE                |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Add Supplier\t\t\t\t[2] Update Supplier\n[3] Delete Supplier\t\t\t\t[4] View Supplier\n[5] Search Supplier\t\t\t\t[6] Home Page");

    }

    public static void stockManage() {
        
    }

    public static void logOut() {
        
    }

    public static void exitTheSystem() {
        
    }
}