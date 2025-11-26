🧪 Testing

This project includes JUnit 5 and Mockito based unit tests to validate core backend functionality.
The goal of the test suite is to ensure that the most important components of the system behave correctly without needing to spin up the entire application.

Only key layers of the system were tested, as required by the project guidelines:

✔ 1. Service Layer Test – EventServiceTest

This test verifies:

Fetching all events

Saving an event

Searching by keyword (title & venue)

Searching by date

Why it matters:
The service layer contains the project’s core business logic.
Testing it ensures event-related operations behave correctly.

✔ 2. Repository Test – EventRepositoryTest

A lightweight @DataJpaTest that checks:

Basic CRUD operations

Whether an event can be saved and retrieved

Why it matters:
This confirms that database integration (JPA + MySQL) works as expected.

✔ 3. Controller Test – EventControllerTest

A MockMVC test that ensures:

The /events endpoint loads successfully

Our controller wiring, routing, and MVC configuration work correctly

Why it matters:
This verifies user-facing endpoints without starting the full Spring Boot server.
