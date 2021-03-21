package com.valo.ba04;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
@Data
public class School {
    @Value("人民大学")
    private String name;
    @Value("海淀区")
    private String address;
}
