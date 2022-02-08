import java.util.Scanner;

public class POS {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        System.out.println("===================================================");
        System.out.println("\tWelcome to Majors Oni Restaurant!\n" + "\tWe serve best, You eat the best!\n" + "\tPoblacion, Muntinlupa City\n");
        System.out.println("===================================================");
        System.out.print("Enter customer name: ");
        String name = enter.nextLine();
        
        String [][] Menu = new String [5][2];
        //Foods
        Menu [0][0] = "Medium Bowl Ramen                ";
        Menu [1][0] = "Omelette                         ";
        Menu [2][0] = "6 pcs Siomai                     ";
        Menu [3][0] = "6 pcs Takoyaki                   ";
        Menu [4][0] = "6 pcs Sushi                      ";

        //Drinks
        Menu [0][1] = "Milkshake (Strawberry marshallow)";
        Menu [1][1] = "Milkshake (Choc Malt)            ";
        Menu [2][1] = "Milkshake (Triple Nut Caramel)   ";
        Menu [3][1] = "MilkShake (Special Ube)          ";
        Menu [4][1] = "MilkShake (Special Vanilla)      ";


        double [][] Prices = new double [5][2];
        //Foods prices
        Prices [0][0] = 150;
        Prices [1][0] = 120;
        Prices [2][0] = 60;
        Prices [3][0] = 60;
        Prices [4][0] = 120;

        //Drinks prices
        Prices [0][1] = 120;
        Prices [1][1] = 95;
        Prices [2][1] = 130;
        Prices [3][1] = 95;
        Prices [4][1] = 95;

        String [] storage = new String[10];
        double [] pstorage = new double[10];
        int [] qtty = new int [10];
        boolean exit = true;
        
        
        while (exit)
        {
            System.out.println("===================================================");
            System.out.println("Please choose your category");
            System.out.println("[1] Foods\n" + "[2] Drinks\n");
            System.out.print("Select: ");
            int input = enter.nextInt();
            int choice;
            switch (input)
            {
                case 1:
                System.out.println("-----------------------FOOD MENU-----------------------");
                System.out.println("Items \t\t\t\t" + "\t\tPrice\n");
                int counter = 0;
                int qty;

                //Display Food Menu
                for (int x = 0; x < Menu.length; x++) {
                System.out.println("["+counter + "] " + Menu[x][0] + "\t\t" + Prices[x][0]);
                counter ++;
                }

                //User selection
                System.out.println();
                System.out.print("Select: ");
                choice = enter.nextInt();
                System.out.print("Enter Quantity: ");
                qty =  enter.nextInt();

                //Stores all selected foods from the menu
                for (int i = 0; i < storage.length; i++) {
                    //Quantity checker
                    if (storage[i] != null && storage[i] == Menu[choice][0]) {
                        qtty[i] = qtty[i] + qty;
                        break;
                    }
                    if (storage[i] == null) {
                       storage[i] = Menu[choice][0];
                       qtty[i] = qty;
                    }
                   
                   else {
                       continue;
                   }
                   break;
                }

                //Stores all the prices of the selected foods from the menu
                for (int i = 0; i < pstorage.length; i++) {
                    //Multiplies the prices from its quantity
                    if (storage[i] != null && storage[i] == Menu[choice][0]) {
                        pstorage[i] = qtty[i] * Prices[choice][0];
                        break;
                    }
                    else if (pstorage[i] == 0) {
                        pstorage[i] = Prices[choice][0];
                    }
                    else {
                        continue;
                    }
                    break;
                 }
                break;

                case 2:
                System.out.println("-----------------------DRINKS MENU-----------------------");
                System.out.println("Items \t\t\t\t\t\t" + "Price\n");
                int c = 0;
                int q;

                //Display drinks menu
                for (int x = 0; x < Menu.length; x++) {
                    for (int y = 1; y < Menu[x].length; y++) {
                        System.out.println("["+ c+"] " + Menu[x][y] + "\t\t" + Prices[x][1]);
                        c++;
                    }
                }

                //User selection
                System.out.println();
                System.out.print("Select: ");
                choice = enter.nextInt();
                System.out.print("Enter Quantity: ");
                q = enter.nextInt();

                //Stores all selected drinks to this array
                for (int i = 0; i < storage.length; i++) {
                    //Quantity checker
                    if (storage[i] != null && storage[i] == Menu[choice][1]) {
                        qtty[i] = qtty[i] + q; 
                        break;
                    }
                   if (storage[i] == null) {
                       storage[i] = Menu[choice][1];
                       qtty[i] = q;
                   }
                   else {
                       continue;
                   }
                   break;
                }

                //Stores all the prices of the selected drinks to this array
                for (int i = 0; i < pstorage.length; i++) {
                    //Multiplies its price to its quantity
                    if (storage[i] != null && storage[i] == Menu[choice][1]) {
                        pstorage[i] = qtty[i] * Prices[choice][1];
                        break;
                    }
                    if (pstorage[i] == 0) {
                        pstorage[i] = Prices[choice][1];
                    }
                    else {
                        continue;
                    }
                    break;
                 }
                break;
                default:
                System.out.println("Something went wrong, the program has stoppped");
                break;
            }

            String ans;
            System.out.println();
            System.out.print("Would you like to add another order?\n" + "[Y][N]: ");
            ans = enter.next();

            //Repeats the loop
            if (ans.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                break;
            }
        }

        System.out.println("====================================================================");
        System.out.println("Your order(s) \t\t\t\t\t" + "Qty.\t" + "Total Price\n");
        
        //Prints all selected items 
        for (int x = 0; x < 10; x++) {
            if(storage[x] == null) {
                continue;
            }
            System.out.print(storage[x] + "\t\t");
            if (pstorage[x] == 0) {
                continue;
            }
            System.out.print(qtty[x] + "\t");
            System.out.println(pstorage[x]);
        }

        //Computes the total price
        double total = 0;
        for (int i = 0; i < pstorage.length; i++) {
            total += pstorage[i];
        } 

        System.out.println();
        System.out.println("Total: \t\t\t\t\t\t\t" + total);
        double change;
        double temp = 0;

        //Tax computattion
        for (int x = 0; x < pstorage.length; x++) {
            pstorage[x] *= (1 + 0.12);
            temp += pstorage[x];
        }
        
        double tax = temp - total;
        double grossP = total + tax;
        double Total = Math.round(grossP*100.0)/100.0;
        double payment;
        System.out.println("---------------------TAX INFO--------------------");
        System.out.println("Before Tax: \t\t\t" + total);
        System.out.printf("Tax (VAT): \t\t\t%.2f\n" , tax);
        System.out.printf("Total: \t\t\t\t%.2f\n" , Total);
        System.out.println("---------------------PAYMENT---------------------");
        System.out.print("Enter amount for payment: \t" );
        payment = enter.nextDouble();
        if (payment < Total) {
            System.out.println("Not enough funds");
            System.out.println("Please try again");
            System.out.print("Enter amount of payment: \t" );
            payment = enter.nextDouble();
        }
        change = payment - Total;
        System.out.printf("Your change: \t\t\t%.2f\n" , change);
        System.out.println("===================================================");
        System.out.println("\tThank you for coming " + name + "! \n" +"\tHave a great day ahead!\n");
        enter.close();
    }
}
