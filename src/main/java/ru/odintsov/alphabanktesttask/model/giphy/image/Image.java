package ru.odintsov.alphabanktesttask.model.giphy.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {

    private FixedWidthStill fixed_width_still;
    private PreviewGif preview_gif;
    private FixedHeightDownsampled fixed_height_downsampled;
    private Preview preview;
    private FixedHeightSmall fixed_height_small;
    private Downsized downsized;
    private FixedWidthDownsampled fixed_width_downsampled;
    private FixedWidth fixed_width;
    private DownsizedStill downsized_still;
    private DownsizedMedium downsized_medium;
    private OriginalMp4 original_mp4;
    private DownsizedLarge downsized_large;
    private PreviewWebp preview_webp;
    private Original original;
    private OriginalStill original_still;
    private FixedHeightSmallStill fixed_height_small_still;
    private FixedWidthSmall fixed_width_small;
    private Looping looping;
    private DownsizedSmall downsized_small;
    private FixedWidthSmallStill fixed_width_small_still;
    private FixedHeightStill fixed_height_still;
    private FixedHeight fixed_height;
    @JsonProperty("480w_still")
    private WStill480 _480w_still;
}
