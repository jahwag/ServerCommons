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
import com.bundleserver.bundleservercommons.core.Command;

public interface ClientCommandProcessor {

	/**
	 * Processes the given command.
	 * <p/>
	 * @param commandToProcess
	 * @return 
	 */
	public PostClientCommandProcessingAction processCommand(Command commandToProcess);

	/**
	 * A ClientCommandProcessor may be associated with several commandIds.
	 * <p/>
	 * @return one or more commandIds handled by this processor.
	 */
	public CommandId[] getAssociatedIds();
}
