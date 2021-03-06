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
package org.openmidaas.library.persistence;

import android.provider.BaseColumns;

/**
 * 
 * This abstract class specifies the table and 
 * column names of the attributes table. 
 *
 */
public abstract class AttributesTable implements BaseColumns {
	public static final String TABLE_NAME 			= "attributes";
	public static final String COLUMN_NAME_NAME		= "name";
	public static final String COLUMN_NAME_VALUE 	= "value";
	public static final String COLUMN_NAME_TOKEN	= "token";
	public static final String COLUMN_NAME_PENDING	= "pending";
	public static final String COLUMN_NAME_LABEL	= "label";
}
