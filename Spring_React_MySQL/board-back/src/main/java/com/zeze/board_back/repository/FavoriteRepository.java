package com.zeze.board_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeze.board_back.entity.FavoriteEntity;
import com.zeze.board_back.entity.primaryKey.FavoritePk;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk>{
    
    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);

}
