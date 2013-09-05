package org.jboss.tools.aesh.core.ansi;


public class CursorHorizontalAbsolute extends ControlSequence {

	public CursorHorizontalAbsolute(String controlSequenceString) {
		super(controlSequenceString);
	}

	@Override
	protected ControlSequenceType getType() {
		return ControlSequenceType.CURSOR_HORIZONTAL_ABSOLUTE;
	}

}
