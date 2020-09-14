package ua.alexcrow.mongo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "countries")
public class CountryModel {

    @Transient
    public static final String SEQUENCE_NAME = "country_sequence";

    @Id
    private long id;
    @Indexed(name = "country_isoChar_index", unique = true)
    private String isoChar;
    @Indexed(name = "country_isoDigital_index", unique = true)
    private int isoDigital;
    private String name;

    public CountryModel(long id, String isoChar, int isoDigital, String name) {
        this.id = id;
        this.isoChar = isoChar;
        this.isoDigital = isoDigital;
        this.name = name;
    }
}
