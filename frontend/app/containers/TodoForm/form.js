import React from 'react';
import { withFormik, Form } from 'formik';
import {
  FormControl,
  InputLabel,
  OutlinedInput,
  Button,
  FormHelperText,
} from '@material-ui/core';
import { DateTimePicker, MuiPickersUtilsProvider } from '@material-ui/pickers';
import MomentUtils from '@date-io/moment';
import { closeFormAction } from 'containers/HomePage/actions';
import { string, object } from 'yup';
import { startEditTodoAction, startAddTodoAction } from './actions';

function CustomForm({
  values,
  touched,
  errors,
  isSubmitting,
  handleChange,
  setFieldValue,
}) {
  return (
    <Form className="form">
      <FormControl variant="outlined">
        <InputLabel htmlFor="title">Title</InputLabel>
        <OutlinedInput
          id="title"
          value={values.title}
          onChange={handleChange}
          error={touched.title && Boolean(errors.title)}
        />
        <FormHelperText>{touched.title ? errors.title : ''}</FormHelperText>
      </FormControl>
      <FormControl variant="outlined">
        <InputLabel htmlFor="description">Description</InputLabel>
        <OutlinedInput
          id="description"
          value={values.description}
          onChange={handleChange}
          error={touched.title && Boolean(errors.description)}
        />
        <FormHelperText>
          {touched.description ? errors.description : ''}
        </FormHelperText>
      </FormControl>

      <MuiPickersUtilsProvider utils={MomentUtils}>
        <DateTimePicker
          label="Start at"
          inputVariant="outlined"
          value={values.startAt}
          onChange={val => setFieldValue('startAt', val)}
          disablePast
        />
      </MuiPickersUtilsProvider>

      <div className="save-edit-btn">
        <Button
          disabled={isSubmitting}
          type="submit"
          variant="contained"
          color="primary"
        >
          Save
        </Button>
        <Button
          disabled={isSubmitting}
          variant="contained"
          onClick={() => values.dispatch(closeFormAction())}
        >
          Close
        </Button>
      </div>
    </Form>
  );
}

const Formik = withFormik({
  mapPropsToValues: ({ title, description, startAt, dispatch }) => ({
    title: title || '',
    description: description || '',
    startAt: startAt || new Date(),
    dispatch,
  }),

  validationSchema: object().shape({
    title: string().required('Title is required'),
    description: string().required('Description is required'),
    startAt: object().required('Start time is required'),
  }),

  handleSubmit: (values, { props }) => {
    const data = {
      title: values.title,
      description: values.description,
      startTime: values.startAt.valueOf(),
    };

    if (props.type === 'Add') {
      props.dispatch(startAddTodoAction(data));
    } else if (props.type === 'Edit') {
      data.taskId = props.taskId;
      props.dispatch(startEditTodoAction(data));
    }
  },
})(CustomForm);

export default Formik;
