package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.in.web.MedicationRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;
    private ICategoryRepository categoryRepository;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    @Transactional
    public Medication createMedication(MedicationRequestDto requestDto) {
        Category category = categoryRepository.findByName(requestDto.getCategoryName())
                .orElseGet(() -> {
                    Category newCategory = Category.builder().name(requestDto.getCategoryName()).build();
                    return categoryRepository.save(newCategory); // Guarda la nueva categoría
                });

        Medication medication = Medication.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .expirationDate(requestDto.getExpirationDate())
                .category(category)
                .build();

        return medicationRepository.save(medication);
    }
}
