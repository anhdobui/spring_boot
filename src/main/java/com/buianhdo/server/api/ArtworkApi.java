package com.buianhdo.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buianhdo.server.api.input.InputArtwork;
import com.buianhdo.server.api.output.OutputArtwork;
import com.buianhdo.server.api.output.OutputArtworks;
import com.buianhdo.server.service.impl.ArtworkService;

@RestController
@RequestMapping(value = "/api")
public class ArtworkApi {

    @Autowired
    private ArtworkService artworkService;
    
    @GetMapping(value="/artwork")
    public OutputArtworks getArtwork(@RequestParam(value="page",required = false) Integer page,
                                    @RequestParam(value="limit",required = false) Integer limit){
        OutputArtworks result = new OutputArtworks();
        if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = PageRequest.of(page - 1, limit);
			result.setListResult(artworkService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (artworkService.totalItem()) / limit));
		} else {
			result.setListResult(artworkService.findAll());
		}
		return result;
    }
    @PostMapping(value="/artwork")
    public OutputArtwork createArtwork(@RequestBody InputArtwork model){
        return artworkService.save(model);
    }

    @PutMapping(value="/artwork/{id}")
    public OutputArtwork updateArtwork(@RequestBody InputArtwork model,@PathVariable("id") long id){
        model.setId(id);
        return artworkService.save(model);
    }

    @DeleteMapping(value="/artwork")
    public void deleteArtwork(@RequestBody long[] ids){
        artworkService.delete(ids);
    }
}
