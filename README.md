# Kafka Microservices POC

This is a simple Spring Boot microservices proof-of-concept that demonstrates asynchronous communication using **Apache Kafka**, running locally via Docker.

---

## ✨ Objectives

- Implement two independent microservices: `Producer` and `Consumer`.
- Facilitate communication between them using Kafka topics.
- Run Kafka in Docker

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Apache Kafka
- Spring Kafka
- Maven
- Docker & Docker Compose

---

## ⚙️ Prerequisites

Before you begin, make sure you have:

- Java 17 installed
- Maven installed
- Docker Desktop running
- Postman or cURL (to test the API)

---

## 🐳 Start Kafka & Zookeeper via Docker

Use the included `docker-compose.yml` file:

```bash
docker-compose up -d
```

Kafka runs at `localhost:9092`  
Zookeeper runs at `localhost:2181`

Kafka topics will be auto-created.

---

## 🚀 How to Run the Microservices

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/kafka-microservices-poc.git
cd kafka-microservices-poc
```

### 2. Start the Consumer

```bash
cd message-consumer
mvn spring-boot:run
```

> 🟢 Runs on port **8081**

---

### 3. Start the Producer

```bash
cd ../message-producer
mvn spring-boot:run
```

> 🟢 Runs on port **8080**

---

## 📬 Test the Flow with Postman or curl

### 🔸 Endpoint

**POST** `http://localhost:8080/api/send`  
**Body (raw text):**

```
hello
```

**Header:**
```
Content-Type: text/plain
```

---

## 🔄 Expected Flow

1. **Producer** sends `"hello"` to Kafka topic `hello-topic`
2. **Consumer** receives the message:
   ```
   Consumer received: hello
   Consumer sent: hello World
   ```
3. **Producer** receives the response:
   ```
   Producer sent: hello
   Producer received: hello World
   ```

---

## ✅ Summary

- `message-producer` POSTs messages via Kafka.
- `message-consumer` listens and responds.
- Kafka handles the message pipeline in between.
- Fully runs locally using Docker and Spring Boot.
