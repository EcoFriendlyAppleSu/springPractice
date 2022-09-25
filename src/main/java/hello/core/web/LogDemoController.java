package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // 의존관계 주입 생성자가 하나일 때
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody //화면 없이 메세지를 반환하고 싶을 때 사용
    public String logDemo(HttpServletRequest request) { // 고객 요청 정보 받아옴
        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString(); // get client input URL info
        myLogger.setRequestURL(requestURL);

        myLogger.log("Controller Test");
        logDemoService.logic("TestId");
        return "OK";
    }
}
