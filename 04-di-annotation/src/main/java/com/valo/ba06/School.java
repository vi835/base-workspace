package com.valo.ba06;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool06")
@Data
public class School {
    @Value("南京大学")
    private String name;
    @Value("海淀区")
    private String address;
}
