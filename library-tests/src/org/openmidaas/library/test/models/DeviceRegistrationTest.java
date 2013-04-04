/*******************************************************************************
 * Copyright 2013 SecureKey Technologies Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.openmidaas.library.test.models;

import java.util.concurrent.CountDownLatch;

import junit.framework.Assert;

import org.openmidaas.library.MIDaaS;
import org.openmidaas.library.authentication.AVSDeviceRegistration;
import org.openmidaas.library.authentication.Level0DeviceAuthentication;
import org.openmidaas.library.common.network.ConnectionManager;
import org.openmidaas.library.model.core.InitializationCallback;
import org.openmidaas.library.model.core.MIDaaSException;
import org.openmidaas.library.persistence.AttributeDBPersistenceDelegate;
import org.openmidaas.library.persistence.AttributePersistenceCoordinator;
import org.openmidaas.library.test.network.MockTransportFactory;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

public class DeviceRegistrationTest extends InstrumentationTestCase{
	
	private MockTransportFactory mockFactory;
	private Context mContext;
	private boolean notificationSuccess = false;
	private static boolean isInit = false;
	
	protected void setUp() throws Exception {
		mContext = getInstrumentation().getContext();
		MIDaaS.setContext(mContext);
		mockFactory = new MockTransportFactory(mContext, "device_reg_success.json");
		ConnectionManager.setNetworkFactory(mockFactory);
		AttributePersistenceCoordinator.setPersistenceDelegate(new MockPersistence());
		//mContext.deleteDatabase("attributes.db");
		isInit = true;
	}

	
	@SmallTest
	public void testDeviceRegistrationSuccess() throws Exception {
		final CountDownLatch mLatch = new CountDownLatch(1);
		mockFactory.setFilename("device_reg_success.json");
		mContext.deleteDatabase(mContext.getDatabasePath("attributes.db").toString());
		// first register the device. 
		notificationSuccess = false;
		AVSDeviceRegistration deviceRegistration = new AVSDeviceRegistration(new Level0DeviceAuthentication());
		deviceRegistration.registerDevice(new InitializationCallback() {

			@Override
			public void onSuccess() {
				notificationSuccess = true;
				mLatch.countDown();
			}

			@Override
			public void onError(MIDaaSException exception) {
				notificationSuccess = false;
				mLatch.countDown();
			}

			@Override
			public void onRegistering() {
				
			}	
		});
		mLatch.await();
		Assert.assertTrue(notificationSuccess);
	}
	
	@SmallTest
	public void testRegistrationFailure() throws Exception {
		final CountDownLatch mLatch = new CountDownLatch(1);
		mockFactory.setFilename("device_reg_fail.json");
		mContext.deleteDatabase(mContext.getDatabasePath("attributes.db").toString());
		AVSDeviceRegistration deviceRegistration = new AVSDeviceRegistration(new Level0DeviceAuthentication());
		deviceRegistration.registerDevice(new InitializationCallback() {

			

			@Override
			public void onError(MIDaaSException exception) {
				notificationSuccess = false;
				mLatch.countDown();
			}

			@Override
			public void onSuccess() {
				notificationSuccess = true;
				mLatch.countDown();
			}

			@Override
			public void onRegistering() {
				// TODO Auto-generated method stub
				
			}	
		});
		
		mLatch.await();
		Assert.assertEquals(false, notificationSuccess);
	}
	
	@SmallTest
	public void testRegistrationFailureWithErrorInAuthenticationStrategy()  throws Exception {
		final CountDownLatch mLatch = new CountDownLatch(1);
		mockFactory.setFilename("device_reg_success.json");
		AVSDeviceRegistration deviceRegistration = new AVSDeviceRegistration(new MockAuthenticationStrategy());
		deviceRegistration.registerDevice(new InitializationCallback() {

			

			@Override
			public void onError(MIDaaSException exception) {
				notificationSuccess = false;
				mLatch.countDown();
			}

			@Override
			public void onSuccess() {
				notificationSuccess = true;
				mLatch.countDown();
			}

			@Override
			public void onRegistering() {
				// TODO Auto-generated method stub
				
			}	
		});
		
		mLatch.await();
	//	mContext.deleteDatabase(mContext.getDatabasePath("attributes.db").toString());
		Assert.assertEquals(false, notificationSuccess);
	}
	
//	@Override
//	protected void tearDown () {
//		mContext.deleteDatabase("attributes.db");	
//	}

}
