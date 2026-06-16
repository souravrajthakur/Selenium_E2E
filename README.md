# 🚀 Saucedemo End-to-End Automation Framework

> Production-ready UI automation framework using **Selenide + TestNG + Maven**, integrated with **GitHub Actions (CI/CD)**, **Allure reporting**, and **automated HTML email notifications with charts**.

---

## 🔥 Why This Project Stands Out

* End-to-end user journey automation (Login → Cart → Checkout)
* CI/CD with **push**, **schedule (cron)**, and **manual** triggers
* **Allure** reports with detailed insights
* **HTML email reports** with dynamic pie chart 📊
* **Headless execution** for CI environments
* Scalable **Page Object Model (POM)** architecture

---

## 🧠 What This Demonstrates

* Framework design using POM
* CI/CD pipeline integration
* Reporting and monitoring
* Real-world automation workflow

---

## ⚙️ CI/CD Pipeline

### Triggers

* Push to `main`
* Daily scheduled execution
* Manual trigger

### Flow

```text
Push / Schedule / Manual
        ↓
GitHub Actions
        ↓
Build (Maven)
        ↓
Test Execution (Headless)
        ↓
Allure Report
        ↓
Summary Extraction
        ↓
Email Notification 📧
```

---

## 📸 Execution Proof

The following screenshots demonstrate the complete automation pipeline in action—from execution to reporting and notification.

### 🔹 CI Pipeline

<img width="1895" height="849" src="https://github.com/user-attachments/assets/8b98ba36-485b-4a93-8339-c264925357c3" />

> CI pipeline execution with test run, reporting, and email notification.

---

### 🔹 Allure Dashboard

<img width="1915" height="956" src="https://github.com/user-attachments/assets/8bd2375d-ca90-4459-9f78-e1f102efe164" />

> High-level summary of test execution results.

---

### 🔹 Allure Test Details

<img width="1088" height="947" src="https://github.com/user-attachments/assets/be2e511c-6342-40de-8d3c-5fe46eeca30d" />

> Detailed test steps for debugging and analysis.

---

### 🔹 Email Report

<img width="1061" height="893" src="https://private-user-images.githubusercontent.com/84566774/608827629-f2bf8c9f-b2c0-4e80-97b6-0b401091fcfe.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3ODE2NDEzNDUsIm5iZiI6MTc4MTY0MTA0NSwicGF0aCI6Ii84NDU2Njc3NC82MDg4Mjc2MjktZjJiZjhjOWYtYjJjMC00ZTgwLTk3YjYtMGI0MDEwOTFmY2ZlLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNjA2MTYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjYwNjE2VDIwMTcyNVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTkxMzI1MGEyYTQwODI0ZDE4YTljNWNhNDNmYzk2OTAxNjkxNWQxZDRlNTQ4ZmMyMzI2N2JhYTI3NjM4NGUzNzkmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JnJlc3BvbnNlLWNvbnRlbnQtdHlwZT1pbWFnZSUyRnBuZyJ9.UPl5UrOGgEUq2BzvImGLoueT_0L9WECPGPwTTsND7ms" />

> Automated email with execution summary and chart.

---

### 🔹 Project Structure

<img width="267" height="717" src="https://github.com/user-attachments/assets/26736dea-8fa8-4b84-b3c3-0f0895933f69" />

> Organized framework structure following POM.

---

## 🧪 Automated Test Scenarios Covered

### 🔹 Authentication & Login
- Verify successful login with valid credentials  
- Validate error message for invalid credentials  
- Validate locked-out user login restriction  
- Validate login with multiple user types (standard, locked, invalid, performance)  
- Validate performance user login behavior  

---

### 🔹 Inventory / Product Page
- Verify inventory page loads successfully after login  
- Add item to cart  
- Remove item from cart  
- Validate sorting functionality (Price: Low → High)  

---

### 🔹 Cart & Checkout Flow
- Add item to cart and proceed with flow  
- Remove item from cart  
- Complete end-to-end purchase flow  
- Validate successful order completion message  

---

## 📂 Project Structure

```text
pages        → Page Object classes  
tests        → Test scenarios  
base         → Test setup  
utils        → Utility classes  
dataproviders→ Test data handling  
```

---

## 📊 Reporting

### 🔹 Allure

* Execution dashboard
* Step-level insights
* Failure diagnostics

### 🔹 Email

* Test summary
* Pass/Fail metrics
* Chart visualization

---

## 📅 Scheduled Execution

Runs daily at **6:30 PM IST**

---

## 🛠️ Tech Stack

| Layer        | Tool           |
| ------------ | -------------- |
| Language     | Java           |
| Automation   | Selenide       |
| Framework    | TestNG         |
| Build        | Maven          |
| CI/CD        | GitHub Actions |
| Reporting    | Allure         |
| Notification | SMTP           |

---

## ▶️ Run Locally

```bash
git clone https://github.com/souravrajthakur/Selenium_E2E.git
cd Saucedemo-End-to-End-Automation-framework
mvn clean test
```

Generate report:

```bash
mvn io.qameta.allure:allure-maven:serve
```

---

## 🔐 GitHub Secrets

* EMAIL_USERNAME
* EMAIL_PASSWORD
* EMAIL_TO

---

## 👨‍💻 Author

**Sourav Raj**

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="18"/> <a href="https://github.com/Souravrajthakur">GitHub</a> &nbsp; | &nbsp;
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/linkedin/linkedin-original.svg" width="18"/> <a href="https://www.linkedin.com/in/souravrajthakur/">LinkedIn</a>

---

## ⭐ Final Note

Built to simulate a real-world automation pipeline with CI/CD, reporting, and automated notifications.
