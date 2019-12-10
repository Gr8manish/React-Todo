/**
 * @(#) TaskDAO.java
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
package com.tm.todoapp.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.tm.todoapp.dao.ITaskDAO;
import com.tm.todoapp.mapper.TaskMapper;
import com.tm.todoapp.model.Page;
import com.tm.todoapp.model.PagePayload;
import com.tm.todoapp.model.Task;

/**
 * The TaskDAO. It holds implementation of the CRUD operations related to the
 * tasks information.
 */
@Repository
public class TaskDAO implements ITaskDAO {

	/**
	 * The JDBC template
	 */
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Instantiating the TaskDAO
	 * 
	 * @param jdbcTemplate The JDBC template
	 */
	public TaskDAO(NamedParameterJdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Adds the new task
	 * 
	 * @param task The new task
	 * @return The count of rows affected
	 */
	@Override
	public int addTask(Task task) {

		return this.jdbcTemplate.update(
				"insert into tasks(title, description, start_time) values(:title, :description, :start_time)",
				new MapSqlParameterSource().addValue("title", task.getTitle())
						.addValue("description", task.getDescription()).addValue("start_time", task.getStartTime()),
				new GeneratedKeyHolder());
	}

	/**
	 * Edits the task with specified ID
	 * 
	 * @param taskId      The task ID
	 * @param updatedTask The updated task
	 * @return The updation status
	 */
	@Override
	public boolean editTask(Integer taskId, Task updatedTask) {

		return this.jdbcTemplate.update(
				"update tasks set title=:title, description=:description, start_time=:start_time where task_id=:task_id",
				new MapSqlParameterSource().addValue("title", updatedTask.getTitle())
						.addValue("description", updatedTask.getDescription())
						.addValue("start_time", updatedTask.getStartTime()).addValue("task_id", taskId),
				new GeneratedKeyHolder()) > 0;
	}

	/**
	 * Deletes the task with specified ID
	 * 
	 * @param taskId The task ID
	 * @return The deletion status
	 */
	@Override
	public boolean deleteTask(Integer taskId) {

		return this.jdbcTemplate.update("delete from tasks where task_id=:task_id",
				new MapSqlParameterSource().addValue("task_id", taskId), new GeneratedKeyHolder()) > 0;
	}

	/**
	 * Gets the list of tasks(paginated)
	 * 
	 * @param payload The payload which holds the page constraints
	 * @return The list of tasks
	 */
	@Override
	public Page<Task> getTasks(PagePayload payload) {

		// Getting the paginated tasks
		int offset = (payload.getPageNumber() - 1) * payload.getPageSize();
		String orderBy = payload.getSortOrder().equals("ascend") ? "ASC" : "DESC";
		List<Task> tasks = this.jdbcTemplate.query("select * from tasks order by " + payload.getSortField() + " "
				+ orderBy + " offset " + offset + " limit " + payload.getPageSize(), new TaskMapper());

		// Getting total tasks count
		Long totalRecords = this.jdbcTemplate.queryForObject("select count(*) as totalCount from tasks;",
				new HashMap<>(), Long.class);
		Page<Task> pageResponse = new Page<>();
		pageResponse.setData(tasks);
		pageResponse.setTotalCount(totalRecords.intValue());
		return pageResponse;
	}
}
