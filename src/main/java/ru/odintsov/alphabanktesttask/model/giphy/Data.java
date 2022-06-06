package ru.odintsov.alphabanktesttask.model.giphy;

import lombok.Getter;
import lombok.Setter;
import ru.odintsov.alphabanktesttask.model.giphy.image.Image;

@Getter
@Setter
public class Data {

    private String type;
    private String id;
    private String url;
    private String slug;
    private String bitly_gif_url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String title;
    private String rating;
    private String content_url;
    private String source_tld;
    private String source_post_url;
    private int is_sticker;
    private String import_datetime;
    private String trending_datetime;
    private Image images;
    private User user;
}
