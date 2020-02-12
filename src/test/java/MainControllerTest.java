import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.alx.javaproject.eshop.controller.MainPageController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private MainPageController mainPageController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainPageController).build();
    }

    @Test
    public void mainPageControllerTest () throws Exception {
        mockMvc.perform(get("/Welcome"))
                .andExpect(status().isOk())
                .andExpect(view().name("MainPage"));
    }
}
