package com.joons.jwt.api;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.jayway.jsonpath.internal.function.ParamType.JSON;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    AuthController authController;

    @Before
    public void init() throws Exception {
        mock = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    public void requestTest() throws Exception {
        mock.perform(get("/auth/request"))
                .andDo(print());
    }
}
