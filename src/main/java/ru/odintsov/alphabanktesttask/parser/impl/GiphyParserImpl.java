package ru.odintsov.alphabanktesttask.parser.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.odintsov.alphabanktesttask.model.giphy.GiphyModel;
import ru.odintsov.alphabanktesttask.parser.GiphyParser;

@Service
public class GiphyParserImpl implements GiphyParser {

    @Override
    public GiphyModel parse(String jsonString) {
        Gson gson = new Gson();
        GiphyModel giphyModel = gson.fromJson(jsonString, GiphyModel.class);
        return giphyModel;
    }
}
