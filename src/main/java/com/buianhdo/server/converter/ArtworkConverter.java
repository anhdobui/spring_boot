package com.buianhdo.server.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.buianhdo.server.api.input.InputArtwork;
import com.buianhdo.server.api.output.OutputArtwork;
import com.buianhdo.server.entity.ArtworkEntity;

@Component
public class ArtworkConverter  {

    public ArtworkEntity toEntity(InputArtwork inputArtwork) {
        ArtworkEntity entity = new ArtworkEntity();
		entity.setName(inputArtwork.getName());
		entity.setAlbum(inputArtwork.getAlbum());
		entity.setDeep(inputArtwork.getDeep());
		entity.setHeight(inputArtwork.getHeight());
		entity.setWidth(inputArtwork.getWidth());
        entity.setPrice(inputArtwork.getPrice());
        entity.setThumbnail(inputArtwork.getThumbnail());
		return entity;
    }

    public OutputArtwork toOutput(ArtworkEntity entity) {
        OutputArtwork outputArtwork = new OutputArtwork();
        if(entity.getCategory() != null){
            outputArtwork.setCategoryid(entity.getCategory().getId().toString());
        }
        outputArtwork.setAlbum(entity.getAlbum());
        outputArtwork.setDeep(entity.getDeep());
        outputArtwork.setHeight(entity.getHeight());
        outputArtwork.setWidth(entity.getWidth());
        outputArtwork.setName(entity.getName());
        outputArtwork.setPrice(entity.getPrice());
        outputArtwork.setThumbnail(entity.getThumbnail());
        outputArtwork.setCreatedBy(entity.getCreatedBy());
        outputArtwork.setCreatedDate(entity.getCreatedDate());
        outputArtwork.setModifiedDate(entity.getModifiedDate());
        outputArtwork.setModifiedBy(entity.getModifiedBy());
        return outputArtwork;
    }

    public ArtworkEntity toEntity(InputArtwork inputArtwork , Optional<ArtworkEntity> oldEntity) {
        ArtworkEntity entity = oldEntity.orElse(new ArtworkEntity());
		entity.setName(inputArtwork.getName());
		entity.setAlbum(inputArtwork.getAlbum());
		entity.setDeep(inputArtwork.getDeep());
		entity.setHeight(inputArtwork.getHeight());
		entity.setWidth(inputArtwork.getWidth());
        entity.setPrice(inputArtwork.getPrice());
        entity.setThumbnail(inputArtwork.getThumbnail());
		return entity;
    }



    
    
}
