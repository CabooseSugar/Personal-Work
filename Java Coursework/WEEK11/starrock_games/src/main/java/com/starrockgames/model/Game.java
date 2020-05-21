package com.starrockgames.model;

public class Game {

    //
    //  instance data
    private Long gameId;
    private String gameName;
    private Double price;
    private Character rating;

    public Game(Long gameId, String gameName, Double price, Character rating) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.price = price;
        this.rating = rating;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Character getRating() {
        return rating;
    }

    public void setRating(Character rating) {
        this.rating = rating;
    }
}
