package ru.odintsov.alphabanktesttask.service;

import ru.odintsov.alphabanktesttask.model.openExChange.MoneyRate;

import java.io.IOException;

public interface MoneyRateService {

    MoneyRate getRecentMoneyRate(String currency) throws IOException, InterruptedException;

    MoneyRate getYesterdayMoneyRate(String currency) throws IOException, InterruptedException;

}
