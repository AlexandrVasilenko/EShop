import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.repository.ProfileRepository;
import ru.alx.javaproject.eshop.service.ProfileService;
import ru.alx.javaproject.eshop.service.ProfileServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService = new ProfileServiceImpl();

    @Mock
    private ProfileRepository repository;;

    private List<Profile> list = new ArrayList<>();
    private int secondPlayerId = Math.abs("TestName2".hashCode() + "Vegan".hashCode() + 12 + 5);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        list.add(new Profile("TestName1","Vegetarian",1,32,3,true,true,false,"Female"));
        list.add(new Profile("TestName2","Vegan",1,12,5,true,false,true,"Male"));
        list.add(new Profile("TestName3","MeatEater",7,20,3,false,true,true,"Female"));

        when(repository.findAll()).thenReturn(list);
        when(repository.findById(secondPlayerId)).thenReturn(java.util.Optional.ofNullable(list.get(1)));
    }

    @Test
    public void testFindAll (){
        assertNotNull(profileService.findAll());
        assertEquals(3,profileService.findAll().size());
    }

    @Test
    public void testFindOneById(){
        assertEquals(list.get(1),profileService.findById(secondPlayerId));
    }

}
