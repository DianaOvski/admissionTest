package com.sprint3.admission_test.infrastructure.adapter.in.web;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 30, max = 255, message = "La descripción debe tener entre 30 y 255 caracteres")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener una precisión de 12 dígitos en total (10 enteros, 2 decimales)")
    private BigDecimal price;

    @NotNull(message = "La fecha de caducidad es obligatoria")
    @FutureOrPresent(message = "La fecha de caducidad no puede ser en el pasado")
    private LocalDate expirationDate;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre de la categoría debe tener entre 3 y 50 caracteres")
    private String categoryName;



    // --- Getters ---
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public String getCategoryName() { return categoryName; }

    // --- Setters ---
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}

