package ru.odintsov.alphabanktesttask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.odintsov.alphabanktesttask.model.openExChange.MoneyRate;
import ru.odintsov.alphabanktesttask.service.GiphyService;
import ru.odintsov.alphabanktesttask.service.MoneyRateService;


@Controller
@RequestMapping
@AllArgsConstructor
public class MoneyRateController {

    private final MoneyRateService moneyRateService;
    private final GiphyService giphyService;

    @GetMapping(value = "/api/v1/rate/{currency}")
    public String getGif(@PathVariable("currency") String currency) throws Exception {
        MoneyRate moneyRate1 = moneyRateService.getRecentMoneyRate(currency.toUpperCase());
        MoneyRate moneyRate2 = moneyRateService.getYesterdayMoneyRate(currency.toUpperCase());
        double recentMoney;
        double yesterdayMoney;
        String gifUrl;

        if (moneyRate1 != null)
            recentMoney = moneyRate1.getRates().get(currency.toUpperCase());
        else
            recentMoney = 0;

        if (moneyRate2 != null)
            yesterdayMoney = moneyRate2.getRates().get(currency.toUpperCase());
        else
            yesterdayMoney = 0;

        if (recentMoney > yesterdayMoney)
            gifUrl = giphyService.getGif("rich");
        else
            gifUrl = giphyService.getGif("broke");

        return "redirect:" + gifUrl;
    }
}
