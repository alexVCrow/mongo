package ua.alexcrow.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.alexcrow.mongo.model.TransferModel;

@Repository
public interface TransferRepository extends MongoRepository<TransferModel, Long> {

}
