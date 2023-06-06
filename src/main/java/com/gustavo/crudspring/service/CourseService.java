package com.gustavo.crudspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.gustavo.crudspring.model.Course;
import com.gustavo.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {
  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  public Optional<Course> findOneById(@PathVariable @NotNull @Positive Long id) {
    return courseRepository.findById(id);
  }

  public Course create(@Valid Course registry) {
    return courseRepository.save(registry);
  }

  public Optional<Course> update(@NotNull @Positive Long id, @Valid Course registry) {
    return courseRepository.findById(id)
        .map(foundedData -> {
          foundedData.setName(registry.getName());
          foundedData.setCategory(registry.getCategory());
          return courseRepository.save(foundedData);
        });
  }

  public boolean delete(@NotNull @Positive Long id) {
    return courseRepository.findById(id)
        .map(foundedData -> {
          return true;
        })
        .orElse(false);
  }
}
