package it.unifi.facpl.junit.function;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;

public class BooleanCombinationExpressionTest extends ExpressionBooleanTree {

	static private ExpressionValue v_true = ExpressionValue.TRUE;
	static private ExpressionValue v_false = ExpressionValue.FALSE;
	static private ExpressionValue err = ExpressionValue.ERROR;
	static private ExpressionValue bot = ExpressionValue.BOTTOM;

	public BooleanCombinationExpressionTest() {
		// in order to use the combined method defined in the
		// ExpressionBooleanTree class
		super(null);
	}

	@Before
	public void setUp() {
	}

	@Test
	public void testCombineAND() {
		ExpressionValue m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_true, v_true));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_false, v_true));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_true, v_false));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_false, v_false));
		assertEquals(v_false, m);
		// bot
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_false, bot));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(bot, v_false));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(bot, bot));
		assertEquals(bot, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_true, bot));
		assertEquals(bot, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(bot, v_true));
		assertEquals(bot, m);
		// err
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_false, err));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(err, v_false));
		assertEquals(v_false, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(v_true, err));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(err, v_true));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(err, err));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(err, bot));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.AND, getArrayList(bot, err));
		assertEquals(err, m);
	}

	@Test
	public void testCombineOR() {
		ExpressionValue m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_true, v_true));
		assertEquals(ExpressionValue.TRUE, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_false, v_true));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_true, v_false));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_false, v_false));
		assertEquals(v_false, m);
		// bot
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(bot, bot));
		assertEquals(bot, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_false, bot));
		assertEquals(bot, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(bot, v_false));
		assertEquals(bot, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_true, bot));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(bot, v_true));
		assertEquals(v_true, m);
		// err
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_false, err));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(err, v_false));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(v_true, err));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(err, v_true));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(err, err));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(err, bot));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.OR, getArrayList(bot, err));
		assertEquals(err, m);
	}

	@Test
	public void testCombineNOT() {
		ExpressionValue m = this.combineValues(ExprBooleanConnector.NOT, getArrayList(v_true));
		assertEquals(ExpressionValue.FALSE, m);
		m = this.combineValues(ExprBooleanConnector.NOT, getArrayList(v_false));
		assertEquals(v_true, m);
		m = this.combineValues(ExprBooleanConnector.NOT, getArrayList(err));
		assertEquals(err, m);
		m = this.combineValues(ExprBooleanConnector.NOT, getArrayList(bot));
		assertEquals(bot, m);
	}

	private ArrayList<ExpressionValue> getArrayList(ExpressionValue... v_truees) {
		ArrayList<ExpressionValue> lists = new ArrayList<ExpressionValue>();
		for (ExpressionValue m : v_truees) {
			lists.add(m);
		}
		return lists;
	}
}
