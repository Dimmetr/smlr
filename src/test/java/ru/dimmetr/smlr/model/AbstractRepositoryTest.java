package ru.dimmetr.smlr.model;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import ru.dimmetr.smlr.SmlrApplication;

@TestPropertySource(locations = "classpath:repositories-test.properties")
@TestExecutionListeners(DbUnitTestExecutionListener.class)
@SpringApplicationConfiguration(classes = SmlrApplication.class)
@DirtiesContext
public abstract class AbstractRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

}
