// Generated from DistributionRules.g4 by ANTLR 4.13.1
package com.nice.dcm.distribution.rule.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DistributionRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DistributionRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#routingRuleSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutingRuleSet(DistributionRulesParser.RoutingRuleSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#routingWaitingRuleGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutingWaitingRuleGroup(DistributionRulesParser.RoutingWaitingRuleGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#routingRuleGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutingRuleGroup(DistributionRulesParser.RoutingRuleGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#routingRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutingRule(DistributionRulesParser.RoutingRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ACTQUEUETO}
	 * labeled alternative in {@link DistributionRulesParser#ruleAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitACTQUEUETO(DistributionRulesParser.ACTQUEUETOContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKILLSETOR}
	 * labeled alternative in {@link DistributionRulesParser#orSkills}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKILLSETOR(DistributionRulesParser.SKILLSETORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ORSKILL}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORSKILL(DistributionRulesParser.ORSKILLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ORSKILLSET}
	 * labeled alternative in {@link DistributionRulesParser#skillOrSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORSKILLSET(DistributionRulesParser.ORSKILLSETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKILLANDSET}
	 * labeled alternative in {@link DistributionRulesParser#skillSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKILLANDSET(DistributionRulesParser.SKILLANDSETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SKILLCONDITION}
	 * labeled alternative in {@link DistributionRulesParser#skill}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSKILLCONDITION(DistributionRulesParser.SKILLCONDITIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARYOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARYOP(DistributionRulesParser.BINARYOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SQLOP}
	 * labeled alternative in {@link DistributionRulesParser#levelCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSQLOP(DistributionRulesParser.SQLOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(DistributionRulesParser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#sqlOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlOperator(DistributionRulesParser.SqlOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OIDHEX}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOIDHEX(DistributionRulesParser.OIDHEXContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OIDNUMBER}
	 * labeled alternative in {@link DistributionRulesParser#entity_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOIDNUMBER(DistributionRulesParser.OIDNUMBERContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(DistributionRulesParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link DistributionRulesParser#waitRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitRule(DistributionRulesParser.WaitRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QSLEASTBUSYOF}
	 * labeled alternative in {@link DistributionRulesParser#queue_status}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQSLEASTBUSYOF(DistributionRulesParser.QSLEASTBUSYOFContext ctx);
}