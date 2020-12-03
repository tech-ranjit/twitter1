package com.twitter.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterTrends {
	public static void main(String[] args) throws NumberFormatException, IOException {

		FileUtils fileUtils = new FileUtils();
		String fileContent = FileUtils.readLineByLineJava8();
		System.out.print(fileContent);
		String path = "E:\\new_work_spc\\TwitterHashtag\\src\\resources\\test.txt";
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

		LinkedHashMap<String, Integer> hashTagCounterMap = countHashTag(reader);
		System.out.println(hashTagCounterMap);

		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(hashTagCounterMap.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
				if (b.getValue().equals(a.getValue()))
					return a.getKey().compareTo(b.getKey());
				else
					return b.getValue().compareTo(a.getValue());
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Iterator it = sortedMap.entrySet().iterator();
		int counterTemp = 1;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey());
			it.remove();
			if (counterTemp == 5)
				break;
			counterTemp++;
		}
	}

	public static LinkedHashMap<String, Integer> countHashTag(BufferedReader reader) {
		LinkedHashMap<String, Integer> hashTagCounterMap = new LinkedHashMap<String, Integer>();
		Pattern pattern = Pattern.compile("(#\\w+)");
		Matcher m;

		String line;
		try {
			while (Objects.nonNull(line = reader.readLine())) {

				m = pattern.matcher(line);
				while (m.find()) {

					if (Objects.nonNull(hashTagCounterMap.get(m.group()))) {
						hashTagCounterMap.put(m.group(), (hashTagCounterMap.get(m.group()) + 1));
					} else {
						hashTagCounterMap.put(m.group(), new Integer(1));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashTagCounterMap;
	}

}