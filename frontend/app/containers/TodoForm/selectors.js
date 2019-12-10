import { createSelector } from 'reselect';
import { initialState } from './reducer';

/**
 * Direct selector to the todoForm state domain
 */

const selectTodoFormDomain = state => state.todoForm || initialState;

/**
 * Other specific selectors
 */

/**
 * Default selector used by TodoForm
 */

const makeSelectTodoForm = () =>
  createSelector(
    selectTodoFormDomain,
    substate => substate,
  );

export default makeSelectTodoForm;
export { selectTodoFormDomain };
