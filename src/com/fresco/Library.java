package com.fresco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Library {

	String bookName;
	String author;

	Library() {
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.bookName);
		hash = 83 * hash + Objects.hashCode(this.author);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Library other = (Library) obj;
		if (!Objects.equals(this.bookName, other.bookName)) {
			return false;
		}
		if (!Objects.equals(this.author, other.author)) {
			return false;
		}
		return true;
	}

	Library(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
		HashMap<Integer, Library> libraryMap = new HashMap<>();
		ArrayList<String> bookList = new ArrayList<>();

		// tokenize the string
		StringTokenizer stringTokenizer = new StringTokenizer(booksInLibrary, "|");
		while (stringTokenizer.hasMoreTokens()) {

			bookList.add(stringTokenizer.nextToken());
		}

		// process each book
		for (String eachString : bookList) {
			// create the object of the Library class

			String[] splittedStrings = eachString.split(",");
			int bookId = Integer.parseInt(splittedStrings[0]);
			Library objLibrary = new Library(splittedStrings[1], splittedStrings[2]);
			// System.out.println("DEBUGGING " + objLibrary.author + " " +
			// objLibrary.bookName);
			libraryMap.put(bookId, objLibrary);

		}
		return libraryMap;
	}

	public HashMap<Integer, Integer> createUserMap(String borrowedUsers) {
		HashMap<Integer, Integer> userMap = new HashMap<Integer, Integer>();
		ArrayList<String> borrowedList = new ArrayList<>();

		StringTokenizer strkTokenizer = new StringTokenizer(borrowedUsers, "|");
		while (strkTokenizer.hasMoreTokens()) {
			borrowedList.add(strkTokenizer.nextToken());
		}

		for (String s : borrowedList) {
			String[] idStrings = s.split(",");

			userMap.put(Integer.parseInt(idStrings[0]), Integer.parseInt(idStrings[1]));// bookId,userId
		}
		return userMap;
	}

	public String getQuery(String booksInLibrary, String borrowedUsers, String query) {
		// process all the arguments
		int argI = 0, libBookCount = 0, borrowedBookCount = 0;
		ArrayList<Integer> foundBookId = new ArrayList<>();
		ArrayList<String> foundBookNames = new ArrayList<>();
		HashMap<Integer, Library> libraryMap = createLibraryMap(booksInLibrary);
		HashMap<Integer, Integer> userMap = createUserMap(borrowedUsers);
		String argS = null, resultString = "";

		String[] queriesStrings = query.split(",");
		int q = Integer.parseInt(queriesStrings[0]);

		if (q == 3 || q == 4 || q == 5)
			argS = queriesStrings[1];

		else
			argI = Integer.parseInt(queriesStrings[1]);
		// System.out.println(argS);
		// swtich case
		switch (q) {
		case 1: // the second parameter is an id
			/*
			 * Check first presence of the book in the library map if not then check in the
			 * user No test case mentioned if the bookId is not present
			 */
			// first discard the book ids given in the second Map from The first map
			for (Map.Entry<Integer, Integer> m : userMap.entrySet()) {
				if (libraryMap.containsKey(m.getKey()))
					libraryMap.remove(m.getKey());
			}

			if (libraryMap.containsKey(argI)) {
				// System.out.println("It is available\n author is " +
				// libraryMap.get(argI).author + "\n");
				resultString = "It is available\nAuthor is " + libraryMap.get(argI).author;
			}
			if (userMap.containsKey(argI)) {

				// System.out.println("No Stock\nBorrowed by " + m.getKey());
				resultString = "No Stock\nIt is Owned by " + userMap.get(argI);
				break;
			}
			break;
		case 2:// user id returns book details
			for (Map.Entry<Integer, Integer> m : userMap.entrySet()) {
				if (m.getValue() == argI) {// userId found
					// System.out.println(m.getKey() + " " + libraryMap.get(m.getKey()).bookName +
					// "\n");
					resultString += m.getKey() + " " + libraryMap.get(m.getKey()).bookName + "\n";
					// break;
				}
			}
			break;
		case 3: // argS is the book name first get the book id then check if present in the
				// library and then in the user
			for (Map.Entry<Integer, Library> m : libraryMap.entrySet()) {
				if (m.getValue().bookName.equals(argS)) {
					// then get the bookId
					libBookCount++;
					foundBookId.add(m.getKey());

				}
			}
			if (libBookCount != 0) {
				for (int i : foundBookId) {
					if (userMap.containsKey(i)) {
						borrowedBookCount++;
					}
				}

				// System.out.println((libBookCount - borrowedBookCount) + "in\n" +
				// borrowedBookCount + " out\n");
				resultString = borrowedBookCount + " out\n" + (libBookCount - borrowedBookCount) + " in";
			}
			break;
		case 4: // argS is the author name
			for (Map.Entry<Integer, Library> mEntry : libraryMap.entrySet()) {
				if (mEntry.getValue().author.equals(argS))
					foundBookNames.add(mEntry.getValue().bookName);
			}
			// foundBookNames.stream().forEach((e) -> System.out.println(e));
			for (String bString : foundBookNames)
				resultString += bString + '\n';
			// change the result in to a String and return
			break;
		case 5:// this is a key word fro a book name
			for (Map.Entry<Integer, Library> m : libraryMap.entrySet()) {
				if (m.getValue().bookName.contains(argS)) {
					// System.out.println(m.getKey() + " " + m.getValue().bookName + "\n");
					resultString += m.getKey() + " " + m.getValue().bookName + "\n";
				}
			}
			break;
		default:
			break;
		}
		return resultString;
	}
}
