/**
*@author : Marwa Bouabid
*@version : 09/07/2020
*Disussed with Rhitom Mishra
*/
package candy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CandyTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCandyEmptyLikes() 
	{
		/*
         * Purpose: Bad User Input— tests for empty List likes
         * Method: score
         * Initialization:create a candy object 
         * Parameters: List<String> likes[ ] 
         * Correct result: 0
         */
		String [] ingredients = new String [] {"chocolate"};
		Candy mms = new Candy("m&ms", ingredients);
		List<String> likes = new ArrayList<>();
		List<String> loves = new ArrayList<>();
		assertEquals(0, mms.score(likes,loves));

	 }
	
	@Test
	void testCandyEmptyLoves() 
	{
		/*
         * Purpose: Bad User Input— tests for empty List loves
         * Method: score
         * Initialization:create a candy object 
         * Parameters: List<String> likes[ ] 
         * Correct result: 0
         */
		String [] ingredients = new String [] {"chocolate"};
		Candy mms = new Candy("m&ms", ingredients);
		List<String> loves = new ArrayList<>();
		List<String> likes = new ArrayList<>();
		assertEquals(0, mms.score(likes,loves));

	 }
	
	@Test
	void testCandyIngredientsOneLoveTwoLikes() 
	{
		/*
         * Purpose: Edge Case Test—tests for when all liked/loved ingredients are in candy
         * Method: score
         * Initialization:create a candy object 
         * Parameters: List<String> likes <chocolate, caramel, peanuts>
         * Correct result: 10
         */
		String [] ingredients = new String [] {"chocolate", "caramel", "peanuts"};
		Candy snickers = new Candy("snickers", ingredients);
		List<String> likes = new ArrayList<>();
		List<String> loves = new ArrayList<>();
		likes.add("chocolate");
		likes.add("caramel");
		loves.add("peanuts");
		assertEquals(10, snickers.score(likes,loves));

	 }
	
	@Test
	void testCandyIngredientsNoLovesOrLikes() 
	{
		/*
         * Purpose: Edge Case Test—tests for when no liked/loved ingredients are in candy
         * Method: score
         * Initialization:create a candy object 
         * Parameters: List<String> <fruit, toffee, peppermint>, 
         * (i.e. no common ingredients with candy object)
         * Correct result: 0
         */
		String [] ingredients = new String [] {"chocolate", "caramel", "peanuts"};
		Candy fruitLoop = new Candy("fruitloop", ingredients);
		List<String> likes = new ArrayList<>();
		List<String> loves = new ArrayList<>();
		likes.add("fruit");
		likes.add("toffee");
		loves.add("peppermint");
		assertEquals(0, fruitLoop.score(likes,loves));

	 }
	
	@Test
	void testCandyDuplicateLikeAndLove() 
	{
		/*
         * Purpose: Edge Case Test—tests for when no liked/loved ingredients are in candy
         * Method: score
         * Initialization:create a candy object 
         List<String> likes <caramel, fruit, chocolate, chocolate > 
         *with a duplicate ingredient (chocolate), and all the 
         *rest of the ingredients are not in the candy
         * Correct result: 20
         */
		String [] ingredients = new String [] {"chocolate"};
		Candy mms = new Candy("m&ms", ingredients);
		List<String> likes = new ArrayList<>();
		List<String> loves = new ArrayList<>();
		likes.add("fruit");
		likes.add("caramel");
		likes.add("chocolate");
		loves.add("chocolate");
		assertEquals(20, mms.score(likes,loves));
	 }
	
	@Test
	void testCandyIngredientsSome() 
	
	{
		/*
         * Purpose: Equivalence Case—tests for when some ingredients in 
         * List likes/loves appear in List ingredients 
         * Method: score
         * Initialization:create a candy object 
         *List<String> likes <caramel, fruit, chocolate, chocolate > 
         *construct candy Snickers with ingredients [chocolate, caramel, peanuts]
         *correct result : 2*10/3
         */
		String [] ingredients = new String [] {"chocolate", "caramel", "peanuts"};
		Candy snickers = new Candy("snickers", ingredients);
		List<String> likes = new ArrayList<>();
		List<String> loves = new ArrayList<>();
		likes.add("chocolate");
		likes.add("caramel");
		loves.add("sugar");
		assertEquals(2*10/3, snickers.score(likes,loves));

	 }
	
	@Test
	void testConstructor()
	{
		/*
         * Purpose: Testing if the constructor functions correctly 
         * Method: Candy
         * Initialization
         * construct candy Snickers with ingredients [chocolate, caramel, peanuts]
         * correct result : Snickers
         */
		   String[] ingredients = {"chocolate", "peanuts", "caramel"};
	       Candy snickers = new Candy("Snickers", ingredients);
	       assertEquals ("Snickers", snickers.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
