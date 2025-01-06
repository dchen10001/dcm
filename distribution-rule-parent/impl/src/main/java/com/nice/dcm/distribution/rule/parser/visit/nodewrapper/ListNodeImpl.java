package com.nice.dcm.distribution.rule.parser.visit.nodewrapper;

import java.util.List;

import com.nice.dcm.simulation.distribution.node.BaseNode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class ListNodeImpl implements BaseNode {
    private final List<?> value;
    
	@Override
	public String toExpression() {
		return null;
	}
}
