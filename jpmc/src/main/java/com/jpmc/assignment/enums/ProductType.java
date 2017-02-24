package com.jpmc.assignment.enums;

public enum ProductType {
	APPLE("apple"), ORANGE("orange"), PEAR("pear"), BANANA("banana"), KIWI(
			"kiwi"), MELONS("melons"), AVOCADO("avocado"), PINEAPPLE(
			"pineapple"), COCONUT("coconut"), GUAVA("guava"), MANGO("mango"), PAPAYA(
			"papaya"), LEMON("lemon"), APRICOT("apricot"), FIG("fig");
	
	private String value;
	
	private ProductType(String lowerCase) {
		this.value=lowerCase;
	}

	public String getValue() {
		return value;
	}
	
}
