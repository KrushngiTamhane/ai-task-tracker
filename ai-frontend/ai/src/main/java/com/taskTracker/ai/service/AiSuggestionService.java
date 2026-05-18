package com.taskTracker.ai.service;

import org.springframework.stereotype.Service;

@Service
public class AiSuggestionService {

    public String generateSuggestion(String title) {

        String lower = title.toLowerCase();

        // CREATE SCREEN
        if (lower.contains("screen") || lower.contains("page") || lower.contains("ui")) {

            return """
                    1. Analyze the business requirement and gather all required fields and validations.

                    2. Design responsive UI screen using proper layout, alignment and reusable components.

                    3. Create frontend implementation with proper navigation and user interaction handling.

                    4. Develop backend APIs and integrate frontend with backend services.

                    5. Implement database changes if required and validate data flow.

                    6. Add form validations, error handling and success messages.

                    7. Perform unit testing and integration testing for all functionalities.

                    8. Verify responsive design compatibility across different screen sizes.

                    9. Conduct end-to-end testing and fix identified issues.

                    10. Prepare deployment-ready changes and update documentation.
                    """;
        }

        // BUG FIX
        if (lower.contains("bug") || lower.contains("fix") || lower.contains("issue")) {

            return """
                    1. Analyze the reported issue and identify root cause.

                    2. Reproduce the issue in local or testing environment.

                    3. Debug affected modules and identify impacted functionality.

                    4. Implement required code fixes with proper validations.

                    5. Perform regression testing to ensure existing functionality is unaffected.

                    6. Validate fix in multiple scenarios and edge cases.

                    7. Update related documentation and deployment notes if required.
                    """;
        }

        // API TASK
        if (lower.contains("api") || lower.contains("service")) {

            return """
                    1. Analyze API requirements and expected request/response structure.

                    2. Design endpoint structure and validation logic.

                    3. Implement service layer and business logic.

                    4. Integrate database operations and exception handling.

                    5. Add Swagger documentation and request validation.

                    6. Perform API testing using Postman or Swagger.

                    7. Verify response performance and error scenarios.

                    8. Prepare deployment and update API documentation.
                    """;
        }

        // DATABASE TASK
        if (lower.contains("database") || lower.contains("table")) {

            return """
                    1. Analyze database change requirements and dependencies.

                    2. Design required table structure, relationships and constraints.

                    3. Create migration scripts and entity mappings.

                    4. Implement repository and service layer integration.

                    5. Validate CRUD operations and transaction handling.

                    6. Perform database testing for data integrity and performance.

                    7. Update technical documentation and deployment instructions.
                    """;
        }

        // DEFAULT TASK FLOW
        return """
                1. Analyze the requirement and understand business expectations.

                2. Design technical solution and identify impacted modules.

                3. Implement frontend/backend changes based on requirements.

                4. Add proper validations and exception handling.

                5. Perform unit testing and functional testing.

                6. Verify complete end-to-end functionality.

                7. Fix identified issues and optimize implementation.

                8. Prepare deployment-ready changes and update documentation.
                """;
    }
}