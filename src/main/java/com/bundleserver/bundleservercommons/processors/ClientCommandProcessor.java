/*
 * Copyright 2012 Jahziah Wagner <jahziah[dot]wagner[at]gmail[dot]com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bundleserver.bundleservercommons.processors;

import com.bundleserver.bundleservercommons.actions.PostClientCommandProcessingAction;
import com.bundleserver.bundleservercommons.core.CommandId;
import com.bundleserver.bundleservercommons.core.RawCommand;
import org.osgi.service.log.LogService;

public abstract class ClientCommandProcessor {
	private volatile LogService logger;

	/**
	 * Processes the given command.
	 * <p/>
	 * @param commandToProcess
	 * @return
	 */
	public abstract PostClientCommandProcessingAction processCommand(RawCommand commandToProcess);

	/**
	 * A ClientCommandProcessor may be associated with several commandIds.
	 * <p/>
	 * @return one or more commandIds handled by this processor.
	 */
	public abstract CommandId[] getAssociatedIds();

	public LogService getLogger() {
		return logger;
	}

	@Override
	public int hashCode() {
		// A CCP is effectively a singleton inside the server
		return getClass().getSimpleName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ClientCommandProcessor other = (ClientCommandProcessor) obj;
		return other.getClass().equals(getClass());
	}


}
