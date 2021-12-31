package com.rahul.FileSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class FileSystemUtil {

	File _basePath = null;

	/**
	 * This is a constructor without arguments
	 */
	public FileSystemUtil() {
		String currentDir = System.getProperty("user.dir");
		_basePath = new File(currentDir);
	}

	/**
	 * This is a constructor with arguments
	 * 
	 * @param path
	 *            Provide the path
	 * @throws FileNotFoundException
	 */
	public FileSystemUtil(String path) throws FileNotFoundException {
		_basePath = new File(path);
		if (_basePath.exists() == false)
			throw new FileNotFoundException(path);
	}

	public void printProperties() {
		// isFile
		// isDirectory
		// CreatedOn
		// CreatedBy
		// LastModifiedOn
		// FullPath
		// Extension if File

		System.out.println("Name: " + _basePath.getName());
		System.out.println("IsFile: " + _basePath.isFile());
		System.out.println("IsDirectory: " + _basePath.isDirectory());
		// System.out.println("CreatedOn: " + _basePath.);
		System.out.println("Last Modified On: " + new Date(_basePath.lastModified()));
		System.out.println("Full Path: " + _basePath.getAbsolutePath());
		if (_basePath.isFile())
			System.out.println("Extension: " + getExtension(_basePath));
	}

	private String getExtension(File f) {
		String extension = "";
		String fileName = f.getName();

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public void printAllFilesAndDirectories() throws Exception {
		if (_basePath.isFile())
			throw new Exception("The provided path is a File. Cannot continue");

		// this is a directory
		System.out.println(_basePath.getName());
		for (File f : _basePath.listFiles()) {
			System.out.println(" |--" + f.getName());
		}
	}

	public void printAllFilesAndDirectoriesRecursively() throws Exception {
		System.out.println(_basePath.getName());
		this.printAllFilesAndDirectoriesRecursively(_basePath, 1);
	}

	public void printAllFilesAndDirectoriesRecursively(File aFile, int level) throws Exception {
		if (aFile.isDirectory()) {
			// this is a directory

			List<File> subFilesOrDirs = new ArrayList<File>();
			for (File f : aFile.listFiles()) {
				subFilesOrDirs.add(f);
			}

			Collections.sort(subFilesOrDirs, (a, b) -> {

				if (a.isFile() && b.isFile())
					return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());

				if (a.isDirectory() && b.isDirectory())
					return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());

				if (a.isFile()) // b is dir
					return -1;

				else // b is file
					return +1;

			});


			for (File f : subFilesOrDirs) {
				String spaces = new String(new char[level]).replace("\0", " ");

				if (f.isFile()) {
					System.out.println(spaces + " |  " + f.getName());
				} else {
					System.out.println(spaces + " |  ");
					System.out.println(spaces + " |- " + f.getName());
				}
				printAllFilesAndDirectoriesRecursively(f, level + 1);
			}

		}
	}

}
