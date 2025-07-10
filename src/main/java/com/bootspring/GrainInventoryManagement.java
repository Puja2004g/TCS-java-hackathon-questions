package com.bootspring;

public class GrainInventoryManagement {
    static int countGrainByName(Grain[] grains, String name){
        int count=0;

        for(Grain grain:grains){
            if(grain.getGrainName().equalsIgnoreCase(name)){
                count++;
            }
        }

        return count;
    }

    static Grain getMinGrainFromMaharashtra(Grain[] grains){
        if(grains==null){
            return null;
        }
        Grain fromMaharashtra=null;
        int quintal=Integer.MAX_VALUE;

        for(Grain grain:grains){
            if(grain.getState().equalsIgnoreCase("Maharashtra")){
                if(grain.getGtyinQuintal()<quintal){
                    quintal=grain.getGtyinQuintal();
                    fromMaharashtra = grain;
                }
            }
        }

        return fromMaharashtra;
    }
}

class Grain{
    private int grainId;
    private String grainName;
    private String state;
    private int gtyinQuintal;

    public Grain(int grainId, String grainName, String state, int gtyinQuintal) {
        this.grainId = grainId;
        this.grainName = grainName;
        this.state = state;
        this.gtyinQuintal = gtyinQuintal;
    }

    public int getGrainId() {
        return grainId;
    }

    public void setGrainId(int grainId) {
        this.grainId = grainId;
    }

    public String getGrainName() {
        return grainName;
    }

    public void setGrainName(String grainName) {
        this.grainName = grainName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getGtyinQuintal() {
        return gtyinQuintal;
    }

    public void setGtyinQuintal(int gtyinQuintal) {
        this.gtyinQuintal = gtyinQuintal;
    }
}