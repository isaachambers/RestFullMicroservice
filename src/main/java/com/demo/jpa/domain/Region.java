package com.demo.jpa.domain;

public enum Region {

	KAMPALA("Kampala"), NAIROBI("Nairobi"), KIGALI("Kigali");
	private String label;

	private Region(String label) {
		this.label = label;
	}

	public static Region findByLabel(String label) {
		for (Region region : Region.values()) {
			if (region.label.equalsIgnoreCase(label))
				return region;
		}
		return null;
	}
	
	public String getLabel() {
		return this.label;
	}
}
