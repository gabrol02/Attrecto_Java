package com.attrecto.academy.java.courseapp.model.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema
@ValidDateRange
public class CreateCourseDto {
	@Max(100)
	@Size(min=10,max=100)
	@NotBlank
	@Schema(description = "Title of the course", example = "Java course")
	private String title;
	@Max(1000)
	@NotBlank
	@Schema(description = "Description of the course", example = "Java fundamentals and Spring Boot")	
	private String description;
	@NotBlank
	@Schema(description = "URL for the course", example = "https://attrecto.com/academy/course/java")	
	private String url;
	@NotBlank
	@Schema(description = "Start date for the course", example = "2023.04.01")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	@NotBlank
	@Schema(description = "End date for the course", example = "2024.04.01")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	@NotNull
	@Schema(description = "Id of the of the course author", example = "1")	
	private Integer authorId;
	private Set<Integer> studentIds = new HashSet<>();
	
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
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Set<Integer> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(Set<Integer> studentIds) {
		this.studentIds = studentIds;
	}
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
}
