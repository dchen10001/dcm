package com.nice.dcm.simulation.distribution.service;

import java.util.List;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser;
import com.nice.dcm.distribution.rule.parser.utility.RuleParserHelper;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.ActionNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleGroupNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.WaitNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.BinaryOperatorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.EntityIdentifierNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.PriorityNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillLevelConditionNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillOrSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillSetSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SqlOperatorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visitor.DCMRuleVisitorImpl;
import com.nice.dcm.simulation.distribution.node.rule.RoutingGroupRule;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRule;
import com.nice.dcm.simulation.distribution.node.rule.RuleAction;
import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;
import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinaryOperator;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlOperator;

public class TestRuleParserHelper extends RuleParserHelper {
	/**********************************************************************
	 *     
	 *  functions of basic elements of the rule  
	 *     
	 **********************************************************************/	
    public long visitWaitFor(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	WaitNodeWrapImpl node = (WaitNodeWrapImpl)parser.waitRule().accept(dcmRuleVisitor);
    	return node.getWaitFor();
    }
    
    public int visitPriority(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	PriorityNodeWrapImpl node = (PriorityNodeWrapImpl)parser.priority().accept(dcmRuleVisitor);
    	return node.getPriority();
    }
    
	public String visitOid(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
		DistributionRulesParser parser = parserScript(script);
		EntityIdentifierNodeWrapImpl node = (EntityIdentifierNodeWrapImpl)parser.entity_identifier().accept(dcmRuleVisitor);
		return node.getEntityIdentifier();
	}
	
    public SqlOperator visitSqlOperator(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
        DistributionRulesParser parser = parserScript(script);
        SqlOperatorNodeWrapImpl node = (SqlOperatorNodeWrapImpl)parser.sqlOperator().accept(dcmRuleVisitor);  
        return node.getOperator();
    }
    
    public BinaryOperator visitBinaryOperator(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
        DistributionRulesParser parser = parserScript(script);
        BinaryOperatorNodeWrapImpl node = (BinaryOperatorNodeWrapImpl)parser.binaryOperator().accept(dcmRuleVisitor);  
        return node.getOperator();
    }
    
    public SkillLevelCondition visitLevelCondition(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
        DistributionRulesParser parser = parserScript(script);
        SkillLevelConditionNodeWrapImpl node = (SkillLevelConditionNodeWrapImpl)parser.levelCondition().accept(dcmRuleVisitor);
        return node.getCondition();
    }
	
    public RuleAction visitRuleAction(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	ActionNodeWrapImpl node = (ActionNodeWrapImpl)parser.ruleAction().accept(dcmRuleVisitor);
    	return node.getAction();
    }
    
	/**********************************************************************
	 *     
	 *  functions of skill selectors
	 *     
	 **********************************************************************/
    public SkillSelector visitSkill(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	SkillSelectorNodeWrapImpl node = (SkillSelectorNodeWrapImpl)parser.skill().accept(dcmRuleVisitor);
    	return node.getSkillSelector();
    }

    public SkillSetSelector visitSkillSet(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	SkillSetSelectorNodeWrapImpl node = (SkillSetSelectorNodeWrapImpl)parser.skillSet().accept(dcmRuleVisitor);
    	return node.getSkillSetSelector();
    }
    
    public SkillSetSelector visitSkillOrSet(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	SkillSetSelectorNodeWrapImpl node = (SkillSetSelectorNodeWrapImpl)parser.skillOrSet().accept(dcmRuleVisitor);
    	return node.getSkillSetSelector();
    }
    
    public List<SkillSetSelector> visitOrSkills(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	SkillOrSelectorNodeWrapImpl node = (SkillOrSelectorNodeWrapImpl)parser.orSkills().accept(dcmRuleVisitor);
    	return node.getSelectors();
    }
    
	/**********************************************************************
	 *     
	 *  functions of rule and rule group
	 *     
	 **********************************************************************/
    public RoutingRule visitRoutingRule(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	RoutingRuleNodeWrapImpl node = (RoutingRuleNodeWrapImpl)parser.routingRule().accept(dcmRuleVisitor);
    	return node.getRoutingRule();
    }
    
    public RoutingGroupRule visitRoutingRuleGroup(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	RoutingRuleGroupNodeWrapImpl node = (RoutingRuleGroupNodeWrapImpl)parser.routingRuleGroup().accept(dcmRuleVisitor);
    	return node.getRoutingGroupRule();
    }
    
    public RoutingGroupRule visitRoutingWaitRuleGroup(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	RoutingRuleGroupNodeWrapImpl node = (RoutingRuleGroupNodeWrapImpl)parser.routingWaitingRuleGroup().accept(dcmRuleVisitor);
    	return node.getRoutingGroupRule();
    }
}
