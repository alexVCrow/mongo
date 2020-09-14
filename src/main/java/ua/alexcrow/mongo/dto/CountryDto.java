package ua.alexcrow.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private long id;
    private String isoCodeChar;
    private int isoCodeDigital;
    private String title;

}
