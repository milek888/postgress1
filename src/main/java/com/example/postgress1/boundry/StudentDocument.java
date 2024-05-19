package com.example.postgress1.boundry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
record StudentDocument(@JsonProperty("id") int id,
                       @JsonProperty("name") String name,
                       @JsonProperty("second_name") String secondName,
                       @JsonProperty("age") int age) {
}
