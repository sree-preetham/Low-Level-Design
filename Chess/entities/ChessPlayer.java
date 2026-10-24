package entities;

import strategy.ChessPlayerMovementStrategy;

public class ChessPlayer {

    String name;
    boolean isWhiteSide;
    ChessPlayerMovementStrategy playerMovementStrategy;

    public ChessPlayer(String name, boolean isWhiteSide, ChessPlayerMovementStrategy playerMovementStrategy) {
        this.name = name;
        this.isWhiteSide = isWhiteSide;
        this.playerMovementStrategy = playerMovementStrategy;
    }

    public String getName() {
        return name;
    }

    public boolean isWhiteSide() {
        return isWhiteSide;
    }

    public ChessPlayerMovementStrategy getPlayerMovementStrategy() {
        return playerMovementStrategy;
    }

    
}
