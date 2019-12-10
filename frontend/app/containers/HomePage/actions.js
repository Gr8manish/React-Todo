/*
 *
 * TodoItem actions
 *
 */

import {
  START_FETCH_TODOS,
  SUCCESS_FETCH_TODOS,
  FAIL_FETCH_TODOS,
  ADD_TODO,
  DELETE_TODO,
  UPDATE_TODO,
  SET_PAGE_NUMBER,
  START_TABLE_LOADING,
  STOP_TABLE_LOADING,
  SET_CURRENT_REQUEST_BODY,
  REFRESH_TABLE,
  OPEN_FORM,
  CLOSE_FORM,
} from './constants';

export function startFetchTodosAction(data) {
  return {
    type: START_FETCH_TODOS,
    data,
  };
}

export function successFetchTodosAction(data) {
  return {
    type: SUCCESS_FETCH_TODOS,
    data,
  };
}

export function failFetchTodosAction() {
  return {
    type: FAIL_FETCH_TODOS,
  };
}

export function startTableLoadingAction() {
  return {
    type: START_TABLE_LOADING,
  };
}

export function stopTableLoadingAction() {
  return {
    type: STOP_TABLE_LOADING,
  };
}

export function addTodoAction() {
  return {
    type: ADD_TODO,
  };
}

export function deleteTodoAction({ taskId }) {
  return {
    type: DELETE_TODO,
    taskId,
  };
}

export function updateTodoAction() {
  return {
    type: UPDATE_TODO,
  };
}

export function setPageNumber(data) {
  return {
    type: SET_PAGE_NUMBER,
    data,
  };
}

export function setCurrentRequestBodyAction(data) {
  return {
    type: SET_CURRENT_REQUEST_BODY,
    data,
  };
}

export function refreshTableAction() {
  return {
    type: REFRESH_TABLE,
  };
}

export function openFormAction() {
  return {
    type: OPEN_FORM,
  };
}

export function closeFormAction() {
  return {
    type: CLOSE_FORM,
  };
}
