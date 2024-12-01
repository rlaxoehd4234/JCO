package org.jco.communityservice.domain;

import org.jco.communityservice.controller.CommunityController;
import org.jco.communityservice.exception.CommunityNotFoundException;
import org.jco.communityservice.service.CommunityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = CommunityController.class)
class CommunityControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunityService service;
    @Autowired
    private CommunityService communityService;

    @Test
    void getCommunity() {
    }

    @Test
    void whenGetCommunityNotFound() throws Exception{
        long communityNumber = 10;
        given(communityService.findById(communityNumber))
                .willThrow(CommunityNotFoundException.class);
        mockMvc
                .perform(get("/community/find/"+communityNumber))
                .andExpect(status().isNotFound());
    }

    @Test
    void delete() throws Exception {
        long communityNumber = Long.MAX_VALUE;
        given(communityService.delete(communityNumber))
                .willThrow(CommunityNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.delete("/" + communityNumber))
                .andExpect(status().isNotFound());
    }

}