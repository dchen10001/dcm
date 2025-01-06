package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.StringNodeImpl;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Node implementation for ENTITY_IDENTIFIER node
 * entityIdentifier: entity identifier UUID style
 */

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@ToString
public class EntityIdentifierNodeWrapImpl implements NodeWrapper<StringNodeImpl> {
	private final String entityIdentifier;

	@Override
	public StringNodeImpl getNode() {
		return new StringNodeImpl(entityIdentifier);
	}
}
