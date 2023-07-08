import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    static Scanner scanner=new Scanner(System.in);
    static String validUsername="UdithDev";
    static String validPassword="1234";
    static String supplier[][]=new String[0][2];
    static String item[][] = new String[0][6];
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
        clearConsole();
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
            System.out.println();
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

            case 1: 
            clearConsole();
            addSupplier();
            break;

            case 2:
            clearConsole();
            updateSupplier();
            break;

            case 3: deleteSupplier();
            break;

            case 4: viewSupplier();
            break;

            case 5: searchSupplier();
            break;

            case 6: homePage();
            break;

            default:
                System.out.println("Invalid choice!");
            break;
        }

    }

    public static void stockManage() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                STOCK MANAGE                   |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        System.out.println("[1] Manage Item Categories\t\t\t\t[2] Add Item\n[3] Get Item Supplier Wise\t\t\t\t[4] View Items\n[5] Rank Item per Unit Price\t\t\t\t[6] Home Page");

        System.out.print("Enter an option to continue > ");
        int option=scanner.nextInt();

        switch(option){

            case 1: clearConsole();
             manageItemCategories();
            break;

            case 2: clearConsole();
            addItem();
            break;

            case 3: clearConsole();
            getItemSupplierWise();
            break;

        }
    }
    public static void getItemSupplierWise(){
        System.out.println("+-----------------------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\t\t\t\t\tSEARCH ITEM SUPPLIER WISE\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.print("Enter the Supplier ID: ");
            String id = scanner.next();
            String name = "";
    
            for (int i = 0; i < supplier.length; i++) {
                if (supplier[i][0].equals(id)) {
                    name = supplier[i][1];
                    break;
                }
            }
    
            System.out.println("Supplier Name: "+name);
            System.out.println();
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("|\tItem ID\t\t|\tDescription\t\t|\tUnit Price\t|\tQty on Hand\t|");
            System.out.println("+-------------------------------------------------------------------+");
    
            for (int i = 0; i < item.length; i++) {
                if (item[i][5].equals(id)) {
                    System.out.printf("|\t%-10s\t|\t%-18s\b\b|\t%-10s\t|\t%-12s\b |\n", item[i][0], item[i][1], item[i][2], item[i][3]);
                }
            }
    
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println();
            System.out.print("Search successfully! ");
            System.out.print("Do you want to search another item (Y/N)? ");
            String answer = scanner.next();
    
    
            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                getItemSupplierWise();
            } else if (answer.equalsIgnoreCase("N")) {
                clearConsole();
                stockManage();
            }

    }
    
    public static void addItem(){
        boolean categories = false;

        for (int i = 0; i < item.length-1; i++) {
            if (item[i][4] != null) {
                categories=true;
                break;
            }
        }

        boolean suppliers = false;

        for (int i = 0; i < supplier.length-1; i++) {
            if (supplier[i][0] != null) {
                suppliers=true;
                break;
            }
        }

        if (!categories) {
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\t\t\t\t\t\tADD ITEM\t\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("OOPS! It seems that you don't have any item categories in the system.");
            System.out.print("Do you want to add a new item category? (Y/N) ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                addNewItemCategory();
            } else if (answer.equalsIgnoreCase("N")) {
                clearConsole();
                stockManage();
            }
        } else if (!suppliers) {
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\t\t\t\t\t\tADD ITEM\t\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("OOPS! It seems that you don't have any item suppliers in the system.");
            System.out.print("Do you want to add a new supplier category? (Y/N) ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                addSupplier();
            } else if (answer.equalsIgnoreCase("N")) {
                clearConsole();
                stockManage();
            }
        } else {
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("|\t\t\t\t\t\t\t\t\tADD ITEM\t\t\t\t\t\t\t\t\t\t\t|");
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println();

            System.out.print("Item id: ");
            String id = scanner.next();
            System.out.println();

            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|\t #\t\t\t|\tSupplier ID\t\t\t|\tSupplier Name\t\t|");
            System.out.println("+---------------------------------------------------------------+");

            for (int i = 0; i < supplier.length; i++) {
                System.out.printf("|\t %-10s |\t%-18s\t|\t%-18s\t|\n", (i+1), supplier[i][0], supplier[i][1]);
            }

            System.out.println("+---------------------------------------------------------------+");
            System.out.println();
            System.out.print("Enter the Supplier number > ");
            int supplierNumber = scanner.nextInt();

            if (supplierNumber > 0 && supplierNumber <= supplier.length) {                                      ///////////////////////////////////////////////
                String supplierId = supplier[supplierNumber-1][0];

                System.out.println("+-------------------------------------------+");
                System.out.println("|\t #\t\t\t|\tCategory name\t\t\t|");
                System.out.println("+-------------------------------------------+");

                for (int k = 0; k < item.length; k++) {
                    System.out.printf("|\t %-10s |\t%-18s\t\t|\n", (k+1), item[k][4]);
                }

                System.out.println("+-------------------------------------------+");
                System.out.println();
                System.out.print("Enter the Category number > ");
                int categoryNumber = scanner.nextInt();

                if (categoryNumber > 0 && categoryNumber <= item.length) {
                    String category = item[categoryNumber-1][4];

                    System.out.print("Description: ");
                    String description = scanner.next();
                    System.out.println();
                    System.out.print("Unit Price: ");
                    String unitPrice = scanner.next();
                    System.out.println();
                    System.out.print("Qty on hand: ");
                    String qty = scanner.next();
                    System.out.println();

                    item[item.length-1][0] = id;
                    item[item.length-1][1] = description;
                    item[item.length-1][2] = unitPrice;
                    item[item.length-1][3] = qty;
                    item[item.length-1][4] = category;
                    item[item.length-1][5] = supplierId;

                    System.out.print(item[item.length-1][0]+", ");
                    System.out.print(item[item.length-1][1]+", ");
                    System.out.print(item[item.length-1][2]+", ");
                    System.out.print(item[item.length-1][3]+", ");
                    System.out.print(item[item.length-1][4]+", ");
                    System.out.print(item[item.length-1][5]);
                    System.out.println();

                    addItemExtend(id, description, unitPrice, qty, category);

                    System.out.println("Added successfully!");
                    System.out.print("Do you want to add another Item (Y/N)? ");
                    String answer = scanner.next();

                    if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("y")) {
                        clearConsole();
                        addItem();
                    } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("n")) {
                        clearConsole();
                        stockManage();
                    }
                }
            }
        }        
    }
    public static void manageItemCategories(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                MANAGE ITEM CATEGORIES         |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();
            

       System.out.println("[1] Add New  Item Category\t\t\t\t[2] Delete Item Category\n[3] Update Item Catogery\t\t\t\t[4] Stock Management");

       System.out.print("Enter an option to continue > ");
       int option=scanner.nextInt();

       switch(option){

        case 1 : clearConsole();
        addNewItemCategory();
        break;
        case 2:clearConsole();
         deleteItemCategory();
        break;

        case 3:clearConsole();
         updateItemCategory();
        break;

        case 4 :clearConsole();
         supplierManage();
        break;


       }
    }

  
    public static void addNewItemCategory() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                ADD NEW ITEM CATEGORY          |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while (true) {
            System.out.print("Enter the new item category : ");
            String category = scanner.next();

            addItemExtend("","","","",category);

            System.out.println();
            System.out.println("For test only !!! "+Arrays.toString(item));

            System.out.print("Added successfully! ");
            System.out.print("Do you want to add another category(Y/N) ? ");
            String answer = scanner.next();

            System.out.println(item.length);
            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                addNewItemCategory();
                break;
            }
            if (answer.equalsIgnoreCase("N")) {
                clearConsole();
                stockManage();
                break;
            }
        } 
    }
    public static void addItemExtend(String id, String desc, String unitPrice, String Qty, String Category) {
        String[][] temp = new String[item.length+1][6];

        for (int i = 0; i < item.length; i++) {
            for (int j = 0; j < item[i].length; j++) {
                temp[i][j] = item[i][j];
            }
        }
        temp[item.length][0] = id;
        temp[item.length][1] = desc;
        temp[item.length][2] = unitPrice;
        temp[item.length][3] = Qty;
        temp[item.length][4] = Category;
        temp[item.length][5] = "";
        item = temp;
    }
    public static void deleteItemCategory(){
        int countDelete=0;
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                DELETE ITEM CATEGORY           |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while (true) {
            System.out.print("Item Category: ");
            String id = scanner.next();

            boolean flagSupplierID = checkCategory(id);

            if (flagSupplierID==true) {
                for (int i = 0; i < item.length; i++) {        //delete countt eka ganima
                    if (item[i][4].equals(id)) {
                        countDelete++;
                    }
                }
                String[][] deleteItem = new String[item.length-countDelete][5];       //delete karata passe thiyana items daa ganimata array ekk hadaganima
                int count = 0;

                for (int j = 0; j < item.length; j++) {
                    if (!item[j][4].equals(id)) {                       //category value (item[j][4]) is not equal to the specified id.
                        deleteItem[count] = item[j];
                        count++;
                    }
                }
                item = deleteItem;
                System.out.println("Deleted successfully!");
                System.out.print("Do you want to delete another (Y/N)? ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("Y")) {
                    clearConsole();
                    deleteItemCategory();
                    break;
                }
                if (answer.equalsIgnoreCase("N")) {
                    clearConsole();
                    stockManage();
                    break;
                }
            }
            if (flagSupplierID == false){
                System.out.println("Can't find Item Category. Try again!");
            }
        }

    }
    public static boolean checkCategory(String id) {
        for (int i = 0; i < item.length; i++) {
            if (item[i][4].equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static void updateItemCategory(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                UPDATE ITEM CATEGORY           |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();


        while (true){
            System.out.print("Item Category : ");
            String Category = scanner.next();
//            boolean duplicate = checkDuplicate(Category);
            boolean flagCategory = checkCategory(Category);

            if (flagCategory==false) {
                System.out.println("can't find Item Category. try again!");
            }
            if (flagCategory==true) {
                System.out.print(" Update Item Category :");
                String updateCategory = scanner.next();
                for (int i = 0; i < item.length; i++) {
                    if (item[i][4].equals(Category)) {
                        item[i][4] = updateCategory;
                    }
                }
                System.out.println("updated successfully! ");
            }

            System.out.print("Do you want to updated another(Y/N) ? ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                updateItemCategory();
                break;
            }
            if (answer.equalsIgnoreCase("N")) {
                clearConsole();
                manageItemCategories();
                break;
            }
        }

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
    }
    public static void updateSupplier() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                UPDATE SUPPLIER                |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while(true){
            System.out.print("Supplier Id : ");
            String supplierId=scanner.next();

            boolean duplicate=checkDuplicate(supplierId);
            if(duplicate==false){
                System.out.println("can't find supplier id. try again !");

            }
            for(int i=0; i<supplier.length; i++){
                if(duplicate==true && supplierId.equals(supplier[i][0])){
                    System.out.println("Supplier Name: " + supplier[i][1]);
                    System.out.print("Enter the new supplier Name :  ");
                    String newName=scanner.next();

                    for (int j = 0; j < supplier.length; j++) {
                        if (supplierId.equals(supplier[j][0])) {
                            supplier[j][1]=newName;
                        }
                    }
                    System.out.println(Arrays.deepToString(supplier));
                    System.out.print("Update succesfully! Do you want update another suupplier (Y/N) ? : ");
                    String answer=scanner.next();
                    if (answer.equals("Y")||answer.equals("y")) {
                        clearConsole();
                        updateSupplier();;
                        break;
                    }else if(answer.equals("N")||answer.equals("n")){
                        clearConsole();
                        supplierManage();
                    }

                }
            }
        }
    }

    public static void deleteSupplier() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                DELETE SUPPLIER                |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while (true) {
            int countDelete = 0;
            System.out.print("Supplier id: ");
            String id = scanner.next();

            boolean flagSupplierID = supplierIdCheck(id);

            if (flagSupplierID==true) {
                for (int i = 0; i < supplier.length; i++) {
                    if (supplier[i][0].equals(id)) {
                        countDelete++;
                    }
                }
                String[][] NewSuppliers = new String[supplier.length-countDelete][2];

                int count = 0;
                for (int j = 0; j < supplier.length; j++) {
                    if (!supplier[j][0].equals(id)) {
                        NewSuppliers[count] = supplier[j];
                        count++;
                    }
                }
                supplier = NewSuppliers;
                System.out.println("Deleted successfully!");
                System.out.print("Do you want to delete another (Y/N)? ");
                String answer = scanner.next();
                if (answer.equals("Y")) {
                    clearConsole();
                    deleteSupplier();
                    break;
                }
                if (answer.equals("N") ) {
                    clearConsole();
                    supplierManage();
                    break;
                }
            }
            if (flagSupplierID == false) {
                System.out.println("Cannot find supplier ID. Try again!");
            }
        }
    }

    public static boolean supplierIdCheck(String id){

        for(int i=0; i<supplier.length; i++ ){
            if(id.equals(supplier[i][0])){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public static void viewSupplier() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                   VIEW SUPPLIER               |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while (true){
            System.out.println();
            System.out.println("+-----------------------------------------------+");
            System.out.println("|\tSupplier ID\t\t|      Supplier Name\t\t      |");
            System.out.println("+-----------------------------------------------+");
            for (int i = 0; i < supplier.length; i++) {
                System.out.printf("|\t%-12s\t|\t\t%-14s\t\t|\n", supplier[i][0], supplier[i][1]);
            }
            System.out.println("+-----------------------------------------------+");

            System.out.println();
            System.out.print("Do you want to go supplier manage page(Y/N) ? ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                clearConsole();
                supplierManage();
                break;
            }else if(answer.equalsIgnoreCase("N")){
                clearConsole();
            }
        }
    }

    public static void searchSupplier() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                SEARCH SUPPLIER                |");
        System.out.println("+-----------------------------------------------+");
        System.out.println();

        while (true) {
            System.out.print("Supplier ID: ");
            String supplierId = scanner.next();

            boolean isSearch=false;

            for (int i = 0; i < supplier.length; i++) {
                if (supplierId.equals(supplier[i][0])) {
                    System.out.println("Supplier Name: " + supplier[i][1]);
                    isSearch = true;
                    System.out.print("Search successfully! ");
                    System.out.print("Do you want to Search another(Y/N) ? ");
                    supplierId = scanner.next();

                    if (supplierId.equals("Y")|| supplierId.equals("y")) {
                        clearConsole();
                        searchSupplier();
                        break;
                    }
                    if (supplierId.equals("N")||supplierId.equals("n")) {
                        clearConsole();
                        supplierManage();
                        break;
                    }
                }
            }
            if (isSearch==false) {
                System.out.println("can't find supplier id. try again!");
            } else {
                //break;
            }
        }

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