// Generated from DistributionRules.g4 by ANTLR 4.13.1
package com.nice.dcm.distribution.rule.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DistributionRulesParser}.
 */
public interface DistributionRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#routingRuleSet}.
	 * @param ctx the parse tree
	 */
	void enterRoutingRuleSet(DistributionRulesParser.RoutingRuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#routingRuleSet}.
	 * @param ctx the parse tree
	 */
	void exitRoutingRuleSet(DistributionRulesParser.RoutingRuleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#routingWaitingRuleGroup}.
	 * @param ctx the parse tree
	 */
	void enterRoutingWaitingRuleGroup(DistributionRulesParser.RoutingWaitingRuleGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#routingWaitingRuleGroup}.
	 * @param ctx the parse tree
	 */
	void exitRoutingWaitingRuleGroup(DistributionRulesParser.RoutingWaitingRuleGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#routingRuleGroup}.
	 * @param ctx the parse tree
	 */
	void enterRoutingRuleGroup(DistributionRulesParser.RoutingRuleGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#routingRuleGroup}.
	 * @param ctx the parse tree
	 */
	void exitRoutingRuleGroup(DistributionRulesParser.RoutingRuleGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#routingRule}.
	 * @param ctx the parse tree
	 */
	void enterRoutingRule(DistributionRulesParser.RoutingRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#routingRule}.
	 * @param ctx the parse tree
	 */
	void exitRoutingRule(DistributionRulesParser.RoutingRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ACTQUEUETO}
	 * labeled alternative in {@link DistributionRulesParser#ruleAction}.
	 * @param ctx the parse tree
	 */
	void enterACTQUEUETO(DistributionRulesParser.ACTQUEUETOContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ACTQUEUETO}
	 * labeled alternative in {@link DistributionRulesParser#ruleAction}.
	 * @param ctx the parse tree
	 */
	void exitACTQUEUETO(DistributionRulesParser.ACTQUEUETOContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SKILLSETOR}
	 * labeled alternative in {@link DistributionRulesParser#orSkills}.
	 * @param ctx the parse tree
	 */
	void enterSKILLSETOR(DistributionRulesParser.SKILLSETORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SKILLSETOR}
	 * labeled alternative in {@link DistributionRulesParser#orSkills}.
	 * @param ctx the parse tree
	 */
	void exitSKILLSETOR(DistributionRulesParser.SKILLSETORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ORSKILL}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 */
	void enterORSKILL(DistributionRulesParser.ORSKILLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ORSKILL}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 */
	void exitORSKILL(DistributionRulesParser.ORSKILLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ORSKILLSET}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 */
	void enterORSKILLSET(DistributionRulesParser.ORSKILLSETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ORSKILLSET}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 */
	void exitORSKILLSET(DistributionRulesParser.ORSKILLSETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SKILLANDSET}
	 * labeled alternative in {@link DistributionRulesParser#skillSet}.
	 * @param ctx the parse tree
	 */
	void enterSKILLANDSET(DistributionRulesParser.SKILLANDSETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SKILLANDSET}
	 * labeled alternative in {@link DistributionRulesParser#skillSet}.
	 * @param ctx the parse tree
	 */
	void exitSKILLANDSET(DistributionRulesParser.SKILLANDSETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SKILLCONDITION}
	 * labeled alternative in {@link DistributionRulesParser#skill}.
	 * @param ctx the parse tree
	 */
	void enterSKILLCONDITION(DistributionRulesParser.SKILLCONDITIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SKILLCONDITION}
	 * labeled alternative in {@link DistributionRulesParser#skill}.
	 * @param ctx the parse tree
	 */
	void exitSKILLCONDITION(DistributionRulesParser.SKILLCONDITIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BINARYOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 */
	void enterBINARYOP(DistributionRulesParser.BINARYOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BINARYOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 */
	void exitBINARYOP(DistributionRulesParser.BINARYOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SQLOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 */
	void enterSQLOP(DistributionRulesParser.SQLOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SQLOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 */
	void exitSQLOP(DistributionRulesParser.SQLOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(DistributionRulesParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(DistributionRulesParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#sqlOperator}.
	 * @param ctx the parse tree
	 */
	void enterSqlOperator(DistributionRulesParser.SqlOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#sqlOperator}.
	 * @param ctx the parse tree
	 */
	void exitSqlOperator(DistributionRulesParser.SqlOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OIDHEX}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 */
	void enterOIDHEX(DistributionRulesParser.OIDHEXContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OIDHEX}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 */
	void exitOIDHEX(DistributionRulesParser.OIDHEXContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OIDNUMBER}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 */
	void enterOIDNUMBER(DistributionRulesParser.OIDNUMBERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OIDNUMBER}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 */
	void exitOIDNUMBER(DistributionRulesParser.OIDNUMBERContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#priority}.
	 * @param ctx the parse tree
	 */
	void enterPriority(DistributionRulesParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#priority}.
	 * @param ctx the parse tree
	 */
	void exitPriority(DistributionRulesParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link DistributionRulesParser#waitRule}.
	 * @param ctx the parse tree
	 */
	void enterWaitRule(DistributionRulesParser.WaitRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DistributionRulesParser#waitRule}.
	 * @param ctx the parse tree
	 */
	void exitWaitRule(DistributionRulesParser.WaitRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QSLEASTBUSYOF}
	 * labeled alternative in {@link DistributionRulesParser#queue_status}.
	 * @param ctx the parse tree
	 */
	void enterQSLEASTBUSYOF(DistributionRulesParser.QSLEASTBUSYOFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QSLEASTBUSYOF}
	 * labeled alternative in {@link DistributionRulesParser#queue_status}.
	 * @param ctx the parse tree
	 */
	void exitQSLEASTBUSYOF(DistributionRulesParser.QSLEASTBUSYOFContext ctx);
}