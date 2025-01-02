// Generated from IfStatement.g4 by ANTLR 4.13.1
package com.nice.antlr.ifstatement.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ConditionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, DOUBLE=19, Identifier=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "DOUBLE", "Identifier", "WS"
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


	public ConditionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IfStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015r\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012Y\b"+
		"\u0012\u000b\u0012\f\u0012Z\u0001\u0012\u0001\u0012\u0004\u0012_\b\u0012"+
		"\u000b\u0012\f\u0012`\u0003\u0012c\b\u0012\u0001\u0013\u0001\u0013\u0005"+
		"\u0013g\b\u0013\n\u0013\f\u0013j\t\u0013\u0001\u0014\u0004\u0014m\b\u0014"+
		"\u000b\u0014\f\u0014n\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000\u0003"+
		"\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  v\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001"+
		"\u0000\u0000\u0000\u0003/\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000"+
		"\u0000\u00073\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b"+
		"7\u0001\u0000\u0000\u0000\r9\u0001\u0000\u0000\u0000\u000f;\u0001\u0000"+
		"\u0000\u0000\u0011=\u0001\u0000\u0000\u0000\u0013?\u0001\u0000\u0000\u0000"+
		"\u0015A\u0001\u0000\u0000\u0000\u0017D\u0001\u0000\u0000\u0000\u0019G"+
		"\u0001\u0000\u0000\u0000\u001bI\u0001\u0000\u0000\u0000\u001dK\u0001\u0000"+
		"\u0000\u0000\u001fN\u0001\u0000\u0000\u0000!Q\u0001\u0000\u0000\u0000"+
		"#T\u0001\u0000\u0000\u0000%X\u0001\u0000\u0000\u0000\'d\u0001\u0000\u0000"+
		"\u0000)l\u0001\u0000\u0000\u0000+,\u0005s\u0000\u0000,-\u0005e\u0000\u0000"+
		"-.\u0005t\u0000\u0000.\u0002\u0001\u0000\u0000\u0000/0\u0005=\u0000\u0000"+
		"0\u0004\u0001\u0000\u0000\u000012\u0005(\u0000\u00002\u0006\u0001\u0000"+
		"\u0000\u000034\u0005)\u0000\u00004\b\u0001\u0000\u0000\u000056\u0005!"+
		"\u0000\u00006\n\u0001\u0000\u0000\u000078\u0005-\u0000\u00008\f\u0001"+
		"\u0000\u0000\u00009:\u0005+\u0000\u0000:\u000e\u0001\u0000\u0000\u0000"+
		";<\u0005*\u0000\u0000<\u0010\u0001\u0000\u0000\u0000=>\u0005/\u0000\u0000"+
		">\u0012\u0001\u0000\u0000\u0000?@\u0005%\u0000\u0000@\u0014\u0001\u0000"+
		"\u0000\u0000AB\u0005=\u0000\u0000BC\u0005=\u0000\u0000C\u0016\u0001\u0000"+
		"\u0000\u0000DE\u0005!\u0000\u0000EF\u0005=\u0000\u0000F\u0018\u0001\u0000"+
		"\u0000\u0000GH\u0005>\u0000\u0000H\u001a\u0001\u0000\u0000\u0000IJ\u0005"+
		"<\u0000\u0000J\u001c\u0001\u0000\u0000\u0000KL\u0005>\u0000\u0000LM\u0005"+
		"=\u0000\u0000M\u001e\u0001\u0000\u0000\u0000NO\u0005<\u0000\u0000OP\u0005"+
		"=\u0000\u0000P \u0001\u0000\u0000\u0000QR\u0005|\u0000\u0000RS\u0005|"+
		"\u0000\u0000S\"\u0001\u0000\u0000\u0000TU\u0005&\u0000\u0000UV\u0005&"+
		"\u0000\u0000V$\u0001\u0000\u0000\u0000WY\u000209\u0000XW\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[b\u0001\u0000\u0000\u0000\\^\u0005.\u0000\u0000]_\u00020"+
		"9\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000b\\\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c&\u0001\u0000\u0000\u0000"+
		"dh\u0007\u0000\u0000\u0000eg\u0007\u0001\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000i(\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000km\u0007"+
		"\u0002\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000pq\u0006\u0014\u0000\u0000q*\u0001\u0000\u0000\u0000\u0006\u0000"+
		"Z`bhn\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}