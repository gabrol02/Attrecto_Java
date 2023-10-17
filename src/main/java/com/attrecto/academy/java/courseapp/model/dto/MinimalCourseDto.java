package com.attrecto.academy.java.courseapp.model.dto;



import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;

public class MinimalCourseDto {
	@NotBlank
	@Schema(description = "Id of the course", example = "1")
	private int id;
	@NotBlank
	@Schema(description = "Title of the course", example = "Spring boot")
	private String title;
	@NotBlank
	@Schema(description = "Description of the course", example = "Java fundamentals and Spring Boot")
	private String description;
	@NotBlank
	@Schema(description = "URL for the course", example = "https://attrecto.com/academy/course/java")	
	private String url;
	@NotBlank
	@Schema(description = "Start date for the course", example = "2023.04.01")
	private LocalDate startDate;
	@NotBlank
	@Schema(description = "End date for the course", example = "2024.04.01")
	private LocalDate endDate;


	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
