An offline-first Electronic Medical Record (EMR) system specifically designed for ophthalmology clinics[cite: 5]. This application ensures reliable patient data management, appointment scheduling, and clinical documentation even in environments with unstable or no internet connectivity[cite: 5].

## Key Features[cite: 5]
* Offline-first data synchronization and local storage[cite: 5].
* Comprehensive patient registration and medical history tracking[cite: 5].
* Specialized ophthalmology exam workflows and diagnostic logging[cite: 5].
* Secure role-based access control for clinic staff[cite: 5].
* Fast, lightweight interface optimized for daily clinical operations[cite: 5].

---

## 🛠️ Prerequisites & Environment Setup

For new developers (such as Lily) joining the project, ensure your local development machine is equipped with:

* **Operating System**: Windows 10 / 11
* **IDE**: Visual Studio Code (VS Code) with extensions:
  * Extension Pack for Java (Microsoft)
  * Spring Boot Extension Pack
  * Gradle for Java
* **Java Development Kit (JDK 25)**: Installed with your `JAVA_HOME` environment variable pointing to your JDK 25 directory.
* **Node.js & Angular CLI**: Required for frontend Angular development.
* **Git**: For version control.

---

## 📂 Project Technology Stack

* **Backend Framework**: Spring Boot 4.1.1
* **Build Tool**: Gradle 9.8.0 (managed via Gradle Wrapper)
* **Language**: Java 25
* **Database**: SQLite (local lightweight database)
* **Persistence / Data Mapping**: MyBatis
* **Frontend**: Angular (Planned integration)
* **Artifact Type**: Web Application Archive (`.war`)

---

## 🗄️ Database Configuration (SQLite)

Configure your local SQLite connection inside `src/main/resources/application.properties`:

```properties
# SQLite Datasource Configuration
spring.datasource.url=jdbc:sqlite:emr.db
spring.datasource.driver-class-name=org.sqlite.JDBC

# MyBatis Configuration
mybatis.mapper-locations=classpath:mapper/**/*.xml

🚀 Getting Started (Step-by-Step)
1. Clone the Repository and Switch Branch

Open your terminal (PowerShell or Git Bash), clone the repository, and switch to the active feature branch:

git clone <repository-url>
cd emr-system
git checkout feature/registration

2. Verify Your Java Environment

Verify that your terminal is using Java 25:

java -version

3. Build the Project

The project uses the Gradle wrapper (gradlew.bat). Run the clean build task to compile the application and generate the WAR file:

.\gradlew.bat clean build

Once built successfully, the deployment package is located at:
build/libs/emr-system-0.0.1-SNAPSHOT.war
4. Run the Application Locally

Run the packaged WAR file directly using Java:

java -jar build/libs/emr-system-0.0.1-SNAPSHOT.war

Open your web browser and navigate to: http://localhost:8080/

    To stop the running application, press Ctrl + C in your terminal window.

✅ Project To-Do List & Roadmap

    [x] Initialize project structure and Gradle build configuration for Java 25 & Spring Boot 4.1.1

    [x] Verify local WAR build and execution

    [ ] Configure SQLite database connection in application.properties

    [ ] Integrate MyBatis for database mapping and SQL queries

    [ ] Implement patient registration backend logic and controllers

    [ ] Set up Angular frontend project structure and UI components

    [ ] Connect Angular frontend with Spring Boot backend APIs

📝 Git Workflow & Committing Changes

    1) Check status of files:

    git status

    2) Stage all modifications and new files:

    git add .

    3) Commit with a clear descriptive message:
    
    git commit -m "Your descriptive commit message here"

    4) Push your changes to the remote branch:

    git push origin feature/registration


