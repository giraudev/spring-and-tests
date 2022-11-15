# Spring-and-Tests

Tech:
1. Java 19 - Maven, Spring Boot 2.7.5, Lombok, Spring Web, Spring Data, H2 Database, Contract Verifier;
2. Open the project in your favorite IDE.

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
- Right Interactions - Test Slices - Embedded database - @TestContainers

Service Layer Testing
1. Create a Class called: StudentServiceTest
2. Create a Class called: StudentService
3. Paying attention in the annotations

Notes
- Separation of concern - Loose coupling - Orchestration - Caching

Integration Test for Cache
1. Create a Class called: StudentCacheTest
2. Use Mockito
3. @Cacheable
4. BDDMockito

Testing Controller