package com.virtualKey.Utilities;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author sranumula FileOperations class is used to do all the operations like
 *         adding a file, deleting a file, searching file.
 */
public class FileOperations {
	/**
	 * 
	 * @param path
	 * 
	 *             listAllFiles method is for to print the all the file in that
	 *             specific path in ascending order i am using list here so that by
	 *             using collections.sort it automatically arrange the order of file
	 *             by their name.	
	 */
	public void listAllFiles(String path) {
		Utils.pathChecking(path);
		File directoryPath = new File(path);
		List<String> listFile = Arrays.asList(directoryPath.list());
		Collections.sort(listFile);
		Utils.printMessage("List of files ");
		for (int i = 0; i < listFile.size(); i++) {
			Utils.printMessage(listFile.get(i));
		}
	}

	/**
	 * 
	 * @param filename---user enters the name of filename
	 * @param path            ---it defined in the
	 * @throws IOException newFile method is to create the file in specific path
	 *                     here, i using the file class . it has inbuilt method
	 *                     called createNewfile() it return boolean values. if file
	 *                     is created it returns true otherwise it returns false.
	 * 
	 */
	public void newFile(String filename, String path) throws IOException {
		Utils.filenameChecking(filename);
		Utils.pathChecking(path);
		File newFile = new File(path + filename);
		
		boolean createdFile = newFile.createNewFile();

		if (createdFile) {

			Utils.printMessage("\nFile Successfully Created: " + newFile.getAbsolutePath());

		} else if (!createdFile) {

			Utils.printMessage("\nFile Already Exist.. Please try again.");

		}

	}

	/**
	 * 
	 * @param filename
	 * @param path     for deleting the file i am using deletingFile() method
	 */
	public void deletingFile(String filename, String path) {
		Utils.filenameChecking(filename);
		Utils.pathChecking(path);

		File newFile = new File(path + filename);

		boolean deleteFile = newFile.delete();
		
		

		if (deleteFile) {

			Utils.printMessage("\nFile deleted Successfully");

		} else {

			Utils.printMessage("\nFile Not Found.. ");

		}

	}

	public void searchingFile(String filename, String path) {
		Utils.filenameChecking(filename);
		
		File dir = new File(path);
		
		if (!dir.exists())
			throw new IllegalArgumentException("Path does not exist");

		if (dir.isFile())
			throw new IllegalArgumentException("The given path is a file. A directory is expected.");

		String[] fileList = dir.list();
		boolean flag = false;

		Pattern pat = Pattern.compile(filename);

		if (fileList != null && fileList.length > 0) {
			for (String file : fileList) {
				Matcher mat = pat.matcher(file);
				if (mat.matches()) {
					Utils.printMessage("File Found at location: " + dir.getAbsolutePath());
					flag = true;
					break;
				}
			}
		}
		if (flag == false)
			Utils.printMessage("File Not Found..");

	}
}
