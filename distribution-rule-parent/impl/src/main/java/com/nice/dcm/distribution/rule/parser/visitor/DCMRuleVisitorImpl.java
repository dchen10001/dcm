package com.nice.dcm.distribution.rule.parser.visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ExecutionContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.OIDHEXContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.OIDNUMBERContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleGroupContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingRuleSetContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.RoutingWaitingRuleGroupContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.StartContext;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.ExecutionNodeWrapperImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.ActionNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.QueueStatusNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleGroupNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleSetNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.WaitNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.EntityIdentifierNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.PriorityNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillOrSelectorNodeWrapImpl;
import com.nice.dcm.simulation.distribution.node.Execution;
import com.nice.dcm.simulation.distribution.node.ExecutionImpl;
import com.nice.dcm.simulation.distribution.node.rule.QueueStatus;
import com.nice.dcm.simulation.distribution.node.rule.RoutingGroupRule;
import com.nice.dcm.simulation.distribution.node.rule.RoutingGroupRuleImpl;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRule;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleImpl;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleSet;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleSetImpl;
import com.nice.dcm.simulation.distribution.node.rule.RuleAction;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

public class DCMRuleVisitorImpl extends AbstractRuleVistorImpl {

	private final Set<String> skills;
	
	private final Set<String> noExistSkills = new HashSet<>();
	
	public DCMRuleVisitorImpl() {
		this(null);
	}
	
	public DCMRuleVisitorImpl(Set<String> skills) {
		this.skills = skills == null ? Set.of() : skills;
	}
	
	@Override
	public ExecutionNodeWrapperImpl visitStart(StartContext ctx) {
		logger.trace("Visiting start context");
		return visitExecution(ctx.execution());
	}

	@Override
	public ExecutionNodeWrapperImpl visitExecution(ExecutionContext ctx) {
		logger.trace("Visiting execution context {}", ctx.getText());
		RoutingRuleSet routingRuleSet = ((RoutingRuleSetNodeWrapImpl)visit(ctx.routingRuleSet())).getNode();
		Execution execution = new ExecutionImpl(routingRuleSet);
		return new ExecutionNodeWrapperImpl(execution);
	}
	/**
	 * Visit a routing rule set node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleSetNodeWrapImpl visitRoutingRuleSet(RoutingRuleSetContext ctx) {
		logger.trace("Visiting routing rule set context {}", ctx.getText());
		RoutingGroupRule groupRule = ((RoutingRuleGroupNodeWrapImpl)visit(ctx.routingRuleGroup())).getRoutingGroupRule();

		List<RoutingWaitingRuleGroupContext> waitGroupRules = ctx.routingWaitingRuleGroup();
		RoutingRuleSet routingRuleSet = null;
		if (waitGroupRules.isEmpty()) {
			routingRuleSet =  new RoutingRuleSetImpl(groupRule);
		} else {
			List<RoutingGroupRule> groupRules = waitGroupRules.stream()
					.map(c -> ((RoutingRuleGroupNodeWrapImpl)visit(c)).getRoutingGroupRule()).toList();
			routingRuleSet = new RoutingRuleSetImpl(groupRule, groupRules);
		}
		return new RoutingRuleSetNodeWrapImpl(routingRuleSet);
	}

	/**
	 * Visit a routing waiting rule group node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleGroupNodeWrapImpl visitRoutingWaitingRuleGroup(RoutingWaitingRuleGroupContext ctx) {
		logger.trace("Visiting routing waiting rule group context {}", ctx.getText());
		
		long waitAfterSeconds = ((WaitNodeWrapImpl)visit(ctx.waitRule())).getWaitFor();
		RoutingGroupRule rule = toRoutingGroupRule(ctx.routingRuleGroup(), waitAfterSeconds);
		return new RoutingRuleGroupNodeWrapImpl(rule);
	}

	/**
	 * Visit a routing rule group node
	 * 
	 * @param ctx
	 * @return
	 */
	@Override
	public RoutingRuleGroupNodeWrapImpl visitRoutingRuleGroup(RoutingRuleGroupContext ctx) {
		logger.trace("Visiting routing rule group context {}", ctx.getText());
		RoutingGroupRule rule = toRoutingGroupRule(ctx, 0l);
		return new RoutingRuleGroupNodeWrapImpl(rule);
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
	public RoutingRuleNodeWrapImpl visitRoutingRule(RoutingRuleContext ctx) {
		logger.trace("Visiting routing rule context {}", ctx.getText());
        RoutingRule rule = toRoutingRule(ctx);
		return new RoutingRuleNodeWrapImpl(rule);
	}
	
	protected RoutingRule toRoutingRule(RoutingRuleContext ctx) {
		RuleAction action = ((ActionNodeWrapImpl)visit(ctx.ruleAction())).getAction();
		List<SkillSetSelector> selectors = ((SkillOrSelectorNodeWrapImpl)visit(ctx.orSkills())).getSelectors();
		int priority = ((PriorityNodeWrapImpl)visit(ctx.priority())).getPriority();
		
		QueueStatus queueStatus = null;
		if (selectors.size() > 1 && ctx.queue_status() != null) {
			QueueStatusNodeWrapImpl queueNode = (QueueStatusNodeWrapImpl)visit(ctx.queue_status());
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
	public EntityIdentifierNodeWrapImpl visitOIDHEX(OIDHEXContext ctx) {
		logger.trace("Visiting oid hex context {}", ctx.getText());
		String oid = ctx.getText();
		validSkill(oid);
		return new EntityIdentifierNodeWrapImpl(oid);
	}

	@Override
	public EntityIdentifierNodeWrapImpl visitOIDNUMBER(OIDNUMBERContext ctx) {
		logger.trace("Visiting oid number context {}", ctx.getText());
		String oid = ctx.getText();
		validSkill(oid);
		return new EntityIdentifierNodeWrapImpl(oid);
	}
	
	public Set<String> getNoExistSkills() {
		return noExistSkills;
	}
}
