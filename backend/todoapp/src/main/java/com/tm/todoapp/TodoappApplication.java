/**
 * @(#) TodoappApplication.java
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
package com.tm.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The TodoappApplication. Its the starting point of application.
 */
@SpringBootApplication
public class TodoappApplication {

	/**
	 * Execution starts from here
	 * 
	 * @param args The command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}
}
