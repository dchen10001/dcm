package com.nice.dcm.distribution.rule.client;

import com.nice.dcm.simulation.distribution.service.RuleParserServiceProvider;

public class RuleServiceClient {

	public static void main(String[] args) {
		RuleParserServiceProvider provider = RuleParserServiceFactory.getRuleParserServiceProvider();
        System.out.println(provider.getClass().getName());
	}

}
