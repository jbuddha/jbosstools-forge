package org.jboss.tools.aesh.core.internal.ansi;

import org.jboss.tools.aesh.core.document.Document;
import org.jboss.tools.aesh.core.internal.AeshCorePlugin;


public class CursorBack extends AbstractCommand {
	
	private int amount = 0;

	public CursorBack(String arguments) {
		try {
			amount = Integer.valueOf(arguments);
		} catch (NumberFormatException e) {
			AeshCorePlugin.log(e);
		}
	}

	@Override
	public CommandType getType() {
		return CommandType.CURSOR_BACK;
	}
	
	@Override
	public void handle(Document document) {
		document.moveCursorTo(document.getCursorOffset() - amount);
	}

}
