package com.fresco.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class FrescoHasSetSolution {
	// who have played in squad2 not in squad1
	// static HashSet<String> playerSet = new HashSet<>();
	static ArrayList<Set<String>> playerArrayList = new ArrayList<Set<String>>();

	public static String getPlayers(int numberOfMatches, String squads, int squad1, int squad2) {
		String resultString;
		StringTokenizer stringTokenizer = new StringTokenizer(squads, "#");
		while (stringTokenizer.hasMoreTokens()) {
			String tokenString = new String(stringTokenizer.nextToken());
			tokenString = tokenString.replace(' ', ',');
			String[] tokenStringArray = tokenString.split(",");
			Set<String> playerSet = new HashSet<>(Arrays.asList(tokenStringArray));// new set of players for each
																					// match
			playerArrayList.add(playerSet);

		} // list of set of players
		Set<String> uniHashSet = new HashSet<>(playerArrayList.get(0));

		for (int i = 1; i < playerArrayList.size(); ++i) {
			uniHashSet.addAll(playerArrayList.get(i)); // union of all the sets these are the qhole squad
		}

		Set<String> interHashSet = new HashSet<>(uniHashSet);
		for (Set<String> eachHashSet : playerArrayList) {
			interHashSet.retainAll(eachHashSet);
		}
		Set<String> diffHashSet = new HashSet<>(playerArrayList.get(squad2 - 1));
		diffHashSet.removeAll(playerArrayList.get(squad1 - 1));

		// System.out.println(uniHashSet);

		resultString = interHashSet.stream().collect(Collectors.joining(" "));
		resultString += ", ";
		resultString += diffHashSet.stream().collect(Collectors.joining(" "));
		// System.out.println(interHashSet);
		// System.out.println("Result String for intersection: " + resultString);
		// System.out.println(diffHashSet);
		return resultString;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfMatches = 4;
		String squadString = "Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Daniel Patrício Nelson Pepe Mario Pereira Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo";
		int x = 2;
		int y = 4;
		System.out.println(getPlayers(numberOfMatches, squadString, x, y));

	}

}

/* Solution that worked */
/*
 * 
 * package com.fresco;
 * 
 * import java.util.ArrayList; import java.util.Arrays; import
 * java.util.HashSet; import java.util.Set; import java.util.StringTokenizer;
 * import java.util.stream.Collectors;
 * 
 * public class Hashset {
 * 
 * public static String getOut(int numberOfMatches, String squads, int squad1,
 * int squad2) { //write your code here String resultString;
 * ArrayList<Set<String>> playerArrayList=new ArrayList<Set<String>>();
 * StringTokenizer stringTokenizer = new StringTokenizer(squads, "#");
 * 
 * while (stringTokenizer.hasMoreTokens()) { String tokenString = new
 * String(stringTokenizer.nextToken()); tokenString = tokenString.replace(' ',
 * ','); String[] tokenStringArray = tokenString.split(",");
 * 
 * Set<String> playerSet = new
 * HashSet<String>(Arrays.asList(tokenStringArray));// new set of players for
 * each // match playerArrayList.add(playerSet);
 * 
 * } // list of set of players Set<String> uniHashSet = new
 * HashSet<String>(playerArrayList.get(0));
 * 
 * for (int i = 1; i < playerArrayList.size(); ++i) {
 * uniHashSet.addAll(playerArrayList.get(i)); // union of all the sets these are
 * the qhole squad }
 * 
 * Set<String> interHashSet = new HashSet<String>(uniHashSet); for (Set<String>
 * eachHashSet : playerArrayList) { interHashSet.retainAll(eachHashSet); }
 * Set<String> diffHashSet = new HashSet<String>(playerArrayList.get(squad2 -
 * 1)); diffHashSet.removeAll(playerArrayList.get(squad1 - 1));
 * 
 * // System.out.println(uniHashSet);
 * 
 * resultString = interHashSet.stream().collect(Collectors.joining(" "));
 * resultString += ", "; resultString +=
 * diffHashSet.stream().collect(Collectors.joining(" ")); //
 * System.out.println(interHashSet); //
 * System.out.println("Result String for intersection: " + resultString); //
 * System.out.println(diffHashSet); return resultString;
 * 
 * 
 * } }
 * 
 * 
 * 
 */