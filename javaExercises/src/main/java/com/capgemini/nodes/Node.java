package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {
	private String id;
	private String description;
	private String predecessorId;

	public Node(String i, String d, String p) {
		this.id = i;
		this.description = d;
		this.predecessorId = p;
	}

	public String getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPredecessorId() {
		return this.predecessorId;
	}
}
