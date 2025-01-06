package com.nice.dcm.distribution.rule.parser.visitor;

import static com.nice.dcm.distribution.rule.parser.visitor.DCMDistributionRulesVisitor.toBinaryOperator;
import static com.nice.dcm.distribution.rule.parser.visitor.DCMDistributionRulesVisitor.toLong;
import static com.nice.dcm.distribution.rule.parser.visitor.DCMDistributionRulesVisitor.toNumber;
import static com.nice.dcm.distribution.rule.parser.visitor.DCMDistributionRulesVisitor.toSqlOperator;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ACTQUEUETOContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.BINARYOPContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.BinaryOperatorContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.LevelConditionContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ORSKILLContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ORSKILLSETContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.PriorityContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.QSLEASTBUSYOFContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLANDSETContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLCONDITIONContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SKILLSETORContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SQLOPContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SkillContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SkillOrSetContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SqlOperatorContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.WaitRuleContext;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.ActionNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.QueueStatusNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.WaitNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.BinaryOperatorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.EntityIdentifierNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.PriorityNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillLevelConditionNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillOrSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SkillSetSelectorNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill.SqlOperatorNodeWrapImpl;
import com.nice.dcm.simulation.distribution.node.rule.QueueStatus;
import com.nice.dcm.simulation.distribution.node.rule.RuleAction;
import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;
import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinaryOperator;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinarySkillLevelConditionImpl;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlOperator;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlSkillLevelConditionImpl;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DistributionRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */

public abstract class AbstractRuleVistorImpl extends CommonNodeVisitorImpl {
	
	protected AbstractRuleVistorImpl() {
		super();
	}
	
	/**************************************************************************
	 * The following methods are used to convert the context to the corresponding
	 * operator or condition. 
	 * all methods are independent and can be moved to other classes.
	 *************************************************************************/
    /**
     * Visit a queue status node
     * 
     * @param ctx
     * @return
     */
	@Override
	public QueueStatusNodeWrapImpl visitQSLEASTBUSYOF(QSLEASTBUSYOFContext ctx) {
		logger.trace("Visiting least busy queue status {}", ctx.getText());
		return new QueueStatusNodeWrapImpl(QueueStatus.LEAST_BUSY);
	}
        
    /**
     * Visit a rule action node
     * 
     * @param ctx
     * @return
     */
	@Override
	public ActionNodeWrapImpl visitACTQUEUETO(ACTQUEUETOContext ctx) {
		logger.trace("Visiting queue to action {}", ctx.getText());
		return new ActionNodeWrapImpl(RuleAction.QUEUE_TO);
	}

    /**
     * Visit an order node
     * 
     * @param ctx
     * @return
     */
    @Override
	public PriorityNodeWrapImpl visitPriority(PriorityContext ctx) {
    	logger.trace("Visiting priority {}", ctx.getText());
		return new PriorityNodeWrapImpl(toNumber(ctx.NUMBER()));
	}
    
    /**
     * Visit a wait node
     * 
     * @param ctx
     * @return
     */
    @Override
	public WaitNodeWrapImpl visitWaitRule(WaitRuleContext ctx) {
    	logger.trace("Visiting wait {}", ctx.getText());
    	return new WaitNodeWrapImpl(toLong(ctx.NUMBER()));
	}
    
	/**************************************************************************
	 * The following methods are used to convert the context to the corresponding
	 * operator or condition.
	 *************************************************************************/
	/**
	 * Convert the binary operator context to binary operator node.
	 * 
	 * @param ctx
	 * @return
	 */        
    @Override
	public BinaryOperatorNodeWrapImpl visitBinaryOperator(BinaryOperatorContext ctx) {
    	logger.trace("Visiting binary operator {}", ctx.getText());
    	BinaryOperator operator = toBinaryOperator(ctx);
    	return new BinaryOperatorNodeWrapImpl(operator);
    }
    
	/**
	 * Convert the sql operator context to sql operator node.
	 * 
	 * @param ctx
	 * @return
	 */    
    @Override
	public SqlOperatorNodeWrapImpl visitSqlOperator(SqlOperatorContext ctx) {
    	logger.trace("Visiting sql operator {}", ctx.getText());
		SqlOperator operator = toSqlOperator(ctx);
		return new SqlOperatorNodeWrapImpl(operator);
	}
    
