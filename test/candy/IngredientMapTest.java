/**
*@author : Marwa Bouabid
*@version : 09/07/2020
*Disussed with Rhitom Mishra
*/
package candy;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientMapTest {

	static Map<String, List<Candy>> ingredientMap = new HashMap<>();
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testIngredients() {
		 /*
		* Purpose: test whether all the correct ingredients are returned 
		* the ingredient map is empty
		* Method: ingredients() in IngredientsMap.java
		* Initialization:test done on specific candy(ies) for example HeathBar: 
		* construct a map with pair [chocolate, toffee]
		* Parameters: None
		* Correct result: all the correct ingredients in the candy are returned 
		* for example <chocolate, toffee>
		*/
		String [] ingredients = new String [] {"caramel"};
		Candy mms = new Candy("m&ms", ingredients);
		Candy caramellos = new Candy("caramellos", ingredients);
		IngredientMap ingredientMap = new IngredientMap();
		ingredientMap.add("caramel", mms);
		ingredientMap.add("caramel", caramellos);
		Set<String> ingredientSet = new HashSet<String>();
		ingredientSet.add("caramel");
		assertEquals(ingredientSet, ingredientMap.ingredients());
		
	}

	@Test
	void testIngredientsEmpty() {
		 /*
		* Purpose:test whether ingredients will be returned when 
		* the ingredient map is empty
		* Method: ingredients() in IngredientsMap.java
		* Initialization:create an empty ingredient map
		* Parameters: None
		* Correct result: empty set
		*/
		IngredientMap ingredientMap = new IngredientMap();
		Set<String> ingredientSet = new HashSet<String>();
		assertEquals(ingredientSet, ingredientMap.ingredients());
}
	
	@Test
	void addtestOneIngredient() {
    /*
	* Purpose: Test newList.add(candy); statement and 
	* ingredientMap.put(ingredient, newList); statement
	* for one ingredient in one candy
	* Method:  add
	* Initialization:Create a List of Candy named newList, 
	* Create a Hashmap called ingredientMap
	* Parameters: String Strawberry, Candy haribo
	* Correct result: haribo
	*/
	String [] ingredients = new String [] {"strawberry"};
	Candy haribo = new Candy("haribo", ingredients);
	IngredientMap ingredientMapObj = new IngredientMap();
	ingredientMapObj.add("strawberry", haribo);
	List<Candy> candies = new ArrayList<Candy>();
	candies.add(haribo);
	assertEquals(candies, ingredientMapObj.getMap().get("strawberry"));
	}
	
	@Test
	void addtestTwoIngredients() {
    /*
	* Purpose: Test newList.add(candy); statement and 
	* ingredientMap.put(ingredient, newList); statement
	* for two candies with tow different ingredients 
	* Method:  add
	* Initialization:Create a List of Candy named newList, 
	* Create a Hashmap called ingredientMap
	* Parameters: String Strawberry, Candy haribo, string pomegrenate, candy haribo
	* Correct result: haribo for strawberry and gummy for pomegrante
	*/
	String [] ingredient1 = new String [] {"strawberry"};
	String [] ingredient2 = new String [] {"pomegrenate"};
	Candy haribo = new Candy("haribo", ingredient1);
	Candy gummy = new Candy("gummy", ingredient2);
	IngredientMap ingredientMapObj = new IngredientMap();
	ingredientMapObj.add("strawberry", haribo);
	ingredientMapObj.add("pomegrenate", gummy);
	List<Candy> candy1 = new ArrayList<Candy>();
	List<Candy> candy2 = new ArrayList<Candy>();
	candy1.add(haribo);
	candy2.add(gummy);
	assertEquals(candy1, ingredientMapObj.getMap().get("strawberry"));
	assertEquals(candy2, ingredientMapObj.getMap().get("pomegrenate"));
	
	}
	
	@Test
	void addtestTwoCandies() {
    /*
	* Purpose: Test newList.add(candy); statement and 
	* ingredientMap.put(ingredient, newList); statement when two
	* candies have the same ingredient
	* Method:  add
	* Initialization:Create a List of Candy named newList, 
	* Create a Hashmap called ingredientMap
	* Parameters: String Strawberry, Candy haribo, string pomegrenate, candy haribo
	* Correct result: haribo for strawberry and gummy for pomegrante
	*/
	String [] ingredient = new String [] {"strawberry"};
	Candy haribo = new Candy("haribo", ingredient);
	Candy gummy = new Candy("gummy", ingredient);
	IngredientMap ingredientMapObj = new IngredientMap();
	ingredientMapObj.add("strawberry", haribo);
	ingredientMapObj.add("strawberry", gummy);
	List<Candy> candies = new ArrayList<Candy>();
	candies.add(haribo);
	candies.add(gummy);
	assertEquals(candies, ingredientMapObj.getMap().get("strawberry"));
	
	}
	@Test
	void returntest()
	{
	/*
    * Purpose: Test return ingredientMap.keySet(); statement
    * Method: ingredients
    * Initialization:Create a Hashmap called ingredientMap 
    * as follows : (“Strawberry”, <Popsicle>, "apple", <popsicle>)
    * Parameters: List<String> likes[ ] 
    * Correct result: Strawberry, apple
    */
	String [] ingredients1 = new String [] {"strawberry"};
	String [] ingredients2 = new String [] {"strawberry"};
	String [] ingredients3 = new String [] {"apple"};
	Candy popsicle = new Candy("popsicle", ingredients1);
	Candy jelly = new Candy("jelly", ingredients2);
	Candy gummy = new Candy("jelly", ingredients3);
	IngredientMap ingredientMap = new IngredientMap();
	Set<String> popsicleSet = new HashSet<String>();
	popsicleSet.add("Strawberry");
	popsicleSet.add("apple");
	ingredientMap.add("Strawberry", popsicle);
	ingredientMap.add("apple", popsicle);
	assertEquals(popsicleSet, ingredientMap.ingredients());
	}
	
	
}

   
