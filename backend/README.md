#### There are 4 APIs in TODO App. The following are the details:

#### 1. Add new task
- URI: /taskmanager/api/v1/todo
- Method: POST
- Sample request body:
```json
        {
            "title":"Participate in Marathon",
            "description":"Just go for it!",
            "startTime":1573139044000,

        }
```
- #### Validations:
  - The title and startTime are mandatory fields

_Note: An incremental task ID would be assigned to each new task_


#### 2. Delete the task
- URI: /taskmanager/api/v1/todo/{task-id}
- Method: DELETE
- #### Validations:
  - The task-id must be present in the DB    


#### 3. Edit existing task
- URI: /taskmanager/api/v1/todo/{task-id}
- Method: PUT
- Sample request body:
```json
        {
            "title":"Participate in Marathon again",
            "description":"Just go for it!",
            "startTime":1573149044000
        }
```   
- #### Validations:
  - The title and startTime are mandatory fields
  - The task-id must be present in the DB    

#### 4. Get list of tasks (paginated)
- URI: /taskmanager/api/v1/todo/list
- Method: POST
- Sample request body:
```json
        {
          "pageSize":10,
          "pageNumber":1,
          "sortField":"start_time",
          "sortOrder":"descend"
        }
```
- Sample response:
```json
        {
            "tasks":[
                {
                    "taskId":1,
                    "title":"Participate in Marathon again",
                    "description":"Just go for it!",
                    "startTime":1573149044000
                },
            ],
            "totalCount":100
        }
```            
      

- #### Validations:
  - If pageNumber is not sent or is negative, it will be set to 1
  - If pageSize is not sent or is negative, all records will be sent
  - If sortField is not sent, it will be set to 'date'. Otherwise, it should be either 'title' or 'date'
  - If sortOrder is not sent or non in 'ascend' or 'descend', it will be set to 'descend'

#### Note: The error response for each API would be in this format
```json
    {
        "error":"This error occurred"
    }
```
