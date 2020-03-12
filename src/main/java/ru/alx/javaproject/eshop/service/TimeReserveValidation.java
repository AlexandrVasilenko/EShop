package ru.alx.javaproject.eshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.alx.javaproject.eshop.utility.NutritionType;

@Component
public class TimeReserveValidation {

    private static final Logger logger = LoggerFactory.getLogger(TimeReserveValidation.class);

    public int calculateTimeReserve(String gender, String nutritionType, int playerAge, int sleepingHours, int sportActivity, boolean smoking, boolean alcohol, boolean inLove) {


        int result;
        int usefulHoursPerYear = 52 * 10;
        int lifetime = -1;
        double lifeFactor = 1;


       switch (NutritionType.valueOf(nutritionType.toUpperCase())){
           case MEATEATER:
               lifetime = 60;
               break;
           case VEGETARIAN:
               lifetime = 70;
               break;
           case VEGAN:
               lifetime = 80;
               break;
           case RAWVEGAN:
               lifetime = 90;
               break;
           default:
               logger.debug("Unexpected value: " + NutritionType.valueOf(nutritionType));
               return -1;
       }

       if(lifetime - playerAge <=0 || sleepingHours == 0){
           return -1;
       }
       result = lifetime - playerAge;
       if(smoking){
           lifeFactor = lifeFactor - 0.2;
       }
       if(alcohol){
           lifeFactor = lifeFactor - 0.2;
       }
       if(sportActivity >= 4){
           lifeFactor = lifeFactor + 0.2;
       }
       if(sleepingHours <= 5){
           lifeFactor = lifeFactor - 0.2;
       }
       if(gender.equals("Female")){
           lifeFactor = lifeFactor + 0.1;
       }
       if(inLove){
           lifeFactor = lifeFactor + 0.3;
       }
        return (int)Math.round(result * lifeFactor * usefulHoursPerYear);
    }

}
