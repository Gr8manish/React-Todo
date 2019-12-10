/**
 *
 * TodoForm
 *
 */

import React from 'react';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';
import { Paper } from '@material-ui/core';

import { useInjectSaga } from 'utils/injectSaga';
import { useInjectReducer } from 'utils/injectReducer';
import makeSelectTodoForm from './selectors';
import reducer from './reducer';
import saga from './saga';
import './styles.scss';
import Form from './form';

export function TodoForm({
  title,
  description,
  startAt,
  formHeader,
  dispatch,
  taskId,
}) {
  useInjectReducer({ key: 'todoForm', reducer });
  useInjectSaga({ key: 'todoForm', saga });

  return (
    <Paper className="model-container">
      <h2>{formHeader} todo</h2>
      <Form
        type={formHeader}
        title={title}
        description={description}
        startAt={startAt}
        dispatch={dispatch}
        taskId={taskId}
      />
    </Paper>
  );
}

const mapStateToProps = createStructuredSelector({
  todoForm: makeSelectTodoForm(),
});

function mapDispatchToProps(dispatch) {
  return {
    dispatch,
  };
}

const withConnect = connect(
  mapStateToProps,
  mapDispatchToProps,
);

export default compose(withConnect)(TodoForm);
