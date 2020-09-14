package ua.alexcrow.mongo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import ua.alexcrow.mongo.dto.TransferDto;
import ua.alexcrow.mongo.model.CountryModel;
import ua.alexcrow.mongo.model.TransferModel;
import ua.alexcrow.mongo.service.ConvertService;

import java.util.List;

@RestController
@RequestMapping(value = "/transfer")
@Log4j2
public class TransferController {

    private final MongoTemplate mongoTemplate;
    private final ConvertService convertService;

    public TransferController(MongoTemplate mongoTemplate, ConvertService convertService) {
        this.mongoTemplate = mongoTemplate;
        this.convertService = convertService;
    }

    @GetMapping
    public List<TransferModel> getAllUsers() {
        log.info("Getting all Transfers.");
        return mongoTemplate.findAll(TransferModel.class);
    }

    @PostMapping("/create")
    public TransferDto add(@RequestBody TransferDto transferDto) {
        log.info("Saving TransferModel.");
        Query query = new Query();
        query.addCriteria(Criteria.where("isoChar").is(transferDto.getSendCountry()));
        CountryModel countryModel = mongoTemplate.findOne(query, CountryModel.class);
        TransferModel transferModel = mongoTemplate.save(convertService.transferDtoToModel(transferDto, countryModel));
        return convertService.transferModelToDto(transferModel);
    }

    @GetMapping("/{id}")
    public TransferModel getEmployee(@PathVariable long id) {
        log.info("Getting TransferModel with ID: {}.", id);
        return mongoTemplate.findById(id, TransferModel.class);
    }
}
