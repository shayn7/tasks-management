package com.naamad.tasksmanagement.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("pending")
    PENDING,
    @JsonProperty("completed")
    COMPLETED,
    @JsonProperty("archived")
    ARCHIVED
}
