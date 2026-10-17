# Java RMI Calculator

A Java Remote Method Invocation (RMI) calculator with separate server and client programs.

## Features
- Remote interface and implementation
- Addition, subtraction, multiplication, and division
- Server creates an RMI registry on port 1099
- No third-party libraries, Maven, or Tomcat required

## Requirements
JDK 17+ (JDK 21 recommended). Check in VS Code PowerShell:
```powershell
java -version
javac -version
```

## Structure
```text
Java_RMI_Calculator/
├── src/main/java/com/kishan/rmi/
│   ├── Calculator.java
│   ├── CalculatorImpl.java
│   ├── Server.java
│   └── Client.java
├── README.md
└── .gitignore
```

## Compile (run from project root)
```powershell
javac -encoding UTF-8 -d out src\main\java\com\kishan\rmi\Calculator.java src\main\java\com\kishan\rmi\CalculatorImpl.java src\main\java\com\kishan\rmi\Server.java src\main\java\com\kishan\rmi\Client.java
```

## Run
Terminal 1:
```powershell
java -cp out com.kishan.rmi.Server
```
Keep it open. In a second VS Code terminal, from the same project folder:
```powershell
java -cp out com.kishan.rmi.Client
```
Choose 1–4 and enter two numbers. Choose 0 to exit.

For a different computer, use `java -cp out com.kishan.rmi.Client SERVER_IP`; port 1099 must be reachable and firewall rules may need configuring.

## Troubleshooting
- `javac is not recognized`: install/configure a JDK and restart VS Code.
- `Connection refused`: start the server first and keep its terminal open.
- `Port already in use`: stop the other process using port 1099.

## GitHub upload
Create an empty repository named `java-rmi-calculator` (do not initialize another README). From the project root:
```powershell
git init
git add .
git status
git commit -m "Add Java RMI calculator"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/java-rmi-calculator.git
git push -u origin main
```
Replace `YOUR-USERNAME` with your GitHub username. If `origin` already exists, use `git remote set-url origin https://github.com/YOUR-USERNAME/java-rmi-calculator.git`.
