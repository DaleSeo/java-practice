package seo.dale.practice.java.lamda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class TradeProcessorTest {

	private TradeProcessor processor =  new TradeProcessor();


	@Test
	public void test() throws Exception {
		IAddable<Trade> aggregateQty = (t1, t2) -> {
			Trade t = new Trade(t1.getQuantity() + t2.getQuantity());
			return t;
		};

		IAddable<Trade> largeTrade = (t1, t2) -> {
			if (t1.getQuantity() > 100) {
				return t1;
			} else {
				return t2;
			}
		};

		Trade t1 = new Trade(57);
		Trade t2 = new Trade(103);

		Trade t3 = processor.applyBehaviour(aggregateQty, t1, t2);
		assertEquals(160, t3.getQuantity());

		Trade t4 = processor.applyBehaviour(largeTrade, t1, t2);
		assertEquals(103, t4.getQuantity());

	}

}