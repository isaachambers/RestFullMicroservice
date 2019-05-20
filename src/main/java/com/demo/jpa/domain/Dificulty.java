package com.demo.jpa.domain;

public enum Dificulty {

	EASY("Easy"),MEDIUM("Medium"),HARD("Hard");
	
	private String label;

	private Dificulty(String label) {
		this.label = label;
	}

	public static Dificulty findByLabel(String label) {
		for (Dificulty region : Dificulty.values()) {
			if (region.label.equalsIgnoreCase(label))
				return region;
		}
		return null;
	}
}
