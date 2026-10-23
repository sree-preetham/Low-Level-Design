package strategy;

import entities.Cell;
import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Cell move() {
        System.out.println("Choose row and col to place the token ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Cell(row, col);
    }
}
