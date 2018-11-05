# Client Stack Rest API

This is a Rest API that I built using Java Spring & Maven for one of my final projects at the [CareerDevs Computer Science Academy](http://careerdevs.com/).  
The front end for this project was built with Angular and can be found at;
https://github.com/wiltrahan/client-stack

## Technolgies Used
* Java 8
* Spring Framework
* Maven
* Jackson
* MYSQL
* Hibernate


## Open Endpoints

* **URL**: /api/clients
* **METHOD**: GET
* **RESULT**: Retrieves all clients from database
- - - -
* **URL**: /api/clients/{clientId}
* **METHOD**: GET
* **RESULT**: Retrieves individual client from database
- - - -
* **URL**: /api/clients
* **METHOD**: POST
* **RESULT**: Adds new client to database
- - - -
* **URL**: /api/clients
* **METHOD**: PUT
* **RESULT**: Update client in database
- - - -
* **URL**: /api/clients/{clientId}
* **METHOD**: DELETE
* **RESULT**: Deletes individual client from database
- - - -
