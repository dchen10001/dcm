package com.nice.dcm.distribution.rule.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.OIDHEXContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.OIDNUMBERContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleGroupContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleSetContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingWaitingRuleGroupContext;
import com.nice.dcm.distribution.rule.parser.node.ActionNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.EntityIdentifierNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.PriorityNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.QueueStatusNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.RoutingRuleGroupNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.RoutingRuleNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.RoutingRuleSetNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillOrSelectorNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.WaitNodeImpl;
import com.nice.dcm.simulation.distribution.rule.QueueStatus;
import com.nice.dcm.simulation.distribution.rule.RoutingGroupRule;
import com.nice.dcm.simulation.distribution.rule.RoutingGroupRuleImpl;
import com.nice.dcm.simulation.distribution.rule.RoutingRule;
import com.nice.dcm.simulation.distribution.rule.RoutingRuleImpl;
import com.nice.dcm.simulation.distribution.rule.RoutingRuleSet;
import com.nice.dcm.simulation.distribution.rule.RoutingRuleSetImpl;
import com.nice.dcm.simulation.distribution.rule.RuleAction;
import com.nice.dcm.simulation.distribution.rule.SkillSetSelector;

public class DCMRuleVisitorImpl extends AbstractRuleVistorImpl {

	private final Set<String> skills;
	
	private final Set<String> noExistSkills = new HashSet<>();
	
	public DCMRuleVisitorImpl() {
		this(null);
	}
	
	public DCMRuleVisitorImpl(Set<String> skills) {
		this.skills = skills == null ? Set.of() : skills;
	}
	
	/**
	 * Visit a routing rule set node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleSetNodeImpl visitRoutingRuleSet(RoutingRuleSetContext ctx) {
		RoutingGroupRule groupRule = ((RoutingRuleGroupNodeImpl)visit(ctx.routingRuleGroup())).getRoutingGroupRule();

		List<RoutingWaitingRuleGroupContext> waitGroupRules = ctx.routingWaitingRuleGroup();
		RoutingRuleSet routingRuleSet = null;
		if (waitGroupRules.isEmpty()) {
			routingRuleSet =  new RoutingRuleSetImpl(groupRule);
		} else {
			List<RoutingGroupRule> groupRules = waitGroupRules.stream()
					.map(c -> ((RoutingRuleGroupNodeImpl)visit(c)).getRoutingGroupRule()).toList();
			routingRuleSet = new RoutingRuleSetImpl(groupRule, groupRules);
		}
		return new RoutingRuleSetNodeImpl(routingRuleSet);
	}

	/**
	 * Visit a routing waiting rule group node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleGroupNodeImpl visitRoutingWaitingRuleGroup(RoutingWaitingRuleGroupContext ctx) {
		long waitAfterSeconds = ((WaitNodeImpl)visit(ctx.waitRule())).getWaitFor();
		RoutingGroupRule rule = toRoutingGroupRule(ctx.routingRuleGroup(), waitAfterSeconds);
		return new RoutingRuleGroupNodeImpl(rule);
	}

	/**
	 * Visit a routing rule group node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleGroupNodeImpl visitRoutingRuleGroup(RoutingRuleGroupContext ctx) {
		RoutingGroupRule rule = toRoutingGroupRule(ctx, 0l);
		return new RoutingRuleGroupNodeImpl(rule);
	}
	
	protected RoutingGroupRule toRoutingGroupRule(RoutingRuleGroupContext ctx, long waitAfterSeconds) {
		List<RoutingRule> rules = ctx.routingRule().stream().map(this::toRoutingRule).toList();
		return new RoutingGroupRuleImpl(waitAfterSeconds, rules);
	}

	/**
	 * Visit a routing rule node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleNodeImpl visitRoutingRule(RoutingRuleContext ctx) {
        RoutingRule rule = toRoutingRule(ctx);
		return new RoutingRuleNodeImpl(rule);
	}
	
	protected RoutingRule toRoutingRule(RoutingRuleContext ctx) {
		RuleAction action = ((ActionNodeImpl)visit(ctx.ruleAction())).getAction();
		List<SkillSetSelector> selectors = ((SkillOrSelectorNodeImpl)visit(ctx.orSkills())).getSelectors();
		int priority = ((PriorityNodeImpl)visit(ctx.priority())).getPriority();
		
		QueueStatus queueStatus = null;
		if (selectors.size() > 1 && ctx.queue_status() != null) {
			QueueStatusNodeImpl queueNode = (QueueStatusNodeImpl)visit(ctx.queue_status());
			queueStatus = queueNode.getQueueStatus();
		}
		return new RoutingRuleImpl(action, queueStatus, selectors, priority);
	}
	
    /**
     * Visit an entity identifier node
     * 
     * @param ctx
     * @return
     */
    private void validSkill(String oid) {
        if (!skills.contains(oid)) {
			logger.warn("Skill {} does not exist", oid);
        	noExistSkills.add(oid);
        }
    }
    
	@Override
	public EntityIdentifierNodeImpl visitOIDHEX(OIDHEXContext ctx) {
		String oid = ctx.getText();
		validSkill(oid);
		return new EntityIdentifierNodeImpl(oid);
	}

	@Override
	public EntityIdentifierNodeImpl visitOIDNUMBER(OIDNUMBERContext ctx) {
		String oid = ctx.getText();
		validSkill(oid);
		return new EntityIdentifierNodeImpl(oid);
	}
	
	public Set<String> getNoExistSkills() {
		return noExistSkills;
	}
}
