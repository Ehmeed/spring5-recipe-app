package com.ehmeed.repositories;

import com.ehmeed.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTestIT {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findByDescription() throws Exception {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");

        assertEquals("Mexican", categoryOptional.get().getDescription());

    }
}