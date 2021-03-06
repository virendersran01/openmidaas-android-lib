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
package org.openmidaas.library.common.network;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Interface that specifies the methods of the network 
 * transport. 
 * Implement this interface to create your own transport. 
 */
public interface NetworkTransport {
	
	/**
	 * Performs a POST request to the URL path specified. 
	 * @param disableSSL - disables SSL.
	 * @param url - the path to post the data to.
	 * @param data - the data to post of type JSONObject.
	 * @param responseHandler - the async handler to receive success/error
	 * 							from the requested operation.
	 */
	public void doPostRequest(boolean disableSSL, String url, HashMap<String, String> headers, JSONObject data, AsyncHttpResponseHandler responseHandler);
	
	/**
	 * Performs a GET request to the URL path specified. 
	 * @param disableSSL - disables SSL
	 * @param url - the path to get the data from.
	 * @param requestParams - the request parameters
	 * @param responseHandler - the async handler to receive success/error 
	 * 							from the requested operation
	 */
	public void doGetRequest(boolean disableSSL, String url, Map<String, String> requestParams, AsyncHttpResponseHandler responseHandler);

}
