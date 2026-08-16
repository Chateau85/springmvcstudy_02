package hello.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringmvcApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void basicMappingReturnsOk() throws Exception {
		mockMvc.perform(get("/hello-basic"))
				.andExpect(status().isOk())
				.andExpect(content().string("ok"));
	}

	@Test
	void jsonRequestBodyIsEchoed() throws Exception {
		mockMvc.perform(post("/request-body-json-v5")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{"username":"hello","age":20}
								"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("hello"))
				.andExpect(jsonPath("$.age").value(20));
	}

	@Test
	void thymeleafViewIsRendered() throws Exception {
		mockMvc.perform(get("/response-view-v2"))
				.andExpect(status().isOk())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("hello!")));
	}

}
