/**
 * @(#) TaskController.java
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
package com.tm.todoapp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tm.todoapp.dao.impl.TaskDAO;
import com.tm.todoapp.model.Page;
import com.tm.todoapp.model.PagePayload;
import com.tm.todoapp.model.Task;
import com.tm.todoapp.util.CommonUtils;

/**
 * The TaskController. It holds APIs which performs CRUD operations on tasks
 * information.
 */
@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TaskController {

	/**
	 * The autowired task DAO
	 */
	@Autowired
	TaskDAO taskDAO;

	/**
	 * API to create new task
	 * 
	 * @param task The task
	 * @return The insertion status
	 */
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createTask(@RequestBody Task task) {

		// Validating the task
		if (StringUtils.isBlank(task.getTitle()) || task.getStartTime() == null) {
			return CommonUtils.preconditionFailedResponse("The title and startTime are mandatory fields");
		}
		if (task.getStartTime() < 0) {
			return CommonUtils.badRequestResponse("The startTime cannot be negative");
		}

		// Adding the task
		taskDAO.addTask(task);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * API to delete the task with specified ID
	 * 
	 * @param taskId The task ID
	 * @return The deletion status
	 */
	@DeleteMapping(value = "/{task-id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTask(@PathVariable(value = "task-id", required = true) Integer taskId) {

		boolean isDeleted = taskDAO.deleteTask(taskId);
		if (!isDeleted) {
			return CommonUtils.badRequestResponse("No task is present with this ID");
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * API to edit a task
	 * 
	 * @param task The task
	 * @return The updation status
	 */
	@PutMapping(value = "/{task-id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTask(@PathVariable(value = "task-id", required = true) Integer taskId,
			@RequestBody Task task) {

		// Validating the task
		if (StringUtils.isBlank(task.getTitle()) || task.getStartTime() == null) {
			return CommonUtils.preconditionFailedResponse("The title and startTime are mandatory fields");
		}
		if (task.getStartTime() < 0) {
			return CommonUtils.badRequestResponse("The startTime cannot be negative");
		}

		// Adding the task
		boolean isUpdated = taskDAO.editTask(taskId, task);
		if (!isUpdated) {
			return CommonUtils.badRequestResponse("No task is present with this ID");
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTasks(@RequestBody PagePayload payload) {

		// Validating the payload
		if (payload.getPageNumber() == null || payload.getPageNumber() < 0) {
			payload.setPageNumber(1);
		}
		if (payload.getPageSize() == null || payload.getPageSize() < 0) {
			payload.setPageSize(Integer.MAX_VALUE);
		}
		if (StringUtils.isBlank(payload.getSortField())) {
			payload.setSortField("task_id");
			payload.setSortOrder("descend");
		}
		if (StringUtils.isBlank(payload.getSortOrder()) || !payload.getSortOrder().matches("^(ascend|descend)$")) {
			payload.setSortOrder("descend");
		}

		// Getting the page response
		Page<Task> pageResponse = taskDAO.getTasks(payload);
		return new ResponseEntity<>(pageResponse, HttpStatus.OK);
	}
}
