/*
 * HomePage
 *
 * This is the first thing users see of our App, at the '/' route
 *
 */

import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';
import { Fab } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import { Table, Button, Divider } from 'antd';
import moment from 'moment';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import Header from 'components/Header';
import TodoFormModel from 'components/TodoFormModel';

import { useInjectSaga } from 'utils/injectSaga';
import { useInjectReducer } from 'utils/injectReducer';
import 'antd/dist/antd.css';
import styles from './style.scss';
import makeSelectHomePage from './selectors';
import reducer from './reducer';
import saga from './saga';
import {
  startFetchTodosAction,
  deleteTodoAction,
  setPageNumber,
  setCurrentRequestBodyAction,
  openFormAction,
  closeFormAction,
} from './actions';

function HomePage({ state, dispatch }) {
  useInjectReducer({ key: 'homePage', reducer });
  useInjectSaga({ key: 'homePage', saga });

  const [formHeader, setFormHeader] = useState('Add');
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [startAt, setStartAt] = useState(moment());
  const [taskId, setTaskId] = useState(moment());

  const onAddBtnClick = () => {
    setFormHeader('Add');
    setTitle('');
    setDescription('');
    setStartAt(moment());
    dispatch(openFormAction());
  };

  const handleClose = () => {
    dispatch(closeFormAction());
  };

  useEffect(() => {
    dispatch(
      startFetchTodosAction({
        pageNumber: 1,
      }),
    );
  }, []);
  //
  const columns = [
    {
      title: 'Title',
      dataIndex: 'title',
      key: 'title',
      sortDirections: ['descend', 'ascend'],
      sorter: () => {},
    },
    {
      title: 'Description',
      dataIndex: 'description',
      key: 'description',
      sorter: () => {},
      sortDirections: ['descend', 'ascend'],
    },
    {
      title: 'Start at',
      dataIndex: 'startTime',
      key: 'start_time',
      sorter: () => {},
      sortDirections: ['descend', 'ascend'],
      render: data => moment(data).format('llll'),
    },
    {
      title: 'Action',
      key: 'action',
      render: data => (
        <span>
          <Button
            type="link"
            onClick={() => {
              setFormHeader('Edit');
              setTitle(data.title);
              setDescription(data.description);
              setStartAt(moment(data.startTime));
              setTaskId(data.taskId);
              dispatch(openFormAction());
            }}
          >
            Edit
          </Button>
          <Divider type="vertical" />
          <Button
            type="link"
            onClick={() => {
              dispatch(deleteTodoAction({ taskId: data.taskId }));
            }}
          >
            Delete
          </Button>
        </span>
      ),
    },
  ];

  const handleTableChange = (pagination, filters, sorter) => {
    dispatch(setPageNumber(pagination.current));
    const data = {
      pageNumber: pagination.current,
      sortField: sorter.columnKey,
      sortOrder: sorter.order,
    };

    dispatch(setCurrentRequestBodyAction(data));
    dispatch(startFetchTodosAction(data));
  };

  return (
    <section className={styles.todo}>
      <Header />
      <div className={styles.body}>
        <div className={styles.addBtn}>
          <Fab color="primary" aria-label="add" onClick={onAddBtnClick}>
            <AddIcon />
          </Fab>
        </div>
        <Table
          columns={columns}
          rowKey={record => record.taskId}
          dataSource={state.data}
          pagination={state.pagination}
          loading={state.tableLoading}
          onChange={handleTableChange}
          className={styles.todoTable}
        />
      </div>
      <TodoFormModel
        open={state.open}
        handleClose={handleClose}
        formHeader={formHeader}
        title={title}
        description={description}
        startAt={startAt}
        taskId={taskId}
      />

      <ToastContainer
        position="top-right"
        autoClose={2000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnVisibilityChange
        draggable
        pauseOnHover
      />
    </section>
  );
}

const mapStateToProps = createStructuredSelector({
  state: makeSelectHomePage(),
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

export default compose(withConnect)(HomePage);
