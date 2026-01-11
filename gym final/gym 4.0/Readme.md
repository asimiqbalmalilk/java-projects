# Gym Management System — Java GUI Based OOP Project

**Course:** CSC241 – Object Oriented Programming  
**Degree Program:** BS Artificial Intelligence  
**Institution:** COMSATS University Islamabad  
**Submission Type:** Semester Project  
**Technology Stack:** Java, Java Swing (GUI), Object Serialization  

---

## About the Project

This project was built with a simple idea in mind:

> *What if a gym could be managed as easily as opening an app?*

In most gyms, records are still maintained manually — using registers, spreadsheets, or scattered files. As the number of members grows, so does the complexity: tracking memberships, assigning trainers, calculating salaries, generating financial reports, managing diet plans, and monitoring fitness goals.

This quickly becomes inefficient, error-prone, and hard to scale.

The **Gym Management System** is a complete Java-based desktop application that replaces manual record keeping with a structured, automated, and user-friendly digital system. It provides a graphical interface for gym owners, trainers, and members, and handles all core operations in a centralized platform.

The goal of this project was not just to build a working application — but to design a system that reflects real-world business needs using proper software engineering principles.

---

## Problem We Identified

During analysis, we observed several real-world issues faced by gym owners:

- Member and trainer data stored in registers or Excel sheets  
- No centralized system for financial reporting  
- Manual salary calculations  
- No organized tracking of diet plans, workout goals, or membership duration  
- Data loss when files are misplaced or corrupted  

All of these problems point toward one solution:  
a **centralized digital management system**.

---

## Our Solution

We designed and developed a **GUI-based Java desktop application** that automates gym operations using Object-Oriented Programming concepts.

The system provides:

- A role-based login system (Manager, Trainer, Member)  
- Dedicated dashboards for each role  
- Automatic record management  
- Financial reporting  
- Persistent storage using file handling  

The entire system is built in a modular way so that new features can be added easily in the future.

---

## System Design & Architecture

The project follows a clean, layered architecture:

### GUI Layer  
Handles user interaction using Java Swing.

### Business Logic Layer  
Processes all core operations such as registrations, assignments, reports, and calculations.

### Data Layer  
Manages file storage using object serialization.

This separation ensures:
- Clean code  
- Easy maintenance  
- Better scalability  

---

## Object-Oriented Design Approach

The project is designed using real-world modeling.

### Core Design Concepts

- `Person` is an abstract base class  
- `Member` and `Employee` inherit from `Person`  
- `Trainer` inherits from `Employee`  
- `Payable` interface is used for salary and payment calculations  
- `GymManagementSystem` controls all business logic  
- `GymDataManager` handles data persistence  

This structure reflects how a real gym operates and allows the system to grow without breaking existing functionality.

---

## Main Features

### Manager Dashboard
- Add and delete members  
- Add and delete trainers  
- View member and trainer records  
- Generate monthly financial reports  
- Save system data  

### Member Dashboard
- Personal profile  
- Membership details  
- Fitness goals  
- Workout plan  
- Diet plan  

### Trainer Dashboard
- Trainer profile  
- Assigned members  
- Member progress  
- Salary information  

### Financial System
- Monthly revenue  
- Salary expenses  
- Maintenance costs  
- Net profit or loss  

---

## System Execution Flow

1. Application starts from the `RunnerGUI` class  
2. Previously saved data is loaded using `GymDataManager`  
3. Login screen appears with role-based access  
4. Dashboard opens based on selected role  
5. All user input is validated  
6. Core operations are handled by `GymManagementSystem`  
7. Data is saved using object serialization  

This ensures the system remembers everything even after restart.

---

## Validation & Reliability

The system includes proper validation to prevent:

- Empty input fields  
- Invalid data  
- Incorrect formats  

Error messages guide the user and prevent corrupted records. This makes the system reliable for daily gym operations.

---

## Project Contributors

- **Muhammad Asim Iqbal (SP25-BAI-039)**  
  File handling, serialization, validation & testing  

- **Muhammad Abdul Moiz (SP25-BAI-037)**  
  System design, class hierarchy & OOP implementation  

- **Abdul Rehman (SP25-BAI-002)**  
  GUI design & user interaction  

---

## How to Run the Project

1. Open the project in NetBeans or IntelliJ  
2. Build the project  
3. Run the `RunnerGUI` class  
4. Login using role-based access  
5. Start managing gym operations  

---

## Future Vision — Smart AI Gym Portal 🚀

This project is designed as a foundation for a much bigger idea.

In the future, this system can evolve into a **Smart AI Gym Portal** where:

- Users create intelligent fitness profiles  
- AI analyzes fitness goals, body type, lifestyle, and diet preferences  
- The system automatically assigns membership plans  
- Recommends suitable trainers  
- Generates personalized workout routines  
- Creates diet and nutrition plans  
- Tracks progress using AI insights  

Gym owners will be able to:

- Monitor all members in real-time  
- Track performance analytics  
- Predict churn  
- Optimize trainer workload  
- Increase retention and revenue  

This would transform a traditional gym into a **data-driven smart fitness ecosystem**.

---

## GitHub Automation (Optional CI Build)

This project can be connected with GitHub Actions for automatic build checking.
