// Generated from DistributionRules.g4 by ANTLR 4.13.1
package com.nice.dcm.distribution.rule.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DistributionRulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LESS_THAN=11, LESS_THAN_EQUAL=12, EQUAL=13, NOT_EQUAL=14, GREATER_THAN=15, 
		GREATER_THAN_EQUAL=16, NE1=17, NE2=18, IN=19, NOT_IN=20, LEAST_BUSY_OF=21, 
		QUEUE_TO=22, NUMBER=23, UUID_OR_HEXA=24, WHITESPACE=25;
	public static final int
		RULE_start = 0, RULE_execution = 1, RULE_routingRuleSet = 2, RULE_routingWaitingRuleGroup = 3, 
		RULE_routingRuleGroup = 4, RULE_routingRule = 5, RULE_ruleAction = 6, 
		RULE_orSkills = 7, RULE_skillOrSet = 8, RULE_skillSet = 9, RULE_skill = 10, 
		RULE_levelCondition = 11, RULE_binaryOperator = 12, RULE_sqlOperator = 13, 
		RULE_entity_identifier = 14, RULE_priority = 15, RULE_waitRule = 16, RULE_queue_status = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "execution", "routingRuleSet", "routingWaitingRuleGroup", "routingRuleGroup", 
			"routingRule", "ruleAction", "orSkills", "skillOrSet", "skillSet", "skill", 
			"levelCondition", "binaryOperator", "sqlOperator", "entity_identifier", 
			"priority", "waitRule", "queue_status"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'('", "','", "')'", "'@S:'", "'level'", "'..'", "'with'", 
			"'priority'", "'wait'", "'<'", "'<='", "'='", null, "'>'", "'>='", "'!='", 
			"'<>'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "LESS_THAN", 
			"LESS_THAN_EQUAL", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_THAN_EQUAL", 
			"NE1", "NE2", "IN", "NOT_IN", "LEAST_BUSY_OF", "QUEUE_TO", "NUMBER", 
			"UUID_OR_HEXA", "WHITESPACE"
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
	public String getGrammarFileName() { return "DistributionRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DistributionRulesParser(TokenStream input) {
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
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUEUE_TO:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
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
		public RoutingRuleSetContext routingRuleSet() {
			return getRuleContext(RoutingRuleSetContext.class,0);
		}
		public ExecutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitExecution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitExecution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutionContext execution() throws RecognitionException {
		ExecutionContext _localctx = new ExecutionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_execution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			routingRuleSet();
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
	public static class RoutingRuleSetContext extends ParserRuleContext {
		public RoutingRuleGroupContext routingRuleGroup() {
			return getRuleContext(RoutingRuleGroupContext.class,0);
		}
		public List<RoutingWaitingRuleGroupContext> routingWaitingRuleGroup() {
			return getRuleContexts(RoutingWaitingRuleGroupContext.class);
		}
		public RoutingWaitingRuleGroupContext routingWaitingRuleGroup(int i) {
			return getRuleContext(RoutingWaitingRuleGroupContext.class,i);
		}
		public RoutingRuleSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routingRuleSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterRoutingRuleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitRoutingRuleSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitRoutingRuleSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutingRuleSetContext routingRuleSet() throws RecognitionException {
		RoutingRuleSetContext _localctx = new RoutingRuleSetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_routingRuleSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			routingRuleGroup();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(43);
				routingWaitingRuleGroup();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class RoutingWaitingRuleGroupContext extends ParserRuleContext {
		public WaitRuleContext waitRule() {
			return getRuleContext(WaitRuleContext.class,0);
		}
		public RoutingRuleGroupContext routingRuleGroup() {
			return getRuleContext(RoutingRuleGroupContext.class,0);
		}
		public RoutingWaitingRuleGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routingWaitingRuleGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterRoutingWaitingRuleGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitRoutingWaitingRuleGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitRoutingWaitingRuleGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutingWaitingRuleGroupContext routingWaitingRuleGroup() throws RecognitionException {
		RoutingWaitingRuleGroupContext _localctx = new RoutingWaitingRuleGroupContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_routingWaitingRuleGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			waitRule();
			setState(50);
			routingRuleGroup();
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
	public static class RoutingRuleGroupContext extends ParserRuleContext {
		public List<RoutingRuleContext> routingRule() {
			return getRuleContexts(RoutingRuleContext.class);
		}
		public RoutingRuleContext routingRule(int i) {
			return getRuleContext(RoutingRuleContext.class,i);
		}
		public RoutingRuleGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routingRuleGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterRoutingRuleGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitRoutingRuleGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitRoutingRuleGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutingRuleGroupContext routingRuleGroup() throws RecognitionException {
		RoutingRuleGroupContext _localctx = new RoutingRuleGroupContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_routingRuleGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				routingRule();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUEUE_TO );
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
	public static class RoutingRuleContext extends ParserRuleContext {
		public RuleActionContext ruleAction() {
			return getRuleContext(RuleActionContext.class,0);
		}
		public OrSkillsContext orSkills() {
			return getRuleContext(OrSkillsContext.class,0);
		}
		public PriorityContext priority() {
			return getRuleContext(PriorityContext.class,0);
		}
		public Queue_statusContext queue_status() {
			return getRuleContext(Queue_statusContext.class,0);
		}
		public RoutingRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routingRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterRoutingRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitRoutingRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitRoutingRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutingRuleContext routingRule() throws RecognitionException {
		RoutingRuleContext _localctx = new RoutingRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_routingRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			ruleAction();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEAST_BUSY_OF) {
				{
				setState(58);
				queue_status();
				}
			}

			setState(61);
			orSkills();
			setState(62);
			priority();
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
	public static class RuleActionContext extends ParserRuleContext {
		public RuleActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleAction; }
	 
		public RuleActionContext() { }
		public void copyFrom(RuleActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ACTQUEUETOContext extends RuleActionContext {
		public TerminalNode QUEUE_TO() { return getToken(DistributionRulesParser.QUEUE_TO, 0); }
		public ACTQUEUETOContext(RuleActionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterACTQUEUETO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitACTQUEUETO(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitACTQUEUETO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleActionContext ruleAction() throws RecognitionException {
		RuleActionContext _localctx = new RuleActionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ruleAction);
		try {
			_localctx = new ACTQUEUETOContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(QUEUE_TO);
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
	public static class OrSkillsContext extends ParserRuleContext {
		public OrSkillsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orSkills; }
	 
		public OrSkillsContext() { }
		public void copyFrom(OrSkillsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SKILLSETORContext extends OrSkillsContext {
		public List<SkillOrSetContext> skillOrSet() {
			return getRuleContexts(SkillOrSetContext.class);
		}
		public SkillOrSetContext skillOrSet(int i) {
			return getRuleContext(SkillOrSetContext.class,i);
		}
		public SKILLSETORContext(OrSkillsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterSKILLSETOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitSKILLSETOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitSKILLSETOR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrSkillsContext orSkills() throws RecognitionException {
		OrSkillsContext _localctx = new OrSkillsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_orSkills);
		int _la;
		try {
			_localctx = new SKILLSETORContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			skillOrSet();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(67);
				match(T__0);
				setState(68);
				skillOrSet();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class SkillOrSetContext extends ParserRuleContext {
		public SkillOrSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillOrSet; }
	 
		public SkillOrSetContext() { }
		public void copyFrom(SkillOrSetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ORSKILLContext extends SkillOrSetContext {
		public SkillContext skill() {
			return getRuleContext(SkillContext.class,0);
		}
		public ORSKILLContext(SkillOrSetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterORSKILL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitORSKILL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitORSKILL(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ORSKILLSETContext extends SkillOrSetContext {
		public SkillSetContext skillSet() {
			return getRuleContext(SkillSetContext.class,0);
		}
		public ORSKILLSETContext(SkillOrSetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterORSKILLSET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitORSKILLSET(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitORSKILLSET(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillOrSetContext skillOrSet() throws RecognitionException {
		SkillOrSetContext _localctx = new SkillOrSetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_skillOrSet);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new ORSKILLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				skill();
				}
				break;
			case T__1:
				_localctx = new ORSKILLSETContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				skillSet();
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
	public static class SkillSetContext extends ParserRuleContext {
		public SkillSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillSet; }
	 
		public SkillSetContext() { }
		public void copyFrom(SkillSetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SKILLANDSETContext extends SkillSetContext {
		public List<SkillContext> skill() {
			return getRuleContexts(SkillContext.class);
		}
		public SkillContext skill(int i) {
			return getRuleContext(SkillContext.class,i);
		}
		public SKILLANDSETContext(SkillSetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterSKILLANDSET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitSKILLANDSET(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitSKILLANDSET(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillSetContext skillSet() throws RecognitionException {
		SkillSetContext _localctx = new SkillSetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_skillSet);
		int _la;
		try {
			_localctx = new SKILLANDSETContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__1);
			setState(79);
			skill();
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				match(T__2);
				setState(81);
				skill();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(86);
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
	public static class SkillContext extends ParserRuleContext {
		public SkillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skill; }
	 
		public SkillContext() { }
		public void copyFrom(SkillContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SKILLCONDITIONContext extends SkillContext {
		public Entity_identifierContext entity_identifier() {
			return getRuleContext(Entity_identifierContext.class,0);
		}
		public LevelConditionContext levelCondition() {
			return getRuleContext(LevelConditionContext.class,0);
		}
		public SKILLCONDITIONContext(SkillContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterSKILLCONDITION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitSKILLCONDITION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitSKILLCONDITION(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillContext skill() throws RecognitionException {
		SkillContext _localctx = new SkillContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_skill);
		int _la;
		try {
			_localctx = new SKILLCONDITIONContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__4);
			setState(89);
			entity_identifier();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(90);
				levelCondition();
				}
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
	public static class LevelConditionContext extends ParserRuleContext {
		public LevelConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_levelCondition; }
	 
		public LevelConditionContext() { }
		public void copyFrom(LevelConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SQLOPContext extends LevelConditionContext {
		public SqlOperatorContext sqlOperator() {
			return getRuleContext(SqlOperatorContext.class,0);
		}
		public List<TerminalNode> NUMBER() { return getTokens(DistributionRulesParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(DistributionRulesParser.NUMBER, i);
		}
		public SQLOPContext(LevelConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterSQLOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitSQLOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitSQLOP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BINARYOPContext extends LevelConditionContext {
		public BinaryOperatorContext binaryOperator() {
			return getRuleContext(BinaryOperatorContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(DistributionRulesParser.NUMBER, 0); }
		public BINARYOPContext(LevelConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterBINARYOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitBINARYOP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitBINARYOP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelConditionContext levelCondition() throws RecognitionException {
		LevelConditionContext _localctx = new LevelConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_levelCondition);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new BINARYOPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__5);
				setState(94);
				binaryOperator();
				setState(95);
				match(NUMBER);
				}
				break;
			case 2:
				_localctx = new SQLOPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__5);
				setState(98);
				sqlOperator();
				setState(99);
				match(NUMBER);
				setState(100);
				match(T__6);
				setState(101);
				match(NUMBER);
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
	public static class BinaryOperatorContext extends ParserRuleContext {
		public TerminalNode LESS_THAN() { return getToken(DistributionRulesParser.LESS_THAN, 0); }
		public TerminalNode LESS_THAN_EQUAL() { return getToken(DistributionRulesParser.LESS_THAN_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(DistributionRulesParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(DistributionRulesParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(DistributionRulesParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_THAN_EQUAL() { return getToken(DistributionRulesParser.GREATER_THAN_EQUAL, 0); }
		public BinaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterBinaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitBinaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitBinaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperatorContext binaryOperator() throws RecognitionException {
		BinaryOperatorContext _localctx = new BinaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_binaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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
	public static class SqlOperatorContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(DistributionRulesParser.IN, 0); }
		public TerminalNode NOT_IN() { return getToken(DistributionRulesParser.NOT_IN, 0); }
		public SqlOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterSqlOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitSqlOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitSqlOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlOperatorContext sqlOperator() throws RecognitionException {
		SqlOperatorContext _localctx = new SqlOperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sqlOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==NOT_IN) ) {
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
	public static class Entity_identifierContext extends ParserRuleContext {
		public Entity_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_identifier; }
	 
		public Entity_identifierContext() { }
		public void copyFrom(Entity_identifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OIDHEXContext extends Entity_identifierContext {
		public TerminalNode UUID_OR_HEXA() { return getToken(DistributionRulesParser.UUID_OR_HEXA, 0); }
		public OIDHEXContext(Entity_identifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterOIDHEX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitOIDHEX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitOIDHEX(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OIDNUMBERContext extends Entity_identifierContext {
		public TerminalNode NUMBER() { return getToken(DistributionRulesParser.NUMBER, 0); }
		public OIDNUMBERContext(Entity_identifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterOIDNUMBER(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitOIDNUMBER(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitOIDNUMBER(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_identifierContext entity_identifier() throws RecognitionException {
		Entity_identifierContext _localctx = new Entity_identifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_entity_identifier);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UUID_OR_HEXA:
				_localctx = new OIDHEXContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(UUID_OR_HEXA);
				}
				break;
			case NUMBER:
				_localctx = new OIDNUMBERContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(NUMBER);
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
	public static class PriorityContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DistributionRulesParser.NUMBER, 0); }
		public PriorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterPriority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitPriority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitPriority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PriorityContext priority() throws RecognitionException {
		PriorityContext _localctx = new PriorityContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_priority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__7);
			setState(114);
			match(T__8);
			setState(115);
			match(NUMBER);
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
	public static class WaitRuleContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DistributionRulesParser.NUMBER, 0); }
		public WaitRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_waitRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterWaitRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitWaitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitWaitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WaitRuleContext waitRule() throws RecognitionException {
		WaitRuleContext _localctx = new WaitRuleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_waitRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__9);
			setState(118);
			match(NUMBER);
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
	public static class Queue_statusContext extends ParserRuleContext {
		public Queue_statusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queue_status; }
	 
		public Queue_statusContext() { }
		public void copyFrom(Queue_statusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QSLEASTBUSYOFContext extends Queue_statusContext {
		public TerminalNode LEAST_BUSY_OF() { return getToken(DistributionRulesParser.LEAST_BUSY_OF, 0); }
		public QSLEASTBUSYOFContext(Queue_statusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).enterQSLEASTBUSYOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DistributionRulesListener ) ((DistributionRulesListener)listener).exitQSLEASTBUSYOF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DistributionRulesVisitor ) return ((DistributionRulesVisitor<? extends T>)visitor).visitQSLEASTBUSYOF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Queue_statusContext queue_status() throws RecognitionException {
		Queue_statusContext _localctx = new Queue_statusContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_queue_status);
		try {
			_localctx = new QSLEASTBUSYOFContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LEAST_BUSY_OF);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0019{\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\'\b\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0005\u0002-\b\u0002\n\u0002\f\u00020\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0004\u00046\b\u0004\u000b\u0004\f\u00047\u0001"+
		"\u0005\u0001\u0005\u0003\u0005<\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007F\b\u0007\n\u0007\f\u0007I\t\u0007\u0001\b\u0001\b\u0003\bM\b\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tS\b\t\u000b\t\f\tT\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0003\n\\\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000bh\b\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0003\u000ep\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0002"+
		"\u0001\u0000\u000b\u0010\u0001\u0000\u0013\u0014r\u0000&\u0001\u0000\u0000"+
		"\u0000\u0002(\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006"+
		"1\u0001\u0000\u0000\u0000\b5\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000"+
		"\u0000\f@\u0001\u0000\u0000\u0000\u000eB\u0001\u0000\u0000\u0000\u0010"+
		"L\u0001\u0000\u0000\u0000\u0012N\u0001\u0000\u0000\u0000\u0014X\u0001"+
		"\u0000\u0000\u0000\u0016g\u0001\u0000\u0000\u0000\u0018i\u0001\u0000\u0000"+
		"\u0000\u001ak\u0001\u0000\u0000\u0000\u001co\u0001\u0000\u0000\u0000\u001e"+
		"q\u0001\u0000\u0000\u0000 u\u0001\u0000\u0000\u0000\"x\u0001\u0000\u0000"+
		"\u0000$\'\u0003\u0002\u0001\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&%\u0001\u0000\u0000\u0000\'\u0001\u0001\u0000\u0000\u0000"+
		"()\u0003\u0004\u0002\u0000)\u0003\u0001\u0000\u0000\u0000*.\u0003\b\u0004"+
		"\u0000+-\u0003\u0006\u0003\u0000,+\u0001\u0000\u0000\u0000-0\u0001\u0000"+
		"\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0005"+
		"\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000012\u0003 \u0010\u0000"+
		"23\u0003\b\u0004\u00003\u0007\u0001\u0000\u0000\u000046\u0003\n\u0005"+
		"\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u00008\t\u0001\u0000\u0000\u00009;\u0003"+
		"\f\u0006\u0000:<\u0003\"\u0011\u0000;:\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0003\u000e\u0007\u0000"+
		">?\u0003\u001e\u000f\u0000?\u000b\u0001\u0000\u0000\u0000@A\u0005\u0016"+
		"\u0000\u0000A\r\u0001\u0000\u0000\u0000BG\u0003\u0010\b\u0000CD\u0005"+
		"\u0001\u0000\u0000DF\u0003\u0010\b\u0000EC\u0001\u0000\u0000\u0000FI\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"H\u000f\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JM\u0003\u0014"+
		"\n\u0000KM\u0003\u0012\t\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000"+
		"\u0000\u0000M\u0011\u0001\u0000\u0000\u0000NO\u0005\u0002\u0000\u0000"+
		"OR\u0003\u0014\n\u0000PQ\u0005\u0003\u0000\u0000QS\u0003\u0014\n\u0000"+
		"RP\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005\u0004"+
		"\u0000\u0000W\u0013\u0001\u0000\u0000\u0000XY\u0005\u0005\u0000\u0000"+
		"Y[\u0003\u001c\u000e\u0000Z\\\u0003\u0016\u000b\u0000[Z\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\\u0015\u0001\u0000\u0000\u0000]^\u0005"+
		"\u0006\u0000\u0000^_\u0003\u0018\f\u0000_`\u0005\u0017\u0000\u0000`h\u0001"+
		"\u0000\u0000\u0000ab\u0005\u0006\u0000\u0000bc\u0003\u001a\r\u0000cd\u0005"+
		"\u0017\u0000\u0000de\u0005\u0007\u0000\u0000ef\u0005\u0017\u0000\u0000"+
		"fh\u0001\u0000\u0000\u0000g]\u0001\u0000\u0000\u0000ga\u0001\u0000\u0000"+
		"\u0000h\u0017\u0001\u0000\u0000\u0000ij\u0007\u0000\u0000\u0000j\u0019"+
		"\u0001\u0000\u0000\u0000kl\u0007\u0001\u0000\u0000l\u001b\u0001\u0000"+
		"\u0000\u0000mp\u0005\u0018\u0000\u0000np\u0005\u0017\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\u001d\u0001\u0000\u0000"+
		"\u0000qr\u0005\b\u0000\u0000rs\u0005\t\u0000\u0000st\u0005\u0017\u0000"+
		"\u0000t\u001f\u0001\u0000\u0000\u0000uv\u0005\n\u0000\u0000vw\u0005\u0017"+
		"\u0000\u0000w!\u0001\u0000\u0000\u0000xy\u0005\u0015\u0000\u0000y#\u0001"+
		"\u0000\u0000\u0000\n&.7;GLT[go";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}