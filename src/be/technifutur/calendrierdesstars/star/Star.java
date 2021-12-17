package be.technifutur.calendrierdesstars.star;

import be.technifutur.util.Util;

import java.time.LocalDate;

public class Star {
    private String name;
    private LocalDate birthday, death;
    private String job;

    public Star(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Star(String name, String job , LocalDate birthday, LocalDate death) {
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        this.death = death;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return job;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Star star = (Star) o;

        if (name != null ? !name.equals(star.name) : star.name != null) return false;

        return birthday != null ? birthday.equals(star.birthday) : star.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        if (job == null) {
            result = "Star{" +
                    "name='" + name + '\'' +
                    ", birthday=" + Util.formatDate(birthday) +
                    '}';
        } else if (death == null) {
            result = "Star{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", birthday=" + Util.formatDate(birthday) +
                    '}';
        } else {
            result = "Star{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", birthday=" + Util.formatDate(birthday) +
                    ", death=" + Util.formatDate(death) +
                    '}';
        }
        return result;
    }
}
