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
package org.openmidaas.library.authentication;

import org.openmidaas.library.authentication.core.DeviceAuthenticationCallback;
import org.openmidaas.library.model.core.MIDaaSException;

public class RegistrationAuthDelegate implements DeviceAuthenticationCallback {
	
	protected RegistrationAuthDelegate(){}

	@Override
	public void onSuccess(String deviceToken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(MIDaaSException exception) {
		// TODO Auto-generated method stub
		
	}

}