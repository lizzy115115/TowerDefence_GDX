package com.betmansmall.game.gameLogic.playerTemplates;

/**
 * Created by betma on 19.01.2017.
 */

public enum TowerAttackType {
    Pit("Pit"),
    Melee("Melee"),
    Range("Range");

    private final String text;

    private TowerAttackType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static TowerAttackType getType(String type) {
        for (TowerAttackType t : TowerAttackType.values()) {
            if (t.name().equals(type)) {
                return t;
            }
        }
        return null;
    }
}