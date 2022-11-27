package com.development.validator.password.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.development.validator.password.util.GenericPropertyReader;

/**
 * 
 * @author skjain27
 *
 */

public class RulesExecutionService {

	private ExecutorService service;

	public void executeRules(List<Runnable> rules) {
		service = Executors.newFixedThreadPool(GenericPropertyReader.getInstance().getProperty("thread.count"));
		rules.forEach(rule -> service.submit(rule));
		try {
			awaitTermination(service);
		} catch (InterruptedException e) {
			service.shutdownNow();
		}
	}

	private void awaitTermination(ExecutorService service2) throws InterruptedException {
		service2.shutdown();
		if (!service2.awaitTermination(GenericPropertyReader.getInstance().getProperty("thread.termination.secs"),
				TimeUnit.SECONDS))
			service2.shutdownNow();
	}
}
