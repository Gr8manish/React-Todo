CREATE TABLE tasks 
  ( 
     task_id     SERIAL PRIMARY KEY, 
     title       VARCHAR(100), 
     description VARCHAR(100), 
     start_time  NUMERIC 
  ); 