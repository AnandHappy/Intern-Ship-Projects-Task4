package com.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.sql.rowset.WebRowSet;

public class FileWriteRead {
	public static final String file = "anand.txt";

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome to Notes ...");
			System.out.println("Enter 1 to Write new Notes");
			System.out.println("Enter 2 to Read the Notes");
			System.out.println("Enter 3 to Exit from the Notes..");

			System.out.println("Enter Your Choice::");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				writeNotes(sc);
				break;
			}
			case 2: {
				readnotes();
				break;
			}
			case 3: {
				System.out.println("Exiting from Notes..Thank You");
				break;

			}
			default: {
				System.out.println("Invalid Option.. Try Again..");
			}
			}
		}

	}

	public static void writeNotes(Scanner sc) {
		System.out.println("Enter Your Notes.");
		String note = sc.nextLine();
		try {
			FileWriter filewriter = new FileWriter(file);
			filewriter.write(note);
			System.out.println("Note saved Successfully..");
		} catch (IOException e) {
			System.out.println("Error in saving notes..please try again");
			e.printStackTrace();
		}

	}

	public static void readnotes() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				System.out.println(" " + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No Notes Found..Write some new notes..");
			e.printStackTrace();
		} catch (IOException io) {
			System.out.println("Error in reading notes..");
			io.printStackTrace();
		}
	}

}
