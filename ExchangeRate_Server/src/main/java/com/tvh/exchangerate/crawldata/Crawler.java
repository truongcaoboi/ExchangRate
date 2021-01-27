package com.tvh.exchangerate.crawldata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tvh.exchangerate.dao.DAOCurrency;
import com.tvh.exchangerate.vo.Currency;

@Component
public class Crawler {
	private final String apiKey = "ab1345a7c6864cb3ba241bd197354228";
	private final String USER_AGENT = "API Client/1.0";
	@Autowired
	private DAOCurrency daoCurrency;
	public void crawl() {
		System.out.println("start crawl");
		String url = "https://www.countries-ofthe-world.com/world-currencies.html";
		if(url.length()>0) return;
		List<Currency> currencys = new ArrayList<Currency>();
		try {
			Date now = new Date();
			Document doc = Jsoup.connect(url).get();
			Elements tables = doc.select(".codes");
			for (Element table : tables) {
				if (table.selectFirst("th").text().equals("Country or territory")) {
					Elements trDatas = table.select("tbody tr");
					for (Element trData : trDatas) {
						Elements datas = trData.select("td");
						if(datas.size() == 3) {
							String nation = datas.get(0).text();
							String sumName = datas.get(2).text();
							String curName = datas.get(1).text();
							long modifyDate = now.getTime();
							Currency cur = new Currency();
							cur.setCurName(curName);
							cur.setSumName(sumName);
							if(nation.substring(0, 3).equals(curName.substring(0, 3))) {
								cur.setNation(nation);
							}else {
								cur.setNation("");
							}
							cur.setExchangeRate(-1.0);
							cur.setModifyDate(modifyDate);
							currencys.add(cur);
						}
					}
				}
			}
			for (Currency cur : currencys) {
				Currency curDB = daoCurrency.getCurrency(cur.getSumName());
				if(curDB == null) {
					daoCurrency.addCurrency(cur);
				}else {
					if(curDB.getNation().equals("")) {
						if(!cur.getNation().equals("")) {
							curDB.setNation(cur.getNation());
							daoCurrency.updateCurrency(curDB);
						}
					}
				}
			}
			System.out.println("end crawl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crawlBonus() {
		System.out.println("start crawl numberCode");
		String url = "https://vi.wikipedia.org/wiki/ISO_4217";
		if(url.length()>0) return;
		List<Currency> currencys = new ArrayList<Currency>();
		try {
			Date now = new Date();
			Document doc = Jsoup.connect(url).get();
			Elements tables = doc.select(".wikitable");
			System.out.println(tables.size());
			for (Element table : tables) {
				System.out.println(table.select("th").size());
				if (table.select("th").size() == 5) {
					Elements trDatas = table.select("tbody tr");
					for (Element trData : trDatas) {
						Elements datas = trData.select("td");
						if(datas.size() == 5) {
							String nation = datas.get(4).text();
							String sumName = datas.get(0).text();
							String curName = datas.get(3).text();
							String numCode = datas.get(1).text();
							long modifyDate = now.getTime();
							Currency cur = new Currency();
							cur.setCurName(curName);
							cur.setSumName(sumName);
							cur.setNumberCode(numCode);
							cur.setExchangeRate(-1.0);
							cur.setModifyDate(modifyDate);
							currencys.add(cur);
						}
					}
				}
			}
			for (Currency cur : currencys) {
				System.out.println(new Gson().toJson(cur));
				Currency curDB = daoCurrency.getCurrency(cur.getSumName());
				if(curDB != null) {
					curDB.setNumberCode(cur.getNumberCode());
					daoCurrency.updateCurrency(curDB);
				}
			}
			System.out.println("end crawl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateExechangeRate() {
		if(daoCurrency.getCurrencys().size() ==0) {
			crawl();
		}
		System.out.println("go");
//		JsonObject data = sendGET();
		String sdata = "{\"date\":\"2021-01-21 00:08:00+00\",\"base\":\"USD\",\"rates\":{\"FJD\":\"2.03795\",\"MXN\":\"19.58701\",\"STD\":\"20466.377105\",\"LVL\":\"0.656261\",\"SCR\":\"21.203654\",\"CDF\":\"1973.964828\",\"BBD\":\"2.0\",\"GTQ\":\"7.787373\",\"CLP\":\"722.1\",\"HNL\":\"24.229381\",\"UGX\":\"3694.915306\",\"ZAR\":\"14.90432\",\"TND\":\"2.7075\",\"CUC\":\"1.0\",\"BSD\":\"1.0\",\"SLL\":\"10194.438439\",\"SDG\":\"55.3198\",\"IQD\":\"1460.986005\",\"CUP\":\"26.5\",\"GMD\":\"51.75\",\"TWD\":\"27.883701\",\"RSD\":\"97.4\",\"DOP\":\"58.089554\",\"KMF\":\"406.675213\",\"BCH\":\"0.002022387833314795\",\"MYR\":\"4.0425\",\"FKP\":\"0.731802\",\"XOF\":\"541.509805\",\"GEL\":\"3.305\",\"BTC\":\"0.00002828241461680439\",\"UYU\":\"42.253483\",\"MAD\":\"8.968547\",\"CVE\":\"91.405\",\"TOP\":\"2.292365\",\"AZN\":\"1.700805\",\"OMR\":\"0.384946\",\"PGK\":\"3.53\",\"KES\":\"110.198603\",\"SEK\":\"8.340175\",\"BTN\":\"72.990767\",\"UAH\":\"28.254502\",\"GNF\":\"10228.189639\",\"ERN\":\"14.999753\",\"MZN\":\"75.040004\",\"SVC\":\"8.749783\",\"ARS\":\"86.3593\",\"QAR\":\"3.641\",\"IRR\":\"42101.7\",\"MRO\":\"356.999828\",\"XPD\":\"0.00042054\",\"CNY\":\"6.4665\",\"THB\":\"29.942612\",\"UZS\":\"10500.296996\",\"XPF\":\"98.511501\",\"MRU\":\"36.3445\",\"BDT\":\"84.803613\",\"LYD\":\"4.463889\",\"BMD\":\"1.0\",\"KWD\":\"0.302777\",\"PHP\":\"48.009249\",\"XPT\":\"0.0008994\",\"RUB\":\"73.504\",\"PYG\":\"6904.478724\",\"ISK\":\"129.48\",\"JMD\":\"144.733049\",\"COP\":\"3491.499653\",\"MKD\":\"50.87986\",\"USD\":\"1.0\",\"DZD\":\"132.85272\",\"PAB\":\"1.0\",\"GGP\":\"0.731802\",\"SGD\":\"1.32488\",\"ETB\":\"39.393133\",\"JEP\":\"0.731802\",\"ETC\":\"0.11405759908753921\",\"KGS\":\"83.938641\",\"SOS\":\"579.901895\",\"VEF\":\"248487.642241\",\"VUV\":\"108.562315\",\"LAK\":\"9319.843124\",\"ETH\":\"0.0007327617791455998\",\"BND\":\"1.326173\",\"ZEC\":\"0.010100499974748751\",\"ZMK\":\"5253.075255\",\"XAF\":\"541.509805\",\"LRD\":\"169.500006\",\"XAG\":\"0.0387147\",\"CHF\":\"0.889466\",\"HRK\":\"6.2425\",\"ALL\":\"101.775\",\"DJF\":\"178.025653\",\"VES\":\"1560965.25\",\"ZMW\":\"21.344667\",\"TZS\":\"2318.972749\",\"VND\":\"23067.446959\",\"XAU\":\"0.00053483\",\"DASH\":\"0.008285656286120283\",\"AUD\":\"1.289317\",\"ILS\":\"3.27004\",\"GHS\":\"5.837965\",\"GYD\":\"209.208903\",\"KPW\":\"900.057\",\"BOB\":\"6.884902\",\"KHR\":\"4055.370575\",\"MDL\":\"17.365729\",\"IDR\":\"14021.8935\",\"KYD\":\"0.833285\",\"AMD\":\"521.418477\",\"BWP\":\"10.922864\",\"SHP\":\"0.731802\",\"TRY\":\"7.42\",\"LBP\":\"1514.519803\",\"TJS\":\"11.39478\",\"JOD\":\"0.709\",\"AED\":\"3.6732\",\"HKD\":\"7.75175\",\"RWF\":\"989.111888\",\"EUR\":\"0.825526\",\"LSL\":\"14.902997\",\"DKK\":\"6.14064\",\"CAD\":\"1.26227\",\"BGN\":\"1.61732\",\"MMK\":\"1332.981861\",\"MUR\":\"39.639999\",\"NOK\":\"8.480465\",\"SYP\":\"512.828\",\"IMP\":\"0.731802\",\"GIP\":\"0.731802\",\"RON\":\"4.0237\",\"LKR\":\"195.49682\",\"NGN\":\"387.573731\",\"CRC\":\"608.827189\",\"CZK\":\"21.544\",\"PKR\":\"160.556419\",\"XCD\":\"2.70255\",\"ANG\":\"1.794952\",\"HTG\":\"71.827807\",\"LTC\":\"0.006717946995398206\",\"USDC\":\"1.0\",\"BHD\":\"0.376985\",\"KZT\":\"418.978841\",\"SRD\":\"14.154\",\"SZL\":\"14.914339\",\"LTL\":\"3.224845\",\"SAR\":\"3.751854\",\"TTD\":\"6.783187\",\"YER\":\"250.350066\",\"MVR\":\"15.4\",\"AFN\":\"77.450196\",\"INR\":\"72.908157\",\"AWG\":\"1.8\",\"KRW\":\"1098.67905\",\"NPR\":\"116.785415\",\"JPY\":\"103.5735\",\"MNT\":\"2854.932843\",\"AOA\":\"656.23\",\"PLN\":\"3.744653\",\"GBP\":\"0.731802\",\"SBD\":\"7.969266\",\"BYN\":\"2.53998\",\"HUF\":\"295.023218\",\"XLM\":\"3.4318208726777297\",\"BYR\":\"25399.8\",\"BIF\":\"1946.245163\",\"MWK\":\"771.915872\",\"MGA\":\"3788.065102\",\"XDR\":\"0.693899\",\"EOS\":\"0.36127167630057805\",\"BZD\":\"2.015637\",\"BAM\":\"1.614747\",\"EGP\":\"15.7466\",\"MOP\":\"7.984115\",\"NAD\":\"14.89\",\"NIO\":\"34.959542\",\"PEN\":\"3.615104\",\"NZD\":\"1.391789\",\"WST\":\"2.508609\",\"TMT\":\"3.51\",\"BRL\":\"5.2918\"}}";
		JsonObject data = (JsonObject) new JsonParser().parse(sdata);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String strdate = data.get("date").getAsString();
			Date d = format.parse(strdate.substring(0, strdate.indexOf("+")));
			Calendar ca = Calendar.getInstance();
			ca.setTime(d);
			ca.setTimeZone(TimeZone.getTimeZone("Etc/GMT0"));
			JsonObject rates = data.get("rates").getAsJsonObject();
			for(String key : rates.keySet()) {
				Currency cur = daoCurrency.getCurrency(key);
				if(cur != null) {
					cur.setExchangeRate(rates.get(key).getAsDouble());
					cur.setModifyDate(ca.getTime().getTime());
					daoCurrency.updateCurrency(cur);
				}else {
					cur = new Currency();
					cur.setSumName(key);
					cur.setExchangeRate(rates.get(key).getAsDouble());
					cur.setModifyDate(ca.getTime().getTime());
					daoCurrency.addCurrency(cur);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		crawlBonus();
		System.out.println("end");
	}

	private JsonObject sendGET() {
		JsonObject re = null;
		try {
			String url = "https://api.currencyfreaks.com/latest?apikey=" + apiKey;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
				re = (JsonObject) new JsonParser().parse(response.toString());
			} else {
				System.out.println("GET request not worked");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
}
