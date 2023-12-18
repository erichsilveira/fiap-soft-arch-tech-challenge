package com.fiap.techchallenge.infrastructure.adapter;

import com.fiap.techchallenge.domain.entity.AdditionalItem;
import com.fiap.techchallenge.infrastructure.model.AdditionalItemModel;
import com.fiap.techchallenge.infrastructure.persistence.AdditionalItemJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdditionalItemPersistenceAdapterTest {

    @Mock
    private AdditionalItemJpaRepository springDataRepository;

    @InjectMocks
    private AdditionalItemPersistenceAdapter additionalItemPersistenceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateAdditionalItemWhenValidAdditionalItemIsProvided() {
        // Given
        AdditionalItem additionalItem = AdditionalItem.builder().id("1").name("Item").build();
        AdditionalItemModel model = AdditionalItemModel.toAdditionalItemModel(additionalItem);
        when(springDataRepository.save(any(AdditionalItemModel.class))).thenReturn(model);

        // When
        AdditionalItem result = additionalItemPersistenceAdapter.createAdditionalItem(additionalItem);

        // Then
        assertEquals(additionalItem, result);
        verify(springDataRepository, times(1)).save(any(AdditionalItemModel.class));
    }

    @Test
    void shouldReturnEmptyListWhenNoAdditionalItemsFound() {
        // Given
        when(springDataRepository.findAll(any(Example.class), any(Sort.class))).thenReturn(Collections.emptyList());

        // When
        List<AdditionalItem> result = additionalItemPersistenceAdapter.searchAdditionalItems("1");

        // Then
        assertEquals(0, result.size());
        verify(springDataRepository, times(1)).findAll(any(Example.class), any(Sort.class));
    }

    @Test
    void shouldReturnAdditionalItemsWhenFound() {
        // Given
        AdditionalItemModel model = new AdditionalItemModel();
        model.setId("1");
        model.setName("Item");
        when(springDataRepository.findAll(any(Example.class), any(Sort.class))).thenReturn(List.of(model));

        // When
        List<AdditionalItem> result = additionalItemPersistenceAdapter.searchAdditionalItems("1");

        // Then
        assertEquals(1, result.size());
        verify(springDataRepository, times(1)).findAll(any(Example.class), any(Sort.class));
    }
}