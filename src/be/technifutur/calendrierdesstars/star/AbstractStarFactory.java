package be.technifutur.calendrierdesstars.star;

import be.technifutur.calendrierdesstars.comparators.BirthdayNameStarComparator;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractStarFactory {
    protected abstract List<String> prepareString(List<String> fileContent);

    protected abstract Star createStar(String s);

    public Set<Star> getStars(File filename) {
        Set<Star> stars = new TreeSet<>(new BirthdayNameStarComparator());
        List<String> fileContent = StarReader.read(filename);

        for (String s : prepareString(fileContent)) {
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
