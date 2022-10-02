package com.bulbul.crud.employee.controller.impl;


import com.bulbul.crud.controller.impl.OrderControllerImpl;
import com.bulbul.crud.entity.Order;
import com.bulbul.crud.mapper.OrderMapper;
import com.bulbul.crud.service.OrderService;
import com.bulbul.crud.util.builder.OrderBuilder;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class OrderControllerImplTest {
    //TODO: create the data Test generator class OrderBuilder
    private static final String ENDPOINT_URL = "/api/order";

    @InjectMocks
    private OrderControllerImpl orderController;
    @Mock
    private OrderService orderService;
    @Mock
    private OrderMapper orderMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.orderController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(orderMapper.asDTOList(ArgumentMatchers.any())).thenReturn(OrderBuilder.getListDTO());

        Mockito.when(orderService.findAll()).thenReturn(OrderBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(orderMapper.asDTO(ArgumentMatchers.any())).thenReturn(OrderBuilder.getDTO());

        Mockito.when(orderService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(OrderBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(orderService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(orderService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(orderMapper.asEntity(ArgumentMatchers.any())).thenReturn(OrderBuilder.getEntity());
        Mockito.when(orderService.save(ArgumentMatchers.any(Order.class))).thenReturn(OrderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(OrderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(orderService, Mockito.times(1)).save(ArgumentMatchers.any(Order.class));
        Mockito.verifyNoMoreInteractions(orderService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(orderMapper.asEntity(ArgumentMatchers.any())).thenReturn(OrderBuilder.getEntity());
        Mockito.when(orderService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(OrderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(OrderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(orderService, Mockito.times(1)).update(ArgumentMatchers.any(Order.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(orderService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(orderService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(orderService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(orderService);
    }
}