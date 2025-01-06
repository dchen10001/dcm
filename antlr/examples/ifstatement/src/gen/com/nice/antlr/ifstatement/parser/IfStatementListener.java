// Generated from IfStatement.g4 by ANTLR 4.13.1
package com.nice.antlr.ifstatement.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IfStatementParser}.
 */
public interface IfStatementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(IfStatementParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(IfStatementParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXECUTEIF}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 */
	void enterEXECUTEIF(IfStatementParser.EXECUTEIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXECUTEIF}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 */
	void exitEXECUTEIF(IfStatementParser.EXECUTEIFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXECUTERULE}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 */
	void enterEXECUTERULE(IfStatementParser.EXECUTERULEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXECUTERULE}
	 * labeled alternative in {@link IfStatementParser#execution}.
	 * @param ctx the parse tree
	 */
	void exitEXECUTERULE(IfStatementParser.EXECUTERULEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPRASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterEXPRASSSIGNMENT(IfStatementParser.EXPRASSSIGNMENTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPRASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitEXPRASSSIGNMENT(IfStatementParser.EXPRASSSIGNMENTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CNDASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterCNDASSSIGNMENT(IfStatementParser.CNDASSSIGNMENTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CNDASSSIGNMENT}
	 * labeled alternative in {@link IfStatementParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitCNDASSSIGNMENT(IfStatementParser.CNDASSSIGNMENTContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(IfStatementParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(IfStatementParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#elseifstmt}.
	 * @param ctx the parse tree
	 */
	void enterElseifstmt(IfStatementParser.ElseifstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#elseifstmt}.
	 * @param ctx the parse tree
	 */
	void exitElseifstmt(IfStatementParser.ElseifstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#elsestmt}.
	 * @param ctx the parse tree
	 */
	void enterElsestmt(IfStatementParser.ElsestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#elsestmt}.
	 * @param ctx the parse tree
	 */
	void exitElsestmt(IfStatementParser.ElsestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterLOGICALGRPT(IfStatementParser.LOGICALGRPTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICALGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitLOGICALGRPT(IfStatementParser.LOGICALGRPTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLEGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLEGRP(IfStatementParser.VARIABLEGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLEGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLEGRP(IfStatementParser.VARIABLEGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterCONDITIONGRP(IfStatementParser.CONDITIONGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONDITIONGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitCONDITIONGRP(IfStatementParser.CONDITIONGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterBINARYGRP(IfStatementParser.BINARYGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BINARYGRP}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitBINARYGRP(IfStatementParser.BINARYGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterCONDITIONGRPT(IfStatementParser.CONDITIONGRPTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CONDITIONGRPT}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitCONDITIONGRPT(IfStatementParser.CONDITIONGRPTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOLEAN}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void enterBOOLEAN(IfStatementParser.BOOLEANContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOLEAN}
	 * labeled alternative in {@link IfStatementParser#conditiongroup}.
	 * @param ctx the parse tree
	 */
	void exitBOOLEAN(IfStatementParser.BOOLEANContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterRELOPGRP(IfStatementParser.RELOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RELOPGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitRELOPGRP(IfStatementParser.RELOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCNDPARENGRP(IfStatementParser.CNDPARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CNDPARENGRP}
	 * labeled alternative in {@link IfStatementParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCNDPARENGRP(IfStatementParser.CNDPARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLE(IfStatementParser.VARIABLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLE(IfStatementParser.VARIABLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(IfStatementParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(IfStatementParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(IfStatementParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(IfStatementParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSIGNGRP(IfStatementParser.SIGNGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SIGNGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSIGNGRP(IfStatementParser.SIGNGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPPARENGRP(IfStatementParser.EXPPARENGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EXPPARENGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPPARENGRP(IfStatementParser.EXPPARENGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(IfStatementParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link IfStatementParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(IfStatementParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#binarysign}.
	 * @param ctx the parse tree
	 */
	void enterBinarysign(IfStatementParser.BinarysignContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#binarysign}.
	 * @param ctx the parse tree
	 */
	void exitBinarysign(IfStatementParser.BinarysignContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#arithmeticsign}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticsign(IfStatementParser.ArithmeticsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#arithmeticsign}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticsign(IfStatementParser.ArithmeticsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(IfStatementParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(IfStatementParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(IfStatementParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(IfStatementParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(IfStatementParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(IfStatementParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IfStatementParser#logicalop}.
	 * @param ctx the parse tree
	 */
	void enterLogicalop(IfStatementParser.LogicalopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IfStatementParser#logicalop}.
	 * @param ctx the parse tree
	 */
	void exitLogicalop(IfStatementParser.LogicalopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOPRINT}
	 * labeled alternative in {@link IfStatementParser#doRule}.
	 * @param ctx the parse tree
	 */
	void enterDOPRINT(IfStatementParser.DOPRINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOPRINT}
	 * labeled alternative in {@link IfStatementParser#doRule}.
	 * @param ctx the parse tree
	 */
	void exitDOPRINT(IfStatementParser.DOPRINTContext ctx);
}