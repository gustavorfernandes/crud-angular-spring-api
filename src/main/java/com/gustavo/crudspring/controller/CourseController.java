package com.gustavo.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.crudspring.model.Course;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

  @GetMapping
  public List<Course> list() {
    return null;
  }
}
