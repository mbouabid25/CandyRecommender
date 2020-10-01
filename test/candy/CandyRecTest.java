/**
*@author : Marwa Bouabid
*@version : 09/07/2020
*Disussed with Rhitom Mishra
*/
package candy;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CandyRecTest {
	
	//Declaring all the objects we need for out tests
	private static List<Candy> candies = new ArrayList<>();
	private static List<String> loves = new ArrayList<>();
	private static List<String> dislikes = new ArrayList<>();
	private static IngredientMap ingredientMap = new IngredientMap();

	@BeforeEach
	void setUp() throws Exception {
		initialize();
		CandyRecommender.readCandyFile();
		CandyRecommender.getUserPreferences();
		}
	
	static void initialize() {
        candies = new ArrayList<>();
        loves = new ArrayList<>();
        dislikes = new ArrayList<>();
        ingredientMap = new IngredientMap();
    }

		@Test
		void testfindLovedCandiesNone() throws FileNotFoundException
		{/*
	         * Purpose: Tests when the user has no dislikes
	         * Method: findLovedCandies
	         * Initialization: creating two candies
	         *  objects with specific ingredients
	         * Parameters: None
	         * Correct result: mms and caramellos
	         */
			CandyRecommender.addLoves("caramel");
			Candy mms = new Candy("m&ms", new String [] {"chocolate"});
			Candy caramellos = new Candy("caramellos", new String [] {"caramel"});
			Set<Candy> want = new HashSet<>();
			want.add(caramellos);
			assertTrue(allEqual(want, CandyRecommender.findLovedCandies()));
		}
		
		@Test
		void testfindLovedCandiesOne() throws FileNotFoundException
		{/*
	         * Purpose: Tests when the user has one dislike
	         * Method: findLovedCandies
	         * Initialization: creating two candies objects with specific ingredients
	         * Parameters: None
	         * Correct result: mms
	         */
			CandyRecommender.addDislike("caramel");
			Candy mms = new Candy("m&ms", new String [] {"chocolate"});
			Set<Candy> want = new HashSet<>();
			want.add(mms);
			assertTrue(allEqual(want, CandyRecommender.findLovedCandies()));
		}
		
		//helper method for testfindLovedCandiesOne and None
		private boolean allEqual(Set<Candy> a, Set<Candy> b) {
			if (a.size() >= b.size())
				return a.contains(b);
			else
				return b.contains(a);
		}
		
}
