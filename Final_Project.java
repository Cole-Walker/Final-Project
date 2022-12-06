package com.mycompany.final_project;
import java.util.ArrayList;
import java.util.Scanner;

public class Final_Project 
{
    public static void main(String[] args) 
    {
        
        ArrayList<Double> salesArray = new ArrayList<>();
        ArrayList<Double> purchArray = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int response;
        int userResponse;
        int adminResponse;
        
        do 
        {
            System.out.println("\n\n\n\n----------------------------");
            System.out.println("Make a selection (enter 1, 2, or 3)");
            System.out.println("1. User Functions");
            System.out.println("2. Admin Functions");
            System.out.println("3. Quit");
            System.out.println("----------------------------");
            System.out.print("Enter selection: ");
            
            response = sc.nextInt();
            
            // User menu
            if (response == 1)
            {
                do 
                {
                    System.out.println("\n\n\n\n----------------------------");
                    System.out.println("Make a selection (enter 1, 2, 3, or 4)");
                    System.out.println("1. Calculate board footage");
                    System.out.println("2. Enter log sales records");
                    System.out.println("3. Enter log purchase records");
                    System.out.println("4. Return to main menu");
                    System.out.println("----------------------------");
                    System.out.print("Enter selection: ");
            
                    userResponse = sc.nextInt();
                    
                    // 1. Calculate board footage
                    if (userResponse == 1)
                    {
                        int len;
                        double dia;
                        
                        do 
                        {
                            System.out.println("\n\n\n\n----------------------------");
                            System.out.println("Enter length and diameter separated by a space \nEnter a single 0 to quit");
                            System.out.println("----------------------------");
                            len = sc.nextInt();
                            
                            if (len != 0)
                            {
                                dia = sc.nextInt();
                                System.out.println("Board footage: " + doyleScale(len, dia));
                            }
                        }
                        while (len != 0);  
                    }
                    
                    // 2. Enter log SALES records
                    if (userResponse == 2)
                    {
                        double amount;
                        
                        do
                        {
                            System.out.println("\n\n\n\n----------------------------");
                            System.out.println("Enter the total amount of an individual sale \nEnter a single 0 to quit");
                            System.out.println("----------------------------");
                            amount = sc.nextDouble();
                            
                            if (amount != 0)
                            {
                                salesArray.add(amount);
                            }
                        }
                        while (amount != 0);
                    }
                    
                    // 3. Enter log purchase records
                    if (userResponse == 3)
                    {
                        double amount;
                        
                        do
                        {
                            System.out.println("\n\n\n\n----------------------------");
                            System.out.println("Enter the total amount of an individual purchase (separate by a space for more than one sale) \nEnter a single 0 to quit");
                            System.out.println("----------------------------");
                            amount = sc.nextDouble();
                            
                            if (amount != 0)
                            {
                                purchArray.add(amount);
                            }
                        }
                        while (amount != 0);
                    }  
                }
                while (userResponse != 4);
            }
            // End user menu
            
            // --------------------------------------------------------------------------------------------- :)
            
            // Admin menu
            else if (response == 2)
            {
                do 
                {
                    System.out.println("\n\n\n\n----------------------------");
                    System.out.println("Make a selection (enter 1, 2, or 3)");
                    System.out.println("1. List/audit all timber transactions");
                    System.out.println("2. Get revenue and expenses");
                    System.out.println("3. Return to main menu");
                    System.out.println("----------------------------");
                    System.out.print("Enter selection: ");
            
                    adminResponse = sc.nextInt();
                    
                    // 1. List/audit all timber transactions
                    if (adminResponse == 1)
                    {
                        for (double audit: purchArray)
                        {
                            System.out.println(audit);
                        }  
                    }
                    
                    // 2. Get revenue and expenses
                    if (adminResponse == 2)
                    {
                        double sum = 0;
                        
                        for (double purch: purchArray)
                        {
                            sum += purch;
                        }
                        
                        for (double sales: salesArray)
                        {
                            sum -= sales;
                        }
                        
                        System.out.println("The total revenue is: " + sum);
                    }
                }
                while (adminResponse != 3);
            }
            // End admin menu

            // Add if later to catch non numeric (or outside range) error?
        }
        while(response != 3);
    }
    
    public static double doyleScale(int length, double diameter)
    {
        double answer = ((diameter - 4)/4)*((diameter - 4)/4) * length;
        return answer;
    }
}
