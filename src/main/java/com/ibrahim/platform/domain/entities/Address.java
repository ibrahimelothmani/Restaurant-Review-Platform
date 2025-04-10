package com.ibrahim.platform.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {

    @Field(type = FieldType.Keyword)
    private String streetNumber, unit, city, state, country, postalCode;

    @Field(type = FieldType.Text)
    private String streetName;

}
