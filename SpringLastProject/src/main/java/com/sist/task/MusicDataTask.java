package com.sist.task;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class MusicDataTask {
	//@Scheduled(fixedRate = 10000)
	public void musicAllData() {
		List<String> list=new ArrayList<String>();
		try {
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title=doc.select("div.music-list-wrap table.list-wrap a.title");
			for(int i=0;i<title.size();i++) {
				//System.out.println((i+1)+"."+title.get(i).text());
				list.add(title.get(i).text());
			}
			Collections.shuffle(list);
			for(int i=0;i<list.size();i++) {
				System.out.println((i+1)+"."+list.get(i));
			}
			System.out.println("===============");
		}catch(Exception ex) {}
	}
}
