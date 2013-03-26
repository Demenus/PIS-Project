package com.ub.pis.renderer.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadFile {
	
	public static String read(InputStream stream) throws IOException {
		Scanner sc = new Scanner(stream);
		String txt = "";
		while (sc.hasNextLine()) {
			txt += sc.nextLine();
		}
		stream.reset();
		return txt;
	}

}
