package be.technifutur.calendrierdesstars.star;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class AbstractStarFactory {
    protected abstract List<String> prepareString(List<String> fileContent);

    protected abstract Star createStar(String s);

    public List<Star> getStars(File filename) {
        List<String> fileContent = StarReader.read(filename);
        List<String> preparedList = prepareString(fileContent);
        List<Star> stars = new ArrayList<>();

        for (String s : preparedList) {
            stars.add(createStar(s));
        }

        return stars;
    }

    protected static LocalDate createLocalDate(String dateString) {
        LocalDate parsedDate = null;
        if (dateString != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
            parsedDate = LocalDate.parse(dateString.replace("1er", "1").trim(), formatter);
        }

        return parsedDate;
    }
}