	@Override
	public SkillLevelConditionNodeWrapImpl visitBINARYOP(BINARYOPContext ctx) {
		logger.trace("Visiting binary operator {}", ctx.getText());
        BinaryOperatorNodeWrapImpl binaryOperatorNode = visitBinaryOperator(ctx.binaryOperator());
        int level = toNumber(ctx.NUMBER());
        SkillLevelCondition condition = new BinarySkillLevelConditionImpl(binaryOperatorNode.getOperator(), level);
        return new SkillLevelConditionNodeWrapImpl(condition);
	}

	@Override
	public SkillLevelConditionNodeWrapImpl visitSQLOP(SQLOPContext ctx) {
		logger.trace("Visiting sql operator {}", ctx.getText());
		List<TerminalNode> numbers = ctx.NUMBER();
		SqlOperatorNodeWrapImpl binaryOperatorNode = visitSqlOperator(ctx.sqlOperator());
        int lowerLevel = toNumber(numbers.get(0));
        int upperLevel = toNumber(numbers.get(1));
        SkillLevelCondition condition = new SqlSkillLevelConditionImpl(binaryOperatorNode.getOperator(), lowerLevel, upperLevel);
        return new SkillLevelConditionNodeWrapImpl(condition);
	}	
	
    /**
     * Get a Or skill set selector. The rule language is AND but the actual
     * implementation is OR.
     * 
     * @param token
     * @return
     */	
	@Override
	public SkillOrSelectorNodeWrapImpl visitSKILLSETOR(SKILLSETORContext ctx) {
		logger.trace("Visiting skill set or {}", ctx.getText());
		List<SkillOrSetContext> skills = ctx.skillOrSet();
		List<SkillSetSelector> selectors = skills.stream().map(this::getSkillSetSelector).toList();
		return new SkillOrSelectorNodeWrapImpl(selectors);
	}
	
	protected SkillSetSelector getSkillSetSelector(SkillOrSetContext ctx) {
		SkillSetSelectorNodeWrapImpl node = (SkillSetSelectorNodeWrapImpl)visit(ctx);
		return node.getSkillSetSelector();
	}
	
    /**
     * return a skill set with multiple skills with or without condition.
     */		
	@Override
	public SkillSetSelectorNodeWrapImpl visitORSKILLSET(ORSKILLSETContext ctx) {
		logger.trace("Visiting skill set or {}", ctx.getText());
		return (SkillSetSelectorNodeWrapImpl)visit(ctx.skillSet());
	}

	/**
	 * return a single skill with multiple skills with or without condition.
	 */	
	@Override
	public SkillSetSelectorNodeWrapImpl visitORSKILL(ORSKILLContext ctx) {
		logger.trace("Visiting skill or {}", ctx.getText());
		SkillSelector selector = getSkillLevelCondition(ctx.skill());
		return new SkillSetSelectorNodeWrapImpl(selector);
	}

    /**
     * return a skill set with multiple skills with or without condition.
     * the relationship between multiple skills is AND.
     */	

	@Override
	public SkillSetSelectorNodeWrapImpl visitSKILLANDSET(SKILLANDSETContext ctx) {
		logger.trace("Visiting skill and set {}", ctx.getText());
		List<SkillSelector> skillSelectors = ctx.skill().stream()
			.map(skill -> ((SkillSelectorNodeWrapImpl)visit(skill)).getSkillSelector()).toList();
		return new SkillSetSelectorNodeWrapImpl(skillSelectors);
	}

	/**
	 * return a single skill with or without condition. if condition is null, a
	 * skill in any level will match it.
	 */	
	@Override
	public SkillSelectorNodeWrapImpl visitSKILLCONDITION(SKILLCONDITIONContext ctx) {
		logger.trace("Visiting skill condition {}", ctx.getText());
		EntityIdentifierNodeWrapImpl oidNode = (EntityIdentifierNodeWrapImpl)visit(ctx.entity_identifier());
		LevelConditionContext levelCtx = ctx.levelCondition();
		if (levelCtx == null) {
			return new SkillSelectorNodeWrapImpl(oidNode.getEntityIdentifier());
		}
		SkillLevelConditionNodeWrapImpl conditionNode = (SkillLevelConditionNodeWrapImpl)visit(levelCtx);
		return new SkillSelectorNodeWrapImpl(oidNode.getEntityIdentifier(), conditionNode.getCondition());
	}
	
	protected SkillSelector getSkillLevelCondition(SkillContext ctx) {
		SkillSelectorNodeWrapImpl node = (SkillSelectorNodeWrapImpl)visit(ctx);
		return node.getSkillSelector();
	}
}
