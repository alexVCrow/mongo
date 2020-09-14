package ua.alexcrow.mongo.service;

public interface SequenceGeneratorService {

    long generateSequence(String seqName);
}
