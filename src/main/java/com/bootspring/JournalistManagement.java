package com.bootspring;

public class JournalistManagement {
    static double findAverageExperienceByRegion(Journalist[] journalists, String region){
        int sum = 0;
        int count=0;

        for(Journalist journals : journalists){
            if(journals.getRegion().equalsIgnoreCase(region)){
                sum+=journals.getExperience();
                count++;
            }
        }

        return (double) sum/count;
    }

    static Journalist searchJounalistsById(Journalist[] journalists, int id){
        Journalist matchedId=null;

        for(Journalist journals : journalists){
            if(journals.getId()==id){
                matchedId = journals;
            }
        }

        return matchedId;
    }
}

class Journalist{
    private int id;
    private String name;
    private int experience;
    private String region;

    public Journalist(int id, String name, int experience, String region) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}