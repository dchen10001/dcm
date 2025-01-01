package com.nice.dcm.distribution.rule.parser;

import java.util.List;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.LevelConditionContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ORSKILLContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ORSKILLSETContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLANDSETContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLCONDITIONContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLSETORContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SkillContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SkillOrSetContext;
import com.nice.dcm.distribution.rule.parser.node.EntityIdentifierNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillLevelConditionNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillOrSelectorNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillSelectorNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillSetSelectorNodeImpl;
import com.nice.dcm.simulation.distribution.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.rule.SkillSetSelector;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DistributionRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */

public abstract class AbstractRuleVistorImpl extends BaseRuleVistorImpl {
	
	protected AbstractRuleVistorImpl() {
		super();
	}
	
    /**
     * Get a Or skill set selector. The rule language is AND but the actual
     * implementation is OR.
     * 
     * @param token
     * @return
     */	
	@Override
	public SkillOrSelectorNodeImpl visitSKILLSETOR(SKILLSETORContext ctx) {
		List<SkillOrSetContext> skills = ctx.skillOrSet();
		List<SkillSetSelector> selectors = skills.stream().map(this::getSkillSetSelector).toList();
		return new SkillOrSelectorNodeImpl(selectors);
	}
	
	protected SkillSetSelector getSkillSetSelector(SkillOrSetContext ctx) {
		SkillSetSelectorNodeImpl node = (SkillSetSelectorNodeImpl)visit(ctx);
		return node.getSkillSetSelector();
	}
	
    /**
     * return a skill set with multiple skills with or without condition.
     */		
	@Override
	public SkillSetSelectorNodeImpl visitORSKILLSET(ORSKILLSETContext ctx) {
		return (SkillSetSelectorNodeImpl)visit(ctx.skillSet());
	}

	/**
	 * return a single skill with multiple skills with or without condition.
	 */	
	@Override
	public SkillSetSelectorNodeImpl visitORSKILL(ORSKILLContext ctx) {
		SkillSelector selector = getSkillLevelCondition(ctx.skill());
		return new SkillSetSelectorNodeImpl(selector);
	}

    /**
     * return a skill set with multiple skills with or without condition.
     * the relationship between multiple skills is AND.
     */	

	@Override
	public SkillSetSelectorNodeImpl visitSKILLANDSET(SKILLANDSETContext ctx) {
		List<SkillSelector> skillSelectors = ctx.skill().stream()
			.map(skill -> ((SkillSelectorNodeImpl)visit(skill)).getSkillSelector()).toList();
		return new SkillSetSelectorNodeImpl(skillSelectors);
	}

	/**
	 * return a single skill with or without condition. if condition is null, a
	 * skill in any level will match it.
	 */	
	@Override
	public SkillSelectorNodeImpl visitSKILLCONDITION(SKILLCONDITIONContext ctx) {
		EntityIdentifierNodeImpl oidNode = (EntityIdentifierNodeImpl)visit(ctx.entity_identifier());
		LevelConditionContext levelCtx = ctx.levelCondition();
		if (levelCtx == null) {
			return new SkillSelectorNodeImpl(oidNode.getEntityIdentifier());
		}
		SkillLevelConditionNodeImpl conditionNode = (SkillLevelConditionNodeImpl)visit(levelCtx);
		return new SkillSelectorNodeImpl(oidNode.getEntityIdentifier(), conditionNode.getCondition());
	}
	
	protected SkillSelector getSkillLevelCondition(SkillContext ctx) {
		SkillSelectorNodeImpl node = (SkillSelectorNodeImpl)visit(ctx);
		return node.getSkillSelector();
	}
}
