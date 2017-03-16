package com.jp.market.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.jp.market.service.ReportService;

public class ReportServiceImplTest {

	private ReportService reportService;

	@Before
	public void setUp() throws Exception {
		reportService = new ReportServiceImpl();
	}

	@Test
	public void testGetUSDSettledIncomingEverDay() {
		reportService.getUSDSettledIncomingEverDay();
	}

	@Test
	public void testGetUSDSettledOutcomingEverDay() {
		reportService.getUSDSettledOutcomingEverDay();
	}

	@Test
	public void testGetEntitiesByRank() {
		reportService.getEntitiesByRank();
	}

}
