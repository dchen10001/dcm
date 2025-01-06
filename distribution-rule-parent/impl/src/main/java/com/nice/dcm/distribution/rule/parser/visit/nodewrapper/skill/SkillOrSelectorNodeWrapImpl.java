package com.nice.dcm.distribution.rule.parser.visit.nodewrapper.skill;

import java.util.List;

import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.ListNodeImpl;
import com.nice.dcm.distribution.rule.parser.visit.nodewrapper.NodeWrapper;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper=false)
@ToString
@AllArgsConstructor
public class SkillOrSelectorNodeWrapImpl implements NodeWrapper<ListNodeImpl> {
	List<SkillSetSelector> selectors;

	@Override
	public ListNodeImpl getNode() {
		return new ListNodeImpl(selectors);
	}
}
