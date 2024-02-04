# Java Spring RESTful API for Product Management

This project is a simple RESTful API developed using Java Spring for managing products in a store. Each product has the following attributes:

- Identifier (id)
- Product name (name)
- Product description (description)
- Price (price)
- Quantity in stock (quantity)

## Features

The API supports the following operations:

- Retrieving a list of all products.
- Retrieving a specific product by its identifier.
- Creating a new product.
- Updating an existing product (changing the name, description, price, quantity).
- Deleting a product.
- Ordering a product (adding a product to the order and reducing the quantity in stock).

## Requirements

- Java Spring for backend development.
- RESTful API for interaction between the backend and frontend.
- MySQL database for storing products.

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

- Java 8 or higher
- Maven
- MySQL

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/osozznanie/spring-rest-product-order.git
   ```
2. Navigate to the project directory
   ```sh
   cd Project-Name
   ```
3. Build the project
   ```sh
   mvn clean install
   ```
4. Run the project
   ```sh
   mvn spring-boot:run
   ```

## Usage

Once the server is running, you can use any HTTP client like curl or Postman to interact with the API.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)

