package org.web.bordcommend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.web.borddto.CrawlerDTO;

public class CrawlerCommend2 implements BordQueryCommend {
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("crawler");

		String url = "https://comic.naver.com/webtoon/weekday.nhn";
		Document doc = Jsoup.connect(url).get();

		Elements els = doc.select(".daily_all li"); // 모든 웹툰 선택

		ArrayList<CrawlerDTO> dayList = new ArrayList<>(); // 요일별 담기
		ArrayList<ArrayList<CrawlerDTO>> allList = new ArrayList<>(); // 전체 담기

		String check = "mon"; // 요일 체크
		String checked = ""; // 현재 웹툰의 요일
		for (Element el : els) {

			CrawlerDTO dto = new CrawlerDTO();

			dto.setSrc(el.select("img").first().attr("src"));
			dto.setHref("https://comic.naver.com" + el.select("a").first().attr("href"));
			dto.setTitle(el.select("img").first().attr("title"));

			checked = dto.getHref().substring(dto.getHref().length() - 3); // mon

			if (!check.equals(checked)) {
				allList.add((ArrayList<CrawlerDTO>) dayList.clone()); //deep copy
				dayList.clear();
				check = checked;
			}
			dayList.add(dto);
		}

		allList.add((ArrayList<CrawlerDTO>) dayList.clone());

		request.setAttribute("url", "crawler.jsp");
		request.setAttribute("allList", allList);

	}
}
