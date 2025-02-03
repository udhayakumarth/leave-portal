package dev.udhayakumar.leave_portal;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.udhayakumar.leave_portal.Leave.ApplyLeaveRequestDto;
import dev.udhayakumar.leave_portal.UserDetails.UserDetailsAuthRequestDto;
import dev.udhayakumar.leave_portal.UserDetails.UserDetailsRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class LeavePortalApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final UserDetailsRequestDto userDetailsRequestDto = new UserDetailsRequestDto("uk13","12345","Udhaya","Kumar");
	private final UserDetailsAuthRequestDto userDetailsAuthRequestDto = new UserDetailsAuthRequestDto("uk13","12345");
	private final ApplyLeaveRequestDto applyLeaveRequestDto = new ApplyLeaveRequestDto("15/01/2025","17/01/2025","Sick Leave","Something something","uk13");

	@Test
	public void testSaveUserSuccess() throws Exception{
		mockMvc.perform(post("/api/users")
						.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(userDetailsRequestDto)))
					.andExpect(MockMvcResultMatchers.status().isCreated())
					.andExpect(MockMvcResultMatchers.content().string("User Created Successfully"));
	}

	@Test
	public void testUserAuthSuccess() throws Exception{
		testSaveUserSuccess();
		mockMvc.perform(post("/api/users/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userDetailsAuthRequestDto)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testApplyLeaveSuccess() throws Exception{
		testSaveUserSuccess();
		mockMvc.perform(post("/api/leave")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(applyLeaveRequestDto)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
