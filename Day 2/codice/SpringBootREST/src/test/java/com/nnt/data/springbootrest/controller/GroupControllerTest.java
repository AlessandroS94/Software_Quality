package com.nnt.data.springbootrest.controller;


import com.nnt.data.springbootrest.model.Group;
import com.nnt.data.springbootrest.model.User;
import com.nnt.data.springbootrest.repository.GroupRepository;
import com.nnt.data.springbootrest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GroupControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private GroupRepository groupRepository;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private GroupController groupController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
    }

    @Test
    public void testGetGroups() throws Exception {
        Group group1 = new Group();
        group1.setId(1L);
        group1.setName("Group 1");

        Group group2 = new Group();
        group2.setId(2L);
        group2.setName("Group 2");

        when(groupRepository.findAll()).thenReturn(Arrays.asList(group1, group2));

        mockMvc.perform(MockMvcRequestBuilders.get("/groups"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUserToGroup() throws Exception {
        Group group = new Group();
        group.setId(1L);
        group.setName("Group 1");

        User user = new User();
        user.setId(1L);
        user.setName("User 1");

        when(groupRepository.findById(anyLong())).thenReturn(Optional.of(group));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        mockMvc.perform(MockMvcRequestBuilders.put("/groups/{groupId}/users/{userId}", 1L, 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateGroup() throws Exception {
        Group group = new Group();
        group.setId(1L);
        group.setName("Group 1");

        when(groupRepository.save(any(Group.class))).thenReturn(group);

        mockMvc.perform(MockMvcRequestBuilders.post("/groups")
                        .content("{\"name\":\"Group 1\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteGroup() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/groups/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}