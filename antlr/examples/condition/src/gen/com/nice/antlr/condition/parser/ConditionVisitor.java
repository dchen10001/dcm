// Generated from Condition.g4 by ANTLR 4.13.1
package com.nice.antlr.condition.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConditionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConditionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConditionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ConditionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSSIGNMENT}
	 * labeled alternative in {@link ConditionParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSSIGNMENT(ConditionParser.ASSSIGNMENTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICALGRPT(ConditionParser.LOGICALGRPTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONDITIONGRP(ConditionParser.CONDITIONGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARYGRP(ConditionParser.BINARYGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link ConditionParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONDITIONGRPT(ConditionParser.CONDITIONGRPTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRELOPGRP(ConditionParser.RELOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link ConditionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCNDPARENGRP(ConditionParser.CNDPARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARIABLE(ConditionParser.VARIABLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(ConditionParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULOPGRP(ConditionParser.MULOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIGNGRP(ConditionParser.SIGNGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPPARENGRP(ConditionParser.EXPPARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link ConditionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDOPGRP(ConditionParser.ADDOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#binarysign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarysign(ConditionParser.BinarysignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#arithmeticsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticsign(ConditionParser.ArithmeticsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(ConditionParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(ConditionParser.MulopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(ConditionParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#logicalop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalop(ConditionParser.LogicalopContext ctx);
}