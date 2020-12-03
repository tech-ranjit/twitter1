package com.twitter.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	public  String readFromFile() {
		Path path = null;
		try {
			path = Paths.get(getClass().getClassLoader().getResource("src/com/twitter/test.txt").toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Stream<String> lines = null;
		try {
			lines = Files.lines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = lines.collect(Collectors.joining("\n"));
		lines.close();
		return data;

	}
	
	 static String readLineByLineJava8() 
	    {
	        StringBuilder contentBuilder = new StringBuilder();
	 
	        try (Stream<String> stream = Files.lines( Paths.get("E:\\new_work_spc\\TwitterHashtag\\src\\resources\\test.txt"), StandardCharsets.UTF_8)) 
	        {
	            stream.forEach(s -> contentBuilder.append(s).append("\n"));
	        }
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	 
	        return contentBuilder.toString();
	    }
}
