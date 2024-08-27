package org.workwork.m_backend.work_4.work_1.HomeWork.src.main.java.org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScrapeResult {
    private String url;
    private String title;
    private String description;
}
