package com.nice.dcm.distribution.rule.parser.utility;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nice.dcm.distribution.rule.parser.DistributionRulesLexer;
import com.nice.dcm.distribution.rule.parser.DistributionRulesParser;
import com.nice.dcm.distribution.rule.parser.listener.ThrowingErrorListener;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.ExecutionNodeWrapperImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.rule.RoutingRuleSetNodeWrapImpl;
import com.nice.dcm.distribution.rule.parser.visitor.DCMRuleVisitorImpl;
import com.nice.dcm.simulation.distribution.node.Execution;
import com.nice.dcm.simulation.distribution.node.rule.RoutingRuleSet;

public class RuleParserHelper {
	private static final Logger logger = LoggerFactory.getLogger(RuleParserHelper.class);
	
    private ThrowingErrorListener errorListener = new ThrowingErrorListener();

	public Execution visitStart(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
		DistributionRulesParser parser = parserScript(script);
		ExecutionNodeWrapperImpl nodeWrapper = (ExecutionNodeWrapperImpl)parser.start().accept(dcmRuleVisitor);
		return nodeWrapper.getNode();
	}
	
    public RoutingRuleSet visitRoutingRuleSet(String script, DCMRuleVisitorImpl dcmRuleVisitor) {
    	DistributionRulesParser parser = parserScript(script);
    	RoutingRuleSetNodeWrapImpl ruleSetNode = (RoutingRuleSetNodeWrapImpl)parser.routingRuleSet().accept(dcmRuleVisitor);    
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
