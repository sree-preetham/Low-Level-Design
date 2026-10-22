package entities;

import strategy.PlayerStrategy;

public class Player {

    String name;
    Token token;
    PlayerStrategy playerStrategy;

    public Player(String name, Token token, PlayerStrategy playerStrategy) {
        this.name = name;
        this.token = token;
        this.playerStrategy = playerStrategy;
    }

    public Cell move() {
        Cell cell = playerStrategy.move();
        cell.setToken(token);
        return cell;
    }

    public String getName() {
        return name;
    }

    public Token getToken() {
        return token;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }
}
