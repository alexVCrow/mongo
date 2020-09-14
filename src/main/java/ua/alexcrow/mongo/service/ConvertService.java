package ua.alexcrow.mongo.service;

import ua.alexcrow.mongo.dto.TransferDto;
import ua.alexcrow.mongo.model.CountryModel;
import ua.alexcrow.mongo.model.TransferModel;

public interface ConvertService {

    TransferDto transferModelToDto(TransferModel transferModel);

    TransferModel transferDtoToModel(TransferDto transferDto, CountryModel countryModel);

}
