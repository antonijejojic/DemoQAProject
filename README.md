# Selenium DemoQA Automation Project

## 📌 Project Description

This project is an automated testing framework for the **DemoQA** web application, built using **Selenium WebDriver** and **Java**.
The project follows the **Page Object Model (POM)** design pattern to ensure better code organization, readability, and maintainability.

---

## 🛠 Technologies & Tools

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**
* **Apache POI** (for reading data from Excel files)
* **IntelliJ IDEA**

---

## 🤖 Automation Testing Overview

This project focuses on:

- Writing beginner-friendly automated UI tests  
- Locating web elements using common Selenium strategies  
- Validating UI behavior and basic user interactions  
- Running tests using Maven  

---

## 🌐 Tested Application

* Website: [https://demoqa.com/](https://demoqa.com/)

---

## 📂 Project Structure

```
src
 └── test
     └── java
         ├── Base
         │   ├── BaseTest.java
         │   └── ExcelReader.java
         ├── Pages
         │   ├── BookStoreLoginPage.java
         │   ├── CheckBoxPage.java
         │   ├── HomePage.java
         │   ├── PracticeFormPage.java
         │   ├── RadioButtonPage.java
         │   ├── SideBar.java
         │   ├── TextBoxPage.java
         │   └── WebTablesPage.java
         └── Tests
             ├── BookStoreLoginTest.java
             ├── CheckBoxTest.java
             ├── PracticeFormTest.java
             ├── RadioButtonTest.java
             ├── TextBoxTest.java
             └── WebTablesTest.java
```

---

## 🧪 Test Scenarios

The following functionalities are covered by automated tests:

* **Text Box**
  * Entering and validating user input data
    
* **Check Box**
  * Selecting and validating checkbox options
    
* **Radio Button**
  * Verifying radio button selections
 
* **Web Tables**
  * Adding, editing, and deleting table records
    
* **Practice Form**
  * Filling out and submitting the form
    
* **Book Store Login**
  * User login using test data from an Excel file

---

## 📊 Test Data

* Test data is stored in an Excel file:

```
ProjectData.xlsx
```

* Data reading is implemented using the `ExcelReader` class.

---


## ▶️ How to Run the Tests

1. Open the project in **IntelliJ IDEA**
2. Make sure the following are installed:

   * Java
   * Maven
3. Run tests by:
   * Right-clicking on a test class → **Run**

---

## ✅ Author

* Name: *Antonije Jojic*
Junior QA Software Tester
---

📝 License
* This project was created for learning and practice purposes in Selenium test automation.

---


