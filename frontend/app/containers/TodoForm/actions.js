/*
 *
 * TodoForm actions
 *
 */

import {
  START_ADD_TODO,
  SUCCESS_ADD_TODO,
  START_EDIT_TODO,
  SUCCESS_EDIT_TODO,
} from './constants';

export function startAddTodoAction(data) {
  return {
    type: START_ADD_TODO,
    data,
  };
}

export function successAddTodoAction() {
  return {
    type: SUCCESS_ADD_TODO,
  };
}

export function startEditTodoAction(data) {
  return {
    type: START_EDIT_TODO,
    data,
  };
}

export function successEditTodoAction() {
  return {
    type: SUCCESS_EDIT_TODO,
  };
}
