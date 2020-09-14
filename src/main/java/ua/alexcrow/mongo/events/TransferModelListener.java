package ua.alexcrow.mongo.events;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.util.ReflectionUtils;
import ua.alexcrow.mongo.model.TransferModel;
import ua.alexcrow.mongo.service.SequenceGeneratorService;

import java.lang.reflect.Field;
import java.util.Objects;

public class TransferModelListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private MongoOperations mongoOperations;


    @SneakyThrows
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        final Object source = event.getSource();
        Class<?> o = source.getClass();
        Field seqField = o.getField("SEQUENCE_NAME");
        if(Objects.nonNull(seqField) && seqField.isAnnotationPresent(Transient.class)){
            Field idField = o.getDeclaredField("id");
            if (idField != null) {
                ReflectionUtils.makeAccessible(idField);
                if((long) idField.get(source) < 1){
                    idField.setLong(source, sequenceGenerator.generateSequence((String) seqField.get(source)));
                }
            }
        }
        if(source instanceof TransferModel && ((TransferModel) source).getCountryModel() != null){
            mongoOperations.save(((TransferModel) source).getCountryModel());
        }
    }

}
