package com.gustavo.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.crudspring.model.Course;
import com.gustavo.crudspring.service.CourseService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  public List<Course> findAll() {
    return courseService.findAll();
  }

  @GetMapping("/{id}")
  public Course findOneById(@PathVariable @NotNull @Positive Long id) {
    return courseService.findOneById(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Course create(@RequestBody @Valid Course registry) {
    return courseService.create(registry);
  }

  @PutMapping("/{id}")
  public Course update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course registry) {
    return courseService.update(id, registry);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable @NotNull @Positive Long id) {
    courseService.delete(id);
  }
}
