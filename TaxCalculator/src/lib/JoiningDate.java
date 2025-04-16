package lib;

import java.time.LocalDate;

public class JoiningDate {
    private LocalDate dateJoined;

    public JoiningDate(int year, int month, int day) {
        this.dateJoined = LocalDate.of(year, month, day);
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }
}

