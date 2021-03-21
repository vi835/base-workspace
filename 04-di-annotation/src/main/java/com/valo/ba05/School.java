package com.valo.ba05;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool05")
@Data
public class School {
    @Value("人民大学")
    private String name;
    @Value("海淀区")
    private String address;
}
