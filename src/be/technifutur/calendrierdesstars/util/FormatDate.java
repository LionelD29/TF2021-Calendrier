package be.technifutur.calendrierdesstars.util;

import java.time.LocalDate;

public class FormatDate {
    public static String formatDate(LocalDate date) {
        return (date.getDayOfMonth() == 1 ? "1er" : date.getDayOfMonth())
                + " " + monthFR(date.getMonthValue())
                + " " + date.getYear();
    }

    public static String monthFR(int monthValue) {
        String month = "";
        switch (monthValue) {
            case 1 -> month = "janvier";
            case 2 -> month = "février";
            case 3 -> month = "mars";
            case 4 -> month = "avril";
            case 5 -> month = "mai";
            case 6 -> month = "juin";
            case 7 -> month = "juillet";
            case 8 -> month = "août";
            case 9 -> month = "septembre";
            case 10 -> month = "octobre";
            case 11 -> month = "novembre";
            case 12 -> month = "décembre";
        }
        return month;
    }
}
