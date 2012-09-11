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
package com.bundleserver.bundleservercommons.actions;

import com.bundleserver.bundleservercommons.core.RawCommand;
import com.bundleserver.bundleservercommons.processors.ClientCommandProcessor;
import java.io.BufferedWriter;

/**
 * Always executed by BundleServer (Consumer) after processing {@link RawCommand} (Producer).
 *
 * @see ClientCommandProcessor
 */
public abstract class PostClientCommandProcessingAction {

	private final BufferedWriter outputStream;
	private final RawCommand command;

	public PostClientCommandProcessingAction(BufferedWriter out, RawCommand command) {
		this.outputStream = out;
		this.command = command;
	}

	public BufferedWriter getOutputStream() {
		return outputStream;
	}

	public RawCommand getCommand() {
		return command;
	}

	public abstract void execute();
}
