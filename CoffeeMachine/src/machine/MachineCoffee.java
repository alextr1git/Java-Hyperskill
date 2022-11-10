package machine;

public class MachineCoffee {

    final int ESPRESSO_WATER_NEED = 250;
    final int ESPRESSO_BEANS_NEED = 16;
    final int ESPRESSO_COST = 4;

    final int LATTE_WATER_NEED = 350;
    final int LATTE_MILK_NEED = 75;
    final int LATTE_BEANS_NEED = 20;
    final int LATTE_COST = 7;

    final int CAPPUCCINO_WATER_NEED = 200;
    final int CAPPUCCINO_MILK_NEED = 100;
    final int CAPPUCCINO_BEANS_NEED = 12;
    final int CAPPUCCINO_COST = 6;

    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void runMachine(String inputData) {
        if (!tryParseInt(inputData) && !inputData.equals("back")) {
            switch (inputData) {
                case "buy":
                    machineState = State.BUYING_COFFEE;
                    System.out.println("What do you want to buy?" +
                            " 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    break;
                case "fill":
                    machineState = State.REFILLING_MACHINE;
                    System.out.println("Write how many ml of water you want to add:");
                    counter = 1;
                    break;
                case "take":
                    System.out.printf("I gave you $%d\n", amountMoney);
                    amountMoney = 0;
                    machineState = State.UNSETTED;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(amountWater + " ml of water");
                    System.out.println(amountMilk + " ml of milk");
                    System.out.println(amountBeans + " g of coffee beans");
                    System.out.println(amountCups + " disposable cups");
                    System.out.println(amountMoney + " of money");
                    machineState = State.UNSETTED;
                    break;
                default:
                    break;
            }
        } else {
            switch (machineState.name()) {
                case "BUYING_COFFEE":
                    switch (inputData) {
                        case ("1"):
                            System.out.println(MakeEspresso());
                            break;
                        case ("2"):
                            System.out.println(MakeLatte());
                            break;
                        case ("3"):
                            System.out.println(MakeCappuccino());
                            break;
                        case ("back"):
                            break;
                    }
                    machineState = State.UNSETTED;
                    break;
                case "REFILLING_MACHINE":
                    switch (counter) {
                        case (1):
                            amountWater += Integer.parseInt(inputData);
                            System.out.println("Write how many ml of milk you want to add:");
                            counter++;
                            break;
                        case (2):
                            amountMilk += Integer.parseInt(inputData);
                            System.out.println("Write how many grams of coffee beans you want to add:");
                            counter++;
                            break;
                        case (3):
                            amountBeans += Integer.parseInt(inputData);
                            System.out.println("Write how many disposable cups you want to add:");
                            counter++;
                            break;
                        case (4):
                            amountCups += Integer.parseInt(inputData);
                            counter = 0;
                            machineState = State.UNSETTED;
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private String MakeEspresso() {
        if (amountWater >= ESPRESSO_WATER_NEED)
            amountWater -= ESPRESSO_WATER_NEED;
        else
            return "Sorry, not enough water!";

        if (amountBeans >= ESPRESSO_BEANS_NEED)
            amountBeans -= ESPRESSO_BEANS_NEED;
        else
            return "Sorry, not enough coffee beans!";

        if (amountCups >= 1)
            amountCups -= 1;
        else
            return "Sorry, not enough disposable cups!";

        amountMoney += ESPRESSO_COST;
        return "I have enough resources, making you a coffee!";
    }

    private String MakeLatte() {
        if (amountWater >= LATTE_WATER_NEED)
            amountWater -= LATTE_WATER_NEED;
        else {
            return "Sorry, not enough water!";
        }


        if (amountBeans >= LATTE_BEANS_NEED)
            amountBeans -= LATTE_BEANS_NEED;
        else {
            return "Sorry, not enough coffee beans!";
        }

        if (amountMilk >= LATTE_MILK_NEED)
            amountMilk -= LATTE_MILK_NEED;
        else {
            return "Sorry, not enough milk!";
        }

        if (amountCups >= 1)
            amountCups -= 1;
        else {
            return "Sorry, not enough disposable cups!";
        }
        amountMoney += LATTE_COST;
        return "I have enough resources, making you a coffee!";
    }

    private String MakeCappuccino() {
        if (amountWater >= CAPPUCCINO_WATER_NEED)
            amountWater -= CAPPUCCINO_WATER_NEED;
        else {
            return "Sorry, not enough water!";
        }


        if (amountBeans >= CAPPUCCINO_BEANS_NEED)
            amountBeans -= CAPPUCCINO_BEANS_NEED;
        else {
            return "Sorry, not enough coffee beans!";
        }

        if (amountMilk >= CAPPUCCINO_MILK_NEED)
            amountMilk -= CAPPUCCINO_MILK_NEED;
        else {
            return "Sorry, not enough milk!";
        }

        if (amountCups >= 1)
            amountCups -= 1;
        else {
            return "Sorry, not enough disposable cups!";
        }
        amountMoney += CAPPUCCINO_COST;
        return "I have enough resources, making you a coffee!";

    }

    public State machineState;

    MachineCoffee() {
        amountWater = 400;
        amountMilk = 540;
        amountBeans = 120;
        amountCups = 9;
        amountMoney = 550;
        counter = 0;
        machineState = State.UNSETTED;
    }

    int amountWater;
    int amountMilk;
    int amountBeans;
    int amountCups;
    int amountMoney;

    int counter;
}