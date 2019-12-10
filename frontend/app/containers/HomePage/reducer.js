/*
 *
 * TodoItem reducer
 *
 */
import produce from 'immer';
import {
  SUCCESS_FETCH_TODOS,
  PAGE_SIZE,
  SET_PAGE_NUMBER,
  START_TABLE_LOADING,
  STOP_TABLE_LOADING,
  SET_CURRENT_REQUEST_BODY,
  OPEN_FORM,
  CLOSE_FORM,
} from './constants';

export const initialState = {
  data: [],
  tableLoading: true,
  open: false,
  currentRequestBody: {
    pageNumber: 1,
  },
  pagination: {
    pageSize: PAGE_SIZE,
  },
};

/* eslint-disable default-case, no-param-reassign */
const homePageReducer = (state = initialState, action) =>
  produce(state, draft => {
    switch (action.type) {
      case SUCCESS_FETCH_TODOS:
        draft.data = action.data.data;
        draft.pagination.total = action.data.totalCount;
        break;
      case SET_PAGE_NUMBER:
        draft.pagination.current = action.data;
        break;
      case START_TABLE_LOADING:
        draft.tableLoading = true;
        break;
      case STOP_TABLE_LOADING:
        draft.tableLoading = false;
        break;
      case SET_CURRENT_REQUEST_BODY:
        draft.currentRequestBody = action.data;
        break;
      case OPEN_FORM:
        draft.open = true;
        break;
      case CLOSE_FORM:
        draft.open = false;
        break;
    }
  });

export default homePageReducer;
