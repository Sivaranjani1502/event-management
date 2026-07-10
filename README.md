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

<img width="2880" height="1704" alt="Screenshot 2025-11-26 190127" src="https://github.com/user-attachments/assets/2ff6321d-62b8-47ca-a43a-d21adac3b469" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221729" src="https://github.com/user-attachments/assets/3593f551-5b50-4eb2-b6f9-a5c1e70a0434" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221739" src="https://github.com/user-attachments/assets/d5fbb971-0fc5-4de6-b5c5-904d0d918235" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221756" src="https://github.com/user-attachments/assets/8313a232-4193-4926-8b05-39842c969b71" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221803" src="https://github.com/user-attachments/assets/406fcc61-a872-4652-bf0c-ab38545b922a" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221906" src="https://github.com/user-attachments/assets/9ccfa91b-b521-410b-9820-214b0944645c" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221932" src="https://github.com/user-attachments/assets/f106863c-c62f-4c04-bf29-4ef80b28b047" />
<img width="2880" height="1704" alt="Screenshot 2025-11-26 221946" src="https://github.com/user-attachments/assets/b243f070-cd08-4a41-a490-21a56da2aa4c" />


## Future Improvements

- Migrate to Spring Boot + REST APIs for the backend
- Build an Angular front end to replace the Java GUI
- Add email notifications on registration

## Author

**Sivaranjani R**
[LinkedIn](https://www.linkedin.com/in/sivaranjani-r-15a568281) · [GitHub](https://github.com/Sivaranjani1502)
