package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @GetMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        logRequestData(username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @GetMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        logRequestData(memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        logRequestData(username, age);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        logRequestData(username, age);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) {
        logRequestData(username, age);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username, @RequestParam(required = false, defaultValue = "-1") Integer age) {
        logRequestData(username, age);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        Object username = paramMap.get("username");
        log.debug("usernameLength={}, agePresent={}", username == null ? 0 : username.toString().length(), paramMap.containsKey("age"));
        return "ok";
    }

    @ResponseBody
    @GetMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        logRequestData(helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @GetMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        logRequestData(helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    private void logRequestData(String username, Object age) {
        log.debug("usernameLength={}, age={}", username == null ? 0 : username.length(), age);
    }
}
