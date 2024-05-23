package com.example.postgress1;

import com.example.postgress1.infrastructure.JpaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


/* TO DZIALA
https://stackoverflow.com/questions/43705720/how-do-i-import-configuration-classes-in-a-datajpatest-in-a-springboottest
https://stackoverflow.com/questions/48341097/import-vs-contextconfiguration-in-spring
@DataJpaTest
@ComponentScan(basePackages = "com.example.postgress1")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
*/

/*
TO TEZ DZIALA JAK SIE DA W DataBaseConfiguration2 @ComponentScan(basePackages = "com.example.postgress1")
@DataJpaTest
@ContextConfiguration(classes = DataBaseConfiguration2.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
*/


@Slf4j
@DataJpaTest
@Import(JpaConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.flyway.clean-disabled=false") // 1) @TestPropertySource pozwala na nadpisanie dowolnych propertiesow. 2) musimy dac na false bo flyway domyslnie ustawia to na true zeby sie zabepieczyc przed wymazaniem produkcji
@ActiveProfiles("test")
public class PostgreSqlRepositorylTest extends PostgresTestContainer {

    @Autowired
    Flyway flyway;

    public void restoreDatabase() { // ogolnie to niepotrzebne bo @DataJpaTest robi kazdy test @transactional i rollback
        flyway.clean();
        flyway.migrate();

    }

}
/*!!!   https://engineering.zalando.com/posts/2023/11/mastering-testing-efficiency-in-spring-boot-optimization-strategies-and-best-practices.html
        * https://www.javacodegeeks.com/2019/02/difference-spring-boot-integration-test.html
        * https://reflectoring.io/spring-boot-data-jpa-test/
        * https://howtodoinjava.com/spring-boot2/testing/datajpatest-annotation/
        * */