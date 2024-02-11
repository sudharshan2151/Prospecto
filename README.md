# Prospecto


## Public-API

This project is a Java Spring Boot application that serves as a backend for interacting with [Public APIs](https://api.publicapis.org/). It provides various endpoints to fetch and manipulate API data.

## Features

- List APIs based on category.
- Save a new entry fetched from the Public APIs service.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Maven

## Getting Started

To get started with the project, follow the instructions below:

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Apache Maven installed to manage project dependencies.

## API Endpoints

The following endpoints are available:

- `GET /api/entries?category=<category>` - Retrieve APIs based on category.
- `POST /api/entrites` - Save a new entry from the Public APIs service.

# CSV Calculator

The `CSVCalculator` class is designed to read data from a CSV (Comma Separated Values) file, evaluate mathematical expressions within the file, and write the results to an output CSV file.

## Features

- Reads input data from an `input.csv` file.
- Evaluates mathematical expressions within the input data.
- Supports basic arithmetic operations: addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
- Writes the evaluated results to an `output.csv` file.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- Input CSV file (`input.csv`) with data and expressions to be evaluated.

## Usage

1. **Prepare Input CSV File**: Ensure that you have an `input.csv` file with data and expressions. Each line should contain comma-separated key-value pairs, where the value can be a number or a mathematical expression starting with an equals sign (`=`).
