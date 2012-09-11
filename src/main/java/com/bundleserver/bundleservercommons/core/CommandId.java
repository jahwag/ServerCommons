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
package com.bundleserver.bundleservercommons.core;

/**
 *
 */
public class CommandId {

	private short id; // todo this could be an object to support both binary(short)/real client and ascii(string)/telnet

	public CommandId(int id) {
		if (id < 0) {
			throw new RuntimeException("Must be greater than 0.");
		}

		this.id = id <= Short.MAX_VALUE ? (short) id : (short) -Math.abs(id - Short.MAX_VALUE);
	}

	public CommandId(String id) {
		this(Integer.valueOf(id));
	}

	/**
	 *
	 * @return an integer representing the real value.
	 */
	public int getId() {
		return id < 0 ? Short.MAX_VALUE + Math.abs(id) : id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof CommandId)) {
			throw new RuntimeException("Attempted to compare " + getClass().getSimpleName() + " with " + obj.getClass().getSimpleName());
		}

		return new Short(id).equals(obj);
	}

	@Override
	public int hashCode() {
		return id;
	}

}
