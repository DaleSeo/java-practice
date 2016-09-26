package seo.dale.practice.java.lamda;

public class TradeProcessor {

	public Trade applyBehaviour(IAddable<Trade> addable, Trade t1, Trade t2) {
		Trade t = addable.add(t1, t2);
		return t;
	}

}
