import java.util.Scanner;

public class MainClass {
    static Scanner scanner=new Scanner(System.in);
    static String validUsername="UdithDev";
    static String validPassword="1234";
    public static void main(String[] args) {
        loginPage();
    }
    public static void loginPage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                  LOGIN PAGE                   |");
        System.out.println("+-----------------------------------------------+");

      
        


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

            case 5: System.exit(0); 
            break;

            default: System.out.println("Invalid choice!");
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
                    String newPassword=scanner.next();
                    validPassword=newPassword;
                    System.out.print("Password Change successfully! Do you want to go home page (Y/N)? : ");
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

        System.out.print("Enter an option to continue > ");
        int option=scanner.nextInt();

        switch(option){

            case 1: addSupplier();
            break;

            case 2:
            break;
        }

    }

    public static void stockManage() {

    }

    public static void logOut() {
        loginPage();
        
    }

    public static void addSupplier(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                ADD SUPPLIER                   |");
        System.out.println("+-----------------------------------------------+");

        String supplier[][]=new String[5][2];


       System.out.print("supplier ID : ");
        String supplierId=scanner.next();

        supplier[0][0]=supplierId;

        System.out.print("supplier Name : ");
        String supplierName=scanner.next();

        supplier[0][1]=supplierName;

        System.out.println(supplier[0][0]);
        System.out.println(supplier[0][1]);

        
        

        System.out.println("added successfully! Do you want to add another supplier(y/n)? : ");
        String answer=scanner.next();


    }
}