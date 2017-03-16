package com.jp.market.service;

import java.util.List;

import com.jp.market.model.ReportModel;

public interface ReportService {

	public List<ReportModel> getUSDSettledIncomingEverDay();

	public List<ReportModel> getUSDSettledOutcomingEverDay();

	public List<ReportModel> getEntitiesByRank();

}
