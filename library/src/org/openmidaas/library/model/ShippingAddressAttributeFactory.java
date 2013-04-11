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
package org.openmidaas.library.model;

import org.openmidaas.library.model.core.AbstractAttributeFactory;
import org.openmidaas.library.model.core.MIDaaSException;
import org.openmidaas.library.persistence.AttributePersistenceCoordinator;

import android.database.Cursor;

public class ShippingAddressAttributeFactory implements AbstractAttributeFactory<ShippingAddressAttribute, AddressValue>{

	@Override
	public ShippingAddressAttribute createAttributeWithValue(AddressValue value)
			throws InvalidAttributeValueException, MIDaaSException {
		ShippingAddressAttribute attribute = new ShippingAddressAttribute();
		attribute.setValue(value);
		AttributePersistenceCoordinator.saveAttribute(attribute);
		return attribute;
	}

	@Override
	public ShippingAddressAttribute createAttributeFromCursor(Cursor cursor)
			throws InvalidAttributeValueException {
		// TODO Auto-generated method stub
		return null;
	}

}
