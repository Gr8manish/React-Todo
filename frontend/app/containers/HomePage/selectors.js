import { createSelector } from 'reselect';
import { initialState } from './reducer';

/**
 * Direct selector to the homePage state domain
 */

const selectHomePageDomain = state => state.homePage || initialState;

/**
 * Other specific selectors
 */

/**
 * Default selector used by homePage
 */

const makeSelecthomePage = () =>
  createSelector(
    selectHomePageDomain,
    substate => substate,
  );

export default makeSelecthomePage;
export { selectHomePageDomain as selecthomePageDomain };
