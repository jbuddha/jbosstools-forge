/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.tools.forge.ui.ext;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.addon.ui.CommandExecutionListener;
import org.jboss.forge.addon.ui.UICommand;
import org.jboss.forge.addon.ui.UIProvider;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.furnace.spi.ListenerRegistration;

/**
 * Eclipse implementation of {@link UIProvider}
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public enum ForgeUIProvider implements UIProvider {
	INSTANCE;

	private List<CommandExecutionListener> commandListeners = new ArrayList<CommandExecutionListener>();

	public void fireInteractionStarted(UIContext context) {
	}

	public void fireInteractionStopped(UIContext context) {

	}

	public void firePreCommandExecuted(UICommand command, UIContext context) {
		for (CommandExecutionListener listener : commandListeners) {
			try {
				listener.preCommandExecuted(command, context);
			} catch (Exception e) {
				ForgeUIPlugin.log(e);
			}
		}
	}

	public void firePostCommandExecuted(UICommand command, UIContext context,
			Result result) {
		for (CommandExecutionListener listener : commandListeners) {
			try {
				listener.postCommandExecuted(command, context, result);
			} catch (Exception e) {
				ForgeUIPlugin.log(e);
			}
		}
	}

	public void firePostCommandFailure(UICommand command, UIContext context,
			Throwable failure) {
		for (CommandExecutionListener listener : commandListeners) {
			try {
				listener.postCommandFailure(command, context, failure);
			} catch (Exception e) {
				ForgeUIPlugin.log(e);
			}
		}
	}

	@Override
	public ListenerRegistration<CommandExecutionListener> addCommandExecutionListener(
			final CommandExecutionListener listener) {
		commandListeners.add(listener);
		return new ListenerRegistration<CommandExecutionListener>() {
			public CommandExecutionListener removeListener() {
				commandListeners.remove(listener);
				return listener;
			}
		};
	}

}
