package com.techelevator.model;

import java.time.LocalDate;

public class FavoriteThings {
    private String favoriteColor;
    private String favoriteFood;
    private String favoriteSeason;

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getFavoriteSeason() {
        return favoriteSeason;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setFavoriteSeason(String favoriteSeason) {
        this.favoriteSeason = favoriteSeason;
    }
}
