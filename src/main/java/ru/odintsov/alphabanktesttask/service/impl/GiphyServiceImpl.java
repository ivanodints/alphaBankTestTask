package ru.odintsov.alphabanktesttask.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.odintsov.alphabanktesttask.feignClient.FeignGiphyClient;
import ru.odintsov.alphabanktesttask.model.giphy.GiphyModel;
import ru.odintsov.alphabanktesttask.parser.GiphyParser;
import ru.odintsov.alphabanktesttask.service.GiphyService;

import java.io.IOException;

@Service
@NoArgsConstructor
public class GiphyServiceImpl implements GiphyService {

    @Autowired
    private GiphyParser giphyParser;

    @Value("${giphy.api.key}")
    private String apiKey;

    @Value("${giphy.tag.rich}")
    private String tagRich;

    @Value("${giphy.tag.broke}")
    private String tagBroke;

    @Autowired
    private FeignGiphyClient feignGiphyClient;


    @Override
    public String getGifJson(String status) {

        if (status.equals("rich"))
            return feignGiphyClient.getRndGif(apiKey, tagRich);

        if (status.equals("broke"))
            return feignGiphyClient.getRndGif(apiKey, tagBroke);

        return null;
    }

    @Override
    public String getGif(String status) throws IOException {

        if (status.equals("rich")){
            GiphyModel giphyModel = giphyParser.parse(feignGiphyClient.getRndGif(apiKey, tagRich));
            return giphyModel.getData().getEmbed_url();
        }

        if (status.equals("broke")){
            GiphyModel giphyModel = giphyParser.parse(feignGiphyClient.getRndGif(apiKey, tagBroke));
            return giphyModel.getData().getEmbed_url();
        }

        return null;
    }
}
