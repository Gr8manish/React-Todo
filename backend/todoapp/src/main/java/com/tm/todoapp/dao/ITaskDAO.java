/**
 * @(#) ITaskDAO.java
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
package com.tm.todoapp.dao;

import com.tm.todoapp.model.Page;
import com.tm.todoapp.model.PagePayload;
import com.tm.todoapp.model.Task;

/**
 * The interface ITaskDAO. It holds blueprint of the CRUD operations related to
 * the tasks information.
 */
public interface ITaskDAO {

	/**
	 * Adds the new task
	 * 
	 * @param task The new task
	 * @return The count of rows affected
	 */
	public int addTask(Task task);

	/**
	 * Edits the task with specified ID
	 * 
	 * @param taskId      The task ID
	 * @param updatedTask The updated task
	 * @return The updation status
	 */
	public boolean editTask(Integer taskId, Task updatedTask);

	/**
	 * Deletes the task with specified ID
	 * 
	 * @param taskId The task ID
	 * @return The deletion status
	 */
	public boolean deleteTask(Integer taskId);

	/**
	 * Gets the list of tasks(paginated)
	 * 
	 * @param payload The payload which holds the page constraints
	 * @return The list of tasks
	 */
	public Page<Task> getTasks(PagePayload payload);
}
