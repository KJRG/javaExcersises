package com.capgemini.nodes;

import java.util.Arrays;
import java.util.List;

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

		// TODO this might be a bad practice, check it
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
			
		} catch(NodeException ne) {
			throw ne;
		}
	}

	private int hasCycleOrTooMuchSubsequent(List<Node> nodes) {
		int numSuccessors = 0;
		String current = "----", successor = null;

		// check if there is any node with predecessorId = "----"
		// if not, there is a cycle in the graph
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

	public static void main(String args[]) {
		Node n1 = new Node("X0000", "Incorrect length of id", "Y000");
		Node n2 = new Node("Y000",
				"Description is toooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo loooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong",
				"Z000");
		Node n3 = new Node("A200", "In cycle", "A202");
		Node n4 = new Node("A201", "In cycle", "A200");
		Node n5 = new Node("A202", "In cycle", "A201");
		Node n6 = new Node("B100", "Too many subsequent nodes", "----");
		Node n7 = new Node("B101", "Too many subsequent nodes", "B100");
		Node n8 = new Node("B102", "Too many subsequent nodes", "B100");
		Node n9 = new Node("B103", "Too many subsequent nodes", "B100");
		Node n10 = new Node("C100", "Too many subsequent nodes for penultimate", "----");
		Node n11 = new Node("C101", "Too many subsequent nodes for penultimate", "C100");
		Node n12 = new Node("C102", "Too many subsequent nodes for penultimate", "C101");
		Node n13 = new Node("C103", "Too many subsequent nodes for penultimate", "C101");
		Node n14 = new Node("C104", "Too many subsequent nodes for penultimate", "C101");

		NodeValidators nv = new NodeValidators();

		List<Node> track1 = Arrays.asList(n1);
		List<Node> track2 = Arrays.asList(n2);
		List<Node> track3 = Arrays.asList(n3, n4, n5);
		List<Node> track4 = Arrays.asList(n6, n7, n8, n9);
		List<Node> track5 = Arrays.asList(n10, n11, n12, n13, n14);

		try {
			nv.validateMethod(track1);
		} catch (NodeException ne) {
			System.out.println(ne.getMessage());
		}

		try {
			nv.validateMethod(track2);
		} catch (NodeException ne) {
			System.out.println(ne.getMessage());
		}

		try {
			nv.validateMethod(track3);
		} catch (NodeException ne) {
			System.out.println(ne.getMessage());
		}

		try {
			nv.validateMethod(track4);
		} catch (NodeException ne) {
			System.out.println(ne.getMessage());
		}

		try {
			nv.validateMethod(track5);
		} catch (NodeException ne) {
			System.out.println(ne.getMessage());
		}
	}
}
