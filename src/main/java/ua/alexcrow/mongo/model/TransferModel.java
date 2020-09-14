package ua.alexcrow.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "transfers")
public class TransferModel {

    @Transient
    public static final String SEQUENCE_NAME = "transfer_sequence";

    @Id
    private long id;
    private String reference;
    private String senderCountry;
    private String receiverCountry;
    @DBRef
    @Field("country")
    private CountryModel countryModel;

    public TransferModel(long id, String reference, String senderCountry, String receiverCountry, CountryModel countryModel) {
        this.id = id;
        this.reference = reference;
        this.senderCountry = senderCountry;
        this.receiverCountry = receiverCountry;
        this.countryModel = countryModel;
    }
}
