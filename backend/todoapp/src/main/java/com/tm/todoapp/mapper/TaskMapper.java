/**
 * @(#) TaskMapper.java
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
package com.tm.todoapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tm.todoapp.model.Task;

/**
 * The TaskMapper. It maps the rows from the query response to the Task model.
 */
public class TaskMapper implements RowMapper<Task> {

	/**
	 * Maps the row to Task
	 */
	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

		Task task = new Task();
		task.setTaskId(rs.getInt("task_id"));
		task.setTitle(rs.getString("title"));
		task.setDescription(rs.getString("description"));
		task.setStartTime(rs.getLong("start_time"));
		return task;
	}
}
