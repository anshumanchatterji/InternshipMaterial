package com.rahul.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class RahulsFileReader {

	public String readFullFile(File theFile) throws IOException {
		String fullFileText = "";
		try (BufferedReader br = new BufferedReader(new java.io.FileReader(theFile))) {
			while (true) {
				String aLine = br.readLine();
				if (aLine == null)
					break;
				fullFileText += aLine + "\n";
			}
		}
		return fullFileText;
	}
}
