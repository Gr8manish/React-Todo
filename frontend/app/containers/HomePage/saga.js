import { takeEvery, fork, put, select } from 'redux-saga/effects';
import axios from 'axios';
import { BASE_URL } from 'properties';
import { successToast, errorToast } from 'utils/toast';

import {
  START_FETCH_TODOS,
  DELETE_TODO,
  PAGE_SIZE,
  REFRESH_TABLE,
} from './constants';
import {
  successFetchTodosAction,
  startTableLoadingAction,
  stopTableLoadingAction,
  refreshTableAction,
  closeFormAction,
  startFetchTodosAction,
} from './actions';

// Individual exports for testing
export default function* homePageSaga() {
  yield fork(watchStartFetchTodos);
  yield fork(watchDeleteTodo);
  yield fork(watchRefreshTable);
}

function* watchStartFetchTodos() {
  yield takeEvery(START_FETCH_TODOS, startFetching);
}

function* watchDeleteTodo() {
  yield takeEvery(DELETE_TODO, deleteTodo);
}

function* watchRefreshTable() {
  yield takeEvery(REFRESH_TABLE, refreshTable);
}

function* startFetching(data) {
  yield put(startTableLoadingAction());
  try {
    const response = yield axios.post(`${BASE_URL}/todo/list`, {
      pageSize: PAGE_SIZE,
      ...data.data,
    });
    yield put(successFetchTodosAction(response.data));
  } catch (error) {
    errorToast('Error occurred while fetching todo list!!');
  }
  yield put(stopTableLoadingAction());
}

function* deleteTodo({ taskId }) {
  yield put(startTableLoadingAction());
  try {
    yield axios.delete(`${BASE_URL}/todo/${taskId}`);
    successToast('Todo deleted successfully!!');
  } catch (error) {
    errorToast('Error occurred while deleting todo!!');
  }

  yield put(refreshTableAction());
}

function* refreshTable() {
  yield put(closeFormAction());

  const currentRequestBody = yield select(
    state => state.homePage.currentRequestBody,
  );
  yield put(startFetchTodosAction(currentRequestBody));
}
