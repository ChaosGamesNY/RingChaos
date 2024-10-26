package net.chaosgames.ringchaos.misc;

public class Utilities {
    public static int calcPlayerTotalXp(double playerXp, int playerLevel) {
        int playerXpPoints = (int) (playerXp * calcTotalXpForLevel(playerLevel));
        if (playerLevel >= 0 && playerLevel <= 16) {
            return (int) (playerXpPoints + Math.pow(playerLevel, 2) + (6 * playerLevel));
        } else if (playerLevel <= 31) {
            return (int) (playerXpPoints + (2.5 * Math.pow(playerLevel, 2)) - (40.5 * playerLevel) + 360);
        } else {
            return (int) (playerXpPoints + (4.5 * Math.pow(playerLevel, 2)) - (162.5 * playerLevel) + 2220);
        }
    }
    public static int calcTotalXpForLevel(int playerLevel) {
        if (playerLevel >= 0 && playerLevel <= 15) {
            return 2 * playerLevel + 7;
        } else if(playerLevel <= 30) {
            return 5 * playerLevel - 38;
        } else {
            return 9 * playerLevel - 158;
        }
    }
}
