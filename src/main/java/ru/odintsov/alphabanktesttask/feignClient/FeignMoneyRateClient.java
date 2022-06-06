package ru.odintsov.alphabanktesttask.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.odintsov.alphabanktesttask.model.openExChange.MoneyRate;

@FeignClient(name = "moneyRateClient", url = "${openexchange.url}")
public interface FeignMoneyRateClient {

    @GetMapping("/latest.json")
    MoneyRate getRate(
            @RequestParam("app_id") String appId,
            @RequestParam("currency") String currency
    );


    @GetMapping("/historical/{date}.json")
    MoneyRate getHistoryRate(
            @PathVariable String date,
            @RequestParam("app_id") String appId,
            @RequestParam("currency") String currency
    );
}
