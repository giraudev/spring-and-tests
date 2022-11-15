
# Spring-and-Tests

Tech:
1. Java 19 - Maven, Spring Boot 2.7.5, Lombok, Spring Web, Spring Data, H2 Database, Contract Verifier;
2. Open the project in your favorite IDE.
3. Client: Java 19, Lombok, Spring Reactive Web, Contract Stub Runner

Tests:
Integration testing against a real db using @TestContainer
Service Layer Testing
Integration Testing against services with Caching support
Integration Testing against a Web Controller
Integration Testing for the Client App
Consumer driven contract testing

Notes 
- We could use @SpringBootTest, but in this case, we want to test only JPA, so we can use @DataJpaTest
- Using TestEntityManager: testEntityManager.persistAndFlush
- Right Interactions - Test Slices - Embedded database - @TestContainers
- Separation of concern - Loose coupling - Orchestration - Caching
- @Cacheable
- BDDMockito
- @WebMvcTest
- @MockBean
- MockMvc
