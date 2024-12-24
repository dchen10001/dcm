// Generated from Expression.g4 by ANTLR 4.13.1
package com.nice.antlr.experssion.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExpressionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExpressionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUMINUS(ExpressionParser.UMINUSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUMINUS(ExpressionParser.UMINUSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPARENGRP(ExpressionParser.PARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPARENGRP(ExpressionParser.PARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(ExpressionParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(ExpressionParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(ExpressionParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(ExpressionParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(ExpressionParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(ExpressionParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(ExpressionParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(ExpressionParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(ExpressionParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(ExpressionParser.MulopContext ctx);
}