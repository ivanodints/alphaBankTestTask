package ru.odintsov.alphabanktesttask.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.odintsov.alphabanktesttask.feignClient.FeignMoneyRateClient;
import ru.odintsov.alphabanktesttask.model.openExChange.MoneyRate;
import ru.odintsov.alphabanktesttask.service.MoneyRateService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@NoArgsConstructor
public class MoneyRateServiceImpl implements MoneyRateService {

    private static final String dateFormat = "yyyy-MM-dd";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
    private static final String yesterday = dateFormatter.format(LocalDate.now().minusDays(1L));

    @Autowired
    private FeignMoneyRateClient feignMoneyRateClient;

    @Value("${openexchange.key}")
    private String apiKey;


    @Override
    public MoneyRate getRecentMoneyRate(String currency) throws IOException, InterruptedException {

        return feignMoneyRateClient.getRate(apiKey, currency);
    }

    @Override
    public MoneyRate getYesterdayMoneyRate(String currency) throws IOException, InterruptedException {

        return feignMoneyRateClient.getHistoryRate(yesterday, apiKey, currency);
    }

}
