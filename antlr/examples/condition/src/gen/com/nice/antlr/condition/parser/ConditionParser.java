// Generated from Condition.g4 by ANTLR 4.13.1
package com.nice.antlr.condition.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ConditionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, DOUBLE=19, Identifier=20, WS=21;
	public static final int
		RULE_start = 0, RULE_setdouble = 1, RULE_conditiongroup = 2, RULE_condition = 3, 
		RULE_expr = 4, RULE_binarysign = 5, RULE_arithmeticsign = 6, RULE_addop = 7, 
		RULE_mulop = 8, RULE_relop = 9, RULE_logicalop = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "setdouble", "conditiongroup", "condition", "expr", "binarysign", 
			"arithmeticsign", "addop", "mulop", "relop", "logicalop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'set'", "'='", "'('", "')'", "'!'", "'-'", "'+'", "'*'", "'/'", 
			"'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'||'", "'&&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "DOUBLE", "Identifier", "WS"
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
	public String getGrammarFileName() { return "Condition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConditionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public List<SetdoubleContext> setdouble() {
			return getRuleContexts(SetdoubleContext.class);
		}
		public SetdoubleContext setdouble(int i) {
			return getRuleContext(SetdoubleContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__4:
			case T__5:
			case DOUBLE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(22);
					setdouble();
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(28);
				conditiongroup(0);
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
	public static class SetdoubleContext extends ParserRuleContext {
		public SetdoubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setdouble; }
	 
		public SetdoubleContext() { }
		public void copyFrom(SetdoubleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ASSSIGNMENTContext extends SetdoubleContext {
		public TerminalNode Identifier() { return getToken(ConditionParser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConditiongroupContext conditiongroup() {
			return getRuleContext(ConditiongroupContext.class,0);
		}
		public ASSSIGNMENTContext(SetdoubleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterASSSIGNMENT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitASSSIGNMENT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitASSSIGNMENT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetdoubleContext setdouble() throws RecognitionException {
		SetdoubleContext _localctx = new SetdoubleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setdouble);
		try {
			_localctx = new ASSSIGNMENTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(Identifier);
			setState(34);
			match(T__1);
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(35);
				expr(0);
				}
				break;
			case 2:
				{
				setState(36);
				conditiongroup(0);
				}
				break;
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterLOGICALGRPT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitLOGICALGRPT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitLOGICALGRPT(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARIABLEGRPContext extends ConditiongroupContext {
		public TerminalNode Identifier() { return getToken(ConditionParser.Identifier, 0); }
		public VARIABLEGRPContext(ConditiongroupContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterVARIABLEGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitVARIABLEGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitVARIABLEGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterCONDITIONGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitCONDITIONGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitCONDITIONGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterBINARYGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitBINARYGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitBINARYGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterCONDITIONGRPT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitCONDITIONGRPT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitCONDITIONGRPT(this);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_conditiongroup, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new BINARYGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(40);
				binarysign();
				setState(41);
				conditiongroup(5);
				}
				break;
			case 2:
				{
				_localctx = new CONDITIONGRPTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(T__2);
				setState(44);
				conditiongroup(0);
				setState(45);
				match(T__3);
				}
				break;
			case 3:
				{
				_localctx = new CONDITIONGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				condition();
				}
				break;
			case 4:
				{
				_localctx = new VARIABLEGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(Identifier);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOGICALGRPTContext(new ConditiongroupContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditiongroup);
					setState(51);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(52);
					logicalop();
					setState(53);
					conditiongroup(5);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterRELOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitRELOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitRELOPGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterCNDPARENGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitCNDPARENGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitCNDPARENGRP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new RELOPGRPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				expr(0);
				setState(61);
				relop();
				setState(62);
				expr(0);
				}
				break;
			case 2:
				_localctx = new CNDPARENGRPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__2);
				setState(65);
				condition();
				setState(66);
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
		public TerminalNode Identifier() { return getToken(ConditionParser.Identifier, 0); }
		public VARIABLEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterVARIABLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitVARIABLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitVARIABLE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DOUBLEContext extends ExprContext {
		public TerminalNode DOUBLE() { return getToken(ConditionParser.DOUBLE, 0); }
		public DOUBLEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterDOUBLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitDOUBLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitDOUBLE(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterMULOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitMULOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitMULOPGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterSIGNGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitSIGNGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitSIGNGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterEXPPARENGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitEXPPARENGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitEXPPARENGRP(this);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterADDOPGRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitADDOPGRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitADDOPGRP(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				_localctx = new SIGNGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				arithmeticsign();
				setState(72);
				expr(6);
				}
				break;
			case T__2:
				{
				_localctx = new EXPPARENGRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(T__2);
				setState(75);
				expr(0);
				setState(76);
				match(T__3);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DOUBLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(DOUBLE);
				}
				break;
			case Identifier:
				{
				_localctx = new VARIABLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(90);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MULOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83);
						mulop();
						setState(84);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ADDOPGRPContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(87);
						addop();
						setState(88);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterBinarysign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitBinarysign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitBinarysign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinarysignContext binarysign() throws RecognitionException {
		BinarysignContext _localctx = new BinarysignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binarysign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterArithmeticsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitArithmeticsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitArithmeticsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticsignContext arithmeticsign() throws RecognitionException {
		ArithmeticsignContext _localctx = new ArithmeticsignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arithmeticsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitAddop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitAddop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitMulop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitMulop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
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
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).enterLogicalop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionListener ) ((ConditionListener)listener).exitLogicalop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionVisitor ) return ((ConditionVisitor<? extends T>)visitor).visitLogicalop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalopContext logicalop() throws RecognitionException {
		LogicalopContext _localctx = new LogicalopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logicalop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return conditiongroup_sempred((ConditiongroupContext)_localctx, predIndex);
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditiongroup_sempred(ConditiongroupContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
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
		"\u0004\u0001\u0015l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018"+
		"\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"\u001f\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00022\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u00028\b\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003E\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004Q\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004[\b\u0004"+
		"\n\u0004\f\u0004^\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0000\u0002\u0004\b\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0004\u0001\u0000\u0006\u0007\u0001\u0000\b\n"+
		"\u0001\u0000\u000b\u0010\u0001\u0000\u0011\u0012m\u0000\u001e\u0001\u0000"+
		"\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000"+
		"\u0006D\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\n_\u0001\u0000"+
		"\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000"+
		"\u0010e\u0001\u0000\u0000\u0000\u0012g\u0001\u0000\u0000\u0000\u0014i"+
		"\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001f"+
		"\u0003\u0004\u0002\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u0019"+
		"\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\u0001"+
		"\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000\u0000!\"\u0005\u0014\u0000"+
		"\u0000\"%\u0005\u0002\u0000\u0000#&\u0003\b\u0004\u0000$&\u0003\u0004"+
		"\u0002\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000&\u0003"+
		"\u0001\u0000\u0000\u0000\'(\u0006\u0002\uffff\uffff\u0000()\u0003\n\u0005"+
		"\u0000)*\u0003\u0004\u0002\u0005*2\u0001\u0000\u0000\u0000+,\u0005\u0003"+
		"\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0005\u0004\u0000\u0000.2\u0001"+
		"\u0000\u0000\u0000/2\u0003\u0006\u0003\u000002\u0005\u0014\u0000\u0000"+
		"1\'\u0001\u0000\u0000\u00001+\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000010\u0001\u0000\u0000\u000029\u0001\u0000\u0000\u000034\n\u0004\u0000"+
		"\u000045\u0003\u0014\n\u000056\u0003\u0004\u0002\u000568\u0001\u0000\u0000"+
		"\u000073\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:\u0005\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000<=\u0003\b\u0004\u0000=>\u0003\u0012\t\u0000"+
		">?\u0003\b\u0004\u0000?E\u0001\u0000\u0000\u0000@A\u0005\u0003\u0000\u0000"+
		"AB\u0003\u0006\u0003\u0000BC\u0005\u0004\u0000\u0000CE\u0001\u0000\u0000"+
		"\u0000D<\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000E\u0007\u0001"+
		"\u0000\u0000\u0000FG\u0006\u0004\uffff\uffff\u0000GH\u0003\f\u0006\u0000"+
		"HI\u0003\b\u0004\u0006IQ\u0001\u0000\u0000\u0000JK\u0005\u0003\u0000\u0000"+
		"KL\u0003\b\u0004\u0000LM\u0005\u0004\u0000\u0000MQ\u0001\u0000\u0000\u0000"+
		"NQ\u0005\u0013\u0000\u0000OQ\u0005\u0014\u0000\u0000PF\u0001\u0000\u0000"+
		"\u0000PJ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000"+
		"\u0000\u0000Q\\\u0001\u0000\u0000\u0000RS\n\u0005\u0000\u0000ST\u0003"+
		"\u0010\b\u0000TU\u0003\b\u0004\u0006U[\u0001\u0000\u0000\u0000VW\n\u0004"+
		"\u0000\u0000WX\u0003\u000e\u0007\u0000XY\u0003\b\u0004\u0005Y[\u0001\u0000"+
		"\u0000\u0000ZR\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000[^\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]\t\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_`\u0005\u0005\u0000"+
		"\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0005\u0006\u0000\u0000b\r\u0001"+
		"\u0000\u0000\u0000cd\u0007\u0000\u0000\u0000d\u000f\u0001\u0000\u0000"+
		"\u0000ef\u0007\u0001\u0000\u0000f\u0011\u0001\u0000\u0000\u0000gh\u0007"+
		"\u0002\u0000\u0000h\u0013\u0001\u0000\u0000\u0000ij\u0007\u0003\u0000"+
		"\u0000j\u0015\u0001\u0000\u0000\u0000\t\u0019\u001e%19DPZ\\";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}