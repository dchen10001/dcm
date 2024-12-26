// Generated from Condition.g4 by ANTLR 4.13.1
package com.nice.antlr.condition.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConditionParser}.
 */
public interface ConditionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConditionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ConditionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ConditionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterLOGICALGRPT(ConditionParser.LOGICALGRPTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitLOGICALGRPT(ConditionParser.LOGICALGRPTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterCONDITIONGRP(ConditionParser.CONDITIONGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitCONDITIONGRP(ConditionParser.CONDITIONGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterBINARYGRP(ConditionParser.BINARYGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitBINARYGRP(ConditionParser.BINARYGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterCONDITIONGRPT(ConditionParser.CONDITIONGRPTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitCONDITIONGRPT(ConditionParser.CONDITIONGRPTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterRELOPGRP(ConditionParser.RELOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitRELOPGRP(ConditionParser.RELOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCNDPARENGRP(ConditionParser.CNDPARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCNDPARENGRP(ConditionParser.CNDPARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLE(ConditionParser.VARIABLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLE(ConditionParser.VARIABLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(ConditionParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(ConditionParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(ConditionParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(ConditionParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSIGNGRP(ConditionParser.SIGNGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSIGNGRP(ConditionParser.SIGNGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPPARENGRP(ConditionParser.EXPPARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPPARENGRP(ConditionParser.EXPPARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(ConditionParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(ConditionParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#binarysign}.
	 * @param ctx the parse tree
	 */
	void enterBinarysign(ConditionParser.BinarysignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#binarysign}.
	 * @param ctx the parse tree
	 */
	void exitBinarysign(ConditionParser.BinarysignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#arithmeticsign}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticsign(ConditionParser.ArithmeticsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#arithmeticsign}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticsign(ConditionParser.ArithmeticsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(ConditionParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(ConditionParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(ConditionParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(ConditionParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(ConditionParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(ConditionParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#logicalop}.
	 * @param ctx the parse tree
	 */
	void enterLogicalop(ConditionParser.LogicalopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#logicalop}.
	 * @param ctx the parse tree
	 */
	void exitLogicalop(ConditionParser.LogicalopContext ctx);
}