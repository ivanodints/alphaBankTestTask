package ru.odintsov.alphabanktesttask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import ru.odintsov.alphabanktesttask.feignClient.FeignGiphyClient;
import ru.odintsov.alphabanktesttask.model.giphy.GiphyModel;
import ru.odintsov.alphabanktesttask.parser.GiphyParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ComponentScan
public class TestGiphy {

    @Autowired
    private FeignGiphyClient feignGiphyClient;

    @Autowired
    private GiphyService giphyService;

    @Autowired
    private GiphyParser giphyParser;

    private String rich;
    private String broke;
    private String key;

    @BeforeEach
    public void init() throws IOException {

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("testapplication.properties");
        properties.load(in);
        key = properties.getProperty("giphy.api.key");
        rich = properties.getProperty("giphy.tag.rich");
        broke = properties.getProperty("giphy.tag.broke");

    }

    @Test
    public void testGetRndGifRichService() throws IOException, InterruptedException {
        assertNotNull(giphyService.getGif(rich));
    }

    @Test
    public void testGetRndGifBrokeService() throws IOException, InterruptedException {
        assertNotNull(giphyService.getGif(broke));
    }

    @Test
    public void testGetRndGifRichFeignClient() throws JsonProcessingException {
        String json = feignGiphyClient.getRndGif(key, rich);
        GiphyModel giphyModel = giphyParser.parse(json);
        giphyModel.getData().getEmbed_url();
        assertNotNull(giphyModel.getData().getEmbed_url());
    }

    @Test
    public void testGetRndGifBrokeFeignClient() throws JsonProcessingException {
        String json = feignGiphyClient.getRndGif(key, broke);
        GiphyModel giphyModel = giphyParser.parse(json);
        giphyModel.getData().getEmbed_url();
        assertNotNull(giphyModel.getData().getEmbed_url());
    }
}
