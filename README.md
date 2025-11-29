# Software Dependability Project: School Management System

This project is a high-reliability Spring Boot Web Application designed to demonstrate formal verification, automated testing, and secure CI/CD pipelines.

**Author:** [Your Name]
**DockerHub Image:** `iabrar7/school-app`

## 📊 Project Status (Dependability Criteria)

| Criterion | Status | Tool Used |
| :--- | :--- | :--- |
| **CI/CD Build** | ✅ Passing | GitHub Actions |
| **Formal Verification** | ✅ Verified | OpenJML |
| **Mutation Testing** | ✅ 100% Score | PiTest |
| **Code Coverage** | ✅ >80% | Jacoco |
| **Security Rating** | ✅ Grade A | SonarCloud, Snyk, GitGuardian |
| **Performance** | ✅ Benchmarked | JMH |
| **Containerization** | ✅ Published | Docker |

---

## 🚀 How to Run the Application

### Option 1: Using Docker (Easiest)
The application is containerized and hosted on DockerHub. You can run it with a single command:

```bash
docker run -p 8080:8080 iabrar7/school-app:latest