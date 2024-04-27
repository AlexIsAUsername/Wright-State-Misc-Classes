/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yeoh_project5;

/**
 *
 * @author alexyeoh
 */
class CharacterFramework implements Comparable<CharacterFramework> {

    private String name;
    private String race;
    private String theClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    //constructors
    public CharacterFramework(String name, String race, String theClass, int str, int dex, int con, int inte, int wis, int cha) {
        this.name = name;
        this.race = race;
        this.theClass = theClass;
        this.strength = str;
        this.dexterity = dex;
        this.constitution = con;
        this.intelligence = inte;
        this.wisdom = wis;
        this.charisma = cha;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public String getTheClass() {
        return this.theClass;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setTheClass(String theClass) {
        this.theClass = theClass;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    //toString
    @Override
    public String toString() {
        return "Name: " + this.name + "\nRace: " + this.race + "\nClass: " + this.theClass
                + "\nStrength: " + this.strength + "\nDexterity: " + this.dexterity
                + "\nConstitution: " + this.constitution + "\nIntelligence: " + this.intelligence
                + "\nWisdom: " + this.wisdom + "\nCharisma: " + this.charisma;
    }

    //compareTo
    @Override
    public int compareTo(CharacterFramework otherCharacter) {
        return this.name.compareTo(otherCharacter.name);
    }

}
