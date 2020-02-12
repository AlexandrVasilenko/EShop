import org.junit.Before;
import org.junit.Test;
import ru.alx.javaproject.eshop.entity.Profile;
import ru.alx.javaproject.eshop.service.TimeReserveValidation;
import static org.junit.Assert.*;

public class TimeReserveValidationTest {

    private Profile profileNormal;
    private Profile profileOld;
    private Profile profileFull;

    TimeReserveValidation timeReserveValidation = new TimeReserveValidation();

    @Before
    public void profilesCreation(){
        profileNormal = new Profile("TestName","Vegetarian",5,30,8,false,false,false,"Female");
        profileOld = new Profile("TestName","MeatEater",5,60,7,true,false,false,"Male");
        profileFull = new Profile("TestName","Vegan",1,20,3,true,true,true,"Female");

    }

    @Test
    public void calculateTimeReserveTest (){
        int timeNormal = timeReserveValidation.calculateTimeReserve(profileNormal.getGender(),profileNormal.getNutritionType(),profileNormal.getPlayerAge(),profileNormal.getSleepingHours(),profileNormal.getSportActivity(),profileNormal.isSmoking(),profileNormal.isAlcohol(),profileNormal.isInLove());
        int timeOld = timeReserveValidation.calculateTimeReserve(profileOld.getGender(),profileOld.getNutritionType(),profileOld.getPlayerAge(),profileOld.getSleepingHours(),profileOld.getSportActivity(),profileOld.isSmoking(),profileOld.isAlcohol(),profileOld.isInLove());
        int timeFull = timeReserveValidation.calculateTimeReserve(profileFull.getGender(),profileFull.getNutritionType(),profileFull.getPlayerAge(),profileFull.getSleepingHours(),profileFull.getSportActivity(),profileFull.isSmoking(),profileFull.isAlcohol(),profileFull.isInLove());

        assertEquals(27040, timeNormal);
        assertEquals(-1, timeOld);
        assertEquals(24960, timeFull);
    }

    @Test(expected=IllegalArgumentException.class)
    public void calculateTimeWithWrongNutritionType (){
       timeReserveValidation.calculateTimeReserve("Male","AllEater",30,4,4,true,true,true);
    }


}
