//author: Sudarsana Sandeep

import java.util.ArrayList;

public class Country {

    private int armies;
    private String name;
    private Player ruler;
    private boolean hasRuler;
    private ArrayList<Country> adjacentCountries;

    public Country(String name) {
        this.name = name;
        hasRuler = false;
        armies = 0;
    }

    public String getName(){
        return name;
    }

    public int getArmies(){
        return armies;
    }

    public void setArmies(int army) {
        this.armies = army;
    }

    public void increaseArmyCount(int numArmy) {
        armies = numArmy + armies;
        //System.out.println();
    }

    public void decreaseArmyCount(int numArmy) {
        armies = armies - numArmy;
        //System.out.println();
    }

    public void setRuler(Player ruler) {
        this.ruler = ruler;
        hasRuler = true;
    }

    public Player getRuler(){
        return ruler;
    }

    public boolean hasRuler() {
        return this.hasRuler;
    }

    public void setAdjacentCountries(Country country) {
        adjacentCountries.add(country);
    }

    public ArrayList<Country> getAdjacentCountries() {
        return this.adjacentCountries;
    }

    public boolean checkAdjacentCountries(Country country, Country country2) {
        if(country.adjacentCountries.contains(country2)) {
            return true;
        } else {
            return false;
        }
    }
}
