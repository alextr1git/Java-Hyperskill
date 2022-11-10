package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        boolean flag = false;
        String Command = null;
        Scanner scanner = new Scanner(System.in);
        MachineCoffee machine = new MachineCoffee();

        while (true) {
            if(machine.machineState.name() == "UNSETTED")
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            Command = scanner.next();
            if (Command.equals("exit")){
                break;
            }
            machine.runMachine(Command);
        }

    }
}


