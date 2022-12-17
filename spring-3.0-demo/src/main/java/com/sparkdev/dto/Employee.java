package com.sparkdev.dto;

import java.util.List;

public record Employee(int id, String firstName, String lastName, float currentSalary, float expectedSalary,
                       List<String> skills) {
}
