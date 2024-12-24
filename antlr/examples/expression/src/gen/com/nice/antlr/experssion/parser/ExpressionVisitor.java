// Generated from Expression.g4 by ANTLR 4.13.1
package com.nice.antlr.experssion.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UMINUS}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUMINUS(ExpressionParser.UMINUSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PARENGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPARENGRP(ExpressionParser.PARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(ExpressionParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULOPGRP(ExpressionParser.MULOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDOPGRP(ExpressionParser.ADDOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(ExpressionParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(ExpressionParser.MulopContext ctx);
}