# review_portal

db: mysql
db-name: review-portal

PROD-PROFILE:To build war file which can be deployed in external tomcat
------------------------------------------------------------
1. Go to ~review_portal\review-portal\review-portal-server
2. mvn clean install -Pprod
3. war file be generated in review-portal-rest\target
4. Deploy war in tomcat
5. http://localhost:8080/review-portal-web/swagger-ui.html

DEV-PROFILE:To build jar file which can be run as a standalone
------------------------------------------------------------
1. Go to ~review_portal\review-portal\review-portal-server
2. mvn clean install -Pdev
3. jar file be generated in review-portal-rest\target
4. Start the application using command java -jar -Dspring.profiles.active=prod review-portal-web.jar
5. http://localhost:8080/swagger-ui.html


Sample input for Member registeration[Professionals]
---------------------------------------------------------------
{
  "address": {
    "address": "Malik Tower",
    "city": "Deira",
    "country": "AE",
    "state": "Dubai",
    "zip": "695589"
  },
  "dateofBirth": "2017-08-04T09:46:55.693Z",
  "membershipType": "OFFICIAL",
  "mobile": "+97152XXXXX12",
  "name": "Dinil V",
  "profession": {
    "title": "DENTIST"
  },
  "user": {
    "displayPicture": "897FFF9979797",
    "email": "dinil.v@gmail.com",
    "name": "Dinil V",
    "password": "12345",
    "telephone": "+9715255XXXXXX",
    "username": "dinil.v"
  }
}

Sample input for Member registeration[Review Writer]
---------------------------------------------------------------
{
  "address": {
    "address": "Hiltop Tower",
    "city": "Deira",
    "country": "AE",
    "state": "Abudhabi",
    "zip": "767867"
  },
  "dateofBirth": "2017-08-04T09:46:55.693Z",
  "mobile": "+97152XXXXX12",
  "name": "Marcin Firla",
  "user": {
    "displayPicture": "3423423",
    "email": "marcin.firla@gmail.com",
    "name": "Marcin Firla",
    "password": "12345",
    "telephone": "+9715255XXXXXX",
    "username": "marcin.firla"
  }
}
