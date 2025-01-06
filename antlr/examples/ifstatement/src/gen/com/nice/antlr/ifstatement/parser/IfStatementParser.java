// Generated from IfStatement.g4 by ANTLR 4.13.1
package com.nice.antlr.ifstatement.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IfStatementParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, IF=12, ELSE=13, ELSEIF=14, ENDIF=15, PRINT=16, LEAST_BUSY_OF=17, 
		QUEUE_TO=18, BOOLEAN=19, DOUBLE=20, NUMBER=21, Identifier=22, UUID_OR_HEXA=23, 
		LESS_THAN=24, LESS_THAN_EQUAL=25, EQUAL=26, DEQUAL=27, GREATER_THAN=28, 
		GREATER_THAN_EQUAL=29, NE1=30, NE2=31, IN=32, NOT_IN=33, WS=34;
	public static final int
		RULE_start = 0, RULE_execution = 1, RULE_assignment = 2, RULE_ifstmt = 3, 
		RULE_elseifstmt = 4, RULE_elsestmt = 5, RULE_conditiongroup = 6, RULE_condition = 7, 
		RULE_expr = 8, RULE_binarysign = 9, RULE_arithmeticsign = 10, RULE_addop = 11, 
		RULE_mulop = 12, RULE_relop = 13, RULE_logicalop = 14, RULE_doRule = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "execution", "assignment", "ifstmt", "elseifstmt", "elsestmt", 
			"conditiongroup", "condition", "expr", "binarysign", "arithmeticsign", 
			"addop", "mulop", "relop", "logicalop", "doRule"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'set'", "'('", "')'", "'!'", "'-'", "'+'", "'*'", "'/'", "'%'", 
			"'||'", "'&&'", "'if'", "'else'", "'elseif'", "'endif'", "'print'", null, 
			null, null, null, null, null, null, "'<'", "'<='", "'='", "'=='", "'>'", 
			"'>='", "'!='", "'<>'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"IF", "ELSE", "ELSEIF", "ENDIF", "PRINT", "LEAST_BUSY_OF", "QUEUE_TO", 
			"BOOLEAN", "DOUBLE", "NUMBER", "Identifier", "UUID_OR_HEXA", "LESS_THAN", 
			"LESS_THAN_EQUAL", "EQUAL", "DEQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL", 
			"NE1", "NE2", "IN", "NOT_IN", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IfStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IfStatementParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ExecutionContext execution() {
			return getRuleContext(ExecutionContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case IF:
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				execution();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExecutionContext extends ParserRuleContext {
		public ExecutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execution; }
	 
		public ExecutionContext() { }
		public void copyFrom(ExecutionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXECUTEIFContext extends ExecutionContext {
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public EXECUTEIFContext(ExecutionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterEXECUTEIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitEXECUTEIF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitEXECUTEIF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXECUTERULEContext extends ExecutionContext {
		public DoRuleContext doRule() {
			return getRuleContext(DoRuleContext.class,0);
		}
		public EXECUTERULEContext(ExecutionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterEXECUTERULE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitEXECUTERULE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitEXECUTERULE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_execution);
		int _la;
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case IF:
				_localctx = new EXECUTEIFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(36);
					assignment();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				ifstmt();
				}
				break;
			case PRINT:
				_localctx = new EXECUTERULEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				doRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CNDASSSIGNMENTContext extends AssignmentContext {
		public TerminalNode Identifier() { return getToken(IfStatementParser.Identifier, 0); }
		public TerminalNode EQUAL() { return getToken(IfStatementParser.EQUAL, 0); }
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public CNDASSSIGNMENTContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterCNDASSSIGNMENT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitCNDASSSIGNMENT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitCNDASSSIGNMENT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRASSSIGNMENTContext extends AssignmentContext {
		public TerminalNode Identifier() { return getToken(IfStatementParser.Identifier, 0); }
		public TerminalNode EQUAL() { return getToken(IfStatementParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPRASSSIGNMENTContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterEXPRASSSIGNMENT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitEXPRASSSIGNMENT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitEXPRASSSIGNMENT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new EXPRASSSIGNMENTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(T__0);
				setState(47);
				match(Identifier);
				setState(48);
				match(EQUAL);
				setState(49);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CNDASSSIGNMENTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__0);
				setState(51);
				match(Identifier);
				setState(52);
				match(EQUAL);
				setState(53);
				conditiongroup(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(IfStatementParser.IF, 0); }
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public DoRuleContext doRule() {
			return getRuleContext(DoRuleContext.class,0);
		}
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(IfStatementParser.ENDIF, 0); }
		public List<ElseifstmtContext> elseifstmt() {
			return getRuleContexts(ElseifstmtContext.class);
		}
		public ElseifstmtContext elseifstmt(int i) {
			return getRuleContext(ElseifstmtContext.class,i);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IF);
			setState(57);
			conditiongroup(0);
			setState(58);
			doRule();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(59);
				elseifstmt();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			elsestmt();
			setState(66);
			match(ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseifstmtContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(IfStatementParser.ELSEIF, 0); }
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public DoRuleContext doRule() {
			return getRuleContext(DoRuleContext.class,0);
		}
		public ElseifstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterElseifstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitElseifstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitElseifstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifstmtContext elseifstmt() throws RecognitionException {
		ElseifstmtContext _localctx = new ElseifstmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ELSEIF);
			setState(69);
			conditiongroup(0);
			setState(70);
			doRule();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsestmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(IfStatementParser.ELSE, 0); }
		public DoRuleContext doRule() {
			return getRuleContext(DoRuleContext.class,0);
		}
		public ElsestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterElsestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitElsestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitElsestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elsestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(ELSE);
			setState(73);
			doRule();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditiongroupContext extends ParserRuleContext {
		public ConditiongroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditiongroup; }
	 
		public ConditiongroupContext() { }
		public void copyFrom(ConditiongroupContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LOGICALGRPTContext extends ConditiongroupContext {
		public List<ConditiongroupContext> conditiongroup() {
			return getRuleContexts(ConditiongroupContext.class);
		}
		public ConditiongroupContext conditiongroup(int i) {
			return getRuleContext(ConditiongroupContext.class,i);
		}
		public LogicalopContext logicalop() {
			return getRuleContext(LogicalopContext.class,0);
		}
		public LOGICALGRPTContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterLOGICALGRPT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitLOGICALGRPT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitLOGICALGRPT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARIABLEGRPContext extends ConditiongroupContext {
		public TerminalNode Identifier() { return getToken(IfStatementParser.Identifier, 0); }
		public VARIABLEGRPContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterVARIABLEGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitVARIABLEGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitVARIABLEGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CONDITIONGRPContext extends ConditiongroupContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CONDITIONGRPContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterCONDITIONGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitCONDITIONGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitCONDITIONGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BINARYGRPContext extends ConditiongroupContext {
		public BinarysignContext binarysign() {
			return getRuleContext(BinarysignContext.class,0);
		}
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public BINARYGRPContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterBINARYGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitBINARYGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitBINARYGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CONDITIONGRPTContext extends ConditiongroupContext {
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public CONDITIONGRPTContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterCONDITIONGRPT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitCONDITIONGRPT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitCONDITIONGRPT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOOLEANContext extends ConditiongroupContext {
		public TerminalNode BOOLEAN() { return getToken(IfStatementParser.BOOLEAN, 0); }
		public BOOLEANContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterBOOLEAN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitBOOLEAN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitBOOLEAN(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditiongroupContext conditiongroup() throws RecognitionException {
		return conditiongroup(0);
	}

	private ConditiongroupContext conditiongroup(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditiongroupContext _localctx = new ConditiongroupContext(_ctx, _parentState);
		ConditiongroupContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_conditiongroup, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new BINARYGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(76);
				binarysign();
				setState(77);
				conditiongroup(6);
				}
				break;
			case 2:
				{
				_localctx = new CONDITIONGRPTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(T__1);
				setState(80);
				conditiongroup(0);
				setState(81);
				match(T__2);
				}
				break;
			case 3:
				{
				_localctx = new CONDITIONGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				condition();
				}
				break;
			case 4:
				{
				_localctx = new BOOLEANContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(BOOLEAN);
				}
				break;
			case 5:
				{
				_localctx = new VARIABLEGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOGICALGRPTContext(new ConditiongroupContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditiongroup);
					setState(88);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(89);
					logicalop();
					setState(90);
					conditiongroup(6);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RELOPGRPContext extends ConditionContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public RELOPGRPContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterRELOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitRELOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitRELOPGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CNDPARENGRPContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CNDPARENGRPContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterCNDPARENGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitCNDPARENGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitCNDPARENGRP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new RELOPGRPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				expr(0);
				setState(98);
				relop();
				setState(99);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CNDPARENGRPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(T__1);
				setState(102);
				condition();
				setState(103);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARIABLEContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(IfStatementParser.Identifier, 0); }
		public VARIABLEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterVARIABLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitVARIABLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitVARIABLE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEContext extends ExprContext {
		public TerminalNode DOUBLE() { return getToken(IfStatementParser.DOUBLE, 0); }
		public DOUBLEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterDOUBLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitDOUBLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitDOUBLE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MULOPGRPContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public MULOPGRPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterMULOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitMULOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitMULOPGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SIGNGRPContext extends ExprContext {
		public ArithmeticsignContext arithmeticsign() {
			return getRuleContext(ArithmeticsignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SIGNGRPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterSIGNGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitSIGNGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitSIGNGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPPARENGRPContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPPARENGRPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterEXPPARENGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitEXPPARENGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitEXPPARENGRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ADDOPGRPContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public ADDOPGRPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterADDOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitADDOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitADDOPGRP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				_localctx = new SIGNGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				arithmeticsign();
				setState(109);
				expr(6);
				}
				break;
			case T__1:
				{
				_localctx = new EXPPARENGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				match(T__1);
				setState(112);
				expr(0);
				setState(113);
				match(T__2);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DOUBLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(DOUBLE);
				}
				break;
			case Identifier:
				{
				_localctx = new VARIABLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(127);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MULOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(120);
						mulop();
						setState(121);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ADDOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(124);
						addop();
						setState(125);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinarysignContext extends ParserRuleContext {
		public BinarysignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterBinarysign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitBinarysign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitBinarysign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinarysignContext binarysign() throws RecognitionException {
		BinarysignContext _localctx = new BinarysignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binarysign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticsignContext extends ParserRuleContext {
		public ArithmeticsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticsign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterArithmeticsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitArithmeticsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitArithmeticsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticsignContext arithmeticsign() throws RecognitionException {
		ArithmeticsignContext _localctx = new ArithmeticsignContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmeticsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitAddop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitAddop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitMulop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitMulop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelopContext extends ParserRuleContext {
		public TerminalNode DEQUAL() { return getToken(IfStatementParser.DEQUAL, 0); }
		public TerminalNode NE1() { return getToken(IfStatementParser.NE1, 0); }
		public TerminalNode GREATER_THAN() { return getToken(IfStatementParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(IfStatementParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN_EQUAL() { return getToken(IfStatementParser.GREATER_THAN_EQUAL, 0); }
		public TerminalNode LESS_THAN_EQUAL() { return getToken(IfStatementParser.LESS_THAN_EQUAL, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2063597568L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalopContext extends ParserRuleContext {
		public LogicalopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterLogicalop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitLogicalop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitLogicalop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalopContext logicalop() throws RecognitionException {
		LogicalopContext _localctx = new LogicalopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicalop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoRuleContext extends ParserRuleContext {
		public DoRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doRule; }
	 
		public DoRuleContext() { }
		public void copyFrom(DoRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOPRINTContext extends DoRuleContext {
		public TerminalNode PRINT() { return getToken(IfStatementParser.PRINT, 0); }
		public TerminalNode DOUBLE() { return getToken(IfStatementParser.DOUBLE, 0); }
		public DOPRINTContext(DoRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterDOPRINT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitDOPRINT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitDOPRINT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoRuleContext doRule() throws RecognitionException {
		DoRuleContext _localctx = new DoRuleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_doRule);
		try {
			_localctx = new DOPRINTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(PRINT);
			setState(145);
			match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return conditiongroup_sempred((ConditiongroupContext)_localctx, predIndex);
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditiongroup_sempred(ConditiongroupContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u0094\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0001\u0000\u0003\u0000#\b\u0000\u0001\u0001\u0005\u0001"+
		"&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003=\b\u0003\n\u0003\f\u0003"+
		"@\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006W\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006]\b\u0006"+
		"\n\u0006\f\u0006`\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007j\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bv\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0080\b\b\n\b\f\b\u0083\t\b\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0000\u0002\f\u0010\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\u0005\u0006"+
		"\u0001\u0000\u0007\t\u0002\u0000\u0018\u0019\u001b\u001e\u0001\u0000\n"+
		"\u000b\u0093\u0000\"\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000"+
		"\u0000\u00046\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b"+
		"D\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000"+
		"\u0000\u000ei\u0001\u0000\u0000\u0000\u0010u\u0001\u0000\u0000\u0000\u0012"+
		"\u0084\u0001\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000\u0016"+
		"\u0088\u0001\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a"+
		"\u008c\u0001\u0000\u0000\u0000\u001c\u008e\u0001\u0000\u0000\u0000\u001e"+
		"\u0090\u0001\u0000\u0000\u0000 #\u0003\u0002\u0001\u0000!#\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0001"+
		"\u0001\u0000\u0000\u0000$&\u0003\u0004\u0002\u0000%$\u0001\u0000\u0000"+
		"\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*-\u0003"+
		"\u0006\u0003\u0000+-\u0003\u001e\u000f\u0000,\'\u0001\u0000\u0000\u0000"+
		",+\u0001\u0000\u0000\u0000-\u0003\u0001\u0000\u0000\u0000./\u0005\u0001"+
		"\u0000\u0000/0\u0005\u0016\u0000\u000001\u0005\u001a\u0000\u000017\u0003"+
		"\u0010\b\u000023\u0005\u0001\u0000\u000034\u0005\u0016\u0000\u000045\u0005"+
		"\u001a\u0000\u000057\u0003\f\u0006\u00006.\u0001\u0000\u0000\u000062\u0001"+
		"\u0000\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0005\f\u0000\u0000"+
		"9:\u0003\f\u0006\u0000:>\u0003\u001e\u000f\u0000;=\u0003\b\u0004\u0000"+
		"<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000AB\u0003\n\u0005\u0000BC\u0005\u000f\u0000\u0000C\u0007\u0001"+
		"\u0000\u0000\u0000DE\u0005\u000e\u0000\u0000EF\u0003\f\u0006\u0000FG\u0003"+
		"\u001e\u000f\u0000G\t\u0001\u0000\u0000\u0000HI\u0005\r\u0000\u0000IJ"+
		"\u0003\u001e\u000f\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0006\u0006"+
		"\uffff\uffff\u0000LM\u0003\u0012\t\u0000MN\u0003\f\u0006\u0006NW\u0001"+
		"\u0000\u0000\u0000OP\u0005\u0002\u0000\u0000PQ\u0003\f\u0006\u0000QR\u0005"+
		"\u0003\u0000\u0000RW\u0001\u0000\u0000\u0000SW\u0003\u000e\u0007\u0000"+
		"TW\u0005\u0013\u0000\u0000UW\u0005\u0016\u0000\u0000VK\u0001\u0000\u0000"+
		"\u0000VO\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000VU\u0001\u0000\u0000\u0000W^\u0001\u0000\u0000\u0000XY\n\u0005"+
		"\u0000\u0000YZ\u0003\u001c\u000e\u0000Z[\u0003\f\u0006\u0006[]\u0001\u0000"+
		"\u0000\u0000\\X\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\r\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ab\u0003\u0010\b\u0000bc\u0003\u001a\r\u0000"+
		"cd\u0003\u0010\b\u0000dj\u0001\u0000\u0000\u0000ef\u0005\u0002\u0000\u0000"+
		"fg\u0003\u000e\u0007\u0000gh\u0005\u0003\u0000\u0000hj\u0001\u0000\u0000"+
		"\u0000ia\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000\u0000j\u000f\u0001"+
		"\u0000\u0000\u0000kl\u0006\b\uffff\uffff\u0000lm\u0003\u0014\n\u0000m"+
		"n\u0003\u0010\b\u0006nv\u0001\u0000\u0000\u0000op\u0005\u0002\u0000\u0000"+
		"pq\u0003\u0010\b\u0000qr\u0005\u0003\u0000\u0000rv\u0001\u0000\u0000\u0000"+
		"sv\u0005\u0014\u0000\u0000tv\u0005\u0016\u0000\u0000uk\u0001\u0000\u0000"+
		"\u0000uo\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000"+
		"\u0000\u0000v\u0081\u0001\u0000\u0000\u0000wx\n\u0005\u0000\u0000xy\u0003"+
		"\u0018\f\u0000yz\u0003\u0010\b\u0006z\u0080\u0001\u0000\u0000\u0000{|"+
		"\n\u0004\u0000\u0000|}\u0003\u0016\u000b\u0000}~\u0003\u0010\b\u0005~"+
		"\u0080\u0001\u0000\u0000\u0000\u007fw\u0001\u0000\u0000\u0000\u007f{\u0001"+
		"\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0011\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"\u0004\u0000\u0000\u0085\u0013\u0001\u0000\u0000\u0000\u0086\u0087\u0005"+
		"\u0005\u0000\u0000\u0087\u0015\u0001\u0000\u0000\u0000\u0088\u0089\u0007"+
		"\u0000\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008b\u0007"+
		"\u0001\u0000\u0000\u008b\u0019\u0001\u0000\u0000\u0000\u008c\u008d\u0007"+
		"\u0002\u0000\u0000\u008d\u001b\u0001\u0000\u0000\u0000\u008e\u008f\u0007"+
		"\u0003\u0000\u0000\u008f\u001d\u0001\u0000\u0000\u0000\u0090\u0091\u0005"+
		"\u0010\u0000\u0000\u0091\u0092\u0005\u0014\u0000\u0000\u0092\u001f\u0001"+
		"\u0000\u0000\u0000\u000b\"\',6>V^iu\u007f\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}