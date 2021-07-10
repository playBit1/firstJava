package cinema;
import java.util.*;
public class Cinema {

    private int row;
    private int seat;
    private int totalRows;
    private int totalSeats;
    private String[][] grid;
    private int soldTickets;
    private int salary;
    Scanner input = new Scanner(System.in);

    public void setRow() {
        System.out.println("Enter a row number:");
        System.out.print("> ");
        row = input.nextInt();
    }

    public void setSeat() {
        System.out.println("Enter a seat number in that row:");
        System.out.print("> ");
        seat = input.nextInt();
    }

    public void setTotalRows() {
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        totalRows = input.nextInt();
    }

    public void setTotalSeats() {
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        totalSeats = input.nextInt();
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void buyTicket() {
        setRow();
        setSeat();
        while (row > totalRows || seat > totalSeats) {
            System.out.println("Wrong input!");
            setRow();
            setSeat();

        }

        if (grid[row-1][seat].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            buyTicket();
        }

    }

    public int seatPrice() {
        int price = 10;
        buyTicket();

        grid[row-1][seat] = "B";

        if (grid[row-1][seat].equals("B")) {
            soldTickets += 1;
        }

        if (totalSeats * totalRows> 60) {
            if (row > totalRows/2) {
                price = 8;
                salary += price;
                System.out.println("Ticket price: " + "$"+ price);
                return price;
            }
        }

        salary += price;
        System.out.println("Ticket price: " + "$"+ price);
        return price;
    }

    public void got () {
        int price = 10;
        int frontRowPrice = 10;
        int backRowPrice = 8;

        int salary;
        int frontRow;
        int backRow;

        int totalS = totalSeats * totalRows;

        if (totalS <= 60) {
            salary = totalS * price;

        } else {

            if (totalS % 2 == 0) {
                frontRow = totalS/2;
                backRow = totalS/2;
            } else {
                frontRow = totalRows/2 * totalSeats;
                backRow = frontRow + 1 * totalSeats;
            }
            salary = frontRow * frontRowPrice + backRow * backRowPrice;
        }
        System.out.println("Total income: " + "$"+ salary);


    }

    public  void statistics() {
        System.out.println("Number of purchased tickets: " + soldTickets);
        float total = totalRows * totalSeats;
        float soldPercent = soldTickets * 100 / total;
        System.out.printf("Percentage: %.2f%%", soldPercent);
        System.out.println("\nCurrent income: " + "$" + salary);
        got();
    }

    public void setGrid(int rows, int seats) {

        grid = new String[rows][seats+1];

        for (int i = 0; i < grid.length; i++) {
            grid[i][0] = Integer.toString(i+1);
            for (int j = 1;j < grid[i].length; j++) {
                grid[i][j] = "S";
            }
        }

    }

    public void printGrid() {
        System.out.println("\n"+"Cinema:");

        for (int i = 0; i <= grid[0].length-1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for (String[] strings : grid) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public void menu() {
        Boolean exit = false;

        while (!exit) {
            System.out.print("\n");
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            int action = input.nextInt();

            switch (action) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    printGrid();
                    break;
                case 2:
                    seatPrice();
                    break;
                case 3:
                    statistics();
                    break;
            }
        }


    }




}
