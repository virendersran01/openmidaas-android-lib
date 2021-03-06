/*******************************************************************************
 * Copyright 2013 SecureKey Technologies Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.openmidaas.library.test;

import org.openmidaas.library.common.Constants.ATTRIBUTE_STATE;
import org.openmidaas.library.model.core.AbstractAttribute;

public class MockAttribute extends AbstractAttribute<String>{

	public MockAttribute() {
		mName = "MockAttribute";
		mState = ATTRIBUTE_STATE.NOT_VERIFIED;
		mSignedToken = "1234.1234.1234";
		mValue = "MockAttribute";
	}
	
	@Override
	protected boolean validateAttribute(String value) {
		return true;
	}
}
