package ru.odintsov.alphabanktesttask.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.odintsov.alphabanktesttask.model.giphy.GiphyModel;


public interface GiphyParser {

    GiphyModel parse(String jsonString) throws JsonProcessingException;
}
