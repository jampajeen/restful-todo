========================
API Reference
========================

This is an API documentation. The REST API lives at the ``/restful-todo/api/`` endpoint which depends on your application server configuration, for example http://localhost:8080/restful-todo/api/ 

This API requires no authentication.

Common Request/Response 
------------------------------

Request
~~~~~~~~~~~~~~~

The request parameters of each service operation are different. (You can see how to use them in `Service Operation section`) 

Response
~~~~~~~~~~~~~~~

The successful response has format by following

.. code-block:: js

    {
    	"data": {data object}, //This parameter is optional, it can be both a single todo or list of todos
    	"success": true,
    	"message": description text
    }
    
    
Data object
~~~~~~~~~~~~~~~

=================   =================   ==================
Param               Type                Description
=================   =================   ==================
id             		Long              	Unique ID of todo item
subject             String              Subject
detail              String              Text or detail
targetdatetime      Datetime            Target datetime in format ``yyyy-MM-dd HH:mm:ss``
status              String              Status of todo ``pending`` or ``done``
=================   =================   ==================

    
Example of successful response with single todo object   

.. code-block:: js

    {"data":{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"pending"},"success":true,"message":"Add item successfully"}

Example of successful response with list of todos   

.. code-block:: js

    {"data":[{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"done"},{"id":2,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"pending"}],"success":true,"message":"Search items successfully"}



The error response has format by following

.. code-block:: js

    {
    	"success": false,
    	"message": an error message
    }

Example of error response

.. code-block:: js

    {"success":false,"message":"Error occur, cannot update status of an item id = 1"}



Service Operations 
--------

Add
~~~~~~~~~~~~~~~

Add new todo task

.. code-block:: js

   POST /restful-todo/api/todos/add

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

=================   =================   ==================
Param               Type                Description
=================   =================   ==================
subject             String              Subject
detail              String              Text or detail
targetdatetime      Datetime            Target datetime in format ``yyyy-MM-dd HH:mm:ss``
status              String              Status of todo ``pending`` or ``done``
=================   =================   ==================

Example

.. code-block:: js

   {"subject":"my todo", "detail":"my desc", "targetdatetime":"2016-10-11 01:01:01", "status": "pending"}

Successful response 
~~~~~~~~~~~~~~~

Response with single Todo data object

Example

.. code-block:: js

    {"data":{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"pending"},"success":true,"message":"Add item successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot add an item."}
      
        
--------

Search all
~~~~~~~~~~~~~~~

List all todos 

.. code-block:: js

   GET /restful-todo/api/todos

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

``N/A``

Successful response 
~~~~~~~~~~~~~~~

Response with list of Todo data object

Example

.. code-block:: js

    {"data":[{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"done"},{"id":2,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"pending"}],"success":true,"message":"Search items successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot find items."}
   
   
--------

Search by ID
~~~~~~~~~~~~~~~

Get todo item by ID

.. code-block:: js

   GET /restful-todo/api/todos/:id

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

``N/A``

Successful response
~~~~~~~~~~~~~~~

Response with single Todo data object

Example

.. code-block:: js

    {"data":{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"pending"},"success":true,"message":"Search item successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot find an item id = 1"}
      
--------

Edit by ID
~~~~~~~~~~~~~~~

Edit todo item by ID

.. code-block:: js

   PUT /restful-todo/api/todos/:id/edit

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

=================   =================   ==================
Param               Type                Description
=================   =================   ==================
subject             String              Subject
detail              String              Text or detail
targetdatetime      Datetime            Target datetime in format ``yyyy-MM-dd HH:mm:ss``
status              String              Status of todo ``pending`` or ``done``
=================   =================   ==================

Example

.. code-block:: js

   {"subject":"my todo", "detail":"my desc", "targetdatetime":"2016-10-11 01:01:01", "status": "pending"}

Successful response
~~~~~~~~~~~~~~~

Response with single Todo data object

Example

.. code-block:: js

    {"data":{"id":1,"subject":"my edited todo","detail":"my edited desc","targetdatetime":"2016-10-11 02:00:00","status":"pending"},"success":true,"message":"Edit item successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot edit an item id = 1"}
   
      
--------

Update status by id
~~~~~~~~~~~~~~~

Update Todo status by ID

.. code-block:: js

   PUT /restful-todo/api/todos/:id/status

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

=================   =================   ==================
Param               Type                Description
=================   =================   ==================
subject             String              Subject
detail              String              Text or detail
targetdatetime      Datetime            Target datetime in format ``yyyy-MM-dd HH:mm:ss``
status              String              Status of todo ``pending`` or ``done``
=================   =================   ==================

Example

.. code-block:: js

   {"status":"done"}

Successful response
~~~~~~~~~~~~~~~

Response with single Todo data object

Example

.. code-block:: js

    {"data":{"id":1,"subject":"my todo","detail":"my desc","targetdatetime":"2016-10-11 01:01:01","status":"done"},"success":true,"message":"Update item status successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot update status of an item id = 1"}
   
--------

Delete by id
~~~~~~~~~~~~~~~

Delete todo item by ID

.. code-block:: js

   DELETE /restful-todo/api/todos/:id/delete

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

``N/A``

Successful response
~~~~~~~~~~~~~~~

Response with single Todo data object

Example

.. code-block:: js

  {"success":true,"message":"Delete item successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

  {"success":false,"message":"Error occur, cannot delete an item id = 1"}


--------

Delete all
~~~~~~~~~~~~~~~

Delete all todos 

.. code-block:: js

   DELETE /restful-todo/api/todos/delete

Request 
~~~~~~~~~~~~~~~

Parameters
+++++

``N/A``

Successful response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

  {"success":true,"message":"Delete items successfully"}

Error response
~~~~~~~~~~~~~~~

Example

.. code-block:: js

	{"success":false,"message":"Error occur, cannot delete items"}
   
