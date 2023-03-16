package com.buianhdo.server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtworkDto extends AbstractDto<ArtworkDto>  {
    private String name;
    private String thumbnail;
    private String album;
    private String price;
    private String width;
    private String height;
    private String deep;
    private String categoryid;
}
