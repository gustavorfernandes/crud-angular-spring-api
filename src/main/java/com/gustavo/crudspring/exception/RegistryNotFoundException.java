package com.gustavo.crudspring.exception;

public class RegistryNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public RegistryNotFoundException(Long id) {
    super("Registro não encontrado com o id: " + id);
  }
}
