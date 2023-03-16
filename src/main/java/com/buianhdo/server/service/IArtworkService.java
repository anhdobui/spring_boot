package com.buianhdo.server.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.buianhdo.server.api.input.InputArtwork;
import com.buianhdo.server.api.output.OutputArtwork;

public interface IArtworkService {
    OutputArtwork save(InputArtwork inputArtwork);
    void delete(long[] ids);
    List<OutputArtwork> findAll(Pageable pageable);
    List<OutputArtwork> findAll();
    int totalItem();
}
