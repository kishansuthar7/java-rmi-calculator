package com.kishan.rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {
 public static void main(String[] args) {
  try {
   Calculator calculator = new CalculatorImpl();
   Registry registry = LocateRegistry.createRegistry(1099);
   registry.rebind("CalculatorService", calculator);
   System.out.println("RMI Calculator Server is running on port 1099.");
   System.out.println("Keep this terminal open while using the client.");
  } catch (Exception e) {
   System.err.println("Could not start server: " + e.getMessage());
   e.printStackTrace();
  }
 }
}
