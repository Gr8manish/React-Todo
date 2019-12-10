/**
 * @(#) CommonUtils.java
 *
 * Copyright (C) 2019- Curtis Digital. All rights reserved.
 *
 * This software is proprietary information of Curtis Digital. You shall
 * not disclose this information and shall use it only in accordance with the
 * terms of License.
 *
 * CURTIS DIGITAL, MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CURTIS DIGITAL SHALL
 * NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * 
 * "Curtis Digital"
 */
package com.tm.todoapp.util;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The utility class CommonUtils. It holds common functionalities to be used
 * across the applications.
 */
public class CommonUtils {

	private CommonUtils() {
		// The utility class
	}

	/**
	 * Gets the prepared bad request response
	 * 
	 * @param errorMessage The error message
	 * @return The bad request response
	 */
	public static ResponseEntity<String> badRequestResponse(String errorMessage) {
		return new ResponseEntity<>(new Document("error", errorMessage).toJson(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gets the prepared precondition failed response
	 * 
	 * @param errorMessage The error message
	 * @return The precondition failed response
	 */
	public static ResponseEntity<String> preconditionFailedResponse(String errorMessage) {
		return new ResponseEntity<>(new Document("error", errorMessage).toJson(), HttpStatus.PRECONDITION_FAILED);
	}
}
