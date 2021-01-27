package com.tvh.exchangerate.crawldata;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tvh.exchangerate.dao.DAOCurrency;

@Component
public class FactoryCrawl {
	@Autowired
	private Crawler c;
	private Timer t = null;

	public FactoryCrawl() {
		if (t == null) {
			t = new Timer();
		}
	}

	public void start() {
		if (t != null) {
			t.schedule(new TimerTask() {

				@Override
				public void run() {
					executeCrawlData();
				}
			}, 10 * 1000, 6 * 60 * 60 * 1000);
		}
	}

	public void close() {
		if (t != null) {
			t.cancel();
			t = null;
		}
	}

	private void executeCrawlData() {
		c.updateExechangeRate();
	}
}
