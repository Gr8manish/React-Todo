/**
 *
 * TodoFormModel
 *
 */

import React from 'react';
import { Fade, Modal, Backdrop } from '@material-ui/core';
import TodoForm from 'containers/TodoForm';

import styles from './styles.scss';

function TodoFormModel({ open, handleClose, ...rest }) {
  return (
    <Modal
      open={open}
      onClose={handleClose}
      closeAfterTransition
      BackdropComponent={Backdrop}
      BackdropProps={{
        timeout: 500,
      }}
    >
      <Fade in={open}>
        <TodoForm {...rest} />
      </Fade>
    </Modal>
  );
}

TodoFormModel.propTypes = {};

export default TodoFormModel;
