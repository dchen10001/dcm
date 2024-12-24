// Generated from Function.g4 by ANTLR 4.13.1
package com.nice.antlr.function.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionParser}.
 */
public interface FunctionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FunctionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FunctionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUMINUS(FunctionParser.UMINUSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUMINUS(FunctionParser.UMINUSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLE(FunctionParser.VARIABLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLE(FunctionParser.VARIABLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPARENGRP(FunctionParser.PARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPARENGRP(FunctionParser.PARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(FunctionParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(FunctionParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(FunctionParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(FunctionParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(FunctionParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(FunctionParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(FunctionParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(FunctionParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(FunctionParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(FunctionParser.MulopContext ctx);
}