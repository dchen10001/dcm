package com.nice.dcm.distribution.rule.parser;

import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.distribution.rule.parser.listener.DistributionRulesListenerImpl;
import com.nice.dcm.distribution.rule.parser.listener.ThrowingErrorListener;
import com.nice.dcm.distribution.rule.parser.node.RoutingRuleSetNodeImpl;
import com.nice.dcm.simulation.distribution.rule.RoutingRuleSet;

public class RuleParserHelper {
	private static final Logger logger = LoggerFactory.getLogger(RuleParserHelper.class);
	
    private ThrowingErrorListener errorListener = new ThrowingErrorListener();

    public RoutingRuleSet visitRoutingRuleSet(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	RoutingRuleSetNodeImpl ruleSetNode = (RoutingRuleSetNodeImpl)parser.routingRuleSet().accept(dcmRuleVisitor);    
    	return ruleSetNode.getRoutingRuleSet();
    }

    protected DistributionRulesParser parserScript(String script) {
    	logger.debug("Parsing script: {}", script);
    	DistributionRulesLexer tokenSource = new DistributionRulesLexer(CharStreams.fromString(script));
    	tokenSource.removeErrorListeners();
    	tokenSource.addErrorListener(errorListener);
        CommonTokenStream tokens = new CommonTokenStream(tokenSource);
        
        DistributionRulesParser parser = new DistributionRulesParser(tokens);
        parser.addErrorListener(errorListener);
        return parser;
    }
}
