# 🌦️ Weather App - Spring Boot REST API

A **Spring Boot** based RESTful API to manage and update weather information for different cities. 
Users can **upload**, **update**, and **view** weather conditions including **Sunny**, **Rainy**, **Cloudy**, and **Temperature** details.

---

## ✅ Features

- 📍 Add weather information by city name.
- ☁️ Supported weather conditions:
  - Sunny
  - Rainy
  - Cloudy
- 🌡️ Temperature (in °C).
- 🔄 Update existing weather data.
- 📥 Fetch current weather for any city.
- 📃 REST API with clean JSON responses.

---

## 🏗️ Technology Stack

- **Spring Boot**
- **Postman**
- **Spring Data JPA**
- **MySQL**
- **RESTful API**

---

## 🧾 Weather Entity

```java
{
  "city": "Jaipur",
  "condition": "SUNNY",
  "temperature": 35.2
}

