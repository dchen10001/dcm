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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, IF=19, ELSE=20, ELSEIF=21, ENDIF=22, PRINT=23, BOOLEAN=24, DOUBLE=25, 
		Identifier=26, WS=27;
	public static final int
		RULE_start = 0, RULE_assignment = 1, RULE_ifstmt = 2, RULE_elseifstmt = 3, 
		RULE_elsestmt = 4, RULE_conditiongroup = 5, RULE_condition = 6, RULE_expr = 7, 
		RULE_binarysign = 8, RULE_arithmeticsign = 9, RULE_addop = 10, RULE_mulop = 11, 
		RULE_relop = 12, RULE_logicalop = 13, RULE_printstmt = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "assignment", "ifstmt", "elseifstmt", "elsestmt", "conditiongroup", 
			"condition", "expr", "binarysign", "arithmeticsign", "addop", "mulop", 
			"relop", "logicalop", "printstmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'set'", "'='", "'('", "')'", "'!'", "'-'", "'+'", "'*'", "'/'", 
			"'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'||'", "'&&'", 
			"'if'", "'else'", "'elseif'", "'endif'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IF", "ELSE", "ELSEIF", "ENDIF", 
			"PRINT", "BOOLEAN", "DOUBLE", "Identifier", "WS"
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
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
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
		int _la;
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(30);
					assignment();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36);
				ifstmt();
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
		enterRule(_localctx, 2, RULE_assignment);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new EXPRASSSIGNMENTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(T__0);
				setState(41);
				match(Identifier);
				setState(42);
				match(T__1);
				setState(43);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CNDASSSIGNMENTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(T__0);
				setState(45);
				match(Identifier);
				setState(46);
				match(T__1);
				setState(47);
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
		public PrintstmtContext printstmt() {
			return getRuleContext(PrintstmtContext.class,0);
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
		enterRule(_localctx, 4, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(IF);
			setState(51);
			conditiongroup(0);
			setState(52);
			printstmt();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(53);
				elseifstmt();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			elsestmt();
			setState(60);
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
		public PrintstmtContext printstmt() {
			return getRuleContext(PrintstmtContext.class,0);
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
		enterRule(_localctx, 6, RULE_elseifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ELSEIF);
			setState(63);
			conditiongroup(0);
			setState(64);
			printstmt();
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
		public PrintstmtContext printstmt() {
			return getRuleContext(PrintstmtContext.class,0);
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
		enterRule(_localctx, 8, RULE_elsestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ELSE);
			setState(67);
			printstmt();
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_conditiongroup, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new BINARYGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				binarysign();
				setState(71);
				conditiongroup(6);
				}
				break;
			case 2:
				{
				_localctx = new CONDITIONGRPTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(T__2);
				setState(74);
				conditiongroup(0);
				setState(75);
				match(T__3);
				}
				break;
			case 3:
				{
				_localctx = new CONDITIONGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				condition();
				}
				break;
			case 4:
				{
				_localctx = new BOOLEANContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(BOOLEAN);
				}
				break;
			case 5:
				{
				_localctx = new VARIABLEGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOGICALGRPTContext(new ConditiongroupContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditiongroup);
					setState(82);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(83);
					logicalop();
					setState(84);
					conditiongroup(6);
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 12, RULE_condition);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RELOPGRPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				expr(0);
				setState(92);
				relop();
				setState(93);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CNDPARENGRPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(T__2);
				setState(96);
				condition();
				setState(97);
				match(T__3);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				_localctx = new SIGNGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(102);
				arithmeticsign();
				setState(103);
				expr(6);
				}
				break;
			case T__2:
				{
				_localctx = new EXPPARENGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(T__2);
				setState(106);
				expr(0);
				setState(107);
				match(T__3);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DOUBLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(DOUBLE);
				}
				break;
			case Identifier:
				{
				_localctx = new VARIABLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MULOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(114);
						mulop();
						setState(115);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ADDOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(118);
						addop();
						setState(119);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 16, RULE_binarysign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		enterRule(_localctx, 18, RULE_arithmeticsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__5);
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
		enterRule(_localctx, 20, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
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
		enterRule(_localctx, 22, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 129024L) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_logicalop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
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
	public static class PrintstmtContext extends ParserRuleContext {
		public PrintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstmt; }
	 
		public PrintstmtContext() { }
		public void copyFrom(PrintstmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PRINTDOUBLEContext extends PrintstmtContext {
		public TerminalNode PRINT() { return getToken(IfStatementParser.PRINT, 0); }
		public TerminalNode DOUBLE() { return getToken(IfStatementParser.DOUBLE, 0); }
		public PRINTDOUBLEContext(PrintstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).enterPRINTDOUBLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IfStatementListener ) ((IfStatementListener)listener).exitPRINTDOUBLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IfStatementVisitor ) return ((IfStatementVisitor<? extends T>)visitor).visitPRINTDOUBLE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstmtContext printstmt() throws RecognitionException {
		PrintstmtContext _localctx = new PrintstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_printstmt);
		try {
			_localctx = new PRINTDOUBLEContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(PRINT);
			setState(139);
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
		case 5:
			return conditiongroup_sempred((ConditiongroupContext)_localctx, predIndex);
		case 7:
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
		"\u0004\u0001\u001b\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005"+
		"\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\'\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00027\b\u0002\n\u0002"+
		"\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005Q\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005W\b"+
		"\u0005\n\u0005\f\u0005Z\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006d\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007p\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007z\b\u0007\n\u0007\f\u0007}\t"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0000\u0002\n\u000e\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0004\u0001\u0000\u0006"+
		"\u0007\u0001\u0000\b\n\u0001\u0000\u000b\u0010\u0001\u0000\u0011\u0012"+
		"\u008d\u0000&\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004"+
		"2\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000\u0000\bB\u0001\u0000"+
		"\u0000\u0000\nP\u0001\u0000\u0000\u0000\fc\u0001\u0000\u0000\u0000\u000e"+
		"o\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0080\u0001"+
		"\u0000\u0000\u0000\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0084\u0001"+
		"\u0000\u0000\u0000\u0018\u0086\u0001\u0000\u0000\u0000\u001a\u0088\u0001"+
		"\u0000\u0000\u0000\u001c\u008a\u0001\u0000\u0000\u0000\u001e \u0003\u0002"+
		"\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$\'\u0003\u0004\u0002\u0000%\'\u0001"+
		"\u0000\u0000\u0000&!\u0001\u0000\u0000\u0000&%\u0001\u0000\u0000\u0000"+
		"\'\u0001\u0001\u0000\u0000\u0000()\u0005\u0001\u0000\u0000)*\u0005\u001a"+
		"\u0000\u0000*+\u0005\u0002\u0000\u0000+1\u0003\u000e\u0007\u0000,-\u0005"+
		"\u0001\u0000\u0000-.\u0005\u001a\u0000\u0000./\u0005\u0002\u0000\u0000"+
		"/1\u0003\n\u0005\u00000(\u0001\u0000\u0000\u00000,\u0001\u0000\u0000\u0000"+
		"1\u0003\u0001\u0000\u0000\u000023\u0005\u0013\u0000\u000034\u0003\n\u0005"+
		"\u000048\u0003\u001c\u000e\u000057\u0003\u0006\u0003\u000065\u0001\u0000"+
		"\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		";<\u0003\b\u0004\u0000<=\u0005\u0016\u0000\u0000=\u0005\u0001\u0000\u0000"+
		"\u0000>?\u0005\u0015\u0000\u0000?@\u0003\n\u0005\u0000@A\u0003\u001c\u000e"+
		"\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0005\u0014\u0000\u0000CD\u0003"+
		"\u001c\u000e\u0000D\t\u0001\u0000\u0000\u0000EF\u0006\u0005\uffff\uffff"+
		"\u0000FG\u0003\u0010\b\u0000GH\u0003\n\u0005\u0006HQ\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0003\u0000\u0000JK\u0003\n\u0005\u0000KL\u0005\u0004\u0000"+
		"\u0000LQ\u0001\u0000\u0000\u0000MQ\u0003\f\u0006\u0000NQ\u0005\u0018\u0000"+
		"\u0000OQ\u0005\u001a\u0000\u0000PE\u0001\u0000\u0000\u0000PI\u0001\u0000"+
		"\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000QX\u0001\u0000\u0000\u0000RS\n\u0005\u0000\u0000ST\u0003"+
		"\u001a\r\u0000TU\u0003\n\u0005\u0006UW\u0001\u0000\u0000\u0000VR\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000[\\\u0003\u000e\u0007\u0000\\]\u0003\u0018\f\u0000]^\u0003"+
		"\u000e\u0007\u0000^d\u0001\u0000\u0000\u0000_`\u0005\u0003\u0000\u0000"+
		"`a\u0003\f\u0006\u0000ab\u0005\u0004\u0000\u0000bd\u0001\u0000\u0000\u0000"+
		"c[\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000d\r\u0001\u0000\u0000"+
		"\u0000ef\u0006\u0007\uffff\uffff\u0000fg\u0003\u0012\t\u0000gh\u0003\u000e"+
		"\u0007\u0006hp\u0001\u0000\u0000\u0000ij\u0005\u0003\u0000\u0000jk\u0003"+
		"\u000e\u0007\u0000kl\u0005\u0004\u0000\u0000lp\u0001\u0000\u0000\u0000"+
		"mp\u0005\u0019\u0000\u0000np\u0005\u001a\u0000\u0000oe\u0001\u0000\u0000"+
		"\u0000oi\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000p{\u0001\u0000\u0000\u0000qr\n\u0005\u0000\u0000rs\u0003\u0016"+
		"\u000b\u0000st\u0003\u000e\u0007\u0006tz\u0001\u0000\u0000\u0000uv\n\u0004"+
		"\u0000\u0000vw\u0003\u0014\n\u0000wx\u0003\u000e\u0007\u0005xz\u0001\u0000"+
		"\u0000\u0000yq\u0001\u0000\u0000\u0000yu\u0001\u0000\u0000\u0000z}\u0001"+
		"\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|\u000f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0005\u0000\u0000\u007f\u0011\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		"\u0006\u0000\u0000\u0081\u0013\u0001\u0000\u0000\u0000\u0082\u0083\u0007"+
		"\u0000\u0000\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0085\u0007"+
		"\u0001\u0000\u0000\u0085\u0017\u0001\u0000\u0000\u0000\u0086\u0087\u0007"+
		"\u0002\u0000\u0000\u0087\u0019\u0001\u0000\u0000\u0000\u0088\u0089\u0007"+
		"\u0003\u0000\u0000\u0089\u001b\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\u0017\u0000\u0000\u008b\u008c\u0005\u0019\u0000\u0000\u008c\u001d\u0001"+
		"\u0000\u0000\u0000\n!&08PXcoy{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}