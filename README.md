# Event Management System

A Java-based application that lets users browse and register for events, while giving admins tools to manage event data end-to-end.

## Features

- User registration and login
- Browse events by date, venue, and description
- Registration confirmation for users
- Admin panel to add, update, and manage events
- Data persistence with MySQL via JDBC

## Tech Stack

- **Language:** Java
- **Database:** MySQL
- **Connectivity:** JDBC
- **UI:** Java GUI (Swing/AWT)

## How It Works

1. Users create an account and log in
2. They browse available events with details like date, venue, and description
3. Users register for an event and receive a confirmation
4. Admins log in separately to add new events or manage existing ones and view registrations

## Getting Started

### Prerequisites
- JDK 8+
- MySQL Server
- An IDE (Eclipse / IntelliJ / Spring Tool Suite)

### Setup
```bash
# Clone the repo
git clone https://github.com/Sivaranjani1502/event-management.git

# Import into your IDE as an existing Java project

# Create the database using the provided SQL script (schema.sql)
# Update DB credentials in the DB connection config file

# Run the main class to start the application
```

## Screenshots

*(Add 2-3 screenshots here — login screen, event listing, admin panel)*

## Future Improvements

- Migrate to Spring Boot + REST APIs for the backend
- Build an Angular front end to replace the Java GUI
- Add email notifications on registration

## Author

**Sivaranjani R**
[LinkedIn](https://www.linkedin.com/in/sivaranjani-r-15a568281) · [GitHub](https://github.com/Sivaranjani1502)
