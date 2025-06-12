package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.in.web.MedicationRequestDto;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);

    Medication createMedication(MedicationRequestDto requestDto);
}
