package ua.alexcrow.mongo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import ua.alexcrow.mongo.model.CountryModel;
import ua.alexcrow.mongo.model.TransferModel;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
@Log4j2
public class CountryController {

    private final MongoTemplate mongoTemplate;

    public CountryController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<TransferModel> getAllUsers() {
        log.info("Getting all Transfers.");
        return mongoTemplate.findAll(TransferModel.class);
    }

    @PostMapping("/create")
    public CountryModel add(@RequestBody CountryModel countryModel) {
        log.info("Saving TransferModel.");
        return mongoTemplate.save(countryModel);
    }

    @GetMapping("/{id}")
    public TransferModel getEmployee(@PathVariable long id) {
        log.info("Getting TransferModel with ID: {}.", id);
        return mongoTemplate.findById(id, TransferModel.class);
    }
}
