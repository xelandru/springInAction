package chapter5.spittr.web;

import chapter5.spittr.data.Spitter;
import chapter5.spittr.data.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpitterControlerTest {

    @Test
    public void shouldShowRegistrationForm() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc
                .perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        SpitterRepository mockRepository = mock(SpitterRepository.class);

        Spitter unsaved = new Spitter("Bauer", "Jack", "jbauer", "24hours");
        Spitter saved = new Spitter("Bauer", "Jack", "jbauer", "24hours", 24L);

        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Bauer")
                .param("lastName", "Jack")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}