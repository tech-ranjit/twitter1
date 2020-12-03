package com.twitter.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TwitterHastagsTrends {
	
	
	
	 private void loadFileWithReader() throws IOException {

	        try (FileReader fileReader = new FileReader("src/resources/test.txt");
	             BufferedReader reader = new BufferedReader(fileReader)) {
	            String contents = reader.lines()
	                .collect(Collectors.joining(System.lineSeparator()));
	            System.out.println(contents);
	        }

	    }

	    private void loadFileAsResource() throws IOException {

	        try (InputStream inputStream = getClass().getResourceAsStream("/input.txt");
	             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
	            String contents = reader.lines()
	                .collect(Collectors.joining(System.lineSeparator()));
	            System.out.println(contents);
	        }
	    }

	    public static void main(String[] args) throws IOException {

	    	TwitterHastagsTrends resourceLoader = new TwitterHastagsTrends();

	        resourceLoader.loadFileAsResource();
	        resourceLoader.loadFileWithReader();

	    }

	
	
	
	
	
	
	
	
	
	
	

	/*
	 * private String readFromInputStream(InputStream inputStream) throws
	 * IOException { StringBuilder resultStringBuilder = new StringBuilder(); try
	 * (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
	 * { String line; while ((line = br.readLine()) != null) {
	 * resultStringBuilder.append(line).append("\n"); } } return
	 * resultStringBuilder.toString(); } public void readTwitterTrends() throws
	 * IOException { ClassLoader classLoader = getClass().getClassLoader();
	 * InputStream inputStream = classLoader.getResourceAsStream("fileTest.txt");
	 * String data = readFromInputStream(inputStream); } String st; int paragraph =
	 * 1; while ((st = br.readLine()) != null) System.out.println(st);
	 * 
	 * Pattern pattern = Pattern.compile("(#\\w+)"); Matcher m;
	 * 
	 * LinkedHashMap<String, Integer> counter = new LinkedHashMap<String,
	 * Integer>(); for (int i = 0; i < paragraph; i++) { String line =
	 * br.readLine(); m = pattern.matcher(line); while (m.find()) {
	 * 
	 * if (null != counter.get(m.group())) { counter.put(m.group(),
	 * (counter.get(m.group()) + 1)); } else { counter.put(m.group(), new
	 * Integer(1)); }
	 * 
	 * }
	 * 
	 * } List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String,
	 * Integer>>(counter.entrySet()); Collections.sort(entries, new
	 * Comparator<Map.Entry<String, Integer>>() { public int
	 * compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) { if
	 * (b.getValue().equals(a.getValue())) return a.getKey().compareTo(b.getKey());
	 * else return b.getValue().compareTo(a.getValue()); } }); Map<String, Integer>
	 * sortedMap = new LinkedHashMap<String, Integer>(); for (Map.Entry<String,
	 * Integer> entry : entries) { sortedMap.put(entry.getKey(), entry.getValue());
	 * } Iterator<?> it = sortedMap.entrySet().iterator(); int counterTemp = 1;
	 * while (it.hasNext()) { Map.Entry pair = (Map.Entry) it.next();
	 * System.out.println(pair.getKey()); it.remove(); if (counterTemp == 5) break;
	 * counterTemp++; } }
	 * 
	 * 
	 * public static void main(String[] args) throws NumberFormatException,
	 * IOException {
	 * 
	 * TwitterHastagsTrends t = new TwitterHastagsTrends(); t.readTwitterTrends(); }
	 */
}
