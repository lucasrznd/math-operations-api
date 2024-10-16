package com.lucasrznd.mathoperationsapi.services;

import com.lucasrznd.mathoperationsapi.dtos.ResultResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class MathServiceTest {

    @Autowired
    private MathService service;

    @Test
    public void getSum_WithValidNumbers_ReturnsResult() {
        ResultResponseDTO result = service.sum(5D, 5D);

        assertThat(result).isNotNull();
        assertThat(result.value()).isEqualTo(10D);
    }

    @Test
    public void getSum_WithInvalidNumbers_ThrowsException() {
        assertThatThrownBy(() -> service.sum(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getSubtraction_WithValidNumbers_ReturnsResult() {
        ResultResponseDTO result = service.subtract(10D, 2D);

        assertThat(result).isNotNull();
        assertThat(result.value()).isEqualTo(8D);
    }

    @Test
    public void getSubtraction_WithInvalidNumbers_ThrowsException() {
        assertThatThrownBy(() -> service.subtract(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getMultiplication_WithValidNumbers_ReturnsResult() {
        ResultResponseDTO result = service.multiply(5D, 4D);

        assertThat(result).isNotNull();
        assertThat(result.value()).isEqualTo(20D);
    }

    @Test
    public void getMultiplication_WithInvalidNumbers_ThrowsException() {
        assertThatThrownBy(() -> service.multiply(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

}