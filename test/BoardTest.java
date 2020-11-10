import org.junit.Test;


import java.util.ArrayList;
//
import static org.junit.Assert.*;
///-author Yusuf J, Danish Butt
public class BoardTest {
    Board board = new Board(2); //Creating board with 2 players
    private final Country[] countries = new Country[42];
    private final ArrayList<Continent> continents = new ArrayList<>();

    @Test
    public void createPlayersTest() {
      //If 2 players are created then the size of the player array must be 2
        assertTrue(board.playerArray.size() == 2);
    }

    @Test
    public void createCountriesTest(){
        //When countries array is created Eastern Australia is supposed to be at index 0
        assertTrue(board.getCountries(0).equals("Eastern Australia"));
    }

    @Test
    public void createContinentsTest(){
        //When the continents array is created Australia is supposed to be in the array
        assertTrue(board.getContinent("Australia").getName().equals("Australia"));
    }

    @Test
    public void setInitialArmiesTest(){
        //When 2 players are created at index 2 there has to be 2 armies
        assertTrue(board.getCountries(2).getArmies()==2);
    }

    @Test
    public void setInitialRulersTest(){
        //When 2 players are created the first country in the array(index 0) is assigned to Player 1
        //Player 1 is stored at index 0
        assertTrue(board.getCountries(0).getRuler().equals(board.playerArray.get(0)));
    }

    @Test
    public void getContinentTest() {
        Continent c = new Continent("Somalia",5);
        //Created player
        Player p = new Player("Yusuf",5);
        p.addContinent(c);
        assertEquals(c,p.getContinent(0));
        assertTrue(p.getContinent(0)==c);
    }


    @Test
    public void setAdjacentCountries() {
        Country a1 = new Country("China");
        Country a2 = new Country("Russia");

        //checks if 2 countries were set to be adjacent to each other
        // by  creating 2 countries setting them to be adjacent to each other
        a1.setAdjacentCountries(a2);
        assertEquals(a2,a1.getAdjacentCountries().get(0));
        assertTrue(a1.getAdjacentCountries().get(0)==a2);

    }

    @Test
    public void getAdjacentCountries() {
        Country marty = new Country("China");
        Country news = new Country("Russia");

        marty.setAdjacentCountries(news);

        assertTrue(marty.getAdjacentCountries().get(0)==news);
    }

    @Test
    public void fortifyTest(){

        //moving 1 army from Eastern Australia to New Guinea
        board.fortify("Eastern Australia", "New Guinea", 1);
        int n = board.mapCountryToIndex("New Guinea");

        //New Guinea initially had 2 armies so now it should have 3 armies
        assertTrue(board.getCountries(n).getArmies()==3);
    }


}