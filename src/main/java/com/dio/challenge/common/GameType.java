package com.dio.challenge.common;

public enum GameType {

    MEGA_SENA(4, 6, 60),
    LOTO_FACIL(12, 15,25);

    private final int victoryWithMoreThan;
    private final int minimumQuantitySelected;
    private final int possibilities;

    GameType(int victoryWithMoreThan, int minimumQuantitySelected, int possibilities) {
        this.victoryWithMoreThan = victoryWithMoreThan;
        this.minimumQuantitySelected = minimumQuantitySelected;
        this.possibilities = possibilities;
    }

    public int getVictoryWithMoreThan() {
        return victoryWithMoreThan;
    }

    public int getMinimumQuantitySelected() {
        return minimumQuantitySelected;
    }

    public int getPossibilities() {
        return possibilities;
    }
}
