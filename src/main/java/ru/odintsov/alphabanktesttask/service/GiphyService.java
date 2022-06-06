package ru.odintsov.alphabanktesttask.service;

import java.io.IOException;

public interface GiphyService {

    String getGif(String url) throws IOException, InterruptedException;

    String getGifJson(String url) throws IOException, InterruptedException;

}
