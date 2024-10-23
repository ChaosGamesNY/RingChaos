package net.chaosgames.ringchaos.setup;

public class Utilities {
    public static int calcPlayerTotalXp(double playerXp, int playerLevel) {
        if (playerLevel > 0 && playerLevel <= 16) {
            return (int) (playerXp + Math.pow(playerLevel, 2) + (6 * playerLevel));
        } else if (playerLevel <= 31) {
            return (int) (playerXp + (2.5 * Math.pow(playerLevel, 2)) - (40.5 * playerLevel) + 360);
        } else {
            return (int) (playerXp + (4.5 * Math.pow(playerLevel, 2)) - (162.5 * playerLevel) + 2220);
        }
    }
}
