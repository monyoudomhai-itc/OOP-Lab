import java.util.Scanner;

interface GridLayout {
    void insertAtRow(int rowNumber, int[] values);
    void insertAtColumn(int columnNumber, int[] values);
    void clearAtRow(int rowNumber);
    void clearAtColumn(int columnNumber);
    void updateCell(int rowNumber, int columnNumber, int value);
    void displayGrid();
    void clear();
}

class GridManagement implements GridLayout {
    private static final int SIZE = 7;
    private final int[][] grid;

    GridManagement() {
        grid = new int[SIZE][SIZE];
    }

    @Override
    public void insertAtRow(int rowNumber, int[] values) {
        validateRow(rowNumber);
        validateValues(values);
        for (int col = 0; col < SIZE; col++) {
            grid[rowNumber][col] = values[col];
        }
    }

    @Override
    public void insertAtColumn(int columnNumber, int[] values) {
        validateColumn(columnNumber);
        validateValues(values);
        for (int row = 0; row < SIZE; row++) {
            grid[row][columnNumber] = values[row];
        }
    }

    @Override
    public void clearAtRow(int rowNumber) {
        validateRow(rowNumber);
        for (int col = 0; col < SIZE; col++) {
            grid[rowNumber][col] = 0;
        }
    }

    @Override
    public void clearAtColumn(int columnNumber) {
        validateColumn(columnNumber);
        for (int row = 0; row < SIZE; row++) {
            grid[row][columnNumber] = 0;
        }
    }

    @Override
    public void updateCell(int rowNumber, int columnNumber, int value) {
        validateRow(rowNumber);
        validateColumn(columnNumber);
        validateValue(value);
        grid[rowNumber][columnNumber] = value;
    }

    @Override
    public void displayGrid() {
        System.out.println(":::: The GRID ::::");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = 0;
            }
        }
    }

    private void validateRow(int rowNumber) {
        if (rowNumber < 0 || rowNumber >= SIZE) {
            throw new IllegalArgumentException("Row must be between 0 and 6.");
        }
    }

    private void validateColumn(int columnNumber) {
        if (columnNumber < 0 || columnNumber >= SIZE) {
            throw new IllegalArgumentException("Column must be between 0 and 6.");
        }
    }

    private void validateValues(int[] values) {
        if (values == null || values.length != SIZE) {
            throw new IllegalArgumentException("You must provide exactly 7 values.");
        }
        for (int value : values) {
            validateValue(value);
        }
    }

    private void validateValue(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Cell values must be between 0 and 9.");
        }
    }
}

public class oop81 {
    private static final int SIZE = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GridManagement grid = new GridManagement();

        while (true) {
            grid.displayGrid();
            printMenu();
            int choice = readInt(scanner, "Choose an opt: ");

            try {
                if (choice == 1) {
                    int row = readInt(scanner, "Row (0-6): ");
                    int col = readInt(scanner, "Column (0-6): ");
                    int value = readValue(scanner, "Value (0-9): ");
                    grid.updateCell(row, col, value);
                } else if (choice == 2) {
                    int row = readInt(scanner, "Row (0-6): ");
                    int[] values = readValues(scanner, "Enter 7 values for the row (0-9): ");
                    grid.insertAtRow(row, values);
                } else if (choice == 3) {
                    int col = readInt(scanner, "Column (0-6): ");
                    int[] values = readValues(scanner, "Enter 7 values for the column (0-9): ");
                    grid.insertAtColumn(col, values);
                } else if (choice == 4) {
                    int row = readInt(scanner, "Row (0-6): ");
                    grid.clearAtRow(row);
                } else if (choice == 5) {
                    int col = readInt(scanner, "Column (0-6): ");
                    grid.clearAtColumn(col);
                } else if (choice == 6) {
                    grid.clear();
                } else if (choice == 7) {
                    System.out.println("Bye.");
                    break;
                } else {
                    System.out.println("Invalid option. Choose 1-7.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Update a single cell");
        System.out.println("2. Insert at a row");
        System.out.println("3. Insert at a column");
        System.out.println("4. Clear at a row");
        System.out.println("5. Clear at a column");
        System.out.println("6. Clear all");
        System.out.println("7. Quit");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static int readValue(Scanner scanner, String prompt) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value >= 0 && value <= 9) {
                return value;
            }
            System.out.println("Value must be between 0 and 9.");
        }
    }

    private static int[] readValues(Scanner scanner, String prompt) {
        int[] values = new int[SIZE];
        System.out.println(prompt);
        for (int i = 0; i < SIZE; i++) {
            values[i] = readValue(scanner, "Value " + (i + 1) + ": ");
        }
        return values;
    }
}
