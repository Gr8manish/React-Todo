/**
 * @(#) Task.java
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
 * The data model Task. It holds all the information about a task.
 */
public class Task {

	/**
	 * The task ID
	 */
	private Integer taskId;

	/**
	 * The task title
	 */
	private String title;

	/**
	 * The task description
	 */
	private String description;

	/**
	 * The task start time
	 */
	private Long startTime;

	/**
	 * Gets the task ID
	 * 
	 * @return The task ID
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task ID
	 * 
	 * @param taskId the task ID
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the title
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title
	 * 
	 * @param title The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description
	 * 
	 * @param description The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the start time
	 * 
	 * @return The start time
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time
	 * 
	 * @param startTime The start time
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
}
