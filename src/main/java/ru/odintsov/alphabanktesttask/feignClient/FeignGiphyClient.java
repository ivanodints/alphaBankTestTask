package ru.odintsov.alphabanktesttask.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "giphyClient", url = "${giphy.url.general}")
public interface FeignGiphyClient {

    @GetMapping("/random")
    String getRndGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );
}
