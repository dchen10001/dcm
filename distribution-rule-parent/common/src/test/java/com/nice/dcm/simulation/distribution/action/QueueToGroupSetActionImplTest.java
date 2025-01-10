package com.nice.dcm.simulation.distribution.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.nice.dcm.simulation.distribution.node.rule.SkillLevelCondition;
import com.nice.dcm.simulation.distribution.node.rule.SkillSelector;
import com.nice.dcm.simulation.distribution.node.rule.SkillSetSelector;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinaryOperator;
import com.nice.dcm.simulation.distribution.node.rule.skill.BinarySkillLevelConditionImpl;
import com.nice.dcm.simulation.distribution.node.rule.skill.SkillSelectorImpl;
import com.nice.dcm.simulation.distribution.node.rule.skill.SkillSetSelectorImpl;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlOperator;
import com.nice.dcm.simulation.distribution.node.rule.skill.SqlSkillLevelConditionImpl;

class QueueToGroupSetActionImplTest {
	@Test
	void testConstructor() {
		QueueToGroupAction queueToGroupAction = createDefault(0);
		QueueToGroupSetAction queueToGroupSetAction = new QueueToGroupSetActionImpl(queueToGroupAction);
		
		 QueueToActions actions = queueToGroupSetAction.getActions(0);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		actions = queueToGroupSetAction.getActions(100);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		
		queueToGroupSetAction = new QueueToGroupSetActionImpl(queueToGroupAction, null);
		actions = queueToGroupSetAction.getActions(0);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		actions = queueToGroupSetAction.getActions(100);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		queueToGroupSetAction = new QueueToGroupSetActionImpl(queueToGroupAction, List.of());
		actions = queueToGroupSetAction.getActions(0);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		actions = queueToGroupSetAction.getActions(100);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		List<QueueToGroupAction> queueToGroupActions = createList();
		queueToGroupSetAction = new QueueToGroupSetActionImpl(queueToGroupAction, queueToGroupActions);
		
		actions = queueToGroupSetAction.getActions(0);
		assertEquals(1, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
		
		actions = queueToGroupSetAction.getActions(100);
		assertEquals(3, actions.getActions().size());
		assertSame(0, actions.getActions().get(0).getPriority());
	}
	
	@Test
	void testException() {
		QueueToGroupAction q = createDefault(110);
		Exception e = assertThrows(IllegalArgumentException.class, () -> new QueueToGroupSetActionImpl(q));
		assertEquals("waitAfterSeconds of default group action should be 0.", e.getMessage());
		
		e = assertThrows(NullPointerException.class, () -> new QueueToGroupSetActionImpl(null));
		assertEquals("defaultGroupAction is marked non-null but is null", e.getMessage());
	}
	
	private QueueToGroupAction createDefault(long waitAfterSeconds) {
		SkillLevelCondition condition = new SqlSkillLevelConditionImpl(SqlOperator.IN, 1, 2);
		List<SkillSelector> skillSelectorsList = List.of(new SkillSelectorImpl("skillOid1"),
				new SkillSelectorImpl("skillOid2", condition));
		SkillSetSelector skillSelector = new SkillSetSelectorImpl(skillSelectorsList);
		SkillQueueSelector skillQueueSelector = new SkillQueueSelectorImpl(skillSelector);	
		QueueToAction queueToAction = new QueueToActionImpl(List.of(skillQueueSelector), 0, false);
		return  new QueueToGroupActionImpl(List.of(queueToAction), waitAfterSeconds);
	}
	
	private List<QueueToGroupAction> createList() {
		List<QueueToGroupAction> queueToGroupActions = new ArrayList<>();
		{
			SkillLevelCondition condition = new BinarySkillLevelConditionImpl(BinaryOperator.EQUAL, 1);
			List<SkillSelector> skillSelectorsList = List.of(new SkillSelectorImpl("skillOid3"),
					new SkillSelectorImpl("skillOid4", condition));
			SkillSetSelector skillSelector = new SkillSetSelectorImpl(skillSelectorsList);
			SkillQueueSelector skillQueueSelector = new SkillQueueSelectorImpl(skillSelector);	
			QueueToAction queueToAction = new QueueToActionImpl(List.of(skillQueueSelector), 1, false);
			
			queueToGroupActions.add(new QueueToGroupActionImpl(List.of(queueToAction), 100));
		}
		
		{
			SkillLevelCondition condition = new BinarySkillLevelConditionImpl(BinaryOperator.NOT_EQUAL, 1);
			List<SkillSelector> skillSelectorsList = List.of(new SkillSelectorImpl("skillOid5"),
					new SkillSelectorImpl("skillOid6", condition));
			SkillSetSelector skillSelector = new SkillSetSelectorImpl(skillSelectorsList);
			SkillQueueSelector skillQueueSelector = new SkillQueueSelectorImpl(skillSelector);	
			QueueToAction queueToAction = new QueueToActionImpl(List.of(skillQueueSelector), 2, false);
			
			queueToGroupActions.add(new QueueToGroupActionImpl(List.of(queueToAction), 200));
		}
		return queueToGroupActions;
	}
}
