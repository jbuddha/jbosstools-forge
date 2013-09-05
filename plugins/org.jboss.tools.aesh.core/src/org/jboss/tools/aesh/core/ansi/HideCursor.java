package org.jboss.tools.aesh.core.ansi;


public class HideCursor extends ControlSequence {

	public HideCursor(String controlSequenceString) {
		super(controlSequenceString);
	}

	@Override
	protected ControlSequenceType getType() {
		return ControlSequenceType.HIDE_CURSOR;
	}

}
