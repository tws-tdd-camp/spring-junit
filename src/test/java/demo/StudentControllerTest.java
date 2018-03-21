package demo;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.revinate.assertj.json.JsonPathAssert;
import demo.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void should_return_name_when_get_name() throws Exception {
        List<Student> mockStudents = Arrays.asList(
                new Student("lili", 90)
        );

        Mockito.when(
                studentService.getAll()
        ).thenReturn(mockStudents);

        RequestBuilder builder = MockMvcRequestBuilders.get("/students");
        MvcResult result = mockMvc.perform(builder).andReturn();

        String resultJsonString = result.getResponse().getContentAsString();
        DocumentContext context = JsonPath.parse(resultJsonString);

        // 比起直接的字符串比较，可以忽略顺序
        JSONAssert.assertEquals("[{\"age\":90, \"name\":\"lili\"}]", resultJsonString, true);
    }

    @Test
    public void should_return_name_given_students() throws Exception {
        List<Student> mockStudents = Arrays.asList(
                new Student("lili", 90)
        );

        Mockito.when(
                studentService.getAll()
        ).thenReturn(mockStudents);

        RequestBuilder builder = MockMvcRequestBuilders.get("/students");
        MvcResult result = mockMvc.perform(builder).andReturn();

        String resultJsonString = result.getResponse().getContentAsString();
        DocumentContext context = JsonPath.parse(resultJsonString);

        // JSONPath 比较
        JsonPathAssert.assertThat(context).jsonPathAsString("$[0].age").isEqualTo("90");
    }
}