package com.virtualKey.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.virtualKey.Utilities.FileOperations;
import com.virtualKey.Utilities.Utils;

public class Screen extends Utils implements ScreenDisplay {
	private ArrayList<String> options = new ArrayList<>();
	FileOperations fileOperations = new FileOperations();
	Scanner scan = new Scanner(System.in);
	public Screen() {
		options.add("1.List of Files");
		options.add("2.More Options");
		options.add("3. quit");
	}
	@Override
	public void welcomMessage() {
		Utils.printMessage("------- ***** --------");
		Utils.printMessage("      Welcome      ");
		Utils.printMessage("------- ***** --------");
		Utils.printMessage("Application name : LockedMe.com");
		Utils.printMessage("Developer : Srilaxmi ");
		Utils.printMessage("------- ***** --------");	
	}

	@Override
	public void mainOptions() {
		Utils.printMessage("Main Menu");
		for (String option : options) {
			Utils.printMessage(option);
		}Utils.printMessage("Enter your Option :");
		mainMenuOptions();
	}

	public void mainMenuOptions() {
		int choice = 0;
		try {
			choice = Utils.scanner();
			
		} catch (NumberFormatException e) {
			Utils.printMessage("\nInvalid Input");
		}
		//checkingOptions(choice);
		navigateToMenuOptions(choice);
		
	}

//	public void checkingOptions(int choice) {
//		// Utils.printMessage(limit);
//		if (choice < 4) {
//			navigateToMenuOptions(choice);
//		} else {
//			Utils.printMessage("enter valid input( 1 to 3)");
//			mainOptions();
//		}
//	}

	private void navigateToMenuOptions(int choice) {
		char decision;
		Scanner sc = new Scanner(System.in);
		switch (choice) {

		case 1:
			try {
				Utils.printMessage("\n***********************************\n");
				fileOperations.listAllFiles(path);
			} catch (NullPointerException e) {
				Utils.printMessage(e.getMessage());
			} catch (IllegalArgumentException e) {
				Utils.printMessage(e.getMessage());
			} catch (Exception e) {
				Utils.printMessage(e.getMessage());
			}
			Utils.printMessage("\n***********************************\n");
			mainOptions();
			break;
		case 2:
			Utils.printMessage("\n***********************************\n");
			secondMenu();
			Utils.printMessage("\n***********************************\n");
			break;
		case 3:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("\n  you want to exit ? ");
			Utils.printMessage("  (Y) ==> Yes    (N) ==> No        ");
			decision = sc.nextLine().toUpperCase().charAt(0);
			if (decision == 'Y') {
				Utils.printMessage("\n");
				exitScreen();
				System.exit(1);
			} else if (decision == 'N') {
				Utils.printMessage("\n");
				mainOptions();
			} else {
				Utils.printMessage("\nInvalid Input enter-- Y/N");
				mainOptions();
			}Utils.printMessage("\n***********************************\n");

		default:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("Invalid Input ");
			Utils.printMessage("\n***********************************\n");
			mainOptions();
		}
	}

	private void secondMenu() {
		int choice = 0;
		subMenuOptions();
		
		// mainOptions();
		try {
			choice = Utils.scanner();
		} catch (NumberFormatException e) {
			Utils.printMessage("\nInvalid Input");
		}
		subMenuDetails(choice);
	}

	private void subMenuDetails(int choice) {
		String filename=null;
		switch (choice) {
		case 1:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("adding file....");
			Utils.printMessage("enter file name");
			filename=scan.nextLine().trim();
			try {
				fileOperations.newFile(filename,path);
			} catch (NullPointerException e) {
				Utils.printMessage("please try again...");
			} catch (IOException e) {
				Utils.printMessage("please try again...");
				e.printStackTrace();
			}
			Utils.printMessage("\n***********************************\n");
			secondMenu();
			break;
		case 2:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("Deleting file...");
			Utils.printMessage("enter file name");
			filename=scan.nextLine().trim();
			fileOperations.deletingFile(filename,path);
			Utils.printMessage("\n***********************************\n");
			secondMenu();
			break;
		case 3:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("Searching file...");
			Utils.printMessage("enter file name");
			filename=scan.nextLine().trim();
			fileOperations.searchingFile(filename,path);
			Utils.printMessage("\n***********************************\n");
			secondMenu();
			break;
		case 4:
			Utils.printMessage("\n***********************************\n");
			Utils.printMessage("Back to Main menu...");
			mainOptions();
			break;
		default:
			Utils.printMessage("\nInvalid Input ");
			subMenuOptions();
		}
	}

	@Override
	public void exitScreen() {
		Utils.printMessage("*************************************************");
		Utils.printMessage("*    THANK YOU FOR VISITING LOCKEDME.COM        *");
		Utils.printMessage("*                VISIT AGAIN                    *");
		Utils.printMessage("*************************************************");
		Utils.printMessage("\n\n");
	}

	public void subMenuOptions() {
		Utils.printMessage("-------------------------------------");
		Utils.printMessage(" Select any one                  ");
		Utils.printMessage("   1 - Add a file                 ");
		Utils.printMessage("   2 - Delete a file               ");
		Utils.printMessage("   3 - Search a file               ");
		Utils.printMessage("   4 - Go Back                     ");
		Utils.printMessage("--------------------------------------");
		Utils.printMessage("Enter your choice : ");
	}

}
