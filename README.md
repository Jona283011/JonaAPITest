# JonaAPITest Project

This project has been created to test the Gihub API. Below are the steps to set up and run the tests.

## Requirements

- **Java**: Ensure you have Java JDK 8 or higher installed.
- **Maven**: Maven is required to manage dependencies and run tests.


## Project Structure

- **src/main/java:**: Contains the main source code of the project.
- **src/test/java:**: Contains unit tests.
- **pom.xml:**: Maven configuration file that manages dependencies and the project lifecycle.
- **config.properties:**:Configuration file for storing sensitive information (e.g., access tokens).


## Install dependencies
This command will download the necessary dependencies and compile the project.:
```bash
mvn clean install
```
## Run tests
This command will run all the tests defined in the src/test/java directory.:
```bash
mvn test
```


### Notes
- **config.properties**: Added github token in config.properties to avoid uploading the token to the repository. Always handle sensitive information carefully and follow best practices for security.
- **AssertUtils**: The AssertUtils class has been created to cover the use case where a field is required and can be null. It has not been extended from AssertTrue because it is a static method.
- **Siganture is masked**: I have decided to mask the signature because it is a sensitive field..


