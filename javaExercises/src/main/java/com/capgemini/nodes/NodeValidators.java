package com.capgemini.nodes;

import java.util.List;

// @formatter:off
/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
// @formatter:on
public class NodeValidators {
	public void validateMethod(List<Node> nodes) throws NodeException {
		for (Node n : nodes) {
			
			// validate id
			if (n.getId().length() != 4) {
				throw new InvalidNodeIdException("Node id has incorrect length");
			}

			// validate description
			if (n.getDescription().length() > 128) {
				throw new InvalidNodeDescriptionException("Node description is too long");
			}
		}

		// validate cycle and subsequent nodes
		try {
			switch (hasCycleOrTooMuchSubsequent(nodes)) {
			case 0:
				break;
			case 1:
				throw new CycleDetectedException("A cycle was detected");
			case 2:
				throw new MultipleSubsequentNodesException("One of the nodes has too many subsequent nodes");
			default:
				break;
			}

		} catch (NodeException ne) {
			throw ne;
		}
	}

	private int hasCycleOrTooMuchSubsequent(List<Node> nodes) {
		int numSuccessors = 0;
		String current = "----", successor = null;

		/*
		 * check if there is any node with predecessorId = "----"
		 * if not, there is a cycle in the graphs
		 */
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPredecessorId() == current) {
				successor = nodes.get(i).getId();
				numSuccessors++;

				if (numSuccessors > 1) {
					return 2;
				}
			}
		}
		if (numSuccessors < 1) {
			return 1;
		}
		current = successor;

		// search for nodes with too many penultimate nodes
		for (int i = 1; i < nodes.size() - 2; i++) {
			numSuccessors = 0;

			for (int j = 0; j < nodes.size(); j++) {

				if (nodes.get(j).getPredecessorId() == current) {

					successor = nodes.get(j).getId();
					numSuccessors++;

					if (numSuccessors > 1) {
						return 2;
					}
				}
			}

			current = successor;
		}

		return 0;
	}

}
