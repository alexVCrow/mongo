package ua.alexcrow.mongo.service;

import org.springframework.stereotype.Service;
import ua.alexcrow.mongo.dto.TransferDto;
import ua.alexcrow.mongo.model.CountryModel;
import ua.alexcrow.mongo.model.TransferModel;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public TransferDto transferModelToDto(TransferModel transferModel) {
        return new TransferDto(transferModel.getId(), transferModel.getReference(), transferModel.getSenderCountry(),
                transferModel.getReceiverCountry());
    }

    @Override
    public TransferModel transferDtoToModel(TransferDto transferDto, CountryModel countryModel) {
        return new TransferModel(transferDto.getId(), transferDto.getRef(), transferDto.getSendCountry(),
                transferDto.getRecCountry(), countryModel);
    }
}
