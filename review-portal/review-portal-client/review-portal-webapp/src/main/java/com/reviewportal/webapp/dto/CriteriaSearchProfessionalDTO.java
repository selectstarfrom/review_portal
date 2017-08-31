package com.reviewportal.webapp.dto;

public class CriteriaSearchProfessionalDTO {

    private String searchProfessionTitle;
    private String searchName;
    private String searchRatingMin;
    private String searchRatingMax;
    private String searchCity;
    private String searchState;
    private String searchZip;
    private String searchGender;

    

    public String getSearchProfessionTitle() {
        return searchProfessionTitle;
    }

    public void setSearchProfessionTitle(String pSearchProfessionTitle) {
        searchProfessionTitle = pSearchProfessionTitle;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String pSearchName) {
        searchName = pSearchName;
    }

    public String getSearchRatingMin() {
        return searchRatingMin;
    }

    public void setSearchRatingMin(String pSearchRatingMin) {
        searchRatingMin = pSearchRatingMin;
    }

    public String getSearchRatingMax() {
        return searchRatingMax;
    }

    public void setSearchRatingMax(String pSearchRatingMax) {
        searchRatingMax = pSearchRatingMax;
    }

    public String getSearchCity() {
        return searchCity;
    }

    public void setSearchCity(String pSearchCity) {
        searchCity = pSearchCity;
    }

    public String getSearchState() {
        return searchState;
    }

    public void setSearchState(String pSearchState) {
        searchState = pSearchState;
    }

    public String getSearchZip() {
        return searchZip;
    }

    public void setSearchZip(String pSearchZip) {
        searchZip = pSearchZip;
    }

    public String getSearchGender() {
        return searchGender;
    }

    public void setSearchGender(String pSearchGender) {
        searchGender = pSearchGender;
    }

}
