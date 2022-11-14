# Spring-and-Tests

Step by step:
1. Click on the link: https://start.spring.io/
2. Create a project with: Java 19 - Maven, Spring Boot 2.7.5, Lombok, Spring Web, Spring Data, H2 Database, Contract Verifier;
3. Open the project in your favorite IDE.

Writing Integration tests for a JPARepository
1. Create a Class called: StudentRepositoryTest
2. Create a Class: Student
3. Create an Interface: StudentRepository
4. Create the tests
5. Put @
6. Run the tests

Notes 
- We could use @SpringBootTest, but in this case, we want to test only JPA, so we can use @DataJpaTest
- Using TestEntityManager: testEntityManager.persistAndFlush


Service Layer Testing
1. Create a Class called: StudentRepositoryTest