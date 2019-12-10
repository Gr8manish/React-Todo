/**
 * @(#) Page.java
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
package com.tm.todoapp.model;

import java.util.List;

/**
 * The data model Page. It holds the paginated response.
 */
public class Page<T> {

	/**
	 * The page data
	 */
	private List<T> data;

	/**
	 * The total records count
	 */
	private Integer totalCount;

	/**
	 * Gets the data
	 * 
	 * @return The data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * Sets the data
	 * 
	 * @param data The data
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * Gets the total records count
	 * 
	 * @return The total records count
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total records count
	 * 
	 * @param totalCount The total records count
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
