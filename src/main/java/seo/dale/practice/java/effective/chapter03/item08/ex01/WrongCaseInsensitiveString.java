package seo.dale.practice.java.effective.chapter03.item08.ex01;

import java.util.ArrayList;
import java.util.List;

public final class WrongCaseInsensitiveString {

	private final String str;

	public WrongCaseInsensitiveString(String str) {
		if (str == null) {
			throw new NullPointerException();
		}
		this.str = str;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof WrongCaseInsensitiveString) {
			return str.equalsIgnoreCase(((WrongCaseInsensitiveString) o).str);
		}
		if (o instanceof String) {
			return str.equalsIgnoreCase((String) o);
		}
		return false;
	}

	public static void main(String[] args) {
		WrongCaseInsensitiveString cis = new WrongCaseInsensitiveString("Polish");
		String s = "polish";
		System.out.println(cis.equals(s) + "  " + s.equals(cis));

		List<WrongCaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);
		System.out.println(list.contains(s));
	}

}
