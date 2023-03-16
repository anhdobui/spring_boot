package com.buianhdo.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buianhdo.server.entity.ArtworkEntity;

public interface ArtworkRepository extends JpaRepository<ArtworkEntity,Long>{
}
