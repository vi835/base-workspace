package com.valo.ba03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class School {
    @Value("北京大学")
    private String name;
    @Value("海淀区")
    private String address;
}
