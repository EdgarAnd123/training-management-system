package com.myapp.springReact.integrations;

import com.myapp.app.SpringReactApplication;
import com.myapp.app.service.TrainingRequirementMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = SpringReactApplication.class)
@TestPropertySource(locations = "classpath:application-integration.properties")
@ContextConfiguration(locations = "classpath:spring-config.xml")
public abstract class BaseIntegrationTest {

}