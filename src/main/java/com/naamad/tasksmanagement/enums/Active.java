package com.naamad.tasksmanagement.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Active {
    @JsonProperty("true")
    TRUE,
    @JsonProperty("false")
    FALSE
}
