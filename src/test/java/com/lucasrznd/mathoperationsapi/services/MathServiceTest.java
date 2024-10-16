package com.lucasrznd.mathoperationsapi.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathServiceTest {

    @Mock
    private MathService service;

    @Test
    public void getSum_WithValidNumbers_ReturnsResult() {
        when(service.sum(5D, 5D)).thenReturn(10D);

        Double result = service.sum(5D, 5D);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(10D);
    }

    @Test
    public void getSum_WithInvalidNumbers_ThrowsException() {
        when(service.sum(null, null)).thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> service.sum(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getSubtraction_WithValidNumbers_ReturnsResult() {
        when(service.subtract(10D, 2D)).thenReturn(8D);

        Double result = service.subtract(10D, 2D);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(8D);
    }

    @Test
    public void getSubtraction_WithInvalidNumbers_ThrowsException() {
        when(service.subtract(null, null)).thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> service.subtract(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getMultiply_WithValidNumbers_ReturnsResult() {
        when(service.multiply(5D, 4D)).thenReturn(20D);

        Double result = service.multiply(5D, 4D);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(20D);
    }

    @Test
    public void getMultiply_WithInvalidNumbers_ThrowsException() {
        when(service.multiply(null, null)).thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> service.multiply(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

}