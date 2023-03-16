package com.buianhdo.server.api.output;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputArtworks {
    private int page;
    private int totalPage;
    private List<OutputArtwork> listResult = new ArrayList<>();
}
