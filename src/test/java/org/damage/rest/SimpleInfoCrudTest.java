package org.damage.rest;

import org.assertj.core.api.Assertions;
import org.damage.info.Info;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleInfoCrudTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addingAnExistingInfoShouldReturnConflict() throws Exception {
        ResponseEntity<Info> entity = restTemplate.postForEntity("/info", new Info("one", 1),
                                                                 Info.class);

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }
}
