package com.kishan.rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client {
 public static void main(String[] args) {
  String host = args.length > 0 ? args[0] : "localhost";
  try (Scanner sc = new Scanner(System.in)) {
   Registry registry = LocateRegistry.getRegistry(host,1099);
   Calculator calc = (Calculator) registry.lookup("CalculatorService");
   System.out.println("Connected to RMI Calculator at " + host + ":1099");
   while (true) {
    System.out.println("\n=== RMI Calculator ===\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n0. Exit");
    System.out.print("Choose: ");
    if (!sc.hasNextInt()) { System.out.println("Enter a number from 0 to 4."); sc.nextLine(); continue; }
    int choice=sc.nextInt();
    if (choice==0) { System.out.println("Client closed."); break; }
    if (choice<1 || choice>4) { System.out.println("Invalid choice."); continue; }
    System.out.print("First number: ");
    if (!sc.hasNextDouble()) { System.out.println("Invalid number."); sc.nextLine(); continue; }
    double a=sc.nextDouble();
    System.out.print("Second number: ");
    if (!sc.hasNextDouble()) { System.out.println("Invalid number."); sc.nextLine(); continue; }
    double b=sc.nextDouble();
    try {
     double result;
     switch(choice) {
      case 1: result=calc.add(a,b); break;
      case 2: result=calc.subtract(a,b); break;
      case 3: result=calc.multiply(a,b); break;
      case 4: result=calc.divide(a,b); break;
      default: throw new IllegalStateException();
     }
     System.out.println("Result: " + result);
    } catch(Exception e) { System.out.println("Operation failed: " + e.getMessage()); }
   }
  } catch(Exception e) {
   System.err.println("Cannot connect. Start Server in another terminal first.");
   System.err.println("Details: " + e.getMessage());
  }
 }
}
