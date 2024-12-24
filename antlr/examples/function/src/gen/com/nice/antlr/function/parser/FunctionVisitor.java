// Generated from Function.g4 by ANTLR 4.13.1
package com.nice.antlr.function.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FunctionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUMINUS(FunctionParser.UMINUSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARIABLE(FunctionParser.VARIABLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPARENGRP(FunctionParser.PARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(FunctionParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULOPGRP(FunctionParser.MULOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link FunctionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDOPGRP(FunctionParser.ADDOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(FunctionParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(FunctionParser.MulopContext ctx);
}