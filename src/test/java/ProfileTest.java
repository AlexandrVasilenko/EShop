import org.junit.Before;
import org.junit.Test;
import ru.alx.javaproject.eshop.entity.Profile;

import static org.junit.Assert.*;

public class ProfileTest {

    private Profile profile;

    @Test
    public void createProfileInstance(){
        assertNotNull(profile = new Profile("TestName","Vegan",1,20,3,true,true,true,"Female"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProfileWithWrongNutritionType(){
        profile = new Profile("TestName","AllEater",1,20,3,true,true,true,"Female");
    }
}
