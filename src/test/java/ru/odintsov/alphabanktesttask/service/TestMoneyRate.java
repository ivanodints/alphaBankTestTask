package ru.odintsov.alphabanktesttask.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.odintsov.alphabanktesttask.feignClient.FeignMoneyRateClient;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
@ComponentScan
public class TestMoneyRate {

    private String date;

    @Autowired
    private FeignMoneyRateClient feignMoneyRateClient;

    @Autowired
    private MoneyRateService moneyRateService;

    private String appId;
    private String currency;

    @BeforeEach
    public void init() throws IOException {

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("\\alphabanktesttask\\src\\main\\resources\\application.properties");
        properties.load(in);
        appId = properties.getProperty("openexchange.key");

        date = "2022-06-03";
        currency = "RUB";

    }

    @Test
    public void testGetRecentMoneyRateFeignClient(){
        assertNotNull(feignMoneyRateClient.getRate(appId, currency));
    }

    @Test
    public void testGetHistoricalMoneyRateFeignClient(){
        assertNotNull(feignMoneyRateClient.getHistoryRate(date, appId, currency));
    }

    @Test
    public void testGetRecentMoneyRateService() throws IOException, InterruptedException {
        assertNotNull(moneyRateService.getRecentMoneyRate(currency) );
    }

    @Test
    public void testGetHistoricalMoneyRateService() throws IOException, InterruptedException {
        assertNotNull(moneyRateService.getYesterdayMoneyRate(currency));
    }
}
