package com.nice.dcm.simulation.distribution.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.distribution.action.CTDistributionRules;
import com.nice.dcm.simulation.distribution.action.CTDistributionRulesImpl;
import com.nice.dcm.simulation.distribution.action.CTRuleSetActions;
import com.nice.dcm.simulation.distribution.action.QueueToActions;
import com.nice.dcm.simulation.distribution.action.QueueToGroupSetAction;
import com.nice.dcm.simulation.distribution.action.QueueToTarget;

class RoutingRuleSetPerformanceTest {
	public static final String DEFAULT_PROVIDER_KEY = "RuleParserServiceProvider";
	
	private String getSkillPrefix(int i) {
		String prefix = "" + i;
		while (prefix.length() < 4) {
			prefix = "0" + prefix;
		}
		return prefix;
	}
	
	@Test
	void testParser() {
		String template = 
				"""
				queue to @S:{skillOid1} and (@S:{skillOid2} level < 5, @S:{skillOid3} level in 4..8) with priority 1
				wait 100 
				queue to @S:{skillOid4} with priority 2				
				""";
		
		Set<String> skills = new HashSet<>();
		Map<String, String> ruleScripts = new HashMap<>();
		for(int i = 0; i < 500; i++) {
			String ct = "ct" + i;
			
			String prefix = getSkillPrefix(i);
			
			String skill1 = prefix + "a1";
			skills.add(skill1);
			String skill2 = prefix + "a2";
			skills.add(skill2);
			String skill3 = prefix + "a3";
			skills.add(skill3);
			
			String skill4 = prefix + "a4";
			skills.add(skill4);
			
			String script = template.replace("{skillOid1}", skill1)
					.replace("{skillOid2}", skill2)
					.replace("{skillOid3}", skill3)
					.replace("{skillOid4}", skill4);
			ruleScripts.put(ct, script);
		}
		
		CTDistributionRules rules = new CTDistributionRulesImpl(skills, ruleScripts);
		long start = System.currentTimeMillis();
		
		RuleParserService service = getRuleParserService();
		CTRuleSetActions ruleSetActions = service.parserRules(rules);

		long end = System.currentTimeMillis();
		System.out.println("Parser Time: " + (end - start));

		assertNotNull(ruleSetActions);
		assertEquals(500, ruleSetActions.getContactTypes().size());
		
	}
	
	@Test
	void testVisitRoutingRuleSet() {
		RuleParserService service = getRuleParserService();
		
		Set<String> skills = Set.of("1111a", "2222a", "3333a", "4444a", "5555a");
		String script[] = {
				"""
				queue to @S: 1111a and @S: 3333a and 
					(@S:2222a level < 5, @S:4444a level in 4..8) with priority 1
				queue to @S: 5555a level = 2 with priority 2
				wait 100 queue to 
				@S: 2222a with priority 3
				wait 100 
				queue to @S: 4444a with priority 4
				wait 100 
				queue to @S: 5555a with priority 5
				""",
				"""
				queue to @S: 1111a and @S: 3333a and 
					(@S:2222a level < 5, @S:4444a level in 4..8) with priority 1
				queue to @S: 5555a level = 2 with priority 2
				"""				
		};
		
		CTDistributionRules rules = new CTDistributionRulesImpl(skills, Map.of("ct1", script[0], "ct2", script[1]));
		long start = System.currentTimeMillis();
		CTRuleSetActions ruleSetActions = service.parserRules(rules);
		long end = System.currentTimeMillis();
		assertNotNull(ruleSetActions);
		assertEquals(2, ruleSetActions.getContactTypes().size());
		System.out.println("Parser Time: " + (end - start));
		
		start = System.currentTimeMillis();
		QueueToGroupSetAction queueToGroupSetAction = ruleSetActions.getQueueToGroupSetAction("ct1");
		
		QueueToActions queueToAction = queueToGroupSetAction.getActions();
		
		QueueToActions queueToAction0 = queueToGroupSetAction.getActions(0);
		assertSame(queueToAction0, queueToAction);
		QueueToActions queueToAction1 = queueToGroupSetAction.getActions(1);
		assertSame(queueToAction0, queueToAction1);

		QueueToActions queueToAction101 = queueToGroupSetAction.getActions(101);
		QueueToActions queueToAction201 = queueToGroupSetAction.getActions(201);
		QueueToActions queueToAction301 = queueToGroupSetAction.getActions(301);
		QueueToActions queueToAction401 = queueToGroupSetAction.getActions(401);
		assertSame(queueToAction401, queueToAction301);
		
		for (int i = 0; i < 100000; i++) {	
			Map<String, Integer> skillToLevels = Map.of("1111a", 1);
			QueueToTarget target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(1, target.getPriority());
			assertEquals(0, target.getSkillSelectorId());
			
			skillToLevels = Map.of("3333a", 1);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(1, target.getPriority());
			assertEquals(1, target.getSkillSelectorId());
			
			skillToLevels = Map.of("2222a", 2, "4444a", 5);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(1, target.getPriority());
			assertEquals(2, target.getSkillSelectorId());
			
			skillToLevels = Map.of("5555a", 2);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(2, target.getPriority());
			assertEquals(3, target.getSkillSelectorId());
			
			skillToLevels = Map.of("2222a", 2);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(3, target.getPriority());
			assertEquals(4, target.getSkillSelectorId());
			
			skillToLevels = Map.of("4444a", 2);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(4, target.getPriority());
			assertEquals(5, target.getSkillSelectorId());
			
			skillToLevels = Map.of("5555a", 3);
			target = queueToAction401.evaluate(skillToLevels);
			assertNotNull(target);
			assertEquals(5, target.getPriority());
			assertEquals(6, target.getSkillSelectorId());
			
			skillToLevels = Map.of("6666a", 3);
			target = queueToAction401.evaluate(skillToLevels);
			assertNull(target);
		}
		end = System.currentTimeMillis();
		System.out.println("finally Evaluate Time: " + (end - start));
	}
	
	public RuleParserService getRuleParserService() {
		return new RuleParserServiceImpl();
	}
}
