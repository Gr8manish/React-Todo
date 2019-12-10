import { takeEvery, put, fork } from 'redux-saga/effects';
import axios from 'axios';
import { BASE_URL } from 'properties';
import { successToast, errorToast } from 'utils/toast';
import {
  refreshTableAction,
  startTableLoadingAction,
  stopTableLoadingAction,
  closeFormAction,
} from 'containers/HomePage/actions';
import { START_ADD_TODO, START_EDIT_TODO } from './constants';

// Individual exports for testing
export default function* todoFormSaga() {
  yield fork(watchStartAddTodo);
  yield fork(watchStartEditTodo);
}

function* watchStartAddTodo() {
  yield takeEvery(START_ADD_TODO, addTodo);
}

function* watchStartEditTodo() {
  yield takeEvery(START_EDIT_TODO, editTodo);
}

function* addTodo(data) {
  yield put(closeFormAction());
  yield put(startTableLoadingAction());
  try {
    yield axios.post(`${BASE_URL}/todo`, data.data);
    successToast('Todo added successfully.');
    yield put(refreshTableAction());
  } catch (error) {
    yield put(stopTableLoadingAction());
    errorToast('Error occurred while adding new todo!!');
  }
}

function* editTodo(data) {
  yield put(closeFormAction());
  yield put(startTableLoadingAction());
  try {
    yield axios.put(`${BASE_URL}/todo/${data.data.taskId}`, data.data);
    successToast('Todo updated successfully.');
    yield put(refreshTableAction());
  } catch (error) {
    yield put(stopTableLoadingAction());
    errorToast('Error occurred while updating todo!!');
  }
}
