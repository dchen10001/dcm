// Generated from IfStatement.g4 by ANTLR 4.13.1
package com.nice.antlr.ifstatement.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IfStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IfStatementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(IfStatementParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXECUTEIF}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXECUTEIF(IfStatementParser.EXECUTEIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXECUTERULE}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXECUTERULE(IfStatementParser.EXECUTERULEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPRASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRASSSIGNMENT(IfStatementParser.EXPRASSSIGNMENTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CNDASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCNDASSSIGNMENT(IfStatementParser.CNDASSSIGNMENTContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(IfStatementParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#elseifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifstmt(IfStatementParser.ElseifstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#elsestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsestmt(IfStatementParser.ElsestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICALGRPT(IfStatementParser.LOGICALGRPTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARIABLEGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARIABLEGRP(IfStatementParser.VARIABLEGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONDITIONGRP(IfStatementParser.CONDITIONGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBINARYGRP(IfStatementParser.BINARYGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCONDITIONGRPT(IfStatementParser.CONDITIONGRPTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOLEAN}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOLEAN(IfStatementParser.BOOLEANContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRELOPGRP(IfStatementParser.RELOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCNDPARENGRP(IfStatementParser.CNDPARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARIABLE(IfStatementParser.VARIABLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(IfStatementParser.DOUBLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULOPGRP(IfStatementParser.MULOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSIGNGRP(IfStatementParser.SIGNGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPPARENGRP(IfStatementParser.EXPPARENGRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDOPGRP(IfStatementParser.ADDOPGRPContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#binarysign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarysign(IfStatementParser.BinarysignContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#arithmeticsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticsign(IfStatementParser.ArithmeticsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(IfStatementParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(IfStatementParser.MulopContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(IfStatementParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link IfStatementParser#logicalop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalop(IfStatementParser.LogicalopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOPRINT}
	 * labeled alternative in {@link IfStatementParser#doRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOPRINT(IfStatementParser.DOPRINTContext ctx);
}