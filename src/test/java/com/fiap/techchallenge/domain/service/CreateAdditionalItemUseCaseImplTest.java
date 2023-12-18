package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.domain.entity.AdditionalItem;
import com.fiap.techchallenge.domain.repository.AdditionalItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateAdditionalItemUseCaseImplTest {

    @Mock
    private AdditionalItemRepository repository;

    @InjectMocks
    private CreateAdditionalItemUseCaseImpl createAdditionalItemUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateAdditionalItemWhenValidAdditionalItemIsProvided() {
        // Given
        AdditionalItem additionalItem = AdditionalItem.builder().build();
        when(repository.createAdditionalItem(additionalItem)).thenReturn(additionalItem);

        // When
        AdditionalItem result = createAdditionalItemUseCase.createAdditionalItem(additionalItem);

        // Then
        assertEquals(additionalItem, result);
        verify(repository, times(1)).createAdditionalItem(additionalItem);
    }

    @Test
    void shouldNotCreateAdditionalItemWhenNullIsProvided() {
        // Given
        AdditionalItem additionalItem = null;
        when(repository.createAdditionalItem(additionalItem)).thenReturn(null);

        // When
        AdditionalItem result = createAdditionalItemUseCase.createAdditionalItem(additionalItem);

        // Then
        assertEquals(null, result);
        verify(repository, times(1)).createAdditionalItem(additionalItem);
    }
}