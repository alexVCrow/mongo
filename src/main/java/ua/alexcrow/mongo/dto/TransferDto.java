package ua.alexcrow.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {

    private long id;
    private String ref;
    private String sendCountry;
    private String recCountry;

}
