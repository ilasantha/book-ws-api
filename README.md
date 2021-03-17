# Spring Boot RESTful Service for Book
The application has 2 domain model named "**Book**" and "**BookDetails**" and expose Rest end point to show case, 

- Rest API with HTTP method GET to get the Book information by its unique ISBN no. The HTTP response is in JSON format.
- Rest API with HTTP method POST to handle the new entry of Book. The HTTP request and response are in JSON format.


## Guides
The following guides illustrates how to build, install and run certain features concretely:

### Pre-Requirties 

1. JDK 1.8 or higer
2. Maven 3 or higer
3. GitBash or Curl Command line tool

### Donlowding the Code
Get the repository:

$ git clone <https://gitlab.com/Lasantha_Harris/digital-java-code-assignment-v1.git>


### Building the Application
To build the application:

From the command line with Maven:

$ cd digital-java-code-assignment-v1\book-api

$ build.bat 

### Running Unit Tests
$ runTest.bat 


### Running the Application

$ run.bat

App will start on port 8081 and can access from web browser: <http://localhost8081/books/> (This will shows all available books)


Existing *Book* information can be access through   

<http://localhost:8081/books/45-124>

<http://localhost:8081/books/67-8656>

													


### Testing the APIs
From the command line of GitBash or Curl:

* GET request to retrieve all available *Books* 
										
	curl -i http://localhost:8081/books/

* GET request to retrieve *Book* information for ISBN (Book Summary)
										
	curl -i http://localhost:8081/books/67-8656

* GET request to retrieve *Book* information for ISBN (Full Book Details)

	curl -i http://localhost:8081/books/45-124
	
* GET request to retrieve *Book* information for Invalid ISBN 
	
	curl -i http://localhost:8081/books/bad
	
* POST request to save *Book* information(Only mandatory field, ISBN, Title and Author filled)

	curl -d '{"isbn":"96-23","title":"Spring Boot","authour":"Spring Boot Guru"}' -H "Content-Type: application/json"   http://localhost:8081/books/
	
* POST request to save *Book* information(Mandatory field Author is missing)

	curl -d '{"isbn":"34-898","title":"Spring Boot"}' -H "Content-Type: application/json"   http://localhost:8081/books/

* POST request to save *Book* and *Book Details" information

	curl -d '{"isbn":"978-1785285714","title":"Building a RESTful Web Service with Spring","authour":"Ludovic Dewailly","price":"$44.99","details":{"description":"A hands-on guide to building an enterprise-grade, scalable RESTful web service using the Spring Framework","publishedDate":"October 14, 2015","lanuage":"English","noOfPages":115,"publisher":"Packt Publishing"}}' -H "Content-Type: application/json"   http://localhost:8081/books/

