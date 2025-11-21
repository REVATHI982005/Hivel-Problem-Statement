# Hivel-Problem-Statement
Polynomial Roots – Polynomial Construction from Given Roots

This project reads a set of roots from a JSON file, converts them from different bases to decimal, and constructs a polynomial by multiplying terms of the form (x − r) sequentially.

It is part of the HiVEL Problem Statement assignment.

🚀 Features

Reads inputs from input.json

Supports roots represented in any base

Converts values to BigInteger

Builds polynomial coefficients step-by-step

Fully implemented using Object-Oriented Programming (OOP)

Works with very large numbers using Java BigInteger

📂 Project Structure
polynomial-assignment/
│
├── src/
│   └── PolynomialRoots.java
│
└── input.json

📥 Example Input (input.json)
{
    "keys": { "n": 3, "k": 3 },
    "1": { "value": "10", "base": "10" },
    "2": { "value": "A", "base": "16" },
    "3": { "value": "21", "base": "8" }
}

🧮 Output Example
Final coefficients:
-300
145
-22
1


These represent the polynomial:

P(x) = 1·x³ − 22·x² + 145·x − 300

▶️ How to Run the Program
1. Compile

Open terminal inside your project folder:

javac src/PolynomialRoots.java

2. Run
java -cp src PolynomialRoots

🛠️ Technologies Used

Java 8+

BigInteger

Manual JSON parsing (no external libraries)

📌 Future Enhancements

Add support for floating-point roots

Add unit tests

Add automatic polynomial simplification

Replace manual JSON parsing with Jackson/Gson
