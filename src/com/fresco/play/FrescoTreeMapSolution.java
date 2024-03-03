package com.fresco.play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class CricketTeam {
	public TreeMap<Integer, String> createPlayerPositionMap(String cricketDataset) {

		// 3,Dhoni,120 position,Name,score
		ArrayList<String> detailsList = new ArrayList<>();
		TreeMap<Integer, String> playerPositionTreeMap = new TreeMap<>();

		// tokenize the string
		StringTokenizer stringTokenizer = new StringTokenizer(cricketDataset, "|");
		while (stringTokenizer.hasMoreTokens()) {
			detailsList.add(stringTokenizer.nextToken());
		}

		for (String s : detailsList) {
			String[] detailStrings = s.split(",");
			playerPositionTreeMap.put(Integer.parseInt(detailStrings[0]), detailStrings[1]);
		}
		System.out.println(playerPositionTreeMap.toString());
		return playerPositionTreeMap;

	}

	public TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset) {
		// 3,Dhoni,120 position,Name,score
		ArrayList<String> detailsList = new ArrayList<>();
		TreeMap<String, Integer> playerScoreTreeMap = new TreeMap<>();

		// tokenize the string

		StringTokenizer stringTokenizer = new StringTokenizer(cricketDataset, "|");
		while (stringTokenizer.hasMoreTokens()) {
			detailsList.add(stringTokenizer.nextToken());
		}

		for (String s : detailsList) {
			String[] detailStrings = s.split(",");
			playerScoreTreeMap.put(detailStrings[1], Integer.parseInt(detailStrings[2]));
		}
		return playerScoreTreeMap;

	}

	public TreeMap<?, ?> createMatchesMap(String cricketDataset) {
		// use 3 maps
		// 1.Name:Occur
		// 2.Name:total run
		// total/occue:Name in tree map so will be in sorted order
		HashMap<String, Integer> nameOccurrenceMap = new HashMap<>();
		HashMap<String, Double> playerTotalScoreHashMap = new HashMap<>();
		TreeMap<Double, String> playerAverageScoreMap = new TreeMap<>();
		ArrayList<StringTokenizer> tokenizedPlayerDetailsList = new ArrayList<>();

		String playerName;
		Double score;
		String[] splittedStrings = cricketDataset.split("\n");

		for (String s : splittedStrings) {
			StringTokenizer stringTokenizer = new StringTokenizer(s, "|");
			tokenizedPlayerDetailsList.add(stringTokenizer);
		}

		for (StringTokenizer s : tokenizedPlayerDetailsList) {
			while (s.hasMoreTokens()) {
				// System.out.println(s.nextToken());
				// String tempString = s.nextToken();
				// System.out.println(tempString);

				String[] tokenArrayStrings = s.nextToken().split(",");
				playerName = tokenArrayStrings[1];
				score = Double.parseDouble(tokenArrayStrings[2]);

				// System.out.println("Scanning: " + playerName + " " + score);

				if (nameOccurrenceMap.containsKey(playerName)) {
					nameOccurrenceMap.put(playerName, nameOccurrenceMap.get(playerName) + 1);
				} else {
					nameOccurrenceMap.put(playerName, 1);
				}

				if (playerTotalScoreHashMap.containsKey(playerName)) {
					playerTotalScoreHashMap.put(playerName, playerTotalScoreHashMap.get(playerName) + score);
				} else {
					playerTotalScoreHashMap.put(playerName, (0 + score));
				}

			}

			// System.out.println(s.nextToken());
		}
		// check for the keys
		for (Map.Entry<String, Integer> m : nameOccurrenceMap.entrySet()) {
			int numberOfMatchesPlayed = m.getValue();
			String currentPlayerNamString = m.getKey();
			Double totalScore = playerTotalScoreHashMap.get(currentPlayerNamString);

			Double avgDouble = totalScore / numberOfMatchesPlayed;

			playerAverageScoreMap.put(avgDouble, currentPlayerNamString);
		}
		// System.out.println(nameOccurrenceMap.toString());
		// System.out.println(playerTotalScoreHashMap.toString());
		// System.out.println(playerAverageScoreMap.toString());

		// tokenizedPlayerDetailsList.stream().forEach((e) ->
		// System.out.println(e.nextToken()));
		return playerAverageScoreMap;
	}

	@SuppressWarnings({ "unchecked" })
	public String getQuery(String cricketDataset, String query) {
		Stack<String> reStack = new Stack<>();
		String resultString = "";
		String[] argStrings = query.split(" ");

		if (((Integer.parseInt(argStrings[0])) ^ 1) == 0) {
			int start = Integer.parseInt(argStrings[1]);
			int end = Integer.parseInt(argStrings[2]);
			TreeMap<Integer, String> playerPosName = createPlayerPositionMap(cricketDataset);
			for (int i = start; i <= end; ++i) {
				// if contains should be provided
				resultString += i + " " + playerPosName.get(i) + "\n";
			}
		}

		if (((Integer.parseInt(argStrings[0])) ^ 2) == 0) {
			int thresholdScore = Integer.parseInt(argStrings[1]);
			TreeMap<Integer, String> playerPosName = createPlayerPositionMap(cricketDataset);
			TreeMap<String, Integer> playerScoreName = createPlayerScoreMap(cricketDataset);
			for (Map.Entry<String, Integer> m : playerScoreName.entrySet()) {

				if (m.getValue() >= thresholdScore) {
					String nmString = m.getKey();
					if (playerPosName.containsValue(nmString)) {
						for (Map.Entry<Integer, String> m1 : playerPosName.entrySet()) {

							if (m1.getValue().equals(nmString)) {
								// resultString += m1.getKey() + " " + nmString + "\n";
								String temp = m1.getKey() + " " + nmString + "\n";
								System.out.println("Pushing: " + temp);
								reStack.push(temp);
								break;
							}
						} // inner for loop
					} // inner if
				} // outer if
			} // outer for

			while (!reStack.empty()) {
				resultString += reStack.pop();
			}

		}

		if (((Integer.parseInt(argStrings[0])) ^ 3) == 0)

		{
			TreeMap<Double, String> playerAverageMap = (TreeMap<Double, String>) createMatchesMap(cricketDataset);
			resultString += "The Efficient Opener is " + playerAverageMap.get(playerAverageMap.lastKey());
		}

		return (resultString != "") ? resultString : null;
	}

}

public class FrescoTreeMapSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CricketTeam objeCricketTeam = new CricketTeam();
		final String cricketDataSetString_1_2 = "3,Dhoni,120|1,Virat,103|5,Jadeja,40|2,Rohit,70|4,Pandya,30";
		final String cricketDataSetString_3 = "3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n3,Jadeja,43|2,Virat,54|1,Rohit,40|4,Dhoni,59";
		final String str_3 = "1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69";
		final String str_3_2 = "3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69";
		final String str_3_4 = "1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69";
		final String str_2_1 = "3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150";
		final String str_1_1 = "3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150";
		System.out.println(objeCricketTeam.getQuery(str_3_4, "3"));
		System.out.println(objeCricketTeam.getQuery(str_1_1, "1 4 6"));
		System.out.println(objeCricketTeam.getQuery(str_2_1, "2 100"));

		// TreeMap<?, ?> tMap = objeCricketTeam.createMatchesMap();
	}

}
