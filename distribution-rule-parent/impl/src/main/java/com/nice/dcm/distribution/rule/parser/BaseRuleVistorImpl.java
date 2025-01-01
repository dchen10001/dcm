package com.nice.dcm.distribution.rule.parser;

import static com.nice.dcm.distribution.rule.parser.RuleVistor.toBinaryOperator;
import static com.nice.dcm.distribution.rule.parser.RuleVistor.toLong;
import static com.nice.dcm.distribution.rule.parser.RuleVistor.toNumber;
import static com.nice.dcm.distribution.rule.parser.RuleVistor.toSqlOperator;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.ACTQUEUETOContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.BINARYOPContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.BinaryOperatorContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.PriorityContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.QSLEASTBUSYOFContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SQLOPContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.SqlOperatorContext;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser.WaitRuleContext;
import com.nice.dcm.distribution.rule.parser.node.ActionNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.BinaryOperatorNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.Node;
import com.nice.dcm.distribution.rule.parser.node.PriorityNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.QueueStatusNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SkillLevelConditionNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.SqlOperatorNodeImpl;
import com.nice.dcm.distribution.rule.parser.node.WaitNodeImpl;
import com.nice.dcm.simulation.distribution.rule.QueueStatus;
import com.nice.dcm.simulation.distribution.rule.RuleAction;
import com.nice.dcm.simulation.distribution.rule.SkillLevelCondition;
import com.nice.dcm.simulation.distribution.rule.operator.BinaryOperator;
import com.nice.dcm.simulation.distribution.rule.operator.BinarySkillLevelConditionImpl;
import com.nice.dcm.simulation.distribution.rule.operator.SqlOperator;
import com.nice.dcm.simulation.distribution.rule.operator.SqlSkillLevelConditionImpl;

/**
 * BaseRuleVistorImpl class is the base class for all the RuleVistor
 * It contains the common functionality that can be used by all the RuleVistor
 * 
 * @see RuleVistor
 */
public abstract class BaseRuleVistorImpl extends CommonNodeVisitorImpl {

	protected BaseRuleVistorImpl() {
		
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
	public QueueStatusNodeImpl visitQSLEASTBUSYOF(QSLEASTBUSYOFContext ctx) {
		return new QueueStatusNodeImpl(QueueStatus.LEAST_BUSY);
	}
        
    /**
     * Visit a rule action node
     * 
     * @param ctx
     * @return
     */
	@Override
	public Node visitACTQUEUETO(ACTQUEUETOContext ctx) {
		return new ActionNodeImpl(RuleAction.QUEUE_TO);
	}

    /**
     * Visit an order node
     * 
     * @param ctx
     * @return
     */
    @Override
	public PriorityNodeImpl visitPriority(PriorityContext ctx) {
		return new PriorityNodeImpl(toNumber(ctx.NUMBER()));
	}
    
    /**
     * Visit a wait node
     * 
     * @param ctx
     * @return
     */
    @Override
	public WaitNodeImpl visitWaitRule(WaitRuleContext ctx) {
    	return new WaitNodeImpl(toLong(ctx.NUMBER()));
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
	public BinaryOperatorNodeImpl visitBinaryOperator(BinaryOperatorContext ctx) {
    	BinaryOperator operator = toBinaryOperator(ctx);
    	return new BinaryOperatorNodeImpl(operator);
    }
    
	/**
	 * Convert the sql operator context to sql operator node.
	 * 
	 * @param ctx
	 * @return
	 */    
    @Override
	public SqlOperatorNodeImpl visitSqlOperator(SqlOperatorContext ctx) {
		SqlOperator operator = toSqlOperator(ctx);
		return new SqlOperatorNodeImpl(operator);
	}
    
	@Override
	public SkillLevelConditionNodeImpl visitBINARYOP(BINARYOPContext ctx) {
        BinaryOperatorNodeImpl binaryOperatorNode = visitBinaryOperator(ctx.binaryOperator());
        int level = toNumber(ctx.NUMBER());
        SkillLevelCondition condition = new BinarySkillLevelConditionImpl(binaryOperatorNode.getOperator(), level);
        return new SkillLevelConditionNodeImpl(condition);
	}

	@Override
	public Node visitSQLOP(SQLOPContext ctx) {
		List<TerminalNode> numbers = ctx.NUMBER();
		SqlOperatorNodeImpl binaryOperatorNode = visitSqlOperator(ctx.sqlOperator());
        int lowerLevel = toNumber(numbers.get(0));
        int upperLevel = toNumber(numbers.get(1));
        SkillLevelCondition condition = new SqlSkillLevelConditionImpl(binaryOperatorNode.getOperator(), lowerLevel, upperLevel);
        return new SkillLevelConditionNodeImpl(condition);
	}			
}
