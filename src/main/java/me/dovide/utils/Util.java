package me.dovide.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * @param text Text with Bukkit ColorChat (EX: &cHello)
     * @return Text with Bukkit ColorChat Formatted
     */
    public static String cc(String text) {
        // For HEX Colors
        text = getHEXString(text);
        //Normal colorize
        text = ChatColor.translateAlternateColorCodes('&', text);

        return text.replaceAll("&", "");
    }

    /**
     *
     * @param text Hex String
     * @return Colored Hex String
     */
    private static String getHEXString(String text) {
        Matcher match = pattern.matcher(text);
        while (match.find()) {
            String newText = text.substring(match.start(), match.end());
            text = text.replace(newText, ChatColor.of(newText) + "");
            match = pattern.matcher(text);
        }
        return text;
    }

    /**
     * @param seconds Seconds
     * @return String With Formatted Time
     */
    public static String formatTime(long seconds) {
        long minutes = seconds / 60L;
        long hours = minutes / 60L;
        long days = hours / 24L;
        seconds %= 60L;
        minutes %= 60L;
        hours %= 24L;

        StringBuilder sb = new StringBuilder();
        if (days > 0) {
            sb.append(days).append("d ");
        }
        if (hours > 0) {
            sb.append(hours).append("h ");
        }
        if (minutes > 0) {
            sb.append(minutes).append("m ");
        }
        if (seconds > 0) {
            sb.append(seconds).append("s");
        }
        return sb.toString().trim();
    }

}
