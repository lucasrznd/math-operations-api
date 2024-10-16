package com.lucasrznd.mathoperationsapi.controllers;

import com.lucasrznd.mathoperationsapi.dtos.ResultResponseDTO;
import com.lucasrznd.mathoperationsapi.services.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathService service;

    @Test
    public void getSum_WithValidNumbers_ReturnsOk() throws Exception {
        ResultResponseDTO result = new ResultResponseDTO(10D);
        when(service.sum(5D, 5D)).thenReturn(result);

        mockMvc.perform(get("/math/sum")
                        .param("firstNumber", String.valueOf(5D))
                        .param("secondNumber", String.valueOf(5D)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(10D));
    }

    @Test
    public void getSum_WithNullParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/math/sum"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSubtraction_WithValidNumbers_ReturnsOk() throws Exception {
        ResultResponseDTO result = new ResultResponseDTO(8D);
        when(service.subtract(10D, 2D)).thenReturn(result);

        mockMvc.perform(get("/math/subtract")
                        .param("firstNumber", String.valueOf(10D))
                        .param("secondNumber", String.valueOf(2D)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(8D));
    }

    @Test
    public void getSubtraction_WithNullParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/math/subtract"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getMultiplication_WithValidNumbers_ReturnsOk() throws Exception {
        ResultResponseDTO result = new ResultResponseDTO(25D);
        when(service.multiply(5D, 5D)).thenReturn(result);

        mockMvc.perform(get("/math/multiply")
                        .param("firstNumber", String.valueOf(5D))
                        .param("secondNumber", String.valueOf(5D)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(25D));
    }

    @Test
    public void getMultiplication_WithNullParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/math/multiply"))
                .andExpect(status().isBadRequest());
    }

}