package com.buianhdo.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.buianhdo.server.api.input.InputArtwork;
import com.buianhdo.server.api.output.OutputArtwork;
import com.buianhdo.server.converter.ArtworkConverter;
import com.buianhdo.server.entity.ArtworkEntity;
import com.buianhdo.server.entity.CategoryEntity;
import com.buianhdo.server.repository.ArtworkRepository;
import com.buianhdo.server.repository.CategoryRepository;
import com.buianhdo.server.service.IArtworkService;

@Service
public class ArtworkService implements IArtworkService {
    
    @Autowired
    private ArtworkRepository artworkRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArtworkConverter artworkConverter;

    @Autowired
    private CacheManager cacheManager;
    
    @Override
    @CachePut(value = {"artworks","totalItem"})
    public OutputArtwork save(InputArtwork inputArtwork) {
        ArtworkEntity artworkEntity = new ArtworkEntity();
        if(inputArtwork.getId() != null ){
            Optional<ArtworkEntity> oldArtworkEntity = artworkRepository.findById(inputArtwork.getId().longValue());
            artworkEntity = artworkConverter.toEntity(inputArtwork, oldArtworkEntity);
        }else{
            artworkEntity = artworkConverter.toEntity(inputArtwork);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(inputArtwork.getCategoryid());
        artworkEntity.setCategory(categoryEntity);
        artworkEntity = artworkRepository.save(artworkEntity);
        return artworkConverter.toOutput(artworkEntity);
    }

    @Override
    @CacheEvict(value = {"artworks","totalItem"}, allEntries = true)
    public void delete(long[] ids) {
        for(long id: ids) {
			artworkRepository.deleteById(id);
		}
    }

    @Override
    @Cacheable("artworks")
    public List<OutputArtwork> findAll(Pageable pageable) {
        List<OutputArtwork> result = new ArrayList<>();
        List<ArtworkEntity> entities = artworkRepository.findAll(pageable).getContent();
        for(ArtworkEntity item : entities){
            OutputArtwork outputItem = artworkConverter.toOutput(item);
            result.add(outputItem);
        }
        return result;
    }

    @Override
    @Cacheable("totalItem")
    public int totalItem() {
        return (int) artworkRepository.count();
    }

    @Override
    @Cacheable("artworks")
	public List<OutputArtwork> findAll() {
        List<OutputArtwork> results = new ArrayList<>();
        List<ArtworkEntity> entities = artworkRepository.findAll();
        for(ArtworkEntity item : entities){
            OutputArtwork outputItem = artworkConverter.toOutput(item);
            results.add(outputItem);
        }
        return results;
	}
    
}
