import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.alx.javaproject.eshop.controller.ProfilePageController;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.ProfileService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfileServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ProfilePageController controller;

    @Mock
    private ProfileService service;

    private List<Profile> list = new ArrayList<>();
    private int playerSecond = Math.abs("TestName2".hashCode() + "Vegan".hashCode() + 12 + 5);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        list.add(new Profile("TestName1","Vegetarian",1,32,3,true,true,false,"Female"));
        list.add(new Profile("TestName2","Vegan",1,12,5,true,false,true,"Male"));
        list.add(new Profile("TestName3","MeatEater",7,20,3,false,true,true,"Female"));
    }

    @Test
    public void testFindAll (){
        when(service.findAll()).thenReturn(list);

        assertNotNull(service.findAll());
        assertEquals(3,service.findAll().size());
    }

    @Test
    public void testFindOneById(){
        when(service.findOneById(playerSecond)).thenReturn(list.get(1));
        assertEquals(list.get(1),service.findOneById(playerSecond));
    }

}
