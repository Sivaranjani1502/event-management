CREATE DATABASE IF NOT EXISTS eventdb;
USE eventdb;

-- Users table
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);

-- Events table
CREATE TABLE IF NOT EXISTS events (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  venue VARCHAR(255),
  start_at DATETIME,
  capacity INT
);

-- Registrations table
CREATE TABLE IF NOT EXISTS registrations (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  event_id INT,
  attended BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (event_id) REFERENCES events(id),
  UNIQUE KEY unique_reg (user_id, event_id)
);

-- Insert admin user manually (optional)
-- Password = admin123 (but hashed — you will insert after app runs)
INSERT INTO users(email, password, role)
VALUES ('admin@example.com', 'dummyhash', 'ROLE_ADMIN');

-- Insert some sample events
INSERT INTO events(title, description, venue, start_at, capacity) VALUES
('Tech Talk', 'Introduction to Cloud & AI', 'Auditorium A', '2026-03-12 14:00:00', 120),
('Spring Boot Workshop', 'Hands-on bootcamp', 'Lab 5', '2026-03-30 10:00:00', 60);
