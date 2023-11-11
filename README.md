# TasKManager

This Java application serves as a training ground for improving my skills in this language. It is implemented with Java using Spring Boot for the backend, a PostgreSQL database for data storage, and Vue.js for the frontend.

## Functionality

The goal of this application is to implement the following features:

- **To-Do List**: Post a to-do list with a title, description, due date (optional), and status (to be done, in progress, completed, etc.).
- **Add Tasks**: Users can add new tasks to the to-do list with a title, description, and optionally a due date.
- **Update State**: Users can mark a task as complete or change its status with a checkbox or similar action.
- **Modify Tasks**: Users can edit the title, description, and due date of an existing task.
- **Remove Tasks**: Users can remove a task from the to-do list.
- **Search for a Task (optional)**: Users can search for a task with a keyword in the title or description.
- **Data Storage**: The to-do list is saved to maintain tasks between sessions.
- **User Accounts (optional)**: Implement a login and signup feature to allow users to save their to-do lists.

## Agile Project Management

The next step is to upgrade this application to function as an agile project manager.

## Prerequisites

Make sure you have installed the following elements:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (recommended version: 17)
- [Maven](https://maven.apache.org/download.cgi)
- [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [PostgreSQL](https://www.postgresql.org/download/): Initialize a PostgreSQL database to store your tasks and access it.

## Clone the Project

```bash
git clone https://github.com/mhammeDev/TasKManager.git
```

## Frontend Setup

```bash
cd FRONT/todo
```

```bash
npm install
```

### Compiles and Hot-Reloads for Development

```bash
npm run serve
```

### Compiles and Minifies for Production

```bash
npm run build
```

### Lints and Fixes Files

```bash
npm run lint
```

### Customize Configuration

See [Configuration Reference](https://cli.vuejs.org/config/).

## Backend Setup

### Link Your Database

```bash
cd BACK/to-do/src/main/ressources
```

Edit the `application.properties` file:
```properties
spring.datasource.url=your_database_link
spring.datasource.username=your_username
spring.datasource.password=your_password
```

```bash
cd BACK/to-do/
```

```bash
mvn clean install
```

## Run the Backend

```bash
mvn spring-boot:run
```

## Security Considerations

If your application deals with user accounts and login features, ensure you follow security best practices, especially when handling sensitive information.

## Contributing

If you want to contribute to this project, please follow the guidelines in [CONTRIBUTING.md](CONTRIBUTING.md).

## License

This project is licensed under the [Your License] - see the [LICENSE.md](LICENSE.md) file for details.

## Testing

To run tests, use the following command:

```bash
mvn test
```

Remember to update this README as your project evolves, and feel free to adjust the content based on your specific project details.
```

Note: Please replace `[Your License]` with the appropriate license information for your project. If you don't have a license yet, consider choosing one from [ChooseALicense.com](https://choosealicense.com/).
