# URL Shortener Service (Spring Boot)

A simple URL Shortener REST API built using **Java and Spring Boot**.  
This application allows users to shorten long URLs, redirect using short URLs, and view domain-based usage metrics.

---

## Features

- Shorten long URLs via REST API
- Returns the **same short URL** if the original URL already exists
- Redirects short URL to the original URL
- Stores data **in-memory**
- Metrics API to get **top 3 most shortened domains**
- Thread-safe implementation
- Unit test ready
- Docker support

---

## Tech Stack

- Java 17+
- Spring Boot
- REST APIs
- ConcurrentHashMap (In-Memory Store)
- Maven
- Docker (Optional)

---

## Project Structure

src/main/java
└── com.infracloud.url_shortener
├── controller
│ ├── UrlShortenerController.java
│ └── RedirectController.java
├── service
│ └── UrlShortenerService.java
├── store
│ └── UrlStore.java
├── util
│ └── ShortCodeGenerator.java
└── UrlShortenerApplication.java

yaml
Copy code

---

## API Endpoints

### Shorten URL

**POST** `/api/shorten`

**Request Body**
```json
{
  "url": "https://www.youtube.com/watch?v=abcd"
}
Response

json
Copy code
{
  "shortUrl": "http://localhost:8080/abc123"
}
If the same URL is requested again, the existing short URL is returned.

2] Redirect to Original URL
GET /{shortCode}

Example

bash
Copy code
http://localhost:8080/abc123
--> Redirects to:

arduino
Copy code
https://www.youtube.com/watch?v=abcd
3] Metrics API
GET /api/metrics

Response

json
Copy code
{
  "udemy.com": 6,
  "youtube.com": 4,
  "wikipedia.org": 2
}
Returns top 3 domains shortened the most.

Running the Application
Run Locally
bash
Copy code
mvn clean install
mvn spring-boot:run
Application runs on:

arduino
Copy code
http://localhost:8080
 Docker (Bonus)
Build Image
bash
Copy code
docker build -t url-shortener .
Run Container
bash
Copy code
docker run -p 8080:8080 url-shortener

Testing
bash
Copy code
mvn test
Unit tests ensure:

Same URL returns same short code

Redirection works correctly

Metrics calculation is accurate

Limitations
Data is stored in-memory (will reset on restart)

No authentication or rate limiting

Not production-ready (demo/assignment purpose)

Author
Ganesh Kamble
Java Full Stack Developer
 Pune, India
