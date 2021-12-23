package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AfishaFilm {
    private int id;
    private String filmName;
    private String genre;
    private int year;
}
