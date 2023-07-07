import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    static Scanner scanner=new Scanner(System.in);
    static String validUsername="UdithDev";
    static String validPassword="1234";
    static String supplier[][]=new String[0][2];
    public static void main(String[] args) {
        loginPage();
    }
    public static void loginPage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                  LOGIN PAGE                   |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

      
        


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
            case 1: 
            clearConsole();
            chnageTheCredintials();
            break;

            case 2:
            clearConsole();
             supplierManage();
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

   
    public static void supplierManage(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                SUPPLIAR MANAGE                |");
        System.out.println("+-----------------------------------------------+");

        System.out.println("[1] Add Supplier\t\t\t\t[2] Update Supplier\n[3] Delete Supplier\t\t\t\t[4] View Supplier\n[5] Search Supplier\t\t\t\t[6] Home Page");

        System.out.print("Enter an option to continue > ");
        int option=scanner.nextInt();

        switch(option){

            case 1: addSupplier();
            break;

            case 2:updateSupplier();
            break;

            case 3: deleteSupplier();
            break;

            case 4: viewSupplier();
            break;

            case 5: searchSupplier();
            break;

            default:
                System.out.println("Invalid choice!");
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


        while (true) {
            System.out.print("Supplier Id : ");
            String supplierId = scanner.next();

            boolean duplicate=checkDuplicate(supplierId);
            if(duplicate==true){
                System.out.println("already exists : try another supplier id !");
            }else if(duplicate==false){
                 System.out.print("Supplier Name : ");
                 String supplierName = scanner.next();
                 extendSupplier(supplierId,supplierName);

                  System.out.print("added successfully ! Do you want to add another supplier (Y/N) ? ");
                  char answer = scanner.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                clearConsole();
                addSupplier();
            } else if (answer == 'n' || answer == 'N') {
                clearConsole();
                supplierManage();
                break;
            }

            }

           
           


           
        } 
        return;
    }
    public static void updateSupplier() {

    }

    public static void deleteSupplier() {

    }

    public static void viewSupplier() {

    }

    public static void searchSupplier() {

    }


    public static void extendSupplier(String id, String name){ //Assign temp array values        
            String[][] temp = new String[supplier.length+1][2];

            for (int i = 0; i < supplier.length; i++) {
                for (int j = 0; j < supplier[i].length; j++) {
                    temp[i][j]= supplier[i][j];
                }
            }
            supplier = temp;


            supplier[supplier.length-1][0] = id;   ///// ?????????????????????????   explain
            supplier[supplier.length-1][1]=name;
            System.out.println(Arrays.deepToString(supplier));

    }

    public static boolean checkDuplicate(String id){
        for(int i =0; i<supplier.length; i++){
            if(supplier[i][0].equals(id)){
                return true;
            }
        }
        return false;
    }

    public final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
//handle the exception
            System.err.println(e.getMessage());
        }
    }
}