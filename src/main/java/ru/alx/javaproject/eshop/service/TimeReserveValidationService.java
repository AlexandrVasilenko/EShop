package ru.alx.javaproject.eshop.service;

import org.springframework.stereotype.Service;
import ru.alx.javaproject.eshop.entity.Profile;

import java.sql.SQLException;

@Service
public class TimeReserveValidationService {

    public int calculateTimeReserve (String gender, String nutritionType, int playerAge, int sleepingHours, int sportActivity, boolean smoking, boolean alcohol, boolean inLove){

        //TODO design time calculaton logic

        return 100;
    }

}
