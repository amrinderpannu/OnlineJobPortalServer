package com.onlineJobPortal.services.job;

import com.onlineJobPortal.dto.FavouritesDto;
import com.onlineJobPortal.entity.Favourites;
import com.onlineJobPortal.responce.GeneralResponse;

import java.util.List;

public interface FavouritesService {

    GeneralResponse addFavorites(FavouritesDto jobDto);

    //List<String> getAllFavorites(Long userId);
    List<String> getAllFavorites(Long userId);

    void deleteFavorite(String id);

}
