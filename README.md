# bookapp

Book - Clojure CRUD app with REST service and Bootstrap.

## Usage

There is also book.sql file with some dummy data that needs to be imported.

To start a web server for the application, run:
```
lein ring server
```

####REST service

http://localhost:3000/api/all - This will get all users from database and display it as JSON.

Example:

```JSON
[
{
"id": 4,
"title": "Implementation patterns",
"description": "Book about Java implementation patterns.",
"author": "Kent Back",
"isbn": "1234561278"
},
{
"id": 5,
"title": "Clojure for the Brave and True",
"description": "Learn the ultimate language and become a better programmer",
"author": "Daniel Higginbotham",
"isbn": "1111853456"
},
{
"id": 6,
"title": "The Clean Code",
"description": "Uncle Bob best book.",
"author": "Robert C. Martin",
"isbn": "3115671127"
},
{
"id": 7,
"title": "Refactoring: Improving the Design of Existing Code",
"description": "Martin Flowere about how to refactor the code.",
"author": "Martin Flower",
"isbn": "1236584890"
}
]
```
## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
