package ru.odintsov.alphabanktesttask.model.giphy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String avatar_url;
    private String banner_image;
    private String banner_url;
    private String profile_url;
    private String username;
    private String display_name;
    private String description;
    private boolean is_verified;
    private String website_url;
    private String instagram_url;
}
