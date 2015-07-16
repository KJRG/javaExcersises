package com.capgemini.nodes;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NodeValidatorsTest {

	@Test(expected = InvalidNodeIdException.class)
	public void ShouldThrowInvalidNodeIdException() throws NodeException {
		Node n = new Node("X0000", "Incorrect length of id", "Y000");

		NodeValidators nv = new NodeValidators();

		List<Node> track = Arrays.asList(n);

		nv.validateMethod(track);
	}

	@Test(expected = InvalidNodeDescriptionException.class)
	public void ShouldThrowInvalidNodeDescriptionException()
			throws NodeException {
		Node n = new Node("Y000",
				"Description is toooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo loooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong",
				"Z000");

		NodeValidators nv = new NodeValidators();

		List<Node> track = Arrays.asList(n);

		nv.validateMethod(track);
	}

	@Test(expected = CycleDetectedException.class)
	public void ShouldThrowCycleDetectedException() throws NodeException {
		Node[] track = {new Node("A200", "In cycle", "A202"),
				new Node("A201", "In cycle", "A200"),
				new Node("A202", "In cycle", "A201")};
		NodeValidators nv = new NodeValidators();

		nv.validateMethod(Arrays.asList(track));
	}

	@Test(expected = MultipleSubsequentNodesException.class)
	public void ShouldThrowMultipleSubsequentNodesExceptionForNonPenultimate()
			throws NodeException {
		Node[] track = {new Node("B100", "Too many subsequent nodes", "----"),
				new Node("B101", "Too many subsequent nodes", "B100"),
				new Node("B102", "Too many subsequent nodes", "B101"),
				new Node("B103", "Too many subsequent nodes", "B101"),
				new Node("B104", "Too many subsequent nodes", "B102")};
		NodeValidators nv = new NodeValidators();

		nv.validateMethod(Arrays.asList(track));
	}

	@Test(expected = MultipleSubsequentNodesException.class)
	public void ShouldThrowMultipleSubsequentNodesExceptionForPenultimate()
			throws NodeException {
		Node[] track = {
				new Node("C100", "Too many subsequent nodes for penultimate",
						"----"),
				new Node("C101", "Too many subsequent nodes for penultimate",
						"C100"),
				new Node("C102", "Too many subsequent nodes for penultimate",
						"C101"),
				new Node("C103", "Too many subsequent nodes for penultimate",
						"C101"),
				new Node("C104", "Too many subsequent nodes for penultimate",
						"C101")};
		NodeValidators nv = new NodeValidators();

		nv.validateMethod(Arrays.asList(track));
	}

	@Test
	public void ShouldNotThrowExceptionWithoutMultipleSubsequentNodes()
			throws NodeException {
		Node[] track = {
				new Node("D100", "Too many subsequent nodes for penultimate",
						"----"),
				new Node("D101", "Too many subsequent nodes for penultimate",
						"D100"),
				new Node("D102", "Too many subsequent nodes for penultimate",
						"D101"),
				new Node("D103", "Too many subsequent nodes for penultimate",
						"D102"),
				new Node("D104", "Too many subsequent nodes for penultimate",
						"D103")};
		NodeValidators nv = new NodeValidators();

		nv.validateMethod(Arrays.asList(track));
	}

	@Test
	public void ShouldNotThrowExceptionWithMultipleSubsequentNodesForPenultimate()
			throws NodeException {
		Node[] track = {
				new Node("E100", "Too many subsequent nodes for penultimate",
						"----"),
				new Node("E101", "Too many subsequent nodes for penultimate",
						"E100"),
				new Node("E102", "Too many subsequent nodes for penultimate",
						"E101"),
				new Node("E103", "Too many subsequent nodes for penultimate",
						"E102"),
				new Node("E104", "Too many subsequent nodes for penultimate",
						"E102")};
		NodeValidators nv = new NodeValidators();

		nv.validateMethod(Arrays.asList(track));
	}

}
