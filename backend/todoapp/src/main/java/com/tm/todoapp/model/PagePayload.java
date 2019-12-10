/**
 * @(#) Payload.java
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

/**
 * The data model Payload. It holds all request payload attributes.
 */
public class PagePayload {

	/**
	 * The page size
	 */
	private Integer pageSize;

	/**
	 * The page number
	 */
	private Integer pageNumber;

	/**
	 * The sort field
	 */
	private String sortField;

	/**
	 * The sort order
	 */
	private String sortOrder;

	/**
	 * Gets the page size
	 * 
	 * @return The page size
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size
	 * 
	 * @param pageSize The page size
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the page number
	 * 
	 * @return The page number
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * Sets the page number
	 * 
	 * @param pageNumber The page number
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Gets the sort field
	 * 
	 * @return The sort field
	 */
	public String getSortField() {
		return sortField;
	}

	/**
	 * Sets the sort field
	 * 
	 * @param sortField The sort field
	 */
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	/**
	 * Gets the sort order
	 * 
	 * @return The sort order
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the sort order
	 * 
	 * @param sortOrder
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
