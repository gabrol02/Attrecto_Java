package com.attrecto.academy.java.courseapp.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.CourseDto;
import com.attrecto.academy.java.courseapp.model.dto.CreateCourseDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;

@Service
public class CourseService {

	private MinimalUserDto firstUser;
	private MinimalUserDto secondUser;
	private CourseDto firstCourse;
	private CourseDto secondCourse;
	
	//TODO:Fiktív kurzusok és userek létrehozása
	public CourseService() {
		firstUser = new MinimalUserDto();
		firstUser.setId(1);
		firstUser.setName("firstUser");
		firstUser.setEmail("firstUser@attrecto.com");
		
		firstCourse = new CourseDto();
		firstCourse.setStudents(List.of(firstUser));

		secondUser = new MinimalUserDto();
		secondUser.setId(2);
		secondUser.setName("secondUser");
		secondUser.setEmail("secondUser@attrecto.com");
		
		secondCourse = new CourseDto();
		secondCourse.setStudents(List.of(secondUser));
	}

	//TODO: Teszt célból a valós kurzusok helyett egyenlőre két fiktív kurzust adunk vissza
	public List<CourseDto> listAllCourses() {
		return List.of(firstCourse, secondCourse);
	}

	//TODO: Teszt célból a valós kurzus helyett egyenlőre egy fiktív kurzust adunk vissza
	public CourseDto getCourseById(Integer id) {
		return firstCourse;
	}

	//TODO: Teszt célból a valós kurzus helyett egyenlőre egy fiktív kurzust "hozunk létre" és térünk vele vissza
	public CourseDto createCourse(CreateCourseDto createCourseDto) {
		CourseDto newCourseDto = new CourseDto();
		newCourseDto.setStudents(createCourseDto.getStudentIds().stream().map(id -> {
			MinimalUserDto minimalUserDto = new MinimalUserDto();
			minimalUserDto.setId(id);
			minimalUserDto.setName("user" + id);
			minimalUserDto.setEmail(String.format("user%semail@attrecto.com", id));
			return minimalUserDto;
		}).toList());

		return newCourseDto;
	}

	//TODO: Teszt célból a valós kurzus helyett egyenlőre egy fiktív kurzust módosítunk és térünk vele vissza
	public CourseDto updateCourse(Integer id, CreateCourseDto createCourseDto) {
		CourseDto updatedCourseDto = new CourseDto();
		updatedCourseDto.setStudents(List.of(firstUser, secondUser));
		return updatedCourseDto;
	}

	//TODO: Teszt célból a valós kurzus törlése helyett nem csinálunk egyenlőre semmit
	public void deleteCourse(Integer id) {
	}
}
