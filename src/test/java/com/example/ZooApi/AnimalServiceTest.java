package com.example.ZooApi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    AnimalRepository mockAnimalRepos;
    @InjectMocks
    AnimalService subject;

    @Test
    public void addAnimalToReposTest()
    {
        AnimalDto a1 = new AnimalDto("Dog","walking");
        subject.create(a1);
        verify(mockAnimalRepos).save(new AnimalEntity("Dog","walking"));
    }

}
