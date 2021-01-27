package com.tvh.exchangerate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tvh.exchangerate.crawldata.Crawler;

@SpringBootTest
class ExchangeRateApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	public static void main(String args[]) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			String s = "2021-01-20 00:08:00+00";
//			Date d = format.parse(s.substring(0, s.indexOf("+")));
//			Calendar ca = Calendar.getInstance();
//			ca.setTime(d);
//			ca.setTimeZone(TimeZone.getTimeZone("Etc/GMT0"));
//			System.out.println(format.format(ca.getTime()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
