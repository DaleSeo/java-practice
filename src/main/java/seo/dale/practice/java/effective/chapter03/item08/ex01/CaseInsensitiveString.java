package seo.dale.practice.java.effective.chapter03.item08.ex01;

import java.util.ArrayList;
import java.util.List;

public final class CaseInsensitiveString {

	private final String str;

	public CaseInsensitiveString(String str) {
		if (str == null) {
			throw new NullPointerException();
		}
		this.str = str;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString) {
			return str.equalsIgnoreCase(((CaseInsensitiveString) o).str);
		}
		return false;
	}

	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		System.out.println(cis.equals(s) + "  " + s.equals(cis));

		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);
		System.out.println(list.contains(s));
	}

}
