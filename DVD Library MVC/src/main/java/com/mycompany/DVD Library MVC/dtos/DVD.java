/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summative2.dtos;

/**
 *
 * @author enjoi
 */
public class DVD {
    private int id;
    private String Title;
    private String ReleaseDate;
    private int MPAARating;
    private String DirectorName;
    private String Studio;
    private int UserRating;
    
       public DVD(int DVDId) {
        this.id = DVDId;
    }
       
       public DVD(){
           
       }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the ReleaseDate
     */
    public String getReleaseDate() {
        return ReleaseDate;
    }

    /**
     * @param ReleaseDate the ReleaseDate to set
     */
    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    /**
     * @return the MPAARating
     */
    public int getMPAARating() {
        return MPAARating;
    }

    /**
     * @param MPAARating the MPAARating to set
     */
    public void setMPAARating(int MPAARating) {
        this.MPAARating = MPAARating;
    }

    /**
     * @return the DirectorName
     */
    public String getDirectorName() {
        return DirectorName;
    }

    /**
     * @param DirectorName the DirectorName to set
     */
    public void setDirectorName(String DirectorName) {
        this.DirectorName = DirectorName;
    }

    /**
     * @return the Studio
     */
    public String getStudio() {
        return Studio;
    }

    /**
     * @param Studio the Studio to set
     */
    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    /**
     * @return the UserRating
     */
    public int getUserRating() {
        return UserRating;
    }

    /**
     * @param UserRating the UserRating to set
     */
    public void setUserRating(int UserRating) {
        this.UserRating = UserRating;
    }

}
